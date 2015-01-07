package com.UTC.BooksMatching.Servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.UTC.BooksMatching.Beans.Admin;
import com.UTC.BooksMatching.dao.AdminDao;


/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Admin> la = AdminDao.findall();
		int id=0;
		String action = request.getParameter("action");
		if (action != null) {
			
			String idch = request.getParameter("id");
			if(idch != null){
				try{
					id = Integer.parseInt(idch);
				} catch(Exception e){
					
				}
			}
			if (action.equals("supprimer")){
				AdminDao.delete(id);
			} else if (action.equals("modifier")){
				//request.setAttribute("aModif", AdminDao.find(id));
			} else if (action.equals("sort")){
				Collections.sort(la);
			}
		}
		
		// recuperer une liste d'utilisateurs
		request.setAttribute("listeA", la);
		
		//rediriger vers une page
		request.getRequestDispatcher("Admin_Management.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
