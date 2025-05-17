package com.scrumapp;

import java.sql.Connection;

import com.scrumapp.utils.DatabaseConnection;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        Label label = new Label("¡Bienvenido a ScrumApp!");
        Scene scene = new Scene(label, 400, 300);
        stage.setScene(scene);
        stage.setTitle("ScrumApp");
        stage.show();
    }

    public static void main(String[] args) {
        Connection conn = DatabaseConnection.getConnection();
        if (conn != null) {
            System.out.println("🎉 Conexión establecida correctamente.");
        }
        launch();
    }
}

