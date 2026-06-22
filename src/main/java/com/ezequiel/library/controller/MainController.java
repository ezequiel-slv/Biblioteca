package com.ezequiel.library.controller;

import com.ezequiel.library.service.ScreenService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void enter(ActionEvent event) {
        ScreenService.mudarTela("entrar");
    }

}
