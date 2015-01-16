package com.UTC.BooksMatching.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.UTC.BooksMatching.Beans.Note;
import com.UTC.BooksMatching.dao.ConnexionBDD;

public class NoteDao {
	

	public static int insert(Note n){
		int res = 0;
		Connection cnx = null;
		try {
			System.out.println("Je vais faire get instance");
			cnx=ConnexionBDD.getInstance().getCnx();
			System.out.println("J'ai fini get instance");
			
			String sql = "INSERT INTO note (idBook, idUser, qualityWriting, desireReed, sameAutor, recommend, validate ) VALUES(?, ?, ?, ?, ?, ?, ?)";
			java.sql.PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, n.getIdBook());
			ps.setInt(2, n.getIdUser());
			ps.setInt(3,n.getQualityOfWriting());
			ps.setInt(4, n.getDesireToKeepReading());
			ps.setInt(5,n.getDesireFromSameAuteur());
			ps.setInt(6,n.getDesireToRecommend());
			ps.setInt(7,n.getIsValid());
			
			res=ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return res;
	}
	
	public static Note find(int idUser, int idBook) {
		

		Note b = null;
		
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

		
			//Requete
			String sql = "SELECT idBook, idUser, qualityWriting, desireReed, sameAutor, recommend, validate FROM note WHERE idBook=? AND idUser=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, idBook);
			ps.setInt(2, idUser);
			
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				b = new Note(res.getInt("idBook"),
						res.getInt("idUser"),
						res.getInt("qualityWriting"),
						res.getInt("desireReed"),
						res.getInt("sameAutor"),
						res.getInt("recommend"),
						res.getInt("validate"));
				break;
			}
			
			res.close();
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//
		System.out.println("J'ai trouvé l'eval et je le retourne en objet");
		return b;
	}
	
	public static int update(Note n){
		int res =0;
		Connection cnx=null;
		try {
			cnx=ConnexionBDD.getInstance().getCnx();
			
			String sql = "UPDATE note SET idBook= ?, idUser = ?, qualityWriting= ?, desireReed= ?, sameAutor= ?, recommend =?, validate = ? WHERE idUser = ? AND idBook= ?";
			java.sql.PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, n.getIdBook());
			ps.setInt(2, n.getIdUser());
			ps.setInt(3,n.getQualityOfWriting());
			ps.setInt(4, n.getDesireToKeepReading());
			ps.setInt(5,n.getDesireFromSameAuteur());
			ps.setInt(6,n.getDesireToRecommend());
			ps.setInt(7,n.getIsValid());
			ps.setInt(8, n.getIdBook());
			ps.setInt(9, n.getIdUser());
			
			res=ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static int delete(int idUser, int idBook) {
		int res = 0;
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

				
			//Requete
			String sql = "DELETE FROM note WHERE idUser=? AND idBook=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1,idUser);
			ps.setInt(2,idBook);
			
			//Execution et traitement de la réponse
			res = ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	
	public static java.util.List<Note> findall(int idUser){
		java.util.List<Note> lb = new ArrayList<Note>();
		Connection cnx = null;
		try{
		cnx = ConnexionBDD.getInstance().getCnx();
		java.sql.PreparedStatement statement = cnx.prepareStatement("SELECT idBook, idUser, qualityWriting, desireReed, sameAutor, recommend, validate FROM note WHERE idUser=?; ");
		statement.setInt(1,idUser);
		ResultSet res = statement.executeQuery();
		while (res.next()){
			lb.add(new Note(res.getInt("idBook"),
					res.getInt("idUser"),
					res.getInt("qualityWriting"),
					res.getInt("desireReed"),
					res.getInt("sameAutor"),
					res.getInt("recommend"),
					res.getInt("validate")));
		}

		res.close();

		ConnexionBDD.getInstance().closecnx();
		return lb;
		

		} catch(SQLException e){
			e.printStackTrace();
			return lb;
		}
	}
}

