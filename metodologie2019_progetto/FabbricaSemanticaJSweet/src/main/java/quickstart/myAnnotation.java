package quickstart;

import static def.dom.Globals.console;
import static def.jquery.Globals.$;

import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;


/**
 * Classe contente il main per la generazione della pagina myAnnotation.html
 * @author miche
 */

public class myAnnotation{
	
	public static final String SERVLET_URL = "myAnnotation.jsp";
	public static final String ETICHETTA = "Date le seguenti parole verificare se esse sono sinonimi";
	public static final String PAROLA1 = "Banana";
	public static final String PAROLA2 = "Car";

	
	public static void main (String args[]){

		//creaiamo una form, che e' il contenitore di tutti i pulsanti, caselle di testo, ecc.
		HTMLFormElement form = Builder.createForm();
		form.action = SERVLET_URL; //impostiamo a quale URL inviare i dati quando premiamo "Invio" o un pulsante submit.
		
		HTMLLabelElement word1 = Builder.createWord();
		HTMLLabelElement word2 = Builder.createWord();
		
		word1.innerHTML = PAROLA1;
		word2.innerHTML = PAROLA2;

		HTMLInputElement radioButtonY = Builder.getRadioButton("YES", "asnwer");
		HTMLLabelElement etichettaY = Builder.createAnswer("Si");
		HTMLInputElement radioButtonN = Builder.getRadioButton("NO", "asnwer");
		HTMLLabelElement etichettaN = Builder.createAnswer("No");
		
		//---------------FORMATTIAMO LA PAGINA CON BOOTSTRAP -------------------
		//per formattare meglio la pagina si usano dei contenitori chiamati <div>
		//in bootstrap ogni div con calsse form-group viene visualizzato come blocco separato, uno sotto l'altro
		HTMLDivElement divWord1 = Builder.createDiv(word1);
		HTMLDivElement divWord2 = Builder.createDiv(word2);

		HTMLDivElement divEtichetta = Builder.createDivEtichetta(ETICHETTA);
		
		HTMLDivElement divRadioButton = Builder.createDiv();
		$(divRadioButton).append(Builder.createDivAnswer(radioButtonY, etichettaY), Builder.createDivAnswer(radioButtonN, etichettaN));
		
		HTMLDivElement divButtons= Builder.createDivButtons();

		HTMLDivElement divBar = Builder.createDivBar();
		$("body").append(divBar);
		
		$(form).css("margin", "0% 1.5%"); // mettiamo un po' di spazio ai lati dx e sx della form e 0% di spazio sopra e sotto 
		
		console.log("adding to form");
		// aggiungiamo tutti gli elementi alla form, l'ordine e' importante
		$(form).append(divEtichetta);
		$(form).append(divWord1);
		$(form).append(divWord2);
		$(form).append(divRadioButton);
		$(form).append(divButtons);
		console.log("adding to body");
		//aggiungiamo la form al corpo della pagina
		$("body").append(form);
	}

}