public class DaCifreALettere{
	
	public static String convertiCifraInLettera (char cifra) {
		String lettera;
		switch (cifra){
		
		case '0': lettera = "zero"; break;
		case '1': lettera = "uno"; break;	
		case '2': lettera = "due"; break;
		case '3': lettera = "tre"; break;
		case '4': lettera = "quattro"; break;
		case '5': lettera = "cinque"; break;
		case '6': lettera = "sei"; break;
		case '7': lettera = "sette"; break;
		case '8': lettera = "otto"; break;
		case '9': lettera = "nove"; break;
		
		default: lettera = "ERROR"; break;
		}
		
		return lettera; 
	}	

	public static char convertiLetteraInCifra(String lettera) {
			char cifra;
			switch (lettera) {
			case "zero": cifra = '0'; break;
			case "uno": cifra = '1'; break;
			case "due": cifra = '2'; break;
			case "tre": cifra = '3'; break;
			case "quattro": cifra = '4'; break;
			case "cinque": cifra = '5'; break;
			case "sei" : cifra = '6'; break;
			case "sette" : cifra = '7'; break;
			case "otto" : cifra = '8'; break;
			case "nove" : cifra = '9'; break;
			
			default: cifra = 'X'; break;
			}
			
			return cifra;
	}
	
	public static String convertiNumeriInParole (String numeri) {
		
		String lettera;
		char cifra; 

		String parole="";
		for (int i = 0; i < numeri.length(); i++) {
			cifra = numeri.charAt(i);
			lettera = convertiCifraInLettera(cifra);
			parole = parole + lettera + " ";
		}
	
		return parole;
		
	}
	
	public static String convertiParoleInNumeri(String parole) {
		parole = parole.toLowerCase();
		String [] paroleDivise = parole.split(" ");
		int lunghezza = paroleDivise.length;
		String numeri= ""; 
		for (int i=0; i < lunghezza; i++) {
			numeri = numeri + convertiLetteraInCifra(paroleDivise[i]) + " ";
		}
		return numeri;
	}
}