/* Generated from Java with JSweet 3.0.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe contente il main per la generazione della pagina definationAnnotation.html
     * @author miche
     * @class
     */
    export class definitionAnnotation {
        public static SERVLET_URL : string = "definitionAnnotation.jsp";

        public static REST_URL : string = "nextExample.jsp";

        public static TASK : string = "task=DEFINITION_ANNOTATION";

        public static TEXTAREA_PLACEHOLDER : string = "Inserire qui la tua risposta";

        public static main(args : string[]) {
            let form : HTMLFormElement = quickstart.Builder.createForm();
            form.action = definitionAnnotation.SERVLET_URL;
            console.log("creating desct");
            let description : HTMLLabelElement = quickstart.Builder.createDescription();
            let word : HTMLLabelElement = quickstart.Builder.createWord();
            console.log("creating translation");
            let answer : HTMLTextAreaElement = quickstart.Builder.createTextArea("answer", definitionAnnotation.TEXTAREA_PLACEHOLDER);
            $.getJSON(definitionAnnotation.REST_URL, definitionAnnotation.TASK, ((description,word) => {
                return (result, a, ctx) => {
                    let json : JSON = <JSON>result;
                    let sWord : string = <any>(json["word"]);
                    let sDescription : string = <any>(json["hypernym"]);
                    $(word).text(sWord);
                    $(description).text(sDescription);
                    return null;
                }
            })(description,word));
            console.log(word);
            let divWord : HTMLDivElement = quickstart.Builder.createDiv$def_dom_HTMLElement(word);
            let divDescription : HTMLDivElement = quickstart.Builder.createDiv$def_dom_HTMLElement(description);
            let divAnswer : HTMLDivElement = quickstart.Builder.createDiv();
            let label : HTMLLabelElement = document.createElement("label");
            label.textContent = "Definizione:";
            $(divAnswer).append(label);
            $(divAnswer).append(answer);
            let divButtons : HTMLDivElement = quickstart.Builder.createDivButtons();
            let divBar : HTMLDivElement = quickstart.Builder.createDivBar();
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
    definitionAnnotation["__class"] = "quickstart.definitionAnnotation";

}


quickstart.definitionAnnotation.main(null);
