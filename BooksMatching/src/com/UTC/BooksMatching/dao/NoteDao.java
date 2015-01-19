package com.UTC.BooksMatching.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.UTC.BooksMatching.Beans.Books;
import com.UTC.BooksMatching.Beans.Match;
import com.UTC.BooksMatching.Beans.Note;
import com.UTC.BooksMatching.Beans.NoteDetail;
import com.UTC.BooksMatching.Beans.MatchDetail;
import com.UTC.BooksMatching.Beans.User;
import com.UTC.BooksMatching.dao.ConnexionBDD;

public class NoteDao {
	

	public static int insert(Note n){
		int res = 0;
		Connection cnx = null;
		try {
			cnx=ConnexionBDD.getInstance().getCnx();
			String sql = "INSERT INTO note (idBook, idUser, qualityWriting, desireReed, sameAutor, recommend, validate, date, comment) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			java.sql.PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, n.getIdBook());
			ps.setInt(2, n.getIdUser());
			ps.setInt(3,n.getQualityOfWriting());
			ps.setInt(4, n.getDesireToKeepReading());
			ps.setInt(5,n.getDesireFromSameAuteur());
			ps.setInt(6,n.getDesireToRecommend());
			ps.setInt(7,n.getIsValid());
			ps.setString(8,n.getDate());
			ps.setString(9,n.getComments());
			System.out.println(sql);
			res=ps.executeUpdate();
			System.out.println("fin de statement");
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
			String sql = "SELECT idBook, idUser, qualityWriting, desireReed, sameAutor, recommend, validate, date, comment FROM note WHERE idBook=? AND idUser=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, idBook);
			ps.setInt(2, idUser);
			
			
			//Execution et traitement de la reponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				b = new Note(res.getInt("idBook"),
						res.getInt("idUser"),
						res.getInt("qualityWriting"),
						res.getInt("desireReed"),
						res.getInt("sameAutor"),
						res.getInt("recommend"),
						res.getInt("validate"), 
						res.getString("date"), 
						res.getString("comment"));
				break;
			}
			
