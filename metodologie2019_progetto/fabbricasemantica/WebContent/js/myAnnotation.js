/* Generated from Java with JSweet 3.0.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe contente il main per la generazione della pagina myAnnotation.html
     * @author miche
     * @class
     */
    class myAnnotation {
        static main(args) {
            let form = quickstart.Builder.createForm();
            form.action = myAnnotation.SERVLET_URL;
            let word1 = quickstart.Builder.createWord();
            let word2 = quickstart.Builder.createWord();
            word1.innerHTML = myAnnotation.PAROLA1;
            word2.innerHTML = myAnnotation.PAROLA2;
            let radioButtonY = quickstart.Builder.getRadioButton("YES", "asnwer");
            let etichettaY = quickstart.Builder.createAnswer$java_lang_String("Si");
            let radioButtonN = quickstart.Builder.getRadioButton("NO", "asnwer");
            let etichettaN = quickstart.Builder.createAnswer$java_lang_String("No");
            let divWord1 = quickstart.Builder.createDiv$def_dom_HTMLElement(word1);
            let divWord2 = quickstart.Builder.createDiv$def_dom_HTMLElement(word2);
            let divEtichetta = quickstart.Builder.createDivEtichetta(myAnnotation.ETICHETTA);
            let divRadioButton = quickstart.Builder.createDiv();
            $(divRadioButton).append(quickstart.Builder.createDivAnswer(radioButtonY, etichettaY), quickstart.Builder.createDivAnswer(radioButtonN, etichettaN));
            let divButtons = quickstart.Builder.createDivButtons();
            let divBar = quickstart.Builder.createDivBar();
            $("body").append(divBar);
            $(form).css("margin", "0% 1.5%");
            console.log("adding to form");
            $(form).append(divEtichetta);
            $(form).append(divWord1);
            $(form).append(divWord2);
            $(form).append(divRadioButton);
            $(form).append(divButtons);
            console.log("adding to body");
            $("body").append(form);
        }
    }
    myAnnotation.SERVLET_URL = "myAnnotation.jsp";
    myAnnotation.ETICHETTA = "Date le seguenti parole verificare se esse sono sinonimi";
    myAnnotation.PAROLA1 = "Banana";
    myAnnotation.PAROLA2 = "Car";
    quickstart.myAnnotation = myAnnotation;
    myAnnotation["__class"] = "quickstart.myAnnotation";
})(quickstart || (quickstart = {}));
quickstart.myAnnotation.main(null);
