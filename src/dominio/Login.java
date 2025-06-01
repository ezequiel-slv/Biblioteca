package dominio;

import java.util.Scanner;

public class Login {
    private String usuarioEntrada;
    private String senhaEntrada;


    public void startLogin(){
        System.out.println("--- Login ---");

        Scanner entrada = new Scanner(System.in);
        System.out.println("Usuário");
        this.usuarioEntrada = entrada.nextLine();

        System.out.println("Senha");
        this.senhaEntrada = entrada.nextLine();
    }

    public String getUsuarioEntrada() {
        return usuarioEntrada;
    }

    public String getSenhaEntrada() {
        return senhaEntrada;
    }
}
