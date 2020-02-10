/* Generated from Java with JSweet 3.0.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe contente il main per la generazione della pagina senseValidation.html
     * @author miche
     * @class
     */
    class senseValidation {
        static main(args) {
            let form = quickstart.Builder.createForm();
            form.action = senseValidation.SERVLET_URL;
            let word = quickstart.Builder.createWord();
            let example = quickstart.Builder.createDescription();
            let divEtichetta = quickstart.Builder.createDivEtichetta(senseValidation.ETICHETTA);
            let sense = quickstart.Builder.createDescription();
            $.getJSON(senseValidation.REST_URL, senseValidation.TASK, ((sense, word, example) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sWord = (json["word"]);
                    $(word).text(sWord);
                    console.log(word);
                    let sExample = (json["example"]);
                    $(example).text(sExample);
                    console.log(example);
                    let sSense = (json["sense"]);
                    $(sense).text(sSense);
                    console.log(sense);
                    return null;
                };
            })(sense, word, example));
            $.getJSON(senseValidation.REST_URL, "task=SENSE_VALIDATION", ((word) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sWord = (json["word"]);
                    $(word).text(sWord);
                    return null;
                };
            })(word));
            let radioButtonY = quickstart.Builder.getRadioButton("YES", "asnwer");
            let etichettaY = quickstart.Builder.createAnswer$java_lang_String("Si");
            let radioButtonN = quickstart.Builder.getRadioButton("NO", "asnwer");
            let etichettaN = quickstart.Builder.createAnswer$java_lang_String("No");
            let divWord = quickstart.Builder.createDiv$def_dom_HTMLElement(word);
            let divExample = quickstart.Builder.createDiv$def_dom_HTMLElement(example);
            let divSense = quickstart.Builder.createDiv$def_dom_HTMLElement(sense);
            let divRadioButton = quickstart.Builder.createDiv();
            $(divRadioButton).append(quickstart.Builder.createDivAnswer(radioButtonY, etichettaY), quickstart.Builder.createDivAnswer(radioButtonN, etichettaN));
            let divButtons = quickstart.Builder.createDivButtons();
            let divBar = quickstart.Builder.createDivBar();
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
    senseValidation.SERVLET_URL = "senseValidation.jsp";
    senseValidation.REST_URL = "nextExample.jsp";
    senseValidation.TASK = "task=SENSE_VALIDATION";
    senseValidation.ETICHETTA = "Data la seguente parola e la frase in cui appare, verificare se il senso fornito dal sistema sia appropriato";
    quickstart.senseValidation = senseValidation;
    senseValidation["__class"] = "quickstart.senseValidation";
})(quickstart || (quickstart = {}));
quickstart.senseValidation.main(null);
