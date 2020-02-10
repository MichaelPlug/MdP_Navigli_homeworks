/* Generated from Java with JSweet 3.0.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe contente il main per la generazione della pagina home.html
     * @author miche
     * @class
     */
    export class Home {
        static STARTER_TEXT : string = "Inizia";

        public static main(args : string[]) {
            let divBar : HTMLDivElement = Home.createDivBar();
            let start : HTMLInputElement = Home.getStarter();
            $("body").css("text-align", "center");
            $("body").append(divBar);
            $("body").append(start);
            $("body").css("margin", "2% 1.5%");
        }

        /**
         * La funzione ritorna un bottone per avviare il sistema
         * @return {HTMLInputElement} bottone start
         * @private
         */
        /*private*/ static getStarter() : HTMLInputElement {
            return quickstart.Builder.createButtonRandomLink(Home.STARTER_TEXT);
        }

        /**
         * La funzione ritorna un element HTMLDivElement contente il link per uscire
         * dal propro account
         * @return {HTMLDivElement} HTMLDivElement contente il link a .logout.jsp
         * @private
         */
        /*private*/ static createDivBar() : HTMLDivElement {
            let signUpLink : HTMLElement = quickstart.Builder.getLink("Esci", "./logout.jsp");
            $(signUpLink).css("margin", "0% 1.5%");
            $(signUpLink).css("float", "right");
            let divBar : HTMLDivElement = quickstart.Builder.createDiv();
            $(divBar).append(signUpLink);
            $(divBar).css("margin", "0% 1.5%");
            return divBar;
        }
    }
    Home["__class"] = "quickstart.Home";

}


quickstart.Home.main(null);
