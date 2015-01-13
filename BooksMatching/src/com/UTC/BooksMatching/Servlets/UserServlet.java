package com.UTC.BooksMatching.Servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.UTC.BooksMatching.Beans.Books;
import com.UTC.BooksMatching.Beans.User;
import com.UTC.BooksMatching.dao.BookDao;
import com.UTC.BooksMatching.dao.UserDao;

/**
 * Servlet implementation class UserServlet
 */
//@WebServlet("/UserServlet")
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
		int id = 0;
		String action = request.getParameter("action");
		
		if (action != null) {
			String idCh = request.getParameter("id");
			if (idCh != null) {
				try {
					id = Integer.parseInt(idCh);
				} catch (Exception e) {

				}
			}

			if (action.equals("supprimer")) {
				System.out.println("USER supprimer");
				UserDao.delete(id);		
				
			} else if (action.equals("modifier")) {
				System.out.println("USER modifier : " + UserDao.find(id).getNom());
				request.setAttribute("uModif", UserDao.find(id));
			} 
		}
		
		List<User> listeU = UserDao.findall();
		request.setAttribute("listeU", listeU);		
		this.getServletContext().getRequestDispatcher( "/GestionUser.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nomUser");
		String adresse = request.getParameter("adresseUser");
		String telephone = request.getParameter("telephoneUser");
		DateTime dt = new DateTime();
		DateTimeFormatter form = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
		String date = dt.toString(form);
		String statutCompte = "inactif"; //inactif par d�faut & confirmation de qc pour l'activer ? 
		String mdp = request.getParameter("mdpUser");
		
		String message;
		if (nom != null && adresse != null && telephone != null && mdp != null){
			if ( nom.trim().isEmpty() || adresse.trim().isEmpty() || telephone.trim().isEmpty() ) {
	            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"CreationUser.jsp\">Cliquez ici</a> pour acc�der au formulaire de cr�ation d'un utilisateur.";
	        } else {
	            message = "Utilisateur cr�� avec succ�s !";
	        }
			
			//int id = Integer.parseInt(sid);
			//User user = new User(id, nom, mdp, adresse, telephone, date, statutCompte);
			User user = new User(nom, mdp, adresse, telephone, null, statutCompte);
			
			String idU = request.getParameter("id");
			if (idU != null && !idU.trim().equals("")) {
				System.out.println("COUCOU Update d'un nouveau user");
				user.setId(Integer.parseInt(idU));
				 UserDao.update(user);
			} else {
				System.out.println("COUCOU Ajout d'un nouveau user");
				UserDao.insert(user);
			}
			
			request.setAttribute("user", user);
			request.setAttribute("message", message);
		}
		
		List<User> listeU = UserDao.findall();
		
		request.setAttribute("listeU", listeU);		
		
		
		this.getServletContext().getRequestDispatcher( "/GestionUser.jsp" ).forward( request, response );
	}

}
