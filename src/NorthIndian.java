import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class NorthIndian extends JFrame {

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
					NorthIndian frame = new NorthIndian("");
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
	public NorthIndian(String emailId) {

		con = db.dbconnect();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 20, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		this.email = emailId;

		JPanel panel = new JPanel();
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
		btnSouthindian.setBounds(184, 10, 169, 38);
		panel.add(btnSouthindian);

		JButton btnChinese = new JButton("Chinese");
		btnChinese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chinese cp = new Chinese(email);
				cp.setVisible(true);
				dispose();
			}
		});
		btnChinese.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnChinese.setBackground(Color.ORANGE);
		btnChinese.setBounds(350, 10, 106, 38);
		panel.add(btnChinese);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 44, 1466, 699);
		panel.add(tabbedPane);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Starter", null, panel_1, null);
		panel_1.setLayout(null);

		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBounds(0, 0, 1461, 672);
		panel_1.add(panel_2_2);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(731, 61, 10, 529);
		panel_2_2.add(separator_1);

		JLabel lblNewLabel_1_3 = new JLabel("");
		lblNewLabel_1_3.setIcon(new ImageIcon(NorthIndian.class.getResource("/Images/Veg-NI.jpeg")));
		lblNewLabel_1_3.setBounds(33, 63, 688, 163);
		panel_2_2.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(NorthIndian.class.getResource("/Images/Non-Veg Ni.jpeg")));
		lblNewLabel_1_1_1.setBounds(763, 63, 688, 163);
		panel_2_2.add(lblNewLabel_1_1_1);

		Panel panel_2_1_6 = new Panel();
		panel_2_1_6.setLayout(null);
		panel_2_1_6.setBounds(10, 248, 715, 69);
		panel_2_2.add(panel_2_1_6);

		JLabel PaneerTikka = new JLabel("Paneer Tikka");
		PaneerTikka.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PaneerTikka.setBounds(45, 10, 273, 56);
		panel_2_1_6.add(PaneerTikka);

		JButton btnNewButton_1_1_6 = new JButton("ADD");
		btnNewButton_1_1_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = PaneerTikka.getText();
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
		btnNewButton_1_1_6.setForeground(Color.WHITE);
		btnNewButton_1_1_6.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_6.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_6.setBounds(529, 22, 110, 36);
		panel_2_1_6.add(btnNewButton_1_1_6);

		JLabel lblRs_2_1_10 = new JLabel("Rs.150/-");
		lblRs_2_1_10.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_10.setBounds(377, 8, 103, 56);
		panel_2_1_6.add(lblRs_2_1_10);

		Panel panel_2_1_1_2 = new Panel();
		panel_2_1_1_2.setLayout(null);
		panel_2_1_1_2.setBounds(10, 317, 715, 69);
		panel_2_2.add(panel_2_1_1_2);

		JLabel PaneerMalaiTikka = new JLabel("Paneer Malai Tikka");
		PaneerMalaiTikka.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PaneerMalaiTikka.setBounds(45, 10, 273, 56);
		panel_2_1_1_2.add(PaneerMalaiTikka);

		JButton btnNewButton_1_1_1_2 = new JButton("ADD");
		btnNewButton_1_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = PaneerMalaiTikka.getText();
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
		btnNewButton_1_1_1_2.setForeground(Color.WHITE);
		btnNewButton_1_1_1_2.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_1_2.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_1_2.setBounds(529, 22, 110, 36);
		panel_2_1_1_2.add(btnNewButton_1_1_1_2);

		JLabel lblRs_2_1_11 = new JLabel("Rs.160/-");
		lblRs_2_1_11.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_11.setBounds(377, 8, 103, 56);
		panel_2_1_1_2.add(lblRs_2_1_11);

		Panel panel_2_1_2_2 = new Panel();
		panel_2_1_2_2.setLayout(null);
		panel_2_1_2_2.setBounds(10, 386, 715, 69);
		panel_2_2.add(panel_2_1_2_2);

		JLabel HaraBharaKabab = new JLabel("Hara-Bhara Kabab");
		HaraBharaKabab.setFont(new Font("Times New Roman", Font.BOLD, 20));
		HaraBharaKabab.setBounds(45, 10, 273, 56);
		panel_2_1_2_2.add(HaraBharaKabab);

		JButton btnNewButton_1_1_2_2 = new JButton("ADD");
		btnNewButton_1_1_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = HaraBharaKabab.getText();
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
		btnNewButton_1_1_2_2.setForeground(Color.WHITE);
		btnNewButton_1_1_2_2.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_2_2.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_2_2.setBounds(529, 22, 110, 36);
		panel_2_1_2_2.add(btnNewButton_1_1_2_2);

		JLabel lblRs_2_1_12 = new JLabel("Rs.180/-");
		lblRs_2_1_12.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_12.setBounds(377, 8, 103, 56);
		panel_2_1_2_2.add(lblRs_2_1_12);

		Panel panel_2_1_3_2 = new Panel();
		panel_2_1_3_2.setLayout(null);
		panel_2_1_3_2.setBounds(10, 454, 715, 69);
		panel_2_2.add(panel_2_1_3_2);

		JLabel AmritsariPapadPaneer = new JLabel("Amritsari Papad Paneer");
		AmritsariPapadPaneer.setFont(new Font("Times New Roman", Font.BOLD, 20));
		AmritsariPapadPaneer.setBounds(45, 10, 273, 56);
		panel_2_1_3_2.add(AmritsariPapadPaneer);

		JButton btnNewButton_1_1_3_2 = new JButton("ADD");
		btnNewButton_1_1_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = AmritsariPapadPaneer.getText();
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
		btnNewButton_1_1_3_2.setForeground(Color.WHITE);
		btnNewButton_1_1_3_2.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_3_2.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_3_2.setBounds(529, 22, 110, 36);
		panel_2_1_3_2.add(btnNewButton_1_1_3_2);

		JLabel lblRs_2_1_13 = new JLabel("Rs.190/-");
		lblRs_2_1_13.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_13.setBounds(377, 8, 103, 56);
		panel_2_1_3_2.add(lblRs_2_1_13);

		Panel panel_2_1_4_2 = new Panel();
		panel_2_1_4_2.setLayout(null);
		panel_2_1_4_2.setBounds(10, 523, 715, 69);
		panel_2_2.add(panel_2_1_4_2);

		JLabel AlooChat = new JLabel("Aloo Chat");
		AlooChat.setFont(new Font("Times New Roman", Font.BOLD, 20));
		AlooChat.setBounds(45, 10, 273, 56);
		panel_2_1_4_2.add(AlooChat);

		JButton btnNewButton_1_1_4_2 = new JButton("ADD");
		btnNewButton_1_1_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = AlooChat.getText();
				int price = 80;
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
		btnNewButton_1_1_4_2.setForeground(Color.WHITE);
		btnNewButton_1_1_4_2.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_4_2.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_4_2.setBounds(529, 22, 110, 36);
		panel_2_1_4_2.add(btnNewButton_1_1_4_2);

		JLabel lblRs_2_1_14 = new JLabel("Rs.80/-");
		lblRs_2_1_14.setBounds(377, 8, 103, 56);
		panel_2_1_4_2.add(lblRs_2_1_14);
		lblRs_2_1_14.setFont(new Font("Maiandra GD", Font.BOLD, 20));

		Panel panel_2_1_5_1 = new Panel();
		panel_2_1_5_1.setLayout(null);
		panel_2_1_5_1.setBounds(744, 248, 715, 69);
		panel_2_2.add(panel_2_1_5_1);

		JLabel Kurma = new JLabel("Kurma");
		Kurma.setBounds(45, 10, 273, 56);
		panel_2_1_5_1.add(Kurma);
		Kurma.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JButton btnNewButton_1_1_5_1 = new JButton("ADD");
		btnNewButton_1_1_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = Kurma.getText();
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
		btnNewButton_1_1_5_1.setForeground(Color.WHITE);
		btnNewButton_1_1_5_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_5_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_5_1.setBounds(529, 22, 110, 36);
		panel_2_1_5_1.add(btnNewButton_1_1_5_1);

		JLabel lblRs_2_1_15 = new JLabel("Rs.190/-");
		lblRs_2_1_15.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_15.setBounds(377, 8, 103, 56);
		panel_2_1_5_1.add(lblRs_2_1_15);

		Panel panel_2_1_1_1_1 = new Panel();
		panel_2_1_1_1_1.setLayout(null);
		panel_2_1_1_1_1.setBounds(744, 317, 715, 69);
		panel_2_2.add(panel_2_1_1_1_1);

		JLabel Kabab = new JLabel("Kabab");
		Kabab.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Kabab.setBounds(45, 10, 273, 56);
		panel_2_1_1_1_1.add(Kabab);

		JButton btnNewButton_1_1_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = Kabab.getText();
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
		btnNewButton_1_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_1_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_1_1_1.setBounds(529, 22, 110, 36);
		panel_2_1_1_1_1.add(btnNewButton_1_1_1_1_1);

		JLabel lblRs_2_1_16 = new JLabel("Rs.200/-");
		lblRs_2_1_16.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_16.setBounds(377, 8, 103, 56);
		panel_2_1_1_1_1.add(lblRs_2_1_16);

		Panel panel_2_1_2_1_1 = new Panel();
		panel_2_1_2_1_1.setLayout(null);
		panel_2_1_2_1_1.setBounds(744, 386, 715, 69);
		panel_2_2.add(panel_2_1_2_1_1);

		JLabel ChickenTikka = new JLabel("Chicken Tikka");
		ChickenTikka.setBounds(45, 10, 273, 56);
		panel_2_1_2_1_1.add(ChickenTikka);
		ChickenTikka.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JButton btnNewButton_1_1_2_1_1 = new JButton("ADD");
		btnNewButton_1_1_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = ChickenTikka.getText();
				int price = 220;
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
		btnNewButton_1_1_2_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_2_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_2_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_2_1_1.setBounds(529, 22, 110, 36);
		panel_2_1_2_1_1.add(btnNewButton_1_1_2_1_1);

		JLabel lblRs_2_1_17 = new JLabel("Rs.220/-");
		lblRs_2_1_17.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_17.setBounds(377, 8, 103, 56);
		panel_2_1_2_1_1.add(lblRs_2_1_17);

		Panel panel_2_1_3_1_1 = new Panel();
		panel_2_1_3_1_1.setLayout(null);
		panel_2_1_3_1_1.setBounds(744, 454, 715, 69);
		panel_2_2.add(panel_2_1_3_1_1);

		JLabel ChickenAngara = new JLabel("Chicken Angara");
		ChickenAngara.setBounds(45, 10, 273, 56);
		panel_2_1_3_1_1.add(ChickenAngara);
		ChickenAngara.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JButton btnNewButton_1_1_3_1_1 = new JButton("ADD");
		btnNewButton_1_1_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = ChickenAngara.getText();
				int price = 250;
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
		btnNewButton_1_1_3_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_3_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_3_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_3_1_1.setBounds(529, 22, 110, 36);
		panel_2_1_3_1_1.add(btnNewButton_1_1_3_1_1);

		JLabel lblRs_2_1_18 = new JLabel("Rs.250/-");
		lblRs_2_1_18.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_18.setBounds(377, 8, 103, 56);
		panel_2_1_3_1_1.add(lblRs_2_1_18);

		Panel panel_2_1_4_1_1 = new Panel();
		panel_2_1_4_1_1.setLayout(null);
		panel_2_1_4_1_1.setBounds(744, 523, 715, 69);
		panel_2_2.add(panel_2_1_4_1_1);

		JLabel AmritsariFishFry = new JLabel("Amritsari Fish Fry");
		AmritsariFishFry.setBounds(42, 10, 273, 56);
		panel_2_1_4_1_1.add(AmritsariFishFry);
		AmritsariFishFry.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JButton btnNewButton_1_1_4_1_1 = new JButton("ADD");
		btnNewButton_1_1_4_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = AmritsariFishFry.getText();
				int price = 280;
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
		btnNewButton_1_1_4_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_4_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_4_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_4_1_1.setBounds(529, 22, 110, 36);
		panel_2_1_4_1_1.add(btnNewButton_1_1_4_1_1);

		JLabel lblRs_2_1_19 = new JLabel("Rs.280/-");
		lblRs_2_1_19.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_19.setBounds(377, 8, 103, 56);
		panel_2_1_4_1_1.add(lblRs_2_1_19);

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
		btnNewButton_2.setBounds(632, 600, 209, 58);
		panel_2_2.add(btnNewButton_2);

		JButton btnBack_1 = new JButton("");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home hp = new Home(email);
				hp.setVisible(true);
				dispose();
			}
		});
		btnBack_1.setIcon(new ImageIcon(NorthIndian.class.getResource("/Images/back 3.png")));
		btnBack_1.setBounds(10, 598, 101, 80);
		panel_2_2.add(btnBack_1);
		btnBack_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnBack_1.setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("Starters");
		lblNewLabel.setFont(new Font("Maiandra GD", Font.BOLD, 35));
		lblNewLabel.setBounds(671, -12, 200, 90);
		panel_2_2.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Main", null, panel_2, null);
		panel_2.setLayout(null);

		JPanel panel_2_2_1 = new JPanel();
		panel_2_2_1.setLayout(null);
		panel_2_2_1.setBounds(0, 0, 1461, 672);
		panel_2.add(panel_2_2_1);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setBackground(Color.BLACK);
		separator_1_1.setBounds(731, 63, 10, 527);
		panel_2_2_1.add(separator_1_1);

		JLabel lblNewLabel_1_3_1 = new JLabel("");
		lblNewLabel_1_3_1.setIcon(new ImageIcon(NorthIndian.class.getResource("/Images/Veg-NI.jpeg")));
		lblNewLabel_1_3_1.setBounds(33, 63, 688, 163);
		panel_2_2_1.add(lblNewLabel_1_3_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon(NorthIndian.class.getResource("/Images/Non-Veg Ni.jpeg")));
		lblNewLabel_1_1_1_1.setBounds(763, 63, 688, 163);
		panel_2_2_1.add(lblNewLabel_1_1_1_1);

		Panel panel_2_1_6_1 = new Panel();
		panel_2_1_6_1.setLayout(null);
		panel_2_1_6_1.setBounds(10, 248, 715, 69);

		panel_2_2_1.add(panel_2_1_6_1);

		JLabel PaneerBhurji = new JLabel("Paneer Bhurji");
		PaneerBhurji.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PaneerBhurji.setBounds(45, 10, 273, 56);
		panel_2_1_6_1.add(PaneerBhurji);

		JButton btnNewButton_1_1_6_1 = new JButton("ADD");
		btnNewButton_1_1_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = PaneerBhurji.getText();
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
		btnNewButton_1_1_6_1.setForeground(Color.WHITE);
		btnNewButton_1_1_6_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_6_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_6_1.setBounds(529, 22, 110, 36);
		panel_2_1_6_1.add(btnNewButton_1_1_6_1);

		JLabel lblRs_2_1 = new JLabel("Rs.130/-");
		lblRs_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1.setBounds(377, 8, 103, 56);
		panel_2_1_6_1.add(lblRs_2_1);

		Panel panel_2_1_1_2_1 = new Panel();
		panel_2_1_1_2_1.setLayout(null);
		panel_2_1_1_2_1.setBounds(10, 317, 715, 69);
		panel_2_2_1.add(panel_2_1_1_2_1);

		JLabel CholeBhature = new JLabel("Chole Bhature");
		CholeBhature.setFont(new Font("Times New Roman", Font.BOLD, 20));
		CholeBhature.setBounds(45, 10, 273, 56);
		panel_2_1_1_2_1.add(CholeBhature);

		JButton btnNewButton_1_1_1_2_1 = new JButton("ADD");
		btnNewButton_1_1_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = CholeBhature.getText();
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
		btnNewButton_1_1_1_2_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_1_2_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_1_2_1.setBounds(529, 22, 110, 36);
		panel_2_1_1_2_1.add(btnNewButton_1_1_1_2_1);

		JLabel lblRs_2_1_1 = new JLabel("Rs.130/-");
		lblRs_2_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_1.setBounds(377, 8, 103, 56);
		panel_2_1_1_2_1.add(lblRs_2_1_1);

		Panel panel_2_1_2_2_1 = new Panel();
		panel_2_1_2_2_1.setLayout(null);
		panel_2_1_2_2_1.setBounds(10, 386, 715, 69);
		panel_2_2_1.add(panel_2_1_2_2_1);

		JLabel PalakPaneer = new JLabel("Palak Paneer");
		PalakPaneer.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PalakPaneer.setBounds(45, 10, 273, 56);
		panel_2_1_2_2_1.add(PalakPaneer);

		JButton btnNewButton_1_1_2_2_1 = new JButton("ADD");
		btnNewButton_1_1_2_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = PalakPaneer.getText();
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
		panel_2_1_3_2_1.setBounds(10, 454, 715, 69);
		panel_2_2_1.add(panel_2_1_3_2_1);

		JLabel PaneerButterMasala = new JLabel("Paneer Butter Masala");
		PaneerButterMasala.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PaneerButterMasala.setBounds(45, 10, 273, 56);
		panel_2_1_3_2_1.add(PaneerButterMasala);

		JButton btnNewButton_1_1_3_2_1 = new JButton("ADD");
		btnNewButton_1_1_3_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = PaneerButterMasala.getText();
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
		panel_2_1_4_2_1.setBounds(10, 523, 715, 69);
		panel_2_2_1.add(panel_2_1_4_2_1);

		JLabel PaneerPasanda = new JLabel("Paneer Pasanda");
		PaneerPasanda.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PaneerPasanda.setBounds(45, 10, 273, 56);

		panel_2_1_4_2_1.add(PaneerPasanda);

		JButton btnNewButton_1_1_4_2_1 = new JButton("ADD");
		btnNewButton_1_1_4_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = PaneerPasanda.getText();
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
		btnNewButton_1_1_4_2_1.setForeground(Color.WHITE);
		btnNewButton_1_1_4_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_4_2_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_4_2_1.setBounds(529, 22, 110, 36);
		panel_2_1_4_2_1.add(btnNewButton_1_1_4_2_1);

		JLabel lblRs_2_1_4 = new JLabel("Rs.190/-");
		lblRs_2_1_4.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_4.setBounds(377, 8, 103, 56);
		panel_2_1_4_2_1.add(lblRs_2_1_4);

		Panel panel_2_1_5_1_1 = new Panel();
		panel_2_1_5_1_1.setLayout(null);
		panel_2_1_5_1_1.setBounds(744, 248, 715, 69);
		panel_2_2_1.add(panel_2_1_5_1_1);

		JLabel DhabeDaMeat = new JLabel("Dhabe Da Meat");
		DhabeDaMeat.setFont(new Font("Times New Roman", Font.BOLD, 20));
		DhabeDaMeat.setBounds(45, 10, 273, 56);
		panel_2_1_5_1_1.add(DhabeDaMeat);

		JButton btnNewButton_1_1_5_1_1 = new JButton("ADD");
		btnNewButton_1_1_5_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = DhabeDaMeat.getText();
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
		btnNewButton_1_1_5_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_5_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_5_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_5_1_1.setBounds(529, 22, 110, 36);
		panel_2_1_5_1_1.add(btnNewButton_1_1_5_1_1);

		JLabel lblRs_2_1_5 = new JLabel("Rs.180/-");
		lblRs_2_1_5.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_5.setBounds(377, 8, 103, 56);
		panel_2_1_5_1_1.add(lblRs_2_1_5);

		Panel panel_2_1_1_1_1_1 = new Panel();
		panel_2_1_1_1_1_1.setLayout(null);
		panel_2_1_1_1_1_1.setBounds(744, 317, 715, 69);
		panel_2_2_1.add(panel_2_1_1_1_1_1);

		JLabel PalakButterChicken = new JLabel("Palak Butter Chicken");
		PalakButterChicken.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PalakButterChicken.setBounds(45, 10, 273, 56);
		panel_2_1_1_1_1_1.add(PalakButterChicken);

		JButton btnNewButton_1_1_1_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = PalakButterChicken.getText();
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
		btnNewButton_1_1_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_1_1_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_1_1_1_1.setBounds(529, 22, 110, 36);
		panel_2_1_1_1_1_1.add(btnNewButton_1_1_1_1_1_1);

		JLabel lblRs_2_1_6 = new JLabel("Rs.200/-");
		lblRs_2_1_6.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_6.setBounds(377, 8, 103, 56);
		panel_2_1_1_1_1_1.add(lblRs_2_1_6);

		Panel panel_2_1_2_1_1_1 = new Panel();
		panel_2_1_2_1_1_1.setLayout(null);
		panel_2_1_2_1_1_1.setBounds(744, 386, 715, 69);
		panel_2_2_1.add(panel_2_1_2_1_1_1);

		JLabel ChickenDoPyaza = new JLabel("Chicken Do Pyaza");
		ChickenDoPyaza.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ChickenDoPyaza.setBounds(45, 10, 273, 56);
		panel_2_1_2_1_1_1.add(ChickenDoPyaza);

		JButton btnNewButton_1_1_2_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_2_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = ChickenDoPyaza.getText();
				int price = 220;
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

		JLabel lblRs_2_1_7 = new JLabel("Rs.220/-");
		lblRs_2_1_7.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_7.setBounds(377, 8, 103, 56);
		panel_2_1_2_1_1_1.add(lblRs_2_1_7);

		Panel panel_2_1_3_1_1_1 = new Panel();
		panel_2_1_3_1_1_1.setLayout(null);
		panel_2_1_3_1_1_1.setBounds(744, 454, 715, 69);
		panel_2_2_1.add(panel_2_1_3_1_1_1);

		JLabel ChickenMakhani = new JLabel("Chicken Makhani");
		ChickenMakhani.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ChickenMakhani.setBounds(45, 10, 273, 56);
		panel_2_1_3_1_1_1.add(ChickenMakhani);

		JButton btnNewButton_1_1_3_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_3_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = ChickenMakhani.getText();
				int price = 250;
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

		JLabel lblRs_2_1_8 = new JLabel("Rs.250/-");
		lblRs_2_1_8.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_8.setBounds(377, 8, 103, 56);
		panel_2_1_3_1_1_1.add(lblRs_2_1_8);

		Panel panel_2_1_4_1_1_1 = new Panel();
		panel_2_1_4_1_1_1.setLayout(null);
		panel_2_1_4_1_1_1.setBounds(744, 523, 715, 69);
		panel_2_2_1.add(panel_2_1_4_1_1_1);

		JLabel AmritsariChickenHandi = new JLabel("Amritsari Chiken Handi");
		AmritsariChickenHandi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		AmritsariChickenHandi.setBounds(45, 10, 273, 56);
		panel_2_1_4_1_1_1.add(AmritsariChickenHandi);

		JButton btnNewButton_1_1_4_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_4_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = AmritsariChickenHandi.getText();
				int price = 280;
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

		JLabel lblRs_2_1_9 = new JLabel("Rs.280/-");
		lblRs_2_1_9.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_9.setBounds(377, 8, 103, 56);
		panel_2_1_4_1_1_1.add(lblRs_2_1_9);

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
		btnNewButton_2_1.setBounds(632, 600, 209, 58);
		panel_2_2_1.add(btnNewButton_2_1);
		
		JLabel lblMainCourse = new JLabel("Main Course");
		lblMainCourse.setFont(new Font("Maiandra GD", Font.BOLD, 35));
		lblMainCourse.setBounds(632, -14, 283, 90);
		panel_2_2_1.add(lblMainCourse);
	}

}
