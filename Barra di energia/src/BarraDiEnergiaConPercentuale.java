public class BarraDiEnergiaConPercentuale extends BarraDiEnergia {
	
	public BarraDiEnergiaConPercentuale() {
		super();
	}
	
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < 10 ; i++)
			if (energia > i) s+="O";
			else s+="=";
		s += " " + energia + "0%";
		return s;
	}

	/*
	public static void main(String[] args) {
		BarraDiEnergia b = new BarraDiEnergia();
		BarraDiEnergiaConPercentuale bc = new BarraDiEnergiaConPercentuale();
		
		b.carica();
		b.carica();
		bc.carica();
		bc.carica();
		bc.carica();
		bc.carica();
		System.out.println(b.toString());
		System.out.println(bc.toString());
	}*/
}
