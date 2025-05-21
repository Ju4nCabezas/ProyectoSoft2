package com.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void switchToEstudiantes() throws IOException {
        App.setRoot("estudiantes");
    }

    @FXML
    private void switchToProyectos() throws IOException {
        App.setRoot("proyectos");
    }

    @FXML
    private void switchToCrear() throws IOException {
        App.setRoot("crear");
    }
}