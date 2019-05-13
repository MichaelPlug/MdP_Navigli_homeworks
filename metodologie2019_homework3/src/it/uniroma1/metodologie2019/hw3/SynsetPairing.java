package it.uniroma1.metodologie2019.hw3;

/**
 * Un'istanza di SynsetPairing rappresenta la mappatura
 * tra due Synset, a cui � associato un matchScore
 * (punteggio tra 0 e 1 in base alla similir� tra i due Synset)
 * 
 * @author Spina Michele 1711821
 *
 */
public class SynsetPairing {
	
	private Synset src;
	private Synset trg;
	private double matchScore;
	
	/**
	 * Viene costruito un SynsetPairing fornendo in input
	 * src, trg, e matchScore.
	 * 
	 * @param src Synset di partenza
	 * @param trg Synset di arrivo
	 * @param matchScore Punteggio del match tra i due synset
	 */
	public SynsetPairing(Synset src, Synset trg, double matchScore) {
		this.src = src;
		this.trg = trg;
		this.matchScore = matchScore;
	}
	/**
	 * Il metodo restituisce il Synset di partenza
	 * @return Synset di partenza
	 */
	public Synset getSource() {
		return src;
	}
	/**
	 * Il metodo restituisce il Synset destinazione, ovvero l'immagine del 
	 * Synset sorgente secondo la funzione di mappatura
	 * @return Synset di arrivo
	 */
	public Synset getTarget() {
		return trg;
	}
	/**
	 * Il metodo restituisce il matchScore assegnato alla coppia di Synset, 
	 * esso rapresenta l'affinit� fra i due Synset ed � un valore strettamente
	 * maggiore di 0 e minore di 1.
	 * @return matchScore punteggio del match fra i Synset
	 */
	public double getScore() {
		return matchScore;
	}
}
