package com.UTC.BooksMatching.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.UTC.BooksMatching.Beans.Admin;

public class AdminDao {
	public static int insert (Admin a){
		int res = 0;
		
		Connection cnx=null;
		try{
			cnx = ConnexionBDD.getInstance().getCnx();
			PreparedStatement preparedStatement = cnx.prepareStatement("INSERT"
					+ " INTO administrateurs(adresse, nom, prenom, pwd, telephone, date_creation) VALUES (?, ?, ?, ?, ?, ? );");
			preparedStatement.setString(1,a.getAdresse());
			preparedStatement.setString(2,a.getNom());
			preparedStatement.setString(3,a.getPrenom());
			preparedStatement.setString(4,a.getPwd());
			preparedStatement.setString(5,a.getTelephone());
			preparedStatement.setString(6,a.getDate_creation());
			res = preparedStatement.executeUpdate();
			
			return res;
			
		} catch (SQLException e){
			return res;
		}
	}
	
	public static int delete (String adresse){
		int res = 0;
		
		Connection cnx=null;
		try{
			cnx = ConnexionBDD.getInstance().getCnx();
			PreparedStatement preparedStatement = cnx.prepareStatement("DELETE FROM administrateurs WHERE adresse=?;");
			preparedStatement.setString(1,adresse);
			res = preparedStatement.executeUpdate();
			
			return res;
			
		} catch (SQLException e){
			e.printStackTrace();
			return res;
		}
	}
	
	public static int update (Admin a){
		int res = 0;
		
		Connection cnx=null;
		
		try{		
			cnx = ConnexionBDD.getInstance().getCnx();	
			
			cnx = ConnexionBDD.getInstance().getCnx();
			PreparedStatement preparedStatement = cnx.prepareStatement("UPDATE administrateurs"
					+ " SET nom=?,prenom=?, pwd=?, telephone=? WHERE adresse=?;");
			preparedStatement.setString(1,a.getNom());
			preparedStatement.setString(2,a.getPrenom());
			preparedStatement.setString(3,a.getPwd());
			preparedStatement.setString(4,a.getTelephone());
			preparedStatement.setString(5, a.getAdresse());
			res = preparedStatement.executeUpdate();
			
			return res;
			
		} catch (SQLException e){
			return res;
		}
	}
	
public static Admin find(String adresse) {
		

		Admin a = null;
		
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			
			//Requete
			String sql = "SELECT adresse, nom, prenom, pwd, telephone, date_creation FROM administrateurs WHERE adresse=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, adresse);
			
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				a = new Admin(res.getString("adresse"),
						res.getString("nom"),
						res.getString("prenom"),
						res.getString("pwd"),
						res.getString("telephone"),
						res.getString("date_creation"));
				break;
			}
			
			res.close();
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public static java.util.List<Admin> findall(){
		java.util.List<Admin> lu = new ArrayList<Admin>();
		Connection cnx = null;
		try{
			cnx = ConnexionBDD.getInstance().getCnx();
			java.sql.PreparedStatement statement = cnx.prepareStatement("SELECT adresse, nom, prenom, pwd, telephone, date_creation FROM administrateurs;");
	
			ResultSet res = statement.executeQuery();

			while (res.next()){
				lu.add(new Admin(res.getString("adresse"),res.getString("nom"), res.getString("prenom"), res.getString("pwd"), res.getString("telephone"), res.getString("date_creation")));
			}
	
			res.close();
	
			ConnexionBDD.getInstance().closecnx();
	
			return lu;

		} catch(SQLException e){
			e.printStackTrace();
			return lu;
		}
	}
}
