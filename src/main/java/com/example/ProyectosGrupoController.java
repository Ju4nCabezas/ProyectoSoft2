package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class ProyectosGrupoController implements Initializable{

    @FXML private ListView<String> lvestudiantes;
    @FXML private Button generar;
    @FXML private TextArea lvinfo;

    private List<Proyectos> proyectos; // Lista completa
    private final ProyectosGrupoService service = new ProyectosGrupoService();

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void generar() {
        int selectedIndex = lvestudiantes.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Proyectos seleccionado = proyectos.get(selectedIndex);
            lvinfo.setText("ID: " + seleccionado.getId() + "\n" +
                        "Nombre: " + seleccionado.getNombre() + "\n" +
                        "Descripción: " + seleccionado.getDescripcion() + "\n" +
                        "Creado por: " + seleccionado.getCreado_por());
        } else {
            lvinfo.setText("Selecciona un proyecto.");
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        proyectos = service.list();
        System.out.println("Proyectos cargados: " + proyectos.size());
        for (Proyectos p : proyectos) {
            System.out.println("Proyecto: " + p.getNombre());
            lvestudiantes.getItems().add(p.getNombre()); 
        }
    }

    
}

