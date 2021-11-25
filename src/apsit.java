import java.awt.Color;
//import Home;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class apsit {

	private JFrame frame;
	private JTextField textemail;
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

	Connection con = null;


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	    
		con = db.dbconnect();
		

		frame = new JFrame("APSITO");
		frame.setForeground(Color.CYAN);
		frame.setBounds(10, 20, 1500, 800);
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

				ResultSet r= null;
				PreparedStatement pst=null;
				try {
					String password = String.valueOf(passwordField.getPassword());
					String email = textemail.getText();

					pst = (PreparedStatement) con
							.prepareStatement("select * from user where Email=? and Password=?");
					pst.setString(1, email);
					pst.setString(2, password);

					r = pst.executeQuery();

					if (r.next()) {

						if (email.contains("@admin")) {

							Admin.main(null);

						} else {
							Home homepage = new Home(email);
							homepage.setVisible(true);

//				    		dispose();

						}
					} else {
						JOptionPane.showMessageDialog(null, "Wrong Email or Password");
						passwordField.setText(null);
						textemail.setText(null);
					}

				} catch (Exception e1) {
					e1.printStackTrace();

				} finally {

					try {
						
						r.close();
						pst.close();
						con.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}

				}


			}
		});

		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Maiandra GD", Font.BOLD, 18));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(719, 486, 160, 54);
		panel.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		lblNewLabel.setBounds(542, 243, 249, 49);
		panel.add(lblNewLabel);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		lblPassword.setBounds(542, 360, 249, 49);
		panel.add(lblPassword);

		textemail = new JTextField();
		textemail.setBounds(542, 301, 524, 49);
		panel.add(textemail);
		textemail.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(apsit.class.getResource("/Images/APSITO-White.jpeg")));
		lblNewLabel_1.setBounds(61, -196, 579, 404);
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
		btnSignUp.setBounds(740, 627, 127, 43);
		panel.add(btnSignUp);

		passwordField = new JPasswordField();
		passwordField.setBounds(542, 404, 524, 49);
		panel.add(passwordField);

	}
}
