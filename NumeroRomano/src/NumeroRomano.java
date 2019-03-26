
public class NumeroRomano {

	private String numero;
	
	public NumeroRomano(String numero) {
		this.numero = numero.toUpperCase();
	}

	public int toInteger() {
		int appo = getValue(numero.charAt(numero.length()-1));
		int temp = getValue(numero.charAt(numero.length()-1));
		int pippo;
		for (int i = numero.length()-2; i>=0; i--) {
			pippo = getValue(numero.charAt(i));
			if (pippo >= appo) 
				temp += pippo;
			else temp -= pippo;
			appo = pippo;
			}
		return temp;
	}	
	


	int getValue(char let) {
		switch (let){
			case 'M': return 1000;
			case 'D': return 500;
			case 'C': return 100;
			case 'L': return 50; 
			case 'X': return 10;
			case 'V': return 5; 
			case 'I': return 1;
			default: return 0;	
		}
	}
}
	
