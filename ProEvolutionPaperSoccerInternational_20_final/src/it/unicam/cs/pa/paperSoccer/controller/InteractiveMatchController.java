package it.unicam.cs.pa.paperSoccer.controller;

import it.unicam.cs.pa.paperSoccer.model.core.Cell;
import it.unicam.cs.pa.paperSoccer.model.match.InteractiveMatch;
import it.unicam.cs.pa.paperSoccer.view.View;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * controller che gestisce il match player vs player
 */
class InteractiveMatchController {

    private View view;
    private InteractiveMatch interactiveMatch;

    private int appY, appX;
    private Cell clickedCell;

    InteractiveMatchController(View view, int row, int column){

        this.view = view;
        this.interactiveMatch = new InteractiveMatch(row, column);
        this.view.initCampo(row, column);

        addClickedCellUpdater();
        addInteractiveListener();

    }

    private void addClickedCellUpdater(){

        JPanel ghiera = view.getCampo().getGhiera();

        MouseListener clickListener = new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {

                appY = ghiera.getComponentAt(e.getX(), e.getY()).getY();
                appX = ghiera.getComponentAt(e.getX(), e.getY()).getX();

                clickedCell = interactiveMatch.getField().getCell(appY/50,appX/50);

            }
        };

        ghiera.addMouseListener(clickListener);

    }

    private void addInteractiveListener(){

        MouseListener clickListener = new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {

                //gioco e aggiornamento grafica
                if(interactiveMatch.checkDest(clickedCell)){

                    interactiveMatch.playInteractive(clickedCell);
                    view.getCampo().getGlass().draw(appY, appX);
                    view.getCampo().cambioturno(interactiveMatch.getCurrentPlayer());

                } else {

                    System.out.println("invalid cell");
                    return;

                }

                //creazione dell' end panel
                if(interactiveMatch.getReferee().isEnd(interactiveMatch.getCurrentPlayer()))
                    new EndPanelController(view, interactiveMatch);

            }

        };

        //aggiunta di clickListener a ghiera
        view.getCampo().getGhiera().addMouseListener(clickListener);

    }


}
