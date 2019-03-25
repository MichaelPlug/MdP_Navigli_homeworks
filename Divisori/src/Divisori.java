public class Divisori {
	public static void printDivisori(int n) {
		for (int i = 1; i <= n; i++) {
			if (((int) n/i) *i == n) System.out.print(i+" ");
		}
	}
	
	public static void main (String[] args) {
		printDivisori(20);
	}
}
