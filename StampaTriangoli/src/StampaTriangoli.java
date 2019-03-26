
public class StampaTriangoli {
	public static void print(int n) {
		if (n%2 == 1)
			for (int i = 1; i <= n; i+=2) {
				for (int j = 1; j <= (n-i)/2; j++)
					System.out.print(" ");
				for (int j=1; j<=i; j++) 
					System.out.print("*");
				for (int j=(n+i)/2; j<=n; j++)
					System.out.print(" ");
				System.out.println("");
				}
	}
}
