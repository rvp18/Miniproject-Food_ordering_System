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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class cardDetails1 extends JFrame {

	private JPanel contentPane;
	private JPasswordField CardNumber;
	private JTextField Expiry_Month;
	private JTextField ExpiryYear;

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
	Connection con = null;
	/**
	 * Create the frame.
	 */
	public cardDetails1() {
		
		con=db.dbconnect();
		
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
		
		JLabel lblNewLabel_1 = new JLabel("Card Number");
		lblNewLabel_1.setFont(new Font("Maiandra GD", Font.BOLD, 28));
		lblNewLabel_1.setBounds(404, 199, 268, 53);
		panel.add(lblNewLabel_1);
		
		CardNumber = new JPasswordField();
		CardNumber.setBounds(404, 239, 580, 44);
		panel.add(CardNumber);
		
		JButton btnSave = new JButton("Add Your Card");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String CardNumber1= CardNumber.getText();
				String ExpiryMonth= Expiry_Month.getText();
				String Expiryyear= ExpiryYear.getText();
				
				try {
			          PreparedStatement pst=(PreparedStatement)con.prepareStatement("insert into carddetails(CardNumber,ExpiryMonth,ExpiryYear) values(?,?,?)");
			          pst.setString(1, CardNumber1);
			          pst.setString(2, ExpiryMonth);
			          pst.setString(3, Expiryyear);
			          
			          pst.executeUpdate();
			          JOptionPane.showMessageDialog(null, "Card Added");
			          apsit.main(null);
			          dispose();
			        } catch (SQLException e1) {
			          // TODO Auto-generated catch block
			        	JOptionPane.showMessageDialog(null, "Something Went Wrong","Card",JOptionPane.ERROR_MESSAGE);
			          e1.printStackTrace();
			        }
				
//				String Year= ExpiryYear.getText();
//				String CVV1=CVV.getText();
//        		String Name=Expiry_Month.getName();
//        		String card_number =CardNumber.getText();
//        		String Expirydate=.getText();
        		
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
//        			JOptionPane.showMessageDialog(null, "Succesfully Added Card Details","Payment Details",JOptionPane.DEFAULT_OPTION);
//        		
//        		apsit.main(null);
        		
        		
			}
		});
		btnSave.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnSave.setBackground(new Color(255, 204, 102));
		btnSave.setBounds(462, 527, 201, 60);
		panel.add(btnSave);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(cardDetails1.class.getResource("/Images/card-security.png")));
		lblNewLabel.setBounds(638, 10, 174, 182);
		panel.add(lblNewLabel);
		
		JButton btnSkip = new JButton("Skip");
		btnSkip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				apsit.main(null);
				dispose();
			}
		});
		btnSkip.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnSkip.setBackground(new Color(255, 204, 102));
		btnSkip.setBounds(771, 527, 201, 60);
		panel.add(btnSkip);
		
		JLabel ExpiryDateText = new JLabel("Expiry Date (MM/YY)");
		ExpiryDateText.setFont(new Font("Maiandra GD", Font.BOLD, 28));
		ExpiryDateText.setBounds(403, 341, 295, 34);
		panel.add(ExpiryDateText);
		
		Expiry_Month = new JTextField();
		Expiry_Month.setColumns(10);
		Expiry_Month.setBounds(404, 395, 162, 44);
		panel.add(Expiry_Month);
		
		ExpiryYear = new JTextField();
		ExpiryYear.setColumns(10);
		ExpiryYear.setBounds(576, 395, 122, 44);
		panel.add(ExpiryYear);
	}
}
