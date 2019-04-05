
public class Costante extends EspressioneMatematica {

	private final double a;
	
	public Costante(double a) {
		this.a=a;
	}
	
	@Override
	public double getValore() {
		return a;
	}

	@Override
	public String toString() {
		return Double.toString(a);
	}
}
