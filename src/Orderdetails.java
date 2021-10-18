import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class Orderdetails extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Orderdetails frame = new Orderdetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Orderdetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		panel_1.setBounds(701, 23, 765, 720);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer details:");
		lblNewLabel.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel.setFont(new Font("Maiandra GD", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 10, 417, 60);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 92, 76, 37);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(10, 124, 745, 37);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Address:");
		lblNewLabel_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(10, 171, 148, 37);
		panel_1.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 202, 745, 96);
		panel_1.add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Pincode:");
		lblNewLabel_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(10, 311, 148, 37);
		panel_1.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 347, 172, 50);
		panel_1.add(textField_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Phone No.");
		lblNewLabel_1_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblNewLabel_1_1_1_1.setBounds(213, 311, 148, 37);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(216, 347, 352, 50);
		panel_1.add(textField_3);
		
		JButton btnNewButton_1 = new JButton("Apply Coupon");
		btnNewButton_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnNewButton_1.setBackground(new Color(255, 204, 51));
		btnNewButton_1.setBounds(329, 556, 187, 68);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Order");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		btnNewButton_1_1.setBackground(new Color(0, 204, 0));
		btnNewButton_1_1.setBounds(63, 554, 180, 68);
		panel_1.add(btnNewButton_1_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("COD");
		rdbtnNewRadioButton.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		rdbtnNewRadioButton.setBounds(39, 407, 141, 68);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnPayByCard = new JRadioButton("Pay by Card");
		rdbtnPayByCard.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		rdbtnPayByCard.setBounds(39, 469, 219, 60);
		panel_1.add(rdbtnPayByCard);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblNewLabel_2.setForeground(new Color(255, 255, 51));
		lblNewLabel_2.setBackground(new Color(255, 255, 153));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(Orderdetails.class.getResource("/Images/Ordertable.jpeg")));
		lblNewLabel_2.setBounds(10, 10, 656, 715);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Order Details:");
		lblNewLabel_3.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		lblNewLabel_3.setBounds(24, 28, 260, 49);
		panel.add(lblNewLabel_3);
		
		JButton btnBack_1 = new JButton("");
		btnBack_1.setIcon(new ImageIcon(Orderdetails.class.getResource("/Images/back 3.png")));
		btnBack_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnBack_1.setBackground(Color.WHITE);
		btnBack_1.setBounds(24, 651, 101, 80);
		panel.add(btnBack_1);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
