package com.UTC.BooksMatching.Beans;

import java.io.Serializable;


public class User implements Serializable, Comparable<Admin>{
	private int id;
	private String nom;
	private String pwd;
	private String adresse; 
	private String telephone;
	private String dateCreation;
	private String statutCompte;
	private int coefEcriture;
	private int coefRecommandation;
	private int coefEnvie;
	private int coefAuteur;
	
	
	public User(int id, String nom, String pwd, String adresse,
			String telephone, String dateCreation, String statutCompte) {
		super();
		this.id = id;
		this.nom = nom;
		this.pwd = pwd;
		this.adresse = adresse;
		this.telephone = telephone;
		this.dateCreation = dateCreation;
		this.statutCompte = statutCompte;
		this.coefAuteur = 1;
		this.coefEcriture = 1;
		this.coefEnvie = 1;
		this.coefRecommandation = 1;
	}
	
	public User(String nom, String pwd, String adresse,
			String telephone, String dateCreation, String statutCompte) {
		super();
		this.nom = nom;
		this.pwd = pwd;
		this.adresse = adresse;
		this.telephone = telephone;
		this.dateCreation = dateCreation;
		this.statutCompte = statutCompte;
		this.coefAuteur = 1;
		this.coefEcriture = 1;
		this.coefEnvie = 1;
		this.coefRecommandation = 1;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setId(String id){
		this.id = Integer.parseInt(id);
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
	
	public int getCoefEcriture() {
		return coefEcriture;
	}

	public void setCoefEcriture(int coefEcriture) {
		this.coefEcriture = coefEcriture;
	}

	public int getCoefRecommandation() {
		return coefRecommandation;
	}

	public void setCoefRecommandation(int coefRecommandation) {
		this.coefRecommandation = coefRecommandation;
	}

	public int getCoefEnvie() {
		return coefEnvie;
	}

	public void setCoefEnvie(int coefEnvie) {
		this.coefEnvie = coefEnvie;
	}

	public int getCoefAuteur() {
		return coefAuteur;
	}

	public void setCoefAuteur(int coefAuteur) {
		this.coefAuteur = coefAuteur;
	}

	@Override
	public int compareTo(Admin arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
