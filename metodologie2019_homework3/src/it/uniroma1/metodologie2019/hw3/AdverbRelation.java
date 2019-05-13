package it.uniroma1.metodologie2019.hw3;

/**
 * La classe AdverbRelation rappresenta il tipo di
 * relazioni con un avverbio, ovvero un Synset con 
 * type = POS.ADVERB.
 * 
 * @author Spina Michele 1711821
 *
 */


public enum AdverbRelation implements WordNetRelation{

	ANTONYM ("!"),
	DERIVED_FROM_ADJECTIVE ("\\"),
	DOMAIN_OF_SYNSET_TOPIC (";c"),
	DOMAIN_OF_SYNSET_REGION (";r"),
	DOMAIN_OF_SYNSET_USAGE (";u");

	protected String encoding;
	protected POS pos = POS.ADVERB;

	
	/**
	 * Viene salvata 
	 * la codifica in stringa del tipo di relazione
	 * @param encoding
	 */
	AdverbRelation(String encoding){
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
