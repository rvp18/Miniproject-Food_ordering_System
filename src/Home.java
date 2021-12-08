import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Home extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public String email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home("");
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
	public Home(String emailId) {

		con = db.dbconnect();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 20, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		this.email = emailId;

		JPanel homepanel = new JPanel();
		homepanel.setBackground(Color.WHITE);
		contentPane.add(homepanel, BorderLayout.CENTER);
		homepanel.setLayout(null);

		JButton btnNewButton = new JButton("Maharashtrian Food");
		btnNewButton.setBorder(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Maharashtrian.main(null);
				Maharashtrian maharashtrianPage = new Maharashtrian(email);
				maharashtrianPage.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		btnNewButton.setBounds(600, 340, 273, 75);
		homepanel.add(btnNewButton);

		JButton btnChineseFood = new JButton("Chinese Food");
		btnChineseFood.setBorder(null);
		btnChineseFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chinese cp = new Chinese(email);
				cp.setVisible(true);
				dispose();
			}
		});
		btnChineseFood.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		btnChineseFood.setBackground(Color.ORANGE);
		btnChineseFood.setBounds(600, 436, 272, 75);
		homepanel.add(btnChineseFood);

		JButton btnSouthindianFood = new JButton("South-Indian Food");
		btnSouthindianFood.setBorder(null);
		btnSouthindianFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SouthIndian sip = new SouthIndian(email);
				sip.setVisible(true);
				dispose();
			}
		});
		btnSouthindianFood.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		btnSouthindianFood.setBackground(Color.ORANGE);
		btnSouthindianFood.setBounds(600, 639, 273, 72);
		homepanel.add(btnSouthindianFood);

		JButton btnPunjabiFood = new JButton("NorthIndian");
		btnPunjabiFood.setBorder(null);
		btnPunjabiFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NorthIndian nip = new NorthIndian(email);
				nip.setVisible(true);
				dispose();

			}
		});
		btnPunjabiFood.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		btnPunjabiFood.setBackground(Color.ORANGE);
		btnPunjabiFood.setBounds(600, 539, 273, 72);
		homepanel.add(btnPunjabiFood);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("");
		lblNewLabel_1_2_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_2_1_1.setIcon(new ImageIcon(Home.class.getResource("/Images/rsz_todays_special_canva.jpg")));
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setBounds(21, 241, 405, 502);
		homepanel.add(lblNewLabel_1_2_1_1);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1476, 219);
		homepanel.add(panel);
		panel.setLayout(null);

		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBounds(1265, 92, 127, 47);
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement pst1 = (PreparedStatement) con
							.prepareStatement("DELETE FROM tempaddeditems WHERE Email=?");
					pst1.setString(1, email);
					pst1.executeUpdate();

				} catch (SQLException e1) {

					e1.printStackTrace();
				}
				apsit.main(null);
				dispose();
			}
		});
		btnNewButton_2.setBackground(new Color(255, 51, 51));
		btnNewButton_2.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		
				JLabel lblNewLabel = new JLabel("New label");
				lblNewLabel.setBounds(505, -390, 494, 758);
				panel.add(lblNewLabel);
				lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/Images/APSITO-White.jpeg")));
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("");
		lblNewLabel_1_2_1_1_1.setIcon(new ImageIcon(Home.class.getResource("/Images/offer 1.jpg")));
		lblNewLabel_1_2_1_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1_1.setBounds(1040, 241, 405, 502);
		homepanel.add(lblNewLabel_1_2_1_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("Menu");
		lblNewLabel_3.setFont(new Font("Maiandra GD", Font.BOLD, 40));
		lblNewLabel_3.setBounds(678, 253, 260, 49);
		homepanel.add(lblNewLabel_3);
	}
}
