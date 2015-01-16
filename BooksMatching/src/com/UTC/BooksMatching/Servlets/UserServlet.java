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


import com.UTC.BooksMatching.Beans.MailSendingManager;
import com.UTC.BooksMatching.Beans.User;
import com.UTC.BooksMatching.dao.AppConfigDAO;

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
				UserDao.delete(id);		
				
			} else if (action.equals("modifier")) {
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
			User user = new User(nom, mdp, adresse, telephone, date, statutCompte);
			

			String idU = request.getParameter("id");
			if (idU != null && !idU.trim().equals("")) {
				user.setId(Integer.parseInt(idU));
				 int res = UserDao.update(user);
			} else {
				AppConfigDAO appconfig = new AppConfigDAO();
				UserDao.insert(user);
				User tmp = UserDao.find(user.getAdresse());
				MailSendingManager mailMan = new MailSendingManager();
	            String subject = "Votre compte sur l'application Cl�mentine";
				String body = "<h3>Votre compte sur l'application Cl�mentine aime la *ine est pr�t � �tre utilis�</h3>"
						+ "<p>Ch�r(e) "+((User)tmp).getNom()+"</p>"
						+"<p>Voici votre mot de passe pour vous authentifier "+tmp.getPwd()+"</p>"
						+"<p>Vous devez compl�ter votre inscription en activant votre compte. Pour cela allez au lien ci-dessous</p>"
						+"<a href="+appconfig.getAppUrl()+appconfig.getAppName()+"/ActivationServlet?user="+tmp.getId()+">Activation de compte</a>"
						+"<p><br/>L'�quipe de Cl�mentine aime la *ine.</p>";
				try {
					mailMan.sendMail(user.getAdresse(), subject, body);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			request.setAttribute("user", user);
			request.setAttribute("message", message);
		}
		
		List<User> listeU = UserDao.findall();
		request.setAttribute("listeU", listeU);		
		
		
		this.getServletContext().getRequestDispatcher( "/GestionUser.jsp" ).forward( request, response );
	}

}
