package com.UTC.BooksMatching.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.UTC.BooksMatching.Beans.User;

public class UserDao {
	public static int insert(User u){
		int res = 0;
		Connection cnx = null;
		try {
			cnx=ConnexionBDD.getInstance().getCnx();
			
			String sql = "INSERT INTO User(nom, pwd, adresse, telephone, dateCreation, statutCompte) VALUES(?, ?, ?, ?, ?, ?)";
			java.sql.PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, u.getNom());
			ps.setString(2, u.getPwd());
			ps.setString(3, u.getAdresse());
			ps.setString(4, u.getTelephone());
			ps.setString(5, u.getDateCreation());
			ps.setString(6, u.getStatutCompte());
			
			res=ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e){
			e.printStackTrace();
			return -42;
		}
		return res;
	}
	
	public static int update(User u){
		int res =0;
		Connection cnx=null;
		try {
			cnx=ConnexionBDD.getInstance().getCnx();
			
			String sql = "UPDATE User SET nom = ?, adresse = ?, telephone = ?, dateCreation = ?, statutCompte = ?, pwd= ? WHERE id = ?";
			java.sql.PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, u.getNom());
			ps.setString(2, u.getAdresse());
			ps.setString(3, u.getTelephone());
			ps.setString(4, u.getDateCreation());
			ps.setString(5, u.getStatutCompte());
			ps.setString(6, u.getPwd());
			ps.setInt(7, u.getId());
			
			res=ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static java.util.List<User> findall(){
		java.util.List<User> lu = new ArrayList<User>();
		Connection cnx = null;
		try{
		cnx = ConnexionBDD.getInstance().getCnx();
		java.sql.PreparedStatement statement = cnx.prepareStatement("SELECT * FROM user;");

		ResultSet res = statement.executeQuery();

		while (res.next()){
			lu.add(new User(res.getInt("id"),res.getString("nom"), res.getString("pwd"), res.getString("adresse"), res.getString("telephone"), res.getString("dateCreation"), res.getString("statutCompte")));
		}

		res.close();

		ConnexionBDD.getInstance().closecnx();

		return lu;

		} catch(SQLException e){
			e.printStackTrace();
			return lu;
		}
	}

	public static int delete(int id) {
		int res = 0;
		Connection cnx = null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			
			String sql = "DELETE FROM user WHERE id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1,id);
			
			res = ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;		
	}

	public static User find(int id) {
		User u = null;
		Connection cnx = null;
		try{
		cnx = ConnexionBDD.getInstance().getCnx();
		java.sql.PreparedStatement statement = cnx.prepareStatement("SELECT * FROM user WHERE id = ?;");
		statement.setInt(1, id);
		ResultSet res = statement.executeQuery();

		while (res.next()){
			u = new User (res.getInt("id"),res.getString("nom"), res.getString("pwd"), res.getString("adresse"), res.getString("telephone"), res.getString("dateCreation"), res.getString("statutCompte"));
			break;
		}

		res.close();

		ConnexionBDD.getInstance().closecnx();

		return u;

		} catch(SQLException e){
			e.printStackTrace();
			return u;
		}
	}
	
	public static User find(String adresse) {
		User u = null;
		Connection cnx = null;
		try{
		cnx = ConnexionBDD.getInstance().getCnx();
		java.sql.PreparedStatement statement = cnx.prepareStatement("SELECT * FROM user WHERE adresse = ?;");
		statement.setString(1, adresse);
		ResultSet res = statement.executeQuery();

		while (res.next()){
			u = new User (res.getInt("id"),res.getString("nom"), res.getString("pwd"), res.getString("adresse"), res.getString("telephone"), res.getString("dateCreation"), res.getString("statutCompte"));
			break;
		}

		res.close();

		ConnexionBDD.getInstance().closecnx();

		return u;

		} catch(SQLException e){
			e.printStackTrace();
			return u;
		}
	}
	
	public static int Activation(int id){
		
		Connection cnx = null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			java.sql.PreparedStatement statement = cnx.prepareStatement("update booksmatching.user SET statutCompte='Actif' WHERE id = ? ");
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
			return 1;
		}
		return 0;
	}
}
