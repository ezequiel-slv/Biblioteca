package teste;

import dominio.Login;
import servico.LoginUsuario;

import java.util.Scanner;

public class BibliotecaTeste {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Login login = new Login();

        System.out.println("Digite o nome de usuário: ");
        String usuario = entrada.nextLine();


    }
}
