package quickstart;

import static def.jquery.Globals.$;

import def.dom.HTMLDivElement;
import def.dom.HTMLElement;
import def.dom.HTMLInputElement;

/**
 * Classe contente il main per la generazione della pagina home.html
 * @author miche
 */

public class Home {
	
	private static final String STARTER_TEXT = "Inizia";

	public static void main(String args[]) {
		
		HTMLDivElement divBar = createDivBar();
		HTMLInputElement start = getStarter();
		$("body").css("text-align", "center");
		$("body").append(divBar);
		$("body").append(start);
        $("body").css("margin", "2% 1.5%");	

	}
	
	/**
	 * La funzione ritorna un bottone per avviare il sistema
	 * @return bottone start
	 */
	private static HTMLInputElement getStarter() {
		return Builder.createButtonRandomLink(STARTER_TEXT);
	}	
	
	/**
	 * La funzione ritorna un element HTMLDivElement contente il link per uscire
	 * dal propro account
	 * @return HTMLDivElement contente il link a .logout.jsp
	 */ 
	private static HTMLDivElement createDivBar() {
		HTMLElement signUpLink = Builder.getLink("Esci", "./logout.jsp");
		$(signUpLink).css("margin", "0% 1.5%");
		$(signUpLink).css("float", "right");
		HTMLDivElement divBar = Builder.createDiv();
		$(divBar).append(signUpLink);
		$(divBar).css("margin", "0% 1.5%");
		return divBar;	
	}

}
