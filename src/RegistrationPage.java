import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class RegistrationPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

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

	/**
	 * Create the frame.
	 */
	public RegistrationPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
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
		textField.setBounds(341, 201, 579, 36);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name:");
		lblNewLabel_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(341, 167, 151, 36);
		panel.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(341, 296, 579, 36);
		panel.add(textField_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Phone No.");
		lblNewLabel_1_2.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		lblNewLabel_1_2.setBounds(341, 356, 151, 36);
		panel.add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(341, 390, 579, 36);
		panel.add(textField_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Password:");
		lblNewLabel_1_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		lblNewLabel_1_2_1.setBounds(341, 452, 151, 36);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Confirm Password:");
		lblNewLabel_1_2_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		lblNewLabel_1_2_1_1.setBounds(341, 552, 313, 36);
		panel.add(lblNewLabel_1_2_1_1);
		
		JButton btnNewButton = new JButton("REGISTER");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String Name= textField.getText();
				String Email= textField_1.getText();
				String phone_number=textField_2.getText();
				String password= passwordField.getText();
				String confirmpassword= passwordField_1.getText();
				
				cardDetails1.main(null);
			}
		});
		btnNewButton.setBounds(560, 673, 135, 50);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(RegistrationPage.class.getResource("/Images/external-cutlery-self-protection-linector-lineal-color-linector.png")));
		lblNewLabel_2.setBounds(1145, 48, 135, 141);
		panel.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(341, 490, 579, 36);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(341, 596, 579, 36);
		panel.add(passwordField_1);
	}
}
