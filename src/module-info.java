module ScrumApp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    
    opens com.scrumapp to javafx.fxml;
    exports com.scrumapp;
}
