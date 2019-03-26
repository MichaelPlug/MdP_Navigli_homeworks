import java.util.Arrays;

public class Sequenza {
	private int[] seq;
	
	public Sequenza(int[] arr) {
		seq = Arrays.copyOf(arr, arr.length);
		Arrays.sort(seq);		
	}
	
	public int getMediana() {
		return seq[seq.length /2];
	}
	
	public int getModa() {
		int k = 1;
		int count = 1;
		int valore = seq[0];
		for (int i = 1; i < seq.length; i++)
			if (seq[i-1] == seq [i]) {
				if (++k > count) {
					count = k;
					valore = seq[i];
					}}
				else k=1;
		return valore;
		}
	
	public int getMedia() {
		int tot = 0;
		for (int i = 0; i < seq.length; i++)
			tot += seq[i];
		return tot / seq.length;
	}
	
	public static void main (String[] args) {	
		Sequenza s = new Sequenza(new int [] {10, 9, 73, 44, 5, 5, 8, 9, 10, 9});
		System.out.println(s.getMedia());
		System.out.println(s.getModa());
		System.out.println(s.getMediana());		
	}
}
