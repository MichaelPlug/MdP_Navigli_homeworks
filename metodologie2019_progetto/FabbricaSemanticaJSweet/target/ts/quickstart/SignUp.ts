/* Generated from Java with JSweet 3.0.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe contente il main per la generazione della pagina signup.html
     * @author miche
     * @class
     */
    export class SignUp {
        public static SERVLET_URL : string = "signup.jsp";

        public static REST_URL : string = "home.jsp";

        public static lenguageLevels : string[]; public static lenguageLevels_$LI$() : string[] { if(SignUp.lenguageLevels == null) SignUp.lenguageLevels = ["A1", "A2", "B1", "B2", "C1", "C2"]; return SignUp.lenguageLevels; };

        public static main(args : string[]) {
            console.log("Creating Log-in form");
            let signup : HTMLFormElement = quickstart.Builder.createForm();
            signup.action = SignUp.SERVLET_URL;
            let mailDiv : HTMLDivElement = quickstart.Builder.createDiv();
            $(mailDiv).append(quickstart.Builder.getInputForm$java_lang_String$java_lang_String("email", "Email"));
            let password1Div : HTMLDivElement = quickstart.Builder.createDiv();
            $(password1Div).append(quickstart.Builder.getInputForm$java_lang_String$java_lang_String$boolean("password1", "Password", true));
            let password2Div : HTMLDivElement = quickstart.Builder.createDiv();
            $(password2Div).append(quickstart.Builder.getInputForm$java_lang_String$java_lang_String$boolean("password2", "Ripeti password", true));
            let ingleseCheckboxDiv : HTMLDivElement = SignUp.createLanguageCheckbox("Inglese");
            let italianoCheckboxDiv : HTMLDivElement = SignUp.createLanguageCheckbox("Italiano");
            let linguaExtra : HTMLDivElement = SignUp.createLinguaExtraDiv();
            $(signup).append(mailDiv, password1Div, password2Div);
            $(signup).append(ingleseCheckboxDiv, italianoCheckboxDiv, linguaExtra);
            signup.appendChild(quickstart.Builder.getButton$java_lang_String$java_lang_String$java_lang_String("signUp", "Registrati", "location.href=\'./home.html\';"));
            $("body").append(signup);
            $("body").append(quickstart.Builder.getLink("Sei registrato?", "/fabbricasemantica/login.html"));
            $("body").css("text-align", "center");
            $(signup).css("margin", "2% 1.5%");
        }

        /**
         * La funzione ritorna un menu a tendina contente i possibili livelli
         * di conoscienza di una lingua
         * @return {HTMLElement} menu a tendina
         */
        public static getSelectBox() : HTMLElement {
            let selectBox : HTMLSelectElement = document.createElement("select");
            for(let i : number = 0; i < SignUp.lenguageLevels_$LI$().length; i++) {{
                let appo : HTMLOptionElement = document.createElement("option");
                appo.innerHTML = SignUp.lenguageLevels_$LI$()[i];
                $(appo).css("value", SignUp.lenguageLevels_$LI$()[i]);
                selectBox.appendChild(appo);
            };}
            return selectBox;
        }

        /**
         * La funzione genera un HTMLDivElement contente uan
         * checkbox e una strina di test
         * @param {string} language stringa di testo affinacata alla checkbox
         * @return {HTMLDivElement} HTMLDivElement con checkbox e una stringa di testo
         * @private
         */
        /*private*/ static createLanguageCheckbox(language : string) : HTMLDivElement {
            let div : HTMLDivElement = quickstart.Builder.createDiv();
            let checkbox : HTMLInputElement = quickstart.Builder.getCheckbox$java_lang_String(language);
            div.appendChild(checkbox);
            div.appendChild(document.createTextNode(language));
            return div;
        }

        /**
         * La funzione genera un HTMLDivElement contente
         * una casella di test per inserire un altra lingua e un menù
         * a tendina per indicare il livello di conoscienza
         * @return {HTMLDivElement} HTMLDivElement per l'inserimento di un altra lingua
         * @private
         */
        /*private*/ static createLinguaExtraDiv() : HTMLDivElement {
            let div : HTMLDivElement = quickstart.Builder.createDiv();
            let linguaExtra : HTMLInputElement = quickstart.Builder.getInputForm$java_lang_String$java_lang_String("Altre lingue", "Inserisci un altra lingua");
            $(div).append(linguaExtra);
            $(div).append(SignUp.getSelectBox());
            return div;
        }
    }
    SignUp["__class"] = "quickstart.SignUp";

}


quickstart.SignUp.lenguageLevels_$LI$();

quickstart.SignUp.main(null);
