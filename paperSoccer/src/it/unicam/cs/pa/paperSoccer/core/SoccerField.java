package it.unicam.cs.pa.paperSoccer.core;

/**
	 * Responsabilità: gestire il campo di battaglia 
	 * 
	 * @author andreadiubaldo
	 *
	 */

public interface SoccerField {
	/**
	 * Effettua la mossa. Restituisce true se la mossa viene effettuata, false se la mossa
	 * non viene effettuata.
	 */
	public boolean move(Cell c);
	
	/**
	 * Verifica se la mossa è valida.
	 */
	public boolean isValid(Cell c);
	
	/**
	 * imposta la casella centrale del campo per il calcio di inizio
	 */
	public void place(Cell c, Ball b);

}
