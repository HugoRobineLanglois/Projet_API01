package com.UTC.BooksMatching.Beans;

import java.io.Serializable;

public class NoteDetail implements Serializable, Comparable<NoteDetail> {
	private Books book;
	private User user;
	private Note note;
	
	public NoteDetail(Books book, User user, Note note) {
		super();
		this.book = book;
		this.user = user;
		this.note = note;
	}
	
	public Books getBook() {
		return book;
	}
	public void setBook(Books book) {
		this.book = book;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	@Override
	public int compareTo(NoteDetail o) {
		// TODO Auto-generated method stub
		return this.book.getTitre().compareTo(o.book.getTitre());
	}	
}
