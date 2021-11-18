import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class payment extends JFrame {

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
					payment frame = new payment();
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
	public payment() {
		
		con=db.dbconnect();
		
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
		panel_1.setBounds(466, 253, 740, 427);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Card Number");
		lblNewLabel_1.setFont(new Font("Maiandra GD", Font.BOLD, 28));
		lblNewLabel_1.setBounds(61, 10, 268, 53);
		panel_1.add(lblNewLabel_1);
		
		CardNumber = new JPasswordField();
		CardNumber.setBounds(60, 61, 580, 44);
		panel_1.add(CardNumber);
		
		
		
		
		CVV1 = new JPasswordField();
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
		Expiry_Month.setBounds(61, 190, 162, 44);
		panel_1.add(Expiry_Month);
		Expiry_Month.setColumns(10);
		
		JLabel ExpiryDateText = new JLabel("Expiry Date (MM/YY)");
		ExpiryDateText.setFont(new Font("Maiandra GD", Font.BOLD, 28));
		ExpiryDateText.setBounds(61, 155, 295, 34);
		panel_1.add(ExpiryDateText);
		
		ExpiryYear = new JTextField();
		ExpiryYear.setColumns(10);
		ExpiryYear.setBounds(233, 190, 122, 44);
		panel_1.add(ExpiryYear);
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try
				{    String CardNumber1= CardNumber.getText();
				String ExpiryMonth= Expiry_Month.getText();
				String Expiryyear= ExpiryYear.getText();
				String CVV= CVV1.getText();
     				PreparedStatement pst=(PreparedStatement)con.prepareStatement("select * from carddetails where CardNumber=? and ExpiryMonth=? and  ExpiryYear=? and  CVV=?");
				    pst.setString(1, CardNumber1);
				    pst.setString(2, ExpiryMonth);
				    pst.setString(3, Expiryyear);
				    pst.setString(4, CVV);
				    ResultSet r= pst.executeQuery();
				    
				  
				    
				    if(r.next()){
				    	JOptionPane.showMessageDialog(null, "Payment Done");
				          
				    	
				    }
				    else {
				    	JOptionPane.showMessageDialog(null, "Wrong Details");
				    	CardNumber.setText(null);
				    	Expiry_Month.setText(null);
				    	ExpiryYear.setText(null);
				    	CVV1.setText(null);
				    }
				    
				    
				}
				catch(Exception e1) {
					e1.printStackTrace();
					
			        }

				
			}
		});
	}
}
