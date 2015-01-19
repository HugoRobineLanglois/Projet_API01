package com.UTC.BooksMatching.Beans;


import org.joda.time.DateTime;

public class Match {
	private int id;
	private int idUser1;
	private int idUser2;
	private int idBook;
	private int closest;
	private int farthest;
	private String date;
	
	
	
	public Match(int id, int idUser1, int idUser2, int idBook, int closest,
			int farthest, String date) {
		super();
		this.id = id;
		this.idUser1 = idUser1;
		this.idUser2 = idUser2;
		this.idBook = idBook;
		this.closest = closest;
		this.farthest = farthest;
		this.date = date;
	}

	public Match(int user, int user2, int idBook, int closest,
			int farthest, String date) {
		super();

		this.idUser1 = user;
		this.idUser2 = user2;
		this.idBook = idBook;
		this.closest = closest;
		this.farthest = farthest;
		this.date = date;
		
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser() {
		return idUser1;
	}
	public void setUser(int user) {
		this.idUser1 = user;
	}
	public int getUser2() {
		return idUser2;
	}
	public void setUser2(int user2) {
		this.idUser2 = user2;
	}
	public int getIdBook() {
		return idBook;
	}
	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}
	public int getClosest() {
		return closest;
	}
	public void setClosest(int closest) {
		this.closest = closest;
	}
	public int getFarthest() {
		return farthest;
	}
	public void setFarthest(int farthest) {
		this.farthest = farthest;
	}
	

	
}
