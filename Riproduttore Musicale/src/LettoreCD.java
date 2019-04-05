
public class LettoreCD extends RiproduttoreMusicale {

	public LettoreCD(){
		
	}
	
	@Override
	public void inserisciSupporto(Supporto sup) throws SupportoNonCompatibileException, SupportoGiaAllocatoException{
		if (!(sup instanceof CompactDisc))
			throw new SupportoNonCompatibileException();
		if (disco != null)
			throw new SupportoGiaAllocatoException();
		disco = sup;
	}
}
