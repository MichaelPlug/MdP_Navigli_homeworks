import java.util.Arrays;

public class ListaDiInteri {

	private int [] lista; 
	
	public ListaDiInteri() {
		lista = new int [0];
	}
/*	cercaIndice
 * 
 * La funzione, dato un valore in input, cerca il primo indice in cui esso è contenuto.
 * In caso il valore non sia in lista restituisce -1
 */
	public int cercaIndice (int elemento) {
		int indice = -1;
		int i=0;
		while (i<lista.length && indice==-1) {
			if (lista[i]==elemento) indice=i;
			i++;
		}
		return indice;
	}
/*	cercaElemento
 * 
 * La funzione, dato in input un indice, restituisce l'elemento corrispondente
*/	
	public int cercaElemento (int indice) {
		return lista[indice];
	}
/*	dimesioni	
 * 
 * La funzione da in input la lunghezza della lista
*/	
	public int dimensioni () {
		return lista.length;
	}
/* 	contiene
 * 
 * La funzione verifica la presenza di un elemento nella lista e restituisce un booleano
*/
	public boolean contiene (int elemento) {
		for (int i=0; i<lista.length; i++)
			if (lista[i]==elemento) return true;
		return false;
	}
/*  aggiungiInCoda
 * 
 * Aggiunge un elemento in fondo alla lista, ad esempio se abbiamo un vettore di lunghezza N, inserisce l'elemento dato in input in posizione N+1
 */
	public void aggiungiInCoda (int elemento) {
		lista = Arrays.copyOf(lista, lista.length + 1);
		lista [lista.length -1] = elemento;
	}
/*	aggiungiIn
 * 
 * Aggiunge un elemento in una specifa posiozione data in input, facendo poi scalare così tutti gli elementi successivi verso la coda della lista
 */
	public void aggiungiIn(int elemento, int posizione) {
		lista = Arrays.copyOf(lista, lista.length + 1);
		for (int i=lista.length-1; i>posizione; i--)
			lista[i]=lista[i-1];
		lista[posizione]=elemento;
	}
/*	elimina
*	
*	Elimina l'ultimo elemento in coda e riduce la dimensione della lista di uno
*/	
	public void elimina () {
		lista = Arrays.copyOf(lista, lista.length -1);
	}
/* eliminaIn
 * 
 * Data in input una posizione, elimina l'elemento in quella specifica posizione, facendo scalare tutti i successivi di una posizione verso la testa della lista
 */
	public void eliminaIn (int posizione) {
		for (int i=posizione; i<lista.length-1; i++)
			lista[i]=lista[i+1];
			lista = Arrays.copyOf(lista, lista.length -1);
	}
	
/* convertiInStringa
 * 
 * Restituisce la lista in formato String	
 */
/*	public String convertiInStringa() {
		String listaS = "";
		for (int i=0; i<lista.length; i++)
			listaS = listaS + lista[i] + "\n";
		return listaS;	
		}
*/	
	
	public void convertiInStringa() {
		System.out.println(Arrays.toString(lista));
	}
}