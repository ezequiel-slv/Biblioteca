package dominio;

public class ErroLogin extends Exception {

    public ErroLogin(String message) {
        super(message);
    }
}
