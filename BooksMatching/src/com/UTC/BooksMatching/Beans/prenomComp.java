package com.UTC.BooksMatching.Beans;

import java.util.Comparator;

public class prenomComp implements Comparator<Admin>{
	public int compare(Admin a1, Admin a2) {
		return a1.getPrenom().compareTo(a2.getPrenom());
	}
}
