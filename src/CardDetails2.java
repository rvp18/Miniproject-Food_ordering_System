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
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

public class CardDetails2 extends JFrame {

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
					CardDetails2 frame = new CardDetails2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}
	Connection con=null;
	/**
	 * Create the frame.
	 */
	public CardDetails2() {
		
		con=db.dbconnect();
		
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
		lblNewLabel_1.setBounds(426, 234, 268, 53);
		panel_1.add(lblNewLabel_1);
		
		CardNumber = new JPasswordField();
		CardNumber.setBounds(426, 297, 580, 44);
		panel_1.add(CardNumber);
		
		JButton btnSave = new JButton("Add Your Card & Proceed to Pay");
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
			          JOptionPane.showMessageDialog(null, "Card Added , Now Proceed to Pay");
			          payment.main(null);
			          dispose();
			        } catch (SQLException e1) {
			          // TODO Auto-generated catch block
			        	JOptionPane.showMessageDialog(null, "Something Went Wrong","Card",JOptionPane.ERROR_MESSAGE);
			          e1.printStackTrace();
			        }
			}
		});
		btnSave.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnSave.setBackground(new Color(255, 204, 102));
		btnSave.setBounds(498, 523, 425, 60);
		panel_1.add(btnSave);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CardDetails2.class.getResource("/Images/card-security.png")));
		lblNewLabel.setBounds(638, 10, 174, 182);
		panel_1.add(lblNewLabel);
		
		JButton btnBack_1 = new JButton("");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orderdetails.main(null);
				dispose();
			}
		});
		btnBack_1.setIcon(new ImageIcon(CardDetails2.class.getResource("/Images/back 3.png")));
		btnBack_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnBack_1.setBackground(Color.WHITE);
		btnBack_1.setBounds(59, 598, 101, 80);
		panel_1.add(btnBack_1);
		
		Expiry_Month = new JTextField();
		Expiry_Month.setColumns(10);
		Expiry_Month.setBounds(426, 450, 162, 44);
		panel_1.add(Expiry_Month);
		
		ExpiryYear = new JTextField();
		ExpiryYear.setColumns(10);
		ExpiryYear.setBounds(598, 450, 122, 44);
		panel_1.add(ExpiryYear);
		
		JLabel ExpiryDateText = new JLabel("Expiry Date (MM/YY)");
		ExpiryDateText.setFont(new Font("Maiandra GD", Font.BOLD, 28));
		ExpiryDateText.setBounds(425, 395, 295, 34);
		panel_1.add(ExpiryDateText);
	}
}
