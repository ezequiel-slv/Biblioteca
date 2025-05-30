package dominio;

import javax.security.auth.login.LoginException;

public class ErroLogin extends Exception {

    public void errorAlert(){
        System.out.println("Usuário ou senha incorreto");
    }
}
