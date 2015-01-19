package com.UTC.BooksMatching.Beans;

import java.io.Serializable;


public class Books implements Serializable, Comparable<Books>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String titre; 
	private String auteur; 
	private String editeur; 
	private String ISBN; 
	private String genre;
	
	
	
	public Books(int id, String titre, String auteur, String editeur,
			String iSBN, String genre) {
		super();
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.editeur = editeur;
		this.ISBN = iSBN;
		this.genre = genre;
	}

	public Books(String titre, String auteur, String editeur, String iSBN,
			String genre) {
		super();
		this.titre = titre;
		this.auteur = auteur;
		this.editeur = editeur;
		this.ISBN = iSBN;
		this.genre = genre;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getEditeur() {
		return editeur;
	}
	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}
	
	public String getISBN() {
		return this.ISBN;
	}
	public void setISBN(String iSBN) {
		this.ISBN = iSBN;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public int compareTo(Books o) {
		// TODO Auto-generated method stub
		return this.titre.compareTo(o.titre);
	}
} 

