package servico;

import dominio.Cadastro;
import dominio.ErroLogin;
import dominio.Login;

public class ValidacaoLogin {


    public void Validarlogin(Cadastro cadastro, Login login) throws ErroLogin {
        if (!cadastro.getUsuarioDB().equals(login.getUsuarioEntrada()) || !cadastro.getSenhaDB().equals(login.getSenhaEntrada())) {
            throw new ErroLogin("Erro: Usuário ou Senha incorretos");
        }
        System.out.println("Login bem sucessido");
    }
}
