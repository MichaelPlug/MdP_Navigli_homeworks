package it.uniroma1.metodologie2019.hw3;

import java.util.Optional;

/**
 * Un WordNetMapping rappresenta con un oggetto associato a due WordNet
 * tramite il quale è possibile effettuare una mappatura dei Synset
 * da un WordNet all'altro.
 * 
 * @author Spina Michele 1711821
 *
 */

public class WordNetMapping{

	private WordNet wnSource;
	private WordNet wnTarget;
	
	/**
	 * Un WordNetMapping è costruito a partite da due Wordnet.
	 * Essi rappresentano il dominio di partenza e di arrivo della funzione di mappatura
	 * @param wnSource rappresenta il dominio di partenza della funzione di mappatura
	 * @param wnTarget rappresenta il dominio di arrivo della funzione di mappatura
	 */
	public WordNetMapping(WordNet wnSource, WordNet wnTarget) {
		this.wnSource = wnSource;
		this.wnTarget = wnTarget;
	}
	
	
	/**
	 * Il metodo getMapping dato un input Synset src restiuisce il Synset con maggiore affinità
	 * secondo la funzione di mapputara.
	 * Un Synset non necessariamente è associato a un Synset corrispondente nella dominio di arrivo.
	 * In questo caso il metodo restuisce un Optional vuoto, ovvero Optiona.empty(), altrimenti
	 * un Optional con il Synset corrispondente.
	 * @param src synset da mappare
	 * @return synset a cui è mappato src
	 */
	public Optional<SynsetPairing> getMapping(Synset src) {
		if (src.getWNVersion() != wnSource.getVersion()) return Optional.empty();
		/*
		 * Se i due WordNet di WordNetMapping corrispondono, getMapping selziona come
		 * corrispondente di src, src stesso, con un punteggio di match massimo.
		 * 
		 * Quest'operazione favorisce i tempi di esecuzione di getMapping
		 */
		if (wnSource == wnTarget)
			return Optional.of(new SynsetPairing(src, src, 1.0));			
		Synset trg = null;
		double matchScore = 0;
		/*
		 * Per ogni Synset viene in wnTargt, viene calcolato il punteggio di match,
		 * rappresentato da matchscore. Se  tale punteggio è maggiore strettamente di 0 
		 * e di tutti punteggi dei Synset già analizzati, viene salvato in trg
		 */	

		for (Synset s : wnTarget) {
			if (getMatchScore(src, s) > matchScore) {	
				matchScore = getMatchScore(src, s);
					trg = s;
				}
			if (matchScore == 1) return Optional.of(new SynsetPairing (src, trg, matchScore));
		}
		
		/**
		 * Se il punteggio di matchScore è maggiore di zero, e quindi trq non è null,
		 * viene costruite e restituito un Optional con un SynsetPairing dai valori di
		 * src, trq e matchScore.
		 * In caso contrario viene restituito un Optional.empty
		 */
		if (matchScore > 0) return Optional.of(new SynsetPairing (src, trg, matchScore));
		else return Optional.empty();
	}

	
	/**
	 * Il metodo costiuisce un algoritmo per il calcolo del puntegigo di match fra due Synset.
	 * Il valore del punteggio è compreso tra 0 e 1.
	 * Il valore è calcolato sulla base del numero di sinonimi in comune tra i due WordNet e 
	 * la similarità dei due glossari.
	 * Due Sysnet avranno punteggio pari a zero se non hanno alcuno sinonimo in comune e/o non
	 * c'è similità fra i due glossari e/o sono associati a POS diversi.
	 * @param src synset di partenza
	 * @param trg synset di cui verificare la similarità
	 * @return matchScore compreso tra 0 e 1.
	 */
	public static double getMatchScore(Synset src, Synset trg) {
		/*
		 *  Il metodo verifica che i due synset abbiano lo stesso POS, e che quindi rappresentino
		 *  la stessa parte del discos. In caso contrario restituisce un matchScore pari a zero.
		 */
		if (src.getPOS() != trg.getPOS()) return 0; 
		double matchScore = 0;
		double i;
		/**
		 * Tramite la dimensione dei due synset si un peso alla singola corrispondeza di sinonimi
		 */
		if (src.size() > trg.size()) i = 1.0 / src.size();
		else i = 1.0 / trg.size();	
		
		/**
		 * Se un sinonimo è presente in entrambi i Synset allora viene aumentato il 
		 * valore del matchScore di un peso i.
		 */
		
		for (String word : src) 
			if (trg.contains(word)) matchScore += i;
		
		/**
		 * Se il matchScore è pari a zero, ovvero non si hanno sinonimi in comune, viene restituito il suo valore
		 * 
		 * Questa riga di codice non è STRETTAMENTE necessaria, è stata inserita per aumentare l'efficenza del metodo.
		 */
		if (matchScore == 0) return matchScore;
		
		/*
		 * Si calcola la similirità tra i glossari dei due WordNet dandogli un valore
		 * da 0 a 1.
		 * 
		 * Se e solo se i due glossari sono identici, allora la similarità è pari a 1.
		 * Altrimenti è calcolata sulla base le numero di parole di lunghezza strettamene
		 * maggiore di 5 contenute in entrambi i WordNet
		 */
		if (!src.getGloss().equals(trg.getGloss())) {
			String[] glossaWords = src.getGloss().split(" ");
			int k = 0;
			int k2 = 0;
			for (int j = 0; j < glossaWords.length; j++)
				if (glossaWords[j].length() > 5)  {
					k++;
					if (trg.getGloss().contains(glossaWords[j])) {
						k2++;
					}
				}
				matchScore = k == 0 ? 0 : (matchScore*k2)*0.999/k; 
		}
		return matchScore;
	}
}
