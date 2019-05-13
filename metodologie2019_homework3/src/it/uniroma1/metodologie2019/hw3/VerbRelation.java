package it.uniroma1.metodologie2019.hw3;

/**
 * La classe VerbRelation rappresenta il tipo di
 * relazioni con un verb, ovvero un Synset con 
 * type = POS.VERB.
 * 
 * @author Spina Michele 1711821
 *
 */

public enum VerbRelation implements WordNetRelation {

	ANTONYM ("!"),
	HYPERNYM ("@"),
	HYPONYM ("~"),
	ENTAILMENT ("*"),
	CAUSE (">"),
	ALSO_SEE ("^"),
	VERB_GROUP ("$"),
	DETIVATIONALLY_RELATED_FORM ("+"),
	DOMAIN_OF_SYNSET_TOPIC (";c"),
	DOMAIN_OF_SYNSET_REGION (";r"),
	DOMAIN_OF_SYNSET_USAGE (";u");

	protected String encoding;
	protected POS pos = POS.VERB;
	
	/**
	 * Viene salvata 
	 * la codifica in stringa del tipo di relazione
	 * @param encoding
	 */
	VerbRelation(String encoding){
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
