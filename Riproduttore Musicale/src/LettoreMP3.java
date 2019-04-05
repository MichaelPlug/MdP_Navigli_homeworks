
public class LettoreMP3 extends RiproduttoreMusicale{
	public LettoreMP3() {
	}

	@Override
	public void inserisciSupporto(Supporto sup) throws SupportoNonCompatibileException, SupportoGiaAllocatoException{
		if (!(sup instanceof MemoriaUSB))
			throw new SupportoNonCompatibileException();
		if (disco != null)
			throw new SupportoGiaAllocatoException();
		disco = sup;
	}
}
