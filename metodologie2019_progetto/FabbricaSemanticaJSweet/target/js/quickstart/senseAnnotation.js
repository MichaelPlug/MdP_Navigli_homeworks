/* Generated from Java with JSweet 3.0.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe contente il main per la generazione della pagina senseAnnotation.html
     * @author miche
     * @class
     */
    class senseAnnotation {
        static main(args) {
            let form = quickstart.Builder.createForm();
            form.action = senseAnnotation.SERVLET_URL;
            let checkboxA = quickstart.Builder.getCheckbox$java_lang_String("A-answer");
            let checkboxB = quickstart.Builder.getCheckbox$java_lang_String("B-answer");
            let checkboxC = quickstart.Builder.getCheckbox$java_lang_String("C-answer");
            let checkboxD = quickstart.Builder.getCheckbox$java_lang_String("D-answer");
            let senseA = quickstart.Builder.createAnswer();
            let senseB = quickstart.Builder.createAnswer();
            let senseC = quickstart.Builder.createAnswer();
            let senseD = quickstart.Builder.createAnswer();
            console.log("creating word");
            let word = quickstart.Builder.createWord();
            $.getJSON(senseAnnotation.REST_URL, "task=SENSE_ANNOTATION", ((senseA, senseB, senseC, senseD, word) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sWord = (json["word"]);
                    let sSenses = (json["senses"]);
                    $(word).text(sWord);
                    $(senseA).text(sSenses[0]);
                    console.log(sSenses[0]);
                    $(senseB).text(sSenses[1]);
                    console.log(sSenses[1]);
                    $(senseC).text(sSenses[2]);
                    console.log(sSenses[2]);
                    $(senseD).text(sSenses[3]);
                    console.log(sSenses[3]);
                    return null;
                };
            })(senseA, senseB, senseC, senseD, word));
            let divEtichetta = quickstart.Builder.createDivEtichetta(senseAnnotation.ETICHETTA);
            let divWord = quickstart.Builder.createDiv();
            $(divWord).append(word);
            let divAnswers = quickstart.Builder.createDiv();
            $(divAnswers).append(quickstart.Builder.createDivAnswer(checkboxA, senseA));
            $(divAnswers).append(quickstart.Builder.createDivAnswer(checkboxB, senseB));
            $(divAnswers).append(quickstart.Builder.createDivAnswer(checkboxC, senseC));
            $(divAnswers).append(quickstart.Builder.createDivAnswer(checkboxD, senseD));
            let divButtons = quickstart.Builder.createDivButtons();
            let divBar = quickstart.Builder.createDivBar();
            $("body").append(divBar);
            $(form).css("margin", "0% 1.5%");
            console.log("adding to form");
            $(form).append(divEtichetta);
            $(form).append(divWord);
            $(form).append(divAnswers);
            $(form).append(divButtons);
            console.log("adding to body");
            $("body").append(form);
        }
    }
    senseAnnotation.SERVLET_URL = "senseAnnotation.jsp";
    senseAnnotation.REST_URL = "nextExample.jsp";
    senseAnnotation.ETICHETTA = "Data la seguente parola fornire il corretto significato";
    quickstart.senseAnnotation = senseAnnotation;
    senseAnnotation["__class"] = "quickstart.senseAnnotation";
})(quickstart || (quickstart = {}));
quickstart.senseAnnotation.main(null);
