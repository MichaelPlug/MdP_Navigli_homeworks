
public class Nastro extends Supporto implements addable{
	private final static int MEMORIA = 5;
	
	public Nastro(Brano... tracklist) {
		memoria = MEMORIA;
		for (int i = 0; i < tracklist.length; i++) 
			if (memoria >= tracklist[i].getDurata()) {
				this.tracklist.add(tracklist[i]);
				memoria -= tracklist[i].getDurata();}
	}
	
	@Override
	public void add(Brano track, int index) throws IndexNegativeException, MemoriaInsufficenteException {
		if (index < 0) throw new IndexNegativeException();
		if (index > this.tracklist.size())
			if (memoria - track.getDurata() >= 0) {
				tracklist.add(track);
				memoria -= track.getDurata();
			}
			else throw new MemoriaInsufficenteException();
		else if (memoria - track.getDurata() + tracklist.get(index).getDurata() >= 0) {
			tracklist.add(index, track);
			memoria += tracklist.get(index).getDurata() - track.getDurata();
			}
			else throw new MemoriaInsufficenteException();
		}

	
	@Override
	public void add(Brano track) throws MemoriaInsufficenteException, IndexNegativeException {
		add(track, tracklist.size());
	}
	
}
