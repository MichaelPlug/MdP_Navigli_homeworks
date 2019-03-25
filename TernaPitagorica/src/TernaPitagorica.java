
public class TernaPitagorica {
	public static void printTriplePitagoriche(int N) {
		double c;
		for (int i = 1; i <= N; i++)
			for (int j = i; j <= N; j++) {
				c = Math.sqrt(((double) i*i + j*j));
				if (c == (int) c && c<= N)
					System.out.println("a="+i+" b="+j+" c="+c);
			}
	}

}
