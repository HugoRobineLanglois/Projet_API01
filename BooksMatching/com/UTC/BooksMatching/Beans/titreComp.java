package com.UTC.BooksMatching.Beans;

import java.util.Comparator;

public class titreComp implements Comparator<Books> {
	public int compare(Books b1, Books b2) {
		return b1.getTitre().compareTo(b2.getTitre());
	}
}
