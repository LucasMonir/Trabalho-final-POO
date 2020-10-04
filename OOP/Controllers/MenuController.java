package Controllers;

import Views.CadastroTitulo;
import Views.Menu;
import Views.Relatorio;
import Models.Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Set;

import javax.swing.JOptionPane;

public class MenuController {
    Menu menu = new Menu();

    public MenuController(Set<Cliente> listaClientes){

        menu.setAcaoCadastroDeTitulos(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                new CadastroController(new CadastroTitulo());
            }

        });

        menu.setAcaoBaixaDeTitulos(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }

        });

        menu.setAcaoRelatorios(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                new RelatorioController(new Relatorio());

            }

        });

        menu.setAcaoSalvar(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                // ??????????????????????
                if (!listaClientes.isEmpty()) {
                    try {
                        String date = new SimpleDateFormat("yyy-MM-dd-HH-mm-ssSS").format(new Date()); 
                        FileWriter escritor=new FileWriter("C:\\Windows\\Temp\\Log-"+date+".txt"); //diretório especificado
                        String dadosSalvos="DADOS SALVOS:"+date;
                        
                        for (Cliente cliente : listaClientes) {
                            dadosSalvos+=" \n----------------------------------------- \n"
                            + cliente.consultaTitulo()+"\n";
                        }
                        
                        escritor.write(dadosSalvos);
                        escritor.close();
                        JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
                    } catch (IOException ex) {
                        System.out.println("Problema ao criar arquivo ou diretório, (stackTrace:" + ex.getStackTrace() + ")");
                    }
                } else {
                    System.out.println("Lista vazia, impossivel salvar");
                }

            }

        });

        menu.setAcaoSair(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                System.exit(0);

            }
        });

    }
}
