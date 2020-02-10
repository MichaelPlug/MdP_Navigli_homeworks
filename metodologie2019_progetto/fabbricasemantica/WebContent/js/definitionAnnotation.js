/* Generated from Java with JSweet 3.0.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe contente il main per la generazione della pagina definationAnnotation.html
     * @author miche
     * @class
     */
    class definitionAnnotation {
        static main(args) {
            let form = quickstart.Builder.createForm();
            form.action = definitionAnnotation.SERVLET_URL;
            console.log("creating desct");
            let description = quickstart.Builder.createDescription();
            let word = quickstart.Builder.createWord();
            console.log("creating translation");
            let answer = quickstart.Builder.createTextArea("answer", definitionAnnotation.TEXTAREA_PLACEHOLDER);
            $.getJSON(definitionAnnotation.REST_URL, definitionAnnotation.TASK, ((description, word) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sWord = (json["word"]);
                    let sDescription = (json["hypernym"]);
                    $(word).text(sWord);
                    $(description).text(sDescription);
                    return null;
                };
            })(description, word));
            console.log(word);
            let divWord = quickstart.Builder.createDiv$def_dom_HTMLElement(word);
            let divDescription = quickstart.Builder.createDiv$def_dom_HTMLElement(description);
            let divAnswer = quickstart.Builder.createDiv();
            let label = document.createElement("label");
            label.textContent = "Definizione:";
            $(divAnswer).append(label);
            $(divAnswer).append(answer);
            let divButtons = quickstart.Builder.createDivButtons();
            let divBar = quickstart.Builder.createDivBar();
            $("body").append(divBar);
            $(form).css("margin", "0% 1.5%");
            console.log("adding to form");
            $(form).append(divWord);
            $(form).append(divDescription);
            $(form).append(divAnswer);
            $(form).append(divButtons);
            console.log("adding to body");
            $("body").append(form);
        }
    }
    definitionAnnotation.SERVLET_URL = "definitionAnnotation.jsp";
    definitionAnnotation.REST_URL = "nextExample.jsp";
    definitionAnnotation.TASK = "task=DEFINITION_ANNOTATION";
    definitionAnnotation.TEXTAREA_PLACEHOLDER = "Inserire qui la tua risposta";
    quickstart.definitionAnnotation = definitionAnnotation;
    definitionAnnotation["__class"] = "quickstart.definitionAnnotation";
})(quickstart || (quickstart = {}));
quickstart.definitionAnnotation.main(null);
