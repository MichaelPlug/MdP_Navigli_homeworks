/* Generated from Java with JSweet 3.0.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe contente il main per la generazione della pagina signup.html
     * @author miche
     * @class
     */
    class SignUp {
        static lenguageLevels_$LI$() { if (SignUp.lenguageLevels == null)
            SignUp.lenguageLevels = ["A1", "A2", "B1", "B2", "C1", "C2"]; return SignUp.lenguageLevels; }
        ;
        static main(args) {
            console.log("Creating Log-in form");
            let signup = quickstart.Builder.createForm();
            signup.action = SignUp.SERVLET_URL;
            let mailDiv = quickstart.Builder.createDiv();
            $(mailDiv).append(quickstart.Builder.getInputForm$java_lang_String$java_lang_String("email", "Email"));
            let password1Div = quickstart.Builder.createDiv();
            $(password1Div).append(quickstart.Builder.getInputForm$java_lang_String$java_lang_String$boolean("password1", "Password", true));
            let password2Div = quickstart.Builder.createDiv();
            $(password2Div).append(quickstart.Builder.getInputForm$java_lang_String$java_lang_String$boolean("password2", "Ripeti password", true));
            let ingleseCheckboxDiv = SignUp.createLanguageCheckbox("Inglese");
            let italianoCheckboxDiv = SignUp.createLanguageCheckbox("Italiano");
            let linguaExtra = SignUp.createLinguaExtraDiv();
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
        static getSelectBox() {
            let selectBox = document.createElement("select");
            for (let i = 0; i < SignUp.lenguageLevels_$LI$().length; i++) {
                {
                    let appo = document.createElement("option");
                    appo.innerHTML = SignUp.lenguageLevels_$LI$()[i];
                    $(appo).css("value", SignUp.lenguageLevels_$LI$()[i]);
                    selectBox.appendChild(appo);
                }
                ;
            }
            return selectBox;
        }
        /**
         * La funzione genera un HTMLDivElement contente uan
         * checkbox e una strina di test
         * @param {string} language stringa di testo affinacata alla checkbox
         * @return {HTMLDivElement} HTMLDivElement con checkbox e una stringa di testo
         * @private
         */
        /*private*/ static createLanguageCheckbox(language) {
            let div = quickstart.Builder.createDiv();
            let checkbox = quickstart.Builder.getCheckbox$java_lang_String(language);
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
        /*private*/ static createLinguaExtraDiv() {
            let div = quickstart.Builder.createDiv();
            let linguaExtra = quickstart.Builder.getInputForm$java_lang_String$java_lang_String("Altre lingue", "Inserisci un altra lingua");
            $(div).append(linguaExtra);
            $(div).append(SignUp.getSelectBox());
            return div;
        }
    }
    SignUp.SERVLET_URL = "signup.jsp";
    SignUp.REST_URL = "home.jsp";
    quickstart.SignUp = SignUp;
    SignUp["__class"] = "quickstart.SignUp";
})(quickstart || (quickstart = {}));
quickstart.SignUp.lenguageLevels_$LI$();
quickstart.SignUp.main(null);
