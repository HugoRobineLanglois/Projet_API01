package com.UTC.BooksMatching.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.UTC.BooksMatching.Beans.Match;
import com.UTC.BooksMatching.Beans.Note;
import com.UTC.BooksMatching.Beans.User;

public class MatchingDao {

	public static int abs(int i){
		if(i<0)
			return -i;
		else return i;
	}
	public static Match closematch (User u1,int idBook){
		System.out.println("dans closematch");
		Note n,n2;
		double [][]table_coef = new double[2][10];
		double [][]table_note = new double[2][10];
		double []closest = {0,0,0,100,100};
		double res=0;
		int i,j;
		
		for (i=0;i<2;i++){
			for (j=0;j<10;j++){
				table_coef[i][j]=100;
				table_note[i][j]=100;
			}
		}
		for (User u:UserDao.findall()){
			
			res = (abs(u.getCoefAuteur() - u1.getCoefAuteur())/ (u1.getCoefAuteur()*100)+ abs(u.getCoefEcriture() - u1.getCoefEcriture())/ (u1.getCoefEcriture()*100)+ abs(u.getCoefEnvie() - u1.getCoefEnvie())/ (u1.getCoefEnvie()*100)+ abs(u.getCoefRecommandation() - u1.getCoefRecommandation())/ (u1.getCoefRecommandation()*100))/4;
			for (j=0;j<10;j++){
				if(res<table_coef[1][j]){
					table_coef[1][j]=res;
					table_coef[0][j]=u.getId();
				}
			}
			n = NoteDao.find(u.getId(), idBook);
			n2 = NoteDao.find(u1.getId(), idBook);
			
			if ((n!=null) && (n2 != null)){
				res = (abs( n.getDesireFromSameAuteur() - n2.getDesireFromSameAuteur() )/ (n2.getDesireFromSameAuteur()*100)
						+ abs( n.getDesireToKeepReading() - n2.getDesireToKeepReading() )/ (n2.getDesireToKeepReading()*100)
						+ abs( n.getDesireToRecommend() - n2.getDesireToRecommend() )/ (n2.getDesireToRecommend()*100)
						+ abs( n.getQualityOfWriting() - n2.getQualityOfWriting() )/ (n2.getQualityOfWriting()*100))/4;
				
				for (j=0;j<10;j++){
					if(res<table_note[1][j]){
						table_note[1][j]=res;
						table_note[0][j]=u.getId();
					}
				}
				for(i=0;i<10;i++){
					for(j=0;j<10;j++){
						if (table_note[0][i]==table_coef[0][j])
							if(closest[3]>table_coef[1][j]){
								if(closest[4]>table_note[1][j]){
									closest[0]=u1.getId();
									closest[1]=u.getId();
									closest[2]=idBook;
									closest[3]=table_coef[1][j];
									closest[4]=table_note[1][j];
								}
							}
					}
				}
			
			}
		}
		DateTime dt = new DateTime();
		DateTimeFormatter form = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
		String date_creation = dt.toString(form);
		int idUser1 = (int)closest[0];
		int idUser2 = (int)closest[1];
		int idBookf = (int)closest[2];
		
		if(idUser1!=0 && idUser2 != 0 && idBookf !=0){
			Match m = new Match (idUser1,idUser2,idBookf,1,0,date_creation);
			return m;
		}
		
		System.out.println("fin de closematch");
		return null;
				
	}
	
	public static Match farthestmach (User u1,int idBook){
		System.out.println("dans farthest");
		Note n,n2;
		double [][]table_coef = new double[2][10];
		double [][]table_note = new double[2][10];
		double []closest = {0,0,0,0,0};
		double res=0;
		int i,j;
		
		for (i=0;i<2;i++){
			for (j=0;j<10;j++){
				table_coef[i][j]=0;
				table_note[i][j]=0;
			}
		}
		for (User u:UserDao.findall()){
			
			res = (abs(u.getCoefAuteur() - u1.getCoefAuteur())/ (u1.getCoefAuteur()*100)+ abs(u.getCoefEcriture() - u1.getCoefEcriture())/ (u1.getCoefEcriture()*100)+ abs(u.getCoefEnvie() - u1.getCoefEnvie())/ (u1.getCoefEnvie()*100)+ abs(u.getCoefRecommandation() - u1.getCoefRecommandation())/ (u1.getCoefRecommandation()*100))/4;
			for (j=0;j<10;j++){
				if(res>table_coef[1][j]){
					table_coef[1][j]=res;
					table_coef[0][j]=u.getId();
				}
			}
			n = NoteDao.find(u.getId(), idBook);
			n2 = NoteDao.find(u1.getId(), idBook);
			
			if ((n!=null) && (n2 != null)){
				res = (abs( n.getDesireFromSameAuteur() - n2.getDesireFromSameAuteur() )/ (n2.getDesireFromSameAuteur()*100)
						+ abs( n.getDesireToKeepReading() - n2.getDesireToKeepReading() )/ (n2.getDesireToKeepReading()*100)
						+ abs( n.getDesireToRecommend() - n2.getDesireToRecommend() )/ (n2.getDesireToRecommend()*100)
						+ abs( n.getQualityOfWriting() - n2.getQualityOfWriting() )/ (n2.getQualityOfWriting()*100))/4;
				
				for (j=0;j<10;j++){
					if(res>table_note[1][j]){
						table_note[1][j]=res;
						table_note[0][j]=u.getId();
					}
				}
				for(i=0;i<10;i++){
					for(j=0;j<10;j++){
						if (table_note[0][i]==table_coef[0][j])
							if(closest[3]<table_coef[1][j]){
								if(closest[4]<table_note[1][j]){
									closest[0]=u1.getId();
									closest[1]=u.getId();
									closest[2]=idBook;
									closest[3]=table_coef[1][j];
									closest[4]=table_note[1][j];
								}
							}
					}
				}
			
			}
		}
		DateTime dt = new DateTime();
		DateTimeFormatter form = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
		String date_creation = dt.toString(form);
		int idUser1 = (int)closest[0];
		int idUser2 = (int)closest[1];
		int idBookf = (int)closest[2];
		
		if(idUser1!=0 && idUser2 != 0 && idBookf !=0){
			Match m = new Match (idUser1,idUser2,idBookf,1,0,date_creation);
			return m;
		}
		
		System.out.println("fin de farthestMatch");
		return null;
				
	}
	
