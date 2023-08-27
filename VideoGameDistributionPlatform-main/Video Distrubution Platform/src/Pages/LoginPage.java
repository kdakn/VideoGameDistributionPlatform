package Pages;
import Entities.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Canvas;

public class LoginPage {

	private JFrame frame;
	private JTextField userIDField;
	private JPasswordField userPasswordField;
	private JTextField devIDField;
	private JPasswordField devPasswordField;
	
	private Gamer currentUser;
	private Developer currentDev;
	public boolean login = false;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Video Distrubition Platform - Login");
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 650, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		userIDField = new JTextField();
		userIDField.setBounds(104, 144, 140, 20);
		frame.getContentPane().add(userIDField);
		userIDField.setColumns(10);
		
		JLabel lblUserID = new JLabel("ID:");
		lblUserID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserID.setForeground(Color.WHITE);
		lblUserID.setFont(new Font("Century Schoolbook", Font.PLAIN, 13));
		lblUserID.setBounds(10, 146, 74, 14);
		frame.getContentPane().add(lblUserID);
		
		JButton userLoginButton = new JButton("LOGIN");
		userLoginButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				for(int i = 0; i < List.gamers.size(); i++) {
					if(userIDField.getText().equals(List.gamers.get(i).getId()) && userPasswordField.getText().equals(List.gamers.get(i).getPw())) {
						login = true;
						currentUser = List.gamers.get(i);
						break;
					}
				}
				
				if(!login) {
					JOptionPane.showMessageDialog(frame, "ID/Password is invalid!");
					userIDField.setText("");
					userPasswordField.setText("");
				}
				else {
					MainPage mp = new MainPage();
					mp.getFrame().setVisible(true);
					mp.setCurrentUser(currentUser);
					frame.dispose();
				}
			}
		});
		userLoginButton.setBounds(131, 230, 89, 23);
		frame.getContentPane().add(userLoginButton);
		
		userPasswordField = new JPasswordField();
		userPasswordField.setBounds(104, 183, 140, 20);
		frame.getContentPane().add(userPasswordField);
		
		JLabel lblUserPassword = new JLabel("Password:");
		lblUserPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserPassword.setForeground(Color.WHITE);
		lblUserPassword.setFont(new Font("Century Schoolbook", Font.PLAIN, 13));
		lblUserPassword.setBounds(10, 185, 74, 14);
		frame.getContentPane().add(lblUserPassword);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(Color.WHITE);
		canvas.setBounds(317, 0, 6, 361);
		frame.getContentPane().add(canvas);
		
		JLabel lblDevID = new JLabel("ID:");
		lblDevID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDevID.setForeground(Color.WHITE);
		lblDevID.setFont(new Font("Century Schoolbook", Font.PLAIN, 13));
		lblDevID.setBounds(338, 146, 74, 14);
		frame.getContentPane().add(lblDevID);
		
		JLabel lblDevPassword = new JLabel("Password:");
		lblDevPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDevPassword.setForeground(Color.WHITE);
		lblDevPassword.setFont(new Font("Century Schoolbook", Font.PLAIN, 13));
		lblDevPassword.setBounds(338, 185, 74, 14);
		frame.getContentPane().add(lblDevPassword);
		
		devIDField = new JTextField();
		devIDField.setColumns(10);
		devIDField.setBounds(432, 144, 140, 20);
		frame.getContentPane().add(devIDField);
		
		devPasswordField = new JPasswordField();
		devPasswordField.setBounds(432, 183, 140, 20);
		frame.getContentPane().add(devPasswordField);
		
		JButton devLoginButton = new JButton("LOGIN");
		devLoginButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				for(int i = 0; i < List.developers.size(); i++) {

					if(devIDField.getText().equals(List.developers.get(i).getId()) && devPasswordField.getText().equals(List.developers.get(i).getPw())) {
						login = true;
						currentDev = List.developers.get(i);
						break;
					}
				}
				
				if(!login) {
					JOptionPane.showMessageDialog(frame, "ID/Password is invalid!");
					devIDField.setText("");
					devPasswordField.setText("");
				}
				else {
					MainPageDev mpd = new MainPageDev();
					mpd.getFrame().setVisible(true);
					mpd.setCurrentUser(currentDev);
					frame.dispose();
				}
			}
		});
		devLoginButton.setBounds(459, 230, 89, 23);
		frame.getContentPane().add(devLoginButton);
		
		JLabel lblUserLogin = new JLabel("Login as Gamer");
		lblUserLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserLogin.setForeground(Color.WHITE);
		lblUserLogin.setFont(new Font("Elephant", Font.PLAIN, 29));
		lblUserLogin.setBounds(0, 32, 323, 64);
		frame.getContentPane().add(lblUserLogin);
		
		JLabel lblLoginAsDeveloper = new JLabel("Login as Developer");
		lblLoginAsDeveloper.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginAsDeveloper.setForeground(Color.WHITE);
		lblLoginAsDeveloper.setFont(new Font("Elephant", Font.PLAIN, 29));
		lblLoginAsDeveloper.setBounds(332, 32, 302, 64);
		frame.getContentPane().add(lblLoginAsDeveloper);
		
		JLabel lblDontHaveGamer = new JLabel("Don't have a gamer account yet?\r\n");
		lblDontHaveGamer.setHorizontalAlignment(SwingConstants.CENTER);
		lblDontHaveGamer.setForeground(Color.WHITE);
		lblDontHaveGamer.setFont(new Font("Elephant", Font.PLAIN, 12));
		lblDontHaveGamer.setBounds(0, 279, 311, 36);
		frame.getContentPane().add(lblDontHaveGamer);
		
		JButton btnSignUpGamer = new JButton("Sign Up");
		btnSignUpGamer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SignUpUserPage suser = new SignUpUserPage();
				suser.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnSignUpGamer.setBounds(90, 314, 140, 23);
		frame.getContentPane().add(btnSignUpGamer);
		
		JLabel lblDontHaveDev = new JLabel("Don't have a developer account yet?\r\n");
		lblDontHaveDev.setHorizontalAlignment(SwingConstants.CENTER);
		lblDontHaveDev.setForeground(Color.WHITE);
		lblDontHaveDev.setFont(new Font("Elephant", Font.PLAIN, 12));
		lblDontHaveDev.setBounds(322, 279, 312, 36);
		frame.getContentPane().add(lblDontHaveDev);
		
		JButton btnSignUpDev = new JButton("Sign Up");
		btnSignUpDev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpDevPage sdev = new SignUpDevPage();
				sdev.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnSignUpDev.setBounds(415, 314, 140, 23);
		frame.getContentPane().add(btnSignUpDev);
		
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
}
