package mt.com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mt.beans.Client;
import com.mt.beans.Commande;

/**
 * Servlet implementation class CreationCommande
 */
@WebServlet( "/CreationCommande" )
public class CreationCommande extends HttpServlet {
    private static final long   serialVersionUID       = 1L;

    private static final String CHAMP_NOM              = "nomClient";
    private static final String CHAMP_prenom           = "prenomClient";
    private static final String CHAMP_ADRESSE          = "adresseClient";
    private static final String CHAMP_TEL              = "telephoneClient";
    private static final String CHAMP_EMAIL            = "emailClient";
    private static final String CHAMP_MONTANT          = "montantCommande";
    private static final String CHAMP_MODE_PAIEMENT    = "modePaiementCommande";
    private static final String CHAMP_STATUT_PAIEMENT  = "statutPaiementCommande";
    private static final String CHAMP_MODE_LiVRAISON   = "modeLivraisonCommande";
    private static final String CHAMP_STATUT_LIVRAISON = " statutLivraisonCommande";

    private static final String ATT_MESSAGE            = "message";
    private static final String ATT_COMMANDE           = "commande";
    private static final String ATT_ERREUR             = "erreur";

    private static final String VUE                    = "/AfficheCommande.jsp";

    public CreationCommande() {
        super();
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        // to send to the AfficheCommande page
        // ----------------------------------------
        String message = "";
        Commande commande = new Commande();
        boolean erreur = false;

        // infomation Client
        String nom = request.getParameter( CHAMP_NOM );
        String prenom = request.getParameter( CHAMP_prenom );
        String adresseClient = request.getParameter( CHAMP_ADRESSE );
        String telephoneClient = request.getParameter( CHAMP_TEL );
        String emailClient = request.getParameter( CHAMP_EMAIL );

        Client client = new Client();

        client.setAdresse( adresseClient );
        client.setEmail( emailClient );
        client.setNom( nom );
        client.setPrenom( prenom );
        client.setTelephone( telephoneClient );

        if ( nom.trim().isEmpty() || adresseClient.trim().isEmpty() || telephoneClient.trim().isEmpty() ) {
            erreur = true;
            message = "erreur - vous n'avez pas rempli tous les champs obligatoire <br/> "
                    + "<a href =\"CreerCommande.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'une commande";
        }

        double montant = Double.valueOf( request.getParameter( CHAMP_MONTANT ) );
        String modePaiement = request.getParameter( CHAMP_MODE_PAIEMENT );
        String statutPaiement = request.getParameter( CHAMP_STATUT_PAIEMENT );
        String modeLivraisonCommande = request.getParameter( CHAMP_MODE_LiVRAISON );
        String statutLivraisonCommande = request.getParameter( CHAMP_STATUT_LIVRAISON );

        if ( montant == 0 || modeLivraisonCommande.trim().isEmpty() ) {
            message = "informations incomplet, <a href=\"CreerCommande.jsp\" > cliquez ici </a> pour ...";
            erreur = true;
        }

        commande.setClient( client );
        commande.setModeLivraison( modeLivraisonCommande );
        commande.setModePaiement( modePaiement );
        commande.setMontant( montant );
        commande.setStatuLivraison( statutLivraisonCommande );
        commande.setStatuPaiement( statutPaiement );

        request.setAttribute( ATT_MESSAGE, message );
        request.setAttribute( ATT_COMMANDE, commande );
        request.setAttribute( ATT_ERREUR, erreur );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

    }

}
