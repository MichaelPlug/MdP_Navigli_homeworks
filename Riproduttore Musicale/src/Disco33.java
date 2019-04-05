
public class Disco33 extends Vinile {

	private final static int MEMORIA = 14;
	
	public Disco33(Brano... tracklist) {
		memoria = MEMORIA;
		for (int i = 0; i < tracklist.length & i < memoria; i++) 
			this.tracklist.add(tracklist[i]);
	}
}
