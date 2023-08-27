package Pages;

import Entities.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import Entities.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNewGamePage {

	private JFrame frame;
	MainPageDev mp;
	private JTextField nameField;
	private JTextField yearField;
	private JTextField genreField;
	private JTextField priceField;
	
	private boolean gameExists = false;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public AddNewGamePage(MainPageDev mp) {
		this.mp = mp;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Video Game Distribution Platform - Add New Game");
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 650, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
		lblName.setBounds(22, 146, 107, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setHorizontalAlignment(SwingConstants.RIGHT);
		lblYear.setForeground(Color.WHITE);
		lblYear.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
		lblYear.setBounds(22, 191, 107, 14);
		frame.getContentPane().add(lblYear);
		
		JLabel lblGenre = new JLabel("Genre:");
		lblGenre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGenre.setForeground(Color.WHITE);
		lblGenre.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
		lblGenre.setBounds(22, 236, 107, 14);
		frame.getContentPane().add(lblGenre);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
		lblPrice.setBounds(22, 281, 107, 14);
		frame.getContentPane().add(lblPrice);
		
		nameField = new JTextField();
		nameField.setBounds(150, 145, 159, 20);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		yearField = new JTextField();
		yearField.setColumns(10);
		yearField.setBounds(150, 190, 159, 20);
		frame.getContentPane().add(yearField);
		
		genreField = new JTextField();
		genreField.setColumns(10);
		genreField.setBounds(150, 235, 159, 20);
		frame.getContentPane().add(genreField);
		
		priceField = new JTextField();
		priceField.setColumns(10);
		priceField.setBounds(150, 280, 159, 20);
		frame.getContentPane().add(priceField);
		
		JButton addButton = new JButton("Add Game");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				for (int i = 0; i < List.games.size(); i++) {
					if(nameField.getText().equals(List.games.get(i).getName())) {
						gameExists = true;
						break;
					}
				}
				if(nameField.getText().equals("") || yearField.getText().equals("") || genreField.getText().equals("") || priceField.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Fields cannot be empty!");
				}
				else if(gameExists) {
					JOptionPane.showMessageDialog(frame, "Game already exists, try to update the game.");
					gameExists = false;
				}
				else {
					Game game = new Game(nameField.getText(), Integer.parseInt(yearField.getText()), mp.getCurrentUser(), genreField.getText(), Double.parseDouble(priceField.getText()));
					List.games.add(game);
					mp.getCurrentUser().getGames().add(game);
					JOptionPane.showMessageDialog(frame, nameField.getText() + " added successfuly");
				}
			}
		});
		
		addButton.setBounds(432, 180, 136, 41);
		frame.getContentPane().add(addButton);
		
		JButton updateButton = new JButton("Update Game");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Game game = null;
				int index = 0;
				for (int i = 0; i < mp.getCurrentUser().getGames().size(); i++) {
					if(nameField.getText().equals(mp.getCurrentUser().getGames().get(i).getName())) {
						gameExists = true;
						index = i;
						game = mp.getCurrentUser().getGames().get(i);
						break;
					}
				}
				
				if(nameField.getText().equals("") || yearField.getText().equals("") || genreField.getText().equals("") || priceField.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Fields cannot be empty!");
				}
				else if(!gameExists) {
					JOptionPane.showMessageDialog(frame, "Game does not exist or you are not the publisher of the game!");
				}
				else {
					game.setYear(Integer.parseInt(yearField.getText()));
					game.setGenre(genreField.getText());
					game.setPrice(Double.parseDouble(priceField.getText()));
					mp.getCurrentUser().getGames().remove(index);
					mp.getCurrentUser().getGames().add(game);
					
					for (int i = 0; i < List.games.size(); i++) {
						if(nameField.getText().equals(List.games.get(i).getName())) {
							List.games.remove(i);
						}
					}
					List.games.add(game);
					
					mp.getCurrentUser().getGames().add(game);
					JOptionPane.showMessageDialog(frame, nameField.getText() + " updated successfuly!");
				}
				
			}
		});
		updateButton.setBounds(432, 254, 136, 41);
		frame.getContentPane().add(updateButton);
		
		JButton backButton = new JButton("<- Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mp.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		backButton.setBounds(20, 28, 80, 20);
		frame.getContentPane().add(backButton);
		
		JLabel lblAddNewGame = new JLabel("ADD NEW GAME");
		lblAddNewGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddNewGame.setForeground(Color.WHITE);
		lblAddNewGame.setFont(new Font("Elephant", Font.PLAIN, 40));
		lblAddNewGame.setBounds(10, 42, 614, 70);
		frame.getContentPane().add(lblAddNewGame);
		
	}

	public JFrame getFrame() {
		return frame;
	}
	
	
}
