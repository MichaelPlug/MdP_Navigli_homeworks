public class TavolaPitagorica {

	private int[][] tavola;
	/**Crea una Tavola Pitagorica
	 * 
	 * @param N sono le dimensioni della tavola pitagorica. Essa rappresenterà tutti i
	 * prodotti tra 0 e N. 
	 */
	public TavolaPitagorica (int N) {
		tavola = new int[N+1][N+1];
		for (int i = 0; i <= 10; i++)
			for (int j=0; j <= 10; j++)
				tavola[i][j] = i*j;
	}
	
	/**Questa funzione, date le cordinate, restituisce il valore presente
	 * nella tavola pitagorica, ovvero il prodotto fra x e y
	 * 
	 * 
	 * @param x è la cordinata delle colonne
	 * @param y è la cordinata delle righe
	 * @return il valore in cordinatate (x,y) della tavola, ovvero x*y
	 */
	public int cercaValore (int x, int y) {
		return (tavola[x][y]);
	}
	
	/**Stampa l'intera tavola pitagorica
	 * 
	 */
	public void stampaTavola () {
		for (int i = 0; i <= 10; i++) {
			for (int j=0; j<=10; j++)
				System.out.print(tavola[i][j] + " ");
			System.out.print("\n");
		}
	}
}