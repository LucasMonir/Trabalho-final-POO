package Views;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;

public class Menu extends JFrame {
    private static final long serialVersionUID = 1L;
    private JButton cadastroDeTitulos = new JButton("Cadastro de títulos");
    private JButton baixaDeTitulos = new JButton("Baixa de títulos");
    private JButton relatorios = new JButton("Relatórios");
    private JButton salvar = new JButton("Salvar");
    private JButton sair = new JButton("Sair");

    public Menu() {
        super("XYZ COMERCIO DE PRODUTOS LTDA");
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 300));
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel p1 = new JPanel();
        p1.setLayout(new GridBagLayout());
        p1.add(new JLabel("Menu principal: Sistema de cobrança"));

        JPanel p2 = new JPanel();
        p2.setLayout(new GridBagLayout());
        p2.setBorder(new EmptyBorder(10, 10, 10, 10));
        p2.add(cadastroDeTitulos, setSpacing());
        p2.add(baixaDeTitulos, setSpacing());
        p2.add(relatorios, setSpacing());
        p2.add(salvar, setSpacing());
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

    public void setAcaoCadastroDeTitulos(ActionListener action) {
        cadastroDeTitulos.addActionListener(action);
    }

    public void setAcaoBaixaDeTitulos(ActionListener action) {
        baixaDeTitulos.addActionListener(action);
    }

    public void setAcaoRelatorios(ActionListener action) {
        relatorios.addActionListener(action);
    }

    public void setAcaoSalvar(ActionListener action) {
        salvar.addActionListener(action);
    }

    public void setAcaoSair(ActionListener action) {
        sair.addActionListener(action);
    }
}