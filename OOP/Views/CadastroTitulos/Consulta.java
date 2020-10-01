package Views.CadastroTitulos;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;

public class Consulta extends JFrame{

    private static final long serialVersionUID = 1L;
    private JTextField nome = new JTextField();
    private JTextField cpf = new JTextField();
    
    public Consulta(){
        super("XYZ COMERCIO DE PRODUTOS LTDA");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
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

        getContentPane().add(p1);
        getContentPane().add(p2);
        pack();
        setVisible(true);
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

    public static void main(String[] args) {
        new Consulta();    
    }
}
