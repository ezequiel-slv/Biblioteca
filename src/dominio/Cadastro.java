package dominio;

import java.util.Scanner;

public class Cadastro{
    private String usuarioDB;
    private String senhaDB;


    public void startCadastro() throws ErroLogin{
        System.out.println("--- Cadastro ---");

        Scanner entrada = new Scanner(System.in);
        System.out.println("Escolha o nome de usuário: ");
        this.usuarioDB = entrada.nextLine();

        System.out.println("Escolha a senha: ");
        this.senhaDB = entrada.nextLine();

        try{
            if (usuarioDB != null || senhaDB != null){
                System.out.println("Cadastro feito com sucesso!");
            }
        }catch (Exception e){
            throw new ErroLogin("Erro: Campo usuário ou senha vazios");
        }
    }

    public String getUsuarioDB() {
        return usuarioDB;
    }

    public String getSenhaDB() {
        return senhaDB;
    }
}
