/* Generated from Java with JSweet 3.0.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe contente il main per la generazione della pagina translationValidation.html
     * @author miche
     * @class
     */
    export class translationValidation {
        public static SERVLET_URL : string = "translationValidation.jsp";

        public static REST_URL : string = "nextExample.jsp";

        public static TASK : string = "task=TRANSLATION_VALIDATION";

        public static ETICHETTA : string = "Data la seguente parola e la sua definizone scegliere la traduzioni corrette";

        public static main(args : string[]) {
            let form : HTMLFormElement = quickstart.Builder.createForm();
            form.action = translationValidation.SERVLET_URL;
            let divEtichetta : HTMLDivElement = quickstart.Builder.createDivEtichetta(translationValidation.ETICHETTA);
            let description : HTMLLabelElement = quickstart.Builder.createDescription();
            let checkboxA : HTMLInputElement = quickstart.Builder.getCheckbox$java_lang_String$java_lang_String("A-answer", "answer");
            let checkboxB : HTMLInputElement = quickstart.Builder.getCheckbox$java_lang_String$java_lang_String("B-answer", "answer");
            let checkboxC : HTMLInputElement = quickstart.Builder.getCheckbox$java_lang_String$java_lang_String("C-answer", "answer");
            let checkboxD : HTMLInputElement = quickstart.Builder.getCheckbox$java_lang_String$java_lang_String("D-answer", "answer");
            let translationA : HTMLLabelElement = quickstart.Builder.createAnswer();
            let translationB : HTMLLabelElement = quickstart.Builder.createAnswer();
            let translationC : HTMLLabelElement = quickstart.Builder.createAnswer();
            let noTranslation : HTMLLabelElement = quickstart.Builder.createAnswer();
            noTranslation.innerText = "Nessuna delle precedenti";
            let word : HTMLLabelElement = quickstart.Builder.createWord();
            $.getJSON(translationValidation.REST_URL, translationValidation.TASK, ((translationA,translationB,translationC,description,word) => {
                return (result, a, ctx) => {
                    let json : JSON = <JSON>result;
                    let sWord : string = <any>(json["word"]);
                    let sDescription : string = <any>(json["description"]);
                    let sTranslations : string[] = <any>(json["translations"]);
                    $(word).text(sWord);
                    $(description).text(sDescription);
                    $(translationA).text(sTranslations[0]);
                    console.log(sTranslations[0]);
                    $(translationB).text(sTranslations[1]);
                    console.log(sTranslations[1]);
                    $(translationC).text(sTranslations[2]);
                    console.log(sTranslations[2]);
                    return null;
                }
            })(translationA,translationB,translationC,description,word));
            let divWord : HTMLDivElement = quickstart.Builder.createDiv();
            $(divWord).append(word);
            let divAnswers : HTMLDivElement = quickstart.Builder.createDiv();
            $(divAnswers).append(quickstart.Builder.createDivAnswer(checkboxA, translationA));
            $(divAnswers).append(quickstart.Builder.createDivAnswer(checkboxB, translationB));
            $(divAnswers).append(quickstart.Builder.createDivAnswer(checkboxC, translationC));
            $(divAnswers).append(quickstart.Builder.createDivAnswer(checkboxD, noTranslation));
            let divBar : HTMLDivElement = quickstart.Builder.createDivBar();
            let divButtons : HTMLDivElement = quickstart.Builder.createDivButtons();
            $(form).css("margin", "0% 1.5%");
            console.log("adding to form");
            $(form).append(divEtichetta);
            $(form).append(divWord);
            $(form).append(divAnswers);
            $(form).append(divButtons);
            console.log("adding to body");
            $("body").append(divBar);
            $("body").append(form);
        }
    }
    translationValidation["__class"] = "quickstart.translationValidation";

}


quickstart.translationValidation.main(null);
