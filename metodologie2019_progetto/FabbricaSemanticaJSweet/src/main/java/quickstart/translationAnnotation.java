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
 *  Classe contente il main per la generazione della pagina translationAnnotation.html
 * @author miche
 *
 */
public class translationAnnotation{
	
	public static final String SERVLET_URL = "translationAnnotation.jsp";
	public static final String REST_URL =  "nextExample.jsp";
	public static final String TASK = "task=TRANSLATION_ANNOTATION";
	public static final String ETICHETTA = "Data la seguente parola e definizione in inglese, fornire la traduzione nella tua lingua madre";
			
	public static void main (String args[]){
		
		HTMLFormElement form = Builder.createForm();
		form.action = SERVLET_URL;
	
		HTMLLabelElement description = Builder.createDescription();

		HTMLLabelElement word = Builder.createWord();

		HTMLTextAreaElement translation = Builder.createTranslationTextArea();
		
		// ---------------PRENDIAMO L'ESEMPIO DAL SERVER ------------------- 
		//Object result e' il nostro oggetto JSON
		$.getJSON(REST_URL, "task=TRANSLATION_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word"); //i.e. json.get("word")
			String sDescription = json.$get("description"); //i.e. json.get("description")
			console.log("ciao");
			$(word).text(sWord);
			$(description).text(sDescription);
			return null;
		});

		console.log(word);
	
		
		//---------------FORMATTIAMO LA PAGINA CON BOOTSTRAP -------------------
		//per formattare meglio la pagina si usano dei contenitori chiamati <div>
		//in bootstrap ogni div con calsse form-group viene visualizzato come blocco separato, uno sotto l'altro
		HTMLDivElement divWord = Builder.createDiv();
		$(divWord).append(word);

		HTMLDivElement divEtichetta = Builder.createDivEtichetta(ETICHETTA);
		
		HTMLDivElement divDescription =  Builder.createDiv();
		$(divDescription).append(description);
		
		HTMLDivElement divTranslation =  Builder.createDiv();
		
		HTMLLabelElement label = document.createElement(StringTypes.label);
		label.textContent = "Traduzione:";
		$(divTranslation).append(label);
		$(divTranslation).append(translation);
		
		HTMLDivElement divButtons=  Builder.createDivButtons();
		
		HTMLDivElement divBar = Builder.createDivBar();
		$("body").append(divBar);
		
		$(form).css("margin", "0% 1.5%"); // mettiamo un po' di spazio ai lati dx e sx della form e 0% di spazio sopra e sotto 
		
		console.log("adding to form");
		// aggiungiamo tutti gli elementi alla form, l'ordine e' importante
		$(form).append(divEtichetta);
		$(form).append(divWord);
		$(form).append(divDescription);
		$(form).append(divTranslation);
		$(form).append(divButtons);
		console.log("adding to body");
		//aggiungiamo la form al corpo della pagina
		$("body").append(form);
	}

}