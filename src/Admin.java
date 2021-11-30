import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

public class Admin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con = null;
	private JTable table;
	private JTable table_1;

	/**
	 * Create the frame.
	 */
	public Admin() {

		con = db.dbconnect();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 20, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setForeground(Color.MAGENTA);
		panel_1.setBounds(10, 10, 584, 743);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Name:");
		lblNewLabel_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(54, 94, 477, 36);
		panel_1.add(lblNewLabel_1_1);

		textField = new JTextField();
		textField.setFont(new Font("Consolas", Font.BOLD, 20));
		textField.setColumns(10);
		textField.setBounds(54, 128, 477, 36);
		panel_1.add(textField);

		JLabel lblNewLabel_1 = new JLabel("E-mail:");
		lblNewLabel_1.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		lblNewLabel_1.setBounds(54, 189, 477, 36);
		panel_1.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Consolas", Font.BOLD, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(54, 223, 477, 36);
		panel_1.add(textField_1);

		JLabel lblNewLabel_1_2 = new JLabel("Phone No.");
		lblNewLabel_1_2.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		lblNewLabel_1_2.setBounds(54, 283, 477, 36);
		panel_1.add(lblNewLabel_1_2);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Consolas", Font.BOLD, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(54, 317, 477, 36);
		panel_1.add(textField_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("Password:");
		lblNewLabel_1_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		lblNewLabel_1_2_1.setBounds(54, 379, 477, 36);
		panel_1.add(lblNewLabel_1_2_1);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Consolas", Font.BOLD, 20));
		passwordField.setBounds(54, 417, 477, 36);
		panel_1.add(passwordField);

		JButton btnAddNewAdmin = new JButton("ADD NEW ADMIN");
		btnAddNewAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String Name = textField.getText();
				String Email = textField_1.getText();
				String phone_number = textField_2.getText();
				@SuppressWarnings("deprecation")
				String password = passwordField.getText();

				try {
					PreparedStatement pst = (PreparedStatement) con
							.prepareStatement("insert into user(Name,Email,PhoneNo,Password) values(?,?,?,?)");
					pst.setString(1, Name);
					pst.setString(2, Email);
					pst.setString(3, phone_number);
					pst.setString(4, password);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "New Admin Added Successfully");

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Something Went Wrong", "Registration",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnAddNewAdmin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddNewAdmin.setBackground(Color.ORANGE);
		btnAddNewAdmin.setBounds(183, 531, 211, 50);
		panel_1.add(btnAddNewAdmin);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setForeground(Color.GREEN);
		panel_2.setBounds(599, 10, 867, 379);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 54, 847, 315);
		panel_2.add(scrollPane_1);

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		try {
			String query = "SELECT * FROM customeraddress ORDER BY Order_Id DESC ";
			PreparedStatement pst = con.prepareStatement(query);

			ResultSet rs = pst.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		JLabel lblNewLabel_1_2_2 = new JLabel("Orders Placed:");
		lblNewLabel_1_2_2.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		lblNewLabel_1_2_2.setBounds(10, 10, 477, 36);
		panel_2.add(lblNewLabel_1_2_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setForeground(Color.CYAN);
		panel_3.setBounds(599, 387, 867, 356);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 847, 298);
		panel_3.add(scrollPane);

		JLabel lblNewLabel_1_2_2_1 = new JLabel("Reviews:");
		lblNewLabel_1_2_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		lblNewLabel_1_2_2_1.setBounds(10, 10, 477, 36);
		panel_3.add(lblNewLabel_1_2_2_1);

		table = new JTable();
		scrollPane.setViewportView(table);
		try {
			String query = "SELECT Email,Rating,Time FROM customerreview ORDER BY ReviewNumber DESC";
			PreparedStatement pst = con.prepareStatement(query);

			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
	}
}
