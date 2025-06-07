package dominio;

import java.util.Scanner;

public class Login {
    private String usuarioEntrada;
    private String senhaEntrada;
    private Cadastro cadastro;


    public void startLogin() throws ErroLogin {
        System.out.println("--- Login ---");

        Scanner entrada = new Scanner(System.in);
        System.out.println("Usuário");
        this.usuarioEntrada = entrada.nextLine();

        System.out.println("Senha");
        this.senhaEntrada = entrada.nextLine();

        if (!cadastro.getUsuarioDB().equals(usuarioEntrada) && !cadastro.getSenhaDB().equals(senhaEntrada)) {
            System.out.println("Erro: Usuário ou senha incorretos");
        }
        System.out.println("Login bem sucedido!");
    }

    public String getUsuarioEntrada() {
        return usuarioEntrada;
    }

    public String getSenhaEntrada() {
        return senhaEntrada;
    }
}
