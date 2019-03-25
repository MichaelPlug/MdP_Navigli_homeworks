public class CampoMinato {

	private Casella [][] campo;
	private int n;
  	private int m;
  	private int mine;
  	private Stato [][] caselleScoperte;
  	private StatoDelGioco esito;
  	private int caselleDaScoprire;
  	
  	public enum StatoDelGioco{
  		PERSO(-1),
  		VINTO(1),
  		INGIOCO(0);

  		private int statoDelGioco;
  		private StatoDelGioco(int statoDelGioco) { this.statoDelGioco=statoDelGioco;}
  		private int toInt() { return statoDelGioco;	}
  	}
	
	public enum Casella{
		UNO(1),
		DUE(2),
		TRE(3),
		QUATTRO(4),
		CINQUE(5),
		SEI(6),
		SETTE(7),
		OTTO(8),
		BOMBA(-1),
		VUOTO(0);
		
		private int casella;
		private Casella(int casella) {	this.casella=casella;	}		
		public int toInt() { return casella;	}
		}
	
	public enum Stato{
		COPERTA(0),
		SCOPERTA(-1);
		
		private int stato;	
		Stato(int stato) {	this.stato=stato; }
		public int toInt() {	return stato;	}
	}

	
	
	public CampoMinato(int n, int m, int mineDaInserire){
		this.n=n;
		this.m=m;
		mine=0;
		caselleDaScoprire=n*m;
		campo = new Casella [n][m];
		esito = StatoDelGioco.valueOf("INGIOCO");
		caselleScoperte = new Stato [n][m];
		for (int i=0; i<n; i++)
			for(int j=0; j<m; j++) {
				campo[i][j] = Casella.valueOf("VUOTO");
				caselleScoperte[i][j]=Stato.valueOf("COPERTA");}			
		piazzaMine(mineDaInserire);
		segnaCaselle();
	}
	
	private void piazzaMine(int mineDaInserire) {
		int nCasuale, mCasuale;
		while(0 < mineDaInserire) {
			nCasuale = (int) (Math.random()*n);
			mCasuale = (int) (Math.random()*m);
			if(campo[nCasuale][mCasuale].toInt()!=-1) {
				campo[nCasuale][mCasuale] = Casella.valueOf("BOMBA");
				mineDaInserire--;
				mine++;
			}
		}
	}
	
	private void segnaCaselle() {
		int mineVicine;
		for (int i=0; i<n; i++) {
			Casella [] valori = Casella.values();
			for (int j=0; j<m; j++)
				if(campo[i][j].toInt()==-1) continue;
				else {
					mineVicine=0;
					if(i>0 && j>0 && campo[i-1][j-1].toInt()==-1)
						mineVicine++;
					if(i>0 && campo[i-1][j].toInt()==-1)
						mineVicine++;
					if( i>0 && j<m-1 && campo[i-1][j+1].toInt()==-1)
						mineVicine++;
					if(j>0 && campo[i][j-1].toInt()==-1)
						mineVicine++;
					if(j<m-1 && campo[i][j+1].toInt()==-1)
						mineVicine++;
					if(i<n-1 && j>0 && campo[i+1][j-1].toInt()==-1)
							mineVicine++;
					if(i<n-1 && campo[i+1][j].toInt()==-1)
						mineVicine++;
					if(i<n-1 && j<m-1 && campo[i+1][j+1].toInt()==-1)
						mineVicine++;
					if(mineVicine>0) campo[i][j]=valori[mineVicine-1];
				}
		}
	}
	
	/*
	 * Se la visita non è possibile, per coordinate sbagliate, partita conclusa o 
	 * casella già scoperta, la funzione restituisce -2
	 */

	
	private int scopri(int x, int y) {
		if (x<0||x>=n||y<0||y>=m||esito.toInt()!=0||caselleScoperte[x][y].toInt()==-1) return -2;
		int mineVicine=campo[x][y].toInt();
		caselleScoperte[x][y]=Stato.valueOf("SCOPERTA");
		if (mineVicine==-1) {
			esito=StatoDelGioco.valueOf("PERSO");
			return mineVicine;
		}
		if (mineVicine==0) {
			scopri(x-1, y-1);
			scopri(x-1, y);
			scopri(x-1, y+1);
			scopri(x, y-1);
			scopri(x, y+1);
			scopri(x+1, y-1);
			scopri(x+1, y);
			scopri(x+1, y+1);
		}
		if(--caselleDaScoprire == mine) esito=StatoDelGioco.valueOf("VINTO");
		return (mineVicine);
	}
	
	public String toString() {
		String situazione = "";
		int casella;
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++)
				if (caselleScoperte[i][j].toInt()==0)
					situazione=situazione+"+";
				else {
					casella= campo[i][j].toInt();
					switch (casella) {
						case 0:		situazione=situazione+" ";		break;
						case -1:	situazione=situazione+"*";		break;
						default:	situazione=situazione+casella;	break;
					}
				}
			situazione=situazione+"\n";
		}
		return situazione;
	}

	
	public String vinto() {
		switch (esito.toInt()) {
		case 1:		return "VINTO";
		case -1:	return "PERSO";
		case 0:		return "IN GIOCO";
		}
		return "ERROR";
	}
}
