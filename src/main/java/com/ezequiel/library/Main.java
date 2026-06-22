package com.ezequiel.library;

import com.ezequiel.library.service.ScreenService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage sg) throws Exception {
        ScreenService.stage = sg;
        sg.setTitle("Biblioteca");

        Parent telaInicio = FXMLLoader.load(Objects.requireNonNull(getClass()
                .getResource("screens/mainscreen.fxml")));
        ScreenService.inicioScene = new Scene(telaInicio);

        String cssInicio = Objects.requireNonNull(this.getClass()
                .getResource("screens/css/homescreen.css")).toExternalForm();
        ScreenService.inicioScene.getStylesheets().add(cssInicio);

        Parent telaLogin = FXMLLoader.load(Objects.requireNonNull(getClass()
                .getResource("screens/loginregister.fxml")));
        ScreenService.continueScene = new Scene(telaLogin);

        String cssLogin = Objects.requireNonNull(this.getClass()
                .getResource("screens/css/loginregister.css")).toExternalForm();
        ScreenService.continueScene.getStylesheets().add(cssLogin);

        Parent telaCadastro = FXMLLoader.load(Objects.requireNonNull(getClass()
                .getResource("screens/register.fxml")));
        ScreenService.cadastroScene = new Scene(telaCadastro);

        String cssCadastro = Objects.requireNonNull(this.getClass()
                .getResource("screens/css/register.css")).toExternalForm();
        ScreenService.cadastroScene.getStylesheets().add(cssCadastro);

        Parent telaHome = FXMLLoader.load(Objects.requireNonNull(getClass()
                .getResource("screens/homescreen.fxml")));
        ScreenService.homeScene = new Scene(telaHome);

        Parent telaLoginEmail = FXMLLoader.load(Objects.requireNonNull(getClass()
                .getResource("screens/loginemail.fxml")));
        ScreenService.continueEmail = new Scene(telaLoginEmail);

        String cssLoginEmail = Objects.requireNonNull(this.getClass()
                .getResource("screens/css/loginemail.css")).toExternalForm();
        ScreenService.continueEmail.getStylesheets().add(cssLoginEmail);

        sg.setScene(ScreenService.inicioScene);
        sg.show();
    }
}
