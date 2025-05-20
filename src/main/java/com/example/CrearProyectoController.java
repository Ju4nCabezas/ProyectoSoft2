package com.example;

import java.util.UUID;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class CrearProyectoController {
    @FXML private TextField nombreField;
    @FXML private TextField descripcionField;
    @FXML private TextField creadoPorField;

private final ProyectosGrupoService service = new ProyectosGrupoService(); // Servicio que guarda en BD

@FXML
private void crearProyecto() {
    String nombre = nombreField.getText();
    String descripcion = descripcionField.getText();
    String creadoPor = creadoPorField.getText();

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

}

