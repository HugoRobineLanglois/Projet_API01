package com.UTC.BooksMatching.Beans;

import java.util.Comparator;

public class auteurComp implements Comparator<Books> {
	public int compare(Books b1, Books b2) {
		return b1.getAuteur().compareTo(b2.getAuteur());
	}
}
