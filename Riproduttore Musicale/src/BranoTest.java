import static org.junit.Assert.*;

import org.junit.Test;

public class BranoTest {

	@Test
	public void stampaInfoTest() {
		Brano a = new Brano ("La soluzione", "Fabri Fibra", "Bugiardo", 3.1);
		System.out.println(a.toString());
		assertEquals(a.toString(), "La soluzione, Fabri Fibra, Bugiardo");
	}
	
	@Test
	public void getDurataTest() {
		Brano a = new Brano ("Ex Contadino", "Dargen D'amico", "Di Vizi di Forma Virtù", 5.1);
		assert a.getDurata() == 5.1;
	}
}
