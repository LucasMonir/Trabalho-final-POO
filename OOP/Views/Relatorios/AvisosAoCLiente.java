package Views.Relatorios;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;


public class AvisosAoCLiente extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField cpf = new JTextField();
    private JButton gerarAviso = new JButton("Gerar Aviso");
    private JButton sair = new JButton("Sair");

    public AvisosAoCLiente(){
        super("XYZ COMERCIO DE PRODUTOS LTDA");
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 200));
        setResizable(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        JPanel p1 = new JPanel();
        p1.setLayout(new GridBagLayout());
        p1.add(new JLabel("Avisos ao cliente"));

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(0, 1));
        p2.setBorder(new EmptyBorder(10, 10, 10, 10));

        p2.add(new JLabel("CPF:"));
        p2.add(cpf);

        JPanel p3 = new JPanel(); 
        p3.setLayout(new FlowLayout());
        
        p3.add(gerarAviso);
        p3.add(sair);

        getContentPane().add(p1, BorderLayout.NORTH);
        getContentPane().add(p2);
        getContentPane().add(p3, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    public void setAcaoGerarAviso(ActionListener action){
        gerarAviso.addActionListener(action);
    }

    public void setAcaoSair(ActionListener action){
        sair.addActionListener(action);
    }
}
