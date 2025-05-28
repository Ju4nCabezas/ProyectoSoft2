package com.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.example.AuthController;

public class PrimaryController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;

    private AuthController authController = new AuthController();

    @FXML
    public void handleLogin() {
         String username = usernameField.getText();
    String password = passwordField.getText();

    com.scrumapp.models.User user = authController.login(username, password);

    if (user != null) {
        // 🔐 Guardar el usuario en sesión
        Session.setCurrentUser(user);

        try {
            if (user.getRole().equals("profesor")) {
                App.setRoot("tareas");

                CuestionarioController controller = App.getController();
                controller.inicializarParaUsuario(user); // opcional si ya usas Session

            } else {
                App.setRoot("secondary");
            }
        } catch (IOException e) {
            e.printStackTrace();
            errorLabel.setText("Error al cambiar de vista");
        }
    } else {
        errorLabel.setText("Credenciales incorrectas");
    }
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    
}
