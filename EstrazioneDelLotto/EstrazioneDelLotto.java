
public class EstrazioneDelLotto {
	private int[] ultimaEstrazione;
	private int totaleNumeriEstratti;
	
	public EstrazioneDelLotto() {
		ultimaEstrazione = new int [5];
		for (int i = 0; i < 5; i++) 	ultimaEstrazione[i] = 0;
		totaleNumeriEstratti = 0;
	}
	
	public void estrai() {
		for (int i = 0; i < 5; i++) {
			ultimaEstrazione[i] = (int) (Math.random()*99);
			totaleNumeriEstratti += ultimaEstrazione[i];
		}
	}
	
	public String toString() {
		String stringaEstrazione ="";
		for (int i = 0; i < 5; i++) stringaEstrazione += Integer.toString(ultimaEstrazione[i]) + " ";
		return stringaEstrazione;
	}
	
	public boolean vincita(int [] giocata) {
		boolean b = false; 
		for (int i = 0; i < giocata.length; i++)
			for (int j = 0; j < 5; j++)
				if (giocata[i] == ultimaEstrazione[j]) {if (b) return true; 
														else b = true;}
		return false;		
	}
	
	public int getTotaleNumeriEstratti() {
		return totaleNumeriEstratti;
	}
	
	public static void main (String[] args) {
		EstrazioneDelLotto lotto = new EstrazioneDelLotto();
		lotto.estrai();
		System.out.println(lotto.vincita(new int[] {83, 72, 27, 34, 15, 10, 69, 7, 17, 23, 42, 16, 57, 89, 23, 49, 99, 3, 33, 74, 5, 93, 19, 21}));
		System.out.println(lotto.toString());
		System.out.println(lotto.getTotaleNumeriEstratti());
		lotto.estrai();
		System.out.println(lotto.vincita(new int[] {16, 57, 89, 23, 49, 99, 3, 33}));
		System.out.println(lotto.toString());
		System.out.println(lotto.getTotaleNumeriEstratti());
	}
}