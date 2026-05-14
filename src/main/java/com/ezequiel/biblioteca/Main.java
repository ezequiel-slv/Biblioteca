package com.ezequiel.biblioteca;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {
    private static Stage stage;
    private static Scene inicioScene;
    private static Scene loginScene;
    private static Scene cadastroScene;

    @Override
    public void start(Stage sg) throws Exception {
        stage = sg;
        sg.setTitle("Biblioteca");

        Parent telaInicio = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("telas/inicio.fxml")));
        inicioScene = new Scene(telaInicio);

        Parent telaLogin = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("telas/login.fxml")));
        loginScene = new Scene(telaLogin);

        Parent telaCadastro = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("telas/cadastro.fxml")));
        cadastroScene = new Scene(telaCadastro);


        sg.setScene(telaInicio.getScene());
        sg.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void mudarTela(String src){
        switch (src){
            case "entrar":
                stage.setScene(loginScene);
                break;
            case "cadastrar":
                stage.setScene(cadastroScene);
                break;
            default:
                break;
        }
    }
}
