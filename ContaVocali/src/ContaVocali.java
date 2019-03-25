
public class ContaVocali {
	public static void stampaConteggio(String frase) {
		int a=0, e=0, i=0, o=0, u=0;
		
		for (int index = 0; index < frase.length(); index++)
			switch (frase.charAt(index)) {
			case 'a':
				a++;
				break;
			case 'e':
				e++;
				break;
			case 'i':
				i++;
				break;
			case 'o':
				o++;
				break;
			case 'u':
				u++;
				break;
			}
		
		System.out.println("a=" + a + ", e=" + e +", i="+ i +", o=" +o+ ", u=" + u);
	}
	
}