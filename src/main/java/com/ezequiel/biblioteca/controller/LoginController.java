package com.ezequiel.biblioteca.controller;

import com.ezequiel.biblioteca.model.Estudante;
import com.ezequiel.biblioteca.service.LoginService;
import com.ezequiel.biblioteca.service.TelasService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField tf_senha;

    @FXML
    private TextField tf_email;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public boolean validar(){
        StringBuilder aviso = new StringBuilder();

        if (tf_email.getText().isBlank()){
            aviso.append("Campo Email é obrigatório!\n");
        }

        if (tf_senha.getText().isBlank()){
            aviso.append("Campo Senha é obrigatório!\n");
        }

        if (!aviso.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Erro");
            alert.setContentText(aviso.toString());
            alert.show();

            return false;
        }else{
            return true;
        }
    }

    @FXML
    void entrar(ActionEvent event){
            if (validar()){

                }
            }

    @FXML
    protected void voltar(ActionEvent event){
        TelasService.mudarTela("voltarLogin");
        }
    }


