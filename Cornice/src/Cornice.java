
public class Cornice {
	private int dimensione;
	private String frase;
	
	public Cornice(int dimensione, String frase) {
		this.dimensione = dimensione;
		this.frase = frase;
	}
	
	public String toString() {
		String fraseIncorniciata = "";
		for (int i = 0; i < dimensione; i++)
			fraseIncorniciata += "*";
		fraseIncorniciata += "\n";
		for (int i = 0; i < dimensione - 2; i++) {
			fraseIncorniciata += "*";
			for (int j = 0; j < dimensione -2; j++)
				if (frase.length() > i + ((dimensione-2)*j)) 
					fraseIncorniciata += frase.charAt(j + (dimensione -2)*i);
				else fraseIncorniciata += " ";
			fraseIncorniciata += "*\n";
		}
		for (int i = 0; i < dimensione; i++)
			fraseIncorniciata += "*";
		return fraseIncorniciata;
	}
}
