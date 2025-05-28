package com.example;

import com.scrumapp.utils.Session;
import com.scrumapp.models.User;
import com.scrumapp.utils.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FormularioController {

    @FXML
    private ComboBox<String> epicasComboBox;

    @FXML
    private ComboBox<String> featuresComboBox;

    @FXML
    private Label preguntaLabel;

    @FXML
    private TextField respuestaField;

    @FXML
    private Button guardarButton;

    private int proyectoId;

    @FXML
    public void initialize() {
        User currentUser = Session.getCurrentUser();
        if (currentUser != null) {
            proyectoId = obtenerProyectoIdPorUsuario(currentUser.getId());
            if (proyectoId != -1) {
                cargarEpicas(proyectoId);
                cargarFeatures(proyectoId);
                configurarEventos();
            } else {
                mostrarError("No se encontró un proyecto para este usuario.");
            }
        } else {
            mostrarError("No hay un usuario logueado.");
        }
    }

    private int obtenerProyectoIdPorUsuario(String userId) {
        String sql = "SELECT id FROM proyectos WHERE creado_por = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    

    private void cargarEpicas(int proyectoId) {
        List<String> epicas = new ArrayList<>();
        String sql = "SELECT nombre FROM epicas WHERE proyecto_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, proyectoId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                epicas.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        epicasComboBox.setItems(FXCollections.observableArrayList(epicas));
    }

    private void cargarFeatures(int proyectoId) {
        List<String> features = new ArrayList<>();
        String sql = "SELECT nombre FROM features WHERE proyecto_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, proyectoId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                features.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        featuresComboBox.setItems(FXCollections.observableArrayList(features));
    }

    private void configurarEventos() {
        featuresComboBox.setOnAction(event -> {
            String feature = featuresComboBox.getSelectionModel().getSelectedItem();
            if (feature != null) {
                preguntaLabel.setText("¿Cómo implementarías la feature: " + feature + "?");
            }
        });

        guardarButton.setOnAction(event -> guardarRespuesta());
    }

    private void guardarRespuesta() {
        String epica = epicasComboBox.getSelectionModel().getSelectedItem();
        String feature = featuresComboBox.getSelectionModel().getSelectedItem();
        String respuesta = respuestaField.getText();

        if (epica != null && feature != null && !respuesta.isBlank()) {
            try (FileWriter writer = new FileWriter("respuestas.txt", true)) {
                writer.write("Epica: " + epica + ", Feature: " + feature + ", Respuesta: " + respuesta + "\n");
                mostrarInfo("Respuesta guardada exitosamente.");
                respuestaField.clear();
            } catch (IOException e) {
                mostrarError("Error al guardar la respuesta.");
                e.printStackTrace();
            }
        } else {
            mostrarError("Completa todos los campos antes de guardar.");
        }
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void mostrarInfo(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
