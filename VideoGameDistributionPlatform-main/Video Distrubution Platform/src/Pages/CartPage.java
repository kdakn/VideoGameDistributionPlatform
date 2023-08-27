package Pages;

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

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class CartPage {

	private JFrame frame;
	private JTable table;
	private JLabel lblCart;
	private JLabel lblBalance;
	double totalPrice = 0;
	
	MainPage mp;
	private JLabel lblCurrentBalance;
	private JButton btnPurchase;
	private JLabel lblTotal;

	/**
	 * Create the application.
	 */
	public CartPage(MainPage mp) {
		this.mp = mp;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Video Distribution Platform - Cart");
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 650, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("Click to select.");
		scrollPane.setBounds(0, 122, 634, 196);
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

		for(int i = 0; i < mp.getCart().size(); i++) {
			Object [] row = {mp.getCart().get(i).getName(), mp.getCart().get(i).getYear(), mp.getCart().get(i).getDeveloper(), mp.getCart().get(i).getGenre(), "$" + mp.getCart().get(i).getPrice()};
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
		
		lblCart = new JLabel("CART");
		lblCart.setHorizontalAlignment(SwingConstants.CENTER);
		lblCart.setForeground(Color.WHITE);
		lblCart.setFont(new Font("Elephant", Font.PLAIN, 40));
		lblCart.setBounds(10, 11, 614, 70);
		frame.getContentPane().add(lblCart);
		
		lblCurrentBalance = new JLabel("Current Balance: ");
		lblCurrentBalance.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurrentBalance.setForeground(Color.WHITE);
		lblCurrentBalance.setFont(new Font("Elephant", Font.PLAIN, 25));
		lblCurrentBalance.setBounds(20, 72, 229, 50);
		frame.getContentPane().add(lblCurrentBalance);
		
		lblBalance = new JLabel("");
		lblBalance.setHorizontalAlignment(SwingConstants.LEFT);
		lblBalance.setForeground(Color.WHITE);
		lblBalance.setFont(new Font("Elephant", Font.PLAIN, 25));
		lblBalance.setBounds(270, 78, 229, 50);
		frame.getContentPane().add(lblBalance);
		
		for(int i = 0; i < mp.getCart().size(); i++) {
			totalPrice += mp.getCart().get(i).getPrice();
		}
		
		btnPurchase = new JButton("Purchase");
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mp.getCart().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Cart is empty!");
				}
				else if(mp.getCurrentUser().getBalance() >= totalPrice) {
					int response = JOptionPane.showConfirmDialog(frame, "Are you sure about the purchase?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(response == JOptionPane.YES_OPTION) {
						for(int i = 0; i < mp.getCart().size(); i++) {
							totalPrice += mp.getCart().get(i).getPrice();
						}
						
						int size = mp.getCart().size();
						for(int i = 0; i < size; i++) {
							mp.getCurrentUser().getGames().add(mp.getCart().get(0));
							mp.getCart().remove(0);
							model.removeRow(0);
						}
						for(int i = 0; i < mp.getCart().size(); i++) {
							Object [] row = {mp.getCart().get(i).getName(), mp.getCart().get(i).getYear(), mp.getCart().get(i).getDeveloper(), mp.getCart().get(i).getGenre(), "$" + mp.getCart().get(i).getPrice()};
							model.addRow(row);
						}
						mp.getCurrentUser().setBalance(mp.getCurrentUser().getBalance() - totalPrice/2);
						setBalance(mp.getCurrentUser().getBalance());
						mp.cartsize = 0;
						JOptionPane.showMessageDialog(frame, "Games are added to user's library!");
					}
				}
				else {
					JOptionPane.showMessageDialog(frame, "Balance is not enough!");
				}
			}
		});
		btnPurchase.setBounds(492, 88, 100, 23);
		frame.getContentPane().add(btnPurchase);
		
		lblTotal = new JLabel("Total:    $" + totalPrice);
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setFont(new Font("Elephant", Font.PLAIN, 20));
		lblTotal.setBounds(342, 329, 282, 21);
		frame.getContentPane().add(lblTotal);
		
	}
	

	public JFrame getFrame() {
		return frame;
	}
	
	public void setBalance(double b) {
		lblBalance.setText("$" + b);
	}
	
	

}
