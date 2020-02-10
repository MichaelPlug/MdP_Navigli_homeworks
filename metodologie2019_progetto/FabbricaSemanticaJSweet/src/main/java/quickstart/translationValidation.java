package quickstart;

import static def.dom.Globals.console;
import static def.jquery.Globals.$;

import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import def.js.JSON;
import jsweet.util.StringTypes;

/**
 *  Classe contente il main per la generazione della pagina translationValidation.html
 * @author miche
 *
 */
public class translationValidation{

	
	public static final String SERVLET_URL = "translationValidation.jsp";
	public static final String REST_URL =  "nextExample.jsp";
	public static final String TASK = "task=TRANSLATION_VALIDATION";
	public static final String ETICHETTA = "Data la seguente parola e la sua definizone scegliere la traduzioni corrette";
			
	public static void main (String args[]){
			
		//creaiamo una form, che e' il contenitore di tutti i pulsanti, caselle di testo, ecc.
		HTMLFormElement form = Builder.createForm();
		form.action = SERVLET_URL; //impostiamo a quale URL inviare i dati quando premiamo "Invio" o un pulsante submit.
		
		HTMLDivElement divEtichetta = Builder.createDivEtichetta(ETICHETTA);
		
		HTMLLabelElement description = Builder.createDescription();
		
		
		HTMLInputElement checkboxA = Builder.getCheckbox("A-answer", "answer");
		HTMLInputElement checkboxB = Builder.getCheckbox("B-answer", "answer");
		HTMLInputElement checkboxC = Builder.getCheckbox("C-answer", "answer");
		HTMLInputElement checkboxD = Builder.getCheckbox("D-answer", "answer");
		
		HTMLLabelElement translationA = Builder.createAnswer();
		HTMLLabelElement translationB = Builder.createAnswer();
		HTMLLabelElement translationC = Builder.createAnswer();
		HTMLLabelElement noTranslation = Builder.createAnswer();
		
		noTranslation.innerText = "Nessuna delle precedenti";
		
		HTMLLabelElement word = Builder.createWord();
		
//		HTMLTextAreaElement translation = Builder.createTranslationTextArea();

		// ---------------PRENDIAMO L'ESEMPIO DAL SERVER ------------------- 
		//Object result e' il nostro oggetto JSON
		$.getJSON(REST_URL, TASK, (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word"); //i.e. json.get("word")
			String sDescription = json.$get("description");
			String[] sTranslations = json.$get("translations");//i.e. json.get("description")
			$(word).text(sWord);
			$(description).text(sDescription);
			$(translationA).text(sTranslations[0]);
			console.log(sTranslations[0]);
			$(translationB).text(sTranslations[1]);
			console.log(sTranslations[1]);
			$(translationC).text(sTranslations[2]);
			console.log(sTranslations[2]);
			return null;
		});


		
		//---------------FORMATTIAMO LA PAGINA CON BOOTSTRAP -------------------
		//per formattare meglio la pagina si usano dei contenitori chiamati <div>
		//in bootstrap ogni div con calsse form-group viene visualizzato come blocco separato, uno sotto l'altro
		HTMLDivElement divWord = Builder.createDiv();
		$(divWord).append(word);

		HTMLDivElement divAnswers = Builder.createDiv();
		$(divAnswers).append(Builder.createDivAnswer(checkboxA, translationA));		
		$(divAnswers).append(Builder.createDivAnswer(checkboxB, translationB));		
		$(divAnswers).append(Builder.createDivAnswer(checkboxC, translationC));		
		$(divAnswers).append(Builder.createDivAnswer(checkboxD, noTranslation));		

		HTMLDivElement divBar = Builder.createDivBar();
		
		HTMLDivElement divButtons= Builder.createDivButtons();
		
		$(form).css("margin", "0% 1.5%"); // mettiamo un po' di spazio ai lati dx e sx della form e 0% di spazio sopra e sotto 
		
		console.log("adding to form");
		// aggiungiamo tutti gli elementi alla form, l'ordine e' importante
		$(form).append(divEtichetta);
		$(form).append(divWord);
		$(form).append(divAnswers);
//		$(form).append(divTranslation);
		$(form).append(divButtons);
		console.log("adding to body");
		//aggiungiamo la form al corpo della pagina
		$("body").append(divBar);
		$("body").append(form);
	}
	

	}
