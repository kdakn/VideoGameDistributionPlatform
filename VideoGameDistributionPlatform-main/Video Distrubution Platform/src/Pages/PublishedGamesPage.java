package Pages;
import Entities.*;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class PublishedGamesPage {

	private JFrame frame;
	JTable table;
	MainPageDev mp;
	Developer currentUser;


	/**
	 * Create the application.
	 */
	public PublishedGamesPage(MainPageDev mp, Developer current) {
		this.mp = mp;
		this.currentUser = current;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 650, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton backButton = new JButton("<- Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mp.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		backButton.setBounds(20, 28, 80, 20);
		frame.getContentPane().add(backButton);
		
		JLabel lblMyPublshed = new JLabel("MY PUBLISHED");
		lblMyPublshed.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyPublshed.setForeground(Color.WHITE);
		lblMyPublshed.setFont(new Font("Elephant", Font.PLAIN, 40));
		lblMyPublshed.setBounds(10, 11, 614, 70);
		frame.getContentPane().add(lblMyPublshed);
		
		JLabel lblGames = new JLabel("GAMES");
		lblGames.setHorizontalAlignment(SwingConstants.CENTER);
		lblGames.setForeground(Color.WHITE);
		lblGames.setFont(new Font("Elephant", Font.PLAIN, 40));
		lblGames.setBounds(10, 59, 614, 70);
		frame.getContentPane().add(lblGames);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("Click to select.");
		scrollPane.setBounds(10, 140, 614, 210);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.DARK_GRAY);
		table.setFont(new Font("Impact", Font.PLAIN, 13));
		table.setForeground(Color.WHITE);
		scrollPane.setColumnHeaderView(table);
		DefaultTableModel model = new DefaultTableModel();
		Object [] column = {"Name", "Year", "Genre", "Price"};
		model.setColumnIdentifiers(column);
		table.setModel(model);
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(200);
		scrollPane.setViewportView(table);
		table.setRowHeight(30);

		for(int i = 0; i < currentUser.getGames().size(); i++) {
			Object [] row = {currentUser.getGames().get(i).getName(), currentUser.getGames().get(i).getYear(), currentUser.getGames().get(i).getGenre(), currentUser.getGames().get(i).getPrice()};
			model.addRow(row);	
		}
		
		
	}

	public JFrame getFrame() {
		return frame;
	}
	

}
