package com.UTC.BooksMatching.Servlets;

import java.io.IOException;

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
 * Servlet implementation class NoteServlet
 */
@WebServlet("/NoteServlet")
public class NoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Je suis bien ds le do post de note servlet");
		HttpSession session = request.getSession();
		int idUser= (int) session.getAttribute("User");
		System.out.println("coucou");
		System.out.println(idUser);
		int idBook=-1; 
		int nouveau;
<<<<<<< HEAD
		
=======
>>>>>>> origin/master
		String idCh = request.getParameter("idBook");
		String isNew=request.getParameter("new");
		nouveau=Integer.parseInt(isNew);
		if (idCh != null) {
			try {
				idBook = Integer.parseInt(idCh);
			} catch (Exception e) {

			}
		}
<<<<<<< HEAD
		Books book= BookDao.find(idBook);
		//System.out.println("encore coucou");
		//System.out.println(idBook);
		Note note;
		//System.out.println(request.getParameter("new"));
		if(nouveau==0){
			//System.out.println(" c'est 0");
=======
		
		System.out.println("encore coucou");
		System.out.println(idBook);
		Note note;
		System.out.println(request.getParameter("new"));
		if(nouveau==0){
			System.out.println(" c'est 0");
>>>>>>> origin/master
			note = NoteDao.find(idUser, idBook); 
			request.setAttribute("new", '0');
		}else{
			note=new Note(idBook, idUser,0, 0, 0, 0, 0);
			request.setAttribute("new", '1');

		}
<<<<<<< HEAD
		request.setAttribute("Book", book);
=======
>>>>>>> origin/master
		request.setAttribute("note", note);
		
		request.getRequestDispatcher("noteUser.jsp").forward(request, response);
	}

}
