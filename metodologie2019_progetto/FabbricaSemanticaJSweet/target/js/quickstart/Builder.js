/* Generated from Java with JSweet 3.0.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe costruttri contentente i metodi principali
     * @author miche
     * @class
     */
    class Builder {
        static LINKS_$LI$() { if (Builder.LINKS == null)
            Builder.LINKS = ["definitionAnnotation", "myAnnotation", "senseAnnotation", "senseValidation", "translationAnnotation", "translationValidation", "wordAnnotation"]; return Builder.LINKS; }
        ;
        /**
         * Viene generato un bottone che se cliccato reindirizzerà a una pagina a casa
         * fra quelle relative ai task del sistema
         *
         * @param {string} text - rappresenta il testo che verrà visualizzato all'interno del bottone
         * @return {HTMLInputElement} oggetto HTMLInputElement che se attivato indirizza a una task a caso
         */
        static createButtonRandomLink(text) {
            let randomLink = Builder.LINKS_$LI$()[(Math.floor(Math.random() * Builder.LINKS_$LI$().length) | 0)];
            console.log(randomLink);
            return Builder.getButton$java_lang_String$java_lang_String$java_lang_String("start", text, "location.href=\'/fabbricasemantica/" + randomLink + ".html\';");
        }
        static getButton$java_lang_String$java_lang_String$java_lang_String(name, value, __function) {
            console.log("Creating button" + name);
            let button = document.createElement("input");
            button.type = "submit";
            button.name = name;
            button.className = "btn btn-primary";
            button.value = value;
            button.setAttribute("onClick", __function);
            return button;
        }
        /**
         * Il sistema genera un bottone con un funzione che si attiva al click su di esso
         * @param {string} name - nome del bottone
         * @param {string} value - valore visualizzato nella pagina html
         * @param {string} function - la funzione che si attiverà al click sul bottone
         * @return {HTMLInputElement} un bottone
         */
        static getButton(name, value, __function) {
            if (((typeof name === 'string') || name === null) && ((typeof value === 'string') || value === null) && ((typeof __function === 'string') || __function === null)) {
                return quickstart.Builder.getButton$java_lang_String$java_lang_String$java_lang_String(name, value, __function);
            }
            else if (((typeof name === 'string') || name === null) && ((typeof value === 'string') || value === null) && __function === undefined) {
                return quickstart.Builder.getButton$java_lang_String$java_lang_String(name, value);
            }
            else
                throw new Error('invalid overload');
        }
        static getButton$java_lang_String$java_lang_String(name, value) {
            console.log("Creating button" + name);
            let button = document.createElement("input");
            button.type = "submit";
            button.name = name;
            button.className = "btn btn-primary";
            button.value = value;
            return button;
        }
        static getInputForm$java_lang_String$java_lang_String(name, placeHolder) {
            return Builder.getInputForm$java_lang_String$java_lang_String$boolean(name, placeHolder, false);
        }
        static getInputForm$java_lang_String$java_lang_String$boolean(name, placeHolder, isAPassword) {
            console.log("creating input form");
            let input = document.createElement("input");
            input.name = name;
            if (isAPassword)
                input.setAttribute("type", "password");
            else
                input.setAttribute("type", "text");
            input.placeholder = placeHolder;
            return input;
        }
        /**
         * Viene generato un casella di testo all'interno del quale è presente un testo
         * che verrà visualizzato finché l'utente nons scriverà all'interno di essa.
         *
         * Se isAPassoword è true allora il testo scritto dall'utente verrà oscurato
         *
         * @param {string} name - nome della casella
         * @param {string} placeHolder - testo visualizzato all'interno della casella prima della sua riscrittura da parte dell'utente
         * @param {boolean} isAPassword - booleano che determina la visibilità del testo scritto
         * @return {HTMLInputElement} una casella di testo
         */
        static getInputForm(name, placeHolder, isAPassword) {
            if (((typeof name === 'string') || name === null) && ((typeof placeHolder === 'string') || placeHolder === null) && ((typeof isAPassword === 'boolean') || isAPassword === null)) {
                return quickstart.Builder.getInputForm$java_lang_String$java_lang_String$boolean(name, placeHolder, isAPassword);
            }
            else if (((typeof name === 'string') || name === null) && ((typeof placeHolder === 'string') || placeHolder === null) && isAPassword === undefined) {
                return quickstart.Builder.getInputForm$java_lang_String$java_lang_String(name, placeHolder);
            }
            else
                throw new Error('invalid overload');
        }
        /**
         * Il sistema genera un link
         *
         * @param {string} name - Il testo che verrà visualizzato nella pagina html
         * @param {string} src - La sorgente del link
         * @return {HTMLElement} link
         */
        static getLink(name, src) {
            let link = document.createElement("a");
            link.setAttribute("color", "orange");
            let node = document.createTextNode(name);
            link.appendChild(node);
            link.setAttribute("href", src);
            return link;
        }
        static getCheckbox$java_lang_String(value) {
            return Builder.getCheckbox$java_lang_String$java_lang_Boolean(value, false);
        }
        static getCheckbox$java_lang_String$java_lang_String(value, name) {
            return Builder.getCheckbox$java_lang_String$java_lang_String$java_lang_Boolean(value, name, false);
        }
        /**
         * La funzione genera e ritorna un radio button, non potranno
         * essere spuntati più radio button con lo stesso nome
         * @param {string} value - valore del radio button
         * @param {string} name - nome del radio buttun
         * @return {HTMLInputElement} radio button
         */
        static getRadioButton(value, name) {
            let radioButton = document.createElement("input");
            radioButton.setAttribute("type", "radio");
            radioButton.setAttribute("name", name);
            $(radioButton).css("value", value);
            return radioButton;
        }
        static getCheckbox$java_lang_String$java_lang_Boolean(value, isChecked) {
            let checkbox = document.createElement("input");
            checkbox.setAttribute("type", "checkbox");
            checkbox.checked = isChecked;
            checkbox.value = value;
            return checkbox;
        }
        static getCheckbox$java_lang_String$java_lang_String$java_lang_Boolean(value, name, isChecked) {
            let checkbox = document.createElement("input");
            checkbox.setAttribute("type", "checkbox");
            checkbox.checked = isChecked;
            checkbox.value = value;
            checkbox.setAttribute("name", name);
            return checkbox;
        }
        /**
         *
         * @param {string} value
         * @param {string} name
         * @param {boolean} isChecked
         * @return
         * @return {HTMLInputElement}
         */
        static getCheckbox(value, name, isChecked) {
            if (((typeof value === 'string') || value === null) && ((typeof name === 'string') || name === null) && ((typeof isChecked === 'boolean') || isChecked === null)) {
                return quickstart.Builder.getCheckbox$java_lang_String$java_lang_String$java_lang_Boolean(value, name, isChecked);
            }
            else if (((typeof value === 'string') || value === null) && ((typeof name === 'string') || name === null) && isChecked === undefined) {
                return quickstart.Builder.getCheckbox$java_lang_String$java_lang_String(value, name);
            }
            else if (((typeof value === 'string') || value === null) && ((typeof name === 'boolean') || name === null) && isChecked === undefined) {
                return quickstart.Builder.getCheckbox$java_lang_String$java_lang_Boolean(value, name);
            }
            else if (((typeof value === 'string') || value === null) && name === undefined && isChecked === undefined) {
                return quickstart.Builder.getCheckbox$java_lang_String(value);
            }
            else
                throw new Error('invalid overload');
        }
        /**
         * Viene generato un form con il campo method impostato a "POST"
         * @return {HTMLFormElement} form
         */
        static createForm() {
            console.log("Creating form");
            let form = document.createElement("form");
            form.method = "POST";
            console.log("Form Done");
            return form;
        }
        /**
         * LA funzione ritorna un'etichetta contenente il testo dato in input
         * @param {string} text - testo contenuto nell'etichetta
         * @return {HTMLElement} etichetta
         */
        static createEtichetta(text) {
            let etichetta = document.createElement("div");
            etichetta.innerText = text;
            return etichetta;
        }
        /**
         * Viene generato un oggetto HTMLLabelElement con la formattazione di una descrizione
         * @return {HTMLLabelElement} Label di una descrizone
         */
        static createDescription() {
            console.log("creating desct");
            let description = Builder.createStandardLabelElement();
            return description;
        }
        /**
         * Viene generato un oggetto HTMLLabelElement con la formattazione di una traduzione
         * @return {HTMLLabelElement} Label di una traduzione
         */
        static createTranslation() {
            console.log("creating translation");
            return Builder.createStandardLabelElement();
        }
        /**
         * Viene generato un oggetto HTMLLabelElement con la formattazione di una parola
         * @return {HTMLLabelElement} Label di una parola
         */
        static createWord() {
            console.log("creating word");
            return Builder.createStandardLabelElement();
        }
        /**
         * Viene generato un oggetto HTMLLabelElemen
         * @return {HTMLLabelElement} label
         * @private
         */
        /*private*/ static createStandardLabelElement() {
            let standardLabel = document.createElement("label");
            standardLabel.className = "form-control-plaintext";
            return standardLabel;
        }
        /**
         * Viene generata un'area di testo per l'inserimento di una traduzione da parte dell'utente
         *
         * @return {HTMLTextAreaElement} area di testo per traduzione
         */
        static createTranslationTextArea() {
            return Builder.createTextArea("translation", "Scrivi la traduzione qui...");
        }
        /**
         * Viene generata un'area di testo
         * @param {string} nome - nome del'area di testo
         * @param placeHolder - testo visualizzato all'interno della casella prima della sua riscrittura da parte dell'utente
         * @return {HTMLTextAreaElement} area di testo
         * @param {string} placeholder
         */
        static createTextArea(nome, placeholder) {
            console.log("creating " + nome);
            let textArea = document.createElement("textarea");
            textArea.name = "nome";
            textArea.className = "form-control";
            textArea.placeholder = placeholder;
            return textArea;
        }
        /**
         * La funzione ritorna il bottone submit
         * @return {HTMLInputElement} bottone submit
         */
        static createSubmit() {
            return Builder.getButton$java_lang_String$java_lang_String("submit_button", "Avanti");
        }
        /**
         *
         * La funzione ritorna il bottone skip
         * Esso viene visualizzato a destra dello schermo
         * @return {HTMLInputElement} bottone skip
         */
        static createSkip() {
            let skip = Builder.getButton$java_lang_String$java_lang_String("skip_button", "Skip");
            $(skip).css("float", "right");
            return skip;
        }
        /**
         * La funzione genera il un oggetto HTMLDivElement contenente i link alla "home" e per uscire
         * dal proprio account
         * @return {HTMLDivElement} HTMLDivElement contente il link home e signup
         */
        static createDivBar() {
            let homeLink = Builder.getLink("Home", "/fabbricasemantica/home.html");
            let signUpLink = Builder.getLink("Esci", "./logout.jsp");
            $(homeLink).css("margin", "0% 1.5%");
            $(homeLink).css("float", "right");
            $(signUpLink).css("margin", "0% 1.5%");
            $(signUpLink).css("float", "right");
            let divBar = Builder.createDiv();
            $(divBar).append(signUpLink);
            $(divBar).append(homeLink);
            $(divBar).css("margin", "0% 1.5%");
            return divBar;
        }
        static createDiv$() {
            let div = document.createElement("div");
            div.className = "form-group";
            return div;
        }
        static createDiv$def_dom_HTMLElement(html) {
            let div = Builder.createDiv();
            $(div).append(html);
            return div;
        }
        /**
         * La funzione ritorna un oggetto HTMLDivElement contenente un oggetto
         * html
         * @param {HTMLElement} html - oggetto html inserito nell'oggetto HTMLDivElement
         * @return {HTMLDivElement} HTMLDivElement contenente "html";
         */
        static createDiv(html) {
            if (((html != null && html instanceof HTMLElement) || html === null)) {
                return quickstart.Builder.createDiv$def_dom_HTMLElement(html);
            }
            else if (html === undefined) {
                return quickstart.Builder.createDiv$();
            }
            else
                throw new Error('invalid overload');
        }
        /**
         * La funzione ritorna un oggetto HTMLDivElement contente
         * un'etichetta con il testo dato in input
         * @param {string} etichetta - etichetta contenuta nel HTMLDivElement
         * @return {HTMLDivElement} HTMLDivElement contenente un'etichetta
         */
        static createDivEtichetta(etichetta) {
            let div = document.createElement("div");
            let etichettaElement = Builder.createEtichetta(etichetta);
            div.setAttribute("style", "font-weight:bold");
            $(div).append(etichettaElement);
            return div;
        }
        static createAnswer$() {
            console.log("creating answer");
            return document.createElement("label");
        }
        static createAnswer$java_lang_String(answerText) {
            let answer = Builder.createAnswer();
            answer.innerText = answerText;
            return answer;
        }
        /**
         * La funzione ritorna un oggetto HTMLLabelElement con la formattazione di
         * una risposta possibile risposta
         * @param possibile risposta
         * @return {HTMLLabelElement} HTMLLabelElement con la formattazione di
         * una risposta possibile risposta
         * @param {string} answerText
         */
        static createAnswer(answerText) {
            if (((typeof answerText === 'string') || answerText === null)) {
                return quickstart.Builder.createAnswer$java_lang_String(answerText);
            }
            else if (answerText === undefined) {
                return quickstart.Builder.createAnswer$();
            }
            else
                throw new Error('invalid overload');
        }
        /**
         * La funzione ritorna un oggetto HTMLDivElement contente un HTMLInputElement e una possibile risposta
         * @param {HTMLInputElement} checkbox - HTMLInputElement
         * @param {HTMLLabelElement} answer - Possibile risposta
         * @return {HTMLDivElement} - HTMLDivElement relativo a una risposta
         */
        static createDivAnswer(checkbox, answer) {
            let div = Builder.createDiv();
            $(div).append(checkbox, answer);
            return div;
        }
        /**
         * Il sistema ritorna un HTMLDivElement contenente i bottoni skip e home
         * @return {HTMLDivElement} HTMLDivElement contenente i bottoni skip e home
         */
        static createDivButtons() {
            let div = Builder.createDiv();
            $(div).append(Builder.createSubmit(), Builder.createSkip());
            return div;
        }
    }
    quickstart.Builder = Builder;
    Builder["__class"] = "quickstart.Builder";
})(quickstart || (quickstart = {}));
quickstart.Builder.LINKS_$LI$();
