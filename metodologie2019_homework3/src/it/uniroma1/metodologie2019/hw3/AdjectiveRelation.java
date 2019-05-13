package it.uniroma1.metodologie2019.hw3;

/**
 * La classe AdjectiveRelation rappresenta il tipo di
 * relazioni con un aggettivo, ovvero un Synset con 
 * type = POS.ADJECTIVE.
 * 
 * @author Spina Michele 1711821
 *
 */

public enum AdjectiveRelation implements WordNetRelation {

	ANTONYM ("!"),
	SIMILAR_TO ("&"),
	PARTECIPLE_OF_VERB ("<"),
	PARTAINYM ("\\"),
	ATTRIBUTE ("="),
	ALSO_SEE ("^"),
	DOMAIN_OF_SYNSET_TOPIC (";c"),
	DOMAIN_OF_SYNSET_REGION (";r"),
	DOMAIN_OF_SYNSET_USAGE (";u");

	protected String encoding;
	protected POS pos = POS.ADJECTIVE;

	
	/**
	 * Viene salvata 
	 * la codifica in stringa del tipo di relazione
	 * @param encoding
	 */
	AdjectiveRelation(String encoding){
		this.encoding = encoding;
	}
	
	@Override
	public String getEncoding() {
		return encoding;
	}	
	
	@Override
	public POS getPos() {
		return pos;
	}	
}
