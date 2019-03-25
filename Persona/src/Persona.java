
public class Persona {
	private final String NOME;
	private final String COGNOME;
	public Persona(String NOME, String COGNOME) {
		this.NOME=NOME;
		this.COGNOME=COGNOME;
	}
	
	public void stampa() {
		System.out.print(NOME + " " + COGNOME);
	}
	
	public static void main(String[] args) {
		Persona io = new Persona("Michele", "Spina");
		io.stampa();
	}
}
