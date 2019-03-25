
public class Programmatore {

	private String nome;
	private String cognome;
	private String azienda;
	private String linguaggi;
	
	public Programmatore(String nome, String cognome) {
		this.nome=nome;
		this.cognome=cognome;
		this.linguaggi="";
	}

	public void setAzienda(String azienda) {
		this.azienda = azienda;
	}
	
	public void addLinguaggio(String linguaggio) {
		linguaggi += linguaggio + " ";
	}
	
	public String getNome(){
		return nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public String getAzienda(){
		return azienda;
	}
	
	public String getLinguaggi() {
		return linguaggi;
	}
}