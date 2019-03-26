
public class MioArray {
	
	private int [] vettore;
	
	/*	contiene, che data in ingresso una posizione e un intero, restituisce true o
		false se l’intero è contenuto in quella posizione nell’array
	*/
	
	public MioArray (int[] vettore) {
		this.vettore = vettore;
	}
	
	public boolean contiene (int posizione, int valore) {
		return (posizione < vettore.length && vettore[posizione] == valore);
	}
	
	
	/*	somma2, che restituisce la somma dei primi due elementi dell’array. Se
		l’array è di lunghezza inferiore (info: la lunghezza dell’array a si ottiene con
		il campo speciale length, quindi a.length), restituisce il valore del primo
		elemento oppure 0 se l’array è vuoto

	 */
	
	public int somma2 () {
		if (vettore.length==0) return 0;
		else if (vettore.length==1) return vettore [0];
		else return vettore[0] + vettore[1];
	}

	/*	scambia, che date in ingresso due posizioni intere, scambia i valori presenti
		nelle due posizioni dell’array (es. scambia(1, 3) trasforma l’array { 1, 2, 3, 4,
		5 } in { 1, 4, 3, 2, 5 })
	*/
	
	public void scambia (int pos1, int pos2) {
		int temp;
		temp = vettore[pos1];
		vettore[pos1] = vettore[pos2];
		vettore[pos2] = temp;
	}
	
	/*	maxTripla: che restituisce il valore massimo tra il primo, l’ultimo e il valore in
		posizione intermedia dell’array (es. restituisce 3 se l’oggetto è costruito con {
		1, 7, 5, 3, 0, 2, 2 }, le posizione esaminate sono in grassetto)
	*/
	
	public int maxTripla () {
		if (vettore.length == 0) {
			System.out.println("ERROR: La funzione maxTripla non può definire il massimo di un vettore vuoto");
			return 0;
			}
		int max = vettore[0];
		if (vettore[vettore.length -1] > max) max = vettore[vettore.length -1];
		if (vettore[vettore.length]/2 > max) max = vettore[vettore.length -1]; 
		return max;
		}
	  
	/*	falloInDue: che restituisce un array di due interi, il primo è il primo elemento
		dell’array dell’oggetto, il secondo è l’ultimo elemento dell’array dell’oggetto
	*/ 
		public int[] falloInDue () {
			int[] primoEUltimo = { vettore[0], vettore[vettore.length -1]};
			return primoEUltimo;
		}
		
		
}