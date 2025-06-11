package dominio;

import java.util.Scanner;

public class Cadastro {
    private String usuarioDB;
    private String senhaDB;


    public void startCadastro() throws ErroCadastro {
        System.out.println("--- Cadastro ---");
        Scanner entrada = new Scanner(System.in);

        while (true){
            System.out.println("Escolha o nome de usuário: ");
            this.usuarioDB = entrada.nextLine();

            System.out.println("A senha deve conter:");
            System.out.println("- Uma letra maiúscula");
            System.out.println("- Uma letra minúscula");
            System.out.println("- Um caracter especial");
            System.out.println("- Um número");
            System.out.println("Escolha a senha: ");
            this.senhaDB = entrada.nextLine();

            boolean upper = senhaDB.matches(".*[A-Z].*");
            boolean loww = senhaDB.matches(".*[a-z].*");
            boolean num = senhaDB.matches(".*[0-9].*");
            boolean upperAndLow = upper && loww;
            boolean especialCharacter = senhaDB.matches(".*[!@#$%^&*()\\-+_=~`{}\\[\\]:;\"'<>,.?/|\\\\].*");

            boolean usuarioInvalido = getUsuarioDB() == null || getUsuarioDB().isEmpty();
            boolean senhaInvalida = getSenhaDB() == null || getSenhaDB().isEmpty() || !upperAndLow || !especialCharacter || !num;

            if (usuarioInvalido || senhaInvalida){
                System.out.println("Erro: Usuário ou senha inválida");
            }else {
                System.out.println("Cadastro efetuado com sucesso");
                break;
            }
        }
    }

    public String getUsuarioDB() {
        return usuarioDB.trim();
    }

    public String getSenhaDB() {
        return senhaDB.trim();
    }
}
