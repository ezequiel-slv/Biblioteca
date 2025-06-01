package teste;

import dominio.Cadastro;
import dominio.ErroLogin;
import dominio.Login;
import servico.ValidacaoLogin;


public class BibliotecaTeste {
    public static void main(String[] args) {
        Cadastro cadastro = new Cadastro();
        Login login = new Login();
        ValidacaoLogin validar = new ValidacaoLogin();

        try {
            cadastro.startCadastro();
        } catch (ErroLogin e) {
            throw new RuntimeException(e);
        }

        login.startLogin();

        try {
            validar.Validarlogin(cadastro, login);
        } catch (ErroLogin e) {
            throw new RuntimeException(e);
        }
    }
}
