/* Generated from Java with JSweet 3.0.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe costruttri contentente i metodi principali
     * @author miche
     * @class
     */
    export class Builder {
        static LINKS : string[]; public static LINKS_$LI$() : string[] { if(Builder.LINKS == null) Builder.LINKS = ["definitionAnnotation", "myAnnotation", "senseAnnotation", "senseValidation", "translationAnnotation", "translationValidation", "wordAnnotation"]; return Builder.LINKS; };

        /**
         * Viene generato un bottone che se cliccato reindirizzerà a una pagina a casa
         * fra quelle relative ai task del sistema
         * 
         * @param {string} text - rappresenta il testo che verrà visualizzato all'interno del bottone
         * @return {HTMLInputElement} oggetto HTMLInputElement che se attivato indirizza a una task a caso
         */
        static createButtonRandomLink(text : string) : HTMLInputElement {
            let randomLink : string = Builder.LINKS_$LI$()[(<number>Math.floor(Math.random() * Builder.LINKS_$LI$().length)|0)];
            console.log(randomLink);
            return Builder.getButton$java_lang_String$java_lang_String$java_lang_String("start", text, "location.href=\'/fabbricasemantica/" + randomLink + ".html\';");
        }

        public static getButton$java_lang_String$java_lang_String$java_lang_String(name : string, value : string, __function : string) : HTMLInputElement {
            console.log("Creating button" + name);
            let button : HTMLInputElement = document.createElement("input");
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
        public static getButton(name? : any, value? : any, __function? : any) : any {
            if(((typeof name === 'string') || name === null) && ((typeof value === 'string') || value === null) && ((typeof __function === 'string') || __function === null)) {
                return <any>quickstart.Builder.getButton$java_lang_String$java_lang_String$java_lang_String(name, value, __function);
            } else if(((typeof name === 'string') || name === null) && ((typeof value === 'string') || value === null) && __function === undefined) {
                return <any>quickstart.Builder.getButton$java_lang_String$java_lang_String(name, value);
            } else throw new Error('invalid overload');
        }

        static getButton$java_lang_String$java_lang_String(name : string, value : string) : HTMLInputElement {
            console.log("Creating button" + name);
            let button : HTMLInputElement = document.createElement("input");
            button.type = "submit";
            button.name = name;
            button.className = "btn btn-primary";
            button.value = value;
            return button;
        }

        static getInputForm$java_lang_String$java_lang_String(name : string, placeHolder : string) : HTMLInputElement {
            return Builder.getInputForm$java_lang_String$java_lang_String$boolean(name, placeHolder, false);
        }

        public static getInputForm$java_lang_String$java_lang_String$boolean(name : string, placeHolder : string, isAPassword : boolean) : HTMLInputElement {
            console.log("creating input form");
            let input : HTMLInputElement = document.createElement("input");
            input.name = name;
            if(isAPassword) input.setAttribute("type", "password"); else input.setAttribute("type", "text");
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
        public static getInputForm(name? : any, placeHolder? : any, isAPassword? : any) : any {
            if(((typeof name === 'string') || name === null) && ((typeof placeHolder === 'string') || placeHolder === null) && ((typeof isAPassword === 'boolean') || isAPassword === null)) {
                return <any>quickstart.Builder.getInputForm$java_lang_String$java_lang_String$boolean(name, placeHolder, isAPassword);
            } else if(((typeof name === 'string') || name === null) && ((typeof placeHolder === 'string') || placeHolder === null) && isAPassword === undefined) {
                return <any>quickstart.Builder.getInputForm$java_lang_String$java_lang_String(name, placeHolder);
            } else throw new Error('invalid overload');
        }

        /**
         * Il sistema genera un link
         * 
         * @param {string} name - Il testo che verrà visualizzato nella pagina html
         * @param {string} src - La sorgente del link
         * @return {HTMLElement} link
         */
        static getLink(name : string, src : string) : HTMLElement {
            let link : HTMLElement = document.createElement("a");
            link.setAttribute("color", "orange");
            let node : Text = document.createTextNode(name);
            link.appendChild(node);
            link.setAttribute("href", src);
            return link;
        }

        static getCheckbox$java_lang_String(value : string) : HTMLInputElement {
            return Builder.getCheckbox$java_lang_String$java_lang_Boolean(value, false);
        }

        static getCheckbox$java_lang_String$java_lang_String(value : string, name : string) : HTMLInputElement {
            return Builder.getCheckbox$java_lang_String$java_lang_String$java_lang_Boolean(value, name, false);
        }

        /**
         * La funzione genera e ritorna un radio button, non potranno
         * essere spuntati più radio button con lo stesso nome
         * @param {string} value - valore del radio button
         * @param {string} name - nome del radio buttun
         * @return {HTMLInputElement} radio button
         */
        static getRadioButton(value : string, name : string) : HTMLInputElement {
            let radioButton : HTMLInputElement = document.createElement("input");
            radioButton.setAttribute("type", "radio");
            radioButton.setAttribute("name", name);
            $(radioButton).css("value", value);
            return radioButton;
        }

        static getCheckbox$java_lang_String$java_lang_Boolean(value : string, isChecked : boolean) : HTMLInputElement {
            let checkbox : HTMLInputElement = document.createElement("input");
            checkbox.setAttribute("type", "checkbox");
            checkbox.checked = isChecked;
            checkbox.value = value;
            return checkbox;
        }

        public static getCheckbox$java_lang_String$java_lang_String$java_lang_Boolean(value : string, name : string, isChecked : boolean) : HTMLInputElement {
            let checkbox : HTMLInputElement = document.createElement("input");
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
        public static getCheckbox(value? : any, name? : any, isChecked? : any) : any {
            if(((typeof value === 'string') || value === null) && ((typeof name === 'string') || name === null) && ((typeof isChecked === 'boolean') || isChecked === null)) {
                return <any>quickstart.Builder.getCheckbox$java_lang_String$java_lang_String$java_lang_Boolean(value, name, isChecked);
            } else if(((typeof value === 'string') || value === null) && ((typeof name === 'string') || name === null) && isChecked === undefined) {
                return <any>quickstart.Builder.getCheckbox$java_lang_String$java_lang_String(value, name);
            } else if(((typeof value === 'string') || value === null) && ((typeof name === 'boolean') || name === null) && isChecked === undefined) {
                return <any>quickstart.Builder.getCheckbox$java_lang_String$java_lang_Boolean(value, name);
            } else if(((typeof value === 'string') || value === null) && name === undefined && isChecked === undefined) {
                return <any>quickstart.Builder.getCheckbox$java_lang_String(value);
            } else throw new Error('invalid overload');
        }

        /**
         * Viene generato un form con il campo method impostato a "POST"
         * @return {HTMLFormElement} form
         */
        static createForm() : HTMLFormElement {
            console.log("Creating form");
            let form : HTMLFormElement = document.createElement("form");
            form.method = "POST";
            console.log("Form Done");
            return form;
        }

        /**
         * LA funzione ritorna un'etichetta contenente il testo dato in input
         * @param {string} text - testo contenuto nell'etichetta
         * @return {HTMLElement} etichetta
         */
        static createEtichetta(text : string) : HTMLElement {
            let etichetta : HTMLElement = document.createElement("div");
            etichetta.innerText = text;
            return etichetta;
        }

        /**
         * Viene generato un oggetto HTMLLabelElement con la formattazione di una descrizione
         * @return {HTMLLabelElement} Label di una descrizone
         */
        static createDescription() : HTMLLabelElement {
            console.log("creating desct");
            let description : HTMLLabelElement = Builder.createStandardLabelElement();
            return description;
        }

        /**
         * Viene generato un oggetto HTMLLabelElement con la formattazione di una traduzione
         * @return {HTMLLabelElement} Label di una traduzione
         */
        static createTranslation() : HTMLLabelElement {
            console.log("creating translation");
            return Builder.createStandardLabelElement();
        }

        /**
         * Viene generato un oggetto HTMLLabelElement con la formattazione di una parola
         * @return {HTMLLabelElement} Label di una parola
         */
        static createWord() : HTMLLabelElement {
            console.log("creating word");
            return Builder.createStandardLabelElement();
        }

        /**
         * Viene generato un oggetto HTMLLabelElemen
         * @return {HTMLLabelElement} label
         * @private
         */
        /*private*/ static createStandardLabelElement() : HTMLLabelElement {
            let standardLabel : HTMLLabelElement = document.createElement("label");
            standardLabel.className = "form-control-plaintext";
            return standardLabel;
        }

        /**
         * Viene generata un'area di testo per l'inserimento di una traduzione da parte dell'utente
         * 
         * @return {HTMLTextAreaElement} area di testo per traduzione
         */
        static createTranslationTextArea() : HTMLTextAreaElement {
            return Builder.createTextArea("translation", "Scrivi la traduzione qui...");
        }

        /**
         * Viene generata un'area di testo
         * @param {string} nome - nome del'area di testo
         * @param placeHolder - testo visualizzato all'interno della casella prima della sua riscrittura da parte dell'utente
         * @return {HTMLTextAreaElement} area di testo
         * @param {string} placeholder
         */
        static createTextArea(nome : string, placeholder : string) : HTMLTextAreaElement {
            console.log("creating " + nome);
            let textArea : HTMLTextAreaElement = document.createElement("textarea");
            textArea.name = "nome";
            textArea.className = "form-control";
            textArea.placeholder = placeholder;
            return textArea;
        }

        /**
         * La funzione ritorna il bottone submit
         * @return {HTMLInputElement} bottone submit
         */
        static createSubmit() : HTMLInputElement {
            return Builder.getButton$java_lang_String$java_lang_String("submit_button", "Avanti");
        }

        /**
         * 
         * La funzione ritorna il bottone skip
         * Esso viene visualizzato a destra dello schermo
         * @return {HTMLInputElement} bottone skip
         */
        static createSkip() : HTMLInputElement {
            let skip : HTMLInputElement = Builder.getButton$java_lang_String$java_lang_String("skip_button", "Skip");
            $(skip).css("float", "right");
            return skip;
        }

        /**
         * La funzione genera il un oggetto HTMLDivElement contenente i link alla "home" e per uscire
         * dal proprio account
         * @return {HTMLDivElement} HTMLDivElement contente il link home e signup
         */
        static createDivBar() : HTMLDivElement {
            let homeLink : HTMLElement = Builder.getLink("Home", "/fabbricasemantica/home.html");
            let signUpLink : HTMLElement = Builder.getLink("Esci", "./logout.jsp");
            $(homeLink).css("margin", "0% 1.5%");
            $(homeLink).css("float", "right");
            $(signUpLink).css("margin", "0% 1.5%");
            $(signUpLink).css("float", "right");
            let divBar : HTMLDivElement = Builder.createDiv();
            $(divBar).append(signUpLink);
            $(divBar).append(homeLink);
            $(divBar).css("margin", "0% 1.5%");
            return divBar;
        }

        static createDiv$() : HTMLDivElement {
            let div : HTMLDivElement = document.createElement("div");
            div.className = "form-group";
            return div;
        }

        public static createDiv$def_dom_HTMLElement(html : HTMLElement) : HTMLDivElement {
            let div : HTMLDivElement = Builder.createDiv();
            $(div).append(html);
            return div;
        }

        /**
         * La funzione ritorna un oggetto HTMLDivElement contenente un oggetto
         * html
         * @param {HTMLElement} html - oggetto html inserito nell'oggetto HTMLDivElement
         * @return {HTMLDivElement} HTMLDivElement contenente "html";
         */
        public static createDiv(html? : any) : any {
            if(((html != null && html instanceof <any>HTMLElement) || html === null)) {
                return <any>quickstart.Builder.createDiv$def_dom_HTMLElement(html);
            } else if(html === undefined) {
                return <any>quickstart.Builder.createDiv$();
            } else throw new Error('invalid overload');
        }

        /**
         * La funzione ritorna un oggetto HTMLDivElement contente
         * un'etichetta con il testo dato in input
         * @param {string} etichetta - etichetta contenuta nel HTMLDivElement
         * @return {HTMLDivElement} HTMLDivElement contenente un'etichetta
         */
        static createDivEtichetta(etichetta : string) : HTMLDivElement {
            let div : HTMLDivElement = document.createElement("div");
            let etichettaElement : HTMLElement = Builder.createEtichetta(etichetta);
            div.setAttribute("style", "font-weight:bold");
            $(div).append(etichettaElement);
            return div;
        }

        static createAnswer$() : HTMLLabelElement {
            console.log("creating answer");
            return document.createElement("label");
        }

        public static createAnswer$java_lang_String(answerText : string) : HTMLLabelElement {
            let answer : HTMLLabelElement = Builder.createAnswer();
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
        public static createAnswer(answerText? : any) : any {
            if(((typeof answerText === 'string') || answerText === null)) {
                return <any>quickstart.Builder.createAnswer$java_lang_String(answerText);
            } else if(answerText === undefined) {
                return <any>quickstart.Builder.createAnswer$();
            } else throw new Error('invalid overload');
        }

        /**
         * La funzione ritorna un oggetto HTMLDivElement contente un HTMLInputElement e una possibile risposta
         * @param {HTMLInputElement} checkbox - HTMLInputElement
         * @param {HTMLLabelElement} answer - Possibile risposta
         * @return {HTMLDivElement} - HTMLDivElement relativo a una risposta
         */
        static createDivAnswer(checkbox : HTMLInputElement, answer : HTMLLabelElement) : HTMLDivElement {
            let div : HTMLDivElement = Builder.createDiv();
            $(div).append(checkbox, answer);
            return div;
        }

        /**
         * Il sistema ritorna un HTMLDivElement contenente i bottoni skip e home
         * @return {HTMLDivElement} HTMLDivElement contenente i bottoni skip e home
         */
        static createDivButtons() : HTMLDivElement {
            let div : HTMLDivElement = Builder.createDiv();
            $(div).append(Builder.createSubmit(), Builder.createSkip());
            return div;
        }
    }
    Builder["__class"] = "quickstart.Builder";

}


quickstart.Builder.LINKS_$LI$();
