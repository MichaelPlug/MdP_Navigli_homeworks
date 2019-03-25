
public class StringUTF8 {

	private String UTF8;
	
	public StringUTF8 (int[] UTF8) {
		this.UTF8 = "";
		for (int i = 0; i < UTF8.length; i++)
			this.UTF8 += (char) UTF8[i];
	}
	
	public String toString() {
		return UTF8;
	}
}
