package mt.com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mt.beans.Commande;
import com.mt.forms.CreationCommandeForm;

/**
 * Servlet implementation class CreationCommande
 */
@WebServlet( "/CreationCommande" )
public class CreationCommande extends HttpServlet {
    private static final long  serialVersionUID = 1L;

    public static final String ATT_COMMANDNE    = "commande";
    public static final String ATT_FORM         = "form";

    public static final String VUE_SUCCES       = "/WEB-INF/AfficheCommande.jsp";
    public static final String VUE_FORM         = "/WEB-INF/CreerCommande.jsp";

    public CreationCommande() {
        super();
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );

    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        CreationCommandeForm form = new CreationCommandeForm();
        Commande commande = form.creerCommande( request );

        request.setAttribute( ATT_COMMANDNE, commande );
        request.setAttribute( ATT_FORM, form );

        if ( form.getErreurs().isEmpty() ) {
            this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
        } else {
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
        }

    }

}
