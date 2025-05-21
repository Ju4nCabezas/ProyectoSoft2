package com.example;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.scrumapp.utils.DatabaseConnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class EstudiantesController implements Initializable {

    @FXML
    private  ListView<String> lvestudiantes;

    @FXML
    private final String[] ESTUDIANTES_ITEMS = {"Juan", "Ale",};

    @FXML
    private final ObservableList<String> ESTUDIANTES_LIST = FXCollections.observableArrayList(ESTUDIANTES_ITEMS);

    

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

     public void mostrarUsuarios() {
        String query = "SELECT * FROM usuarios";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            ResultSetMetaData metaData = rs.getMetaData();
            int columnas = metaData.getColumnCount();

            System.out.println("Contenido de la tabla usuarios:");
            while (rs.next()) {
                for (int i = 1; i <= columnas; i++) {
                    String nombreColumna = metaData.getColumnName(i);
                    String valor = rs.getString(i);
                    System.out.print(nombreColumna + ": " + valor + " | ");
                }
                System.out.println(); // Salto de línea entre filas
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String obtenerIdPorNombreCompleto(String nombreCompleto) {
        String query = "SELECT id FROM usuarios WHERE nombre_completo = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nombreCompleto);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
   
    

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        

        lvestudiantes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        lvestudiantes.setItems(ESTUDIANTES_LIST);;
    }

    


}
