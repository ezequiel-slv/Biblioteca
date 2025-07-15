package codmain.bibliotecaonline.teste;

import codmain.bibliotecaonline.dominio.*;


public class BibliotecaTeste {
    public static void main(String[] args) {
        Cadastro cadastro = new Cadastro();
        Login login = new Login();
        Livro1 livro1 = new Livro1();

        try {
            cadastro.startCadastro();
        } catch (ErroCadastro e) {
            throw new RuntimeException(e);
        }

        try {
            login.startLogin(cadastro);
        } catch (ErroLogin e) {
            throw new RuntimeException(e);
        }

        livro1.cadastarLivro();
    }
}
