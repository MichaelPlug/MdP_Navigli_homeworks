
public class Opposto extends EspressioneMatematica{

	private EspressioneMatematica f;
	
	public Opposto(EspressioneMatematica f) {
		this.f = f;
	}

	@Override
	public double getValore() {
		return -f.getValore();
	}

	@Override
	public String toString() {
		return "-(" + f.toString() +")";
	}	
}
