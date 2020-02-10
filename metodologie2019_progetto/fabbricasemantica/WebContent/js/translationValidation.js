/* Generated from Java with JSweet 3.0.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe contente il main per la generazione della pagina translationValidation.html
     * @author miche
     * @class
     */
    class translationValidation {
        static main(args) {
            let form = quickstart.Builder.createForm();
            form.action = translationValidation.SERVLET_URL;
            let divEtichetta = quickstart.Builder.createDivEtichetta(translationValidation.ETICHETTA);
            let description = quickstart.Builder.createDescription();
            let checkboxA = quickstart.Builder.getCheckbox$java_lang_String$java_lang_String("A-answer", "answer");
            let checkboxB = quickstart.Builder.getCheckbox$java_lang_String$java_lang_String("B-answer", "answer");
            let checkboxC = quickstart.Builder.getCheckbox$java_lang_String$java_lang_String("C-answer", "answer");
            let checkboxD = quickstart.Builder.getCheckbox$java_lang_String$java_lang_String("D-answer", "answer");
            let translationA = quickstart.Builder.createAnswer();
            let translationB = quickstart.Builder.createAnswer();
            let translationC = quickstart.Builder.createAnswer();
            let noTranslation = quickstart.Builder.createAnswer();
            noTranslation.innerText = "Nessuna delle precedenti";
            let word = quickstart.Builder.createWord();
            $.getJSON(translationValidation.REST_URL, translationValidation.TASK, ((translationA, translationB, translationC, description, word) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sWord = (json["word"]);
                    let sDescription = (json["description"]);
                    let sTranslations = (json["translations"]);
                    $(word).text(sWord);
                    $(description).text(sDescription);
                    $(translationA).text(sTranslations[0]);
                    console.log(sTranslations[0]);
                    $(translationB).text(sTranslations[1]);
                    console.log(sTranslations[1]);
                    $(translationC).text(sTranslations[2]);
                    console.log(sTranslations[2]);
                    return null;
                };
            })(translationA, translationB, translationC, description, word));
            let divWord = quickstart.Builder.createDiv();
            $(divWord).append(word);
            let divAnswers = quickstart.Builder.createDiv();
            $(divAnswers).append(quickstart.Builder.createDivAnswer(checkboxA, translationA));
            $(divAnswers).append(quickstart.Builder.createDivAnswer(checkboxB, translationB));
            $(divAnswers).append(quickstart.Builder.createDivAnswer(checkboxC, translationC));
            $(divAnswers).append(quickstart.Builder.createDivAnswer(checkboxD, noTranslation));
            let divBar = quickstart.Builder.createDivBar();
            let divButtons = quickstart.Builder.createDivButtons();
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
    translationValidation.SERVLET_URL = "translationValidation.jsp";
    translationValidation.REST_URL = "nextExample.jsp";
    translationValidation.TASK = "task=TRANSLATION_VALIDATION";
    translationValidation.ETICHETTA = "Data la seguente parola e la sua definizone scegliere la traduzioni corrette";
    quickstart.translationValidation = translationValidation;
    translationValidation["__class"] = "quickstart.translationValidation";
})(quickstart || (quickstart = {}));
quickstart.translationValidation.main(null);