	public static int insert(Match m){
		System.out.println("dans insert");
		int res = 0;
		Connection cnx = null;
		try {
			
			cnx=ConnexionBDD.getInstance().getCnx();

			String sql = "INSERT INTO matching(idUser1, idUser2, idBook, closest, farthest, date) VALUES(?, ?, ?, ?, ?,?)";
			java.sql.PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, m.getUser());
			ps.setInt(2, m.getUser2());
			ps.setInt(3, m.getIdBook());
			ps.setInt(4, m.getClosest());
			ps.setInt(5, m.getFarthest());
			ps.setString(6,m.getDate());
			
			res=ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return res;
	}
	
	public static java.util.List<Match> findMatch(int User1, int User2, int idBook) {
		//liste des match associé à un individu et à un livre

		java.util.List<Match> m = new ArrayList<Match>();
		
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();

			String sql = "SELECT id, idUser1, idUser2, idBook, Chlosest, Farthest, date FROM matching WHERE idUser1=? AND idUser2=? AND idBook=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, User1);
			ps.setInt(1, User2);
			ps.setInt(1, idBook);
			
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				m.add(new Match(res.getInt("id"),
						res.getInt("idUser1"),
						res.getInt("idUser2"),
						res.getInt("idBook"),
						res.getInt("Closest"),
						res.getInt("Farthest"),
						res.getString("Date")));
			}
			
			res.close();
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//
		System.out.println("J'ai trouvé mon match et je le retourne en objet");
		return m;
	}
	
	public static Match findLastClosest(int User1, int idBook) {
		java.util.List<Match> lm = new ArrayList<Match>();
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();

			String sql = "SELECT id, idUser1, idUser2, idBook, Closest, Farthest, date FROM matching WHERE idUser1=? AND idBook=? AND Closest=1";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, User1);
			
			ps.setInt(2, idBook);
			
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				lm.add(new Match(res.getInt("id"),
						res.getInt("idUser1"),
						res.getInt("idUser2"),
						res.getInt("idBook"),
						res.getInt("Closest"),
						res.getInt("Farthest"),
						res.getString("Date")));
			}
			
			res.close();
			ConnexionBDD.getInstance().closeCnx();			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (!lm.isEmpty()){
			Match m = lm.get(1);
			
			try {
			
			String dateString = m.getDate();
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			
			Date dateRef=df.parse(dateString);
			for (Match tmp:lm){
				String datetmp = tmp.getDate();
				
				
	    		
					Date date = df.parse(datetmp);
					
					if(date.after(dateRef)){
						m=tmp;
					}
			}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			//
			System.out.println("J'ai trouvé mon match et je le retourne en objet");
			return m;
		}
		else return null;
		}
	
	public static Match findLastFarthest(int User1, int idBook) {
		java.util.List<Match> lm = new ArrayList<Match>();
		System.out.println("Je cherche le match le plus loin en temps !");

		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();

			String sql = "SELECT id, idUser1, idUser2, idBook, Closest, Farthest, date FROM matching WHERE idUser1=? AND idBook=? AND Farthest=1";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, User1);
			
			ps.setInt(2, idBook);
			
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				lm.add(new Match(res.getInt("id"),
						res.getInt("idUser1"),
						res.getInt("idUser2"),
						res.getInt("idBook"),
						res.getInt("Closest"),
						res.getInt("Farthest"),
						res.getString("Date")));
			}
				
			res.close();
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
				e.printStackTrace();
		}
		
		if (!lm.isEmpty()){
			Match m = lm.get(1);
			
			try {
				
				String dateString = m.getDate();
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				
				Date dateRef=df.parse(dateString);
				for (Match tmp:lm){
					String datetmp = tmp.getDate();
					
					
		    		
						Date date = df.parse(datetmp);
						
						if(date.after(dateRef)){
							m=tmp;
						}
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
				//
			System.out.println("J'ai trouvé mon match et je le retourne en objet");
			return m;
		}
		System.out.println("Je n'ai pas trouvé mon match.... Liste vide !");

		return null;
			
	}
		
}
