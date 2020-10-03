package Views;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;

public class BaixaTitulo extends JFrame{
    private static final long serialVersionUID = 1L;
    private JTextField cpf = new JTextField();
    private JTextField valor = new JTextField();
    private JButton pesquisar = new JButton("Pesquisar");
    private JButton darBaixa = new JButton("Dar baixa");
    private JButton sair = new JButton("Sair");
    
    public BaixaTitulo(){
        super("XYZ COMERCIO DE PRODUTOS LTDA");
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 200));
        setResizable(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        JPanel p1 = new JPanel();
        p1.setLayout(new GridBagLayout());
        p1.add(new JLabel("Baixa de título de cobrança"));

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(0, 1));
        p2.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        p2.add(new JLabel("CPF:"));
        p2.add(cpf);

        p2.add(new JLabel("Valor pago:"));
        p2.add(valor);

        JPanel p3 = new JPanel(); 
        p3.setLayout(new FlowLayout());
        
        p3.add(pesquisar);
        p3.add(darBaixa);
        p3.add(sair);

        getContentPane().add(p1, BorderLayout.NORTH);
        getContentPane().add(p2);
        getContentPane().add(p3, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }
    
    public JTextField getCpf() {
        return cpf;
    }

    public void setCpf(JTextField cpf) {
        this.cpf = cpf;
    }

    public void setAcaoPesquisar(ActionListener action){
        pesquisar.addActionListener(action);
    }

    public void setAcaoDarBaixa(ActionListener action) {
        darBaixa.addActionListener(action);
    }

    public void setAcaoSair(ActionListener action) {
        sair.addActionListener(action);
    }
}
