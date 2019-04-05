
public class MemoriaUSB extends Supporto implements addable{

	private final static int MEMORIA = 1024;
	
	public MemoriaUSB(Brano... tracklist) {
		memoria = MEMORIA;
		for (int i = 0; i < tracklist.length & i < memoria; i++) 
			this.tracklist.add(tracklist[i]);
	}
	
	
	@Override
	public void add(Brano track, int index) throws IndexNegativeException, MemoriaInsufficenteException {
		if (index < 0) throw new IndexNegativeException();
		if (index > this.tracklist.size())
			if (memoria > tracklist.size()) 
				tracklist.add(track);
			else
				throw new MemoriaInsufficenteException();
		else tracklist.add(index, track);
	}
}
