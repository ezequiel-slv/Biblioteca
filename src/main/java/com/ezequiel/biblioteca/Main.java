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
                .getResource("telas/stile/Inicio.css")).toExternalForm();
        TelasService.inicioScene.getStylesheets().add(cssInicio);

        Parent telaLogin = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("telas/login.fxml")));
        TelasService.loginScene = new Scene(telaLogin);

        String cssLogin = Objects.requireNonNull(this.getClass()
                .getResource("telas/stile/Login.css")).toExternalForm();
        TelasService.loginScene.getStylesheets().add(cssLogin);

        Parent telaCadastro = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("telas/cadastro.fxml")));
        TelasService.cadastroScene = new Scene(telaCadastro);

        String cssCadastro = Objects.requireNonNull(this.getClass()
                .getResource("telas/stile/cadastro.css")).toExternalForm();
        TelasService.cadastroScene.getStylesheets().add(cssCadastro);

        sg.setScene(TelasService.inicioScene);
        sg.show();

        String stg = TelasService.getStg();
    }
}
