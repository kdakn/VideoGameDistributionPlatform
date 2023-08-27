package Entities;

import java.util.ArrayList;

public class Developer extends User{
	
	String name;
	
	public Developer(String id, String pw, String name) {
		
		super(id, pw);
		this.name = name;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String toString() {
		return this.name;
	}
	
	public ArrayList<Game> getGames() {
		return super.getList();
	}
	
	
	
	
	
	

}
