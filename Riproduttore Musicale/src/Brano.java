
public class Brano {

	private String titolo;
	private String autore;
	private String album;
	private double durata;	
	
	public Brano(String titolo, String autore, String album, double durata) {
		this.titolo = titolo;
		this.autore = autore;
		this.album = album;
		if (durata > 0)
			this.durata = durata;
		else durata = 5.1;
	}
	
	public String toString() {
		return titolo + ", " + autore + ", " + album;
	}
	
	public double getDurata() {
		return durata;
	}
	
}
