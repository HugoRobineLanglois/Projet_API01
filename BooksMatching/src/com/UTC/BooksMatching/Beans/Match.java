package com.UTC.BooksMatching.Beans;

public class Match {
	private int id;
	private User user;
	private String closest;
	private String farthest;
	
	public Match(int id, User user, String closest, String farthest) {
		super();
		this.id = id;
		this.user = user;
		this.closest = closest;
		this.farthest = farthest;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getClosest() {
		return closest;
	}
	public void setClosest(String closest) {
		this.closest = closest;
	}
	public String getFarthest() {
		return farthest;
	}
	public void setFarthest(String farthest) {
		this.farthest = farthest;
	}
	
}
