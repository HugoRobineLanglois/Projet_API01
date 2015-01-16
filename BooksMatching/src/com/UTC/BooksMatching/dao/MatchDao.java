package com.UTC.BooksMatching.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.UTC.BooksMatching.Beans.Match;
import com.UTC.BooksMatching.Beans.User;

public class MatchDao {
	public static int insert(Match m){
		int res = 0;
		Connection cnx = null;
		try {
			cnx=ConnexionBDD.getInstance().getCnx();
			
			String sql = "INSERT INTO matches (user, closest, farthest) VALUES(?, ?, ?)";
			java.sql.PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, m.getUser().getId());
			ps.setString(2, m.getClosest());
			ps.setString(3,m.getFarthest());
			
			res=ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return res;
	}
	
	public static Match find(int idMatch) {		
		Match m = null;		
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();

			String sql = "SELECT * FROM match WHERE id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, idMatch);			
			
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				m = new Match(res.getInt("id"),
						UserDao.find(res.getInt("user")),
						res.getString("closest"),
						res.getString("farthest"));
				break;
			}
			
			res.close();
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}
	
	public static Match find(User user) {		
		Match m = null;		
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();

			String sql = "SELECT * FROM match WHERE user=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, user.getId());			
			
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				m = new Match(res.getInt("id"),
						UserDao.find(res.getInt("user")),
						res.getString("closest"),
						res.getString("farthest"));
				break;
			}
			
			res.close();
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}
	
	public static int update(Match m){
		int res =0;
		Connection cnx=null;
		try {
			cnx=ConnexionBDD.getInstance().getCnx();
			
			String sql = "UPDATE match SET user= ?, closest = ?, farthest= ? WHERE id = ? ";
			java.sql.PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, m.getUser().getId());
			ps.setString(2, m.getClosest());
			ps.setString(3,m.getFarthest());
			ps.setInt(4, m.getId());
			
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
			
			String sql = "DELETE FROM match WHERE id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1,id);
			
			res = ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	
	public static java.util.List<Match> findall(){
		java.util.List<Match> lm = new ArrayList<Match>();
		Connection cnx = null;
		try{
		cnx = ConnexionBDD.getInstance().getCnx();
		java.sql.PreparedStatement statement = cnx.prepareStatement("SELECT * FROM matches");
		ResultSet res = statement.executeQuery();
		while (res.next()){
			lm.add(new Match(res.getInt("id"),
					UserDao.find(res.getInt("user")),
					res.getString("closest"),
					res.getString("farthest")));
		}

		res.close();

		ConnexionBDD.getInstance().closecnx();
		return lm;
		

		} catch(SQLException e){
			e.printStackTrace();
			return lm;
		}
	}
}
