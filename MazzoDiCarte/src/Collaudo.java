
public class Collaudo {

	public static void test() {
		MazzoDiCarte m = new MazzoDiCarte();
		m.mescola();
		for (int i=1; i<=52; i++ ) m.distribuisci().stampa();
		}

}
