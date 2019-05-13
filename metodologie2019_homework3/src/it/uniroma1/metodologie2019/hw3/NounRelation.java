package it.uniroma1.metodologie2019.hw3;

/**
 * La classe NounRelation rappresenta il tipo di
 * relazioni con un nome, ovvero un Synset con 
 * typE = POS.NOUN.
 * 
 * @author Spina Michele 1711821
 *
 */

public enum NounRelation implements WordNetRelation {

	ANTONYM ("!"),
	HYPERNYM ("@"),
	INSTANCE_HYPERNYM ("@i"),
	HYPONYM ("~"),
	INSTANCE_HYPONYM ("~i"),
	MEMBER_HOLONYM ("#m"),
	SUBSTANCE_HOLONYM ("s"),
	PART_HOLONYM ("#p"),
	MEMBER_MERONYM ("%m"),
	SUBSTANCE_MERONYM ("%s"),
	PART_MERONYM ("%p"),
	ATTRIBUTE ("="),
	DERIVATIONALLY_RELATED_FORM ("+"),
	DOMAIN_OF_SYNSET_TOPIC (";c"),
	MEMBER_OF_THIS_DOMAIN_TOPIC ("-c"),
	DOMAIN_OF_SYNSET_REGION (";r"),
	MEMBER_OF_THIS_DOMAIN_REGION ("-r"),
	DOMAIN_OF_SYNSET_USAGE (";u"),
	MEMBER_OF_THIS_DOMAIN ("-u");

	protected String encoding;
	protected POS pos = POS.NOUN;

	
	/**
	 * Viene salvata 
	 * la codifica in stringa del tipo di relazione
	 * @param encoding
	 */
	NounRelation(String encoding){
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
