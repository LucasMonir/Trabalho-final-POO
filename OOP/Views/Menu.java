package Views;

import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Menu extends JFrame{
    private static String[] opcoesMenu = { "", "Cadastro de títulos", "Baixa de títulos", "Relatórios", "Salvar"};
    private static JComboBox opcoes = new JComboBox<>(opcoesMenu);    
    private static JButton confirmar = new JButton("Confirmar");

    public Menu(){
        super("Menu Principal - Sistema de cobrança SGC");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(300,400));
        setResizable(false);
        setLayout(new BorderLayout());
        
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(0,1));
        p1.add(new JLabel("Selecione a operação desejada:"));
        p1.add(opcoes);

        JLabel picLabel = new JLabel();
        try {
            BufferedImage myPicture = ImageIO.read(new File("OOP\\Views\\Logo.png"));
            picLabel = new JLabel(new ImageIcon(myPicture));
            picLabel.setForeground(new Color(75, 74, 100));
            add(picLabel);
        } catch (Exception e) {
            System.out.println(e + "FILE NOT FOUND!!!!");
        }

        getContentPane().add(p1, BorderLayout.NORTH);
        getContentPane().add(picLabel);
        getContentPane().add(confirmar, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    public static int opcaoSelecionada(){
        return opcoes.getSelectedIndex();
    }

    public static void main(String[] args) {
        new Menu();
    }

    public static void setConfirmarAction(ActionListener action){
        confirmar.addActionListener(action);
    }
}
