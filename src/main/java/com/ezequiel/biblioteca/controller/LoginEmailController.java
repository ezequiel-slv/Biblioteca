package com.ezequiel.biblioteca.controller;

import com.ezequiel.biblioteca.model.Estudante;
import com.ezequiel.biblioteca.service.LoginService;
import com.ezequiel.biblioteca.service.TelasService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginEmailController implements Initializable {
    @FXML
    private TextField tf_senha;

    @FXML
    private TextField tf_email;

    @FXML
    private Label alertLogin;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        alertLogin.setText("");
        alertLogin.setVisible(false);
    }

    Estudante estudante = new Estudante();
    LoginService loginService = new LoginService();

    public boolean validar() {

        if (tf_email.getText().isBlank() && !tf_senha.getText().isBlank()) {
            alertLogin.setText("Insira o email");
        }

        if (!tf_email.getText().isBlank() && tf_senha.getText().isBlank()) {
            alertLogin.setText("Insira a senha");
        }

        if (tf_email.getText().isBlank() && tf_senha.getText().isBlank()) {

            alertLogin.setText("Insira a senha e o email");
        }

        int isInvalid = 0;

        if (!tf_email.getText().isBlank() && !tf_senha.getText().isBlank()){

            String emailValido = "([a-zA-Z0-9._+-]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,})";

            Pattern paternEmail = Pattern.compile(emailValido);
            Matcher matcherEmail = paternEmail.matcher(tf_email.getText());

            String senhaValida = "^(?=.*[a-zA-Z])(?=.*\\d).+$";

            Pattern paternSenha = Pattern.compile(senhaValida);
            Matcher matcherSenha = paternSenha.matcher(tf_senha.getText());

            if (!matcherEmail.matches() && matcherSenha.matches()) {
                isInvalid = 1;

            } else if (!matcherSenha.matches() && matcherEmail.matches()) {
                isInvalid = 2;

            } else if (!(matcherEmail.matches() && matcherSenha.matches())) {

                isInvalid = 3;
            }
        }

        switch (isInvalid){
            case 1:
                alertLogin.setText("Email inválido");
                tf_email.setText("");
                break;
            case 2:
                alertLogin.setText("Senha inválida");
                tf_senha.setText("");
                break;
            case 3:
                alertLogin.setText("Email e senha inválidos");
                tf_email.setText("");
                tf_senha.setText("");
                break;
        }

        if (!alertLogin.getText().isEmpty()) {
            alertLogin.getText();
            alertLogin.setVisible(true);

            return false;
        } else {
            return true;
        }
    }

    @FXML
    void loginEmail(ActionEvent event) {
        if (validar()) {
            estudante.setEmail(tf_email.getText());
            estudante.setSenha(tf_senha.getText());

            boolean loginEstudante = loginService.buscar(estudante);

            if (loginEstudante) {
                TelasService.mudarTela("loginSuccessfull");
            } else {
                TelasService.mudarTela("cadastrar");
            }
        }
    }
}


