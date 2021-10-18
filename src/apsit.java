import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Button;

public class apsit {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					apsit window = new apsit();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public apsit() {
		initialize();
		}
		
		

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setForeground(Color.CYAN);
		frame.setBounds(100, 100, 1500, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.BLACK);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Log IN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String password= passwordField.getText();
				String username = textField.getText();
				
				if (password.contains("APSITO") && username.contains("apsito@gmail.com")) {
					
					passwordField.setText(null);
					textField.setText(null);
					
					
					
					Home homepage=new Home();
					homepage.setVisible(true);
					
					
					
				}else {
					JOptionPane.showMessageDialog(null, "Invaild Login Details","Login Error",JOptionPane.ERROR_MESSAGE);
					passwordField.setText(null);
					textField.setText(null);
				}
			}
		});
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Maiandra GD", Font.BOLD, 18));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(719, 486, 169, 61);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		lblNewLabel.setBounds(542, 243, 249, 49);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		lblPassword.setBounds(542, 360, 249, 49);
		panel.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(542, 301, 524, 49);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(apsit.class.getResource("/Images/external-cutlery-self-protection-linector-lineal-color-linector.png")));
		lblNewLabel_1.setBounds(370, 79, 263, 180);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NEW TO APSITO?");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(719, 583, 189, 34);
		panel.add(lblNewLabel_2);
		
		JButton btnSignUp = new JButton("REGISTER");
		btnSignUp.setBackground(Color.ORANGE);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrationPage.main(null);
			}
		});
		btnSignUp.setForeground(Color.BLACK);
		btnSignUp.setFont(new Font("Maiandra GD", Font.BOLD, 10));
		btnSignUp.setBounds(729, 626, 130, 34);
		panel.add(btnSignUp);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(542, 404, 524, 49);
		panel.add(passwordField);
		
		Button button = new Button("Login");
		button.setBounds(569, 486, 109, 42);
		panel.add(button);
	}
}
