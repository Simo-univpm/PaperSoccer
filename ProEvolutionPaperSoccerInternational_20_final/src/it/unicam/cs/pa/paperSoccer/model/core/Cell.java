package it.unicam.cs.pa.paperSoccer.model.core;

import java.util.ArrayList;

public class Cell {

    private CellLocation loc; // identifica la cella aka coordinate
    private ArrayList<Directions> arrayLoc = new ArrayList<>(); // spostamenti effettuati "sopra" la cella

    //============================================================================//
    //costruttori

    public Cell(int row, int column) {
        this(new CellLocation(row, column));
    }

    public Cell(CellLocation loc) {
        this.loc = loc;
    }

    //============================================================================//

    public boolean arrayLocIsFull() {

        if (this.getArrayLoc().size() == 8) {
            return true;
        } else {
            return false;
        }

    }

    void addListDirections(Directions... d) {

        for (Directions l : d) {
            this.getArrayLoc().add(l);
        }

    }

    public Directions matchDirection(Cell dest) {

        int startRow = this.getLoc().getRow();
        int startCol = this.getLoc().getColumn();

        int destRow = dest.getLoc().getRow();
        int destCol = dest.getLoc().getColumn();


        for (Directions d : Directions.values()) {
            if(d.getAdjacentIndex(0)== destRow-startRow && d.getAdjacentIndex(1)==destCol-startCol) {
                return d;
            }
        }
        return null;

    }

    //============================================================================//

    public CellLocation getLoc() {
        return loc;
    }

    public ArrayList<Directions> getArrayLoc() {
        return arrayLoc;
    }


}
