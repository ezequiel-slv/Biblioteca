module com.ezequiel.biblioteca {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens com.ezequiel.biblioteca to javafx.fxml;
    opens com.ezequiel.biblioteca.controller to javafx.fxml;
    opens com.ezequiel.biblioteca.model to java.base;
    exports com.ezequiel.biblioteca to javafx.graphics;
}