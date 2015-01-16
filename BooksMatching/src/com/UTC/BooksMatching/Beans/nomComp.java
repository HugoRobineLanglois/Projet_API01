package com.UTC.BooksMatching.Beans;

import java.util.Comparator;

public class nomComp implements Comparator<Admin>{
	public int compare(Admin a1, Admin a2) {
		return a1.getNom().compareTo(a2.getNom());
	}

}
