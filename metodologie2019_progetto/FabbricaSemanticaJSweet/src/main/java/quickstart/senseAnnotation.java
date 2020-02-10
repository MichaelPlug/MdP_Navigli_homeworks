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
 * Classe contente il main per la generazione della pagina senseAnnotation.html
 * @author miche
 */

public class senseAnnotation{
	
	public static final String SERVLET_URL = "senseAnnotation.jsp";
	public static final String REST_URL =  "nextExample.jsp";
	
	public static final String ETICHETTA = "Data la seguente parola fornire il corretto significato";
			
	public static void main (String args[]){
		
		HTMLFormElement form = Builder.createForm();
		form.action = SERVLET_URL;

		
		HTMLInputElement checkboxA = Builder.getCheckbox("A-answer");
		HTMLInputElement checkboxB = Builder.getCheckbox("B-answer");
		HTMLInputElement checkboxC = Builder.getCheckbox("C-answer");
		HTMLInputElement checkboxD = Builder.getCheckbox("D-answer");
		
		HTMLLabelElement senseA =  Builder.createAnswer();
		HTMLLabelElement senseB =  Builder.createAnswer();
		HTMLLabelElement senseC =  Builder.createAnswer();
		HTMLLabelElement senseD =  Builder.createAnswer();
		

		//una etichetta che contiene la parola
		console.log("creating word");
		HTMLLabelElement word =  Builder.createWord();
		
		// ---------------PRENDIAMO L'ESEMPIO DAL SERVER ------------------- 
		//Object result e' il nostro oggetto JSON
		$.getJSON(REST_URL, "task=SENSE_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word"); //i.e. json.get("word")
			String[] sSenses = json.$get("senses");//i.e. json.get("description")
			
			$(word).text(sWord);
			$(senseA).text(sSenses[0]);
			console.log(sSenses[0]);
			$(senseB).text(sSenses[1]);
			console.log(sSenses[1]);
			$(senseC).text(sSenses[2]);
			console.log(sSenses[2]);
			$(senseD).text(sSenses[3]);
			console.log(sSenses[3]);
			return null;
		});

		HTMLDivElement divEtichetta = Builder.createDivEtichetta(ETICHETTA);

		
		//---------------FORMATTIAMO LA PAGINA CON BOOTSTRAP -------------------
		//per formattare meglio la pagina si usano dei contenitori chiamati <div>
		//in bootstrap ogni div con calsse form-group viene visualizzato come blocco separato, uno sotto l'altro
		HTMLDivElement divWord = Builder.createDiv();
		$(divWord).append(word);

		HTMLDivElement divAnswers = Builder.createDiv();
		$(divAnswers).append(Builder.createDivAnswer(checkboxA, senseA));		
		$(divAnswers).append(Builder.createDivAnswer(checkboxB, senseB));		
		$(divAnswers).append(Builder.createDivAnswer(checkboxC, senseC));		
		$(divAnswers).append(Builder.createDivAnswer(checkboxD, senseD));		


		HTMLDivElement divButtons= Builder.createDivButtons();
		
		HTMLDivElement divBar = Builder.createDivBar();
		$("body").append(divBar);
		
		$(form).css("margin", "0% 1.5%"); // mettiamo un po' di spazio ai lati dx e sx della form e 0% di spazio sopra e sotto 
		
		console.log("adding to form");
		// aggiungiamo tutti gli elementi alla form, l'ordine e' importante
		$(form).append(divEtichetta);

		$(form).append(divWord);
		$(form).append(divAnswers);
		$(form).append(divButtons);
		console.log("adding to body");
		//aggiungiamo la form al corpo della pagina
		$("body").append(form);
		

	}
}