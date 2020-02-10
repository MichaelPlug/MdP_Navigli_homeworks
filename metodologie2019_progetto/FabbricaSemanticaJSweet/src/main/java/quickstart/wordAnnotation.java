package quickstart;

import static def.dom.Globals.console;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;


import def.dom.HTMLDivElement;

import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLTextAreaElement;
import def.jquery.JQueryXHR;
import def.js.JSON;
import jsweet.util.StringTypes;

/**
 *  Classe contente il main per la generazione della pagina wordAnnotation.html
 * @author miche
 *
 */

public class wordAnnotation{
	
	public static final String SERVLET_URL = "wordAnnotation.jsp";
	public static final String REST_URL =  "nextExample.jsp";
	public static final String TASK = "task=WORD_ANNOTATION";
	public static final String ETICHETTA = "Data la seguente definizione, provare a indovinare il termine definito";
			
	public static void main (String args[]){
		
		//creaiamo una form, che e' il contenitore di tutti i pulsanti, caselle di testo, ecc.
		HTMLFormElement form = Builder.createForm();
		form.action = SERVLET_URL;
		//creiamo una etichetta che contiene la descrizione
		console.log("creating desct");
		HTMLLabelElement description = Builder.createDescription();
		//una etichetta che contiene la parola

		console.log("creating translation");
		HTMLTextAreaElement answer = Builder.createTextArea("answer", "Inserire qui la tua risposta");
		HTMLInputElement submit = Builder.createSubmit();
		HTMLInputElement skip = Builder.createSkip();
		$(skip).css("float", "right"); //il pulsante skip sara' messo piu' a destra possibile
		
		// ---------------PRENDIAMO L'ESEMPIO DAL SERVER ------------------- 
		//Object result e' il nostro oggetto JSON
		$.getJSON(REST_URL, "task=WORD_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;

			String sDescription = json.$get("description"); //i.e. json.get("description")
			console.log("ciao");
			$(description).text(sDescription);
			return null;
		});

	//	console.log(word);
	
		
		
		//---------------FORMATTIAMO LA PAGINA CON BOOTSTRAP -------------------
		//per formattare meglio la pagina si usano dei contenitori chiamati <div>
		//in bootstrap ogni div con calsse form-group viene visualizzato come blocco separato, uno sotto l'altro
		HTMLDivElement divEtichetta = Builder.createDivEtichetta(ETICHETTA);
		
		HTMLDivElement divDescription = Builder.createDiv(description);
		
		HTMLDivElement divAnswer = Builder.createDiv();
		HTMLLabelElement label = document.createElement(StringTypes.label);
		label.textContent = "Risposta:";
		$(divAnswer).append(label);
		$(divAnswer).append(answer);
		
		HTMLDivElement divButtons= Builder.createDiv();
		$(divButtons).append(submit, skip);
		
		HTMLDivElement divBar = Builder.createDivBar();
		$("body").append(divBar);
		
		$(form).css("margin", "0% 1.5%"); // mettiamo un po' di spazio ai lati dx e sx della form e 0% di spazio sopra e sotto 
		
		console.log("adding to form");
		// aggiungiamo tutti gli elementi alla form, l'ordine e' importante
		$(form).append(divEtichetta);
		$(form).append(divDescription);
		$(form).append(divAnswer);
		$(form).append(divButtons);
		console.log("adding to body");
		//aggiungiamo la form al corpo della pagina
		$("body").append(form);
	}

}