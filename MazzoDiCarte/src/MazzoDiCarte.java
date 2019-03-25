public class MazzoDiCarte{
	
	public enum Seme{
		CUORI('c'),
		FIORI('f'), 
		QUADRI('q'), 
		PICCHE('p');
		
		private char seme;
		Seme(char seme){ this.seme=seme;}
		public char toChar() { return seme;}
	}
	
	public enum Numero{
		ASSO(1),
		DUE(2),
		TRE(3),
		QUATTRO(4),
		CINQUE(5),
		SEI(6),
		SETTE(7),
		OTTO(8),
		NOVE(9),
		DIECI(10),
		JACK(11),
		REGINA(12),
		RE(13);
		
		private int numero;
		Numero(int numero){ this.numero=numero;}
		public int toInt() { return numero;}
		}

		public class Carta {
			
			
			
		
			
			private Numero valore;
			private Seme segno;
			
		
			
			public Carta(Numero valore, Seme segno){
				this.valore=valore;
				this.segno=segno;
			}	
			
			public void stampa() {
				switch (valore.toInt()) {
				case 11: System.out.print ("J di "); 		break;
				case 12: System.out.print ("Q di"); 		break;
				case 13: System.out.print ("Re di ");		break;
				case 1:  System.out.print ("Asso di ");		break;
				default: System.out.print (valore.toInt()+" di ");	break;
				}
				switch (segno.toChar()) {
				case 'c': System.out.println ("cuori");		break;
				case 'q': System.out.println ("quadri");	break;
				case 'f': System.out.println ("fiori");		break;
				case 'p': System.out.println ("picche");	break;
				}
			}	
		}
		
		private Carta[] carte = new Carta[52];
		private int carteDistribuite;
		
		public MazzoDiCarte(){
			Numero[] valori = Numero.values();
			for (int i=0; i<=12; i++) {
				carte[i] = new Carta(valori[i],Seme.valueOf("CUORI"));
				carte[i+13] = new Carta(valori[i],Seme.valueOf("QUADRI"));
				carte[i+26] = new Carta(valori[i],Seme.valueOf("FIORI"));
				carte[i+39] = new Carta(valori[i],Seme.valueOf("PICCHE"));
			}
			carteDistribuite=0;
		}
		
		public void scambia(int a, int b){
			Carta temp = carte[a];
			carte[a] = carte[b];
			carte[b] = temp;
		}
		
		public void mescola () {
			carteDistribuite = 0;
			int cartaCasuale;
			for (int i=0; i<52; i++) {
				cartaCasuale= (int) (Math.random()*52);
			//	System.out.println(cartaCasuale);  Controllo i valore di cartaCasuale
				scambia (i, cartaCasuale);
			}
		}
		
		public Carta distribuisci () {
			carteDistribuite++;
			return carte[carteDistribuite -1];
		}
	


	}

