package codmain.frame.dominio;

import javax.swing.*;
import java.awt.*;

public class CadastroFrame {
    private JFrame rotulo;

    private JLabel textoUsuario;
    private JTextField campoUsuaro;

    private JLabel textoSenha;
    private JTextField campoSenha;
    public CadastroFrame() {
        startFrameMain();
    }

    public void startFrameMain(){
        rotulo = new JFrame("Cadastro");
        rotulo.setSize(400,500);
        rotulo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rotulo.setLayout(null);

        textoUsuario = new JLabel("Escolha um nome de usuário: ");
        textoUsuario.setBounds(30, 30, 100, 25);
        textoUsuario.add(rotulo);

        campoUsuaro = new JTextField();
        campoUsuaro.setBounds(60, 30, 200, 25);
        campoUsuaro.add(campoUsuaro);
    }

    public void exibir(){
        rotulo.setVisible(true);
    }
}
