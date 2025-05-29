package dominio;

import java.util.Random;

public abstract class Livro {
    String titulo;
    String autor;
    String livroFisico = "LIVRO_FISICO";
    String livroDigital = "LIVRO_DIGITAL";

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
}
