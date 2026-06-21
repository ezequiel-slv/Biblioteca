package com.ezequiel.library.service;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenService {
    public static Stage stage;
    public static Scene inicioScene;
    public static Scene continueScene;
    public static Scene cadastroScene;
    public static Scene homeScene;
    public static Scene continueEmail;


    public static void mudarTela(String string){
        switch (string){
            case "entrar":
                stage.setScene(continueScene);
                break;
            case "createAccount":
                stage.setScene(cadastroScene);
                break;
            case "loginSuccessfull":
                stage.setScene(homeScene);
                break;
            case "continueEmail":
                stage.setScene(continueEmail);
                break;
            default:
                break;
        }
    }
}
