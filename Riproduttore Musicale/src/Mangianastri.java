
public class Mangianastri extends RiproduttoreMusicale{
	
	public Mangianastri() {
	}

	@Override
	public void inserisciSupporto(Supporto sup) throws SupportoNonCompatibileException, SupportoGiaAllocatoException{
		if (!(sup instanceof Nastro)) 
			throw new SupportoNonCompatibileException();
		if (disco != null)
			throw new SupportoGiaAllocatoException();
		disco = sup;
	}

}
