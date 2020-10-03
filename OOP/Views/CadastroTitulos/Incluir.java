package Views.CadastroTitulos;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;

public class Incluir extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField nome = new JTextField();
    private JTextField cpf = new JTextField();
    private JTextField debito = new JTextField();
    private JTextField dataVencimento = new JTextField();
    private JButton salvar = new JButton("Salvar");
    private JButton sair = new JButton("Sair");

    public Incluir() {
        super("XYZ COMERCIO DE PRODUTOS LTDA");
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 300));
        setResizable(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        

        JPanel p1 = new JPanel();
        p1.setLayout(new GridBagLayout());
        p1.add(new JLabel("Incluir título de cobrança"));

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(0, 1));
        p2.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        p2.add(new JLabel("Nome do cliente:"));
        p2.add(nome);

        p2.add(new JLabel("CPF:"));
        p2.add(cpf);

        p2.add(new JLabel("Débito:"));
        p2.add(debito);

        p2.add(new JLabel("Data de vencimento:"));
        p2.add(dataVencimento);

        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout());
        
        p3.add(salvar);
        p3.add(sair);

        getContentPane().add(p1, BorderLayout.NORTH);
        getContentPane().add(p2);
        getContentPane().add(p3, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    public JTextField getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(JTextField dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public JTextField getDebito() {
        return debito;
    }

    public void setDebito(JTextField debito) {
        this.debito = debito;
    }

    public JTextField getCpf() {
        return cpf;
    }

    public void setCpf(JTextField cpf) {
        this.cpf = cpf;
    }

    public JTextField getNome() {
        return nome;
    }

    public void setNome(JTextField nome) {
        this.nome = nome;
    }

    public void setAcaoSalvar(ActionListener action) {
        salvar.addActionListener(action);
    }

    public void setAcaoSair(ActionListener action) {
        sair.addActionListener(action);
    }
}
