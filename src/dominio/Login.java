package dominio;

public class Login extends ErroLogin{
    private String usuarioDB;
    private String senhaDB;

    @Override
    public void errorAlert() {
        super.errorAlert();
    }

    public void setUsuarioDB(String usuarioDB) {
        this.usuarioDB = usuarioDB;
    }

    public void setSenhaDB(String senhaDB) {
        this.senhaDB = senhaDB;
    }
}
