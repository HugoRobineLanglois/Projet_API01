package com.UTC.BooksMatching.Beans;

import java.io.Serializable;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Note implements Serializable, Comparable<Note>{
	private int idBook; 
	private int idUser; 
	private int qualityOfWriting; 
	private int desireToKeepReading;
	private int desireFromSameAuteur; 
	private int desireToRecommend;
	private int isValid; 
	private String comments; 
	private String date; 
	
	
	
	
	public Note(int idBook, int idUser, int qualityOfWriting,
			int desireToKeepReading, int desireFromSameAuteur,
			int desireToRecommend, int isValid) {
		super();
		this.idBook = idBook;
		this.idUser = idUser;
		this.qualityOfWriting = qualityOfWriting;
		this.desireToKeepReading = desireToKeepReading;
		this.desireFromSameAuteur = desireFromSameAuteur;
		this.desireToRecommend = desireToRecommend;
		this.isValid=isValid; 
		DateTime dt = new DateTime();
		DateTimeFormatter form = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
		this.date = dt.toString(form);
	}

	
	public Note(int idBook, int idUser, int qualityOfWriting,
			int desireToKeepReading, int desireFromSameAuteur,
			int desireToRecommend, int isValid, String comment) {
		super();
		this.idBook = idBook;
		this.idUser = idUser;
		this.qualityOfWriting = qualityOfWriting;
		this.desireToKeepReading = desireToKeepReading;
		this.desireFromSameAuteur = desireFromSameAuteur;
		this.desireToRecommend = desireToRecommend;
		this.isValid=isValid; 
		DateTime dt = new DateTime();
		DateTimeFormatter form = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
		this.date = dt.toString(form);
		this.comments=comment; 
	}
	
	public Note(int idBook, int idUser, int qualityOfWriting,
			int desireToKeepReading, int desireFromSameAuteur,
			int desireToRecommend, int isValid,String date, String comment) {
		super();
		this.idBook = idBook;
		this.idUser = idUser;
		this.qualityOfWriting = qualityOfWriting;
		this.desireToKeepReading = desireToKeepReading;
		this.desireFromSameAuteur = desireFromSameAuteur;
		this.desireToRecommend = desireToRecommend;
		this.isValid=isValid; 
		this.date = date;
		this.comments=comment; 
	}


	public int getIdBook() {
		return idBook;
	}




	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}




	public int getIdUser() {
		return idUser;
	}




	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}




	public int getQualityOfWriting() {
		return qualityOfWriting;
	}




	public void setQualityOfWriting(int qualityOfWriting) {
		this.qualityOfWriting = qualityOfWriting;
	}




	public int getDesireToKeepReading() {
		return desireToKeepReading;
	}




	public void setDesireToKeepReading(int desireToKeepReading) {
		this.desireToKeepReading = desireToKeepReading;
	}




	public int getDesireFromSameAuteur() {
		return desireFromSameAuteur;
	}




	public void setDesireFromSameAuteur(int desireFromSameAuteur) {
		this.desireFromSameAuteur = desireFromSameAuteur;
	}




	public int getDesireToRecommend() {
		return desireToRecommend;
	}




	public void setIsValid(int isValid) {
		this.isValid = isValid;
	}

	public int getIsValid() {
		return isValid;
	}




	public void setDesireToRecommend(int desireToRecommend) {
		this.desireToRecommend = desireToRecommend;
	}



	@Override
	public int compareTo(Note o) {
		// TODO Auto-generated method stub
		return 0;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
