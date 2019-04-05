public class ListaDiInteriOrdinati extends ListaDiInteri{

	private final boolean ordine;
	
	public ListaDiInteriOrdinati(int[] lista, boolean ordine) {
		this.ordine = ordine;
		list = new int [lista.length];
		int j;
		for (int i = 0; i < lista.length; i++) {
			j = 0;
			// check if the elements are bigger/smaller of the list is end				
			while (j < i&&(((lista[i]>list[j]&&ordine)||(lista[i]<list[j]&&!ordine)))) j++;	
			// shift the list's elements on the right of new element
			for (int k = i; k > j; k--) 
				list[k] = list[k-1];				
			// add new element
			list[j] = lista[i];	
		}
	}
	
	public ListaDiInteriOrdinati(int[] lista) {
		this(lista, true);
	}
	
	public void aggiungiInCoda(int n) {
		if ((n > list[list.length -1] && ordine)||(n < list[list.length -1] && !ordine))
			aggiungi(n);
	}
	
	@Override
	public void aggiungi(int n, int i) {
		if (i > list.length) i = list.length;
		if (i < 0) i = 0;
		if (list.length == 0) list = new int [] {n};
		else if(i == 0) {
			if ((ordine && list[i]>=n)||(!ordine && list[i]<=n))
				super.aggiungi(n, i);
		}
		else if (i == list.length) {
			if (((ordine&&list[i-1]<=n)||(!ordine&&list[i-1]>=n)))
				super.aggiungi(n, i);
		}
		else if((ordine&&list[i]>=n&&n>=list[i-1])||(!ordine&&list[i]<=n&&n<=list[i-1]))
			super.aggiungi(n, i);
		}
			
	/*	
		else if(i==0&&((ordine && list[i]>=n)||(!ordine && list[i]<=n)))
			super.aggiungi(n, i);
		else if(i==list.length&&((ordine&&list[i-1]<=n)||(!ordine&&list[i-1]>=n)))
			super.aggiungi(n, i);
		else if((ordine&&list[i]>=n&&n>=list[i-1])||(!ordine&&list[i]<=n&&n<=list[i-1]))
			super.aggiungi(n, i);
			*/
	
	@Override
	public void aggiungi(int n) {
		// if list is empy create new list
		if(list.length == 0) list = new int [] {n};
		// if its position is the first, add in
		else if ((n<list[0]&&ordine)||(n>list[0]&&!ordine))
			super.aggiungi(n, 0);
		// if its position is the last, add in
//		else if((n>list[list.length]&&ordine)||(n<list[list.length]&&!ordine))
//			super.aggiungi(n);
		int i = 1;
		while (i<list.length&&((list[i]<n&&ordine)||(list[i]>n&&!ordine))) i++;
		super.aggiungi(n, i);
	}
}
