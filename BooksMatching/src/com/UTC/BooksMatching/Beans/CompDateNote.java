package com.UTC.BooksMatching.Beans;

import java.util.Comparator;

public class CompDateNote implements Comparator<NoteDetail>{

	@Override
	public int compare(NoteDetail o1, NoteDetail o2) {
		return o1.getNote().getDate().compareTo(o2.getNote().getDate());
	}

}
