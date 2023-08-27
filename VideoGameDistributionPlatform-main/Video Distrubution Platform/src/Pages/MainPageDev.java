package Pages;
import Entities.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MainPageDev {

	private JFrame frame;
	
	private Developer currentUser;
	MainPageDev mp = this;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
					window.mainPageFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public MainPageDev() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Video Game Distribution Platform - Main Page");
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 650, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton logOutButton = new JButton("LOG OUT");
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage lp = new LoginPage();
				lp.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		logOutButton.setForeground(Color.BLACK);
		logOutButton.setBackground(Color.WHITE);
		logOutButton.setBounds(107, 270, 417, 45);
		frame.getContentPane().add(logOutButton);
		
		JLabel lblNewLabel = new JLabel("Video Game Distribution Platform\r\n");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Elephant", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 614, 45);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblMainPage = new JLabel("Main Page");
		lblMainPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainPage.setForeground(Color.WHITE);
		lblMainPage.setFont(new Font("Elephant", Font.PLAIN, 20));
		lblMainPage.setBounds(10, 38, 614, 45);
		frame.getContentPane().add(lblMainPage);
		
		JButton publishedButton = new JButton("MY PUBLISHED GAMES");
		publishedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PublishedGamesPage pgp = new PublishedGamesPage(mp, currentUser);
				pgp.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		publishedButton.setForeground(Color.BLACK);
		publishedButton.setBackground(Color.WHITE);
		publishedButton.setBounds(107, 190, 417, 45);
		frame.getContentPane().add(publishedButton);
		
		JButton newGameButton = new JButton("ADD NEW GAME");
		newGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddNewGamePage angp = new AddNewGamePage(mp);
				angp.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		newGameButton.setForeground(Color.BLACK);
		newGameButton.setBackground(Color.WHITE);
		newGameButton.setBounds(107, 110, 417, 45);
		frame.getContentPane().add(newGameButton);
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public Developer getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(Developer currentUser) {
		this.currentUser = currentUser;
	}

	
	

}
