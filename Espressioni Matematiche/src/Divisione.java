
public class Divisione extends EspressioneMatematica{
	private EspressioneMatematica f;
	private EspressioneMatematica g;
	
	public Divisione(EspressioneMatematica f, EspressioneMatematica g) {
		this.f = f;
		this.g = g;
	}

	@Override
	public double getValore() {
		// TODO Auto-generated method stub
		return f.getValore() / g.getValore();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+f.toString()+")/("+g.toString()+")";
	}
}
