package dominio;

import java.util.Scanner;

public class Login {
    private String usuarioEntrada;
    private String senhaEntrada;
    private Cadastro cadastro;


    public void startLogin() throws ErroLogin {
        System.out.println("--- Login ---");
        Scanner entrada = new Scanner(System.in);

        while (true){
            System.out.println("Usuário");
            this.usuarioEntrada = entrada.nextLine();

            System.out.println("Senha");
            this.senhaEntrada = entrada.nextLine();

            boolean loginUsuarioInvalido = !cadastro.getUsuarioDB().equals(usuarioEntrada);
            boolean loginSenhaInvalida = !cadastro.getSenhaDB().equals(senhaEntrada);

            if (loginUsuarioInvalido || loginSenhaInvalida){
                System.out.println("Erro: Usuário ou senha inválidos");
            }else {
                System.out.println("Login bem sucedido");
                break;
            }
        }
    }

    public String getUsuarioEntrada() {
        return usuarioEntrada;
    }

    public String getSenhaEntrada() {
        return senhaEntrada;
    }
}
