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
    }

    Estudante estudante = new Estudante();
    CadastroService cadastroService = new CadastroService();

    @FXML
    public LocalDate getDate() {
         return dp_dataNascimento.getValue();
    }

    public boolean validar(){
        StringBuilder aviso = new StringBuilder();

        if (tf_nome.getText().isBlank()){
            aviso.append("Campo nome é obrigatório\n");
        }

        if (!tf_email.getText().isBlank()){

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

        if (!tf_senha.getText().isBlank()){
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

        String dataDigitada = dp_dataNascimento.getEditor().getText().trim();

        if (dataDigitada.isEmpty() || dp_dataNascimento.getValue() == null){
            aviso.append("Campo data de nascimento é obrigatório\n");
        }

        if (!aviso.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("ERRO");
            alert.setContentText(aviso.toString());
            alert.show();
            return  false;
        }else {
            return  true;
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
            limpar();
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
