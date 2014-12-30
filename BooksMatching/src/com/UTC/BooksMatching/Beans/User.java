package com.UTC.BooksMatching.Beans;


public class User {
<<<<<<< HEAD
	private String nom;
	private String pwd;
	private String adresse; 
	private String telephone;
	private String dateCreation;
	private String statutCompte;	
=======
	private int id;
	private String nom; 
	private String adresse; 
	private String telephone;
	private String dateCreation;
	private String statutCompte;
	private String mdp;
>>>>>>> origin/master
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getStatutCompte() {
		return statutCompte;
	}
	public void setStatutCompte(String statutCompte) {
		this.statutCompte = statutCompte;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
}
