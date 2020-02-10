package quickstart;

import static def.dom.Globals.console;
import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.HTMLDivElement;
import def.dom.HTMLElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLTextAreaElement;
import def.dom.Text;
import jsweet.util.StringTypes;
/**
 * Classe costruttri contentente i metodi principali
 * @author miche
 *
 */

public class Builder {
	
	private static final String[] LINKS = {"definitionAnnotation", "myAnnotation", "senseAnnotation", "senseValidation", "translationAnnotation", "translationValidation", "wordAnnotation"};
	
	/**
	 * Viene generato un bottone che se cliccato reindirizzerà a una pagina a casa
	 * fra quelle relative ai task del sistema
	 * 
	 * @param text - rappresenta il testo che verrà visualizzato all'interno del bottone
	 * @return oggetto HTMLInputElement che se attivato indirizza a una task a caso
	 */
	protected static HTMLInputElement createButtonRandomLink(String text) {
		String randomLink = LINKS[(int) Math.floor(Math.random() * LINKS.length)];
		console.log(randomLink);
		return getButton("start", text, "location.href='/fabbricasemantica/" + randomLink + ".html';");
	}	
	
	/**
	 * Il sistema genera un bottone con un funzione che si attiva al click su di esso
	 * @param name - nome del bottone
	 * @param value - valore visualizzato nella pagina html
	 * @param function - la funzione che si attiverà al click sul bottone
	 * @return un bottone
	 */
	protected static HTMLInputElement getButton(String name, String value, String function) {
		console.log("Creating button" + name);
		HTMLInputElement button = document.createElement(StringTypes.input);
		button.type = "submit";
		button.name = name;
		button.className = "btn btn-primary";
		button.value = value;
		button.setAttribute("onClick", function);
		return button;
	}
	
	/**
	 * Il sistema genera un bottone
	 * @param name - nome del bottone
	 * @param value - valore visualizzato nella pagina html
	 * @return un bottone
	 */
	protected static HTMLInputElement getButton(String name, String value) {
		console.log("Creating button" + name);
		HTMLInputElement button = document.createElement(StringTypes.input);
		button.type = "submit";
		button.name = name;
		button.className = "btn btn-primary";
		button.value = value;
		return button;
	}

	/**
	 * Viene generato un casella di testo all'interno del quale è presente un testo
	 * che verrà visualizzato finché l'utente nons scriverà all'interno di essa
	 * @param name - nome della casella
	 * @param placeHolder - testo visualizzato all'interno della casella prima della sua riscrittura da parte dell'utente
	 * @return una casella di testo
	 */
	protected static HTMLInputElement getInputForm(String name, String placeHolder) {
		return getInputForm(name, placeHolder, false);
	}
	
	/**
	 * Viene generato un casella di testo all'interno del quale è presente un testo
	 * che verrà visualizzato finché l'utente nons scriverà all'interno di essa.
	 * 
	 * Se isAPassoword è true allora il testo scritto dall'utente verrà oscurato
	 * 
	 * @param name - nome della casella
	 * @param placeHolder - testo visualizzato all'interno della casella prima della sua riscrittura da parte dell'utente
	 * @param isAPassword - booleano che determina la visibilità del testo scritto
	 * @return una casella di testo

	 */
	protected static HTMLInputElement getInputForm(String name, String placeHolder, boolean isAPassword) {
		console.log("creating input form");
		HTMLInputElement input = document.createElement(StringTypes.input);
		input.name = name; 
//		input.className =  "form-control";
		if (isAPassword)
			input.setAttribute("type", "password");
		else
			input.setAttribute("type", "text");
		input.placeholder = placeHolder;
		return input;
	}
	
	/**
	 * Il sistema genera un link
	 * 
	 * @param name - Il testo che verrà visualizzato nella pagina html
	 * @param src - La sorgente del link
	 * @return link
	 */
	protected static HTMLElement getLink(String name, String src) {
		HTMLElement link = document.createElement("a");
		link.setAttribute("color", "orange");
		Text node = document.createTextNode(name);
		link.appendChild(node);
		link.setAttribute("href", src);
		return link;
		//		return getLink(name, new URL(src));
	}

	/** La funzione ritorna una checkbox, non spuntata
	 * 
	 * @param value - valore associato aella casella
	 * @return checkbox
	 */
	protected static HTMLInputElement getCheckbox(String value) {
		return getCheckbox(value, false);
	}
	