			res.close();
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return b;
	}
	
	public static int update(Note n){
		int res =0;
		Connection cnx=null;
		try {
			cnx=ConnexionBDD.getInstance().getCnx();
			String sql = "UPDATE note SET  qualityWriting= ?, desireReed= ?, sameAutor= ?, recommend =?, validate = ?, date= ?, comment= ? WHERE idUser = ? AND idBook= ?";
			java.sql.PreparedStatement ps = cnx.prepareStatement(sql);

			ps.setInt(1,n.getQualityOfWriting());
			ps.setInt(2, n.getDesireToKeepReading());
			ps.setInt(3,n.getDesireFromSameAuteur());
			ps.setInt(4,n.getDesireToRecommend());
			ps.setInt(5,n.getIsValid());
			ps.setString(6, n.getDate());
			ps.setString(7, n.getComments());
			ps.setInt(8, n.getIdUser());
			ps.setInt(9, n.getIdBook());
						
			res=ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static int updateInfos(Note n){
		int res =0;
		Connection cnx=null;
		try {
			cnx=ConnexionBDD.getInstance().getCnx();
			String sql = "UPDATE note SET  qualityWriting= ?, desireReed= ?, sameAutor= ?, recommend =?, comment= ? WHERE idUser = ? AND idBook= ?";
			java.sql.PreparedStatement ps = cnx.prepareStatement(sql);

			ps.setInt(1,n.getQualityOfWriting());
			ps.setInt(2, n.getDesireToKeepReading());
			ps.setInt(3,n.getDesireFromSameAuteur());
			ps.setInt(4,n.getDesireToRecommend());
			ps.setString(5, n.getComments());
			ps.setInt(6, n.getIdUser());
			ps.setInt(7, n.getIdBook());
						
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
			
			//Execution et traitement de la reponse
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
		java.sql.PreparedStatement statement = cnx.prepareStatement("SELECT idBook, idUser, qualityWriting, desireReed, sameAutor, recommend, validate, date, comment FROM note WHERE idUser=?; ");
		statement.setInt(1,idUser);
		ResultSet res = statement.executeQuery();
		while (res.next()){
			lb.add(new Note(res.getInt("idBook"),
					res.getInt("idUser"),
					res.getInt("qualityWriting"),
					res.getInt("desireReed"),
					res.getInt("sameAutor"),
					res.getInt("recommend"),
					res.getInt("validate"),
					res.getString("date"),
					res.getString("comment")));
		}

		res.close();

		ConnexionBDD.getInstance().closecnx();
		return lb;
		

		} catch(SQLException e){
			e.printStackTrace();
			return lb;
		}
	}
	
	public static java.util.List<Note> findallBook(int id){
		java.util.List<Note> lb = new ArrayList<Note>();
		Connection cnx = null;
		try{
		cnx = ConnexionBDD.getInstance().getCnx();
		java.sql.PreparedStatement statement = cnx.prepareStatement("SELECT idBook, idUser, qualityWriting, desireReed, sameAutor, recommend, validate, date, comment FROM note WHERE idBook=?; ");
		statement.setInt(1,id);
		ResultSet res = statement.executeQuery();
		while (res.next()){
			lb.add(new Note(res.getInt("idBook"),
					res.getInt("idUser"),
					res.getInt("qualityWriting"),
					res.getInt("desireReed"),
					res.getInt("sameAutor"),
					res.getInt("recommend"),
					res.getInt("validate"),
					res.getString("date"),
					res.getString("comment")));
		}

		res.close();

		ConnexionBDD.getInstance().closecnx();
		return lb;
		

		} catch(SQLException e){
			e.printStackTrace();
			return lb;
		}
	}
	
	public static java.util.List<Note> findall(){
		java.util.List<Note> lb = new ArrayList<Note>();
		Connection cnx = null;
		try{
		cnx = ConnexionBDD.getInstance().getCnx();
		java.sql.PreparedStatement statement = cnx.prepareStatement("SELECT idBook, idUser, qualityWriting, desireReed, sameAutor, recommend, validate, date, comment FROM note ;");
		ResultSet res = statement.executeQuery();
		while (res.next()){
			lb.add(new Note(res.getInt("idBook"),
					res.getInt("idUser"),
					res.getInt("qualityWriting"),
					res.getInt("desireReed"),
					res.getInt("sameAutor"),
					res.getInt("recommend"),
					res.getInt("validate"),
					res.getString("date"),
					res.getString("comment")));
		}

		res.close();

		ConnexionBDD.getInstance().closecnx();
		return lb;
		

		} catch(SQLException e){
			e.printStackTrace();
			return lb;
		}
		
		
	}
	
	public static java.util.List<NoteDetail> findallDetails(){
		java.util.List<Note> ln = findall();
		java.util.List<NoteDetail> lnd = new ArrayList<NoteDetail>();
		User u = null;
		Books b = null; 
		NoteDetail nd = null;
		for (Note n : ln){
			u = UserDao.find(n.getIdUser());
			b = BookDao.find(n.getIdBook());
			nd = new NoteDetail(b, u, n);
			lnd.add(nd);
		}		
		return lnd;
	}
	
	
	
	public static java.util.List<NoteDetail> findallDetailsUser(int id){
		java.util.List<Note> ln = findall(id);
		java.util.List<NoteDetail> lnd = new ArrayList<NoteDetail>();
		User u = null;
		Books b = null; 
		NoteDetail nd = null;
		for (Note n : ln){
			u = UserDao.find(n.getIdUser());
			b = BookDao.find(n.getIdBook());
			nd = new NoteDetail(b, u, n);
			lnd.add(nd);
		}		
		return lnd;
	}
	public static java.util.List<NoteDetail> findallDetailsBook(int id){
		java.util.List<Note> ln = findallBook(id);
		java.util.List<NoteDetail> lnd = new ArrayList<NoteDetail>();
		User u = null;
		Books b = null; 
		NoteDetail nd = null;
		for (Note n : ln){
			u = UserDao.find(n.getIdUser());
			b = BookDao.find(n.getIdBook());
			nd = new NoteDetail(b, u, n);
			lnd.add(nd);
		}		
		return lnd;
	}
	
	public static java.util.List<MatchDetail> findallMatchDetailsUser(int id){
		java.util.List<Match> lb = new ArrayList<Match>();
		java.util.List<MatchDetail> lnd = new ArrayList<MatchDetail>();
		Connection cnx = null;
		try{
		cnx = ConnexionBDD.getInstance().getCnx();
		java.sql.PreparedStatement statement = cnx.prepareStatement("SELECT id,idUser1,idUser2,idBook,Closest,Farthest,date FROM matching WHERE idUser1=?");
		statement.setInt(1, id);
		ResultSet res = statement.executeQuery();
		while (res.next()){
			lb.add(new Match(res.getInt("id"),
					res.getInt("idUser1"),
					res.getInt("idUser2"),
					res.getInt("idBook"),
					res.getInt("closest"),
					res.getInt("farthest"),
					res.getString("date")));
		}

		res.close();

		ConnexionBDD.getInstance().closecnx();
		
		User u1 = null;
		User u2 = null;
		Books b = null; 
		
		MatchDetail nd = null;
		for (Match n : lb){
			u1 = UserDao.find(n.getUser());
			u2 = UserDao.find(n.getUser2());
			b = BookDao.find(n.getIdBook());
			nd = new MatchDetail(b, u1, u2, n.getClosest(), n.getFarthest(), n.getDate());
			lnd.add(nd);
		}		
		return lnd;
		}catch(SQLException e){
			e.printStackTrace();
			return lnd;
		}
			
}

		
	public static java.util.List<MatchDetail> findallMatchDetailsBook(int id){
		java.util.List<Match> lb = new ArrayList<Match>();
		java.util.List<MatchDetail> lnd = new ArrayList<MatchDetail>();
		Connection cnx = null;
		try{
		cnx = ConnexionBDD.getInstance().getCnx();
		java.sql.PreparedStatement statement = cnx.prepareStatement("SELECT id,idUser1,idUser2,idBook,Closest,Farthest,date FROM matching WHERE idBook=?");
		statement.setInt(1, id);
		ResultSet res = statement.executeQuery();
		while (res.next()){
			lb.add(new Match(res.getInt("id"),
					res.getInt("idUser1"),
					res.getInt("idUser2"),
					res.getInt("idBook"),
					res.getInt("closest"),
					res.getInt("farthest"),
					res.getString("date")));
		}

		res.close();

		ConnexionBDD.getInstance().closecnx();
		
		User u1 = null;
		User u2 = null;
		Books b = null; 
		
		MatchDetail nd = null;
		for (Match n : lb){
			u1 = UserDao.find(n.getUser());
			u2 = UserDao.find(n.getUser2());
			b = BookDao.find(n.getIdBook());
			nd = new MatchDetail(b, u1, u2, n.getClosest(), n.getFarthest(), n.getDate());
			lnd.add(nd);
		}		
		return lnd;
		}catch(SQLException e){
			e.printStackTrace();
			return lnd;
		}
	}
}

