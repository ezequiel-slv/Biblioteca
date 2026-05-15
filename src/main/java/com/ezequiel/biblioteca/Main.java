package com.ezequiel.biblioteca;

import com.ezequiel.biblioteca.service.TelasService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage sg) throws Exception {
        TelasService.stage = sg;
        sg.setTitle("Biblioteca");

        Parent telaInicio = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("telas/inicio.fxml")));
        TelasService.inicioScene = new Scene(telaInicio);

        Parent telaLogin = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("telas/login.fxml")));
        TelasService.loginScene = new Scene(telaLogin);

        Parent telaCadastro = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("telas/cadastro.fxml")));
        TelasService.cadastroScene = new Scene(telaCadastro);

        sg.setScene(TelasService.inicioScene);
        sg.show();

        String stg = TelasService.getStg();
    }
}
