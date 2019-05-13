package it.uniroma1.metodologie2019.hw3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Un Synset rappresenta un significato, o concetto.
 * Ad esso sono associati dei sinonimi ed è descritto da
 * un codice identifiativo ed un elemento di POS.
 * 
 * Un Synset contiene al suo interno una definizione testuale e
 * la versione del WordNet che lo ha generato.
 * 
 * Esso puo contenere evenutalmente delle relazioni verso altri WordNet
 * e degli esempi di utilizzo dei sinonimi. 
 * @author Spina Michele 1711821
 *
 */
public  class Synset implements Iterable<String> {

	private String synsetOffset;
	private POS type;
	private String glossa;
	private HashSet<String> synonyms;
	private ArrayList<String> examples;
	private HashMap<String, ArrayList<String>> relations;
	private String wnVersion;
	
	

	/**
	 * Costruttore di un Synset con synsetOffset, type, glossario, sinonimi, esempi e versione di WordNet associata.
	 * Non sono presenti relazioni
	 * 
	 * @param synsetOffSet L'offSet che codifica del Synset
	 * @param type La parte del discorso associata al Synset
	 * @param gloAndEx Stringa contenente il glossario e gli esempi del Synset secondo la formattazione di WordNet
	 * @param synonyms Sinonimi associati al Synset
	 * @param wnVersion La versione del WordNet che ha generato il Synset
	 */
	public Synset (String synsetOffSet, POS type, String gloAndEx, HashSet<String> synonyms, String wnVersion) {
		/*
		 * La versione del WordNet associato, l'offSet del Synset e la parte del discorso, date in input,
		 * vengono salvate nei rispettivi campi.
		 */
		this.wnVersion = wnVersion;
		this.synsetOffset = synsetOffSet;
		this.type = type;
		examples = new ArrayList<String>();
		/**
		 * Il metodo individua le porzioni di stringa rappresentati gli esempi,
		 * contenuti in GloAndEx.
		 * Queste vengono suddivise all'ArrayList example
		 */
		int k = gloAndEx.lastIndexOf('"');
		int i = gloAndEx.lastIndexOf('"', k -1);
		boolean j = false;
		while (i != -1) {
			j = true;
			examples.add(0, gloAndEx.substring(i + 1, k));
			gloAndEx = gloAndEx.substring(0, i);
			k = gloAndEx.lastIndexOf('"');
			i = gloAndEx.lastIndexOf('"', k -1);
		}
		/**
		 * La porzione di stringa rimanente in gloAndEx, 
		 * meno alcuni caratteri superflui, rappresenta il glossario
		 */
		if (j) i = gloAndEx.length() -2;
		else i = gloAndEx.length();
		if (i > 0) 	glossa = gloAndEx.substring(1, gloAndEx.length()-2);
		/*
		 * Vengno salvati i sinonimi ed inizializzato l'ArrayList delle relazioni
		 */
		this.synonyms = synonyms;
		relations = new HashMap<String, ArrayList<String>>();
	}
	
	/**
	 * Restituisce un ArrayList di stringhe con i sinonimi riferiti al Synset
	 * @return sinonimi riferiti al Synset
	 */
	public HashSet<String> getSynonyms(){
		return synonyms;
	}
	
	/**
	 * 	Restituisce un ArrayList di stringhe con gli esempi di un Synset
	 * @return Esempi del synset
	 */
	public ArrayList<String> getExamples(){
		return examples;
	}

	/**
	 * Restituisce il numero di sinonimi di un Synset
	 * @return numero sinonimi
	 */
	public int size() {
		return synonyms.size();
	}

	/**
	 * Restituisce un codice identificativo in forma di stringa, 
	 * composto dal SynsetOffset che è un numero di 8 cifre,
	 * e la codifica della parte del discorso relativa al Synset,
	 * ovvero una codifica di POS.
	 * @return ID del Synset
	 */
	public String getID() {
	//	System.out.println(synsetOffset);
	//	System.out.println(type.getEncoding());
		return synsetOffset + type.getEncoding();
	}
	
	/**
	 * Restituisce il glossario, quindi la definizione testuale
	 * del Synset.
	 * @return Glossario del synset
	 */
	public String getGloss(){
		return glossa;
	}
	
	/**
	 * Restituisce la parte del discorso a cui il Synset appartiene.
	 * @return parte del discorso del Synset
	 */
	public POS getPOS() {
		return type;
	}
	
	@Override
	public boolean equals(Object s) {
		if (!(s instanceof Synset)) return false;
		Synset ss = (Synset) s;
		return (this.wnVersion.equals(ss.getWNVersion()) && this.getID().equals(ss.getID()) && this.synonyms.equals(ss.getSynonyms()) && this.glossa.equals(ss.getGloss()));
	}
	
	/**
	 * Restituisce l'Offset del Synset
	 * @return Offset del Synset
	 */
	public String getOffset() {
		return synsetOffset;
	}
	
	/**
	 * Verifica che il synset contenga una specifica parola
	 * 
	 * @param word parola di cui verificare l'appartenza
	 * @return true se la parola è presente, false altrimenti
	 */
	public boolean contains(String word) {
		return synonyms.contains(word);
//		return this.stream()
	}
	/**
	 * Il metodo verifica se la parte del discorso relativa
	 * al synset è esattamente del tipo dato in input
	 * @param o tipo della parte del discorso 
	 * @return true se di tipo o, false altrimenti
	 */
	public boolean isA(POS o) {
		return type == o;
	}
	
	/**
	 * Converte a stringa l'elenco dei sinonimi
	 */
	@Override
	public String toString() {
		return synonyms.toString();
	}
	
	
	@Override
	public Iterator<String> iterator() {
		return synonyms.iterator();
	}
	
	/**
	 * Il metodo aggiunge al Synset una relation il cui tipo è codificato
	 * da relType, ed associata al synset con ID synsetID.
	 * @param relType codifica della relazione
	 * @param synsetID ID del Synset della relazione
	 */
	public void addRelation(String relType, String synsetID) {
		if (relations.containsKey(relType)) relations.get(relType).add(synsetID);
		else {
			ArrayList<String> aL = new ArrayList<String>();
			aL.add(synsetID);
			relations.put(relType, aL);
		}
	}
	
	/**
	 * Il metodo restituisce un ArrayList di stringhe contenete tutti i codici ID
	 * dei Synset che sono in relazione del tipo codificato in relType
	 * @param relType - codifica della relazione
	 * @return ID dei synset in telazione relType
	 */
	public ArrayList<String> getRelations(String relType){
		return relations.get(relType);
	}
	
	/**
	 * Il metodo restituisce la versione del WordNet relativo al Synset
	 * @return versione del Wordnet
	 */
	public String getWNVersion() {
		return wnVersion;
	}
}