package com.ezequiel.library.controller;

import com.ezequiel.library.model.User;
import com.ezequiel.library.service.RegisterUserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterUserController implements Initializable {

    @FXML
    private DatePicker dp_dataNascimento;

    @FXML
    private RadioButton rb_feminino;

    @FXML
    private RadioButton rb_masculino;

    @FXML
    private TextField tf_email;

    @FXML
    private TextField tf_nome;

    @FXML
    private TextField tf_senha;

    @FXML
    private Label alertSignUp;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dp_dataNascimento.getEditor().setTextFormatter(

                new TextFormatter<>(change -> {

                    String texto = change.getControlNewText();

                    if (texto.matches("[0-9/]*") && texto.length() <= 10) {
                        return change;
                    }

                    return null;
                })
        );

        alertSignUp.setText("");
        alertSignUp.setVisible(false);
    }

    User user = new User();
    RegisterUserService registerUserService = new RegisterUserService();

    @FXML
    public LocalDate getDate() {
        return dp_dataNascimento.getValue();
    }

    public boolean validar() {

        String dataDigitada = dp_dataNascimento.getEditor().getText().trim();

        if (tf_nome.getText().isBlank()
                && !tf_email.getText().isBlank()
                && !tf_senha.getText().isBlank()
                && !(dataDigitada.isEmpty() || dp_dataNascimento.getValue() == null)) {

            alertSignUp.setText("Insira o nome de usuário");
        }

        if (tf_nome.getText().isBlank() && (dataDigitada.isEmpty() || dp_dataNascimento.getValue() == null)
                && !tf_email.getText().isBlank()
                && !tf_senha.getText().isBlank()) {

            alertSignUp.setText("Insira o nome e data");
//            Blank: condição 2;
        }

        if (tf_nome.getText().isBlank() && tf_email.getText().isBlank()
                && !(dataDigitada.isEmpty() || dp_dataNascimento.getValue() == null)
                && !tf_senha.getText().isBlank()) {

            alertSignUp.setText("Insira o nome e email");
//            Blank: condição 3;
        }

        if (tf_nome.getText().isBlank() && tf_senha.getText().isBlank()
                && !(dataDigitada.isEmpty() || dp_dataNascimento.getValue() == null)
                && !tf_email.getText().isBlank()) {

            alertSignUp.setText("Insira o nome e senha");
//            Blank: condição 4;
        }

        if ((tf_nome.getText().isBlank() && (dataDigitada.isEmpty() || dp_dataNascimento.getValue() == null) && tf_email.getText().isBlank())
                && !tf_senha.getText().isBlank()){

            alertSignUp.setText("Insira o nome, data e email");
//            Blank: condição 5;
        }

        if (tf_nome.getText().isBlank() && (dataDigitada.isEmpty() || dp_dataNascimento.getValue() == null) && tf_senha.getText().isBlank()
                && !tf_email.getText().isBlank()){

            alertSignUp.setText("Insira o nome, data e senha");
//            Blank: condição 6;
        }

        if (tf_nome.getText().isBlank() && tf_email.getText().isBlank() && tf_senha.getText().isBlank()
                && !(dataDigitada.isEmpty() || dp_dataNascimento.getValue() == null)){

            alertSignUp.setText("Insira o nome, email e senha");
//            Blank: condição 7;
        }


        if ((dataDigitada.isEmpty() || dp_dataNascimento.getValue() == null)
                && !tf_nome.getText().isBlank()
                && !tf_email.getText().isBlank()
                && !tf_senha.getText().isBlank()) {

            alertSignUp.setText("Insira data de nascimento");
//            Blank: condição = 8;
        }

        if ((dataDigitada.isEmpty() || dp_dataNascimento.getValue() == null) && tf_email.getText().isBlank()
                && !tf_nome.getText().isBlank()
                && !tf_senha.getText().isBlank()){

            alertSignUp.setText("Insira data e email");
//            Blank: condição 9;
        }

        if ((dataDigitada.isEmpty() || dp_dataNascimento.getValue() == null) && tf_senha.getText().isBlank()
                && !tf_email.getText().isBlank()
                && !tf_nome.getText().isBlank()){

            alertSignUp.setText("Insira data e senha");
//            Blank: condição 10;
        }

        if ((dataDigitada.isEmpty() || dp_dataNascimento.getValue() == null) && tf_email.getText().isBlank() && tf_senha.getText().isBlank()
                && !tf_nome.getText().isBlank()){

            alertSignUp.setText("Insira a data, email e senha");
//            Blank: condição 11;
        }


        if (tf_email.getText().isBlank()
                && !tf_nome.getText().isBlank()
                && !tf_senha.getText().isBlank()
                && !(dataDigitada.isEmpty() || dp_dataNascimento.getValue() == null)) {

            alertSignUp.setText("Insira o email");
//            Blank: condição 12
        }

        if (tf_email.getText().isBlank() && tf_senha.getText().isBlank()
                && !tf_nome.getText().isBlank()
                && !(dataDigitada.isEmpty() || dp_dataNascimento.getValue() == null)){

            alertSignUp.setText("Insira email e senha");
//            Blank: condição 13;
        }


        if (tf_senha.getText().isBlank()
                && !tf_nome.getText().isBlank()
                && !(dataDigitada.isEmpty() || dp_dataNascimento.getValue() == null)
                && !tf_email.getText().isBlank()){

            alertSignUp.setText("Insira a senha");
//            Blank: condição 14
        }

        int isInvalid = 0;

        if (!tf_nome.getText().isBlank()
                && !tf_email.getText().isBlank()
                && !tf_senha.getText().isBlank()
                && !(dataDigitada.isEmpty() || dp_dataNascimento.getValue() == null)){

            String emailValido = "([a-zA-Z0-9._+-]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,})";

            Pattern paternEmail = Pattern.compile(emailValido);
            Matcher matcherEmail = paternEmail.matcher(tf_email.getText());

            String senhaValida = "^(?=.*[a-zA-Z])(?=.*\\d).+$";

            Pattern paternSenha = Pattern.compile(senhaValida);
            Matcher matcherSenha = paternSenha.matcher(tf_senha.getText());

            if (!matcherEmail.matches() && matcherSenha.matches()) {
                isInvalid = 1;

//                Invalid: condição 1
            } else if (!matcherSenha.matches() && matcherEmail.matches()) {
                isInvalid = 2;

//                Invalid: condição 2
            } else if (!(matcherEmail.matches() && matcherSenha.matches())) {
                isInvalid = 3;

//                Invalid: condição 3
            }
        }

        switch (isInvalid){
            case 1:
                alertSignUp.setText("Email inválido");
                break;
            case 2:
                alertSignUp.setText("Senha inválida");
                break;
            case 3:
                alertSignUp.setText("Email e senha inválidos");
                tf_email.setText("");
                tf_senha.setText("");
                break;
        }


        if (tf_nome.getText().isBlank()
                && tf_email.getText().isBlank()
                && tf_senha.getText().isBlank()
                && (dataDigitada.isEmpty() || dp_dataNascimento.getValue() == null)) {

            alertSignUp.setText("Preencha os campos");
        }


        if (!alertSignUp.getText().isEmpty()) {
            alertSignUp.getText();
            alertSignUp.setVisible(true);

            return false;
        } else {
            return true;
        }
    }

        @FXML
        void salvarDados (ActionEvent event){
            if (validar()) {
                user.setNome(tf_nome.getText());
                user.setEmail(tf_email.getText());
                user.setSenha(tf_senha.getText());

                user.setDataNascimento(getDate());

                if (rb_masculino.isSelected()) {
                    user.setSexo("Masculino");
                }

                if (rb_feminino.isSelected()) {
                    user.setSexo("Feminino");
                }

                registerUserService.inserir(user);
                limpar();
            }
        }

        void limpar () {
            tf_nome.setText("");
            tf_email.setText("");
            tf_senha.setText("");
            dp_dataNascimento.setValue(null);
        }
    }
