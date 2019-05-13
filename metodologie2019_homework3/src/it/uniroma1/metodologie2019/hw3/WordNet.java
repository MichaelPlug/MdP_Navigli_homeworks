package it.uniroma1.metodologie2019.hw3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * La classe WordNet rappresenta appunto un WordNet contentente dei
 * la lista di Synset associato, creati tramite la lettua di un file.
 * Ogni classe istanza dell'oggetto ha associata una versione, e non 
 * esistono due WordNet diversi con associata la stessa versione.
 * 
 * @author Spina Michele 1711821
 *
 */

public class WordNet implements Iterable<Synset>{
	
	/**
	 * Prima parte dell'indizzo dei file da leggere
	 */
	public final static String earlyPath = "wordnet-releases"+ File.separator + "releases"+File.separator+"WordNet-";
	/**
	 * Sotto indirizzo, all'interno di una cartella del WordNet, della cartella che contiene
	 * i file utili
	 */
	public final static String lastDirectory = File.separator +"dict"+File.separator;
	/**
	 * Nomi dei file da leggere
	 */
	public final static String [] finalPath = {"data.noun", "data.verb", "data.adj", "data.adv"};

	private static Map<String, WordNet> versions = new HashMap<String, WordNet>();
	
	private HashSet<Synset> myDictionary = new HashSet<Synset>();
	private String version;
	
	/**
	 * Viene costruito un WordNet a partire da un file ed una versione richiesta.
	 * @param f file di tipo directory contenente i file necessari
	 * @param version Versione di WordNet richiesta
	 */
	private WordNet(File f, String version) {
		this.version = version; //Viene salvato il numero della versione del WordNet
		String path = f.getPath(); //Viene ottenuto l'indirizzo del file f
		path += lastDirectory; //Viene modificato il path, in modo tale che manchi solo il nome del file da aprire
		for (int i = 0; i < finalPath.length; i++)  
			try(BufferedReader br = new BufferedReader(new FileReader(new File(path + finalPath[i])))) // Viene letto ognuno dei 4 file
			{
				String s =  "";
				int loc;
				boolean c;
				if (br.ready()) {
					s = br.readLine();
					while (s.charAt(0) == ' ' & s.charAt(1) == ' ' & br.ready())	
						s = br.readLine();
					}
				do	{
					c = br.ready();
					loc = s.indexOf('|');
					String gloAndEx = s.substring(loc + 1);
					s = s.substring(0, loc);
					if (finalPath[i] == "data.verb")
						while (s.charAt(s.length() -8) == '+') 							
							s = s.substring(0, s.length() -8);
					String [] data = s.split(" ");
					HashSet<String> synonyms = new HashSet<String>();
					int j = decodeHex(data[3]);		
					for (int k = 4; k < 4 + 2*j; k+=2)
						synonyms.add(data[k]);
					Synset syn = new Synset(data[0], POS.getType(data[2].charAt(0)), gloAndEx ,synonyms, version);
					for (int k = decodeHex(data[3])*2 + 5; k < data.length -2; k += 4)
						syn.addRelation(data[k], data[k+1] + data[k+2]);
					myDictionary.add(syn);
					s = br.readLine();
				}
				while (c);
			}				
			catch(IOException e) {
				System.out.println("Errore nella lettura del file "+ finalPath[i]);
			}
	}
	
	/**
	 * Data in input una stringa s che rappresenti la codifica di un numero
	 * in base esadecimale, il metodo restituisce l'intero corrispondente in 
	 * base decimale.
	 * @param s Stringa rappresentate l'intero decimale
	 * @return intero convertito in base 10
	 */
	private static int decodeHex(String s) {
		int j = 0;
		int k = 1;
		for (int i = 1; i <= s.length(); i++) {
			switch (s.charAt(s.length() - i)){
			case '0': j += 0 * k; break;
			case '1': j += 1 * k; break;
			case '2': j += 2 * k; break;
			case '3': j += 3 * k; break;
			case '4': j += 4 * k; break;
			case '5': j += 5 * k; break;
			case '6': j += 6 * k; break;
			case '7': j += 7 * k; break;
			case '8': j += 8 * k; break;
			case '9': j += 9 * k; break;
			case 'a': j += 10 * k; break;
			case 'b': j += 11 * k; break;
			case 'c': j += 12 * k; break;
			case 'd': j += 13 * k; break;
			case 'e': j += 14 * k; break;
			case 'f': j += 15 * k; break;
			}
			k *= 16;
		}
		return j;
	}
	
	/**
	 * Data in input la versione di WordNet richiesta il metodo controlla se questa è
	 * già stata creata: se sì viene restituita, altrimenti viene creata, inserita
	 * in versions ed infine viene restituita.
	 * @param version versione del WordNet richiesta
	 * @return Instanza di WordNet
	 */
	public static WordNet getInstance(String version) {
		
		/*
		 * Se la stessa versione è già stata instanziata, allora
		 * vine restituito lo stesso oggetto creato in precedenza.
		 */
		if (versions.containsKey(version))
			return versions.get(version);
		
		File f = new File(earlyPath + version);

		if (f.exists()) {
			WordNet wn = new WordNet(f, version);
			versions.put(version, wn);
			return wn;		
		}	
		return null; // Se la versione non è presente nel percorso, allora viene restituito null
	}
	
