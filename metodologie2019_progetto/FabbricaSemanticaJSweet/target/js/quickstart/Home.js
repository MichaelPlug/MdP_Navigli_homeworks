/* Generated from Java with JSweet 3.0.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe contente il main per la generazione della pagina home.html
     * @author miche
     * @class
     */
    class Home {
        static main(args) {
            let divBar = Home.createDivBar();
            $(divBar).css("float", "clear");
            let start = Home.getStarter();
            $("body").css("text-align", "center");
            $("body").append(start);
            $("body").append(divBar);
            $("body").css("margin", "2% 1.5%");
        }
        /**
         * La funzione ritorna un bottone per avviare il sistema
         * @return {HTMLInputElement} bottone start
         * @private
         */
        /*private*/ static getStarter() {
            return quickstart.Builder.createButtonRandomLink(Home.STARTER_TEXT);
        }
        /**
         * La funzione ritorna un element HTMLDivElement contente il link per uscire
         * dal propro account
         * @return {HTMLDivElement} HTMLDivElement contente il link a .logout.jsp
         * @private
         */
        /*private*/ static createDivBar() {
            let signUpLink = quickstart.Builder.getLink("Esci", "./logout.jsp");
            $(signUpLink).css("margin", "0% 1.5%");
            $(signUpLink).css("float", "right");
            let divBar = quickstart.Builder.createDiv();
            $(divBar).append(signUpLink);
            $(divBar).css("margin", "0% 1.5%");
            return divBar;
        }
    }
    Home.STARTER_TEXT = "Inizia";
    quickstart.Home = Home;
    Home["__class"] = "quickstart.Home";
})(quickstart || (quickstart = {}));
quickstart.Home.main(null);
