/* Generated from Java with JSweet 3.0.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe contente il main per la generazione della pagina wordAnnotation.html
     * @author miche
     * @class
     */
    class wordAnnotation {
        static main(args) {
            let form = quickstart.Builder.createForm();
            form.action = wordAnnotation.SERVLET_URL;
            console.log("creating desct");
            let description = quickstart.Builder.createDescription();
            console.log("creating translation");
            let answer = quickstart.Builder.createTextArea("answer", "Inserire qui la tua risposta");
            let submit = quickstart.Builder.createSubmit();
            let skip = quickstart.Builder.createSkip();
            $(skip).css("float", "right");
            $.getJSON(wordAnnotation.REST_URL, "task=WORD_ANNOTATION", ((description) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sDescription = (json["description"]);
                    console.log("ciao");
                    $(description).text(sDescription);
                    return null;
                };
            })(description));
            let divEtichetta = quickstart.Builder.createDivEtichetta(wordAnnotation.ETICHETTA);
            let divDescription = quickstart.Builder.createDiv$def_dom_HTMLElement(description);
            let divAnswer = quickstart.Builder.createDiv();
            let label = document.createElement("label");
            label.textContent = "Risposta:";
            $(divAnswer).append(label);
            $(divAnswer).append(answer);
            let divButtons = quickstart.Builder.createDiv();
            $(divButtons).append(submit, skip);
            let divBar = quickstart.Builder.createDivBar();
            $("body").append(divBar);
            $(form).css("margin", "0% 1.5%");
            console.log("adding to form");
            $(form).append(divEtichetta);
            $(form).append(divDescription);
            $(form).append(divAnswer);
            $(form).append(divButtons);
            console.log("adding to body");
            $("body").append(form);
        }
    }
    wordAnnotation.SERVLET_URL = "wordAnnotation.jsp";
    wordAnnotation.REST_URL = "nextExample.jsp";
    wordAnnotation.TASK = "task=WORD_ANNOTATION";
    wordAnnotation.ETICHETTA = "Data la seguente definizione, provare a indovinare il termine definito";
    quickstart.wordAnnotation = wordAnnotation;
    wordAnnotation["__class"] = "quickstart.wordAnnotation";
})(quickstart || (quickstart = {}));
quickstart.wordAnnotation.main(null);
