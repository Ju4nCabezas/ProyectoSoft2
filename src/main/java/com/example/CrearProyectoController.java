package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class CrearProyectoController {
    @FXML private TextField nombreField;
    @FXML private TextField descripcionField;
    @FXML private TextField creadoPorField;
    @FXML private ComboBox<User> usuarioComboBox;


private final ProyectosGrupoService service = new ProyectosGrupoService(); // Servicio que guarda en BD

@FXML
private void crearProyecto() {
    User seleccionado = usuarioComboBox.getValue();

    if (seleccionado == null) {
        System.out.println("Debes seleccionar un usuario.");
        return;
    }
    String nombre = nombreField.getText();
    String descripcion = descripcionField.getText();
    String creadoPor = seleccionado.getId();

    if (nombre.isEmpty() || descripcion.isEmpty() || creadoPor.isEmpty()) {
        System.out.println("Todos los campos son obligatorios");
        return;
    }

    Proyectos proyecto = new Proyectos();
    proyecto.setId(UUID.randomUUID().toString()); // O algún generador de ID
    proyecto.setNombre(nombre);
    proyecto.setDescripcion(descripcion);
    proyecto.setCreado_por(creadoPor);

    boolean resultado = service.create(proyecto);
    if (resultado) {
        System.out.println("Proyecto creado exitosamente.");
        limpiarCampos();
    } else {
        System.out.println("Error al crear el proyecto.");
    }
}

    private void limpiarCampos() {
        nombreField.clear();
        descripcionField.clear();
        creadoPorField.clear();
    }

    @FXML
    public void initialize() {
        cargarUsuarios();
    }

     private void cargarUsuarios() {
        String query = "SELECT id, nombre_completo FROM usuarios";
        try (Connection conn = com.scrumapp.utils.DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                User usuario = new User();
                usuario.setId(rs.getString("id"));
                usuario.setName(rs.getString("nombre_completo"));
                usuarioComboBox.getItems().add(usuario);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void switchToEpicas() throws IOException {
        App.setRoot("epicas");
    }

}

