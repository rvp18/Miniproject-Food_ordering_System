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

public class Maharashtrian extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private JPanel contentPane;
	public String email;
//	List<String> selectedItems = new ArrayList<String>();
//	
//
//	public List<String> getSelectedItems() {
//		return selectedItems;
//	}
//
//	public void setSelectedItems(List<String> selectedItems) {
//		this.selectedItems = selectedItems;
//	}
//	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Maharashtrian frame = new Maharashtrian("");
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
	public Maharashtrian(String emailId) {

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
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

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
		btnNorthindian.setBounds(0, 10, 194, 38);
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
		btnSouthindian.setBounds(194, 10, 169, 38);
		panel.add(btnSouthindian);

		JButton btnChinese = new JButton("Chinese");
		btnChinese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chinese cp = new Chinese(email);
				cp.setVisible(true);
			}
		});
		btnChinese.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnChinese.setBackground(Color.ORANGE);
		btnChinese.setBounds(363, 10, 106, 38);
		panel.add(btnChinese);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 44, 1466, 699);
		panel.add(tabbedPane);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Starters", null, panel_2, null);
		panel_2.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(731, 63, 10, 509);
		panel_2.add(separator);

		JLabel lblNewLabel = new JLabel("Starters");
		lblNewLabel.setFont(new Font("Maiandra GD", Font.BOLD, 35));
		lblNewLabel.setBounds(670, -15, 200, 90);
		panel_2.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Maharashtrian.class.getResource("/Images/veg maha.jpg")));
		lblNewLabel_1.setBounds(27, 62, 688, 163);
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(Maharashtrian.class.getResource("/Images/non-veg maha.jpg")));
		lblNewLabel_1_1.setBounds(751, 62, 688, 163);
		panel_2.add(lblNewLabel_1_1);

		Panel panel_2_1 = new Panel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(10, 231, 715, 69);
		panel_2.add(panel_2_1);

		JLabel MasalaPapad = new JLabel("Masala Papad");
		MasalaPapad.setFont(new Font("Times New Roman", Font.BOLD, 20));
		MasalaPapad.setBounds(45, 10, 273, 56);
		panel_2_1.add(MasalaPapad);

		JButton btnNewButton_1_1 = new JButton("ADD");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.println("email recive from Log in page in masala papad Add action :" + email);                   
				String item = MasalaPapad.getText();
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
//				selectedItems.add("Masala Papad");
			}
		});
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1.setBounds(532, 20, 110, 36);
		panel_2_1.add(btnNewButton_1_1);

		JLabel lblRs_2_1 = new JLabel("Rs.50/-");
		lblRs_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1.setBounds(377, 8, 103, 56);
		panel_2_1.add(lblRs_2_1);

		Panel panel_2_1_1 = new Panel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBounds(10, 300, 715, 69);
		panel_2.add(panel_2_1_1);

		JLabel lblRs_2_2 = new JLabel("Rs.60/-");
		lblRs_2_2.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_2.setBounds(374, 10, 103, 56);
		panel_2_1_1.add(lblRs_2_2);

		JLabel MixBhaji = new JLabel("Mix Bhaji");
		MixBhaji.setBounds(45, 10, 273, 56);
		panel_2_1_1.add(MixBhaji);
		MixBhaji.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JButton btnNewButton_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = MixBhaji.getText();
				int price = 60;

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
//				selectedItems.add("Mix Bhaji");
			}
		});
		btnNewButton_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_1.setBounds(530, 22, 110, 36);
		panel_2_1_1.add(btnNewButton_1_1_1);

		Panel panel_2_1_2 = new Panel();
		panel_2_1_2.setLayout(null);
		panel_2_1_2.setBounds(10, 369, 715, 69);
		panel_2.add(panel_2_1_2);

		JLabel lblRs_2_3 = new JLabel("Rs.70/-");
		lblRs_2_3.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_3.setBounds(374, 8, 103, 56);
		panel_2_1_2.add(lblRs_2_3);

		JLabel MoogVada = new JLabel("Moog Vada");
		MoogVada.setBounds(45, 10, 273, 56);
		panel_2_1_2.add(MoogVada);
		MoogVada.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JButton btnNewButton_1_1_2 = new JButton("ADD");
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = MoogVada.getText();
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
//				selectedItems.add("Moog Vada");
			}
		});
		btnNewButton_1_1_2.setForeground(Color.WHITE);
		btnNewButton_1_1_2.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_2.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_2.setBounds(529, 20, 110, 36);
		panel_2_1_2.add(btnNewButton_1_1_2);

		Panel panel_2_1_3 = new Panel();
		panel_2_1_3.setLayout(null);
		panel_2_1_3.setBounds(10, 437, 715, 69);
		panel_2.add(panel_2_1_3);

		JLabel ChanaKoliwada = new JLabel("Chana Koliwada");
		ChanaKoliwada.setBounds(45, 10, 273, 56);
		panel_2_1_3.add(ChanaKoliwada);
		ChanaKoliwada.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JButton btnNewButton_1_1_3 = new JButton("ADD");
		btnNewButton_1_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = ChanaKoliwada.getText();
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
		btnNewButton_1_1_3.setForeground(Color.WHITE);
		btnNewButton_1_1_3.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_3.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_3.setBounds(529, 20, 110, 36);
		panel_2_1_3.add(btnNewButton_1_1_3);

		JLabel lblRs_2_3_1 = new JLabel("Rs.80/-");
		lblRs_2_3_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_3_1.setBounds(372, 8, 103, 56);
		panel_2_1_3.add(lblRs_2_3_1);

		Panel panel_2_1_4 = new Panel();
		panel_2_1_4.setLayout(null);
		panel_2_1_4.setBounds(10, 506, 715, 69);
		panel_2.add(panel_2_1_4);

		JLabel lblRs_2_3_2 = new JLabel("Rs.100/-");
		lblRs_2_3_2.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_3_2.setBounds(368, 10, 103, 56);
		panel_2_1_4.add(lblRs_2_3_2);

		JLabel MalvaniPaneerTikka = new JLabel("Malvani Paneer Tikka ");
		MalvaniPaneerTikka.setBounds(45, 10, 273, 56);
		panel_2_1_4.add(MalvaniPaneerTikka);
		MalvaniPaneerTikka.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JButton btnNewButton_1_1_4 = new JButton("ADD");
		btnNewButton_1_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = MalvaniPaneerTikka.getText();
				int price = 100;

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
		btnNewButton_1_1_4.setForeground(Color.WHITE);
		btnNewButton_1_1_4.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_4.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_4.setBounds(529, 22, 110, 36);
		panel_2_1_4.add(btnNewButton_1_1_4);

		Panel panel_2_1_5 = new Panel();
		panel_2_1_5.setLayout(null);
		panel_2_1_5.setBounds(744, 231, 715, 69);
		panel_2.add(panel_2_1_5);

		JLabel ChickenFry = new JLabel("Chicken Fry");
		ChickenFry.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ChickenFry.setBounds(45, 10, 273, 56);
		panel_2_1_5.add(ChickenFry);

		JButton btnNewButton_1_1_5 = new JButton("ADD");
		btnNewButton_1_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = ChickenFry.getText();
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
		btnNewButton_1_1_5.setForeground(Color.WHITE);
		btnNewButton_1_1_5.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_5.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_5.setBounds(529, 22, 110, 36);
		panel_2_1_5.add(btnNewButton_1_1_5);

		JLabel lblRs_2_3_3 = new JLabel("Rs.150/-");
		lblRs_2_3_3.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_3_3.setBounds(351, 8, 103, 56);
		panel_2_1_5.add(lblRs_2_3_3);

		Panel panel_2_1_1_1 = new Panel();
		panel_2_1_1_1.setLayout(null);
		panel_2_1_1_1.setBounds(744, 300, 715, 69);
		panel_2.add(panel_2_1_1_1);

		JLabel MuttonFry = new JLabel("Mutton Fry");
		MuttonFry.setFont(new Font("Times New Roman", Font.BOLD, 20));
		MuttonFry.setBounds(45, 10, 273, 56);
		panel_2_1_1_1.add(MuttonFry);

		JButton btnNewButton_1_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = MuttonFry.getText();
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
		btnNewButton_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_1_1.setBounds(529, 22, 110, 36);
		panel_2_1_1_1.add(btnNewButton_1_1_1_1);

		JLabel lblRs_2_3_4 = new JLabel("Rs.150/-");
		lblRs_2_3_4.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_3_4.setBounds(351, 8, 103, 56);
		panel_2_1_1_1.add(lblRs_2_3_4);

		Panel panel_2_1_2_1 = new Panel();
		panel_2_1_2_1.setLayout(null);
		panel_2_1_2_1.setBounds(744, 369, 715, 69);
		panel_2.add(panel_2_1_2_1);

		JLabel PrawnsFry = new JLabel("Prawns Fry");
		PrawnsFry.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PrawnsFry.setBounds(45, 10, 273, 56);
		panel_2_1_2_1.add(PrawnsFry);

		JButton btnNewButton_1_1_2_1 = new JButton("ADD");
		btnNewButton_1_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = PrawnsFry.getText();
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
		btnNewButton_1_1_2_1.setForeground(Color.WHITE);
		btnNewButton_1_1_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_2_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_2_1.setBounds(529, 22, 110, 36);
		panel_2_1_2_1.add(btnNewButton_1_1_2_1);

		JLabel lblRs_2_3_5 = new JLabel("Rs.170/-");
		lblRs_2_3_5.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_3_5.setBounds(353, 8, 103, 56);
		panel_2_1_2_1.add(lblRs_2_3_5);

		Panel panel_2_1_3_1 = new Panel();
		panel_2_1_3_1.setLayout(null);
		panel_2_1_3_1.setBounds(744, 437, 715, 69);
		panel_2.add(panel_2_1_3_1);

		JLabel SurmaiFry = new JLabel("Surmai Fry");
		SurmaiFry.setFont(new Font("Times New Roman", Font.BOLD, 20));
		SurmaiFry.setBounds(45, 10, 273, 56);
		panel_2_1_3_1.add(SurmaiFry);

		JButton btnNewButton_1_1_3_1 = new JButton("ADD");
		btnNewButton_1_1_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = SurmaiFry.getText();
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
		btnNewButton_1_1_3_1.setForeground(Color.WHITE);
		btnNewButton_1_1_3_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_3_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_3_1.setBounds(529, 22, 110, 36);
		panel_2_1_3_1.add(btnNewButton_1_1_3_1);

		JLabel lblRs_2_3_6 = new JLabel("Rs.180/-");
		lblRs_2_3_6.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_3_6.setBounds(354, 8, 103, 56);
		panel_2_1_3_1.add(lblRs_2_3_6);

		Panel panel_2_1_4_1 = new Panel();
		panel_2_1_4_1.setLayout(null);
		panel_2_1_4_1.setBounds(744, 506, 715, 69);
		panel_2.add(panel_2_1_4_1);

		JLabel PomfretFry = new JLabel("Pomfret Fry");
		PomfretFry.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PomfretFry.setBounds(45, 10, 273, 56);
		panel_2_1_4_1.add(PomfretFry);

		JButton btnNewButton_1_1_4_1 = new JButton("ADD");
		btnNewButton_1_1_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = PomfretFry.getText();
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
		btnNewButton_1_1_4_1.setForeground(Color.WHITE);
		btnNewButton_1_1_4_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_4_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_4_1.setBounds(529, 22, 110, 36);
		panel_2_1_4_1.add(btnNewButton_1_1_4_1);

		JLabel lblRs_2_3_7 = new JLabel("Rs.200/-");
		lblRs_2_3_7.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_3_7.setBounds(354, 8, 103, 56);
		panel_2_1_4_1.add(lblRs_2_3_7);

		JButton btnNewButton_2 = new JButton("Order");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Orderdetails odp = new Orderdetails(email);
				odp.setVisible(true);

				dispose();
			}
		});
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.setFont(new Font("Maiandra GD", Font.BOLD, 30));
		btnNewButton_2.setBounds(634, 593, 209, 58);
		panel_2.add(btnNewButton_2);

		JButton btnBack_1 = new JButton("");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home hp = new Home(email);
				hp.setVisible(true);
				dispose();
			}
		});
		btnBack_1.setIcon(new ImageIcon(Maharashtrian.class.getResource("/Images/back 3.png")));
		btnBack_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnBack_1.setBackground(Color.WHITE);
		btnBack_1.setBounds(10, 582, 101, 80);
		panel_2.add(btnBack_1);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Main", null, panel_1, null);
		panel_1.setLayout(null);

		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBackground(Color.WHITE);
		panel_2_2.setLayout(null);
		panel_2_2.setBounds(0, 0, 1461, 672);
		panel_1.add(panel_2_2);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(735, 210, 10, 384);
		panel_2_2.add(separator_1);

		JLabel lblNewLabel_1_3 = new JLabel("");
		lblNewLabel_1_3.setIcon(new ImageIcon(Maharashtrian.class.getResource("/Images/veg maha.jpg")));
		lblNewLabel_1_3.setBounds(33, 65, 688, 163);
		panel_2_2.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(Maharashtrian.class.getResource("/Images/non-veg maha.jpg")));
		lblNewLabel_1_1_1.setBounds(763, 65, 688, 163);
		panel_2_2.add(lblNewLabel_1_1_1);

		Panel panel_2_1_6 = new Panel();
		panel_2_1_6.setLayout(null);
		panel_2_1_6.setBounds(10, 250, 715, 69);
		panel_2_2.add(panel_2_1_6);

		JLabel DalFry = new JLabel("Dal Fry");
		DalFry.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		DalFry.setBounds(45, 10, 273, 56);
		panel_2_1_6.add(DalFry);

		JLabel lblRs_4 = new JLabel("Rs.130/-");
		lblRs_4.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_4.setBounds(377, 8, 103, 56);
		panel_2_1_6.add(lblRs_4);

		JButton btnNewButton_1_1_6 = new JButton("ADD");
		btnNewButton_1_1_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = DalFry.getText();
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
		btnNewButton_1_1_6.setForeground(Color.WHITE);
		btnNewButton_1_1_6.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_6.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_6.setBounds(529, 22, 110, 36);
		panel_2_1_6.add(btnNewButton_1_1_6);

		Panel panel_2_1_1_2 = new Panel();
		panel_2_1_1_2.setLayout(null);
		panel_2_1_1_2.setBounds(10, 319, 715, 69);
		panel_2_2.add(panel_2_1_1_2);

		JLabel lblRs_3 = new JLabel("Rs.150/-");
		lblRs_3.setBounds(377, 8, 103, 56);
		panel_2_1_1_2.add(lblRs_3);
		lblRs_3.setFont(new Font("Maiandra GD", Font.BOLD, 20));

		JLabel VegThali = new JLabel("Veg Thali");
		VegThali.setBounds(45, 10, 273, 56);
		panel_2_1_1_2.add(VegThali);
		VegThali.setFont(new Font("Maiandra GD", Font.BOLD, 20));

		JButton btnNewButton_1_1_1_2 = new JButton("ADD");
		btnNewButton_1_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = VegThali.getText();
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
		btnNewButton_1_1_1_2.setForeground(Color.WHITE);
		btnNewButton_1_1_1_2.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_1_2.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_1_2.setBounds(529, 22, 110, 36);
		panel_2_1_1_2.add(btnNewButton_1_1_1_2);

		Panel panel_2_1_2_2 = new Panel();
		panel_2_1_2_2.setLayout(null);
		panel_2_1_2_2.setBounds(10, 388, 715, 69);
		panel_2_2.add(panel_2_1_2_2);

		JLabel VegKolhapuri = new JLabel("Veg Kolhapuri");
		VegKolhapuri.setBounds(45, 10, 270, 56);
		panel_2_1_2_2.add(VegKolhapuri);
		VegKolhapuri.setFont(new Font("Maiandra GD", Font.BOLD, 20));

		JLabel lblRs = new JLabel("Rs.150/-");
		lblRs.setBounds(377, 8, 103, 56);
		panel_2_1_2_2.add(lblRs);
		lblRs.setFont(new Font("Maiandra GD", Font.BOLD, 20));

		JButton btnNewButton_1_1_2_2 = new JButton("ADD");
		btnNewButton_1_1_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = VegKolhapuri.getText();
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
		btnNewButton_1_1_2_2.setForeground(Color.WHITE);
		btnNewButton_1_1_2_2.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_2_2.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_2_2.setBounds(529, 22, 110, 36);
		panel_2_1_2_2.add(btnNewButton_1_1_2_2);

		Panel panel_2_1_3_2 = new Panel();
		panel_2_1_3_2.setLayout(null);
		panel_2_1_3_2.setBounds(10, 456, 715, 69);
		panel_2_2.add(panel_2_1_3_2);

		JLabel MushroomMasala = new JLabel("Mushroom Masala");
		MushroomMasala.setBounds(45, 10, 273, 56);
		panel_2_1_3_2.add(MushroomMasala);
		MushroomMasala.setFont(new Font("Maiandra GD", Font.BOLD, 20));

		JButton btnNewButton_1_1_3_2 = new JButton("ADD");
		btnNewButton_1_1_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String item = MushroomMasala.getText();
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
		btnNewButton_1_1_3_2.setForeground(Color.WHITE);
		btnNewButton_1_1_3_2.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_3_2.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_3_2.setBounds(529, 22, 110, 36);
		panel_2_1_3_2.add(btnNewButton_1_1_3_2);

		JLabel lblRs_2 = new JLabel("Rs.170/-");
		lblRs_2.setBounds(377, 8, 103, 56);
		panel_2_1_3_2.add(lblRs_2);
		lblRs_2.setFont(new Font("Maiandra GD", Font.BOLD, 20));

		Panel panel_2_1_4_2 = new Panel();
		panel_2_1_4_2.setLayout(null);
		panel_2_1_4_2.setBounds(10, 525, 715, 69);
		panel_2_2.add(panel_2_1_4_2);

		JLabel KajuMalvaniMasala = new JLabel("Kaju Malvani Masala");
		KajuMalvaniMasala.setBounds(45, 10, 276, 56);
		panel_2_1_4_2.add(KajuMalvaniMasala);
		KajuMalvaniMasala.setFont(new Font("Maiandra GD", Font.BOLD, 20));

		JButton btnNewButton_1_1_4_2 = new JButton("ADD");
		btnNewButton_1_1_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = KajuMalvaniMasala.getText();
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
		btnNewButton_1_1_4_2.setForeground(Color.WHITE);
		btnNewButton_1_1_4_2.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_4_2.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_4_2.setBounds(529, 22, 110, 36);
		panel_2_1_4_2.add(btnNewButton_1_1_4_2);

		JLabel lblRs_10 = new JLabel("Rs.200/-");
		lblRs_10.setBounds(377, 8, 103, 56);
		panel_2_1_4_2.add(lblRs_10);
		lblRs_10.setFont(new Font("Maiandra GD", Font.BOLD, 20));

		Panel panel_2_1_5_1 = new Panel();
		panel_2_1_5_1.setLayout(null);
		panel_2_1_5_1.setBounds(744, 250, 715, 69);
		panel_2_2.add(panel_2_1_5_1);

		JLabel ChickenHandi = new JLabel("Chicken Handi");
		ChickenHandi.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		ChickenHandi.setBounds(45, 10, 273, 56);
		panel_2_1_5_1.add(ChickenHandi);

		JButton btnNewButton_1_1_5_1 = new JButton("ADD");
		btnNewButton_1_1_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = ChickenHandi.getText();
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
		btnNewButton_1_1_5_1.setForeground(Color.WHITE);
		btnNewButton_1_1_5_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_5_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_5_1.setBounds(529, 22, 110, 36);
		panel_2_1_5_1.add(btnNewButton_1_1_5_1);

		JLabel lblRs_5 = new JLabel("Rs.300/-");
		lblRs_5.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_5.setBounds(377, 8, 103, 56);
		panel_2_1_5_1.add(lblRs_5);

		Panel panel_2_1_1_1_1 = new Panel();
		panel_2_1_1_1_1.setLayout(null);
		panel_2_1_1_1_1.setBounds(744, 319, 715, 69);
		panel_2_2.add(panel_2_1_1_1_1);

		JLabel ChickenMalvani = new JLabel("Chicken Malvani");
		ChickenMalvani.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		ChickenMalvani.setBounds(45, 10, 273, 56);
		panel_2_1_1_1_1.add(ChickenMalvani);

		JButton btnNewButton_1_1_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = ChickenMalvani.getText();
				int price = 350;

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

		JLabel lblRs_6 = new JLabel("Rs.350/-");
		lblRs_6.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_6.setBounds(374, 10, 103, 56);
		panel_2_1_1_1_1.add(lblRs_6);

		Panel panel_2_1_2_1_1 = new Panel();
		panel_2_1_2_1_1.setLayout(null);
		panel_2_1_2_1_1.setBounds(744, 388, 715, 69);
		panel_2_2.add(panel_2_1_2_1_1);

		JLabel ChickenKolhapuri = new JLabel("Chicken Kolhapuri");
		ChickenKolhapuri.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		ChickenKolhapuri.setBounds(45, 10, 273, 56);
		panel_2_1_2_1_1.add(ChickenKolhapuri);

		JButton btnNewButton_1_1_2_1_1 = new JButton("ADD");
		btnNewButton_1_1_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = ChickenKolhapuri.getText();
				int price = 370;

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

		JLabel lblRs_7 = new JLabel("Rs.370/-");
		lblRs_7.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_7.setBounds(377, 8, 103, 56);
		panel_2_1_2_1_1.add(lblRs_7);

		Panel panel_2_1_3_1_1 = new Panel();
		panel_2_1_3_1_1.setLayout(null);
		panel_2_1_3_1_1.setBounds(744, 456, 715, 69);
		panel_2_2.add(panel_2_1_3_1_1);

		JLabel PrawnsMasala = new JLabel("Prawns Masala");
		PrawnsMasala.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		PrawnsMasala.setBounds(45, 10, 273, 56);
		panel_2_1_3_1_1.add(PrawnsMasala);

		JButton btnNewButton_1_1_3_1_1 = new JButton("ADD");
		btnNewButton_1_1_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = PrawnsMasala.getText();
				int price = 370;

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

		JLabel lblRs_8 = new JLabel("Rs.370/-");
		lblRs_8.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_8.setBounds(377, 8, 103, 56);
		panel_2_1_3_1_1.add(lblRs_8);

		Panel panel_2_1_4_1_1 = new Panel();
		panel_2_1_4_1_1.setLayout(null);
		panel_2_1_4_1_1.setBounds(744, 525, 715, 69);
		panel_2_2.add(panel_2_1_4_1_1);

		JLabel PomfretMasala = new JLabel("Pomfret Masala");
		PomfretMasala.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		PomfretMasala.setBounds(45, 10, 273, 56);
		panel_2_1_4_1_1.add(PomfretMasala);

		JButton btnNewButton_1_1_4_1_1 = new JButton("ADD");
		btnNewButton_1_1_4_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = PomfretMasala.getText();
				int price = 390;

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

		JLabel lblRs_9 = new JLabel("Rs.390/-");
		lblRs_9.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_9.setBounds(377, 8, 103, 56);
		panel_2_1_4_1_1.add(lblRs_9);

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
		btnNewButton_2_1.setBounds(640, 604, 209, 58);
		panel_2_2.add(btnNewButton_2_1);
		
		JLabel lblMainCourse = new JLabel("Main Course");
		lblMainCourse.setFont(new Font("Maiandra GD", Font.BOLD, 35));
		lblMainCourse.setBounds(640, -12, 283, 90);
		panel_2_2.add(lblMainCourse);

	}
}
