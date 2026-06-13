package com.ezequiel.biblioteca.controller;

import com.ezequiel.biblioteca.service.TelasService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ContinueController {

    @FXML
    private Label alertLogin;

    @FXML
    private AnchorPane bgContinue;

    @FXML
    private Button btLoginEmail;

    @FXML
    private Button btLoginGoogle;

    @FXML
    private Label idCreateAccount;

    @FXML
    private Label idNoAccount;

    @FXML
    private Label loginTitle;

    @FXML
    void LoginWithEmail(ActionEvent event) {
        TelasService.mudarTela("continueEmail");
    }

    @FXML
    void createAccount(MouseEvent event) {
        TelasService.mudarTela("createAccount");
    }

    @FXML
    void loginWithGoogle(ActionEvent event) {

    }

}
