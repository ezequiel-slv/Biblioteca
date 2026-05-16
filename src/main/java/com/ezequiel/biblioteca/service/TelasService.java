package com.ezequiel.biblioteca.service;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelasService {
    public static String stg;
    public static Stage stage;
    public static Scene inicioScene;
    public static Scene loginScene;
    public static Scene cadastroScene;


    public static void mudarTela(String string){
        stg = string;
        switch (string){
            case "entrar":
                stage.setScene(loginScene);
                break;
            case "cadastrar":
                stage.setScene(cadastroScene);
                break;
            case "voltarLogin", "voltarCadastro":
                stage.setScene(inicioScene);
            default:
                break;
        }
    }

    public static String getStg() {
        return stg;
    }

    public static void setStg(String stg) {
        TelasService.stg = stg;
    }
}
