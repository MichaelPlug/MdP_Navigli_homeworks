
public class StringaMangiona {
	private String laStringa;
	private int totaleMangiate;
	
	public StringaMangiona(String laStringa) {
		this.laStringa = laStringa;
		
	}
	
	public String toString() {
		return laStringa;
	}
	
	public int lenght() {
		return laStringa.length();
	}
	
	public void mangiaLettera(char pasto) {
		for (int i = 0; i < laStringa.length(); i++)
			if (laStringa.charAt(i) == pasto) {
				laStringa = laStringa.substring(0, i) + laStringa.substring(i+1);
				totaleMangiate++;
			}
	}
	
	public void slurp () {
		totaleMangiate += laStringa.length();
		laStringa = "";
	}
	
	public void mangiaStringaMangiona(StringaMangiona stringaMangiata) {
		String stringa = stringaMangiata.toString();
		for (int i = 0; i < stringa.length(); i++)
			mangiaLettera(stringa.charAt(i));
	}
	
	public int getTotaleMangiate() {
		return totaleMangiate;
	}
	
	
	/*
	public static void main (String[] args) {
		StringaMangiona s = new StringaMangiona("aiuola");
		System.out.println(s.toString());
		s.mangiaLettera('a');
		System.out.println(s.toString());
		System.out.println(s.getTotaleMangiate());
		
		StringaMangiona s1 = new StringaMangiona("hola");
		s.mangiaStringaMangiona(s1);
		System.out.println(s.toString());
		System.out.println(s.getTotaleMangiate());
		System.out.println(s.lenght());
		
		s.slurp();
		System.out.println(s.toString());
		System.out.println(s.getTotaleMangiate());
		System.out.println(s.lenght());
	}
	*/
}
