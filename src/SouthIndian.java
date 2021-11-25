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
import java.awt.Panel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class SouthIndian extends JFrame {

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
				Maharashtrian.main(null);
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
				NorthIndian.main(null);
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
				Chinese.main(null);
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
		separator_1_1.setBounds(731, 46, 10, 527);
		panel_2_2_1.add(separator_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Veg");
		lblNewLabel_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 35));
		lblNewLabel_2_1.setBounds(322, -14, 95, 90);
		panel_2_2_1.add(lblNewLabel_2_1);
		
		JLabel lblNonveg_1_1 = new JLabel("Non-Veg");
		lblNonveg_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 35));
		lblNonveg_1_1.setBounds(1031, -14, 172, 90);
		panel_2_2_1.add(lblNonveg_1_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("");
		lblNewLabel_1_3_1.setBackground(Color.WHITE);
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_1.setIcon(new ImageIcon(SouthIndian.class.getResource("/Images/APSITO.jpeg")));
		lblNewLabel_1_3_1.setBounds(33, 60, 688, 163);
		panel_2_2_1.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon(SouthIndian.class.getResource("/Images/APSITO.jpeg")));
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
		
		JLabel lblNewLabel_1_2_3_2_1 = new JLabel("Meduvada");
		lblNewLabel_1_2_3_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_3_2_1.setBounds(45, 10, 273, 56);
		panel_2_1_3_2_1.add(lblNewLabel_1_2_3_2_1);
		
		JButton btnNewButton_1_1_3_2_1 = new JButton("ADD");
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
				Orderdetails.main(null);
			}
		});
		btnNewButton_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 30));
		btnNewButton_2_1.setBackground(Color.ORANGE);
		btnNewButton_2_1.setBounds(637, 583, 209, 58);
		panel_2_2_1.add(btnNewButton_2_1);
		
		JButton btnBack_1 = new JButton("");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.main(null);
			}
		});
		btnBack_1.setIcon(new ImageIcon(SouthIndian.class.getResource("/Images/back 3.png")));
		btnBack_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnBack_1.setBackground(Color.WHITE);
		btnBack_1.setBounds(10, 582, 101, 80);
		panel_2_2_1.add(btnBack_1);
		
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
		separator_1.setBounds(731, 46, 10, 552);
		panel_2_2.add(separator_1);
		
		JLabel lblNewLabel_2 = new JLabel("Veg");
		lblNewLabel_2.setFont(new Font("Maiandra GD", Font.BOLD, 35));
		lblNewLabel_2.setBounds(323, -14, 95, 90);
		panel_2_2.add(lblNewLabel_2);
		
		JLabel lblNonveg_1 = new JLabel("Non-Veg");
		lblNonveg_1.setFont(new Font("Maiandra GD", Font.BOLD, 35));
		lblNonveg_1.setBounds(1035, -14, 172, 90);
		panel_2_2.add(lblNonveg_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("");
		lblNewLabel_1_3.setIcon(new ImageIcon(SouthIndian.class.getResource("/Images/APSITO.jpeg")));
		lblNewLabel_1_3.setBounds(33, 55, 688, 163);
		panel_2_2.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(SouthIndian.class.getResource("/Images/APSITO.jpeg")));
		lblNewLabel_1_1_1.setBounds(763, 55, 688, 163);
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
				Orderdetails.main(null);
				 dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Maiandra GD", Font.BOLD, 30));
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.setBounds(627, 604, 209, 58);
		panel_2_2.add(btnNewButton_2);
	}

}
