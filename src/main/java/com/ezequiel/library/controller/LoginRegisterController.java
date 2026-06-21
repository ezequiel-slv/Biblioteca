package com.ezequiel.library.controller;

import com.ezequiel.library.service.ScreenService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class LoginRegisterController {

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
        ScreenService.mudarTela("continueEmail");
    }

    @FXML
    void createAccount(MouseEvent event) {
        ScreenService.mudarTela("createAccount");
    }

    @FXML
    void loginWithGoogle(ActionEvent event) {

    }

}
