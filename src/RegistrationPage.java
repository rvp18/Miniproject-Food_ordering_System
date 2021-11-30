import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RegistrationPage extends JFrame {

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
					RegistrationPage frame = new RegistrationPage();
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
	public RegistrationPage() {
		con = db.dbconnect();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 20, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("REGISTER:");
		lblNewLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
		lblNewLabel.setBounds(275, 65, 281, 63);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("E-mail:");
		lblNewLabel_1.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		lblNewLabel_1.setBounds(341, 262, 151, 36);
		panel.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setFont(new Font("Consolas", Font.BOLD, 20));
		textField.setBounds(341, 201, 579, 36);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Name:");
		lblNewLabel_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(341, 167, 151, 36);
		panel.add(lblNewLabel_1_1);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Consolas", Font.BOLD, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(341, 296, 579, 36);
		panel.add(textField_1);

		JLabel lblNewLabel_1_2 = new JLabel("Phone No.");
		lblNewLabel_1_2.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		lblNewLabel_1_2.setBounds(341, 356, 151, 36);
		panel.add(lblNewLabel_1_2);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Consolas", Font.BOLD, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(341, 390, 579, 36);
		panel.add(textField_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("Password:");
		lblNewLabel_1_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		lblNewLabel_1_2_1.setBounds(341, 452, 151, 36);
		panel.add(lblNewLabel_1_2_1);

		JButton btnNewButton = new JButton("REGISTER");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String Name = textField.getText();
				String Email = textField_1.getText();
				String phone_number = textField_2.getText();
				@SuppressWarnings("deprecation")
				String password = passwordField.getText();

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into user(Name,Email,PhoneNo,Password) values(?,?,?,?)");
					pst.setString(1, Name);
					pst.setString(2, Email);
					pst.setString(3, phone_number);
					pst.setString(4, password);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Signed up Successfully");
					
					apsit.main(null);
					
					
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Something Went Wrong", "Registration",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(560, 599, 135, 50);
		panel.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(RegistrationPage.class.getResource("/Images/APSITO-White.jpeg")));
		lblNewLabel_2.setBounds(934, -239, 579, 424);
		panel.add(lblNewLabel_2);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Consolas", Font.BOLD, 20));
		passwordField.setBounds(341, 490, 579, 36);
		panel.add(passwordField);
	}
}
