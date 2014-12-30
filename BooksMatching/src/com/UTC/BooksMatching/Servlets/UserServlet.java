package com.UTC.BooksMatching.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.UTC.BooksMatching.Beans.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nomUser");
		String adresse = request.getParameter("adresseUser");
		String telephone = request.getParameter("telephoneUser");
		DateTime dt = new DateTime();
		DateTimeFormatter form = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
		String date = dt.toString(form);
<<<<<<< HEAD
		String statutCompte = "inactif"; //inactif par d�faut & confirmation de qc pour l'activer ? 
=======
		String statutCompte = "inactive"; //inactif par d�faut & confirmation de qc pour l'activer ?
		String mdp = request.getParameter("mdpUser");
>>>>>>> origin/master
		
		String message;
		if ( nom.trim().isEmpty() || adresse.trim().isEmpty() || telephone.trim().isEmpty() ) {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"CreationUser.jsp\">Cliquez ici</a> pour acc�der au formulaire de cr�ation d'un utilisateur.";
        } else {
            message = "Utilisateur cr�� avec succ�s !";
        }
		
		User user = new User();
		user.setId(id);
		user.setNom(nom);
		user.setAdresse(adresse);
		user.setTelephone(telephone);
		user.setDateCreation(date);
		user.setStatutCompte(statutCompte);
		user.setMdp(mdp);
		
		request.setAttribute("user", user);
		request.setAttribute("message", message);
		
		this.getServletContext().getRequestDispatcher( "/afficherUser.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
