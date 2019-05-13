package it.uniroma1.metodologie2019.hw3;

/**
 * La classe POS rappresenta le parti del discorso.
 * A ogni parte del discorso è associata una costante enumerativa.
 * @author Spina Michele 1711821
 *
 */

public enum POS {
	NOUN ('n'),
	VERB ('v'),
	ADJECTIVE ('a'),
	ADVERB ('r');
	
	private char encoding;
	
	/**
	 * Viene salvata la codifica in stringa
	 *  del tipo di relazione
	 * @param encoding
	 */
	POS(char encoding){
		this.encoding = encoding;
	}
	
	
	/**
	 * Il metodo applicato ad uno degli oggetti di type
	 * restituisce un intero da utilizzare per la codica
	 * dell'hashcode
	 * 
	 * @return codifica della relazione
	 */
	public char getEncoding() {
		return encoding;
	}
	
	
	/**
	 * Dato un inputo un char, restituisci la costante
	 * enumerativa con il valore encoding equivalente
	 * 
	 * Se l'input è s, e quindi corrisponde a un aggettivo
	 * satellite, lo converto in a per associarlo un aggettivo
	 * semplice.
	 * @param encoding codifica della parte del discorso
	 * @return relazione associata ad encoding
	 */
	public static POS getType(char encoding){
		if (encoding == 's') encoding = 'a'; // L'encoding di un aggettevi satellita è convertito in quello di un aggettivo semplice.
		for(POS e: POS.values()) {
		    if(e.encoding == encoding) {
		      return e;
		      }
		}
		return null;// not found
	}
}