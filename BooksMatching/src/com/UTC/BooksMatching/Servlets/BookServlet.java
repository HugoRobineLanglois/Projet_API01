package com.UTC.BooksMatching.Servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.UTC.BooksMatching.Beans.Books;
import com.UTC.BooksMatching.Beans.Note;
import com.UTC.BooksMatching.Beans.auteurComp;
import com.UTC.BooksMatching.Beans.editeurComp;
import com.UTC.BooksMatching.Beans.titreComp;
import com.UTC.BooksMatching.dao.BookDao;
import com.UTC.BooksMatching.dao.NoteDao;

/**
 * Servlet implementation class BookServlet
 */

//@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	 
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je suis ds doGet de BookServlet");
		java.util.List<Books> lb = BookDao.findall();
		
		// ATTTTENNNNNTTTTTTTIIIIIIIIIIIIOOOOOOOOOONNNNNN : 
		// A CHANGER DES QUE J'AI ID USER DS LA SESSION
		java.util.List<Note> ln= NoteDao.findall(1);
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
				//ATTENTION
				ln= NoteDao.findall(1);
			} else if (action.equals("modifier")) {
				System.out.println("coucou je suis bien dans modifier");
				request.setAttribute("uModif", BookDao.find(id));
				lb = BookDao.findall();
				//ATTENTION
				ln= NoteDao.findall(1);
			} else if (action.equals("sort")) {
				Collections.sort(lb);
			}
		}

		// recuperer une liste d'utilisateurs
		
		request.setAttribute("listeB", lb);
		request.setAttribute("listeN", ln);
		System.out.println("Je sors de doGet et retourne la liste");
		// rediriger vers une page
		request.getRequestDispatcher("BookList.jsp")
				.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je suis dans doPost de BookServlet");
		List<Books> listeB = BookDao.findall();
		
		// ATTTTENNNNNTTTTTTTIIIIIIIIIIIIOOOOOOOOOONNNNNN : 
				// A CHANGER DES QUE J'AI ID USER DS LA SESSION
		java.util.List<Note> ln= NoteDao.findall(1);
		System.out.println("J'ai recuperé tous les résultats de find all");
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
		} else {

			String titre = request.getParameter("titre");
			String auteur = request.getParameter("auteur");
			String editeur = request.getParameter("editeur");
			String genre = request.getParameter("genre");
			String isbn = request.getParameter("ISBN");

			Books b = new Books(titre, auteur, editeur, genre, isbn);
			String idStr = request.getParameter("id");
			if (idStr != null && !idStr.trim().equals("")) {
				b.setId(Integer.parseInt(idStr));
				 BookDao.update(b);
				 listeB = BookDao.findall();
					//ATTENTION
					ln= NoteDao.findall(1);
			} else {
				BookDao.insert(b);
				listeB = BookDao.findall();
				//ATTENTION
				ln= NoteDao.findall(1);
			}

		}
		
		
		System.out.println("Je sors de doPost et retourne la liste");
		request.setAttribute("listeB", listeB);
		request.setAttribute("listeN", ln);
		request.getRequestDispatcher("BookList.jsp").forward(request, response);
	}

}
