package Controllers;

import Views.*;
import Views.CadastroTitulos.Alterar;
import Views.CadastroTitulos.Consulta;
import Views.CadastroTitulos.Excluir;
import Views.CadastroTitulos.Incluir;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroController {
    CadastroTitulo cadastroTitulo = new CadastroTitulo();

    public CadastroController(CadastroTitulo cadastroTitulo) {
        this.cadastroTitulo = cadastroTitulo;

        cadastroTitulo.setAcaoInclusao(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
               
                Incluir incluir = new Incluir();
               
                incluir.setAcaoSalvar( new ActionListener(){

			        @Override
				    public void actionPerformed(ActionEvent e) {
					    //todo
                    }
                    
                }); 

                incluir.setAcaoSair( new ActionListener(){

			        @Override
				    public void actionPerformed(ActionEvent e) {
					    //todo
				    }
                }); 
    
            };
            
        });

        cadastroTitulo.setAcaoAlteracao(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Alterar alterar = new Alterar();

                alterar.setAcaoAlterar( new ActionListener(){

			        @Override
				    public void actionPerformed(ActionEvent e) {
					    //todo
                    }
                    
                });

                alterar.setAcaoSair( new ActionListener(){

			        @Override
				    public void actionPerformed(ActionEvent e) {
					    //todo
				    }
                }); 
            }

        });

        cadastroTitulo.setAcaoConsulta(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               Consulta consulta = new Consulta();
               
                consulta.setAcaoConsultar( new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //todo
                    }

                }); 

                consulta.setAcaoSair( new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //todo
                    }

                }); 
            }

        });

        cadastroTitulo.setAcaoExclusao(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Excluir excluir = new Excluir();

                excluir.setAcaoExcluir( new ActionListener(){

			        @Override
				    public void actionPerformed(ActionEvent e) {
					    //todo
                    }
                    
                }); 

                excluir.setAcaoSair( new ActionListener(){

			        @Override
				    public void actionPerformed(ActionEvent e) {
					    //todo
                    }
                    
                }); 
            }

        });

        cadastroTitulo.setAcaoSair(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });
    }
}
