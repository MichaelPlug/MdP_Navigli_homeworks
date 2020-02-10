/* Generated from Java with JSweet 3.0.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe contente il main per la generazione della pagina senseAnnotation.html
     * @author miche
     * @class
     */
    export class senseAnnotation {
        public static SERVLET_URL : string = "senseAnnotation.jsp";

        public static REST_URL : string = "nextExample.jsp";

        public static ETICHETTA : string = "Data la seguente parola fornire il corretto significato";

        public static main(args : string[]) {
            let form : HTMLFormElement = quickstart.Builder.createForm();
            form.action = senseAnnotation.SERVLET_URL;
            let checkboxA : HTMLInputElement = quickstart.Builder.getCheckbox$java_lang_String("A-answer");
            let checkboxB : HTMLInputElement = quickstart.Builder.getCheckbox$java_lang_String("B-answer");
            let checkboxC : HTMLInputElement = quickstart.Builder.getCheckbox$java_lang_String("C-answer");
            let checkboxD : HTMLInputElement = quickstart.Builder.getCheckbox$java_lang_String("D-answer");
            let senseA : HTMLLabelElement = quickstart.Builder.createAnswer();
            let senseB : HTMLLabelElement = quickstart.Builder.createAnswer();
            let senseC : HTMLLabelElement = quickstart.Builder.createAnswer();
            let senseD : HTMLLabelElement = quickstart.Builder.createAnswer();
            console.log("creating word");
            let word : HTMLLabelElement = quickstart.Builder.createWord();
            $.getJSON(senseAnnotation.REST_URL, "task=SENSE_ANNOTATION", ((senseA,senseB,senseC,senseD,word) => {
                return (result, a, ctx) => {
                    let json : JSON = <JSON>result;
                    let sWord : string = <any>(json["word"]);
                    let sSenses : string[] = <any>(json["senses"]);
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
                }
            })(senseA,senseB,senseC,senseD,word));
            let divEtichetta : HTMLDivElement = quickstart.Builder.createDivEtichetta(senseAnnotation.ETICHETTA);
            let divWord : HTMLDivElement = quickstart.Builder.createDiv();
            $(divWord).append(word);
            let divAnswers : HTMLDivElement = quickstart.Builder.createDiv();
            $(divAnswers).append(quickstart.Builder.createDivAnswer(checkboxA, senseA));
            $(divAnswers).append(quickstart.Builder.createDivAnswer(checkboxB, senseB));
            $(divAnswers).append(quickstart.Builder.createDivAnswer(checkboxC, senseC));
            $(divAnswers).append(quickstart.Builder.createDivAnswer(checkboxD, senseD));
            let divButtons : HTMLDivElement = quickstart.Builder.createDivButtons();
            let divBar : HTMLDivElement = quickstart.Builder.createDivBar();
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
    senseAnnotation["__class"] = "quickstart.senseAnnotation";

}


quickstart.senseAnnotation.main(null);
