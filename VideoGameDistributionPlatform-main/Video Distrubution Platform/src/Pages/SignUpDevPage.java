package Pages;
import Entities.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Entities.Gamer;
import Entities.List;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUpDevPage {

	private JFrame frame;
	private JTextField IDField;
	private JPasswordField passwordField;
	private JTextField nameField;
	
	private boolean signup = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpDevPage window = new SignUpDevPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUpDevPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Video Game Distribution Platform - Sign Up");
		frame.setBounds(100, 100, 300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Sign up as a Developer!");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Elephant", Font.PLAIN, 20));
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setBounds(0, 45, 284, 32);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Century Schoolbook", Font.PLAIN, 13));
		lblID.setForeground(Color.WHITE);
		lblID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblID.setBounds(0, 105, 82, 14);
		frame.getContentPane().add(lblID);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Century Schoolbook", Font.PLAIN, 13));
		lblPassword.setBounds(0, 187, 82, 14);
		frame.getContentPane().add(lblPassword);
		
		IDField = new JTextField();
		IDField.setBounds(102, 103, 134, 20);
		frame.getContentPane().add(IDField);
		IDField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(102, 185, 134, 20);
		frame.getContentPane().add(passwordField);
		
		JButton signInButton = new JButton("Sign Up");
		signInButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				for(int i = 0; i < List.developers.size(); i++) {
					if(IDField.getText().equals(List.developers.get(i).getId()) || nameField.getText().equals(List.developers.get(i).getName())) {
						signup = false;
						break;
					}
				}
				
				if(IDField.getText().equals("") || passwordField.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "ID/Password cannot be empty!");
				}
				else if(!signup) {
					JOptionPane.showMessageDialog(frame, "User Already Exists");
					signup = true;
				}
				else {
					JOptionPane.showMessageDialog(frame, "New Developer Account Has Been Created Successfuly!");
					List.developers.add(new Developer(IDField.getText(), passwordField.getText(), nameField.getText()));
					
					LoginPage lp = new LoginPage();
					lp.getFrame().setVisible(true);
					frame.dispose();
				}
			}
		});
		signInButton.setBounds(125, 216, 89, 23);
		frame.getContentPane().add(signInButton);
		
		JButton backButton = new JButton("<- Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage lp = new LoginPage();
				lp.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		backButton.setBounds(10, 11, 80, 20);
		frame.getContentPane().add(backButton);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(102, 144, 134, 20);
		frame.getContentPane().add(nameField);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Century Schoolbook", Font.PLAIN, 13));
		lblName.setBounds(0, 146, 82, 14);
		frame.getContentPane().add(lblName);
		
		
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
}
