/* Generated from Java with JSweet 3.0.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe contente il main per la generazione della pagina translationAnnotation.html
     * @author miche
     * @class
     */
    export class translationAnnotation {
        public static SERVLET_URL : string = "translationAnnotation.jsp";

        public static REST_URL : string = "nextExample.jsp";

        public static TASK : string = "task=TRANSLATION_ANNOTATION";

        public static ETICHETTA : string = "Data la seguente parola e definizione in inglese, fornire la traduzione nella tua lingua madre";

        public static main(args : string[]) {
            let form : HTMLFormElement = quickstart.Builder.createForm();
            form.action = translationAnnotation.SERVLET_URL;
            let description : HTMLLabelElement = quickstart.Builder.createDescription();
            let word : HTMLLabelElement = quickstart.Builder.createWord();
            let translation : HTMLTextAreaElement = quickstart.Builder.createTranslationTextArea();
            $.getJSON(translationAnnotation.REST_URL, "task=TRANSLATION_ANNOTATION", ((description,word) => {
                return (result, a, ctx) => {
                    let json : JSON = <JSON>result;
                    let sWord : string = <any>(json["word"]);
                    let sDescription : string = <any>(json["description"]);
                    console.log("ciao");
                    $(word).text(sWord);
                    $(description).text(sDescription);
                    return null;
                }
            })(description,word));
            console.log(word);
            let divWord : HTMLDivElement = quickstart.Builder.createDiv();
            $(divWord).append(word);
            let divEtichetta : HTMLDivElement = quickstart.Builder.createDivEtichetta(translationAnnotation.ETICHETTA);
            let divDescription : HTMLDivElement = quickstart.Builder.createDiv();
            $(divDescription).append(description);
            let divTranslation : HTMLDivElement = quickstart.Builder.createDiv();
            let label : HTMLLabelElement = document.createElement("label");
            label.textContent = "Traduzione:";
            $(divTranslation).append(label);
            $(divTranslation).append(translation);
            let divButtons : HTMLDivElement = quickstart.Builder.createDivButtons();
            let divBar : HTMLDivElement = quickstart.Builder.createDivBar();
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
    translationAnnotation["__class"] = "quickstart.translationAnnotation";

}


quickstart.translationAnnotation.main(null);
