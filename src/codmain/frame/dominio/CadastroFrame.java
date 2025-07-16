package codmain.frame.dominio;

import javax.swing.*;
import java.awt.*;

public class CadastroFrame {
    private JFrame rotulo;

    public CadastroFrame() {
        rotulo = new JFrame("Cadastro");
        rotulo.setSize(400, 500);
        rotulo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rotulo.setLayout(new GridBagLayout());

        startFrameMain();
    }

    public void startFrameMain(){


        JLabel infoUsuario = new JLabel("Escolha um nome de usuário:");
        infoUsuario.setBounds(115, 40, 180, 25);
        rotulo.add(infoUsuario);

        JTextField campoUsuario = new JTextField();
        campoUsuario.setBounds(100, 70, 200, 25);
        rotulo.add(campoUsuario);

        JLabel infoSenha = new JLabel("Escolha uma senha:");
        infoSenha.setBounds(140, 120, 150, 25);
        rotulo.add(infoSenha);

        JPasswordField senhaCampo = new JPasswordField();
        senhaCampo.setBounds(100, 150, 200, 25);
        rotulo.add(senhaCampo);


    }

    public void exibir(){
        rotulo.setVisible(true);
    }
}
