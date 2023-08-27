package Pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class WalletPage {

	private JFrame frame;
	MainPage mp;
	private JTextField valueField;
	private JTextField cardNoField;
	private JTextField cvvField;
	private JLabel lblBalance;
	
	private boolean validMonth = false;
	private boolean validYear = false;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public WalletPage(MainPage mp) {
		initialize();
		this.mp = mp;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Video Distribution Platform - Wallet");
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblValue = new JLabel("Value to Deposit:");
		lblValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValue.setForeground(Color.WHITE);
		lblValue.setFont(new Font("Century Schoolbook", Font.PLAIN, 13));
		lblValue.setBounds(31, 141, 107, 14);
		frame.getContentPane().add(lblValue);
		
		JLabel lblCardNumber = new JLabel("Card Number");
		lblCardNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCardNumber.setForeground(Color.WHITE);
		lblCardNumber.setFont(new Font("Century Schoolbook", Font.PLAIN, 13));
		lblCardNumber.setBounds(31, 178, 107, 14);
		frame.getContentPane().add(lblCardNumber);
		
		JLabel lblExpirationDate = new JLabel("Expiration Date:");
		lblExpirationDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExpirationDate.setForeground(Color.WHITE);
		lblExpirationDate.setFont(new Font("Century Schoolbook", Font.PLAIN, 13));
		lblExpirationDate.setBounds(31, 215, 107, 14);
		frame.getContentPane().add(lblExpirationDate);
		
		JLabel lblCvv = new JLabel("CVV:");
		lblCvv.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCvv.setForeground(Color.WHITE);
		lblCvv.setFont(new Font("Century Schoolbook", Font.PLAIN, 13));
		lblCvv.setBounds(31, 253, 107, 14);
		frame.getContentPane().add(lblCvv);
		
		valueField = new JTextField();
		valueField.setBounds(160, 139, 229, 20);
		frame.getContentPane().add(valueField);
		valueField.setColumns(10);
		
		cardNoField = new JTextField();
		cardNoField.setBounds(160, 176, 229, 20);
		frame.getContentPane().add(cardNoField);
		cardNoField.setColumns(10);
		
		JComboBox monthBox = new JComboBox(new Object[] {"01","02","03","04","05","06","07","08","09","10","11","12"});
		monthBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(monthBox.getSelectedItem().equals("06")) {
					validMonth = true;
				}
			}
		});
		monthBox.setBounds(160, 213, 52, 20);
		frame.getContentPane().add(monthBox);
		
		JComboBox yearBox = new JComboBox(new Object[] {"2022","2023","2024","2025","2026","2027","2028","2029"});
		yearBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(yearBox.getSelectedItem().equals("2026")) {
					validYear = true;
				}
			}
		});
		yearBox.setBounds(222, 213, 72, 20);
		frame.getContentPane().add(yearBox);
		
		cvvField = new JTextField();
		cvvField.setBounds(160, 251, 60, 20);
		frame.getContentPane().add(cvvField);
		cvvField.setColumns(10);
		
		JButton depositButton = new JButton("Deposit");
		depositButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardNoField.getText().equals("1111 2222 3333 4444") && cvvField.getText().equals("123") && validYear && validMonth) {
					mp.getCurrentUser().setBalance(mp.getCurrentUser().getBalance() + Double.parseDouble(valueField.getText()));
					setBalance(mp.getCurrentUser().getBalance());
					JOptionPane.showMessageDialog(frame, "Money Transfer has been completed successfuly!");
				}
				else {
					JOptionPane.showMessageDialog(frame, "Credit card informations are invalid!");
				}
			}
		});
		depositButton.setBounds(160, 301, 89, 23);
		frame.getContentPane().add(depositButton);
		
		JLabel lblWallet = new JLabel("WALLET");
		lblWallet.setHorizontalAlignment(SwingConstants.CENTER);
		lblWallet.setForeground(Color.WHITE);
		lblWallet.setFont(new Font("Elephant", Font.PLAIN, 40));
		lblWallet.setBounds(10, 11, 614, 70);
		frame.getContentPane().add(lblWallet);
		
		JLabel lblCurrentBalance = new JLabel("Current Balance: ");
		lblCurrentBalance.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurrentBalance.setForeground(Color.WHITE);
		lblCurrentBalance.setFont(new Font("Elephant", Font.PLAIN, 25));
		lblCurrentBalance.setBounds(31, 80, 229, 50);
		frame.getContentPane().add(lblCurrentBalance);
		
		lblBalance = new JLabel("");
		lblBalance.setHorizontalAlignment(SwingConstants.LEFT);
		lblBalance.setForeground(Color.WHITE);
		lblBalance.setFont(new Font("Elephant", Font.PLAIN, 25));
		lblBalance.setBounds(270, 78, 229, 50);
		frame.getContentPane().add(lblBalance);
		
		JButton backButton = new JButton("<- Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mp.getFrame().setVisible(true);
				mp.setCartTitle();
				frame.dispose();
			}
		});
		backButton.setBounds(20, 28, 80, 20);
		frame.getContentPane().add(backButton);
		
		
		frame.setBounds(100, 100, 650, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	public void setBalance(double b) {
		lblBalance.setText("$" + b);
	}
}
