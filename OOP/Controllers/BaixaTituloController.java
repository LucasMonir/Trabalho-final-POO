package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Views.BaixaTitulo;

public class BaixaTituloController {
    BaixaTitulo baixaTitulo = new BaixaTitulo();

    public BaixaTituloController(BaixaTitulo baixaTitulo) {
        this.baixaTitulo = baixaTitulo;

        baixaTitulo.setAcaoPesquisar(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }

        });

        baixaTitulo.setAcaoDarBaixa(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }

        });

        baixaTitulo.setAcaoSair(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }

        });
    }
}
