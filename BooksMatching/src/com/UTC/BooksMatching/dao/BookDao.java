package com.UTC.BooksMatching.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.UTC.BooksMatching.Beans.Books;
import com.UTC.BooksMatching.dao.ConnexionBDD;

public class BookDao {
	

	public static int insert(Books b){
		int res = 0;
		Connection cnx = null;
		try {
			System.out.println("Je vais faire get instance");
			cnx=ConnexionBDD.getInstance().getCnx();
			System.out.println("J'ai fini get instance");
			
			String sql = "INSERT INTO Books(titre, auteur, editeur, genre, isbn) VALUES(?, ?, ?, ?, ?)";
			java.sql.PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, b.getTitre());
			ps.setString(2, b.getAuteur());
			ps.setString(3, b.getEditeur());
			ps.setString(4, b.getGenre());
			ps.setString(5, b.getISBN());
			
			res=ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return res;
	}
	public static Books find(int id) {
		

		Books b = null;
		
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

		
			//Requete
			String sql = "SELECT id, titre, auteur, editeur, genre, isbn FROM books WHERE id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);
			
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				b = new Books(res.getInt("id"),
						res.getString("titre"),
						res.getString("auteur"),
						res.getString("editeur"),
						res.getString("genre"),
						res.getString("ISBN"));
				break;
			}
			
			res.close();
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//
		System.out.println("J'ai trouvé mon livre et je le retourne en objet");
		return b;
	}
	
	public static int update(Books b){
		int res =0;
		Connection cnx=null;
		try {
			cnx=ConnexionBDD.getInstance().getCnx();
			
			String sql = "UPDATE Books SET titre = ?, auteur = ?, editeur = ?, genre = ?, isbn = ? WHERE id = ?";
			java.sql.PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, b.getTitre());
			ps.setString(2, b.getAuteur());
			ps.setString(3, b.getEditeur());
			ps.setString(4, b.getGenre());
			ps.setString(5, b.getISBN());
			ps.setInt(6, b.getId());
			
			res=ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static int delete(int id) {
		int res = 0;
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

				
			//Requete
			String sql = "DELETE FROM books WHERE id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1,id);
			
			//Execution et traitement de la réponse
			res = ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	
	public static java.util.List<Books> findall(){
		System.out.println("coucou");
		java.util.List<Books> lb = new ArrayList<Books>();
		System.out.println("findall - je vais commencer la connextion");
		Connection cnx = null;
		try{
		cnx = ConnexionBDD.getInstance().getCnx();
		System.out.println("succes de connexion");
		java.sql.PreparedStatement statement = cnx.prepareStatement("SELECT id, titre, auteur, editeur, genre, isbn FROM books;");
		System.out.println("Je vais executer le statement");
		ResultSet res = statement.executeQuery();
		System.out.println("fin d'execution du statement");
		while (res.next()){
			lb.add(new Books(res.getInt("id"),res.getString("titre"), res.getString("auteur"), res.getString("editeur"), res.getString("genre"), res.getString("isbn")));
		}

		res.close();

		ConnexionBDD.getInstance().closecnx();

		System.out.println("ok- retour de findall");
		return lb;
		

		} catch(SQLException e){
			e.printStackTrace();
			return lb;
		}
	}
	
	
	public static java.util.List<Books> search(String v){
		java.util.List<Books> lb = new ArrayList<Books>();
		Connection cnx = null;
		try{
		cnx = ConnexionBDD.getInstance().getCnx();
		java.sql.PreparedStatement statement = cnx.prepareStatement("SELECT id, titre, auteur, editeur, genre, isbn FROM books WHERE titre LIKE ? OR auteur LIKE ? OR editeur LIKE ? OR genre LIKE ? OR isbn LIKE ?;");
		statement.setString(1, v);
		statement.setString(2, v);
		statement.setString(3, v);
		statement.setString(4, v);
		statement.setString(5, v);
		System.out.println("Je vais executer le statement");
		ResultSet res = statement.executeQuery();
		System.out.println("fin d'execution du statement");
		while (res.next()){
			lb.add(new Books(res.getInt("id"),res.getString("titre"), res.getString("auteur"), res.getString("editeur"), res.getString("genre"), res.getString("isbn")));
		}

		res.close();

		ConnexionBDD.getInstance().closecnx();

		System.out.println("ok- retour de search");
		return lb;
		

		} catch(SQLException e){
			e.printStackTrace();
			return lb;
		}
	}
}

