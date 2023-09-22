package it.unicam.cs.pa.paperSoccer.model.match;

import it.unicam.cs.pa.paperSoccer.model.core.Ball;
import it.unicam.cs.pa.paperSoccer.model.core.Cell;
import it.unicam.cs.pa.paperSoccer.model.core.MatrixSoccerField;
import it.unicam.cs.pa.paperSoccer.model.core.Size;
import it.unicam.cs.pa.paperSoccer.model.player.InteractivePlayer;

public class InteractiveMatch extends Match {

    private InteractivePlayer[] players = new InteractivePlayer[2];

    public InteractiveMatch(int row, int column){

        currentPlayer = PLAYER1;

        players[0] = new InteractivePlayer(PLAYER1, "Player 1", referee);
        players[1] = new InteractivePlayer(PLAYER2, "Player 2", referee);

        field = new MatrixSoccerField(new Size(row, column));
        ball = new Ball(row/2, column/2);

        referee.setBall(ball);
        referee.setField(field);

    }

    public void playInteractive(Cell dest){

        if(players[currentPlayer].getMoves() > 0){

            //aggiornamento direzioni celle
            updateCellsArrayLoc(dest);

            //spostamento palla
            players[currentPlayer].moveBall(ball, dest);

            //rimbalzo palla
            if(referee.checkEdge(dest))players[currentPlayer].increaseMoves();

            players[currentPlayer].decreaseMoves();

            //cambio turni giocatori
            if(players[currentPlayer].getMoves() == 0){

                players[currentPlayer].increaseMoves();
                currentPlayer = otherPlayer();

            }

        }

    }

    public boolean checkDest(Cell dest){

        //ignora i click dopo la creazione dell' end panel
        if(referee.isEnd(currentPlayer)) return false;

        //check direzione non disponibile
        if( ! referee.checkMove(dest)) return false;

        //non salta il turno se si clicca la palla
        if(dest.getLoc() == field.getCell(ball.getY(), ball.getX()).getLoc()) return false;

        return true;

    }

}
