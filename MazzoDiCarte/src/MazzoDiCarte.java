public class MazzoDiCarte {

	private Carta[] carte = new Carta[52];
	private int carteDistribuite;
	
	public MazzoDiCarte(){
		for (int i=0; i<=12; i++) {
			carte[i] = new Carta(i+1, 'c');
			carte[i+13] = new Carta(i+1, 'q');
			carte[i+26] = new Carta(i+1, 'f');
			carte[i+39] = new Carta(i+1, 'p');
		}
		carteDistribuite=0;
	}
	
	public void scambia(int a, int b){
		Carta temp = carte[a];
		carte[a] = carte[b];
		carte[b] = temp;
	}
	
	public void mescola () {
		carteDistribuite = 0;
		int cartaCasuale;
		for (int i=0; i<52; i++) {
			cartaCasuale= (int) (Math.random()*52);
		//	System.out.println(cartaCasuale);  Controllo i valore di cartaCasuale
			scambia (i, cartaCasuale);
		}
	}
	
	public Carta distribuisci () {
		carteDistribuite++;
		return carte[carteDistribuite -1];
	}

}
