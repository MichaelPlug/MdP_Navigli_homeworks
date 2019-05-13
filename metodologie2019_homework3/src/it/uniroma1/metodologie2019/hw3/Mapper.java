package it.uniroma1.metodologie2019.hw3;

	/**
	 * La classe Mapper è costituita da un unico metodo tramite il quale è 
	 * possibile ottenere un oggetto mappante tra due WordNet
	 * @author Spina Michele 1711821
	 *
	 */
public class Mapper {
	
	/**
	 * Il metodo restituisce l'oggetto per mappare i Synset da wnSource a wnTarget
	 * @param wnSource dominio di partenza nella mappatura
	 * @param wnTarget dominio di arrivo nella mappatura
	 * @return istanche WordNetMapping che permette la mappatura tra i due WordNet
	 */
	public static WordNetMapping map(WordNet wnSource, WordNet wnTarget) {
	//	if (String )
		return new WordNetMapping(wnSource, wnTarget);
	}
}