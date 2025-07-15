package codmain.bibliotecaonline.dominio;

public abstract class Livro {
    String titulo;
    String autor;
    String livroFisico = "FISICO";
    String livroDigital = "DIGITAL";


    static {
        System.out.println("---Bliblioteca Online---");
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getLivroFisico() {
        return livroFisico;
    }

    public void setLivroFisico(String livroFisico) {
        this.livroFisico = livroFisico;
    }

    public String getLivroDigital() {
        return livroDigital;
    }

    public void setLivroDigital(String livroDigital) {
        this.livroDigital = livroDigital;
    }
}
