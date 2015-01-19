package com.UTC.BooksMatching.Servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.UTC.BooksMatching.Beans.Books;
import com.UTC.BooksMatching.Beans.Note;
import com.UTC.BooksMatching.Beans.auteurComp;
import com.UTC.BooksMatching.Beans.editeurComp;
import com.UTC.BooksMatching.Beans.titreComp;
import com.UTC.BooksMatching.dao.BookDao;
import com.UTC.BooksMatching.dao.NoteDao;

/**
 * Servlet implementation class BookAdminServlet
 */

//@WebServlet("/BookAdminServlet")
public class BookAdminServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	 
    public BookAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je suis ds doGet de BookAdminServlet");
		java.util.List<Books> lb = BookDao.findall();
		
		
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
				BookDao.delete(id);
				lb = BookDao.findall();
			} else if (action.equals("modifier")) {
				System.out.println("coucou je suis bien dans modifier");
				request.setAttribute("uModif", BookDao.find(id));
				lb = BookDao.findall();
			} else if (action.equals("sort")) {
				Collections.sort(lb);
			}
		}

		// recuperer une liste d'utilisateurs
		
		request.setAttribute("listeB", lb);
		System.out.println("Je sors de doGet et retourne la liste");
		// rediriger vers une page
		request.getRequestDispatcher("BookManagement.jsp")
				.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je suis dans doPost de BookAdminServlet");
		List<Books> listeB = BookDao.findall();
		
		String action = request.getParameter("action");
		
		if (action != null) {
			if (action.equals("sort")) {
				String sortType = request.getParameter("sortType");
				if (sortType.equals("1"))
					Collections.sort(listeB, new titreComp());
				else if (sortType.equals("2"))
					Collections.sort(listeB, new auteurComp());
				else if (sortType.equals("3"))
				Collections.sort(listeB, new editeurComp());
		}else if (action.equals("search")){
			String toLook="%"+request.getParameter("toLook")+"%";
			listeB=BookDao.search(toLook);
		}
			} else{

			String titre = request.getParameter("titre");
			String auteur = request.getParameter("auteur");
			String editeur = request.getParameter("editeur");
			String genre = request.getParameter("genre");
			String isbn = request.getParameter("ISBN");
			
			if(titre!=null || auteur!=null || editeur !=null || genre !=null || isbn != null){
				Books b = new Books(titre, auteur, editeur, genre, isbn);
				String idStr = request.getParameter("id");
				if (idStr != null && !idStr.trim().equals("")) {
					b.setId(Integer.parseInt(idStr));
					 BookDao.update(b);
					 listeB = BookDao.findall();
				} else {
					BookDao.insert(b);
					listeB = BookDao.findall();
				}
			}
		}
		
		
		System.out.println("Je sors de doPost et retourne la liste");
		request.setAttribute("listeB", listeB);
		request.getRequestDispatcher("BookManagement.jsp").forward(request, response);
	}

}

