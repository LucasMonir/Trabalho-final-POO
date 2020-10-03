package Views;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;

public class Relatorio extends JFrame{
    
    private static final long serialVersionUID = 1L;
    private JButton clientesEmDebito = new JButton("Clientes em débito");
    private JButton balancoDeInadimplencia = new JButton("Balanço de inadimplência");
    private JButton avisosAoCliente = new JButton("Avisos ao cliente");
    private JButton sair = new JButton("Sair");

    public Relatorio(){
        super("XYZ COMERCIO DE PRODUTOS LTDA");
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 300));
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p1 = new JPanel();
        p1.setLayout(new GridBagLayout());
        p1.add(new JLabel("Relatórios"));

        JPanel p2 = new JPanel();
        p2.setLayout(new GridBagLayout());
        p2.setBorder(new EmptyBorder(10, 10, 10, 10));
        p2.add(clientesEmDebito, setSpacing());
        p2.add(balancoDeInadimplencia, setSpacing());
        p2.add(avisosAoCliente, setSpacing());
        p2.add(sair, setSpacing());

        getContentPane().add(p1, BorderLayout.NORTH);
        getContentPane().add(p2);
        pack();
        setVisible(true);
    }

    public GridBagConstraints setSpacing() {
        GridBagConstraints spacingBetweenButtons = new GridBagConstraints();
        spacingBetweenButtons.weightx = 1;
        spacingBetweenButtons.weighty = .10;
        spacingBetweenButtons.insets = new Insets(5, 0, 5, 0);
        spacingBetweenButtons.gridwidth = GridBagConstraints.REMAINDER;
        spacingBetweenButtons.fill = GridBagConstraints.BOTH;
        return spacingBetweenButtons;
    }

    public void setAcaoClientesEmDebito(ActionListener action) {
        clientesEmDebito.addActionListener(action);
    }

    public void setAcaoBalancoDeInadimplencia(ActionListener action) {
        balancoDeInadimplencia.addActionListener(action);
    }

    public void setAcaoAvisoAoCliente(ActionListener action) {
        avisosAoCliente.addActionListener(action);
    }

    public void setAcaoSair(ActionListener action) {
        sair.addActionListener(action);
    }
}