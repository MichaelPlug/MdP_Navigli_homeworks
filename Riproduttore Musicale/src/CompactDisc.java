import java.util.ArrayList;

public class CompactDisc extends Supporto{

	private final int MEMORIA = 15;
	
	public CompactDisc(Brano... tracklist) {
		memoria = MEMORIA;
		this.tracklist = new ArrayList<Brano>();
		for (int i = 0; i < tracklist.length && i < memoria; i++) 
			this.tracklist.add(tracklist[i]);
	}
}
