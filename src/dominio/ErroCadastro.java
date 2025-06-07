package dominio;

public class ErroCadastro extends RuntimeException {

    public ErroCadastro(String message) {
        super(message);
    }
}
