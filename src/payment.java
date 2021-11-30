import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class payment extends JFrame {

	/**
	 * 
	 */

	String email;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField CardNumber;
	private JPasswordField CVV1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					payment frame = new payment("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con = null;
	private JTextField Expiry_Month;
	private JTextField ExpiryYear;

	/**
	 * Create the frame.
	 */
	public payment(String emailID) {

		con = db.dbconnect();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 20, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		this.email = emailID;
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
		panel_1.setBounds(466, 253, 740, 427);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Card Number");
		lblNewLabel_1.setFont(new Font("Maiandra GD", Font.BOLD, 28));
		lblNewLabel_1.setBounds(61, 10, 268, 53);
		panel_1.add(lblNewLabel_1);

		CardNumber = new JPasswordField();
		CardNumber.setFont(new Font("Consolas", Font.BOLD, 20));
		CardNumber.setBounds(60, 61, 580, 44);
		panel_1.add(CardNumber);

		CVV1 = new JPasswordField();
		CVV1.setFont(new Font("Consolas", Font.BOLD, 20));
		CVV1.setBounds(484, 190, 108, 44);
		panel_1.add(CVV1);

		JLabel lblNewLabel_2_1 = new JLabel("CVV");
		lblNewLabel_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 28));
		lblNewLabel_2_1.setBounds(479, 150, 212, 44);
		panel_1.add(lblNewLabel_2_1);

		JButton btnNewButton = new JButton("Confirm & Pay");
		btnNewButton.setBackground(new Color(0, 153, 0));
		btnNewButton.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnNewButton.setBounds(294, 292, 201, 58);
		panel_1.add(btnNewButton);

		Expiry_Month = new JTextField();
		Expiry_Month.setFont(new Font("Consolas", Font.BOLD, 20));
		Expiry_Month.setBounds(61, 190, 162, 44);
		panel_1.add(Expiry_Month);
		Expiry_Month.setColumns(10);

		JLabel ExpiryDateText = new JLabel("Expiry Date (MM/YY)");
		ExpiryDateText.setFont(new Font("Maiandra GD", Font.BOLD, 28));
		ExpiryDateText.setBounds(61, 155, 295, 34);
		panel_1.add(ExpiryDateText);

		ExpiryYear = new JTextField();
		ExpiryYear.setFont(new Font("Consolas", Font.BOLD, 20));
		ExpiryYear.setColumns(10);
		ExpiryYear.setBounds(233, 190, 122, 44);
		panel_1.add(ExpiryYear);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					@SuppressWarnings("deprecation")
					String CardNumber1 = CardNumber.getText();
					String ExpiryMonth = Expiry_Month.getText();
					String Expiryyear = ExpiryYear.getText();
					@SuppressWarnings("deprecation")
					String CVV = CVV1.getText();
					PreparedStatement pst = (PreparedStatement) con.prepareStatement(
							"select * from carddetails WHERE Email=? and CardNumber=? and ExpiryMonth=? and  ExpiryYear=? and  CVV=?");
					pst.setString(1, email);
					pst.setString(2, CardNumber1);
					pst.setString(3, ExpiryMonth);
					pst.setString(4, Expiryyear);
					pst.setString(5, CVV);
					ResultSet r = pst.executeQuery();

					if (r.next()) {
						JOptionPane.showMessageDialog(null, "Payment Done");
						Invoice ip = new Invoice(email);
						ip.setVisible(true);
						dispose();

					} else {

						try {
							PreparedStatement pst2 = (PreparedStatement) con
									.prepareStatement("select Email from carddetails WHERE Email=?");
							pst2.setString(1, email);
							ResultSet r2 = pst2.executeQuery();

							if (r2.next()) {

								JOptionPane.showMessageDialog(null, "Wrong Card Details");

								CardNumber.setText(null);
								Expiry_Month.setText(null);
								ExpiryYear.setText(null);
								CVV1.setText(null);
							} else {
								JOptionPane.showMessageDialog(null, "Card Not Found,Please Add Card First");
								CardDetails2 cdp = new CardDetails2(email);
								cdp.setVisible(true);
								dispose();
							}

						} catch (Exception e2) {

							e2.printStackTrace();
						}

					}
//				    

				} catch (Exception e1) {
					e1.printStackTrace();

				}

			}
		});
	}
}