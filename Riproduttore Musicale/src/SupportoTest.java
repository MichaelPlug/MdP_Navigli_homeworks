import static org.junit.Assert.*;

import org.junit.Test;

public class SupportoTest {
	
	@Test
	public void testCompactDisc() throws MemoriaInsufficenteException, IndexNegativeException {
		CompactDisc cd = new CompactDisc(new Brano("La soluzione", "Tranne te", "Bugiardo", 3.5), 
			new Brano("Ex Contadino", "Dargen D'amico", "Di Vizi di forma virtù", 5.1));
		cd.add(new Brano("Chebbomba", "Two Fingerz", "Il disco nuovo", 2.1));
		assert cd.getSize() == 3;
		assertEquals(cd.getBrano(1).toString(), new Brano("Ex Contadino", "Dargen D'amico", "Di Vizi di forma virtù", 5.1).toString());
	}
	@Test
	public void testDisco33() throws MemoriaInsufficenteException, IndexNegativeException {
		 Disco33 cd = new Disco33(new Brano("La soluzione", "Tranne te", "Bugiardo", 3.5), 
				new Brano("Ex Contadino", "Dargen D'amico", "Di Vizi di forma virtù", 5.1));
			cd.add(new Brano("Chebbomba", "Two Fingerz", "Il disco nuovo", 2.1));
			assert cd.getSize() == 3;
			assertEquals(cd.getBrano(1).toString(), new Brano("Ex Contadino", "Dargen D'amico", "Di Vizi di forma virtù", 5.1).toString());
	}
	@Test
	public void instanceOf() {
		Supporto d1 = new Disco33();
		Supporto d2 = new Disco45();
		Supporto cd = new CompactDisc();
		assertTrue(d1 instanceof Vinile);
		assertTrue(d2 instanceof Vinile);
		assertFalse(cd instanceof Vinile);
	}
	@Test 
	public void testDisco45() {
		 Disco45 cd = new Disco45(new Brano("La soluzione", "Tranne te", "Bugiardo", 3.5), 
					new Brano("Ex Contadino", "Dargen D'amico", "Di Vizi di forma virtù", 5.1),
					new Brano("Chebbomba", "Two Fingerz", "Il disco nuovo", 2.1));
		//		cd.add(new Brano("Chebbomba", "Two Fingerz", "Il disco nuovo", 2.1));
				assert cd.getSize() == 2;
				assertEquals(cd.getBrano(1).toString(), new Brano("Ex Contadino", "Dargen D'amico", "Di Vizi di forma virtù", 5.1).toString());
		//		assertEquals(cd.getBrano(2), null);
	}
	@Test
	public void testNastro() {
		Supporto na = new Nastro(new Brano("A", "A", "A", 0.5),
				new Brano("B", "B", "B", 5.5),
				new Brano("C", "C", "C", 3.5),
				new Brano("D", "D", "D", 2.0)
				);
		assert na.getSize() == 2;
		assertEquals(na.getBrano(1).toString(), "C, C, C");
	}
	@Test
	public void MemoriaUSB() {
		Supporto musb = new MemoriaUSB(new Brano("La soluzione", "Tranne te", "Bugiardo", 3.5), 
					new Brano("Ex Contadino", "Dargen D'amico", "Di Vizi di forma virtù", 5.1),
					new Brano("Chebbomba", "Two Fingerz", "Il disco nuovo", 2.1));
		assert musb.getSize() == 3;
	}
}
;