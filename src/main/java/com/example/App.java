package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 1300, 700);
        scene.getStylesheets().add(App.class.getResource("primary.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        
        try (Connection conn = DatabaseConnection.getConnection()) {
        if (conn != null) {
            System.out.println("✅ Conexión a PostgreSQL establecida correctamente.");
        } else {
            System.out.println("❌ Falló la conexión a PostgreSQL.");
        }
    } catch (Exception e) {
        System.out.println("❌ Error de conexión: " + e.getMessage());
    }

        launch();
    }

}