package mt.com.servlets;

import java.io.IOException;
import java.time.LocalDate;

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
@WebServlet("/CreationCommande")
public class CreationCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreationCommande() {
        super();
    }
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// to send to the AfficheCommande page
		//----------------------------------------
		String message = "" ; 
		Commande commande = new Commande() ; 
				
		// infomation Client
		String nom  = request.getParameter("nomClient") ; 
		String prenom = request.getParameter("prenomClient") ; 
		String adresseClient = request.getParameter("adresseClient") ; 
		String telephoneClient = request.getParameter("telephoneClient") ;
		String emailClient = request.getParameter("emailClient") ; 
		
		Client client = new Client() ; 
		
		client.setAdresse(adresseClient);
		client.setEmail(emailClient);
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setTelephone(telephoneClient);
		
		if(nom.trim().isEmpty() || adresseClient.trim().isEmpty() || telephoneClient.trim().isEmpty()) {
			message = "informations incomplet, <a href=\"CreerCommande.jsp\" > cliquez ici </a> pour ...";
		}
		// informations Commande
		
		// LocalDate date = request.getParameter("dateCommande") ; 
		double montant = Double.valueOf( request.getParameter("montantCommande")) ; 
		String modePaiement = request.getParameter("modePaiementCommande") ; 
		String statutPaiement = request.getParameter("statutPaiementCommande") ; 
		String modeLivraisonCommande = request.getParameter("modeLivraisonCommande");
		String statutLivraisonCommande = request.getParameter("statutLivraisonCommande");
		
		if(montant == 0 || modeLivraisonCommande.trim().isEmpty()) {
			if(message.isEmpty()) message = "informations incomplet, <a href=\"CreerCommande.jsp\" > cliquez ici </a> pour ...";

		}
		
		commande.setClient(client);
		commande.setModeLivraison(modeLivraisonCommande);
		commande.setModePaiement(modePaiement);
		commande.setMontant(montant);
		commande.setStatuLivraison(statutLivraisonCommande);
		commande.setStatuPaiement(statutPaiement);
		
		request.setAttribute("message", message);
		request.setAttribute("commande", commande);
		
		this.getServletContext().getRequestDispatcher("/AfficheCommande.jsp").forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
