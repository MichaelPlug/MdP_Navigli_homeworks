public class FrasePalindroma {

	public static boolean palindroma(String frase) {
		for (int i=0; i<(frase.length()/2); i++) 
			if (frase.charAt(i) != frase.charAt(frase.length()-i-1)) return false;
		return true;
	}
	
	public static void test() {
		System.out.println(palindroma("anna"));
		System.out.println(palindroma("radar"));
		System.out.println(palindroma("angelalavalalegna"));
		System.out.println(palindroma("itopinonavevanonipoti"));
		System.out.println(!(palindroma("ottovolante")));
		System.out.println(palindroma("c"));
		System.out.println(!(palindroma("cinque")));
	}
}
