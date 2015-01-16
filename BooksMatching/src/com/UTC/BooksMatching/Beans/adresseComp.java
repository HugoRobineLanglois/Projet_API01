package com.UTC.BooksMatching.Beans;

import java.util.Comparator;

public class adresseComp implements Comparator<Admin> {
	public int compare(Admin a1, Admin a2) {
		return a1.getAdresse().compareTo(a2.getAdresse());
	}
}
