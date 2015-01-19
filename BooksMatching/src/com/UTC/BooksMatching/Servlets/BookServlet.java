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
import com.UTC.BooksMatching.Beans.Match;
import com.UTC.BooksMatching.Beans.Note;
import com.UTC.BooksMatching.Beans.User;
import com.UTC.BooksMatching.Beans.auteurComp;
import com.UTC.BooksMatching.Beans.editeurComp;
import com.UTC.BooksMatching.Beans.titreComp;
import com.UTC.BooksMatching.dao.BookDao;
import com.UTC.BooksMatching.dao.MatchingDao;
import com.UTC.BooksMatching.dao.NoteDao;
import com.UTC.BooksMatching.dao.UserDao;

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
		HttpSession session = request.getSession();
		int idUser= (int) session.getAttribute("User");
		User u=UserDao.find(idUser);
		
		java.util.List<Note> ln= NoteDao.findall(idUser);
		
		
		int id = 0;
		int isNew = 0;
		int idBook=-1; 
		int qualityOfWriting=0;
		int desireToKeepReading=0; 
		int desireFromSameAuteur=0;
		int desireToRecommend=0; 
		
		
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
				ln= NoteDao.findall(idUser);
			} else if (action.equals("modifier")) {
				System.out.println("coucou je suis bien dans modifier");
				request.setAttribute("uModif", BookDao.find(id));
				lb = BookDao.findall();
				ln= NoteDao.findall(idUser);
			} else if (action.equals("sort")) {
				Collections.sort(lb);
			}else if(action.equals("changecoef")){
				System.out.println("bien ici");
				int coefAuteur=0, coefEcriture=0, coefEnvie=0, coefRecommandation=0;
				
				coefAuteur = Integer.parseInt(request.getParameter("coefAuteur"));
				coefEcriture = Integer.parseInt(request.getParameter("coefEcriture"));
				coefEnvie = Integer.parseInt(request.getParameter("coefEnvie"));
				coefRecommandation = Integer.parseInt(request.getParameter("coefRecommandation"));
				System.out.println(coefAuteur + " &  "+ coefEcriture + " &  "+ coefEnvie +" & "+ coefRecommandation);
				UserDao.UpdateCoef(idUser, coefAuteur, coefEcriture, coefEnvie, coefRecommandation);
				u.setCoefAuteur(coefAuteur);
				u.setCoefEcriture(coefEcriture);
				u.setCoefEnvie(coefEnvie);
				u.setCoefRecommandation(coefRecommandation);
			}else if(action.equals("note")){
				// SI NOUVEAU 
				// SI NON NOUVEAU 
				// SI ENREGISTRER ou SI VALIDER
				
				String idCh1 = request.getParameter("idBook");
				if (idCh1 != null) {
					try {
						idBook = Integer.parseInt(idCh1);
					} catch (Exception e) {

					}
				}
				String idCh2 = request.getParameter("new");
				if (idCh2 != null) {
					try {
						isNew = Integer.parseInt(idCh2);
					} catch (Exception e) {

					}
				}
				
				String qualityOfWritingS= request.getParameter("qualityOfWriting");
				String desireToKeepReadingS= request.getParameter("desireToKeepReading");
				String desireFromSameAuteurS = request.getParameter("desireFromSameAuteur");
				String desireToRecommendS = request.getParameter("desireToRecommend");
				String comment= request.getParameter("comment");
				
				qualityOfWriting= Integer.parseInt(qualityOfWritingS);
				desireToKeepReading=Integer.parseInt(desireToKeepReadingS); 
				desireFromSameAuteur=Integer.parseInt(desireFromSameAuteurS); 
				desireToRecommend=Integer.parseInt(desireToRecommendS);
				Note newNote=new Note(idBook, idUser, qualityOfWriting, desireToKeepReading, desireFromSameAuteur, desireToRecommend, 0, comment);
				
				System.out.println("Creation des matchs");
				Match closest = MatchingDao.closematch(UserDao.find(idUser), idBook);
				Match farthest = MatchingDao.farthestmach(UserDao.find(idUser), idBook);
				
				System.out.println("Insertion des matchs");
				MatchingDao.insert(closest);
				MatchingDao.insert(farthest);
				
				if (isNew==0){
					NoteDao.insert(newNote);
				}else {
					NoteDao.update(newNote);
				}
			}
		}

		// recuperer une liste d'utilisateurs
		request.setAttribute("coefAuteur", u.getCoefAuteur());
		request.setAttribute("coefEcriture", u.getCoefEcriture());
		request.setAttribute("coefEnvie", u.getCoefEnvie());
		request.setAttribute("coefRecommandation", u.getCoefRecommandation());
		System.out.println("Test" + u.getCoefRecommandation());
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
		HttpSession session = request.getSession();
		int idUser= (int) session.getAttribute("User");
		java.util.List<Note> ln= NoteDao.findall(idUser);
		
		String action = request.getParameter("action");
		User u=UserDao.find(idUser);
		int isNew = 0;
		int idBook=-1; 
		int qualityOfWriting=0;
		int desireToKeepReading=0; 
		int desireFromSameAuteur=0;
		int desireToRecommend=0; 

		
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
		}else if(action.equals("note")){
			// SI NOUVEAU 
			// SI NON NOUVEAU 
			// SI ENREGISTRER ou SI VALIDER
			
			String idCh1 = request.getParameter("idBook");
			if (idCh1 != null) {
				try {
					idBook = Integer.parseInt(idCh1);
				} catch (Exception e) {

				}
			}
			String idCh2 = request.getParameter("new");
			if (idCh2 != null) {
				try {
					isNew = Integer.parseInt(idCh2);
				} catch (Exception e) {

				}
			}
			
			String qualityOfWritingS= request.getParameter("qualityOfWriting");
			String desireToKeepReadingS= request.getParameter("desireToKeepReading");
			String desireFromSameAuteurS = request.getParameter("desireFromSameAuteur");
			String desireToRecommendS = request.getParameter("desireToRecommend");
			String comment= request.getParameter("comment");
			
			qualityOfWriting= Integer.parseInt(qualityOfWritingS);
			desireToKeepReading=Integer.parseInt(desireToKeepReadingS); 
			desireFromSameAuteur=Integer.parseInt(desireFromSameAuteurS); 
			desireToRecommend=Integer.parseInt(desireToRecommendS);
			Note newNote=new Note(idBook, idUser, qualityOfWriting, desireToKeepReading, desireFromSameAuteur, desireToRecommend, 0, comment);
			if (isNew==0){
				NoteDao.update(newNote);				
			}else {
				NoteDao.insert(newNote);
			}
			
			ln= NoteDao.findall(idUser);
		}else if(action.equals("valider")){
			String idCh1 = request.getParameter("idBook");
			if (idCh1 != null) {
				try {
					idBook = Integer.parseInt(idCh1);
				} catch (Exception e) {

				}
			}
			
			Note note= NoteDao.find(idUser, idBook);
			note.setIsValid(1);
			NoteDao.update(note);
			ln= NoteDao.findall(idUser);
			
			
			
			Match closest = MatchingDao.closematch(UserDao.find(idUser), idBook);
			Match farthest = MatchingDao.farthestmach(UserDao.find(idUser), idBook);
			
			if(closest != null)
				MatchingDao.insert(closest);
			if(farthest != null)
				MatchingDao.insert(farthest);
			
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
					 ln= NoteDao.findall(idUser);
				} else {
					BookDao.insert(b);
					listeB = BookDao.findall();
					ln= NoteDao.findall(idUser);
				}
			}
		}
		
		request.setAttribute("coefAuteur", u.getCoefAuteur());
		request.setAttribute("coefEcriture", u.getCoefEcriture());
		request.setAttribute("coefEnvie", u.getCoefEnvie());
		request.setAttribute("coefRecommandation", u.getCoefRecommandation());
		request.setAttribute("listeB", listeB);
		request.setAttribute("listeN", ln);
		request.getRequestDispatcher("BookList.jsp").forward(request, response);
	}

}

