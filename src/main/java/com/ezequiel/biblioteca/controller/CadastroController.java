package com.ezequiel.biblioteca.controller;

import com.ezequiel.biblioteca.model.Estudante;
import com.ezequiel.biblioteca.service.CadastroService;
import com.ezequiel.biblioteca.service.TelasService;
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

    public boolean validar(){
        String dataDigitada = dp_dataNascimento.getEditor().getText().trim();

        boolean validacaoGeral = tf_nome.getText().isBlank()
                && tf_email.getText().isBlank()
                && tf_senha.getText().isBlank()
                && dataDigitada.isEmpty() || dp_dataNascimento.getValue() == null;

            if (!tf_email.getText().isBlank()) {

                String emailValido = "([a-zA-Z0-9._+-]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,})";

                Pattern paternEmail = Pattern.compile(emailValido);
                Matcher matcherEmail = paternEmail.matcher(tf_email.getText());

                if (!matcherEmail.matches()) {

                    alert.setText("Email inválido!");
                    tf_email.setText("");
                }
            }

            if (!tf_senha.getText().isBlank()) {

                String senhaValida = "^(?=.*[a-zA-Z])(?=.*\\d).+$";

                Pattern paternSenha = Pattern.compile(senhaValida);
                Matcher matcherSenha = paternSenha.matcher(tf_senha.getText());

                if (!matcherSenha.matches()) {

                    alert.setText("Senha inválida");
                    tf_senha.setText("");
                }
            }

        if (tf_nome.getText().isBlank()
                && !(dataDigitada.isEmpty()) || dp_dataNascimento.getValue() != null
                && !(tf_email.getText().isBlank())
                && !(tf_senha.getText().isBlank())){

            alert.setText(null);
            alert.setText("Insira um nome de usuário!");
            alert.setVisible(true);

        }

        if (dataDigitada.isEmpty() || dp_dataNascimento.getValue() == null){
            alert.setVisible(true);
        }

        if (validacaoGeral){
            alert.setText("Preencha os campos para prosseguir");
            alert.setVisible(true);

            return  false;
        }else {
            return true;
        }
    }

    @FXML
    void salvarDados(ActionEvent event) {
        if (validar()){
            estudante.setNome(tf_nome.getText());
            estudante.setEmail(tf_email.getText());
            estudante.setSenha(tf_senha.getText());

            estudante.setDataNascimento(getDate());

            if (rb_masculino.isSelected()){
                estudante.setSexo("Masculino");
            }

            if (rb_feminino.isSelected()){
                estudante.setSexo("Feminino");
            }

            cadastroService.inserir(estudante);
            //limpar();
        }
    }

    @FXML
    void voltarCadastro(ActionEvent event){
        TelasService.mudarTela("voltarCadastro");
    }

    void limpar(){
        tf_nome.setText("");
        tf_email.setText("");
        tf_senha.setText("");
        dp_dataNascimento.setValue(null);
    }
}
