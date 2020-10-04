package Views;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;

public class CadastroTitulo extends JFrame {
    private static final long serialVersionUID = 1L;
    private JButton inclusao = new JButton("Inclusão");
    private JButton alteracao = new JButton("Alteração");
    private JButton consulta = new JButton("Consulta");
    private JButton exclusao = new JButton("Exclusão");
    private JButton sair = new JButton("Sair");

    public CadastroTitulo() {
        super("XYZ COMERCIO DE PRODUTOS LTDA");
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 300));
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel p1 = new JPanel();
        p1.setLayout(new GridBagLayout());
        p1.add(new JLabel("Menu de cadastro"));

        JPanel p2 = new JPanel();
        p2.setLayout(new GridBagLayout());
        p2.setBorder(new EmptyBorder(10, 10, 10, 10));
        p2.add(inclusao, setSpacing());
        p2.add(alteracao, setSpacing());
        p2.add(consulta, setSpacing());
        p2.add(exclusao, setSpacing());
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

    public void setAcaoInclusao(ActionListener action) {
        inclusao.addActionListener(action);
    }

    public void setAcaoAlteracao(ActionListener action) {
        alteracao.addActionListener(action);
    }

    public void setAcaoConsulta(ActionListener action) {
        consulta.addActionListener(action);
    }

    public void setAcaoExclusao(ActionListener action) {
        exclusao.addActionListener(action);
    }

    public void setAcaoSair(ActionListener action) {
        sair.addActionListener(action);
    }
}