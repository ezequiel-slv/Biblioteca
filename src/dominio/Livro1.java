package dominio;

import java.util.Scanner;

public class Livro1 extends Livro implements Imprimivel{

    @Override
    public void imprimivel() {
        System.out.println("O livro pode ser impresso");
    }

    public void cadastarLivro(){
        System.out.println("Antes de iniciar o cadastro você tem a opção de escolher essas categorias: ");

        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome do titulo do livro: ");
        this.titulo = entrada.nextLine();

        System.out.println("Digite o nome do autor");
        this.autor = entrada.nextLine();

        System.out.println("Digite o formato do livro que deseja cadastrar (FISICO ou DIGITAL): ");
        String categoriaFinal = entrada.nextLine();
        if (categoriaFinal.equals(livroDigital)){
            imprimivel();
        }

    }

    @Override
    public String getTitulo() {
        return super.getTitulo();
    }

    @Override
    public void setTitulo(String titulo) {
        super.setTitulo(titulo);
    }

    @Override
    public String getAutor() {
        return super.getAutor();
    }

    @Override
    public void setAutor(String autor) {
        super.setAutor(autor);
    }

    @Override
    public String getLivroFisico() {
        return super.getLivroFisico();
    }

    @Override
    public void setLivroFisico(String livroFisico) {
        super.setLivroFisico(livroFisico);
    }

    @Override
    public String getLivroDigital() {
        return super.getLivroDigital();
    }

    @Override
    public void setLivroDigital(String livroDigital) {
        super.setLivroDigital(livroDigital);
    }
}
