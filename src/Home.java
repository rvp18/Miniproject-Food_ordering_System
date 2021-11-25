import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

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

	/**
	 * Create the frame.
	 */
	public Home(String emailId) {
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

		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setIcon(new ImageIcon(Home.class.getResource("/Images/off2.jpg")));
		lblNewLabel_1_2.setBounds(1022, 369, 380, 161);
		homepanel.add(lblNewLabel_1_2);

		JButton btnNewButton = new JButton("Maharashtrian Food");
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
		btnNewButton.setBounds(210, 631, 273, 75);
		homepanel.add(btnNewButton);

		JButton btnChineseFood = new JButton("Chinese Food");
		btnChineseFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chinese.main(null);
				dispose();
			}
		});
		btnChineseFood.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		btnChineseFood.setBackground(Color.ORANGE);
		btnChineseFood.setBounds(493, 632, 261, 75);
		homepanel.add(btnChineseFood);

		JButton btnSouthindianFood = new JButton("South-Indian Food");
		btnSouthindianFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SouthIndian.main(null);
				dispose();
			}
		});
		btnSouthindianFood.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		btnSouthindianFood.setBackground(Color.ORANGE);
		btnSouthindianFood.setBounds(764, 634, 241, 72);
		homepanel.add(btnSouthindianFood);

		JButton btnPunjabiFood = new JButton("NorthIndian");
		btnPunjabiFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NorthIndian.main(null);
				dispose();

			}
		});
		btnPunjabiFood.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		btnPunjabiFood.setBackground(Color.ORANGE);
		btnPunjabiFood.setBounds(1015, 634, 241, 72);
		homepanel.add(btnPunjabiFood);

		JLabel lblNewLabel_1_2_1 = new JLabel("");
		lblNewLabel_1_2_1.setIcon(new ImageIcon(Home.class.getResource("/Images/off2.jpg")));
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setBounds(546, 369, 431, 161);
		homepanel.add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("");
		lblNewLabel_1_2_1_1.setIcon(new ImageIcon(Home.class.getResource("/Images/off2.jpg")));
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setBounds(43, 369, 483, 161);
		homepanel.add(lblNewLabel_1_2_1_1);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1476, 219);
		homepanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/Images/APSITO MAIN.jpeg")));
		lblNewLabel.setBounds(49, 28, 494, 167);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Home.class.getResource("/Images/cart main.jpeg")));
		lblNewLabel_1.setBounds(1171, 90, 295, 119);
		panel.add(lblNewLabel_1);

		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.setBounds(1248, 28, 127, 47);
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				apsit.main(null);
				dispose();
			}
		});
		btnNewButton_2.setBackground(new Color(204, 0, 51));
		btnNewButton_2.setFont(new Font("Maiandra GD", Font.BOLD, 20));
	}
}
