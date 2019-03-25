public class SommaNumeriPrecedenti {
	public static void sNP(int a, int b,int n) {
		int appo;
		System.out.print(a +", "+ b);
		for (int i = 0; i < n; i++) {
			appo = b;
			b = a + b;
			a = appo;
			System.out.print(", "+b);
		}
	}
}

