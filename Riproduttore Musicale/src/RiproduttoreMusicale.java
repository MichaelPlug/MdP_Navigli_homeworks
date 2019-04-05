public abstract class RiproduttoreMusicale {
	
	protected Supporto disco = null;
	protected boolean play = false;
	protected int numeroBrano = -1;
	
	abstract public void inserisciSupporto(Supporto sup) throws SupportoNonCompatibileException, SupportoGiaAllocatoException;
	
	public Supporto espelliSupporto() {
		Supporto c = disco;
		disco = null;
		return c;
	}
	
	public Brano getBrano() {	
		if (play) return disco.getBrano(numeroBrano);
		return null;
	}
		
	public Brano play() throws DiscoNonPresenteException{	
		if (disco == null) throw new DiscoNonPresenteException();
		if (disco.getSize() != 0) {
			play = true;
			numeroBrano = 0;
			return getBrano();
		}
		return null;
	}
	
	public void stop() throws DiscoNonPresenteException{
		if (disco == null) throw new DiscoNonPresenteException();
		play = false;
		numeroBrano = -1;
	}
	
	public Brano next() throws DiscoNonPresenteException, StopException{
		if (disco == null) throw new DiscoNonPresenteException();
		if (!play) throw new StopException();
		if (numeroBrano < disco.getSize() -1)
			numeroBrano++;
		else
			stop();
		return getBrano();
	}
	
	public Brano prev() throws DiscoNonPresenteException, StopException{
		if (disco == null) throw new DiscoNonPresenteException();
		if (!play) throw new StopException();
		if (numeroBrano > 0)
			numeroBrano--;
		return getBrano();
	}

	@Override
	public String toString(){
		if (disco == null) return null;
		if (!play) return null;
		return getBrano().toString();
	}
}
