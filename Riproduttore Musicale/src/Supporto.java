import java.util.ArrayList;

public abstract class Supporto{

	protected ArrayList<Brano> tracklist = new ArrayList<Brano>();
	protected int memoria;
/*	
	public void addBrano(Brano track) {
		if (tracklist.size() < memoria -1)
				tracklist.add(track);
	}
	*/
	
	public int getSize() {
		return tracklist.size();
	}
	
	public Brano getBrano(int i) {
		return tracklist.get(i); 
		}
	
	public void add(Brano track) throws MemoriaInsufficenteException, IndexNegativeException{
		if (memoria <= tracklist.size()) {
			throw new MemoriaInsufficenteException();
		}
		else tracklist.add(track);
	}
}


