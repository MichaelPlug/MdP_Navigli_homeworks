/* Generated from Java with JSweet 3.0.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe contente il main per la generazione della pagina login.html
     * @author miche
     * @class
     */
    export class Login {
        public static SERVLET_URL : string = "login.jsp";

        public static main(args : string[]) {
            let login : HTMLFormElement = quickstart.Builder.createForm();
            login.action = Login.SERVLET_URL;
            console.log("creating desct");
            let description : HTMLLabelElement = quickstart.Builder.createDescription();
            $(description).text("Inserisci i tuoi dati per effettuare l\'accesso");
            document.body.appendChild(description);
            document.body.appendChild(login);
            let mailDiv : HTMLDivElement = quickstart.Builder.createDiv();
            let passwordDiv : HTMLDivElement = quickstart.Builder.createDiv();
            let loginDiv : HTMLDivElement = quickstart.Builder.createDiv();
            $(passwordDiv).append(quickstart.Builder.getInputForm$java_lang_String$java_lang_String$boolean("password1", "Password", true));
            $(mailDiv).append(quickstart.Builder.getInputForm$java_lang_String$java_lang_String("email", "Email"));
            $(loginDiv).append(quickstart.Builder.getButton$java_lang_String$java_lang_String("login", "Entra"));
            $(login).append(passwordDiv, mailDiv, loginDiv);
            $(login).css("margin", "0% 1.5%");
            let signup : HTMLElement = quickstart.Builder.getLink("Non hai un account?", "./signup.html");
            signup.setAttribute("name", "signup");
            $("body").append(signup);
            $("body").css("text-align", "center");
        }
    }
    Login["__class"] = "quickstart.Login";

}


quickstart.Login.main(null);
