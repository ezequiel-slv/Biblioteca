package com.ezequiel.biblioteca.service;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelasService {
    public static Stage stage;
    public static Scene inicioScene;
    public static Scene loginScene;
    public static Scene cadastroScene;
    public static Scene home;


    public static void mudarTela(String string){
        switch (string){
            case "entrar":
                stage.setScene(loginScene);
                break;
            case "cadastrar":
                stage.setScene(cadastroScene);
                break;
            case "voltarLogin", "voltarCadastro":
                stage.setScene(inicioScene);
            case "loginSuccessfull":
                stage.setScene(home);
            default:
                break;
        }
    }
}
