import static org.junit.Assert.*;

import org.junit.Test;

import RiproduttoreMusicale.DiscoNonPresenteException;

public class RiproduttoreMusicaleTest {

	@Test
	public void test() throws MemoriaInsufficenteException, IndexNegativeException, SupportoNonCompatibileException, SupportoGiaAllocatoException, DiscoNonPresenteException, StopException {
		RiproduttoreMusicale gd = new Giradischi();
		Disco33 cd = new Disco33(new Brano("La soluzione", "Tranne te", "Bugiardo", 3.5), 
				new Brano("Ex Contadino", "Dargen D'amico", "Di Vizi di forma virtù", 5.1));
		cd.add(new Brano("Chebbomba", "Two Fingerz", "Il disco nuovo", 2.1));
		gd.inserisciSupporto(cd);
		gd.play();
		gd.prev();
		gd.next();
		RiproduttoreMusicale ggdd = new Giradischi();
	//	ggdd.next();
	//	ggdd.stop();
		assertEquals(gd.toString(), new Brano("Ex Contadino", "Dargen D'amico", "Di Vizi di forma virtù", 5.1).toString());
		gd.espelliSupporto();
		assertEquals(gd.disco, null);
	}

}
