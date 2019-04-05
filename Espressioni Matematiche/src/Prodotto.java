
public class Prodotto extends EspressioneMatematica{
	
	private EspressioneMatematica f;
	private EspressioneMatematica g;
	
	public Prodotto(EspressioneMatematica f, EspressioneMatematica g) {
		this.f = f;
		this.g = g;
	}

	@Override
	public double getValore() {
		// TODO Auto-generated method stub
		return f.getValore() * g.getValore();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+f.toString()+")*("+g.toString()+")";
	}
}
