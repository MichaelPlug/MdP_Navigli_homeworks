
public class Carta {
		private int numero;
		private char seme;
		
		public Carta(int numero, char seme){
			this.numero=numero;
			this.seme=seme;
		}	
		
		public void stampa() {
			switch (numero) {
			case 11: System.out.print ("J di "); 		break;
			case 12: System.out.print ("Q di"); 		break;
			case 13: System.out.print ("Re di ");		break;
			case 1:  System.out.print ("Asso di ");		break;
			default: System.out.print (numero+" di ");	break;
			}
			switch (seme) {
			case 'c': System.out.println ("cuori");		break;
			case 'q': System.out.println ("quadri");	break;
			case 'f': System.out.println ("fiori");		break;
			case 'p': System.out.println ("picche");	break;
			}
		}	
	}
