/* Generated from Java with JSweet 3.0.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe contente il main per la generazione della pagina translationAnnotation.html
     * @author miche
     * @class
     */
    class translationAnnotation {
        static main(args) {
            let form = quickstart.Builder.createForm();
            form.action = translationAnnotation.SERVLET_URL;
            let description = quickstart.Builder.createDescription();
            let word = quickstart.Builder.createWord();
            let translation = quickstart.Builder.createTranslationTextArea();
            $.getJSON(translationAnnotation.REST_URL, "task=TRANSLATION_ANNOTATION", ((description, word) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sWord = (json["word"]);
                    let sDescription = (json["description"]);
                    console.log("ciao");
                    $(word).text(sWord);
                    $(description).text(sDescription);
                    return null;
                };
            })(description, word));
            console.log(word);
            let divWord = quickstart.Builder.createDiv();
            $(divWord).append(word);
            let divEtichetta = quickstart.Builder.createDivEtichetta(translationAnnotation.ETICHETTA);
            let divDescription = quickstart.Builder.createDiv();
            $(divDescription).append(description);
            let divTranslation = quickstart.Builder.createDiv();
            let label = document.createElement("label");
            label.textContent = "Traduzione:";
            $(divTranslation).append(label);
            $(divTranslation).append(translation);
            let divButtons = quickstart.Builder.createDivButtons();
            let divBar = quickstart.Builder.createDivBar();
            $("body").append(divBar);
            $(form).css("margin", "0% 1.5%");
            console.log("adding to form");
            $(form).append(divEtichetta);
            $(form).append(divWord);
            $(form).append(divDescription);
            $(form).append(divTranslation);
            $(form).append(divButtons);
            console.log("adding to body");
            $("body").append(form);
        }
    }
    translationAnnotation.SERVLET_URL = "translationAnnotation.jsp";
    translationAnnotation.REST_URL = "nextExample.jsp";
    translationAnnotation.TASK = "task=TRANSLATION_ANNOTATION";
    translationAnnotation.ETICHETTA = "Data la seguente parola e definizione in inglese, fornire la traduzione nella tua lingua madre";
    quickstart.translationAnnotation = translationAnnotation;
    translationAnnotation["__class"] = "quickstart.translationAnnotation";
})(quickstart || (quickstart = {}));
quickstart.translationAnnotation.main(null);
