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
    }

    public void exibir(){
        rotulo.setVisible(true);
    }
}
