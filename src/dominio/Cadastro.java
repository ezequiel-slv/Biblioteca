package dominio;

import java.util.Scanner;

public class Cadastro{
    private String usuarioDB;
    private String senhaDB;


    public void confirmaCadastro(){
        if (usuarioDB != null || senhaDB != null){
            System.out.println("Cadastro feito com sucesso!");
        }

    }

    public String getUsuarioDB() {
        return usuarioDB;
    }

    public String getSenhaDB() {
        return senhaDB;
    }

    public void setUsuarioDB(String usuarioDB) {
        this.usuarioDB = usuarioDB;
    }

    public void setSenhaDB(String senhaDB) {
        this.senhaDB = senhaDB;
    }
}
