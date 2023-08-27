package Pages;
import Entities.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MainPage {

	private JFrame frame;
	
	private Gamer currentUser;
	private JButton cartButton;
	private MainPage mp = this;
	private ArrayList<Game> cart = new ArrayList<Game>();
	int cartsize = 0;

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
	public MainPage() {
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
		logOutButton.setBounds(107, 278, 417, 45);
		frame.getContentPane().add(logOutButton);
		
		cartButton = new JButton("Cart (0)");
		cartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CartPage cp = new CartPage(mp);
				cp.setBalance(currentUser.getBalance());
				cp.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		cartButton.setForeground(Color.BLACK);
		cartButton.setBackground(Color.WHITE);
		cartButton.setBounds(529, 11, 95, 32);
		frame.getContentPane().add(cartButton);
		
		JButton walletButton = new JButton("WALLET");
		walletButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WalletPage wp = new WalletPage(mp);
				wp.getFrame().setVisible(true);
				wp.setBalance(currentUser.getBalance());
				frame.setVisible(false);
			}
		});
		walletButton.setForeground(Color.BLACK);
		walletButton.setBackground(Color.WHITE);
		walletButton.setBounds(107, 222, 417, 45);
		frame.getContentPane().add(walletButton);
		
		JButton LibraryButton = new JButton("LIBRARY");
		LibraryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibraryPage lp = new LibraryPage(mp, currentUser);
				lp.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		LibraryButton.setForeground(Color.BLACK);
		LibraryButton.setBackground(Color.WHITE);
		LibraryButton.setBounds(107, 166, 417, 45);
		frame.getContentPane().add(LibraryButton);
		
		JButton storeButton = new JButton("STORE");
		storeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StorePage sp = new StorePage(mp);
				sp.getFrame().setVisible(true);
				sp.setCartSize(cartsize);
				sp.setCartTitle();
				frame.dispose();
				
			}
		});
		storeButton.setForeground(Color.BLACK);
		storeButton.setBackground(Color.WHITE);
		storeButton.setBounds(107, 110, 417, 45);
		frame.getContentPane().add(storeButton);
		
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
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public Gamer getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(Gamer currentUser) {
		this.currentUser = currentUser;
	}

	public ArrayList<Game> getCart() {
		return cart;
	}

	public void setCart(ArrayList<Game> cart) {
		this.cart = cart;
	}

	public int getCartSize() {
		if(cart.isEmpty()) {
			return 0;
		}
		else {
			return cart.size();
		}
	}
	
	public void setCartTitle() {
		cartButton.setText("Cart (" + cartsize +")");
	}


	
	

	
	

}
