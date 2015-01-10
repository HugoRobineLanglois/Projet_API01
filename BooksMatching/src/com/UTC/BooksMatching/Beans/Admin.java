package com.UTC.BooksMatching.Beans;

import java.io.Serializable;

public class Admin implements Serializable, Comparable<Admin>{
	
	private static final long serialVersionUID = 1L;
	
	private String adresse;
	private String nom;
	private String prenom;
	private String pwd;
	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	private String telephone;
	private String date_creation;
	
	
	public Admin(String adresse, String nom, String prenom, String pwd, String telephone, String date_creation) {
		super();
		this.adresse = adresse;
		this.nom = nom;
		this.prenom = prenom;
		this.pwd = pwd;
		this.telephone = telephone;
		this.date_creation = date_creation;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getDate_creation() {
		return date_creation;
	}


	public void setDate_creation(String date_creation) {
		this.date_creation = date_creation;
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


	@Override
	public int compareTo(Admin arg0) {
		// TODO Auto-generated method stub
		if((this.adresse.compareTo(arg0.getAdresse()) == 0) && (this.nom.compareTo(arg0.getNom())==0) && (this.prenom.compareTo(arg0.getPrenom())==0)
				&& (this.pwd.compareTo(arg0.getPwd())==0) && (this.telephone.compareTo(arg0.getTelephone())==0) && (this.date_creation.compareTo(arg0.getDate_creation())==0))
				return 0;
		else return 1;
	}

}
