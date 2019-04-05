
public class BarraDiEnergia {
	
	protected int energia;
	
	public BarraDiEnergia() {
		
	}
	
	public void carica() {
		if (energia < 10)	energia++;
	}
	
	public String toString() {		String s = "";
		for (int i = 0; i < 10 ; i++)
			if (energia > i) s+="O";
			else s+="=";
		return s;
	}

}
