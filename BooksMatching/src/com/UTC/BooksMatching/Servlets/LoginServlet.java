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
//@WebServlet("/LoginServlet")
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
		
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		if(action.compareTo("deconnexion") == 0){
			session.setAttribute("Status",null);
			session.setAttribute("User","-1");
		}
		
		
        this.getServletContext().getRequestDispatcher("/LoginPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nomUser");
        String pwd = request.getParameter("mdp");
        
        HttpSession session = request.getSession();
        if((nom != null) && (pwd !=null) ){
	        for(Admin a:AdminDao.findall()){
	        	
	        	if(a.getAdresse().compareTo(nom) == 0) {
	        			if (a.getPwd().compareTo(pwd) == 0){
			        		System.out.println("isAdmin "+a.getNom());
			        		session.setAttribute("Status", "Admin");
			            	this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	        			}
	        			else{
	        				request.setAttribute("alert", "Mot de passe erroné !");
		        	    	this.getServletContext().getRequestDispatcher("/LoginPage.jsp").forward(request, response);
	        			}
	        			
	        	}
	        }
	        if (session.getAttribute("Status") == null){
	        	for(User u:UserDao.findall()){
	        		if(u.getAdresse().compareTo(nom) == 0){
	        				if(u.getPwd().compareTo(pwd) == 0){
			        			session.setAttribute("Status", "User");
			        			System.out.println("isUser"+u.getNom());
			        			session.setAttribute("User",u.getId());
			        	    	this.getServletContext().getRequestDispatcher("/BookServlet").forward(request, response);
	        				}
	        				else {
	        					request.setAttribute("alert", "Mot de passe erroné !");
			        	    	this.getServletContext().getRequestDispatcher("/LoginPage.jsp").forward(request, response);
	        				}
	        		
	        		}

	        		}
	        	}
	        
	        request.setAttribute("alert", "Login non reconnu");
        	this.getServletContext().getRequestDispatcher("/LoginPage.jsp").forward(request, response); 
	        
        } else {
        	request.setAttribute("alert", "Veuillez entrer une adresse de login et un mot de passe");
        	this.getServletContext().getRequestDispatcher("/LoginPage.jsp").forward(request, response);
        }

	}

}
