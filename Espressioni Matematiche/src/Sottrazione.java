
public class Sottrazione extends EspressioneMatematica{
	private EspressioneMatematica f;
	private EspressioneMatematica g;
	
	public Sottrazione(EspressioneMatematica f, EspressioneMatematica g) {
		this.f = f;
		this.g = g;
	}
	
	@Override
	public double getValore() {
		return f.getValore() - g.getValore();
	}
	@Override
	public String toString() {
		return "("+f.toString()+ ")-(" + g.toString()+ ")";
	}

}
