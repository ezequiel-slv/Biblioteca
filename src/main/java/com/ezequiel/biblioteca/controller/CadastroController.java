package com.ezequiel.biblioteca.controller;

import com.ezequiel.biblioteca.model.Estudante;
import com.ezequiel.biblioteca.service.CadastroService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CadastroController implements Initializable {

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
    private Label alert;

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
        alert.setVisible(false);
    }

    Estudante estudante = new Estudante();
    CadastroService cadastroService = new CadastroService();

    @FXML
    public LocalDate getDate() {
        return dp_dataNascimento.getValue();
    }

    public boolean validar() {

        String dataDigitada = dp_dataNascimento.getEditor().getText().trim();


        int isBlank = 0;
        int isInvalid = 0;

        if (tf_nome.getText().isBlank() && !tf_email.getText().isBlank()
                && !tf_senha.getText().isBlank()
                && (!dataDigitada.isEmpty() || dp_dataNascimento.getValue() != null)) {
            isBlank = 1;
        }

        if (tf_nome.getText().isBlank() && (dataDigitada.isEmpty() || dp_dataNascimento.getValue() == null)
                && !tf_email.getText().isBlank() && !tf_senha.getText().isBlank()) {
            isBlank = 2;
        }

        if (tf_nome.getText().isBlank() && tf_email.getText().isBlank()
                && (!dataDigitada.isEmpty() || dp_dataNascimento.getValue() != null)
                && !tf_senha.getText().isBlank()) {
            isBlank = 3;
        }

        if (tf_nome.getText().isBlank() && tf_senha.getText().isBlank()
                && !(dataDigitada.isEmpty() || dp_dataNascimento.getValue() == null)
                && !tf_email.getText().isBlank()) {
            isBlank = 4;
        }

        if ((tf_nome.getText().isBlank()
                && (dataDigitada.isEmpty() || dp_dataNascimento.getValue() == null)
                && tf_email.getText().isBlank()) && !tf_senha.getText().isBlank()){
            isBlank = 5;
        }



        if ((dataDigitada.isEmpty() || dp_dataNascimento.getValue() == null)
                && !tf_nome.getText().isBlank()
                && !tf_email.getText().isBlank()
                && !tf_senha.getText().isBlank()) {
            isBlank = 6;
        }

        if ((dataDigitada.isEmpty() || dp_dataNascimento.getValue() == null) && tf_email.getText().isBlank()
                && !tf_nome.getText().isBlank()
                && !tf_senha.getText().isBlank()){
            isBlank = 7;
        }

        if ((dataDigitada.isEmpty() || dp_dataNascimento.getValue() == null) && tf_senha.getText().isBlank()
                && !tf_email.getText().isBlank()
                && !tf_nome.getText().isBlank()){
            isBlank = 8;
        }



        if (tf_email.getText().isBlank() && tf_senha.getText().isBlank()
                && !tf_nome.getText().isBlank()
                && !(dataDigitada.isEmpty() || dp_dataNascimento.getValue() == null)){
            isBlank = 9;
        }

        if (tf_nome.getText().isBlank()
                && tf_email.getText().isBlank()
                && tf_senha.getText().isBlank()
                && (dataDigitada.isEmpty() || dp_dataNascimento.getValue() == null)) {
            isBlank = 10;
        }


        if (tf_email.getText().isBlank()
                && !tf_nome.getText().isBlank()
                && !tf_senha.getText().isBlank()
                && !(dataDigitada.isEmpty() || dp_dataNascimento.getValue() == null)) {
            isBlank = 11;
        }

        if (!tf_nome.getText().isBlank()
                && !tf_email.getText().isBlank()
                && !tf_senha.getText().isBlank()
                && !(dataDigitada.isEmpty() || dp_dataNascimento.getValue() == null)){

            String emailValido = "([a-zA-Z0-9._+-]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,})";

            Pattern paternEmail = Pattern.compile(emailValido);
            Matcher matcherEmail = paternEmail.matcher(tf_email.getText());

            if (!matcherEmail.matches()) {
                isInvalid = 1;
            }
        }

        if (tf_senha.getText().isBlank()
                && !tf_nome.getText().isBlank()
                && !(dataDigitada.isEmpty() || dp_dataNascimento.getValue() == null)
                && !tf_email.getText().isBlank()){
            isBlank = 12;
        }

        if (!tf_email.getText().isBlank()
                && !tf_nome.getText().isBlank()
                && !tf_senha.getText().isBlank()
                && !(dataDigitada.isEmpty() || dp_dataNascimento.getValue() == null)) {
            String senhaValida = "^(?=.*[a-zA-Z])(?=.*\\d).+$";

            Pattern paternSenha = Pattern.compile(senhaValida);
            Matcher matcherSenha = paternSenha.matcher(tf_senha.getText());

            if (!matcherSenha.matches()) {
                isInvalid = 2;
            }
        }

        switch (isInvalid) {
            case 1:
                alert.setText("Email inválido!");
                tf_email.setText("");
                break;
            case 2:
                alert.setText("Senha inválida");
                tf_senha.setText("");
                break;
        }

        switch (isBlank) {
            case 1:
                alert.setText("Insira o nome de usuário");
                break;
            case 2:
                alert.setText("Insira o nome e data");
                break;
            case 3:
                alert.setText("Insira o nome e email");
                break;
            case 4:
                alert.setText("Insira o nome e senha");
                break;
            case 5:
                alert.setText("Insira o nome, data e email");
                break;
            case 6:
                alert.setText("Insira a data de nascimento");
                break;
            case 7:
                alert.setText("Insira data e email");
                break;
            case 8:
                alert.setText("Insira data e senha");
                break;
            case 9:
                alert.setText("Insira email e senha");
                break;
            case 10:
                alert.setText("Preencha os campos");
                break;
            case 11:
                alert.setText("Insira o email");
                break;
            case 12:
                alert.setText("Insira a senha");
                break;
        }

        if (!alert.getText().isEmpty()) {
            alert.getText();
            alert.setVisible(true);

            return false;
        } else {
            return true;
        }
    }

        @FXML
        void salvarDados (ActionEvent event){
            if (validar()) {
                estudante.setNome(tf_nome.getText());
                estudante.setEmail(tf_email.getText());
                estudante.setSenha(tf_senha.getText());

                estudante.setDataNascimento(getDate());

                if (rb_masculino.isSelected()) {
                    estudante.setSexo("Masculino");
                }

                if (rb_feminino.isSelected()) {
                    estudante.setSexo("Feminino");
                }

                cadastroService.inserir(estudante);
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
