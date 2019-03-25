public class ConversioneNumeri{
	
	private int baseDecimale;
	
	public ConversioneNumeri(int baseDecimale){
		this.baseDecimale = baseDecimale;
	}
	
	public ConversioneNumeri(String baseDecimale) {
		this.baseDecimale = Integer.parseInt(baseDecimale);
	}
	
	public String conversione (int nuovaBase) {
		String numeroConvertito = "";
		int copia = baseDecimale;
		do {	numeroConvertito=copia%nuovaBase+numeroConvertito;
				copia = copia/nuovaBase;
		}while (copia != 0);
		return numeroConvertito;
	}
}
