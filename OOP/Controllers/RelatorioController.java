package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Views.Relatorio;
import Views.Relatorios.AvisosAoCLiente;
import Views.Relatorios.BalancoInadimplencia;
import Views.Relatorios.ClientesEmDebito;

public class RelatorioController {
    Relatorio relatorio = new Relatorio();

    public RelatorioController(Relatorio relatorio) {
        this.relatorio = relatorio;

        relatorio.setAcaoAvisoAoCliente(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                AvisosAoCLiente avisosAoCLiente = new AvisosAoCLiente();

                avisosAoCLiente.setAcaoGerarAviso(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TO DO
                    }

                }); 

                avisosAoCLiente.setAcaoSair(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TO DO
                    }

                }); 
            }
            
        });

        relatorio.setAcaoBalancoDeInadimplencia(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                BalancoInadimplencia balancoInadimplencia = new BalancoInadimplencia();

                balancoInadimplencia.setAcaoExibirBlanco(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TO DO

                    }

                });

                balancoInadimplencia.setAcaoSair(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TO DO

                    }

                });
            }

        });

        relatorio.setAcaoClientesEmDebito(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                ClientesEmDebito clientesEmDebito = new ClientesEmDebito();

                clientesEmDebito.setAcaoExibirClientesEmDebito(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TO DO

                    }

                });

                clientesEmDebito.setAcaoSair(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TO DO

                    }

                });
            }

        });
    }
}
