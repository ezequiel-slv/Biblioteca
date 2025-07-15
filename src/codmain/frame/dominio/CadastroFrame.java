package codmain.frame.dominio;

import javax.swing.*;

public class CadastroFrame {
    private JFrame titulo;

    public CadastroFrame() {
        startFrameMain();
    }

    public void startFrameMain(){
        titulo = new JFrame("Cadastro");
        titulo.setSize(400, 500);
        titulo.setDefaultCloseOperation(titulo.EXIT_ON_CLOSE);
        titulo.setLayout(null);

        JLabel infoUsuario = new JLabel("Escolha um nome de usuário:");
        infoUsuario.setBounds(115, 40, 180, 25);
        titulo.add(infoUsuario);

        JTextField usuarioCampo = new JTextField();
        usuarioCampo.setBounds(100, 70, 200, 25);
        titulo.add(usuarioCampo);

        JLabel infoSenha = new JLabel("Escolha uma senha:");
        infoSenha.setBounds(140, 120, 150, 25);
        titulo.add(infoSenha);

        JPasswordField senhaCampo = new JPasswordField();
        senhaCampo.setBounds(100, 150, 200, 25);
        titulo.add(senhaCampo);


    }

    public void exibir(){
        titulo.setVisible(true);
    }
}
