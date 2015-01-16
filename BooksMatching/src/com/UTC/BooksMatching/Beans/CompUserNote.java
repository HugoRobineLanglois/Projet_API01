package com.UTC.BooksMatching.Beans;

import java.util.Comparator;

public class CompUserNote implements Comparator<NoteDetail>{

	@Override
	public int compare(NoteDetail o1, NoteDetail o2) {
		// TODO Auto-generated method stub
		return o1.getUser().getNom().compareTo(o2.getUser().getNom());
	}

}
