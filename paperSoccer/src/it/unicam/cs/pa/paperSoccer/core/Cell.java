package it.unicam.cs.pa.paperSoccer.core;

public class Cell {
	private boolean invalidFlag;
	private final int row;
	private final int column;
	
	public Cell(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public boolean isInvalidFlag() {
		return invalidFlag;
	}

	
	public void setInvalidFlag(boolean invalidFlag) {
		this.invalidFlag = invalidFlag;
	}

	public String toString (Object o) {
		return "[row=" + row + ", column=" + column + "]";
	}
}
