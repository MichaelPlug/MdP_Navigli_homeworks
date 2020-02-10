package quickstart;

import static def.dom.Globals.console;
import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.HTMLDivElement;
import def.dom.HTMLElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLOptionElement;
import def.dom.HTMLSelectElement;
import jsweet.util.StringTypes;

/**
 *  Classe contente il main per la generazione della pagina signup.html
 * @author miche
 *
 */
public class SignUp{

	public static final String SERVLET_URL = "signup.jsp";
	public static final String REST_URL = "home.jsp";
	
	public static final String[] lenguageLevels= {"A1", "A2", "B1", "B2", "C1", "C2"};
	
	public static void main(String args[]) {
	
		/**
		 * Viene generato il form da inviare alla servlet
		 */
		
        console.log("Creating Log-in form");
        
		HTMLFormElement signup = Builder.createForm();
		signup.action = SERVLET_URL;

		/*
		 * Crea una cornice all'interno della quale vengono "appese" 
		 * le istanze degli altri oggetti, così da creare dei margini
		 * ben definiti.
		 */
		
		
		//form email
		HTMLDivElement mailDiv = Builder.createDiv();
		$(mailDiv).append(Builder.getInputForm("email", "Email"));


		//verifica se la mail è nei server
		
		//password
		HTMLDivElement password1Div = Builder.createDiv();
		$(password1Div).append(Builder.getInputForm("password1", "Password", true));
		
		//ripeti password
		HTMLDivElement password2Div = Builder.createDiv();
		$(password2Div).append(Builder.getInputForm("password2", "Ripeti password", true));

		
		// opzionale - verifica password uguali
		
		
		/*lingue parlate come madrelingua,
		 * questo campo prevede una checkbox (selezione multipla) 
		 * con le lingue presenti nel sistema.
		 * L’utente deve selezionare una o più lingue. 
		 */
		HTMLDivElement ingleseCheckboxDiv = createLanguageCheckbox("Inglese");
		HTMLDivElement italianoCheckboxDiv = createLanguageCheckbox("Italiano");
		
		/*
		 * altre lingue parlate e
		 * il livello con cui sono parlate (A1, A2, B1, B2, C1, C2).
		 * Questo campo è opzionale
		 * (può essere lasciato vuoto dall’utente).
		 */
		
		
		HTMLDivElement linguaExtra = createLinguaExtraDiv();
				
				
	//	HTMLInputElement level = 
		$(signup).append(mailDiv, password1Div, password2Div);
		$(signup).append(ingleseCheckboxDiv, italianoCheckboxDiv, linguaExtra);
		//pulsante chiamato singup, cliccandolo invia i dati al server signup.jsp
		signup.appendChild(Builder.getButton("signUp", "Registrati", "location.href='./home.html';"));
		
		$("body").append(signup);	
		//un link per andare alla pagina di login
		$("body").append(Builder.getLink("Sei registrato?", "/fabbricasemantica/login.html"));
		$("body").css("text-align", "center");
        $(signup).css("margin", "2% 1.5%");	
	}	
	
	
	/**
	 * La funzione ritorna un menu a tendina contente i possibili livelli
	 * di conoscienza di una lingua
	 * @return menu a tendina
	 */
	public static HTMLElement getSelectBox() {
		HTMLSelectElement selectBox = document.createElement(StringTypes.select);
		for (int i = 0; i < lenguageLevels.length; i++) {
			HTMLOptionElement appo = document.createElement(StringTypes.option);
			appo.innerHTML = lenguageLevels[i];
			$(appo).css("value", lenguageLevels[i]);
			selectBox.appendChild(appo);
		}
		return selectBox;
	}
	
	/**
	 * La funzione genera un HTMLDivElement contente uan 
	 * checkbox e una strina di test
	 * @param language stringa di testo affinacata alla checkbox
	 * @return HTMLDivElement con checkbox e una stringa di testo
	 */
	private static HTMLDivElement createLanguageCheckbox(String language) {
		HTMLDivElement div = Builder.createDiv();
		HTMLInputElement checkbox = Builder.getCheckbox(language);
		div.appendChild(checkbox);
		div.appendChild(document.createTextNode(language));
		return div;
	}
	
	/**
	 * La funzione genera un HTMLDivElement contente
	 * una casella di test per inserire un altra lingua e un menù
	 * a tendina per indicare il livello di conoscienza
	 * @return HTMLDivElement per l'inserimento di un altra lingua
	 */
	private static HTMLDivElement createLinguaExtraDiv() {
		HTMLDivElement div = Builder.createDiv();
		HTMLInputElement linguaExtra = Builder.getInputForm("Altre lingue", "Inserisci un altra lingua");
		$(div).append(linguaExtra);
		$(div).append(getSelectBox());
		return div;
	}
}