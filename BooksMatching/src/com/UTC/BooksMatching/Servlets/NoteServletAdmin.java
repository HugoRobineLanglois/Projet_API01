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
import com.UTC.BooksMatching.Beans.CompDateNote;
import com.UTC.BooksMatching.Beans.CompTitreNote;
import com.UTC.BooksMatching.Beans.CompUserNote;
import com.UTC.BooksMatching.Beans.Note;
import com.UTC.BooksMatching.Beans.NoteDetail;
import com.UTC.BooksMatching.Beans.auteurComp;
import com.UTC.BooksMatching.Beans.editeurComp;
import com.UTC.BooksMatching.Beans.titreComp;
import com.UTC.BooksMatching.dao.BookDao;
import com.UTC.BooksMatching.dao.NoteDao;

public class NoteServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoteServletAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		java.util.List<NoteDetail> listeN = NoteDao.findallDetails();
		int idUser = 0, idBook = 0;
		String action = request.getParameter("action");
		if (action != null) {
			String idU = request.getParameter("user");
			String idB = request.getParameter("book");
			if (idU != null && idB != null) {
				try {
					idUser = Integer.parseInt(idU);
					idBook = Integer.parseInt(idB);
					
				} catch (Exception e) {

				}
			} 
			if (action.equals("sort")) {
				Collections.sort(listeN);
			} else if (action.equals("modifier")) {
				System.out.println("NoteAdmin modifier");
				request.setAttribute("nModif", NoteDao.find(idUser, idBook));
				listeN= NoteDao.findallDetails();
			}
		}		
		request.setAttribute("listeN", listeN);
		request.getRequestDispatcher("noteAdmin.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<NoteDetail> listeN = NoteDao.findallDetails();
		String action = request.getParameter("action");
		if (action != null) {
			if (action.equals("sort")) {
				String sortType = request.getParameter("sortType");
				if (sortType.equals("titre"))
					Collections.sort(listeN, new CompTitreNote());
				else if (sortType.equals("user"))
					Collections.sort(listeN, new CompUserNote());
				else if (sortType.equals("date"))
				Collections.sort(listeN, new CompDateNote());
			}
		}
		request.setAttribute("listeN", listeN);
		request.getRequestDispatcher("noteAdmin.jsp").forward(request, response);
	}
}
