package Pages;
import Entities.*;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class StorePage {

	private JFrame frame;
	
	private MainPage mp;
	private JTable table;
	private boolean ascending = true;
	private int cartsize = 0;
	JButton cartButton;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public StorePage(MainPage mp) {
		initialize();
		this.mp = mp;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Video Distribution Platform - Store");
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 650, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("Click to select.");
		scrollPane.setBounds(10, 153, 614, 197);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setToolTipText("Click to select.");
		table.setBackground(Color.DARK_GRAY);
		table.setFont(new Font("Impact", Font.PLAIN, 13));
		table.setForeground(Color.WHITE);
		scrollPane.setColumnHeaderView(table);
		DefaultTableModel model = new DefaultTableModel();
		Object [] column = {"Name", "Year", "Developer", "Genre", "Price"};
		model.setColumnIdentifiers(column);
		table.setModel(model);
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(200);
		scrollPane.setViewportView(table);
		table.setRowHeight(30);

		for(int i = 0; i < List.games.size(); i++) {
			Object [] row = {List.games.get(i).getName(), List.games.get(i).getYear(), List.games.get(i).getDeveloper(), List.games.get(i).getGenre(), "$" + List.games.get(i).getPrice()};
			model.addRow(row);
			
		}
		
		JComboBox sortBox = new JComboBox(column);
		sortBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(sortBox.getSelectedItem().equals("Name")) {
					if(ascending) {
						List.games.sort(new Comparator<Game>() {
							public int compare(Game g1, Game g2) {
								return g1.getName().compareToIgnoreCase(g2.getName());
							}
						});;
						for(int i = 0; i < List.games.size(); i++) {
							model.removeRow(0);
						}
						for(int i = 0; i < List.games.size(); i++) {
							Object [] row = {List.games.get(i).getName(), List.games.get(i).getYear(), List.games.get(i).getDeveloper(), List.games.get(i).getGenre(), "$" + List.games.get(i).getPrice()};
							model.addRow(row);
						}
					}
					else {
						List.games.sort(new Comparator<Game>() {
							public int compare(Game g1, Game g2) {
								return g2.getName().compareToIgnoreCase(g1.getName());
							}
						});;
						for(int i = 0; i < List.games.size(); i++) {
							model.removeRow(0);
						}
						for(int i = 0; i < List.games.size(); i++) {
							Object [] row = {List.games.get(i).getName(), List.games.get(i).getYear(), List.games.get(i).getDeveloper(), List.games.get(i).getGenre(), "$" + List.games.get(i).getPrice()};
							model.addRow(row);
						}
					}
				}
				else if(sortBox.getSelectedItem().equals("Year")) {
					if(ascending) {
						List.games.sort(new Comparator<Game>() {
							public int compare(Game g1, Game g2) {
								return Integer.valueOf(g1.getYear()).compareTo(Integer.valueOf(g2.getYear()));
							}
						});;
						for(int i = 0; i < List.games.size(); i++) {
							model.removeRow(0);
						}
						for(int i = 0; i < List.games.size(); i++) {
							Object [] row = {List.games.get(i).getName(), List.games.get(i).getYear(), List.games.get(i).getDeveloper(), List.games.get(i).getGenre(), "$" + List.games.get(i).getPrice()};
							model.addRow(row);
						}
					}
					else {
						List.games.sort(new Comparator<Game>() {
							public int compare(Game g1, Game g2) {
								return Integer.valueOf(g2.getYear()).compareTo(Integer.valueOf(g1.getYear()));
							}
						});;
						for(int i = 0; i < List.games.size(); i++) {
							model.removeRow(0);
						}
						for(int i = 0; i < List.games.size(); i++) {
							Object [] row = {List.games.get(i).getName(), List.games.get(i).getYear(), List.games.get(i).getDeveloper(), List.games.get(i).getGenre(), "$" + List.games.get(i).getPrice()};
							model.addRow(row);
						}
					}
				}
				else if(sortBox.getSelectedItem().equals("Developer")) {
					if(ascending) {
						List.games.sort(new Comparator<Game>() {
							public int compare(Game g1, Game g2) {
								return g1.getDeveloper().getName().compareTo(g2.getDeveloper().getName());
							}
						});;
						for(int i = 0; i < List.games.size(); i++) {
							model.removeRow(0);
						}
						for(int i = 0; i < List.games.size(); i++) {
							Object [] row = {List.games.get(i).getName(), List.games.get(i).getYear(), List.games.get(i).getDeveloper(), List.games.get(i).getGenre(), "$" + List.games.get(i).getPrice()};
							model.addRow(row);
						}
					}
					else {
						List.games.sort(new Comparator<Game>() {
							public int compare(Game g1, Game g2) {
								return g2.getDeveloper().getName().compareTo(g1.getDeveloper().getName());
							}
						});;
						for(int i = 0; i < List.games.size(); i++) {
							model.removeRow(0);
						}
						for(int i = 0; i < List.games.size(); i++) {
							Object [] row = {List.games.get(i).getName(), List.games.get(i).getYear(), List.games.get(i).getDeveloper(), List.games.get(i).getGenre(), "$" + List.games.get(i).getPrice()};
							model.addRow(row);
						}
					}
				}
				else if(sortBox.getSelectedItem().equals("Genre")) {
					if(ascending) {
						List.games.sort(new Comparator<Game>() {
							public int compare(Game g1, Game g2) {
								return g1.getGenre().compareTo(g2.getGenre());
							}
						});;
						for(int i = 0; i < List.games.size(); i++) {
							model.removeRow(0);
						}
						for(int i = 0; i < List.games.size(); i++) {
							Object [] row = {List.games.get(i).getName(), List.games.get(i).getYear(), List.games.get(i).getDeveloper(), List.games.get(i).getGenre(), "$" + List.games.get(i).getPrice()};
							model.addRow(row);
						}
					}
					else {
						List.games.sort(new Comparator<Game>() {
							public int compare(Game g1, Game g2) {
								return g2.getGenre().compareTo(g1.getGenre());
							}
						});;
						for(int i = 0; i < List.games.size(); i++) {
							model.removeRow(0);
						}
						for(int i = 0; i < List.games.size(); i++) {
							Object [] row = {List.games.get(i).getName(), List.games.get(i).getYear(), List.games.get(i).getDeveloper(), List.games.get(i).getGenre(), "$" + List.games.get(i).getPrice()};
							model.addRow(row);
						}
					}
				}
				else if(sortBox.getSelectedItem().equals("Price")) {
					if(ascending) {
						List.games.sort(new Comparator<Game>() {
							public int compare(Game g1, Game g2) {
								return Double.valueOf(g1.getPrice()).compareTo(Double.valueOf(g2.getPrice()));
							}
						});;
						for(int i = 0; i < List.games.size(); i++) {
							model.removeRow(0);
						}
						for(int i = 0; i < List.games.size(); i++) {
							Object [] row = {List.games.get(i).getName(), List.games.get(i).getYear(), List.games.get(i).getDeveloper(), List.games.get(i).getGenre(), "$" + List.games.get(i).getPrice()};
							model.addRow(row);
						}
					}
					else {
						List.games.sort(new Comparator<Game>() {
							public int compare(Game g1, Game g2) {
								return Double.valueOf(g2.getPrice()).compareTo(Double.valueOf(g1.getPrice()));
							}
						});;
						for(int i = 0; i < List.games.size(); i++) {
							model.removeRow(0);
						}
						for(int i = 0; i < List.games.size(); i++) {
							Object [] row = {List.games.get(i).getName(), List.games.get(i).getYear(), List.games.get(i).getDeveloper(), List.games.get(i).getGenre(), "$" + List.games.get(i).getPrice()};
							model.addRow(row);
						}
					}
				}
				
				
				
			}
		});
		sortBox.setBounds(70, 122, 121, 20);
		frame.getContentPane().add(sortBox);
		
		JLabel lblSortBy = new JLabel("Sort by");
		lblSortBy.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSortBy.setForeground(Color.WHITE);
		lblSortBy.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
		lblSortBy.setBounds(10, 122, 50, 20);
		frame.getContentPane().add(lblSortBy);
		
		JLabel lblOrder = new JLabel("Order");
		lblOrder.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrder.setForeground(Color.WHITE);
		lblOrder.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
		lblOrder.setBounds(225, 122, 50, 20);
		frame.getContentPane().add(lblOrder);
		
		JComboBox orderBox = new JComboBox(new Object[]{"Ascending", "Descending"});
		orderBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(orderBox.getSelectedItem().equals("Ascending")) {
					ascending = true;
				}
				else {
					ascending = false;
				}
			}
		});
		orderBox.setBounds(285, 122, 121, 20);
		frame.getContentPane().add(orderBox);
		
		JButton addCartButton = new JButton("Add to Cart");
		addCartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean owned = false;
				boolean oncart = false;
				
				if(table.getSelectedRow() != -1) {
					for(int i = 0; i < mp.getCurrentUser().getGames().size(); i++) {
						if(List.games.get(table.getSelectedRow()).getName().equals(mp.getCurrentUser().getGames().get(i).getName())) {
							owned = true;
							break;
						}
					}
					for(int i = 0; i < mp.getCartSize(); i++) {
						if(List.games.get(table.getSelectedRow()).getName().equals(mp.getCart().get(i).getName())) {
							oncart = true;
							break;
						}
					}
				}
				
				if(table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(frame, "Select a game to add to cart!");
				}
				else if(owned) {
					JOptionPane.showMessageDialog(frame, "You have already owned this game!");
				}
				else if(oncart) {
					JOptionPane.showMessageDialog(frame, "The game has already added to the cart!");
				}
				else {
					JOptionPane.showMessageDialog(frame, "Game has successfully added to the cart!");
					mp.getCart().add(List.games.get(table.getSelectedRow()));
					cartsize++;
					mp.cartsize++;
					cartButton.setText("Cart (" + cartsize + ")");
				}
				
				
			}
		});
		addCartButton.setBounds(476, 119, 121, 23);
		frame.getContentPane().add(addCartButton);
		
		cartButton = new JButton("Cart (0)");
		cartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CartPage cp = new CartPage(mp);
				cp.setBalance(mp.getCurrentUser().getBalance());
				cp.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		cartButton.setForeground(Color.BLACK);
		cartButton.setBackground(Color.WHITE);
		cartButton.setBounds(517, 22, 95, 32);
		frame.getContentPane().add(cartButton);
		
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
		
		
		JLabel lblStore = new JLabel("STORE");
		lblStore.setHorizontalAlignment(SwingConstants.CENTER);
		lblStore.setForeground(Color.WHITE);
		lblStore.setFont(new Font("Elephant", Font.PLAIN, 40));
		lblStore.setBounds(10, 11, 614, 70);
		frame.getContentPane().add(lblStore);
		
		
		
		
		
		
		
	}
	

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public MainPage getMp() {
		return mp;
	}

	public void setMp(MainPage mp) {
		this.mp = mp;
	}
	
	public void setCartTitle() {
		cartButton.setText("Cart (" + cartsize +")");
	}
	
	public void setCartSize(int cs) {
		cartsize = cs;
	}
}
