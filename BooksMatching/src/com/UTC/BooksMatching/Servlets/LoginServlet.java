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
		// TODO Auto-generated method stub
        this.getServletContext().getRequestDispatcher("/LoginPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nomUser");
        String pwd = request.getParameter("mdp");
        
        HttpSession session = request.getSession();
        if((nom != null) && (pwd !=null) ){
	        for(Admin a:AdminDao.findall()){
	        	
	        	if((a.getNom().compareTo(nom) == 0) && (a.getPwd().compareTo(pwd) == 0)){
	        		System.out.println("isAdmin "+a.getNom());
	        		session.setAttribute("Status", "Admin");
	        	this.getServletContext().getRequestDispatcher("/MenuAdmin.jsp").forward(request, response);
	        }}
	        if (session.getAttribute("Status") == null){
	        	for(User u:UserDao.findall()){
	        		System.out.println("not admin " + u.getNom());
	        		if((u.getNom().compareTo(nom) == 0) && (u.getPwd().compareTo(pwd) == 0)){
	        			session.setAttribute("Status", "User");
	        		this.getServletContext().getRequestDispatcher("/MenuUser.jsp").forward(request, response);
	        		}}
	            }
	        
        } else {
        	System.out.println("Erreur !");
        	this.getServletContext().getRequestDispatcher("/LoginPage.jsp").forward(request, response);
        }
	}

}
