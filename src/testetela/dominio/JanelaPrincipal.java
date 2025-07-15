package testetela.dominio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaPrincipal {
    private JFrame frame;
    private JTextField campoTexto;
    private JButton botaoMostrar;

    public JanelaPrincipal() {
        inicializarComponentes();
        configurarEventos();
    }

    private void inicializarComponentes() {
        frame = new JFrame("Interface Interativa - POO");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel rotulo = new JLabel("Digite algo:");
        rotulo.setBounds(30, 30, 100, 25);
        frame.add(rotulo);

        campoTexto = new JTextField();
        campoTexto.setBounds(130, 30, 200, 25);
        frame.add(campoTexto);

        botaoMostrar = new JButton("Mostrar");
        botaoMostrar.setBounds(130, 70, 100, 30);
        frame.add(botaoMostrar);
    }

    private void configurarEventos() {
        botaoMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textoDigitado = campoTexto.getText();
                JOptionPane.showMessageDialog(frame, "Você digitou: " + textoDigitado);
            }
        });
    }

    public void exibir() {
        frame.setVisible(true);
    }
}