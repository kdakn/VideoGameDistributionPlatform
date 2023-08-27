package Entities;

public class Game {
	
	private String name;
	private String genre;
	private Developer developer;
	private int year;
	private double price = 0;
	
	public Game(String name, int year, Developer dev, String genre, double price) {
		this.name = name;
		this.year = year;
		this.developer = dev;
		this.genre = genre;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Developer getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	

}
