public class Tris{
	
	private ScacchieraTris scacchiera;
	private char turno;
	private String esito;
	private int mano;
	

/**
 * Crea un oggetto Tris rappresentante una nuova partita.
 * Esso crea una nuova scacchiera ("vuota") e inizializza tutti gli altri campi.
 * @param giocaotoreIniziale rappresenta il giocatore iniziale, esso può essere X o O, 
 * in caso contrario viene scelto casualmente fra questi due
 */

	public Tris(char giocatoreIniziale){
		scacchiera = new ScacchieraTris();
		esito = "La partita non è finita";
		mano = 0;
		if (giocatoreIniziale=='X'||giocatoreIniziale=='O')
			turno = giocatoreIniziale;
		else { int giocatoreInizialeCasuale; // DA RIVEDERE
				giocatoreInizialeCasuale = (int)(Math.random() * 2)-1;
				System.out.println(giocatoreInizialeCasuale);
				switch(giocatoreInizialeCasuale) {
				case 0: turno = 'O'; break;
				case -1: turno = 'X'; break;
				default: turno = 'O'; break;
				}
		}
	}
	
	/**
	 * La funzione consiste in una singola manche, permette di eseguire una mossa,
	 * verificandone la validità tramite la funzione scriviScacchiera, 
	 * in caso la mossa sia valida restituisce true ed incrementa il numero della mano.
	 * Prima di terminare, se la scrittura è andata a buon fine, stampa la scacchiera. 
	 *
	 * @param x la colonna in cui viene inserito il segno
	 * @param y riga in cui viene inserito il segno
	 * @return true se l'operazione di scrittura è andata a buon fine,
	 * 			false in caso contrario
	 */
	
	
	
	public boolean manche(int x, int y) {
		if (esito!="La partita non è finita") return false;
		else {if (scacchiera.scriviScacchiera(turno, x, y)) {	
			mano++;
			scacchiera.stampaScacchiera();
			verificaRisultato();
			cambioTurno();
			System.out.println(esito);
			return true;
		}
		else System.out.println("Coordinate non valide");
		return false;}
	}

	/**
	 * Controlla il risultato senza necessitare di conoscere l'ultima mossa
	 */
	
	public void verificaRisultato() {
		char [][] matrice = new char [3][3];
		matrice = scacchiera.getMatrice();
		if (matrice[0][0]==matrice[1][1] && matrice[0][0]==matrice[2][2] && matrice[1][1]!=' ') {
			esito = "Vince " +matrice[1][1];
			return;
		}
		if (matrice[0][2]==matrice[1][1]&&matrice[0][2]==matrice[2][0]&&matrice[1][1]!=' ') {
			esito = "Vince " +matrice[1][1];
			return;
		}
		for (int i=0; i<3; i++)
			if (matrice[i][0]==matrice[i][1]&&matrice[i][0]==matrice[i][2]&&matrice[i][0]!=' ') {
				esito = "Vince " +matrice[i][0];
				return;
			}
			else if (matrice[0][i]==matrice[1][i]&&matrice[0][i]==matrice[2][i]&&matrice[0][i]!=' ') {
				esito = "Vince " +matrice[0][i];
				return;
			}
		if (mano>8) esito = "Pareggio";
		else esito = "La partita non è finita";
		return;
	}
	
	/**
	 * La funzione verifica se, date le coordinate di una casella, essa è coinvolta
	 * nella determinazione del risultato, o se la partita finisce perchè tutte le 
	 * caselle sono state riempite
	 * @param x
	 * @param y
	 */
	
	private void verificaRisultato(int x, int y) {
		char [][] matrice = new char [3][3];
		matrice = scacchiera.getMatrice();
		if(matrice[x][y]==matrice[(x+1)%3][y]&&matrice[x][y]==matrice[(x+2)%3][y]&&matrice[x][y]==' ')
			{
			esito = "Vince "+matrice[x][y];
			return;
			}
		if(matrice[x][y]==matrice[x][(y+1)%3]&&matrice[x][y]==matrice[x][(y+2)%3]&&matrice[x][y]==' ')
			{
			esito = "Vince "+matrice[x][y];
			return;
			}
		if(x==y&&matrice[x][y]==matrice[(x+1)%3][(y+1)%3]&&matrice[x][y]==matrice[(x+2)%3][(y+2)%3]) {
			esito = "Vince "+matrice[x][y];
			return;
		}
		if(x+y==4&&matrice[x][y]==matrice[(x+1)%3][(y-1)&3]&&matrice[x][y]==matrice[(x-1)%3][(y+1)&3])
		if (mano>8) esito = "Pareggio";
		else esito = "La partita non è finita";
		return;
	}
	/**
	 * Alterna i turni dei due giocatori
	 */
	public void cambioTurno() {
		switch (turno) {
		case 'O': turno= 'X'; break;
		case 'X': turno= 'O'; break;
		}
	}
	
	public class ScacchieraTris {
		private char [][] matrice;
		
		/**
		 *  Crea la scacchiera "vuota"
		 */
		public ScacchieraTris(){
			matrice = new char[3][3];
			for (int i=0; i<3; i++)
				for (int j=0; j<3; j++)
					matrice[i][j] = ' ';
		}
		/**
		 *  Stampa la scacchiera, separando le righe andando a capo e le colonne con uno spazio
		 */
		
		public void stampaScacchiera() {
			for (int i=0; i<3; i++) {
				System.out.print("");
				for (int j=0; j<3; j++)
					System.out.print(matrice[i][j] + " ");
				System.out.println("");
			}	
		}
		
		/**
		 * 
		 * @param giocatore è il giocatore a cui appartiene il turno e
		 * 			rappresenta il segno che verrà inserito
		 * @param x è la colonna in cui verrà scritto il segno inserito
		 * @param y è la riga in cui verrà scritto il segno inserito
		 * @return	se l'operazione è andata a buon fine ritorna vero, in caso contrario false
		 * 			così che il metodo possa essere chiamato di nuovo con dati coerenti
		 */
		public boolean scriviScacchiera(char giocatore, int x, int y) {
			if ((giocatore != 'X' && giocatore != 'O')|| x<0 || x>2 || y<0 || y>2)
				return false;
			else {
				matrice[x][y]=giocatore;
				return true;	
			}
		}

/**
 * 
 * @return restituisce la matrice rappresentate la scacchiera
 */
		public char[][] getMatrice() {
				return matrice;
		}
	}
}
