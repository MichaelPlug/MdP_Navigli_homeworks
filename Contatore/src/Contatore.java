
public class Contatore {

	int k; 
	
	Contatore (){
		k = 0;
	}
	
	public void incrementare() {
		k++;
	}
	
	public int ottenere() {
		return k;
	}
	
	public void reset() {
		k = 0;
	}
	
	public static void main (String [] args) {
		Contatore cont = new Contatore();
		System.out.println(cont.ottenere());
		cont.incrementare();
		System.out.println(cont.ottenere());
		cont.reset();
		System.out.println(cont.ottenere());
	}
}
