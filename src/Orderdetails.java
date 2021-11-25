import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

public class Orderdetails extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;

	String email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

//		System.out.println(args[0]);
//		Maharashtrian m = new Maharashtrian();
//		List<String> list = m.getSelectedItems();
//		
//		System.out.println("List by object : " + list);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Orderdetails frame = new Orderdetails("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con = null;

	/**
	 * Create the frame.
	 */
	public Orderdetails(String emailId) {

		con = db.dbconnect();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 20, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		this.email = emailId;

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

		JRadioButton COD = new JRadioButton("COD");
		buttonGroup.add(COD);
		COD.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		COD.setBounds(39, 407, 141, 68);
		panel_1.add(COD);

		JRadioButton PayByCard = new JRadioButton("Pay by Card");
		buttonGroup.add(PayByCard);
		PayByCard.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		PayByCard.setBounds(39, 469, 219, 60);
		panel_1.add(PayByCard);

		JButton btnNewButton_1_1 = new JButton("Order");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (COD.isSelected() == true) {
					Invoice.main(null);
					dispose();
				} else if (PayByCard.isSelected()) {
					CardDetails2.main(null);
					dispose();
				}

				else {
					JOptionPane.showMessageDialog(null, "Please Select Payment Option");
				}

			}
		});
		btnNewButton_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		btnNewButton_1_1.setBackground(new Color(0, 204, 0));
		btnNewButton_1_1.setBounds(63, 554, 180, 68);
		panel_1.add(btnNewButton_1_1);

		JLabel lblNewLabel_3 = new JLabel("Order Details:");
		lblNewLabel_3.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		lblNewLabel_3.setBounds(24, 28, 260, 49);
		panel.add(lblNewLabel_3);

		JButton btnBack_1 = new JButton("");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack_1.setIcon(new ImageIcon(Orderdetails.class.getResource("/Images/back 3.png")));
		btnBack_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnBack_1.setBackground(Color.WHITE);
		btnBack_1.setBounds(24, 651, 101, 80);
		panel.add(btnBack_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 120, 603, 460);
		panel.add(scrollPane);
//		
		table = new JTable();

		try {
			String query = "SELECT Name,Price FROM tempaddeditems WHERE Email=? ";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, email);

			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
//		DefaultTableModel dtm;
////		dtm=setModel
//		table.setModel(dtm);

		scrollPane.setViewportView(table);

		JLabel totaltext = new JLabel("Total");
		totaltext.setFont(new Font("Maiandra GD", Font.BOLD, 30));
		totaltext.setBounds(24, 581, 455, 49);
		panel.add(totaltext);
		
		
		ResultSet rs;
		String total = "";
//		try {
//			String query = "SELECT SUM(Price) AS 'Total' FROM tempaddeditems WHERE Email=? ";
//			PreparedStatement pst = con.prepareStatement(query);
//			pst.setString(1, email);
//
//			 rs = pst.executeQuery();
//			
//			
//			total=rs.getString(123);
//
//		} catch (SQLException e1) {
//
//			e1.printStackTrace();
//		}

		JLabel totalPrice = new JLabel(total);
		totalPrice.setBounds(496, 580, 130, 39);
		panel.add(totalPrice);
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
