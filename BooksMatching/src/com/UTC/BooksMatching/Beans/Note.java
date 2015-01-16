package com.UTC.BooksMatching.Beans;

import java.io.Serializable;

public class Note implements Serializable, Comparable<Note>{
	private int idBook; 
	private int idUser; 
	private int qualityOfWriting; 
	private int desireToKeepReading;
	private int desireFromSameAuteur; 
	private int desireToRecommend;
	private int isValid; 
	
	
	
	
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
	
	
	
}
