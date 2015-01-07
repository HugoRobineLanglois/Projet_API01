package com.UTC.BooksMatching.Beans;

import java.util.Comparator;

public class editeurComp implements Comparator<Books> {
	public int compare(Books b1, Books b2) {
		return b1.getEditeur().compareTo(b2.getEditeur());
	}
}
