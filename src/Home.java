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
import javax.swing.border.CompoundBorder;

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
		btnNewButton.setBounds(993, 295, 273, 75);
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
		btnChineseFood.setBounds(993, 391, 272, 75);
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
		btnSouthindianFood.setBounds(993, 594, 273, 72);
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
		btnPunjabiFood.setBounds(993, 494, 273, 72);
		homepanel.add(btnPunjabiFood);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("");
		lblNewLabel_1_2_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_2_1_1.setIcon(new ImageIcon(Home.class.getResource("/Images/resized-image-Promo.jpeg")));
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setBounds(21, 241, 405, 502);
		homepanel.add(lblNewLabel_1_2_1_1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 204));
		panel.setBounds(0, 0, 1476, 219);
		homepanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/Images/logo.png")));
		lblNewLabel.setBounds(49, 28, 494, 167);
		panel.add(lblNewLabel);

		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBounds(1308, 172, 127, 47);
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
		btnNewButton_2.setBackground(new Color(204, 255, 255));
		btnNewButton_2.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("");
		lblNewLabel_1_2_1_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1_1.setBounds(470, 241, 405, 502);
		homepanel.add(lblNewLabel_1_2_1_1_1);
	}
}
