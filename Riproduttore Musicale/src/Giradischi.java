
public class Giradischi extends RiproduttoreMusicale{
	
	public Giradischi() {
	}

	@Override
	public void inserisciSupporto(Supporto sup) throws SupportoNonCompatibileException, SupportoGiaAllocatoException{
		if (!(sup instanceof Vinile))
			throw new SupportoNonCompatibileException();
		if (disco != null)
			throw new SupportoGiaAllocatoException();
		disco = sup;
	}

}
