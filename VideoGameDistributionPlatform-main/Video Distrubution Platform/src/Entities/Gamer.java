package Entities;

import java.util.ArrayList;

public class Gamer extends User{
	
	
	double walletBalance = 0;

	

	public Gamer(String id, String pw) {
		
		super(id, pw);
		
	}
	
	
	public void setBalance(double balance) {
		this.walletBalance = balance;
	}
	
	public Double getBalance() {
		return this.walletBalance;
	}
	
	public ArrayList<Game> getGames() {
		return super.getList();
	}

}
