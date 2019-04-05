import java.util.Arrays;

public class ListaDiInteri {

	protected int[] list;
	
	public ListaDiInteri(int ...lista) {
		list = Arrays.copyOf(lista, lista.length);
	}

	public int intAt(int i) {
		return list[i];
	}
	
	public int indexOf(int n) {
		for (int i = 0; i<list.length; i++)
			if (list[i]==n) return i;
		return -1;
	}
	
	public boolean thereIs(int n) {
		return indexOf(n) != -1;
	}
	
	public String toString() {
		String s = "";
		for (int i = 0; i<list.length; i++)
			s+= list[i] + " ";
		return s;
	}
	
	public int getLength() {
		return list.length;
	}
	
	public void aggiungi(int n) {
		this.aggiungi(n, list.length);
	}
	
	public void aggiungi(int n, int i) {
		if (i > list.length) i = list.length;
		if (i < 0) i = 0;
		int[] neoList = new int [list.length +1];
		for (int j = 0; j < i; j++)
			neoList[j] = list[j];
		neoList[i] = n;
		for (int j = i; j < list.length; j++)
			neoList[j+1] = list[j];
		
		list = neoList;
	}
	
	public boolean delateInt(int n) {
		return delateAt(this.indexOf(n));
	}
	
	
	public boolean delateAt(int i) {
		if (i < 0 || i >= list.length) return false;
		int[] neoList = new int[list.length -1];
		for (int j = 0; j < i; j++)
			neoList[j] = list[j];
		for (int j = i+1; j < list.length; j++)
			neoList[j-1] = list[j];
		list = neoList;
		return true;
	}

}
