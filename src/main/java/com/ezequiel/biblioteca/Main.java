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

        String cssInicio = Objects.requireNonNull(this.getClass()
                .getResource("telas/css/Inicio.css")).toExternalForm();
        TelasService.inicioScene.getStylesheets().add(cssInicio);

        Parent telaLogin = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("telas/continue.fxml")));
        TelasService.continueScene = new Scene(telaLogin);

        String cssLogin = Objects.requireNonNull(this.getClass()
                .getResource("telas/css/continue.css")).toExternalForm();
        TelasService.continueScene.getStylesheets().add(cssLogin);

        Parent telaCadastro = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("telas/cadastro.fxml")));
        TelasService.cadastroScene = new Scene(telaCadastro);

        String cssCadastro = Objects.requireNonNull(this.getClass()
                .getResource("telas/css/cadastro.css")).toExternalForm();
        TelasService.cadastroScene.getStylesheets().add(cssCadastro);

        Parent telaHome = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("telas/home.fxml")));
        TelasService.home = new Scene(telaHome);

        Parent telaLoginEmail = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("telas/loginemail.fxml")));
        TelasService.continueEmail = new Scene(telaLoginEmail);

        String cssLoginEmail = Objects.requireNonNull(this.getClass()
                .getResource("telas/css/loginEmail.css")).toExternalForm();
        TelasService.continueEmail.getStylesheets().add(cssLoginEmail);

        sg.setScene(TelasService.inicioScene);
        sg.show();
    }
}
