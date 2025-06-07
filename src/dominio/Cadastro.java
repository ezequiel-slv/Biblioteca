package dominio;

import java.util.Scanner;

public class Cadastro {
    private String usuarioDB;
    private String senhaDB;


    public void startCadastro() throws ErroCadastro {
        System.out.println("--- Cadastro ---");

        Scanner entrada = new Scanner(System.in);
        System.out.println("Escolha o nome de usuário: ");
        this.usuarioDB = entrada.nextLine();

        System.out.println("- A senha deve conter:");
        System.out.println("Uma letra maiúscula");
        System.out.println("Uma letra minúscula");
        System.out.println("Um caracter especial");

        System.out.println("Escolha a senha: ");
        this.senhaDB = entrada.nextLine();

        boolean upper = senhaDB.matches(".*[A-Z].*");
        boolean loww = senhaDB.matches(".*[a-z].*");
        boolean upperAndLow = upper && loww;

        boolean especialCharacter = senhaDB.matches(".*[!@#$%^&*()+_=~`{}:;'<>,.?/|].*");


        if (getUsuarioDB() != null && !getUsuarioDB().isEmpty() && getSenhaDB() != null && !getSenhaDB().isEmpty() && upperAndLow && especialCharacter) {
            System.out.println("Cadastro feito com sucesso!");
        } else {
            throw new ErroCadastro("Erro: Usuário ou senha inválidos");
        }
    }

    public String getUsuarioDB() {
        return usuarioDB.trim();
    }

    public String getSenhaDB() {
        return senhaDB.trim();
    }
}
