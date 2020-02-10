package quickstart;

import static def.dom.Globals.console;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;


import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLTextAreaElement;
import def.jquery.JQueryXHR;
import def.js.JSON;
import jsweet.util.StringTypes;

/**
 * Classe contente il main per la generazione della pagina definationAnnotation.html
 * @author miche
 *
 */

public class definitionAnnotation{
	
	public static final String SERVLET_URL = "definitionAnnotation.jsp";
	public static final String REST_URL =  "nextExample.jsp";
	public static final String ETICHETTA = "Data la seguente parola e il suo iperonimo, definirla nella propria lingua madra";
	public static final String TASK = "task=DEFINITION_ANNOTATION";
	public static final String TEXTAREA_PLACEHOLDER = "Inserire qui la tua risposta";
			
	public static void main (String args[]){
		
		HTMLFormElement form = Builder.createForm();
		form.action = SERVLET_URL;
		
		console.log("creating desct");
		HTMLLabelElement description = Builder.createDescription();

		HTMLLabelElement word = Builder.createWord();
		
		HTMLDivElement divEtichetta = Builder.createDivEtichetta(ETICHETTA);

		HTMLTextAreaElement answer = Builder.createTextArea("answer", TEXTAREA_PLACEHOLDER);

		
		// ---------------PRENDIAMO L'ESEMPIO DAL SERVER ------------------- 
		//Object result e' il nostro oggetto JSON
		$.getJSON(REST_URL, TASK, (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word"); //i.e. json.get("word")
			String sDescription = json.$get("hypernym"); //i.e. json.get("description");
			$(word).text(sWord);
			$(description).text(sDescription);
			return null;
		});

		console.log(word);
	
		
		
		//---------------FORMATTIAMO LA PAGINA CON BOOTSTRAP -------------------
		//per formattare meglio la pagina si usano dei contenitori chiamati <div>
		//in bootstrap ogni div con calsse form-group viene visualizzato come blocco separato, uno sotto l'altro
		HTMLDivElement divWord = Builder.createDiv(word);

		HTMLDivElement divDescription = Builder.createDiv(description);
		
		HTMLDivElement divAnswer = Builder.createDiv();
		HTMLLabelElement label = document.createElement(StringTypes.label);
		label.textContent = "Definizione:";
		$(divAnswer).append(label);
		$(divAnswer).append(answer);
		
		HTMLDivElement divButtons= Builder.createDivButtons();
		
		HTMLDivElement divBar = Builder.createDivBar();
		$("body").append(divBar);
		
		$(form).css("margin", "0% 1.5%"); // mettiamo un po' di spazio ai lati dx e sx della form e 0% di spazio sopra e sotto 
		
		console.log("adding to form");
		// aggiungiamo tutti gli elementi alla form, l'ordine e' importante
		$(form).append(divEtichetta);
		$(form).append(divWord);
		$(form).append(divDescription);
		$(form).append(divAnswer);
		$(form).append(divButtons);
		console.log("adding to body");
		//aggiungiamo la form al corpo della pagina
		$("body").append(form);
	
	}
}