	/**
	 * 
	 * @param value valore associato alla casella
	 * @param name nome della checkbox
	 * @return checkbox
	 */
	protected static HTMLInputElement getCheckbox(String value, String name) {
		return getCheckbox(value, name, false);
	}
	
	/**
	 * La funzione genera e ritorna un radio button, non potranno
	 * essere spuntati più radio button con lo stesso nome
	 * @param value - valore del radio button
	 * @param name - nome del radio buttun
	 * @return radio button
	 */
	protected static HTMLInputElement getRadioButton (String value, String name) {
		HTMLInputElement radioButton = document.createElement(StringTypes.input);
		radioButton.setAttribute("type", "radio");
		radioButton.setAttribute("name", name);
		$(radioButton).css("value", value);
		return radioButton;
	}
	
	/**
	 * La funzione ritorna una checkbox
	 * 
	 * @param value valore associato alla casella
s	 * @param isChecked booleano che determina se la casella sia spuntata o meno
	 * @return checkbox
	 */
	protected static HTMLInputElement getCheckbox(String value, Boolean isChecked) {
		HTMLInputElement checkbox = document.createElement(StringTypes.input);
		checkbox.setAttribute("type", "checkbox");
		checkbox.checked = isChecked;
		checkbox.value = value;
		return checkbox;
	}
	/**
	 * la funzione ritorna una checkbox
	 * @param value valore associato alla cesella
	 * @param name nome della casella
	 * @param isChecked booleano che determina se la checkbox sia spuntata o meno
	 * @return checkbox
	 */
	protected static HTMLInputElement getCheckbox(String value, String name, Boolean isChecked) {
		HTMLInputElement checkbox = document.createElement(StringTypes.input);
		checkbox.setAttribute("type", "checkbox");
		checkbox.checked = isChecked;
		checkbox.value = value;
		checkbox.setAttribute("name", name);
		return checkbox;
	}
	

	/**
	 * Viene generato un form con il campo method impostato a "POST"
	 * @return form
	 */
	protected static HTMLFormElement createForm() {
		console.log("Creating form");
		HTMLFormElement form = document.createElement(StringTypes.form); //creiamo l'oggetto form
		form.method = "POST"; //impostiamo POST come metodo
		console.log("Form Done");
		return form;
	}
	

	/**
	 * LA funzione ritorna un'etichetta contenente il testo dato in input
	 * @param text - testo contenuto nell'etichetta 
	 * @return etichetta
	 */
	protected static HTMLElement createEtichetta(String text) {
		HTMLElement etichetta = document.createElement(StringTypes.div);
		etichetta.innerText = text;
		return etichetta;
	}

	/**
	 * Viene generato un oggetto HTMLLabelElement con la formattazione di una descrizione
	 * @return Label di una descrizone
	 */
	protected static HTMLLabelElement createDescription() {
		console.log("creating desct");
		HTMLLabelElement description = createStandardLabelElement();
	//	description.setAttribute("style", "font-weight:bold");
		return description;
	}
	
	/**
	 * Viene generato un oggetto HTMLLabelElement con la formattazione di una traduzione
	 * @return Label di una traduzione
	 */
	protected static HTMLLabelElement createTranslation() {
		console.log("creating translation");
		return createStandardLabelElement();
	}
	
	/**
	 * Viene generato un oggetto HTMLLabelElement con la formattazione di una parola
	 * @return Label di una parola
	 */
	protected static HTMLLabelElement createWord() {
		console.log("creating word");
		return createStandardLabelElement();
	}
	
	/**
	 * Viene generato un oggetto HTMLLabelElemen
	 * @return label
	 */
	private static HTMLLabelElement createStandardLabelElement() {
		HTMLLabelElement standardLabel = document.createElement(StringTypes.label);
		standardLabel.className =  "form-control-plaintext";
		return standardLabel;
	}
	
	/** Viene generata un'area di testo per l'inserimento di una traduzione da parte dell'utente
	 * 
	 * @return area di testo per traduzione
	 */
	protected static HTMLTextAreaElement createTranslationTextArea() {
		return createTextArea("translation", "Scrivi la traduzione qui...");
	}
	/**
	 * Viene generata un'area di testo 
	 * @param nome nome del'area di testo
	 * @param placeholder testo visualizzato all'interno della casella prima della sua riscrittura da parte dell'utente
	 * @return area di testo
	 */
	protected static HTMLTextAreaElement createTextArea(String nome, String placeholder) {
		console.log("creating " + nome);
		HTMLTextAreaElement textArea = document.createElement(StringTypes.textarea);
		textArea.name = "nome"; //lato backend usiamo l'attributo name per ottenere l'input inserito dall'utente: request.getParameter("translation")
		textArea.className =  "form-control";
		textArea.placeholder = placeholder;
		return textArea;
	}
	/**
	 * La funzione ritorna il bottone submit
	 * @return bottone submit
	 */
	protected static HTMLInputElement createSubmit() {
		return getButton("submit_button", "Avanti");
	}
	
