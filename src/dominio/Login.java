package dominio;

import java.util.Scanner;

public class Login {
    public void startLogin(Cadastro cadastro) throws ErroLogin {

        System.out.println("--- Login ---");
        Scanner entrada = new Scanner(System.in);

        while (true){
            System.out.println("Usuário");
            String usuarioEntrada = entrada.nextLine();

            System.out.println("Senha");
            String senhaEntrada = entrada.nextLine();

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
}
