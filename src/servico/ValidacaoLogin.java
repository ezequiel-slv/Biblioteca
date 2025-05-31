package servico;

import dominio.Cadastro;
import dominio.ErroLogin;
import dominio.Login;

public class ValidacaoLogin {


    public void Validarlogin(Cadastro cadastro, Login login) throws ErroLogin {
        if (!cadastro.getUsuarioDB().equals(login.getUsuarioEntrada()) || !cadastro.getSenhaDB().equals(login.getSenhaEntrada())){
            throw new ErroLogin("Usuário ou senha incorreto");
        }
        System.out.println("Login efetuado com sucesso!");
    }
}
