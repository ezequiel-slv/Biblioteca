package teste;

import dominio.Cadastro;
import dominio.ErroLogin;
import dominio.Login;
import servico.ValidacaoLogin;

import java.util.Scanner;

public class BibliotecaTeste {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Cadastro cadastro = new Cadastro();
        Login login = new Login();
        ValidacaoLogin validar = new ValidacaoLogin();

        System.out.println("--- Cadastro ---");
        System.out.println("Digite o nome de usuário: ");
        String usuario = entrada.nextLine();
        cadastro.setUsuarioDB(usuario);

        System.out.println("Digite a senha: ");
        String senha = entrada.nextLine();
        cadastro.setSenhaDB(senha);

        cadastro.confirmaCadastro();

        System.out.println("--- Login ---");

        System.out.println("Usuário: ");
        String usuarioDigitado = entrada.nextLine();
        login.setUsuarioEntrada(usuarioDigitado);

        System.out.println("Senha");
        String senhaDigitada = entrada.nextLine();
        login.setSenhaEntrada(senhaDigitada);

        try {
            validar.Validarlogin(cadastro, login);
        } catch (ErroLogin e) {
            throw new RuntimeException(e);
        }
    }
}
