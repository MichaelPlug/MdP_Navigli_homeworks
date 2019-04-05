public class Variabile extends EspressioneMatematica {

	private double x;
	private String simbolo;
	
	public Variabile(String nome, double x) {
		simbolo = nome;
		this.x = x;
	}
	
	public Variabile(String nome) {
		simbolo = nome;
	}
	
	public void setVariabile(int x) {
		this.x = x;
	}

	@Override
	public double getValore() {
		return x;
	}
	
	@Override
	public String toString() {
		return simbolo;
	}
}
