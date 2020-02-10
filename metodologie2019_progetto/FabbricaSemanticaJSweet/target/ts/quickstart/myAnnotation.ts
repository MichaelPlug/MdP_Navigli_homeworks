/* Generated from Java with JSweet 3.0.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe contente il main per la generazione della pagina myAnnotation.html
     * @author miche
     * @class
     */
    export class myAnnotation {
        public static SERVLET_URL : string = "myAnnotation.jsp";

        public static ETICHETTA : string = "Date le seguenti parole verificare se esse sono sinonimi";

        public static PAROLA1 : string = "Banana";

        public static PAROLA2 : string = "Car";

        public static main(args : string[]) {
            let form : HTMLFormElement = quickstart.Builder.createForm();
            form.action = myAnnotation.SERVLET_URL;
            let word1 : HTMLLabelElement = quickstart.Builder.createWord();
            let word2 : HTMLLabelElement = quickstart.Builder.createWord();
            word1.innerHTML = myAnnotation.PAROLA1;
            word2.innerHTML = myAnnotation.PAROLA2;
            let radioButtonY : HTMLInputElement = quickstart.Builder.getRadioButton("YES", "asnwer");
            let etichettaY : HTMLLabelElement = quickstart.Builder.createAnswer$java_lang_String("Si");
            let radioButtonN : HTMLInputElement = quickstart.Builder.getRadioButton("NO", "asnwer");
            let etichettaN : HTMLLabelElement = quickstart.Builder.createAnswer$java_lang_String("No");
            let divWord1 : HTMLDivElement = quickstart.Builder.createDiv$def_dom_HTMLElement(word1);
            let divWord2 : HTMLDivElement = quickstart.Builder.createDiv$def_dom_HTMLElement(word2);
            let divEtichetta : HTMLDivElement = quickstart.Builder.createDivEtichetta(myAnnotation.ETICHETTA);
            let divRadioButton : HTMLDivElement = quickstart.Builder.createDiv();
            $(divRadioButton).append(quickstart.Builder.createDivAnswer(radioButtonY, etichettaY), quickstart.Builder.createDivAnswer(radioButtonN, etichettaN));
            let divButtons : HTMLDivElement = quickstart.Builder.createDivButtons();
            let divBar : HTMLDivElement = quickstart.Builder.createDivBar();
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
    myAnnotation["__class"] = "quickstart.myAnnotation";

}


quickstart.myAnnotation.main(null);
