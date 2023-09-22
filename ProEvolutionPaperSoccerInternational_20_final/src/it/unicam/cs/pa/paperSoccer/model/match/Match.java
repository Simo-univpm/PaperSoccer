package it.unicam.cs.pa.paperSoccer.model.match;

import it.unicam.cs.pa.paperSoccer.model.core.Ball;
import it.unicam.cs.pa.paperSoccer.model.core.Cell;
import it.unicam.cs.pa.paperSoccer.model.core.Directions;
import it.unicam.cs.pa.paperSoccer.model.core.MatrixSoccerField;
import it.unicam.cs.pa.paperSoccer.model.ruleSet.DefaultRuleSet;

/**
 * Questa classe definisce il modello di match generico, con i due giocatori, il campo, la palla e l'arbitro
 */

public abstract class Match {

    //id per alternare i turni
    static final int PLAYER1 = 0;
    static final int PLAYER2 = 1;
    int currentPlayer;

    MatrixSoccerField field;
    Ball ball;

    DefaultRuleSet referee = new DefaultRuleSet();

    //============================================================================

    int otherPlayer() {
        return (currentPlayer + 1) % 2;
    }

    //===========================================================================
    //overload

    void updateCellsArrayLoc(Cell dest){

        Cell start = field.getCell(ball.getY(), ball.getX());

        try{

            start.getArrayLoc().add(start.matchDirection(dest));
            dest.getArrayLoc().add(start.matchDirection(dest).getOppositeDirection());

        }catch(Exception e){
            System.out.println("can't update dest -> " + dest.getLoc().toString() + " array list");
        }

    }

    void updateCellsArrayLoc(Directions dir){

        Cell start = field.getCell(ball.getY(), ball.getX());
        Cell dest  = field.getCell(ball.getY() + dir.getAdjacentIndex(0), ball.getX() + dir.getAdjacentIndex(1));

        try{

            start.getArrayLoc().add(dir);
            dest.getArrayLoc().add(dir.getOppositeDirection());

        }catch(Exception e){
            System.out.println("can't update dest -> " + dest.getLoc().toString() + " array list");
        }

    }

    //============================================================================
    //getters e setters

    public Ball getBall() {
        return ball;
    }

    public MatrixSoccerField getField() {
        return field;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public DefaultRuleSet getReferee() {
        return referee;
    }

    //============================================================================

}
