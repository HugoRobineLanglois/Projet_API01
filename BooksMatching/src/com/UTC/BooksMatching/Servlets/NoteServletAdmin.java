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
				request.setAttribute("nModif", NoteDao.find(idUser, idBook));
				listeN= NoteDao.findallDetails();
			} else if (action.equals("supprimer")){
				NoteDao.delete(idUser, idBook);
				listeN = NoteDao.findallDetails();
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
			else if (action.equals("modifier")){
				int idUser = 0, idBook = 0;
				String idCh1 = request.getParameter("user");
				if (idCh1 != null) {
					try {
						idUser = Integer.parseInt(idCh1);
					} catch (Exception e) {
	
					}
				}
				String idCh2 = request.getParameter("book");
				if (idCh2 != null) {
					try {
						idBook = Integer.parseInt(idCh2);
					} catch (Exception e) {
	
					}
				}
				
				Note note = NoteDao.find(idUser, idBook);
				request.setAttribute("note", note);
				int qualityOfWriting = Integer.parseInt(request.getParameter("qualityOfWriting"));
				int desireToKeepReading = Integer.parseInt(request.getParameter("desireToKeepReading"));
				int desireFromSameAuteur = Integer.parseInt(request.getParameter("desireFromSameAuteur"));
				int desireToRecommend = Integer.parseInt(request.getParameter("desireToRecommend"));
				String comment = request.getParameter("comment");
				int isValid = 1;
				DateTime dt = new DateTime();
				DateTimeFormatter form = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
				String date = dt.toString(form);
				
				Note newNote = new Note(idBook, idUser, qualityOfWriting, desireToKeepReading, desireFromSameAuteur, desireToRecommend, isValid, comment);
				
				NoteDao.updateInfos(newNote);
				
				listeN = NoteDao.findallDetails();
			}
		}
		request.setAttribute("listeN", listeN);
		request.getRequestDispatcher("noteAdmin.jsp").forward(request, response);
	}
}
