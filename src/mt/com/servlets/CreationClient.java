package mt.com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mt.beans.Client;

@WebServlet("/CreationClient")
public class CreationClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreationClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("test ---------------------------");

		// to send to the the AfficheClient
		String message = "";
		Client client = new Client();
		// --------------------------------------------------------------
		String temp = "";

		String nomClient = request.getParameter("nomClient");
		String prenomClient = request.getParameter("prenomClient");
		String adresseClient = request.getParameter("adresseClient");
		String telephoneClient = request.getParameter("telephoneClient");
		String emailClient = request.getParameter("emailClient");

		client.setNom(nomClient);
		client.setPrenom(prenomClient);
		client.setAdresse(adresseClient);
		client.setTelephone(telephoneClient);
		client.setEmail(emailClient);

		if (nomClient.isEmpty())
			temp += "Le nom est obligatoire ";
		if (adresseClient.isEmpty())
			temp += "L'adresse de livraion est oblifatoire";
		if (telephoneClient.isEmpty())
			temp += "Le telephone est obligatoire";
		temp += "<br/> <a href=\"CreerClient.jsp\"> cliquez ici </a> pour accéder au formulaire de création d'un client";
		message = temp.isEmpty() ? "Success" : "echec : " + temp;

		request.setAttribute("message", message);
		request.setAttribute("client", client);

		this.getServletContext().getRequestDispatcher("/AfficheClient.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
