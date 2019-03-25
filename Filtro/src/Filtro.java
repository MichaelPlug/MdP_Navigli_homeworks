import java.util.Arrays;

public class Filtro {

	int [] vettore;
	
	public Filtro (int[] vettore) {
		this.vettore=vettore;
	}
	
	public Filtro filtra(int k) { 
		int [] tempVettore = new int[vettore.length];
		int dimensioni = 0;
		for (int i=0; i<vettore.length; i++) {
				if (vettore[i] != k ) {
				tempVettore[dimensioni] = vettore[i];
				dimensioni++;
				}
			}
		tempVettore = Arrays.copyOf(tempVettore, dimensioni);
		return (new Filtro(tempVettore));
	}
	
	public Filtro passaBasso(int k) {
		int [] tempVettore = new int[vettore.length];
		int dimensioni = 0;
		for (int i=0; i<vettore.length; i++) {
				if (vettore[i] <= k ) {
				tempVettore[dimensioni]=vettore[i];
				dimensioni++;
				}
			}
		tempVettore = Arrays.copyOf(tempVettore, dimensioni);
		return (new Filtro(tempVettore));
	}
	
	public Filtro passaAlto(int k){
		int [] tempVettore = new int[vettore.length];
		int dimensioni = 0;
		for (int i=0; i<vettore.length; i++) {
				if (vettore[i] >= k ) {
				tempVettore[dimensioni]=vettore[i];
				dimensioni++;
				}
			}
		tempVettore = Arrays.copyOf(tempVettore, dimensioni);
		return (new Filtro(tempVettore));
	}
	
	public void stampa() {
		System.out.println(Arrays.toString(vettore));
	}
}
