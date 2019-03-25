public class ContaParola {
	
	private String [] frase;
	private int k;
	
	public ContaParola(String frase, String parola) {
		this.frase = frase.split(" ");
		System.out.println(frase.toString());
		System.out.println(this.frase.length);
		for (int i = 0; i<this.frase.length; i++) 
			if (this.frase[i].equals(parola)) k++;
		return;
	}
	
	public String [] getFrase() {
		return frase;
	}
	
	public int getK() {
		return k;
	}
	
	public static void main (String[] args) {
		ContaParola conta = new ContaParola ("Le mucca fanno mu,"
				+ " ma una fa mu mu", "mu");
		// Stampa con ciclo for
		System.out.println(conta.getK());
	}
	
}