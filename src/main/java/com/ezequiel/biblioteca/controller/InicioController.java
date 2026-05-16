package com.ezequiel.biblioteca.controller;

import com.ezequiel.biblioteca.service.TelasService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class InicioController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void cadastrar(ActionEvent event) {
        TelasService.mudarTela("cadastrar");
    }

    @FXML
    void entrar(ActionEvent event) {
        TelasService.mudarTela("entrar");
    }

}
