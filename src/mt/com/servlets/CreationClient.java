package mt.com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mt.beans.Client;

@WebServlet( "/CreationClient" )
public class CreationClient extends HttpServlet {
    private static final long   serialVersionUID = 1L;

    private static final String CHAMP_NOM        = "nomClient";
    private static final String CHAMP_prenom     = "prenomClient";
    private static final String CHAMP_ADRESSE    = "adresseClient";
    private static final String CHAMP_TEL        = "telephoneClient";
    private static final String CHAMP_EMAIL      = "emailClient";

    private static final String ATT_MESSAGE      = "message";
    private static final String ATT_CLIENT       = "client";
    private static final String ATT_ERREUR       = "erreur";
    private static final String VUE              = "/AfficheClient.jsp";

    public CreationClient() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        String message = "";
        Client client = new Client();
        boolean erreur = true;

        String nomClient = request.getParameter( CHAMP_NOM );
        String prenomClient = request.getParameter( CHAMP_prenom );
        String adresseClient = request.getParameter( CHAMP_ADRESSE );
        String telephoneClient = request.getParameter( CHAMP_TEL );
        String emailClient = request.getParameter( CHAMP_EMAIL );

        client.setNom( nomClient );
        client.setPrenom( prenomClient );
        client.setAdresse( adresseClient );
        client.setTelephone( telephoneClient );
        client.setEmail( emailClient );

        if ( nomClient.trim().isEmpty() || adresseClient.trim().isEmpty() || telephoneClient.trim().isEmpty() ) {
            erreur = true;
            message = "erreur - vous n'avez pas rempli tous les champs obligatoire <br/> "
                    + "<a href =\"CreerClient.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un client";
        } else {
            erreur = false;
            message = "Client crée avec succés";
        }

        request.setAttribute( ATT_MESSAGE, message );
        request.setAttribute( ATT_CLIENT, client );
        request.setAttribute( ATT_ERREUR, erreur );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
    }

}
