import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cardDetails1 extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cardDetails1 frame = new cardDetails1();
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
	public cardDetails1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Card Number");
		lblNewLabel_1.setFont(new Font("Maiandra GD", Font.BOLD, 28));
		lblNewLabel_1.setBounds(425, 293, 268, 53);
		panel.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(425, 333, 580, 44);
		panel.add(passwordField);
		
		textField = new JTextField();
		textField.setFont(new Font("Consolas", Font.BOLD, 20));
		textField.setColumns(10);
		textField.setBounds(425, 438, 221, 44);
		panel.add(textField);
		
		JLabel lblNewLabel_2 = new JLabel("Expiry Date");
		lblNewLabel_2.setFont(new Font("Maiandra GD", Font.BOLD, 28));
		lblNewLabel_2.setBounds(425, 397, 212, 44);
		panel.add(lblNewLabel_2);
		
		JButton btnSave = new JButton("Add Your Card");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		String Name=textField_1.getName();
        		String card_number =passwordField.getText();
        		String Expirydate=textField.getText();
        		
//        		if () {
//					
//					JOptionPane.showMessageDialog(null, "ADD valid Details","Details",JOptionPane.ERROR_MESSAGE);
//					textField_1.setText(null);
//					passwordField.setText(null);
//					textField.setText(null);
//					
//        			
//        			}
//        		else {
        			JOptionPane.showMessageDialog(null, "Succesfully Added Card Details","Payment Details",JOptionPane.OK_OPTION);
        		
        		apsit.main(null);
        		
        		
			}
		});
		btnSave.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnSave.setBackground(new Color(255, 204, 102));
		btnSave.setBounds(462, 527, 201, 60);
		panel.add(btnSave);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name:");
		lblNewLabel_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 28));
		lblNewLabel_1_1.setBounds(425, 178, 268, 53);
		panel.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Consolas", Font.BOLD, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(425, 226, 580, 44);
		panel.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(cardDetails1.class.getResource("/Images/card-security.png")));
		lblNewLabel.setBounds(638, 10, 174, 182);
		panel.add(lblNewLabel);
		
		JButton btnSkip = new JButton("Skip");
		btnSkip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				apsit.main(null);
			}
		});
		btnSkip.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnSkip.setBackground(new Color(255, 204, 102));
		btnSkip.setBounds(771, 527, 201, 60);
		panel.add(btnSkip);
	}
}
