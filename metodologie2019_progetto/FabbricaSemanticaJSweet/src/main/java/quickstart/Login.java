package quickstart;

import static def.dom.Globals.console;

import static def.dom.Globals.document;

import static def.jquery.Globals.$;

import def.dom.HTMLDivElement;
import def.dom.HTMLElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLLabelElement;

/**
 * Classe contente il main per la generazione della pagina login.html
 * @author miche
 */

public class Login {

	public static final String SERVLET_URL = "login.jsp";

	public static void main(String[] args) {
		
        
        /*
         * Creazione del form da inviare al servlet
         */
		HTMLFormElement login = Builder.createForm();
		login.action = SERVLET_URL;
			
		/*
		 * Viene inserita un'etichetta testuale ad indicare la funzione della pagina
		 * all'utente 
		 */
		console.log("creating desct");
		HTMLLabelElement description = Builder.createDescription();
		$(description).text("Inserisci i tuoi dati per effettuare l'accesso");

		
		/*
		 * La descrizione viene messa in coda nella pagina
		 */
		document.body.appendChild(description);
		

		/*
		 * Il form viene inserito in coda al documento
		 */
		document.body.appendChild(login);

		HTMLDivElement mailDiv = Builder.createDiv();
		HTMLDivElement passwordDiv = Builder.createDiv();
		HTMLDivElement loginDiv = Builder.createDiv();

		
		$(passwordDiv).append(Builder.getInputForm("password1", "Password", true));
		$(mailDiv).append(Builder.getInputForm("email", "Email"));

		/*
		 * Viene generato un bottone per inviare i file al servle
		 */
		$(loginDiv).append(Builder.getButton("login", "Entra"));
		
		$(login).append(passwordDiv, mailDiv, loginDiv);
		
		$(login).css("margin", "0% 1.5%");
		
		/*
		 * Viene generato un link con etichetta per essere reindirizzati alla
		 * pagina di registrazione
		 */
		HTMLElement signup = Builder.getLink("Non hai un account?", "./signup.html");
		signup.setAttribute("name", "signup");
		$("body").append(signup);
		$("body").css("text-align", "center");
	}	

}