
public class Stringa42 {
	private String stringa42;
	
	public Stringa42(String s1, String s2, String s3) {
		StringBuilder sb = new StringBuilder();		
		sb.append(s1).append(" ").append(s2).append(" ").append(s3);
		stringa42 = sb.toString();
		if (stringa42.length() > 42)
			stringa42 = stringa42.substring(42);
	}
	
	public String toString() {
		return stringa42;
	}
	
	public char getIniziale() {
		return stringa42.charAt(0);
	}
	
	public boolean terna() {
		return stringa42.equals("42 42 42");
	}
	
	public boolean contiene() {
		return stringa42.indexOf("42") != -1;
	}
	
}
