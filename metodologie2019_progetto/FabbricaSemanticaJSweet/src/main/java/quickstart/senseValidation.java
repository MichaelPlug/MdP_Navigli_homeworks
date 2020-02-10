package quickstart;

import static def.dom.Globals.console;

import static def.jquery.Globals.$;

import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import def.js.JSON;

/**
 * Classe contente il main per la generazione della pagina senseValidation.html
 * @author miche
 *
 */

public class senseValidation{
	
	public static final String SERVLET_URL = "senseValidation.jsp";
	public static final String REST_URL =  "nextExample.jsp";
	public static final String TASK = "task=SENSE_VALIDATION";
	public static final String ETICHETTA = "Data la seguente parola e la frase in cui appare, verificare se il senso fornito dal sistema sia appropriato";
	
	public static void main (String args[]){
		
		//creaiamo una form, che e' il contenitore di tutti i pulsanti, caselle di testo, ecc.
		HTMLFormElement form = Builder.createForm();
		form.action = SERVLET_URL; //impostiamo a quale URL inviare i dati quando premiamo "Invio" o un pulsante submit.
		
		HTMLLabelElement word = Builder.createWord();
		
		HTMLLabelElement example = Builder.createDescription();
		HTMLDivElement divEtichetta = Builder.createDivEtichetta(ETICHETTA);
		HTMLLabelElement sense = Builder.createDescription();


		// ---------------PRENDIAMO L'ESEMPIO DAL SERVER ------------------- 
		//Object result e' il nostro oggetto JSON
		$.getJSON(REST_URL, TASK, (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word"); //i.e. json.get("word")
			$(word).text(sWord);
			console.log(word);
			String sExample = json.$get("example");
			$(example).text(sExample);
			console.log(example);
			String sSense = json.$get("sense");
			$(sense).text(sSense); 
			console.log(sense);
			return null;
		});

		$.getJSON(REST_URL, "task=SENSE_VALIDATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word"); //i.e. json.get("word")
			$(word).text(sWord);
			return null;
		});
		
		HTMLInputElement radioButtonY = Builder.getRadioButton("YES", "asnwer");
		HTMLLabelElement etichettaY = Builder.createAnswer("Si");
		HTMLInputElement radioButtonN = Builder.getRadioButton("NO", "asnwer");
		HTMLLabelElement etichettaN = Builder.createAnswer("No");
		
		//---------------FORMATTIAMO LA PAGINA CON BOOTSTRAP -------------------
		//per formattare meglio la pagina si usano dei contenitori chiamati <div>
		//in bootstrap ogni div con calsse form-group viene visualizzato come blocco separato, uno sotto l'altro
		HTMLDivElement divWord = Builder.createDiv(word);
		HTMLDivElement divExample = Builder.createDiv(example);
		HTMLDivElement divSense = Builder.createDiv(sense);
		
		HTMLDivElement divRadioButton = Builder.createDiv();
		$(divRadioButton).append(Builder.createDivAnswer(radioButtonY, etichettaY), Builder.createDivAnswer(radioButtonN, etichettaN));
		
		HTMLDivElement divButtons= Builder.createDivButtons();
		
		HTMLDivElement divBar = Builder.createDivBar();
		$("body").append(divBar);
		
		$(form).css("margin", "0% 1.5%"); // mettiamo un po' di spazio ai lati dx e sx della form e 0% di spazio sopra e sotto 
		
		console.log("adding to form");
		// aggiungiamo tutti gli elementi alla form, l'ordine e' importante
		$(form).append(divEtichetta);
		$(form).append(divWord);
		$(form).append(divExample);
		$(form).append(divSense);
		$(form).append(divRadioButton);
		$(form).append(divButtons);
		console.log("adding to body");
		//aggiungiamo la form al corpo della pagina
		$("body").append(form);
		
	}

}