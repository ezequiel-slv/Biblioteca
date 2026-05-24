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
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginController implements Initializable {
    @FXML
    private TextField tf_senha;

    @FXML
    private TextField tf_email;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    Estudante estudante = new Estudante();
    LoginService loginService = new LoginService();

    public boolean validar() {
        StringBuilder aviso = new StringBuilder();

        if (!tf_email.getText().isEmpty()){
            String emailValido = "([a-zA-Z0-9._+-]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,})";

            Pattern paternEmail = Pattern.compile(emailValido);
            Matcher matcherEmail = paternEmail.matcher(tf_email.getText());

            if (!matcherEmail.matches()){
                aviso.append("Email inválido!\n");
                tf_email.setText("");
            }
        }else {
            aviso.append("Campo email é obrigatório\n");
        }

        if (!tf_senha.getText().isEmpty()){
            String senhaValida = "^(?=.*[a-zA-Z])(?=.*\\d).+$";

            Pattern paternSenha = Pattern.compile(senhaValida);
            Matcher matcherSenha = paternSenha.matcher(tf_senha.getText());

            if (!matcherSenha.matches()){
                aviso.append("Senha inválida!\n");
                tf_senha.setText("");
            }
        }else {
            aviso.append("Campo senha é obrigatório\n");
        }

        if (!aviso.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Erro");
            alert.setContentText(aviso.toString());
            alert.show();
            return false;
        } else {
            return true;
        }
    }

    @FXML
    void entrar(ActionEvent event) {
        if (validar()) {
            estudante.setEmail(tf_email.getText());
            estudante.setSenha(tf_senha.getText());

            boolean loginEstudante = loginService.buscar(estudante);

            if (loginEstudante) {
                System.out.println("Login bem sucedido");
            } else {
                TelasService.mudarTela("cadastrar");
            }
        }
    }
}


