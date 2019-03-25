
public class GiocoDelQuindici {
	public enum Casella{
		UNO(1),
		DUE(2),
		TRE(3),
		QUATTRO(4),
		CINQUE(5),
		SEI(6),
		SETTE(7),
		OTTO(8),
		NOVE(9),
		DIECI(10),
		UNDICI(11),
		DODICI(12),
		TREDICI(13),
		QUATTORDICI(14),
		QUINDICI(15),
		VUOTA(16);
		
		private int numero;
		Casella(int numero) {this.numero=numero;}
		public int toInt() { return numero; }
	}
	public enum Direzione{
		SU(0),
		SINISTRA(1),
		DESTRA(2),
		GIU(3);
		
		private int direzione;
		Direzione(int direzione) {	this.direzione=direzione;	}
		public int toInt() {	return direzione;	}
	}
	
	private final int N = 4;
	private Casella[][] tavolaDaGioco;

	public GiocoDelQuindici() {
		tavolaDaGioco = new Casella[N][N];
		Casella[] valori = Casella.values();
		for (int i=0; i<N; i++)
			for (int j=0; j<N; j++)
				tavolaDaGioco[i][j]= valori[(i*4)+j];
		//mescola();
	}
	
	public void mescola() {
		for (int i=0; i<N; i++)
			for (int j=0; j<N; j++)
				scambia (i, j,(int)(Math.random()*4), (int)(Math.random()*4));
		}
	
	private void scambia(int x1, int y1, int x2, int y2) {
		System.out.print("LOOOL");
		Casella temp = tavolaDaGioco[x1][y1];
		tavolaDaGioco[x1][y1] = tavolaDaGioco[x2][y2];
		tavolaDaGioco[x2][y2] = temp;
	}
	
	public void scorri(int x, int y, Direzione verso) {	
		switch(verso.toInt()) {
		case 1: if (y>0 &&tavolaDaGioco[x][y-1].toInt()==16) scambia(x, y, x, y-1); break;
		case 0: if (x>0 &&tavolaDaGioco[x-1][y].toInt()==16) scambia(x, y, x-1, y); break;
		case 3:	if (x<N-1&&tavolaDaGioco[x+1][y].toInt()==16) scambia(x, y, x+1, y); break;
		case 2: if (y<N-1 && tavolaDaGioco[x][y+1].toInt()==16) scambia(x, y, x, y+1); break;
		default: return;
		}
		return;
	}
	
	public boolean vinto() {
		for (int i=0; i<N; i++)
			for (int j=0; j<N; j++)
				if(tavolaDaGioco[i][j].toInt()!=(i*4)+j+1) return false;
		return true;
	}
	
	public void stampa() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) 
				System.out.print(tavolaDaGioco[i][j].toInt() + " ");
			System.out.println("");
		}
	}
}