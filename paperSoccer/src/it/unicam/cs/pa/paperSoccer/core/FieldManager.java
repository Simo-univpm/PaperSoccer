package it.unicam.cs.pa.paperSoccer.core;
import java.util.HashMap;
	/**
	 * Responsabilità : geetire il campo (gestisce l'hashMap, e quindi sa dove un giocatore può
	 *  andare dalla casella di partenza
	 * 
	 */
public class FieldManager {
	/**
	 * hashMap viene utilizzato per tenere traccia del percorso della palla
	 */
	private HashMap <Cell, Cell> path = new HashMap<Cell, Cell>();
	
	
}
