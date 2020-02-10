/* Generated from Java with JSweet 3.0.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe contente il main per la generazione della pagina login.html
     * @author miche
     * @class
     */
    class Login {
        static main(args) {
            let login = quickstart.Builder.createForm();
            login.action = Login.SERVLET_URL;
            console.log("creating desct");
            let description = quickstart.Builder.createDescription();
            $(description).text("Inserisci i tuoi dati per effettuare l\'accesso");
            document.body.appendChild(description);
            document.body.appendChild(login);
            let mailDiv = quickstart.Builder.createDiv();
            let passwordDiv = quickstart.Builder.createDiv();
            let loginDiv = quickstart.Builder.createDiv();
            $(passwordDiv).append(quickstart.Builder.getInputForm$java_lang_String$java_lang_String$boolean("password1", "Password", true));
            $(mailDiv).append(quickstart.Builder.getInputForm$java_lang_String$java_lang_String("email", "Email"));
            $(loginDiv).append(quickstart.Builder.getButton$java_lang_String$java_lang_String("login", "Entra"));
            $(login).append(passwordDiv, mailDiv, loginDiv);
            $(login).css("margin", "0% 1.5%");
            let signup = quickstart.Builder.getLink("Non hai un account?", "./signup.html");
            signup.setAttribute("name", "signup");
            $("body").append(signup);
            $("body").css("text-align", "center");
        }
    }
    Login.SERVLET_URL = "login.jsp";
    quickstart.Login = Login;
    Login["__class"] = "quickstart.Login";
})(quickstart || (quickstart = {}));
quickstart.Login.main(null);
