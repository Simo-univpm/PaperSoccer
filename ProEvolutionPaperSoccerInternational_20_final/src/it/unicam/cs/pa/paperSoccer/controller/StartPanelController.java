package it.unicam.cs.pa.paperSoccer.controller;

import it.unicam.cs.pa.paperSoccer.view.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * controller che gestisce lo startPanel e la creazione delle partite
 */

public class StartPanelController {

    private View view;

    protected static int row, column;

    public StartPanelController(View view){

        this.view = view;

        view.initStartPanel();
        addStartBtn();

    }

    private void addStartBtn(){

        ActionListener startGame = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //lettura valori Jspinner
                row = (int)view.getStartpanel().getAltezza().getValue();
                column = (int)view.getStartpanel().getLarghezza().getValue();

                //player vs player
                if(view.getStartpanel().getPvp().isSelected()){
                    new InteractiveMatchController(view, row, column);
                }

                //pc vs pc
                if(view.getStartpanel().getMvm().isSelected()){
                    new RandomMatchController(view, row, column);
                }

                view.getStartpanel().dispose();

            }

        };//fine listener

        view.getStartpanel().getPlayBtn().addActionListener(startGame);

    }//fine funzione

}
