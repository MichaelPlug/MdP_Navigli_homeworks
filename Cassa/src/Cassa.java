public class Cassa{	
	
	private int prezzoDiVendita;
	private int importoPagato;
	
	public Cassa (int prezzoDiVendita) {
		this.prezzoDiVendita = prezzoDiVendita;
		importoPagato = 0;
	}
	
	public int pagamento (int importoPagato) {
		this.importoPagato += importoPagato;
		int resto = this.importoPagato - prezzoDiVendita;	
		stampaRisultato(resto);	
		return resto;
	}	
	
	public void stampaRisultato (int resto) {
		if (resto==0) System.out.println("Transazione completata");
		else if (resto>0) System.out.println("Transazione completata, resto: "+ resto +"EUR");
		else System.out.println("Pagamento insufficente, debito di "+ (-resto)+"EUR");
	}
}
