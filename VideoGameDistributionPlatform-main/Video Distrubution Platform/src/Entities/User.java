package Entities;

import java.util.ArrayList;

public class User {
	
	String id;
	String pw;
	
	private ArrayList <Game> games = new ArrayList<Game>();
	
	public User(String id, String pw) {
		
		this.id = id;
		this.pw = pw;
		
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public ArrayList<Game> getList() {
		return this.games;
	}


	
	
	
	

}
