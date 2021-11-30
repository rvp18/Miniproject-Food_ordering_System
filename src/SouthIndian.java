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

public class SouthIndian extends JFrame {

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
					SouthIndian frame = new SouthIndian("");
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
	public SouthIndian(String emailId) {

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
		btnChinese.setBounds(376, 10, 106, 38);
		panel.add(btnChinese);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 44, 1466, 699);
		panel.add(tabbedPane);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Starter", null, panel_1, null);
		panel_1.setLayout(null);

		JPanel panel_2_2_1 = new JPanel();
		panel_2_2_1.setLayout(null);
		panel_2_2_1.setBounds(0, 0, 1461, 672);
		panel_1.add(panel_2_2_1);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setBackground(Color.BLACK);
		separator_1_1.setBounds(731, 60, 10, 513);
		panel_2_2_1.add(separator_1_1);

		JLabel lblNewLabel_1_3_1 = new JLabel("");
		lblNewLabel_1_3_1.setBackground(Color.WHITE);
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_1.setIcon(new ImageIcon(SouthIndian.class.getResource("/Images/rsz_1veg_south-indian.jpg")));
		lblNewLabel_1_3_1.setBounds(33, 60, 688, 163);
		panel_2_2_1.add(lblNewLabel_1_3_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1
				.setIcon(new ImageIcon(SouthIndian.class.getResource("/Images/rsz_non-veg_south-indian.jpg")));
		lblNewLabel_1_1_1_1.setBounds(763, 60, 688, 163);
		panel_2_2_1.add(lblNewLabel_1_1_1_1);

		Panel panel_2_1_6_1 = new Panel();
		panel_2_1_6_1.setLayout(null);
		panel_2_1_6_1.setBounds(10, 229, 715, 69);
		panel_2_2_1.add(panel_2_1_6_1);

		JLabel MasalaDosa = new JLabel("Masala Dosa");
		MasalaDosa.setFont(new Font("Times New Roman", Font.BOLD, 20));
		MasalaDosa.setBounds(45, 10, 273, 56);
		panel_2_1_6_1.add(MasalaDosa);

		JButton btnNewButton_1_1_6_1 = new JButton("ADD");
		btnNewButton_1_1_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = MasalaDosa.getText();
				int price = 50;

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

		JLabel lblRs_2_1 = new JLabel("Rs.50/-");
		lblRs_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1.setBounds(377, 8, 103, 56);
		panel_2_1_6_1.add(lblRs_2_1);

		Panel panel_2_1_1_2_1 = new Panel();
		panel_2_1_1_2_1.setLayout(null);
		panel_2_1_1_2_1.setBounds(10, 298, 715, 69);
		panel_2_2_1.add(panel_2_1_1_2_1);

		JLabel Uttappa = new JLabel("Uttappa");
		Uttappa.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Uttappa.setBounds(45, 10, 273, 56);
		panel_2_1_1_2_1.add(Uttappa);

		JButton btnNewButton_1_1_1_2_1 = new JButton("ADD");
		btnNewButton_1_1_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = Uttappa.getText();
				int price = 70;

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

		JLabel lblRs_2_1_1 = new JLabel("Rs.70/-");
		lblRs_2_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_1.setBounds(377, 8, 103, 56);
		panel_2_1_1_2_1.add(lblRs_2_1_1);

		Panel panel_2_1_2_2_1 = new Panel();
		panel_2_1_2_2_1.setLayout(null);
		panel_2_1_2_2_1.setBounds(10, 367, 715, 69);
		panel_2_2_1.add(panel_2_1_2_2_1);

		JLabel Idli = new JLabel("Idli Sambar");
		Idli.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Idli.setBounds(45, 10, 273, 56);
		panel_2_1_2_2_1.add(Idli);

		JButton btnNewButton_1_1_2_2_1 = new JButton("ADD");
		btnNewButton_1_1_2_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = Idli.getText();
				int price = 70;

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

		JLabel lblRs_2_1_2 = new JLabel("Rs.70/-");
		lblRs_2_1_2.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_2.setBounds(377, 8, 103, 56);
		panel_2_1_2_2_1.add(lblRs_2_1_2);

		Panel panel_2_1_3_2_1 = new Panel();
		panel_2_1_3_2_1.setLayout(null);
		panel_2_1_3_2_1.setBounds(10, 435, 715, 69);
		panel_2_2_1.add(panel_2_1_3_2_1);

		JLabel Meduvada = new JLabel("Meduvada");
		Meduvada.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Meduvada.setBounds(45, 10, 273, 56);
		panel_2_1_3_2_1.add(Meduvada);

		JButton btnNewButton_1_1_3_2_1 = new JButton("ADD");
		btnNewButton_1_1_3_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = Meduvada.getText();
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
		btnNewButton_1_1_3_2_1.setForeground(Color.WHITE);
		btnNewButton_1_1_3_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_3_2_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_3_2_1.setBounds(529, 22, 110, 36);
		panel_2_1_3_2_1.add(btnNewButton_1_1_3_2_1);

		JLabel lblRs_2_1_3 = new JLabel("Rs.80/-");
		lblRs_2_1_3.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_3.setBounds(377, 8, 103, 56);
		panel_2_1_3_2_1.add(lblRs_2_1_3);

		Panel panel_2_1_4_2_1 = new Panel();
		panel_2_1_4_2_1.setLayout(null);
		panel_2_1_4_2_1.setBounds(10, 504, 715, 69);
		panel_2_2_1.add(panel_2_1_4_2_1);

		JLabel CoconutBarfi = new JLabel("Coconut Barfi");
		CoconutBarfi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		CoconutBarfi.setBounds(45, 10, 273, 56);
		panel_2_1_4_2_1.add(CoconutBarfi);

		JButton btnNewButton_1_1_4_2_1 = new JButton("ADD");
		btnNewButton_1_1_4_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = CoconutBarfi.getText();
				int price = 70;

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

		JLabel lblRs_2_1_4 = new JLabel("Rs.70/-");
		lblRs_2_1_4.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_4.setBounds(377, 8, 103, 56);
		panel_2_1_4_2_1.add(lblRs_2_1_4);

		Panel panel_2_1_5_1_1 = new Panel();
		panel_2_1_5_1_1.setLayout(null);
		panel_2_1_5_1_1.setBounds(744, 229, 715, 69);
		panel_2_2_1.add(panel_2_1_5_1_1);

		JLabel KeralaChickenRoast = new JLabel("Kerala Chicken Roast");
		KeralaChickenRoast.setFont(new Font("Times New Roman", Font.BOLD, 20));
		KeralaChickenRoast.setBounds(45, 10, 273, 56);
		panel_2_1_5_1_1.add(KeralaChickenRoast);

		JButton btnNewButton_1_1_5_1_1 = new JButton("ADD");
		btnNewButton_1_1_5_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = KeralaChickenRoast.getText();
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
		btnNewButton_1_1_5_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_5_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_5_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_5_1_1.setBounds(529, 22, 110, 36);
		panel_2_1_5_1_1.add(btnNewButton_1_1_5_1_1);

		JLabel lblRs_2_1_5 = new JLabel("Rs.150/-");
		lblRs_2_1_5.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_5.setBounds(377, 8, 103, 56);
		panel_2_1_5_1_1.add(lblRs_2_1_5);

		Panel panel_2_1_1_1_1_1 = new Panel();
		panel_2_1_1_1_1_1.setLayout(null);
		panel_2_1_1_1_1_1.setBounds(744, 298, 715, 69);
		panel_2_2_1.add(panel_2_1_1_1_1_1);

		JLabel PayyoliChickenFry = new JLabel("Payyoli Chicken Fry");
		PayyoliChickenFry.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PayyoliChickenFry.setBounds(45, 10, 273, 56);
		panel_2_1_1_1_1_1.add(PayyoliChickenFry);

		JButton btnNewButton_1_1_1_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = PayyoliChickenFry.getText();
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
		btnNewButton_1_1_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_1_1_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_1_1_1_1.setBounds(529, 22, 110, 36);
		panel_2_1_1_1_1_1.add(btnNewButton_1_1_1_1_1_1);

		JLabel lblRs_2_1_6 = new JLabel("Rs.170/-");
		lblRs_2_1_6.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_6.setBounds(377, 8, 103, 56);
		panel_2_1_1_1_1_1.add(lblRs_2_1_6);

		Panel panel_2_1_2_1_1_1 = new Panel();
		panel_2_1_2_1_1_1.setLayout(null);
		panel_2_1_2_1_1_1.setBounds(744, 367, 715, 69);
		panel_2_2_1.add(panel_2_1_2_1_1_1);

		JLabel SquidFry = new JLabel("Squid Fry");
		SquidFry.setFont(new Font("Times New Roman", Font.BOLD, 20));
		SquidFry.setBounds(45, 10, 273, 56);
		panel_2_1_2_1_1_1.add(SquidFry);

		JButton btnNewButton_1_1_2_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_2_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = SquidFry.getText();
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
		btnNewButton_1_1_2_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_2_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_2_1_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_2_1_1_1.setBounds(529, 22, 110, 36);
		panel_2_1_2_1_1_1.add(btnNewButton_1_1_2_1_1_1);

		JLabel lblRs_2_1_7 = new JLabel("Rs.170/-");
		lblRs_2_1_7.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_7.setBounds(377, 8, 103, 56);
		panel_2_1_2_1_1_1.add(lblRs_2_1_7);

		Panel panel_2_1_3_1_1_1 = new Panel();
		panel_2_1_3_1_1_1.setLayout(null);
		panel_2_1_3_1_1_1.setBounds(744, 435, 715, 69);
		panel_2_2_1.add(panel_2_1_3_1_1_1);

		JLabel KaneRavaFry = new JLabel("Kane Rava Fry");
		KaneRavaFry.setFont(new Font("Times New Roman", Font.BOLD, 20));
		KaneRavaFry.setBounds(45, 10, 273, 56);
		panel_2_1_3_1_1_1.add(KaneRavaFry);

		JButton btnNewButton_1_1_3_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_3_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = KaneRavaFry.getText();
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
		panel_2_1_4_1_1_1.setBounds(744, 504, 715, 69);
		panel_2_2_1.add(panel_2_1_4_1_1_1);

		JLabel ChickenNizami = new JLabel("Chicken Nizami");
		ChickenNizami.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ChickenNizami.setBounds(45, 10, 273, 56);
		panel_2_1_4_1_1_1.add(ChickenNizami);

		JButton btnNewButton_1_1_4_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_4_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = ChickenNizami.getText();
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
		btnNewButton_1_1_4_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_4_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_4_1_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_4_1_1_1.setBounds(529, 22, 110, 36);
		panel_2_1_4_1_1_1.add(btnNewButton_1_1_4_1_1_1);

		JLabel lblRs_2_1_9 = new JLabel("Rs.220/-");
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
		btnNewButton_2_1.setBounds(637, 583, 209, 58);
		panel_2_2_1.add(btnNewButton_2_1);

		JButton btnBack_1 = new JButton("");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home hp = new Home(email);
				hp.setVisible(true);
				dispose();
			}
		});
		btnBack_1.setIcon(new ImageIcon(SouthIndian.class.getResource("/Images/back 3.png")));
		btnBack_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnBack_1.setBackground(Color.WHITE);
		btnBack_1.setBounds(10, 582, 101, 80);
		panel_2_2_1.add(btnBack_1);
		
		JLabel lblNewLabel = new JLabel("Starters");
		lblNewLabel.setFont(new Font("Maiandra GD", Font.BOLD, 35));
		lblNewLabel.setBounds(670, -16, 200, 90);
		panel_2_2_1.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Main", null, panel_2, null);
		panel_2.setLayout(null);

		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBackground(Color.WHITE);
		panel_2_2.setLayout(null);
		panel_2_2.setBounds(0, 0, 1461, 672);
		panel_2.add(panel_2_2);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(731, 55, 10, 543);
		panel_2_2.add(separator_1);

		JLabel lblNewLabel_1_3 = new JLabel("");
		lblNewLabel_1_3.setIcon(new ImageIcon(SouthIndian.class.getResource("/Images/rsz_1veg_south-indian.jpg")));
		lblNewLabel_1_3.setBounds(21, 55, 700, 163);
		panel_2_2.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(SouthIndian.class.getResource("/Images/rsz_non-veg_south-indian.jpg")));
		lblNewLabel_1_1_1.setBounds(751, 55, 700, 163);
		panel_2_2.add(lblNewLabel_1_1_1);

		Panel panel_2_1_6 = new Panel();
		panel_2_1_6.setLayout(null);
		panel_2_1_6.setBounds(10, 238, 715, 69);
		panel_2_2.add(panel_2_1_6);

		JLabel Pesarattu = new JLabel("Pesarattu");
		Pesarattu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Pesarattu.setBounds(45, 10, 273, 56);
		panel_2_1_6.add(Pesarattu);

		JButton btnNewButton_1_1_6 = new JButton("ADD");
		btnNewButton_1_1_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = Pesarattu.getText();
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
		panel_2_1_1_2.setBounds(10, 307, 715, 69);
		panel_2_2.add(panel_2_1_1_2);

		JLabel PuliodarRice = new JLabel("Puliodar Rice");
		PuliodarRice.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PuliodarRice.setBounds(45, 10, 273, 56);
		panel_2_1_1_2.add(PuliodarRice);

		JButton btnNewButton_1_1_1_2 = new JButton("ADD");
		btnNewButton_1_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = PuliodarRice.getText();
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
		btnNewButton_1_1_1_2.setForeground(Color.WHITE);
		btnNewButton_1_1_1_2.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_1_2.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_1_2.setBounds(529, 22, 110, 36);
		panel_2_1_1_2.add(btnNewButton_1_1_1_2);

		JLabel lblRs_2_1_11 = new JLabel("Rs.170/-");
		lblRs_2_1_11.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_11.setBounds(377, 8, 103, 56);
		panel_2_1_1_2.add(lblRs_2_1_11);

		Panel panel_2_1_2_2 = new Panel();
		panel_2_1_2_2.setLayout(null);
		panel_2_1_2_2.setBounds(10, 376, 715, 69);
		panel_2_2.add(panel_2_1_2_2);

		JLabel TomotoGojju = new JLabel("Tomoto Gojju");
		TomotoGojju.setFont(new Font("Times New Roman", Font.BOLD, 20));
		TomotoGojju.setBounds(45, 10, 273, 56);
		panel_2_1_2_2.add(TomotoGojju);

		JButton btnNewButton_1_1_2_2 = new JButton("ADD");
		btnNewButton_1_1_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = TomotoGojju.getText();
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
		panel_2_1_3_2.setBounds(10, 444, 715, 69);
		panel_2_2.add(panel_2_1_3_2);

		JLabel MoreKuzhambu = new JLabel("More Kuzhambu");
		MoreKuzhambu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		MoreKuzhambu.setBounds(45, 10, 273, 56);
		panel_2_1_3_2.add(MoreKuzhambu);

		JButton btnNewButton_1_1_3_2 = new JButton("ADD");
		btnNewButton_1_1_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = MoreKuzhambu.getText();
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
		btnNewButton_1_1_3_2.setForeground(Color.WHITE);
		btnNewButton_1_1_3_2.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_3_2.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_3_2.setBounds(529, 22, 110, 36);
		panel_2_1_3_2.add(btnNewButton_1_1_3_2);

		JLabel lblRs_2_1_13 = new JLabel("Rs.200/-");
		lblRs_2_1_13.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_13.setBounds(377, 8, 103, 56);
		panel_2_1_3_2.add(lblRs_2_1_13);

		Panel panel_2_1_4_2 = new Panel();
		panel_2_1_4_2.setLayout(null);
		panel_2_1_4_2.setBounds(10, 513, 715, 69);
		panel_2_2.add(panel_2_1_4_2);

		JLabel PongalKootu = new JLabel("Pongal Kootu");
		PongalKootu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PongalKootu.setBounds(45, 10, 273, 56);
		panel_2_1_4_2.add(PongalKootu);

		JButton btnNewButton_1_1_4_2 = new JButton("ADD");
		btnNewButton_1_1_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = PongalKootu.getText();
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
		btnNewButton_1_1_4_2.setForeground(Color.WHITE);
		btnNewButton_1_1_4_2.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_4_2.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_4_2.setBounds(529, 22, 110, 36);
		panel_2_1_4_2.add(btnNewButton_1_1_4_2);

		JLabel lblRs_2_1_14 = new JLabel("Rs.220/-");
		lblRs_2_1_14.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_14.setBounds(377, 8, 103, 56);
		panel_2_1_4_2.add(lblRs_2_1_14);

		Panel panel_2_1_5_1 = new Panel();
		panel_2_1_5_1.setLayout(null);
		panel_2_1_5_1.setBounds(744, 238, 715, 69);
		panel_2_2.add(panel_2_1_5_1);

		JLabel ChickenChettinad = new JLabel("Chicken Chettinad");
		ChickenChettinad.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ChickenChettinad.setBounds(45, 10, 273, 56);
		panel_2_1_5_1.add(ChickenChettinad);

		JButton btnNewButton_1_1_5_1 = new JButton("ADD");
		btnNewButton_1_1_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = ChickenChettinad.getText();
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
		btnNewButton_1_1_5_1.setForeground(Color.WHITE);
		btnNewButton_1_1_5_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_5_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_5_1.setBounds(529, 22, 110, 36);
		panel_2_1_5_1.add(btnNewButton_1_1_5_1);

		JLabel lblRs_2_1_15 = new JLabel("Rs.250/-");
		lblRs_2_1_15.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_15.setBounds(377, 8, 103, 56);
		panel_2_1_5_1.add(lblRs_2_1_15);

		Panel panel_2_1_1_1_1 = new Panel();
		panel_2_1_1_1_1.setLayout(null);
		panel_2_1_1_1_1.setBounds(744, 307, 715, 69);
		panel_2_2.add(panel_2_1_1_1_1);

		JLabel AilaCurry = new JLabel("Aila Curry");
		AilaCurry.setFont(new Font("Times New Roman", Font.BOLD, 20));
		AilaCurry.setBounds(45, 10, 273, 56);
		panel_2_1_1_1_1.add(AilaCurry);

		JButton btnNewButton_1_1_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = AilaCurry.getText();
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
		btnNewButton_1_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_1_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_1_1_1.setBounds(529, 22, 110, 36);
		panel_2_1_1_1_1.add(btnNewButton_1_1_1_1_1);

		JLabel lblRs_2_1_16 = new JLabel("Rs.250/-");
		lblRs_2_1_16.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_16.setBounds(377, 8, 103, 56);
		panel_2_1_1_1_1.add(lblRs_2_1_16);

		Panel panel_2_1_2_1_1 = new Panel();
		panel_2_1_2_1_1.setLayout(null);
		panel_2_1_2_1_1.setBounds(744, 376, 715, 69);
		panel_2_2.add(panel_2_1_2_1_1);

		JLabel SquidCurry = new JLabel("Squid Curry");
		SquidCurry.setFont(new Font("Times New Roman", Font.BOLD, 20));
		SquidCurry.setBounds(45, 10, 273, 56);
		panel_2_1_2_1_1.add(SquidCurry);

		JButton btnNewButton_1_1_2_1_1 = new JButton("ADD");
		btnNewButton_1_1_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = SquidCurry.getText();
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
		btnNewButton_1_1_2_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_2_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_2_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_2_1_1.setBounds(529, 22, 110, 36);
		panel_2_1_2_1_1.add(btnNewButton_1_1_2_1_1);

		JLabel lblRs_2_1_17 = new JLabel("Rs.280/-");
		lblRs_2_1_17.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_17.setBounds(377, 8, 103, 56);
		panel_2_1_2_1_1.add(lblRs_2_1_17);

		Panel panel_2_1_3_1_1 = new Panel();
		panel_2_1_3_1_1.setLayout(null);
		panel_2_1_3_1_1.setBounds(744, 444, 715, 69);
		panel_2_2.add(panel_2_1_3_1_1);

		JLabel ChickenSalna = new JLabel("Chicken Salna ");
		ChickenSalna.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ChickenSalna.setBounds(45, 10, 273, 56);
		panel_2_1_3_1_1.add(ChickenSalna);

		JButton btnNewButton_1_1_3_1_1 = new JButton("ADD");
		btnNewButton_1_1_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = ChickenSalna.getText();
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
		btnNewButton_1_1_3_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_3_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_3_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_3_1_1.setBounds(529, 22, 110, 36);
		panel_2_1_3_1_1.add(btnNewButton_1_1_3_1_1);

		JLabel lblRs_2_1_18 = new JLabel("Rs.280/-");
		lblRs_2_1_18.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1_18.setBounds(377, 8, 103, 56);
		panel_2_1_3_1_1.add(lblRs_2_1_18);

		Panel panel_2_1_4_1_1 = new Panel();
		panel_2_1_4_1_1.setLayout(null);
		panel_2_1_4_1_1.setBounds(744, 513, 715, 69);
		panel_2_2.add(panel_2_1_4_1_1);

		JLabel HydrabadiChickenBiriyani = new JLabel("Hydrabadi Chicken Biriyani");
		HydrabadiChickenBiriyani.setFont(new Font("Times New Roman", Font.BOLD, 20));
		HydrabadiChickenBiriyani.setBounds(45, 10, 273, 56);
		panel_2_1_4_1_1.add(HydrabadiChickenBiriyani);

		JButton btnNewButton_1_1_4_1_1 = new JButton("ADD");
		btnNewButton_1_1_4_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = HydrabadiChickenBiriyani.getText();
				int price = 300;

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

		JLabel lblRs_2_1_19 = new JLabel("Rs.300/-");
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
		btnNewButton_2.setBounds(627, 604, 209, 58);
		panel_2_2.add(btnNewButton_2);
		
		JLabel lblMainCourse = new JLabel("Main Course");
		lblMainCourse.setFont(new Font("Maiandra GD", Font.BOLD, 35));
		lblMainCourse.setBounds(636, -21, 283, 90);
		panel_2_2.add(lblMainCourse);
	}

}
