/* Generated from Java with JSweet 3.0.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe contente il main per la generazione della pagina senseValidation.html
     * @author miche
     * @class
     */
    export class senseValidation {
        public static SERVLET_URL : string = "senseValidation.jsp";

        public static REST_URL : string = "nextExample.jsp";

        public static TASK : string = "task=SENSE_VALIDATION";

        public static ETICHETTA : string = "Data la seguente parola e la frase in cui appare, verificare se il senso fornito dal sistema sia appropriato";

        public static main(args : string[]) {
            let form : HTMLFormElement = quickstart.Builder.createForm();
            form.action = senseValidation.SERVLET_URL;
            let word : HTMLLabelElement = quickstart.Builder.createWord();
            let example : HTMLLabelElement = quickstart.Builder.createDescription();
            let divEtichetta : HTMLDivElement = quickstart.Builder.createDivEtichetta(senseValidation.ETICHETTA);
            let sense : HTMLLabelElement = quickstart.Builder.createDescription();
            $.getJSON(senseValidation.REST_URL, senseValidation.TASK, ((sense,word,example) => {
                return (result, a, ctx) => {
                    let json : JSON = <JSON>result;
                    let sWord : string = <any>(json["word"]);
                    $(word).text(sWord);
                    console.log(word);
                    let sExample : string = <any>(json["example"]);
                    $(example).text(sExample);
                    console.log(example);
                    let sSense : string = <any>(json["sense"]);
                    $(sense).text(sSense);
                    console.log(sense);
                    return null;
                }
            })(sense,word,example));
            $.getJSON(senseValidation.REST_URL, "task=SENSE_VALIDATION", ((word) => {
                return (result, a, ctx) => {
                    let json : JSON = <JSON>result;
                    let sWord : string = <any>(json["word"]);
                    $(word).text(sWord);
                    return null;
                }
            })(word));
            let radioButtonY : HTMLInputElement = quickstart.Builder.getRadioButton("YES", "asnwer");
            let etichettaY : HTMLLabelElement = quickstart.Builder.createAnswer$java_lang_String("Si");
            let radioButtonN : HTMLInputElement = quickstart.Builder.getRadioButton("NO", "asnwer");
            let etichettaN : HTMLLabelElement = quickstart.Builder.createAnswer$java_lang_String("No");
            let divWord : HTMLDivElement = quickstart.Builder.createDiv$def_dom_HTMLElement(word);
            let divExample : HTMLDivElement = quickstart.Builder.createDiv$def_dom_HTMLElement(example);
            let divSense : HTMLDivElement = quickstart.Builder.createDiv$def_dom_HTMLElement(sense);
            let divRadioButton : HTMLDivElement = quickstart.Builder.createDiv();
            $(divRadioButton).append(quickstart.Builder.createDivAnswer(radioButtonY, etichettaY), quickstart.Builder.createDivAnswer(radioButtonN, etichettaN));
            let divButtons : HTMLDivElement = quickstart.Builder.createDivButtons();
            let divBar : HTMLDivElement = quickstart.Builder.createDivBar();
            $("body").append(divBar);
            $(form).css("margin", "0% 1.5%");
            console.log("adding to form");
            $(form).append(divEtichetta);
            $(form).append(divWord);
            $(form).append(divExample);
            $(form).append(divSense);
            $(form).append(divRadioButton);
            $(form).append(divButtons);
            console.log("adding to body");
            $("body").append(form);
        }
    }
    senseValidation["__class"] = "quickstart.senseValidation";

}


quickstart.senseValidation.main(null);
