
public class Calcolatrice {

	private int[] memoria;
	private int valore;
	
	public Calcolatrice(){
		memoria = new int [0];
		valore = 0;
	}
	
	public void somma(int addendo) {
		valore += valore;
	}
	
	public void memorizza() {
		int lun = memoria.length+1;
		int [] appo = new int [lun];
		for (int i = 0; i < lun; i++)
			appo[i] = memoria[i];
		appo [lun] = valore;
		memoria = appo;
	}
	
	public void azzera () {
		valore =0;
	}
	
	public boolean recupera (int k) {
		if (k < memoria.length) {
			valore = memoria[k];
			return true;
		}
		return false;
	}
}
