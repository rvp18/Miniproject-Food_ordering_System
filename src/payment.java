import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;

public class payment extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					payment frame = new payment();
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
	public payment() {
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setIcon(new ImageIcon(payment.class.getResource("/Images/cc.jpeg")));
		lblNewLabel.setBounds(43, -11, 400, 340);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(475, 213, 740, 427);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Card Number");
		lblNewLabel_1.setFont(new Font("Maiandra GD", Font.BOLD, 28));
		lblNewLabel_1.setBounds(61, 10, 268, 53);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Consolas", Font.BOLD, 20));
		textField.setBounds(61, 190, 221, 44);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Expiry Date");
		lblNewLabel_2.setFont(new Font("Maiandra GD", Font.BOLD, 28));
		lblNewLabel_2.setBounds(61, 150, 212, 44);
		panel_1.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(60, 61, 580, 44);
		panel_1.add(passwordField);
		
		JButton btnNewButton = new JButton("Confirm & Pay");
		btnNewButton.setBackground(new Color(0, 153, 0));
		btnNewButton.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnNewButton.setBounds(294, 292, 201, 58);
		panel_1.add(btnNewButton);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(386, 190, 108, 44);
		panel_1.add(passwordField_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("CVV");
		lblNewLabel_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 28));
		lblNewLabel_2_1.setBounds(380, 150, 212, 44);
		panel_1.add(lblNewLabel_2_1);
	}
}
