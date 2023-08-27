package Pages;

import java.awt.Color;
import Entities.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Entities.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JProgressBar;
	
	
public class LibraryPage {
	
	static Timer timer;
	
	

	private JFrame frame;
	private JTable table;
	private JProgressBar progressBar;
	MainPage mp;
	Gamer currentUser;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public LibraryPage(MainPage mp, Gamer current) {
		this.mp = mp;
		currentUser = current;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Video Distribution Platform - Store");
		frame.setTitle("Video Distribution Platform - Library");
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 650, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("Click to select.");
		scrollPane.setBounds(10, 92, 614, 226);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setToolTipText("Click to select.");
		table.setBackground(Color.DARK_GRAY);
		table.setFont(new Font("Impact", Font.PLAIN, 13));
		table.setForeground(Color.WHITE);
		scrollPane.setColumnHeaderView(table);
		DefaultTableModel model = new DefaultTableModel();
		Object [] column = {"Name", "Year", "Developer", "Genre"};
		model.setColumnIdentifiers(column);
		table.setModel(model);
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(200);
		scrollPane.setViewportView(table);
		table.setRowHeight(30);

		for(int i = 0; i < currentUser.getGames().size(); i++) {
			Object [] row = {currentUser.getGames().get(i).getName(), currentUser.getGames().get(i).getYear(), currentUser.getGames().get(i).getDeveloper(), currentUser.getGames().get(i).getGenre()};
			model.addRow(row);
			
		}
		
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
		
		timer = new Timer(50, new ActionListener() {
			private int x = 0;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				progressBar.setValue(x++);
				if(x ==100) {
					timer.stop();
					JOptionPane.showMessageDialog(frame, "Download finished.");
					x=0;
					progressBar.setValue(0);
				}
				
			}
			
			
		});
		
		JButton btnDownload = new JButton("Download");
		btnDownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(frame, "Select a game to download!");
				}
				else {
					JOptionPane.showMessageDialog(frame, currentUser.getGames().get(table.getSelectedRow()).getName()+ ": Download started.");
					timer.start();
				}
			}
		});
		btnDownload.setBounds(508, 58, 116, 23);
		frame.getContentPane().add(btnDownload);
		
		progressBar = new JProgressBar();
		progressBar.setMaximum(100);
		progressBar.setForeground(Color.GREEN);
		progressBar.setBounds(478, 329, 146, 14);
		frame.getContentPane().add(progressBar);
		
		JLabel lblLbrary = new JLabel("LIBRARY");
		lblLbrary.setHorizontalAlignment(SwingConstants.CENTER);
		lblLbrary.setForeground(Color.WHITE);
		lblLbrary.setFont(new Font("Elephant", Font.PLAIN, 40));
		lblLbrary.setBounds(10, 11, 614, 70);
		frame.getContentPane().add(lblLbrary);
		
		JLabel lblDownloadProcess = new JLabel("Download Process:");
		lblDownloadProcess.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDownloadProcess.setForeground(Color.WHITE);
		lblDownloadProcess.setFont(new Font("Century Schoolbook", Font.PLAIN, 13));
		lblDownloadProcess.setBounds(322, 329, 146, 14);
		frame.getContentPane().add(lblDownloadProcess);
		
	}

	public JFrame getFrame() {
		return frame;
	}
}
