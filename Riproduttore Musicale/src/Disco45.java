
public class Disco45 extends Vinile {
	
	private final static int MEMORIA = 2;
	
	public Disco45(Brano... tracklist) {
		memoria = MEMORIA;
		for (int i = 0; i < tracklist.length & i < memoria; i++) 
			this.tracklist.add(tracklist[i]);
	}

}
