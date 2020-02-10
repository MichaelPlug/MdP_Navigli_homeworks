/* Generated from Java with JSweet 3.0.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe contente il main per la generazione della pagina wordAnnotation.html
     * @author miche
     * @class
     */
    export class wordAnnotation {
        public static SERVLET_URL : string = "wordAnnotation.jsp";

        public static REST_URL : string = "nextExample.jsp";

        public static TASK : string = "task=WORD_ANNOTATION";

        public static ETICHETTA : string = "Data la seguente definizione, provare a indovinare il termine definito";

        public static main(args : string[]) {
            let form : HTMLFormElement = quickstart.Builder.createForm();
            form.action = wordAnnotation.SERVLET_URL;
            console.log("creating desct");
            let description : HTMLLabelElement = quickstart.Builder.createDescription();
            console.log("creating translation");
            let answer : HTMLTextAreaElement = quickstart.Builder.createTextArea("answer", "Inserire qui la tua risposta");
            let submit : HTMLInputElement = quickstart.Builder.createSubmit();
            let skip : HTMLInputElement = quickstart.Builder.createSkip();
            $(skip).css("float", "right");
            $.getJSON(wordAnnotation.REST_URL, "task=WORD_ANNOTATION", ((description) => {
                return (result, a, ctx) => {
                    let json : JSON = <JSON>result;
                    let sDescription : string = <any>(json["description"]);
                    console.log("ciao");
                    $(description).text(sDescription);
                    return null;
                }
            })(description));
            let divEtichetta : HTMLDivElement = quickstart.Builder.createDivEtichetta(wordAnnotation.ETICHETTA);
            let divDescription : HTMLDivElement = quickstart.Builder.createDiv$def_dom_HTMLElement(description);
            let divAnswer : HTMLDivElement = quickstart.Builder.createDiv();
            let label : HTMLLabelElement = document.createElement("label");
            label.textContent = "Risposta:";
            $(divAnswer).append(label);
            $(divAnswer).append(answer);
            let divButtons : HTMLDivElement = quickstart.Builder.createDiv();
            $(divButtons).append(submit, skip);
            let divBar : HTMLDivElement = quickstart.Builder.createDivBar();
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
    wordAnnotation["__class"] = "quickstart.wordAnnotation";

}


quickstart.wordAnnotation.main(null);
