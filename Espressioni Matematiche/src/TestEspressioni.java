import static org.junit.Assert.*;

import org.junit.Test;

public class TestEspressioni {


	
	@Test
	public void testCreaCostante() {
		Costante c = new Costante(10.0);
		double d = c.getValore();
		String ts = c.toString();
		assertEquals("errore nel to string", ts, "10.0");
		assertEquals(c.toString(), "10.0");
		assert d == 10.0;
	}

	
	@Test
	public void testCreaVariabile() {
		Variabile x = new Variabile("Baby");
		Variabile y = new Variabile("Bel", 10);
		assertEquals(x.toString(), "Baby");
		assertEquals(y.toString(), "Bel");
		assert x.getValore() == 0;
		assert y.getValore() == 10;
		y.setVariabile(22);
		assert y.getValore() == 22;
	}
	
	@Test
	public void testOpposto() {
		Opposto c = new Opposto(new Costante (10.0));
		assert c.getValore() == -10.0;
		assertEquals(c.toString(), "-(10.0)");
	}
	
	@Test
	public void testSomma() {
		Somma s = new Somma(new Costante (6), new Variabile("Caccole", 7));
		assertEquals(s.toString(), "(6.0)+(Caccole)");
		assert s.getValore() == 13;
	}
	
	@Test
	public void testSottrazione(){
		Sottrazione s = new Sottrazione(new Costante (6), new Variabile("Yogurt", 7));
		assertEquals(s.toString(), "(6.0)-(Yogurt)");
		assert s.getValore() == -1.0;
	}
	
	@Test
	public void testDivisione() {
		Divisione d = new Divisione(new Variabile("Carbonara", 10), new Costante (2));
		assertEquals(d.toString(), "(Carbonara)/(2.0)");
		assert d.getValore() == 5.0;
	}
	
	@Test
	public void testProdotto() {
		Prodotto p = new Prodotto(new Variabile("More", 7), new Costante (111));
		assertEquals(p.toString(), "(More)*(111.0)");
		assert p.getValore() == 777;
	}
	
	@Test
	public void testModulo() {
		Modulo m = new Modulo(new Variabile("Roccia ho portato il mare a Milano", 10), new Costante (3));
		assertEquals(m.toString(), "(Roccia ho portato il mare a Milano)%(3.0)");
		assert m.getValore() == 1;
	}

	@Test
	public void testFunzione1() {
		Divisione tremezzi = new Divisione(new Costante (3), new Costante (2));
		Somma unpo = new Somma (new Somma(new Costante (5), tremezzi), new Costante (-2));
		Prodotto finale = new Prodotto (new Opposto(unpo), new Variabile("x", 3));
//		assertEquasl(finale.toString(), (-(((5)+(3/2))))
		System.out.println(finale.toString());
		System.out.println(finale.getValore());
		assert finale.getValore() == -13.5;
	}
	
	@Test
	public void testFunzione2() {
		Divisione tremezzi = new Divisione(new Costante (3), new Costante (2));
		Somma unpo = new Somma (new Somma(new Costante (5), tremezzi), new Costante (-2));
		Variabile x = new Variabile("x", 3);
		Prodotto finale = new Prodotto (new Opposto(unpo), x);
		x.setVariabile(6);
		System.out.println(finale.getValore());
		assert finale.getValore() == -27.0;
	}
}
