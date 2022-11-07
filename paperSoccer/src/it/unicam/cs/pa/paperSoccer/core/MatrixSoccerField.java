package it.unicam.cs.pa.paperSoccer.core;

public class MatrixSoccerField implements SoccerField {
	private Cell[][] matrix;
	private int length;
	private int height;
	
	
	public MatrixSoccerField (int length, int height) {
		this.length=length;
		this.height=height;
		this.matrix = new Cell[length][height];
	}


	@Override
	public boolean move(Cell c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isValid(Cell c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void place(Cell c, Ball b) {
		b.setX(c.getRow());
		b.setY(c.getColumn());		
	}
}
