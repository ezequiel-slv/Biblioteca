module com.ezequiel.library {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens com.ezequiel.library to javafx.fxml;
    opens com.ezequiel.library.controller to javafx.fxml;
    opens com.ezequiel.library.model to java.base;
    exports com.ezequiel.library to javafx.graphics;
}