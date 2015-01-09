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
		String nom, prenom, adresse, pwd, telephone, date_creation;
		
		Connection cnx=null;
		
		try{		
			cnx = ConnexionBDD.getInstance().getCnx();	
			PreparedStatement ps = cnx.prepareStatement("SELECT adresse, nom, prenom, pwd, telephone, date_creation FROM administrateurs WHERE adresse = ?;");
			ps.setString(1, a.getAdresse());
			ResultSet rs = ps.executeQuery();
			adresse = rs.getString("adresse");
			nom = rs.getString("nom");
			prenom = rs.getString("prenom");
			pwd = rs.getString("pwd");
			telephone = rs.getString("telephone");
			date_creation = rs.getString("date_creation");
			
			
			if(adresse!=a.getAdresse())
				adresse=a.getAdresse();
			if(nom!=a.getNom())
				nom=a.getNom();
			if(a.getPrenom()!=prenom)
				prenom=a.getPrenom();
			if(pwd!=a.getPwd())
				pwd=a.getPwd();
			if(a.getTelephone()!=telephone)
				telephone=a.getTelephone();
			if(a.getDate_creation()!=date_creation)
				date_creation = a.getDate_creation();
			
			cnx = ConnexionBDD.getInstance().getCnx();
			PreparedStatement preparedStatement = cnx.prepareStatement("UPDATE administrateurs"
					+ " SET id=?, nom=?, tel=?, adresse=?, pdw=? WHERE id=?;");
			preparedStatement.setString(1,adresse);
			preparedStatement.setString(2,nom);
			preparedStatement.setString(3,prenom);
			preparedStatement.setString(4,pwd);
			preparedStatement.setString(5,telephone);
			preparedStatement.setString(6, date_creation);
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
