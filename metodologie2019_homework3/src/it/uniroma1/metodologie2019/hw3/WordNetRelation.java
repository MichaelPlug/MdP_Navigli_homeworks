package it.uniroma1.metodologie2019.hw3;

/**
 * Interfaccia rappresentante i tipi di relazione di un WordNet
 * @author Spina Michele 1711821
 *
 */

public interface WordNetRelation {
		
	/**
	 * Restituisce la codifica del tipo di relazione
	 * @return codifca di un'istanza di WordNetRelation
	 */
	public String getEncoding();
	/**
	 * Restituisce la parte del discorso relativa al genere di relazione
	 * @return parte del discorso associata alla relazione
	 */
	public POS getPos();
}
