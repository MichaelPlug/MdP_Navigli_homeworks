public class StringheVerticali {
	public static void stampaStringheVerticali (String s1, String s2, String s3) {
		int max = s1.length();
		if (s2.length() > max) max = s2.length();
		if (s3.length() > max) max = s3.length();
		
		for (int j = 0; j < max; j++) {
				if (j < s1.length())  System.out.print(s1.charAt(j));
				else System.out.print(" ");
				if (j < s2.length())  System.out.print(s2.charAt(j));
				else System.out.print(" ");
				if (j < s3.length())  System.out.println(s3.charAt(j));
				else System.out.println(" ");
			}

		}
}

