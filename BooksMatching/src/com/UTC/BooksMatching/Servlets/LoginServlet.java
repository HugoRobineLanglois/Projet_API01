package com.UTC.BooksMatching.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.UTC.BooksMatching.dao.AdminDao;
import com.UTC.BooksMatching.dao.UserDao;
import com.UTC.BooksMatching.Beans.Admin;
import com.UTC.BooksMatching.Beans.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        this.getServletContext().getRequestDispatcher("/WebContent/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nomUser");
        String pwd = request.getParameter("mdp");
        
        HttpSession session = request.getSession();
        
        for(Admin a:AdminDao.findall()){
        	if((a.getNom()==nom) && (a.getPwd() == pwd))
        		session.setAttribute("Status", "admin");
        }
        if (session.getAttribute("Status") == null){
        	for(User u:UserDao.findall()){
        		if((u.getNom()==nom) && (u.getPwd() == pwd))
        			session.setAttribute("Status", "User");
        		}
            }        
        
        this.getServletContext().getRequestDispatcher("/WebContent/index.jsp").forward(request, response);
 
	}

}