	/**	
	 * La funzione ritorna il bottone skip
	 * Esso viene visualizzato a destra dello schermo	
	 * @return bottone skip
	 */
	protected static HTMLInputElement createSkip() {
		HTMLInputElement skip = getButton("skip_button", "Skip");
		$(skip).css("float", "right");
		return skip;
	}
	
	/**
	 * La funzione genera il un oggetto HTMLDivElement contenente i link alla "home" e per uscire
	 * dal proprio account 
	 * @return HTMLDivElement contente il link home e signup
	 */
	protected static HTMLDivElement createDivBar() {
		HTMLElement homeLink = Builder.getLink("Home", "/fabbricasemantica/home.html");
		HTMLElement signUpLink = Builder.getLink("Esci", "./logout.jsp");
		$(homeLink).css("margin", "0% 1.5%");
		$(homeLink).css("float", "right");
		$(signUpLink).css("margin", "0% 1.5%");
		$(signUpLink).css("float", "right");
		HTMLDivElement divBar = createDiv();
		$(divBar).append(signUpLink);
		$(divBar).append(homeLink);
		$(divBar).css("margin", "0% 1.5%");
		return divBar;
	}
	
	
	/**
	 * La funzione ritorna un oggetto HTMLDivElement
	 * @return HTLMDivElement;
	 */
	protected static HTMLDivElement createDiv() {
		HTMLDivElement div = document.createElement(StringTypes.div);
		div.className = "form-group";
		return div;
	}
	

	/**
	 *  La funzione ritorna un oggetto HTMLDivElement contenente un oggetto
	 *  html
	 * @param html - oggetto html inserito nell'oggetto HTMLDivElement
	 * @return HTMLDivElement contenente "html";
	 */
	protected static HTMLDivElement createDiv(HTMLElement html) {
		HTMLDivElement div = createDiv();
		$(div).append(html);
		return div;
	}
	
	/**
	 * La funzione ritorna un oggetto HTMLDivElement contente
	 * un'etichetta con il testo dato in input
	 * @param etichetta - etichetta contenuta nel HTMLDivElement
	 * @return HTMLDivElement contenente un'etichetta
	 */
	protected static HTMLDivElement createDivEtichetta(String etichetta) {
		HTMLDivElement div = document.createElement(StringTypes.div);
		HTMLElement etichettaElement = createEtichetta(etichetta);
		div.setAttribute("style", "font-weight:bold");
		$(div).append(etichettaElement);
		return div;
	}
	
	/**
	 * La funzione ritorna un oggetto HTMLLabelElement con la formattazione di 
	 * una risposta possibile risposta 
	 * @return  HTMLLabelElement con la formattazione di 
	 * una risposta possibile risposta
	 */
	protected static HTMLLabelElement createAnswer() {
		console.log("creating answer");
		return document.createElement(StringTypes.label);
	}
	
	/**
	 * La funzione ritorna un oggetto HTMLLabelElement con la formattazione di 
	 * una risposta possibile risposta
	 * @param answerText possibile risposta
	 * @return HTMLLabelElement con la formattazione di 
	 * una risposta possibile risposta
	 */
	protected static HTMLLabelElement createAnswer(String answerText) {
		HTMLLabelElement answer = createAnswer();
		answer.innerText = answerText;
		return answer;
	}
	
	/**
	 * La funzione ritorna un oggetto HTMLDivElement contente un HTMLInputElement e una possibile risposta
	 * @param checkbox - HTMLInputElement
	 * @param answer - Possibile risposta
	 * @return - HTMLDivElement relativo a una risposta
	 */
	protected static HTMLDivElement createDivAnswer(HTMLInputElement checkbox, HTMLLabelElement answer) {
		HTMLDivElement div = createDiv();
		$(div).append(checkbox, answer);
		return div;
	}
	
	/**
	 * Il sistema ritorna un HTMLDivElement contenente i bottoni skip e home
	 * @return HTMLDivElement contenente i bottoni skip e home
	 */
	protected static HTMLDivElement createDivButtons() {
		HTMLDivElement div = createDiv();
		$(div).append(createSubmit(), createSkip());
		return div;
	}
}
