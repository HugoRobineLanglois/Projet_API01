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

import com.UTC.BooksMatching.Beans.Admin;
import com.UTC.BooksMatching.Beans.auteurComp;
import com.UTC.BooksMatching.Beans.editeurComp;
import com.UTC.BooksMatching.Beans.titreComp;
import com.UTC.BooksMatching.dao.AdminDao;

/**
 * Servlet implementation class BookServlet *
 **/

//@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	 
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je suis ds doGet de AdminServlet");
		java.util.List<Admin> la = AdminDao.findall();
		String adresse = null;
		String action = request.getParameter("action");
		System.out.println(action);
		if (action != null) {
			String idCh = request.getParameter("adresse");
			if (idCh != null) {
				try {
					adresse = idCh;
				} catch (Exception e) {

				}
			}

			if (action.equals("supprimer")) {
				AdminDao.delete(adresse);
				la = AdminDao.findall();
			} else if (action.equals("modifier")) {
				System.out.println("coucou je suis bien dans modifier");
				request.setAttribute("Modif", "oui");
				request.setAttribute("uModif", AdminDao.find(adresse));
				la = AdminDao.findall();
			} else if (action.equals("sort")) {
				
			}
		}

		// recuperer une liste d'utilisateurs

		request.setAttribute("listeA", la);
		System.out.println("Je sors de doGet et retourne la liste");
		// rediriger vers une page
		request.getRequestDispatcher("Admin_Management.jsp").forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Admin> listeA = AdminDao.findall();
		String action = request.getParameter("action");

		if (action != null) {
			if (action.equals("sort")) {
				String sortType = request.getParameter("sortType");
				if (sortType.equals("1"))
					//Collections.sort(listeB, new titreComp());
					System.out.println("1");
				else if (sortType.equals("2"))
					//Collections.sort(listeB, new auteurComp());
					System.out.println("2");
				else if (sortType.equals("3"))
					//Collections.sort(listeB, new editeurComp());
					System.out.println("3");
		}
		} else {
			//récupération de la date
			DateTime dt = new DateTime();
			DateTimeFormatter form = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
			String date_creation = dt.toString(form);
			
			//Recuperation des champs
			String adresse = request.getParameter("adresse");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String pwd = request.getParameter("pwd");
			String telephone = request.getParameter("telephone");
			Admin tmp = new Admin (adresse, nom, prenom, pwd, telephone, date_creation);

			System.out.println(tmp.getAdresse());
			if(AdminDao.find(tmp.getAdresse()) != null){
				AdminDao.update(tmp);
			} else {
				AdminDao.insert(tmp);
			}
			//on met a jour la liste
			listeA = AdminDao.findall();

		}
		request.setAttribute("Modif",0);
		request.setAttribute("listeA", listeA);
		request.getRequestDispatcher("Admin_Management.jsp").forward(request, response);
	}

}
