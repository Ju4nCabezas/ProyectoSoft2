package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import com.scrumapp.models.Proyectos;
import com.scrumapp.models.Epicas;
import com.scrumapp.services.ProyectosService;
import com.scrumapp.services.EpicService;

public class EpicController implements Initializable {

    @FXML private ComboBox<com.scrumapp.models.Proyectos> proyectoComboBox;
    @FXML private ListView<String> epicasListView;
    @FXML private TextField descripcionField;
    @FXML private Button agregarButton;

    private final ProyectosService proyectoService = new ProyectosService();
    private final EpicService epicService = new EpicService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cargarProyectos();
        proyectoComboBox.setOnAction(e -> actualizarEpicas());
    }

    private void cargarProyectos() {
        proyectoComboBox.setItems(FXCollections.observableArrayList(proyectoService.list()));

    }

    private void actualizarEpicas() {
        Proyectos seleccionado = proyectoComboBox.getValue();
        if (seleccionado != null) {
            var epicas = epicService.list().stream()
                    .filter(e -> e.getProyecto_id().equals(seleccionado.getId()))
                    .map(Epicas::getDescripcion)
                    .collect(Collectors.toList());

            epicasListView.setItems(FXCollections.observableArrayList(epicas));
        }
    }

    @FXML
    private void agregarEpica() {
        Proyectos seleccionado = proyectoComboBox.getValue();
        String descripcion = descripcionField.getText();

        if (seleccionado == null || descripcion.isEmpty()) {
            System.out.println("Selecciona un proyecto y escribe una descripción.");
            return;
        }

        Epicas nueva = new Epicas();
        nueva.setId(UUID.randomUUID().toString());
        nueva.setProyecto_id(seleccionado.getId());
        nueva.setDescripcion(descripcion);
        nueva.setNombre(descripcion);

        if (epicService.create(nueva)) {
            System.out.println("Épica creada correctamente.");
            descripcionField.clear();
            actualizarEpicas();
        } else {
            System.out.println("Error al crear la épica.");
        }
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }


}

