package com.UTC.BooksMatching.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.UTC.BooksMatching.Beans.User;

public class UserDao {
	public static int insert(User u){
		int res = 0;
		Connection cnx = null;
		try {
			cnx=ConnexionBDD.getInstance().getCnx();
			
			String sql = "INSERT INTO User(nom, adresse, telephone, dateCreation, statuCompte, mdp) VALUES(?, ?, ?, ?, ?, ?)";
			java.sql.PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, u.getNom());
			ps.setString(2, u.getAdresse());
			ps.setString(3, u.getTelephone());
			ps.setString(4, u.getDateCreation());
			ps.setString(4, u.getStatutCompte());
			ps.setString(4, u.getMdp());
			
			res=ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return res;
	}
	
	public static int update(User u){
		int res =0;
		Connection cnx=null;
		try {
			cnx=ConnexionBDD.getInstance().getCnx();
			
			String sql = "UPDATE User SET nom = ?, adresse = ?, telephone = ?, dateCreation = ?, statuCompte = ?, mdp= ? WHERE id = ?";
			java.sql.PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, u.getNom());
			ps.setString(2, u.getTel());
			ps.setString(3, u.getUsername());
			ps.setString(4, u.getPwd());
			ps.setInt(5, u.getId());
			
			res=ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return res;
	}
}
