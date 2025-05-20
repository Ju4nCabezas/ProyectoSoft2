package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        lvestudiantes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        lvestudiantes.setItems(ESTUDIANTES_LIST);;
    }

    


}
