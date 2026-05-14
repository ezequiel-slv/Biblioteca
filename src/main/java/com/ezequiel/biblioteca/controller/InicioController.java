package com.ezequiel.biblioteca.controller;

import com.ezequiel.biblioteca.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;

public class InicioController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private Button bt_cadastrar;

    @FXML
    private Button bt_entrar;

    @FXML
    protected void entrar(ActionEvent event){
        Main.mudarTela("entrar");
    }

    @FXML
    protected void cadastrar(ActionEvent event){
        Main.mudarTela("cadastrar");
    }
}
