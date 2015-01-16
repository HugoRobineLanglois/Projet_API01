package com.UTC.BooksMatching.Beans;

import java.util.Comparator;

public class CompTitreNote implements Comparator<NoteDetail>{
	public int compare(NoteDetail n1, NoteDetail n2) {
		return n1.getBook().getTitre().compareTo(n2.getBook().getTitre());
	}
}
