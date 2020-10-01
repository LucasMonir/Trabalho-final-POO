import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;

public class Menu extends JFrame{
    private static final long serialVersionUID = 1L;

    public Menu(){
        super("XYZ COMERCIO DE PRODUTOS LTDA: SISTEMA DE COBRANÇA");
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 300));
        JButton cadastroDeTitulos = new JButton("Cadastro de títulos");
        JButton baixaDeTitulos = new JButton("Baixa de títulos");
        JButton relatorios = new JButton("Relatórios");
        JButton salvar = new JButton("Salvar");
        JButton sair = new JButton("Sair");

        JPanel p1 = new JPanel();
        p1.setLayout(new GridBagLayout());

        JPanel p2 = new JPanel();
        p2.setLayout(new GridBagLayout());
        p2.setBorder(new EmptyBorder( 10, 10, 10 ,10));

        p1.add(new JLabel("Menu principal"));
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

    public GridBagConstraints setSpacing(){
        GridBagConstraints spacingBetweenButtons = new GridBagConstraints();
        spacingBetweenButtons.weightx = 1;
        spacingBetweenButtons.weighty = .10;
        spacingBetweenButtons.insets = new Insets(2, 0, 2, 0);
        spacingBetweenButtons.gridwidth = GridBagConstraints.REMAINDER;
        spacingBetweenButtons.fill = GridBagConstraints.BOTH;
        return spacingBetweenButtons;
    }

    public static void main(String[] args) {
        new Menu();
    }
}