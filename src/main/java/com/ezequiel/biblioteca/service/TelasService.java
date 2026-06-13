package com.ezequiel.biblioteca.service;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelasService {
    public static Stage stage;
    public static Scene inicioScene;
    public static Scene continueScene;
    public static Scene cadastroScene;
    public static Scene home;
    public static Scene continueEmail;


    public static void mudarTela(String string){
        switch (string){
            case "entrar":
                stage.setScene(continueScene);
                break;
            case "createAccount":
                stage.setScene(cadastroScene);
                break;
            case "voltarLogin", "voltarCadastro":
                stage.setScene(inicioScene);
            case "loginSuccessfull":
                stage.setScene(home);
            case "continueEmail":
                stage.setScene(continueEmail);
            default:
                break;
        }
    }
}