	/**
	 * Dato in input una parola, il metodo costruisce un ArrayList
	 * di Synset che contendono tale parola.
	 * 
	 * @param word Stringa contenente una parola
	 * @return ArrayList di Synset del WordNet con tra i sinonimi la parola word
	 */
	public ArrayList<Synset> getSynsets(String word){
		word.toLowerCase();
		ArrayList<Synset> sL = new ArrayList<Synset>();
		for (Synset s : myDictionary)
			if (s.contains(word)) 
				sL.add(s);
		return sL;
	}
	
	
	/**
	 * Dato in input un Synset il restituisce true se esso e' presente nel WordNet,
	 * false altrimenti
	 * @param syn Synset di cui verificare l'appartenza al WordNet
	 * @return booleano true se il Synset è presente nel WN, false altrimenti
	 */
	public boolean contains (Synset syn) {
		for (Synset s: myDictionary) {
			if (syn.equals(s)) return true;
		}
		return false;
		
		/*
		 * Metodo alternativo:
		 * 
		 * return (syn.getWNVersion == version);
		 */
	}
	
	/**
	 * Dato in input una parola in forma di stringa ed un elemento enumerativo di POS
	 * il metodo restituisce un ArrayList di Synsete che contengono tale parola
	 * e che sono di tipo POS.
	 * Es: dato in input la stringa "albero" e POS.NOUN il metodo restituisce
	 * 	un ArrayList di Synset contenenti la stringa albero e che sono nomi.
	 * @param word parola di cui verificare la presenza nei Synset 
	 * @param pos parte del discorso a cui devono appartenere i synsets
	 * @return ArrayList di Synset contenenti la parola word di tipo pos
	 */
	public ArrayList<Synset> getSynsets(String word, POS pos) {
		word.toLowerCase();
		ArrayList<Synset> sL = new ArrayList<Synset>();
		for (Synset s : myDictionary)
			if (s.contains(word) && s.isA(pos)) sL.add(s);
		return sL;
	}
	
	/**
	 * Dato in input un id in forma di stringa il metodo restituisce il Synset 
	 * corrispondente a quell'id se presente nel WordNet. 
	 * Altrimenti restituisce null
	 * @param id identificativo di un Synset
	 * @return synset corrispondente all'id
	 */
	public Synset getSynsetFromID (String id) {
		id = id.replace('s', 'a');
		for (Synset s : myDictionary) 
			if (id.equals(s.getID()))
				return s;
		return null; // not found
	}
	
	/**
	 * Restituisce uno stream di Synset del WordNet
	 * @return stream di Synset
	 */
	public Stream<Synset> stream(){
		Stream<Synset> stream1 = myDictionary.stream();
		return stream1;
	}
	
	/**
	 * Il medoto restituisce la versione corrispondente al WordNet a cui è applicata.
	 * @return versione del Wordet
	 */
	public String getVersion() {
		return version;
	}
	
	/**
	 * Dato in input un Synset e la codifica di una relazione in forma di stringa, 
	 * il metodo restuisce tutti i Synset presenti nel WordNet che sono in relazione 
	 * di tipo corrispondente alla codifca data, con il Synset dato in input.
	 * @param synset synset di cui leggere le relazioni
	 * @param relation tipo di relazione da analizzare
	 * @return synset in relazione data con il synset dato
	 */
	public ArrayList<Synset> getRelatedSynsets (Synset synset, String relation) {
		return getSynsetsFromIDs(synset.getRelations(relation));
	}

	/**
	 * Dato in input un Synset ed una relazione, 
	 * il metodo restuisce tutti i Synset presenti nel WordNet che sono in relazione 
	 * del tipo dato, con il Synset dato in input.
	 * Se la relazione non è associata al tipo di synset dato in input, allora
	 * il medoto restituisce una lista vuota.
	 * @param synset synset di cui leggere le relazioni
	 * @param relation tipo di relazione da analizzare
	 * @return synset in relazione data con il synset dato
	 */
	public ArrayList<Synset> getRelatedSynsets (Synset synset, WordNetRelation relation){
		if (!synset.isA(relation.getPos())) return new ArrayList<Synset>();
		else return getRelatedSynsets (synset, relation.getEncoding());
	}
	
	/**
	 * Metodo che restituisce un iteratore dei Synset di un WordNet
	 */
	@Override
	public Iterator<Synset> iterator() {
		return myDictionary.iterator();
	}
	
	
	/**
	 * Dato un ArrayList di stringhe codificanti l'ID di Synset,
	 * il metodo restituisce un ArratList dei Synset corrispondenti
	 * @param IDs una lista di Stringhe con l'ID dei Synset
	 * @return lista dei Synset corrispondenti agli ID
	 */
	private ArrayList<Synset> getSynsetsFromIDs(ArrayList<String> IDs){
		ArrayList <Synset> synsets = new ArrayList<Synset>();
		for (Synset s : myDictionary)
			if (IDs.contains(s.getID())) synsets.add(s);
		return synsets;
	}
	
}