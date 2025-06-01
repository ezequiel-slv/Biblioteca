package dominio;

import java.util.Random;

public abstract class Livro {
    String titulo;
    String autor;
    String livroFisico = "FISICO";
    String livroDigital = "DIGITAL";

    static {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder codigo = new StringBuilder();

        Random randon = new Random();
        int tamanho = 8;
        for (int i = 0; i < tamanho; i++) {
            int index = randon.nextInt(caracteres.length());
            codigo.append(caracteres.charAt(index));
        }
        String codigoAleatorio = codigo.toString();

        System.out.println("Código gerado: " + codigoAleatorio);
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
