import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

public class CardDetails2 extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardDetails2 frame = new CardDetails2();
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
	public CardDetails2() {
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
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 1476, 753);
		panel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Card Number");
		lblNewLabel_1.setFont(new Font("Maiandra GD", Font.BOLD, 28));
		lblNewLabel_1.setBounds(425, 293, 268, 53);
		panel_1.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(425, 333, 580, 44);
		panel_1.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("Expiry Date");
		lblNewLabel_2.setFont(new Font("Maiandra GD", Font.BOLD, 28));
		lblNewLabel_2.setBounds(425, 397, 212, 44);
		panel_1.add(lblNewLabel_2);
		
		JButton btnSave = new JButton("Add Your Card");
		btnSave.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnSave.setBackground(new Color(255, 204, 102));
		btnSave.setBounds(611, 524, 201, 60);
		panel_1.add(btnSave);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name:");
		lblNewLabel_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 28));
		lblNewLabel_1_1.setBounds(425, 178, 268, 53);
		panel_1.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Consolas", Font.BOLD, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(425, 226, 580, 44);
		panel_1.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CardDetails2.class.getResource("/Images/card-security.png")));
		lblNewLabel.setBounds(638, 10, 174, 182);
		panel_1.add(lblNewLabel);
		
		JButton btnBack_1 = new JButton("");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orderdetails.main(null);
			}
		});
		btnBack_1.setIcon(new ImageIcon(CardDetails2.class.getResource("/Images/back 3.png")));
		btnBack_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnBack_1.setBackground(Color.WHITE);
		btnBack_1.setBounds(59, 598, 101, 80);
		panel_1.add(btnBack_1);
		
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.getComboBox().setFont(new Font("Maiandra GD", Font.BOLD, 15));
		monthChooser.setBounds(425, 451, 119, 36);
		panel_1.add(monthChooser);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(554, 451, 64, 36);
		panel_1.add(yearChooser);
	}
}
