import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Panel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Chinese extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chinese frame = new Chinese("");
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
	public Chinese(String emailId) {

		con = db.dbconnect();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 20, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		this.email = emailId;

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		contentPane.add(panel, BorderLayout.CENTER);

		JButton btnMaharashtrian = new JButton("Maharashtrian");
		btnMaharashtrian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Maharashtrian maharashtrianPage = new Maharashtrian(email);
				maharashtrianPage.setVisible(true);
				dispose();
			}
		});
		btnMaharashtrian.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnMaharashtrian.setBackground(Color.ORANGE);
		btnMaharashtrian.setBounds(0, 10, 185, 38);
		panel.add(btnMaharashtrian);

		JButton btnNorthindian = new JButton("North-Indian");
		btnNorthindian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NorthIndian nip = new NorthIndian(email);
				nip.setVisible(true);
				dispose();
			}
		});
		btnNorthindian.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnNorthindian.setBackground(Color.ORANGE);
		btnNorthindian.setBounds(184, 10, 194, 38);
		panel.add(btnNorthindian);

		JButton btnSouthindian = new JButton("South-Indian");
		btnSouthindian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SouthIndian sip = new SouthIndian(email);
				sip.setVisible(true);
				dispose();
			}
		});
		btnSouthindian.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnSouthindian.setBackground(Color.ORANGE);
		btnSouthindian.setBounds(378, 10, 169, 38);
		panel.add(btnSouthindian);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 44, 1466, 699);
		panel.add(tabbedPane);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Starter", null, panel_1, null);
		panel_1.setLayout(null);

		JPanel panel_2_2_1 = new JPanel();
		panel_2_2_1.setBackground(new Color(240, 240, 240));
		panel_2_2_1.setLayout(null);
		panel_2_2_1.setBounds(0, 0, 1461, 672);
		panel_1.add(panel_2_2_1);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setBackground(Color.BLACK);
		separator_1_1.setBounds(731, 55, 10, 528);
		panel_2_2_1.add(separator_1_1);

		JLabel lblNewLabel_1_3_1 = new JLabel("");
		lblNewLabel_1_3_1.setForeground(Color.WHITE);
		lblNewLabel_1_3_1.setBackground(new Color(154, 229, 230));
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_1.setIcon(new ImageIcon(Chinese.class.getResource("/Images/rsz_veg_chinese.jpg")));
		lblNewLabel_1_3_1.setBounds(10, 55, 711, 163);
		panel_2_2_1.add(lblNewLabel_1_3_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon(Chinese.class.getResource("/Images/rsz_1non-veg_chinese.jpg")));
		lblNewLabel_1_1_1_1.setBounds(751, 55, 700, 163);
		panel_2_2_1.add(lblNewLabel_1_1_1_1);

		Panel panel_2_1_6_1 = new Panel();
		panel_2_1_6_1.setLayout(null);
		panel_2_1_6_1.setBounds(10, 240, 715, 69);
		panel_2_2_1.add(panel_2_1_6_1);

		JLabel VegMachurian = new JLabel("Veg Machurian");
		VegMachurian.setFont(new Font("Times New Roman", Font.BOLD, 20));
		VegMachurian.setBounds(45, 10, 273, 56);
		panel_2_1_6_1.add(VegMachurian);

		JButton btnNewButton_1_1_6_1 = new JButton("ADD");
		btnNewButton_1_1_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = VegMachurian.getText();
				int price = 90;

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into tempaddeditems(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Item added to Order List Successfully");

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into finalorder(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1_6_1.setForeground(Color.WHITE);
		btnNewButton_1_1_6_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_6_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_6_1.setBounds(529, 22, 110, 36);
		panel_2_1_6_1.add(btnNewButton_1_1_6_1);

		JLabel lblRs_2_1 = new JLabel("Rs.90");
		lblRs_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1.setBounds(377, 8, 103, 56);
		panel_2_1_6_1.add(lblRs_2_1);

		Panel panel_2_1_1_2_1 = new Panel();
		panel_2_1_1_2_1.setLayout(null);
		panel_2_1_1_2_1.setBounds(10, 309, 715, 69);
		panel_2_2_1.add(panel_2_1_1_2_1);

		JLabel PaneerCrispy = new JLabel("Paneer Crispy");
		PaneerCrispy.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PaneerCrispy.setBounds(45, 10, 273, 56);
		panel_2_1_1_2_1.add(PaneerCrispy);

		JButton btnNewButton_1_1_1_2_1 = new JButton("ADD");
		btnNewButton_1_1_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = PaneerCrispy.getText();
				int price = 120;

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into tempaddeditems(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Item added to Order List Successfully");

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into finalorder(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1_1_2_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_1_2_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_1_2_1.setBounds(529, 22, 110, 36);
		panel_2_1_1_2_1.add(btnNewButton_1_1_1_2_1);

		JLabel lblRs_2_1_1 = new JLabel("Rs.120/-");
		lblRs_2_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_1.setBounds(377, 8, 103, 56);
		panel_2_1_1_2_1.add(lblRs_2_1_1);

		Panel panel_2_1_2_2_1 = new Panel();
		panel_2_1_2_2_1.setLayout(null);
		panel_2_1_2_2_1.setBounds(10, 378, 715, 69);
		panel_2_2_1.add(panel_2_1_2_2_1);

		JLabel SpringRoll = new JLabel("Spring Roll");
		SpringRoll.setFont(new Font("Times New Roman", Font.BOLD, 20));
		SpringRoll.setBounds(45, 10, 273, 56);
		panel_2_1_2_2_1.add(SpringRoll);

		JButton btnNewButton_1_1_2_2_1 = new JButton("ADD");
		btnNewButton_1_1_2_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = SpringRoll.getText();
				int price = 150;

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into tempaddeditems(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Item added to Order List Successfully");

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into finalorder(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1_2_2_1.setForeground(Color.WHITE);
		btnNewButton_1_1_2_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_2_2_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_2_2_1.setBounds(529, 22, 110, 36);
		panel_2_1_2_2_1.add(btnNewButton_1_1_2_2_1);

		JLabel lblRs_2_1_2 = new JLabel("Rs.150/-");
		lblRs_2_1_2.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_2.setBounds(377, 8, 103, 56);
		panel_2_1_2_2_1.add(lblRs_2_1_2);

		Panel panel_2_1_3_2_1 = new Panel();
		panel_2_1_3_2_1.setLayout(null);
		panel_2_1_3_2_1.setBounds(10, 446, 715, 69);
		panel_2_2_1.add(panel_2_1_3_2_1);

		JLabel HotandSourSoup = new JLabel("Hot and Sour Soup");
		HotandSourSoup.setFont(new Font("Times New Roman", Font.BOLD, 20));
		HotandSourSoup.setBounds(45, 10, 273, 56);
		panel_2_1_3_2_1.add(HotandSourSoup);

		JButton btnNewButton_1_1_3_2_1 = new JButton("ADD");
		btnNewButton_1_1_3_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = HotandSourSoup.getText();
				int price = 170;

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into tempaddeditems(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Item added to Order List Successfully");

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into finalorder(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1_3_2_1.setForeground(Color.WHITE);
		btnNewButton_1_1_3_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_3_2_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_3_2_1.setBounds(529, 22, 110, 36);
		panel_2_1_3_2_1.add(btnNewButton_1_1_3_2_1);

		JLabel lblRs_2_1_3 = new JLabel("Rs.170/-");
		lblRs_2_1_3.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_3.setBounds(377, 8, 103, 56);
		panel_2_1_3_2_1.add(lblRs_2_1_3);

		Panel panel_2_1_4_2_1 = new Panel();
		panel_2_1_4_2_1.setLayout(null);
		panel_2_1_4_2_1.setBounds(10, 515, 715, 69);
		panel_2_2_1.add(panel_2_1_4_2_1);

		JLabel Manchaw = new JLabel("Manchow Soup");
		Manchaw.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Manchaw.setBounds(45, 10, 273, 56);
		panel_2_1_4_2_1.add(Manchaw);

		JButton btnNewButton_1_1_4_2_1 = new JButton("ADD");
		btnNewButton_1_1_4_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = Manchaw.getText();
				int price = 170;

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into tempaddeditems(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Item added to Order List Successfully");

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into finalorder(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_1_1_4_2_1.setForeground(Color.WHITE);
		btnNewButton_1_1_4_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_4_2_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_4_2_1.setBounds(529, 22, 110, 36);
		panel_2_1_4_2_1.add(btnNewButton_1_1_4_2_1);

		JLabel lblRs_2_1_4 = new JLabel("Rs.170/-");
		lblRs_2_1_4.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_4.setBounds(377, 8, 103, 56);
		panel_2_1_4_2_1.add(lblRs_2_1_4);

		Panel panel_2_1_5_1_1 = new Panel();
		panel_2_1_5_1_1.setLayout(null);
		panel_2_1_5_1_1.setBounds(744, 240, 715, 69);
		panel_2_2_1.add(panel_2_1_5_1_1);

		JLabel ChickenChilli = new JLabel("Chicken Chilli");
		ChickenChilli.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ChickenChilli.setBounds(45, 10, 273, 56);
		panel_2_1_5_1_1.add(ChickenChilli);

		JButton btnNewButton_1_1_5_1_1 = new JButton("ADD");
		btnNewButton_1_1_5_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = ChickenChilli.getText();
				int price = 130;

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into tempaddeditems(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Item added to Order List Successfully");

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into finalorder(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1_5_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_5_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_5_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_5_1_1.setBounds(529, 22, 110, 36);
		panel_2_1_5_1_1.add(btnNewButton_1_1_5_1_1);

		JLabel lblRs_2_1_5 = new JLabel("Rs.130/-");
		lblRs_2_1_5.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_5.setBounds(377, 8, 103, 56);
		panel_2_1_5_1_1.add(lblRs_2_1_5);

		Panel panel_2_1_1_1_1_1 = new Panel();
		panel_2_1_1_1_1_1.setLayout(null);
		panel_2_1_1_1_1_1.setBounds(744, 309, 715, 69);
		panel_2_2_1.add(panel_2_1_1_1_1_1);

		JLabel ChickenCrispy = new JLabel("Chicken Crispy");
		ChickenCrispy.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ChickenCrispy.setBounds(45, 10, 273, 56);
		panel_2_1_1_1_1_1.add(ChickenCrispy);

		JButton btnNewButton_1_1_1_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = ChickenCrispy.getText();
				int price = 140;

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into tempaddeditems(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Item added to Order List Successfully");

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into finalorder(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_1_1_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_1_1_1_1.setBounds(529, 22, 110, 36);
		panel_2_1_1_1_1_1.add(btnNewButton_1_1_1_1_1_1);

		JLabel lblRs_2_1_6 = new JLabel("Rs.140/-");
		lblRs_2_1_6.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_6.setBounds(377, 8, 103, 56);
		panel_2_1_1_1_1_1.add(lblRs_2_1_6);

		Panel panel_2_1_2_1_1_1 = new Panel();
		panel_2_1_2_1_1_1.setLayout(null);
		panel_2_1_2_1_1_1.setBounds(744, 378, 715, 69);
		panel_2_2_1.add(panel_2_1_2_1_1_1);

		JLabel ChickenLollypop = new JLabel("Chicken Lollypop");
		ChickenLollypop.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ChickenLollypop.setBounds(45, 10, 273, 56);
		panel_2_1_2_1_1_1.add(ChickenLollypop);

		JButton btnNewButton_1_1_2_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_2_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = ChickenLollypop.getText();
				int price = 160;

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into tempaddeditems(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Item added to Order List Successfully");

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into finalorder(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1_2_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_2_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_2_1_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_2_1_1_1.setBounds(529, 22, 110, 36);
		panel_2_1_2_1_1_1.add(btnNewButton_1_1_2_1_1_1);

		JLabel lblRs_2_1_7 = new JLabel("Rs.160/-");
		lblRs_2_1_7.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_7.setBounds(377, 8, 103, 56);
		panel_2_1_2_1_1_1.add(lblRs_2_1_7);

		Panel panel_2_1_3_1_1_1 = new Panel();
		panel_2_1_3_1_1_1.setLayout(null);
		panel_2_1_3_1_1_1.setBounds(744, 446, 715, 69);
		panel_2_2_1.add(panel_2_1_3_1_1_1);

		JLabel ChickenHotandSourSoup = new JLabel("Chicken Hot and Sour Soup");
		ChickenHotandSourSoup.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ChickenHotandSourSoup.setBounds(45, 10, 273, 56);
		panel_2_1_3_1_1_1.add(ChickenHotandSourSoup);

		JButton btnNewButton_1_1_3_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_3_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = ChickenHotandSourSoup.getText();
				int price = 200;

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into tempaddeditems(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Item added to Order List Successfully");

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into finalorder(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1_3_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_3_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_3_1_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_3_1_1_1.setBounds(529, 22, 110, 36);
		panel_2_1_3_1_1_1.add(btnNewButton_1_1_3_1_1_1);

		JLabel lblRs_2_1_8 = new JLabel("Rs.200/-");
		lblRs_2_1_8.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_8.setBounds(377, 8, 103, 56);
		panel_2_1_3_1_1_1.add(lblRs_2_1_8);

		Panel panel_2_1_4_1_1_1 = new Panel();
		panel_2_1_4_1_1_1.setLayout(null);
		panel_2_1_4_1_1_1.setBounds(744, 515, 715, 69);
		panel_2_2_1.add(panel_2_1_4_1_1_1);

		JLabel ChickenManchowSoup = new JLabel("Chicken Manchow Soup ");
		ChickenManchowSoup.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ChickenManchowSoup.setBounds(45, 10, 273, 56);
		panel_2_1_4_1_1_1.add(ChickenManchowSoup);

		JButton btnNewButton_1_1_4_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_4_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = ChickenManchowSoup.getText();
				int price = 200;

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into tempaddeditems(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Item added to Order List Successfully");

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into finalorder(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1_4_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_4_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_4_1_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_4_1_1_1.setBounds(529, 22, 110, 36);
		panel_2_1_4_1_1_1.add(btnNewButton_1_1_4_1_1_1);

		JLabel lblRs_2_1_9 = new JLabel("Rs.200/-");
		lblRs_2_1_9.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_9.setBounds(377, 8, 103, 56);
		panel_2_1_4_1_1_1.add(lblRs_2_1_9);

		JButton btnNewButton_2 = new JButton("Order");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orderdetails odp = new Orderdetails(email);
				odp.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Maiandra GD", Font.BOLD, 30));
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.setBounds(624, 593, 209, 58);
		panel_2_2_1.add(btnNewButton_2);

		JButton btnBack_1 = new JButton("");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home hp = new Home(email);
				hp.setVisible(true);
				dispose();
			}
		});
		btnBack_1.setIcon(new ImageIcon(Chinese.class.getResource("/Images/back 3.png")));
		btnBack_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnBack_1.setBackground(Color.WHITE);
		btnBack_1.setBounds(10, 592, 101, 80);
		panel_2_2_1.add(btnBack_1);
		
		JLabel lblNewLabel = new JLabel("Starters");
		lblNewLabel.setFont(new Font("Maiandra GD", Font.BOLD, 35));
		lblNewLabel.setBounds(671, -18, 200, 90);
		panel_2_2_1.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Main", null, panel_2, null);
		panel_2.setLayout(null);

		JPanel panel_2_2_1_1 = new JPanel();
		panel_2_2_1_1.setBackground(Color.WHITE);
		panel_2_2_1_1.setLayout(null);
		panel_2_2_1_1.setBounds(0, 0, 1461, 672);
		panel_2.add(panel_2_2_1_1);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1_1.setBackground(Color.BLACK);
		separator_1_1_1.setBounds(731, 61, 10, 522);
		panel_2_2_1_1.add(separator_1_1_1);

		JLabel lblNewLabel_1_3_1_1 = new JLabel("");
		lblNewLabel_1_3_1_1.setIcon(new ImageIcon(Chinese.class.getResource("/Images/rsz_veg_chinese.jpg")));
		lblNewLabel_1_3_1_1.setBounds(33, 55, 688, 163);
		panel_2_2_1_1.add(lblNewLabel_1_3_1_1);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1_1.setIcon(new ImageIcon(Chinese.class.getResource("/Images/rsz_1non-veg_chinese.jpg")));
		lblNewLabel_1_1_1_1_1.setBounds(763, 55, 688, 163);
		panel_2_2_1_1.add(lblNewLabel_1_1_1_1_1);

		Panel panel_2_1_6_1_1 = new Panel();
		panel_2_1_6_1_1.setLayout(null);
		panel_2_1_6_1_1.setBounds(10, 240, 715, 69);
		panel_2_2_1_1.add(panel_2_1_6_1_1);

		JLabel VegFriedRice = new JLabel("Veg Fried Rice");
		VegFriedRice.setFont(new Font("Times New Roman", Font.BOLD, 20));
		VegFriedRice.setBounds(45, 10, 273, 56);
		panel_2_1_6_1_1.add(VegFriedRice);

		JButton btnNewButton_1_1_6_1_1 = new JButton("ADD");
		btnNewButton_1_1_6_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = VegFriedRice.getText();
				int price = 150;

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into tempaddeditems(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Item added to Order List Successfully");

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into finalorder(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_1_1_6_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_6_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_6_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_6_1_1.setBounds(529, 22, 110, 36);
		panel_2_1_6_1_1.add(btnNewButton_1_1_6_1_1);

		JLabel lblRs_2_1_10 = new JLabel("Rs.150/-");
		lblRs_2_1_10.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_10.setBounds(377, 8, 103, 56);
		panel_2_1_6_1_1.add(lblRs_2_1_10);

		Panel panel_2_1_1_2_1_1 = new Panel();
		panel_2_1_1_2_1_1.setLayout(null);
		panel_2_1_1_2_1_1.setBounds(10, 309, 715, 69);
		panel_2_2_1_1.add(panel_2_1_1_2_1_1);

		JLabel SchezwanFriedRice = new JLabel("Schezwan Fried Rice");
		SchezwanFriedRice.setFont(new Font("Times New Roman", Font.BOLD, 20));
		SchezwanFriedRice.setBounds(45, 10, 273, 56);
		panel_2_1_1_2_1_1.add(SchezwanFriedRice);

		JButton btnNewButton_1_1_1_2_1_1 = new JButton("ADD");
		btnNewButton_1_1_1_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = SchezwanFriedRice.getText();
				int price = 160;

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into tempaddeditems(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Item added to Order List Successfully");

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into finalorder(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1_1_2_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1_2_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_1_2_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_1_2_1_1.setBounds(529, 22, 110, 36);
		panel_2_1_1_2_1_1.add(btnNewButton_1_1_1_2_1_1);

		JLabel lblRs_2_1_11 = new JLabel("Rs.160/-");
		lblRs_2_1_11.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_11.setBounds(377, 8, 103, 56);
		panel_2_1_1_2_1_1.add(lblRs_2_1_11);

		Panel panel_2_1_2_2_1_1 = new Panel();
		panel_2_1_2_2_1_1.setLayout(null);
		panel_2_1_2_2_1_1.setBounds(10, 378, 715, 69);
		panel_2_2_1_1.add(panel_2_1_2_2_1_1);

		JLabel TripleSchezwanNoodles = new JLabel("Triple Schezwan Noodles");
		TripleSchezwanNoodles.setFont(new Font("Times New Roman", Font.BOLD, 20));
		TripleSchezwanNoodles.setBounds(45, 10, 273, 56);
		panel_2_1_2_2_1_1.add(TripleSchezwanNoodles);

		JButton btnNewButton_1_1_2_2_1_1 = new JButton("ADD");
		btnNewButton_1_1_2_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = TripleSchezwanNoodles.getText();
				int price = 180;

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into tempaddeditems(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Item added to Order List Successfully");

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into finalorder(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1_2_2_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_2_2_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_2_2_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_2_2_1_1.setBounds(529, 22, 110, 36);
		panel_2_1_2_2_1_1.add(btnNewButton_1_1_2_2_1_1);

		JLabel lblRs_2_1_12 = new JLabel("Rs.180/-");
		lblRs_2_1_12.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_12.setBounds(377, 8, 103, 56);
		panel_2_1_2_2_1_1.add(lblRs_2_1_12);

		Panel panel_2_1_3_2_1_1 = new Panel();
		panel_2_1_3_2_1_1.setLayout(null);
		panel_2_1_3_2_1_1.setBounds(10, 446, 715, 69);
		panel_2_2_1_1.add(panel_2_1_3_2_1_1);

		JLabel HakkaNoodles = new JLabel("Hakka Noodles");
		HakkaNoodles.setFont(new Font("Times New Roman", Font.BOLD, 20));
		HakkaNoodles.setBounds(45, 10, 273, 56);
		panel_2_1_3_2_1_1.add(HakkaNoodles);

		JButton btnNewButton_1_1_3_2_1_1 = new JButton("ADD");
		btnNewButton_1_1_3_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = HakkaNoodles.getText();
				int price = 180;

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into tempaddeditems(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Item added to Order List Successfully");

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into finalorder(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1_3_2_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_3_2_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_3_2_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_3_2_1_1.setBounds(529, 22, 110, 36);
		panel_2_1_3_2_1_1.add(btnNewButton_1_1_3_2_1_1);

		JLabel lblRs_2_1_13 = new JLabel("Rs.180/-");
		lblRs_2_1_13.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_13.setBounds(377, 8, 103, 56);
		panel_2_1_3_2_1_1.add(lblRs_2_1_13);

		Panel panel_2_1_4_2_1_1 = new Panel();
		panel_2_1_4_2_1_1.setLayout(null);
		panel_2_1_4_2_1_1.setBounds(10, 515, 715, 69);
		panel_2_2_1_1.add(panel_2_1_4_2_1_1);

		JLabel HongKongNoodles = new JLabel("Hong-Kong Noodles");
		HongKongNoodles.setFont(new Font("Times New Roman", Font.BOLD, 20));
		HongKongNoodles.setBounds(45, 10, 273, 56);
		panel_2_1_4_2_1_1.add(HongKongNoodles);

		JButton btnNewButton_1_1_4_2_1_1 = new JButton("ADD");
		btnNewButton_1_1_4_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = HongKongNoodles.getText();
				int price = 200;

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into tempaddeditems(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Item added to Order List Successfully");

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into finalorder(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1_4_2_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_4_2_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_4_2_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_4_2_1_1.setBounds(529, 22, 110, 36);
		panel_2_1_4_2_1_1.add(btnNewButton_1_1_4_2_1_1);

		JLabel lblRs_2_1_14 = new JLabel("Rs.200/-");
		lblRs_2_1_14.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_14.setBounds(377, 8, 103, 56);
		panel_2_1_4_2_1_1.add(lblRs_2_1_14);

		Panel panel_2_1_5_1_1_1 = new Panel();
		panel_2_1_5_1_1_1.setLayout(null);
		panel_2_1_5_1_1_1.setBounds(744, 240, 715, 69);
		panel_2_2_1_1.add(panel_2_1_5_1_1_1);

		JLabel ChickenFriedRice = new JLabel("Chicken Fried Rice");
		ChickenFriedRice.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ChickenFriedRice.setBounds(45, 10, 273, 56);
		panel_2_1_5_1_1_1.add(ChickenFriedRice);

		JButton btnNewButton_1_1_5_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_5_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = ChickenFriedRice.getText();
				int price = 180;

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into tempaddeditems(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Item added to Order List Successfully");

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into finalorder(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1_5_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_5_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_5_1_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_5_1_1_1.setBounds(529, 22, 110, 36);
		panel_2_1_5_1_1_1.add(btnNewButton_1_1_5_1_1_1);

		JLabel lblRs_2_1_15 = new JLabel("Rs.180/-");
		lblRs_2_1_15.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_15.setBounds(377, 8, 103, 56);
		panel_2_1_5_1_1_1.add(lblRs_2_1_15);

		Panel panel_2_1_1_1_1_1_1 = new Panel();
		panel_2_1_1_1_1_1_1.setLayout(null);
		panel_2_1_1_1_1_1_1.setBounds(744, 309, 715, 69);
		panel_2_2_1_1.add(panel_2_1_1_1_1_1_1);

		JLabel ChickenSchezwanFriedRice = new JLabel("Chicken Schezwan Fried Rice");
		ChickenSchezwanFriedRice.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ChickenSchezwanFriedRice.setBounds(45, 10, 273, 56);
		panel_2_1_1_1_1_1_1.add(ChickenSchezwanFriedRice);

		JButton btnNewButton_1_1_1_1_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = ChickenSchezwanFriedRice.getText();
				int price = 190;

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into tempaddeditems(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Item added to Order List Successfully");

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into finalorder(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1_1_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1_1_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_1_1_1_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_1_1_1_1_1.setBounds(529, 22, 110, 36);
		panel_2_1_1_1_1_1_1.add(btnNewButton_1_1_1_1_1_1_1);

		JLabel lblRs_2_1_16 = new JLabel("Rs.190/-");
		lblRs_2_1_16.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_16.setBounds(377, 8, 103, 56);
		panel_2_1_1_1_1_1_1.add(lblRs_2_1_16);

		Panel panel_2_1_2_1_1_1_1 = new Panel();
		panel_2_1_2_1_1_1_1.setLayout(null);
		panel_2_1_2_1_1_1_1.setBounds(744, 378, 715, 69);
		panel_2_2_1_1.add(panel_2_1_2_1_1_1_1);

		JLabel ChickenTripleSchezwanNoodles = new JLabel("Chicken Triple Schezwan Noodles");
		ChickenTripleSchezwanNoodles.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ChickenTripleSchezwanNoodles.setBounds(47, 10, 304, 56);
		panel_2_1_2_1_1_1_1.add(ChickenTripleSchezwanNoodles);

		JButton btnNewButton_1_1_2_1_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_2_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = ChickenTripleSchezwanNoodles.getText();
				int price = 210;

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into tempaddeditems(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Item added to Order List Successfully");

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into finalorder(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1_2_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_2_1_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_2_1_1_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_2_1_1_1_1.setBounds(529, 22, 110, 36);
		panel_2_1_2_1_1_1_1.add(btnNewButton_1_1_2_1_1_1_1);

		JLabel lblRs_2_1_17 = new JLabel("Rs.210/-");
		lblRs_2_1_17.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_17.setBounds(379, 8, 103, 56);
		panel_2_1_2_1_1_1_1.add(lblRs_2_1_17);

		Panel panel_2_1_3_1_1_1_1 = new Panel();
		panel_2_1_3_1_1_1_1.setLayout(null);
		panel_2_1_3_1_1_1_1.setBounds(744, 446, 715, 69);
		panel_2_2_1_1.add(panel_2_1_3_1_1_1_1);

		JLabel ChickenHakkaNoodles = new JLabel("Chicken Hakka Noodles");
		ChickenHakkaNoodles.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ChickenHakkaNoodles.setBounds(45, 10, 273, 56);
		panel_2_1_3_1_1_1_1.add(ChickenHakkaNoodles);

		JButton btnNewButton_1_1_3_1_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_3_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = ChickenHakkaNoodles.getText();
				int price = 210;

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into tempaddeditems(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Item added to Order List Successfully");

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into finalorder(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1_3_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_3_1_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_3_1_1_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_3_1_1_1_1.setBounds(529, 22, 110, 36);
		panel_2_1_3_1_1_1_1.add(btnNewButton_1_1_3_1_1_1_1);

		JLabel lblRs_2_1_18 = new JLabel("Rs.210/-");
		lblRs_2_1_18.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_18.setBounds(377, 8, 103, 56);
		panel_2_1_3_1_1_1_1.add(lblRs_2_1_18);

		Panel panel_2_1_4_1_1_1_1 = new Panel();
		panel_2_1_4_1_1_1_1.setLayout(null);
		panel_2_1_4_1_1_1_1.setBounds(744, 515, 715, 69);
		panel_2_2_1_1.add(panel_2_1_4_1_1_1_1);

		JLabel lblRs_2_1_19 = new JLabel("Rs.240/-");
		lblRs_2_1_19.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_19.setBounds(377, 8, 103, 56);
		panel_2_1_4_1_1_1_1.add(lblRs_2_1_19);

		JLabel lblNewLabel_1_2_4_1_1_1_1 = new JLabel("Chicken Hong-Kong Noodles");
		lblNewLabel_1_2_4_1_1_1_1.setBounds(45, 10, 273, 56);
		panel_2_1_4_1_1_1_1.add(lblNewLabel_1_2_4_1_1_1_1);
		lblNewLabel_1_2_4_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JButton btnNewButton_1_1_4_1_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_4_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = lblNewLabel_1_2_4_1_1_1_1.getText();
				int price = 240;

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into tempaddeditems(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Item added to Order List Successfully");

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

				try {
					PreparedStatement pst = con
							.prepareStatement("insert into finalorder(Email,Name,Price) values(?,?,?)");
					pst.setString(1, email);
					pst.setString(2, item);
					pst.setInt(3, price);

					pst.executeUpdate();

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Something Wrong", "Order List", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1_4_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_4_1_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_4_1_1_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_4_1_1_1_1.setBounds(529, 22, 110, 36);
		panel_2_1_4_1_1_1_1.add(btnNewButton_1_1_4_1_1_1_1);

		JButton btnNewButton_2_1 = new JButton("Order");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orderdetails odp = new Orderdetails(email);
				odp.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 30));
		btnNewButton_2_1.setBackground(Color.ORANGE);
		btnNewButton_2_1.setBounds(624, 593, 209, 58);
		panel_2_2_1_1.add(btnNewButton_2_1);
		
		JLabel lblMainCourse = new JLabel("Main Course");
		lblMainCourse.setFont(new Font("Maiandra GD", Font.BOLD, 35));
		lblMainCourse.setBounds(637, -20, 283, 90);
		panel_2_2_1_1.add(lblMainCourse);
	}

}
