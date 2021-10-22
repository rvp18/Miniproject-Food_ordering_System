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
import java.awt.event.ActionEvent;

public class Chinese extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chinese frame = new Chinese();
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
	public Chinese() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 20, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btnMaharashtrian = new JButton("Maharashtrian");
		btnMaharashtrian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Maharashtrian.main(null);
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
			}
		});
		btnNorthindian.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnNorthindian.setBackground(Color.ORANGE);
		btnNorthindian.setBounds(184, 10, 194, 38);
		panel.add(btnNorthindian);
		
		JButton btnSouthindian = new JButton("South-Indian");
		btnSouthindian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SouthIndian.main(null);
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
		panel_2_2_1.setLayout(null);
		panel_2_2_1.setBounds(0, 0, 1461, 672);
		panel_1.add(panel_2_2_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setBackground(Color.BLACK);
		separator_1_1.setBounds(731, 14, 10, 569);
		panel_2_2_1.add(separator_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Veg");
		lblNewLabel_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 35));
		lblNewLabel_2_1.setBounds(323, -22, 95, 90);
		panel_2_2_1.add(lblNewLabel_2_1);
		
		JLabel lblNonveg_1_1 = new JLabel("Non-Veg");
		lblNonveg_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 35));
		lblNonveg_1_1.setBounds(1034, -22, 172, 90);
		panel_2_2_1.add(lblNonveg_1_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("");
		lblNewLabel_1_3_1.setIcon(new ImageIcon(Chinese.class.getResource("/Images/Chinese Banner.jpg")));
		lblNewLabel_1_3_1.setBounds(33, 55, 688, 163);
		panel_2_2_1.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon(Chinese.class.getResource("/Images/Chinese Banner.jpg")));
		lblNewLabel_1_1_1_1.setBounds(763, 55, 688, 163);
		panel_2_2_1.add(lblNewLabel_1_1_1_1);
		
		Panel panel_2_1_6_1 = new Panel();
		panel_2_1_6_1.setLayout(null);
		panel_2_1_6_1.setBounds(10, 240, 715, 69);
		panel_2_2_1.add(panel_2_1_6_1);
		
		JLabel lblNewLabel_1_2_6_1 = new JLabel("NAME");
		lblNewLabel_1_2_6_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_6_1.setBounds(10, 10, 273, 56);
		panel_2_1_6_1.add(lblNewLabel_1_2_6_1);
		
		JButton btnNewButton_1_7_1 = new JButton("Remove");
		btnNewButton_1_7_1.setForeground(Color.WHITE);
		btnNewButton_1_7_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_7_1.setBackground(new Color(204, 51, 0));
		btnNewButton_1_7_1.setBounds(584, 20, 110, 36);
		panel_2_1_6_1.add(btnNewButton_1_7_1);
		
		JButton btnNewButton_1_1_6_1 = new JButton("ADD");
		btnNewButton_1_1_6_1.setForeground(Color.WHITE);
		btnNewButton_1_1_6_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_6_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_6_1.setBounds(437, 20, 110, 36);
		panel_2_1_6_1.add(btnNewButton_1_1_6_1);
		
		Panel panel_2_1_1_2_1 = new Panel();
		panel_2_1_1_2_1.setLayout(null);
		panel_2_1_1_2_1.setBounds(10, 309, 715, 69);
		panel_2_2_1.add(panel_2_1_1_2_1);
		
		JLabel lblNewLabel_1_2_1_2_1 = new JLabel("NAME");
		lblNewLabel_1_2_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_1_2_1.setBounds(10, 10, 273, 56);
		panel_2_1_1_2_1.add(lblNewLabel_1_2_1_2_1);
		
		JButton btnNewButton_1_2_2_1 = new JButton("Remove");
		btnNewButton_1_2_2_1.setForeground(Color.WHITE);
		btnNewButton_1_2_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_2_2_1.setBackground(new Color(204, 51, 0));
		btnNewButton_1_2_2_1.setBounds(584, 20, 110, 36);
		panel_2_1_1_2_1.add(btnNewButton_1_2_2_1);
		
		JButton btnNewButton_1_1_1_2_1 = new JButton("ADD");
		btnNewButton_1_1_1_2_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_1_2_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_1_2_1.setBounds(437, 20, 110, 36);
		panel_2_1_1_2_1.add(btnNewButton_1_1_1_2_1);
		
		Panel panel_2_1_2_2_1 = new Panel();
		panel_2_1_2_2_1.setLayout(null);
		panel_2_1_2_2_1.setBounds(10, 378, 715, 69);
		panel_2_2_1.add(panel_2_1_2_2_1);
		
		JLabel lblNewLabel_1_2_2_2_1 = new JLabel("NAME");
		lblNewLabel_1_2_2_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_2_2_1.setBounds(10, 10, 273, 56);
		panel_2_1_2_2_1.add(lblNewLabel_1_2_2_2_1);
		
		JButton btnNewButton_1_3_2_1 = new JButton("Remove");
		btnNewButton_1_3_2_1.setForeground(Color.WHITE);
		btnNewButton_1_3_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_3_2_1.setBackground(new Color(204, 51, 0));
		btnNewButton_1_3_2_1.setBounds(584, 20, 110, 36);
		panel_2_1_2_2_1.add(btnNewButton_1_3_2_1);
		
		JButton btnNewButton_1_1_2_2_1 = new JButton("ADD");
		btnNewButton_1_1_2_2_1.setForeground(Color.WHITE);
		btnNewButton_1_1_2_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_2_2_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_2_2_1.setBounds(437, 20, 110, 36);
		panel_2_1_2_2_1.add(btnNewButton_1_1_2_2_1);
		
		Panel panel_2_1_3_2_1 = new Panel();
		panel_2_1_3_2_1.setLayout(null);
		panel_2_1_3_2_1.setBounds(10, 446, 715, 69);
		panel_2_2_1.add(panel_2_1_3_2_1);
		
		JLabel lblNewLabel_1_2_3_2_1 = new JLabel("NAME");
		lblNewLabel_1_2_3_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_3_2_1.setBounds(10, 10, 273, 56);
		panel_2_1_3_2_1.add(lblNewLabel_1_2_3_2_1);
		
		JButton btnNewButton_1_4_2_1 = new JButton("Remove");
		btnNewButton_1_4_2_1.setForeground(Color.WHITE);
		btnNewButton_1_4_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_4_2_1.setBackground(new Color(204, 51, 0));
		btnNewButton_1_4_2_1.setBounds(584, 20, 110, 36);
		panel_2_1_3_2_1.add(btnNewButton_1_4_2_1);
		
		JButton btnNewButton_1_1_3_2_1 = new JButton("ADD");
		btnNewButton_1_1_3_2_1.setForeground(Color.WHITE);
		btnNewButton_1_1_3_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_3_2_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_3_2_1.setBounds(437, 20, 110, 36);
		panel_2_1_3_2_1.add(btnNewButton_1_1_3_2_1);
		
		Panel panel_2_1_4_2_1 = new Panel();
		panel_2_1_4_2_1.setLayout(null);
		panel_2_1_4_2_1.setBounds(10, 515, 715, 69);
		panel_2_2_1.add(panel_2_1_4_2_1);
		
		JLabel lblNewLabel_1_2_4_2_1 = new JLabel("NAME");
		lblNewLabel_1_2_4_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_4_2_1.setBounds(10, 10, 273, 56);
		panel_2_1_4_2_1.add(lblNewLabel_1_2_4_2_1);
		
		JButton btnNewButton_1_5_2_1 = new JButton("Remove");
		btnNewButton_1_5_2_1.setForeground(Color.WHITE);
		btnNewButton_1_5_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_5_2_1.setBackground(new Color(204, 51, 0));
		btnNewButton_1_5_2_1.setBounds(584, 20, 110, 36);
		panel_2_1_4_2_1.add(btnNewButton_1_5_2_1);
		
		JButton btnNewButton_1_1_4_2_1 = new JButton("ADD");
		btnNewButton_1_1_4_2_1.setForeground(Color.WHITE);
		btnNewButton_1_1_4_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_4_2_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_4_2_1.setBounds(437, 20, 110, 36);
		panel_2_1_4_2_1.add(btnNewButton_1_1_4_2_1);
		
		Panel panel_2_1_5_1_1 = new Panel();
		panel_2_1_5_1_1.setLayout(null);
		panel_2_1_5_1_1.setBounds(744, 240, 715, 69);
		panel_2_2_1.add(panel_2_1_5_1_1);
		
		JLabel lblNewLabel_1_2_5_1_1 = new JLabel("NAME");
		lblNewLabel_1_2_5_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_5_1_1.setBounds(10, 10, 273, 56);
		panel_2_1_5_1_1.add(lblNewLabel_1_2_5_1_1);
		
		JButton btnNewButton_1_6_1_1 = new JButton("Remove");
		btnNewButton_1_6_1_1.setForeground(Color.WHITE);
		btnNewButton_1_6_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_6_1_1.setBackground(new Color(204, 51, 0));
		btnNewButton_1_6_1_1.setBounds(584, 20, 110, 36);
		panel_2_1_5_1_1.add(btnNewButton_1_6_1_1);
		
		JButton btnNewButton_1_1_5_1_1 = new JButton("ADD");
		btnNewButton_1_1_5_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_5_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_5_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_5_1_1.setBounds(437, 20, 110, 36);
		panel_2_1_5_1_1.add(btnNewButton_1_1_5_1_1);
		
		Panel panel_2_1_1_1_1_1 = new Panel();
		panel_2_1_1_1_1_1.setLayout(null);
		panel_2_1_1_1_1_1.setBounds(744, 309, 715, 69);
		panel_2_2_1.add(panel_2_1_1_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("NAME");
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_1_1_1_1.setBounds(10, 10, 273, 56);
		panel_2_1_1_1_1_1.add(lblNewLabel_1_2_1_1_1_1);
		
		JButton btnNewButton_1_2_1_1_1 = new JButton("Remove");
		btnNewButton_1_2_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_2_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_2_1_1_1.setBackground(new Color(204, 51, 0));
		btnNewButton_1_2_1_1_1.setBounds(584, 20, 110, 36);
		panel_2_1_1_1_1_1.add(btnNewButton_1_2_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_1_1_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_1_1_1_1.setBounds(437, 20, 110, 36);
		panel_2_1_1_1_1_1.add(btnNewButton_1_1_1_1_1_1);
		
		Panel panel_2_1_2_1_1_1 = new Panel();
		panel_2_1_2_1_1_1.setLayout(null);
		panel_2_1_2_1_1_1.setBounds(744, 378, 715, 69);
		panel_2_2_1.add(panel_2_1_2_1_1_1);
		
		JLabel lblNewLabel_1_2_2_1_1_1 = new JLabel("NAME");
		lblNewLabel_1_2_2_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_2_1_1_1.setBounds(10, 10, 273, 56);
		panel_2_1_2_1_1_1.add(lblNewLabel_1_2_2_1_1_1);
		
		JButton btnNewButton_1_3_1_1_1 = new JButton("Remove");
		btnNewButton_1_3_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_3_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_3_1_1_1.setBackground(new Color(204, 51, 0));
		btnNewButton_1_3_1_1_1.setBounds(584, 20, 110, 36);
		panel_2_1_2_1_1_1.add(btnNewButton_1_3_1_1_1);
		
		JButton btnNewButton_1_1_2_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_2_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_2_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_2_1_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_2_1_1_1.setBounds(437, 20, 110, 36);
		panel_2_1_2_1_1_1.add(btnNewButton_1_1_2_1_1_1);
		
		Panel panel_2_1_3_1_1_1 = new Panel();
		panel_2_1_3_1_1_1.setLayout(null);
		panel_2_1_3_1_1_1.setBounds(744, 446, 715, 69);
		panel_2_2_1.add(panel_2_1_3_1_1_1);
		
		JLabel lblNewLabel_1_2_3_1_1_1 = new JLabel("NAME");
		lblNewLabel_1_2_3_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_3_1_1_1.setBounds(10, 10, 273, 56);
		panel_2_1_3_1_1_1.add(lblNewLabel_1_2_3_1_1_1);
		
		JButton btnNewButton_1_4_1_1_1 = new JButton("Remove");
		btnNewButton_1_4_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_4_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_4_1_1_1.setBackground(new Color(204, 51, 0));
		btnNewButton_1_4_1_1_1.setBounds(584, 20, 110, 36);
		panel_2_1_3_1_1_1.add(btnNewButton_1_4_1_1_1);
		
		JButton btnNewButton_1_1_3_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_3_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_3_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_3_1_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_3_1_1_1.setBounds(437, 20, 110, 36);
		panel_2_1_3_1_1_1.add(btnNewButton_1_1_3_1_1_1);
		
		Panel panel_2_1_4_1_1_1 = new Panel();
		panel_2_1_4_1_1_1.setLayout(null);
		panel_2_1_4_1_1_1.setBounds(744, 515, 715, 69);
		panel_2_2_1.add(panel_2_1_4_1_1_1);
		
		JLabel lblNewLabel_1_2_4_1_1_1 = new JLabel("NAME");
		lblNewLabel_1_2_4_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_4_1_1_1.setBounds(10, 10, 273, 56);
		panel_2_1_4_1_1_1.add(lblNewLabel_1_2_4_1_1_1);
		
		JButton btnNewButton_1_5_1_1_1 = new JButton("Remove");
		btnNewButton_1_5_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_5_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_5_1_1_1.setBackground(new Color(204, 51, 0));
		btnNewButton_1_5_1_1_1.setBounds(584, 20, 110, 36);
		panel_2_1_4_1_1_1.add(btnNewButton_1_5_1_1_1);
		
		JButton btnNewButton_1_1_4_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_4_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_4_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_4_1_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_4_1_1_1.setBounds(437, 20, 110, 36);
		panel_2_1_4_1_1_1.add(btnNewButton_1_1_4_1_1_1);
		
		JButton btnNewButton_2 = new JButton("Order");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orderdetails.main(null);
			}
		});
		btnNewButton_2.setFont(new Font("Maiandra GD", Font.BOLD, 30));
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.setBounds(624, 593, 209, 58);
		panel_2_2_1.add(btnNewButton_2);
		
		JButton btnBack_1 = new JButton("");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.main(null);
			}
		});
		btnBack_1.setIcon(new ImageIcon(Chinese.class.getResource("/Images/back 3.png")));
		btnBack_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnBack_1.setBackground(Color.WHITE);
		btnBack_1.setBounds(10, 592, 101, 80);
		panel_2_2_1.add(btnBack_1);
		
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
		separator_1_1_1.setBounds(731, 14, 10, 569);
		panel_2_2_1_1.add(separator_1_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Veg");
		lblNewLabel_2_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 35));
		lblNewLabel_2_1_1.setBounds(323, -22, 95, 90);
		panel_2_2_1_1.add(lblNewLabel_2_1_1);
		
		JLabel lblNonveg_1_1_1 = new JLabel("Non-Veg");
		lblNonveg_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 35));
		lblNonveg_1_1_1.setBounds(1034, -22, 172, 90);
		panel_2_2_1_1.add(lblNonveg_1_1_1);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("");
		lblNewLabel_1_3_1_1.setIcon(new ImageIcon(Chinese.class.getResource("/Images/Chinese Banner.jpg")));
		lblNewLabel_1_3_1_1.setBounds(33, 55, 688, 163);
		panel_2_2_1_1.add(lblNewLabel_1_3_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1_1.setIcon(new ImageIcon(Chinese.class.getResource("/Images/Chinese Banner.jpg")));
		lblNewLabel_1_1_1_1_1.setBounds(763, 55, 688, 163);
		panel_2_2_1_1.add(lblNewLabel_1_1_1_1_1);
		
		Panel panel_2_1_6_1_1 = new Panel();
		panel_2_1_6_1_1.setLayout(null);
		panel_2_1_6_1_1.setBounds(10, 240, 715, 69);
		panel_2_2_1_1.add(panel_2_1_6_1_1);
		
		JLabel lblNewLabel_1_2_6_1_1 = new JLabel("NAME");
		lblNewLabel_1_2_6_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_6_1_1.setBounds(10, 10, 273, 56);
		panel_2_1_6_1_1.add(lblNewLabel_1_2_6_1_1);
		
		JButton btnNewButton_1_7_1_1 = new JButton("Remove");
		btnNewButton_1_7_1_1.setForeground(Color.WHITE);
		btnNewButton_1_7_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_7_1_1.setBackground(new Color(204, 51, 0));
		btnNewButton_1_7_1_1.setBounds(584, 20, 110, 36);
		panel_2_1_6_1_1.add(btnNewButton_1_7_1_1);
		
		JButton btnNewButton_1_1_6_1_1 = new JButton("ADD");
		btnNewButton_1_1_6_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_6_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_6_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_6_1_1.setBounds(437, 20, 110, 36);
		panel_2_1_6_1_1.add(btnNewButton_1_1_6_1_1);
		
		Panel panel_2_1_1_2_1_1 = new Panel();
		panel_2_1_1_2_1_1.setLayout(null);
		panel_2_1_1_2_1_1.setBounds(10, 309, 715, 69);
		panel_2_2_1_1.add(panel_2_1_1_2_1_1);
		
		JLabel lblNewLabel_1_2_1_2_1_1 = new JLabel("NAME");
		lblNewLabel_1_2_1_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_1_2_1_1.setBounds(10, 10, 273, 56);
		panel_2_1_1_2_1_1.add(lblNewLabel_1_2_1_2_1_1);
		
		JButton btnNewButton_1_2_2_1_1 = new JButton("Remove");
		btnNewButton_1_2_2_1_1.setForeground(Color.WHITE);
		btnNewButton_1_2_2_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_2_2_1_1.setBackground(new Color(204, 51, 0));
		btnNewButton_1_2_2_1_1.setBounds(584, 20, 110, 36);
		panel_2_1_1_2_1_1.add(btnNewButton_1_2_2_1_1);
		
		JButton btnNewButton_1_1_1_2_1_1 = new JButton("ADD");
		btnNewButton_1_1_1_2_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1_2_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_1_2_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_1_2_1_1.setBounds(437, 20, 110, 36);
		panel_2_1_1_2_1_1.add(btnNewButton_1_1_1_2_1_1);
		
		Panel panel_2_1_2_2_1_1 = new Panel();
		panel_2_1_2_2_1_1.setLayout(null);
		panel_2_1_2_2_1_1.setBounds(10, 378, 715, 69);
		panel_2_2_1_1.add(panel_2_1_2_2_1_1);
		
		JLabel lblNewLabel_1_2_2_2_1_1 = new JLabel("NAME");
		lblNewLabel_1_2_2_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_2_2_1_1.setBounds(10, 10, 273, 56);
		panel_2_1_2_2_1_1.add(lblNewLabel_1_2_2_2_1_1);
		
		JButton btnNewButton_1_3_2_1_1 = new JButton("Remove");
		btnNewButton_1_3_2_1_1.setForeground(Color.WHITE);
		btnNewButton_1_3_2_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_3_2_1_1.setBackground(new Color(204, 51, 0));
		btnNewButton_1_3_2_1_1.setBounds(584, 20, 110, 36);
		panel_2_1_2_2_1_1.add(btnNewButton_1_3_2_1_1);
		
		JButton btnNewButton_1_1_2_2_1_1 = new JButton("ADD");
		btnNewButton_1_1_2_2_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_2_2_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_2_2_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_2_2_1_1.setBounds(437, 20, 110, 36);
		panel_2_1_2_2_1_1.add(btnNewButton_1_1_2_2_1_1);
		
		Panel panel_2_1_3_2_1_1 = new Panel();
		panel_2_1_3_2_1_1.setLayout(null);
		panel_2_1_3_2_1_1.setBounds(10, 446, 715, 69);
		panel_2_2_1_1.add(panel_2_1_3_2_1_1);
		
		JLabel lblNewLabel_1_2_3_2_1_1 = new JLabel("NAME");
		lblNewLabel_1_2_3_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_3_2_1_1.setBounds(10, 10, 273, 56);
		panel_2_1_3_2_1_1.add(lblNewLabel_1_2_3_2_1_1);
		
		JButton btnNewButton_1_4_2_1_1 = new JButton("Remove");
		btnNewButton_1_4_2_1_1.setForeground(Color.WHITE);
		btnNewButton_1_4_2_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_4_2_1_1.setBackground(new Color(204, 51, 0));
		btnNewButton_1_4_2_1_1.setBounds(584, 20, 110, 36);
		panel_2_1_3_2_1_1.add(btnNewButton_1_4_2_1_1);
		
		JButton btnNewButton_1_1_3_2_1_1 = new JButton("ADD");
		btnNewButton_1_1_3_2_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_3_2_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_3_2_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_3_2_1_1.setBounds(437, 20, 110, 36);
		panel_2_1_3_2_1_1.add(btnNewButton_1_1_3_2_1_1);
		
		Panel panel_2_1_4_2_1_1 = new Panel();
		panel_2_1_4_2_1_1.setLayout(null);
		panel_2_1_4_2_1_1.setBounds(10, 515, 715, 69);
		panel_2_2_1_1.add(panel_2_1_4_2_1_1);
		
		JLabel lblNewLabel_1_2_4_2_1_1 = new JLabel("NAME");
		lblNewLabel_1_2_4_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_4_2_1_1.setBounds(10, 10, 273, 56);
		panel_2_1_4_2_1_1.add(lblNewLabel_1_2_4_2_1_1);
		
		JButton btnNewButton_1_5_2_1_1 = new JButton("Remove");
		btnNewButton_1_5_2_1_1.setForeground(Color.WHITE);
		btnNewButton_1_5_2_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_5_2_1_1.setBackground(new Color(204, 51, 0));
		btnNewButton_1_5_2_1_1.setBounds(584, 20, 110, 36);
		panel_2_1_4_2_1_1.add(btnNewButton_1_5_2_1_1);
		
		JButton btnNewButton_1_1_4_2_1_1 = new JButton("ADD");
		btnNewButton_1_1_4_2_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_4_2_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_4_2_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_4_2_1_1.setBounds(437, 20, 110, 36);
		panel_2_1_4_2_1_1.add(btnNewButton_1_1_4_2_1_1);
		
		Panel panel_2_1_5_1_1_1 = new Panel();
		panel_2_1_5_1_1_1.setLayout(null);
		panel_2_1_5_1_1_1.setBounds(744, 240, 715, 69);
		panel_2_2_1_1.add(panel_2_1_5_1_1_1);
		
		JLabel lblNewLabel_1_2_5_1_1_1 = new JLabel("NAME");
		lblNewLabel_1_2_5_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_5_1_1_1.setBounds(10, 10, 273, 56);
		panel_2_1_5_1_1_1.add(lblNewLabel_1_2_5_1_1_1);
		
		JButton btnNewButton_1_6_1_1_1 = new JButton("Remove");
		btnNewButton_1_6_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_6_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_6_1_1_1.setBackground(new Color(204, 51, 0));
		btnNewButton_1_6_1_1_1.setBounds(584, 20, 110, 36);
		panel_2_1_5_1_1_1.add(btnNewButton_1_6_1_1_1);
		
		JButton btnNewButton_1_1_5_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_5_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_5_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_5_1_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_5_1_1_1.setBounds(437, 20, 110, 36);
		panel_2_1_5_1_1_1.add(btnNewButton_1_1_5_1_1_1);
		
		Panel panel_2_1_1_1_1_1_1 = new Panel();
		panel_2_1_1_1_1_1_1.setLayout(null);
		panel_2_1_1_1_1_1_1.setBounds(744, 309, 715, 69);
		panel_2_2_1_1.add(panel_2_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1_1_1 = new JLabel("NAME");
		lblNewLabel_1_2_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_1_1_1_1_1.setBounds(10, 10, 273, 56);
		panel_2_1_1_1_1_1_1.add(lblNewLabel_1_2_1_1_1_1_1);
		
		JButton btnNewButton_1_2_1_1_1_1 = new JButton("Remove");
		btnNewButton_1_2_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_2_1_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_2_1_1_1_1.setBackground(new Color(204, 51, 0));
		btnNewButton_1_2_1_1_1_1.setBounds(584, 20, 110, 36);
		panel_2_1_1_1_1_1_1.add(btnNewButton_1_2_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_1_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1_1_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_1_1_1_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_1_1_1_1_1.setBounds(437, 20, 110, 36);
		panel_2_1_1_1_1_1_1.add(btnNewButton_1_1_1_1_1_1_1);
		
		Panel panel_2_1_2_1_1_1_1 = new Panel();
		panel_2_1_2_1_1_1_1.setLayout(null);
		panel_2_1_2_1_1_1_1.setBounds(744, 378, 715, 69);
		panel_2_2_1_1.add(panel_2_1_2_1_1_1_1);
		
		JLabel lblNewLabel_1_2_2_1_1_1_1 = new JLabel("NAME");
		lblNewLabel_1_2_2_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_2_1_1_1_1.setBounds(10, 10, 273, 56);
		panel_2_1_2_1_1_1_1.add(lblNewLabel_1_2_2_1_1_1_1);
		
		JButton btnNewButton_1_3_1_1_1_1 = new JButton("Remove");
		btnNewButton_1_3_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_3_1_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_3_1_1_1_1.setBackground(new Color(204, 51, 0));
		btnNewButton_1_3_1_1_1_1.setBounds(584, 20, 110, 36);
		panel_2_1_2_1_1_1_1.add(btnNewButton_1_3_1_1_1_1);
		
		JButton btnNewButton_1_1_2_1_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_2_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_2_1_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_2_1_1_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_2_1_1_1_1.setBounds(437, 20, 110, 36);
		panel_2_1_2_1_1_1_1.add(btnNewButton_1_1_2_1_1_1_1);
		
		Panel panel_2_1_3_1_1_1_1 = new Panel();
		panel_2_1_3_1_1_1_1.setLayout(null);
		panel_2_1_3_1_1_1_1.setBounds(744, 446, 715, 69);
		panel_2_2_1_1.add(panel_2_1_3_1_1_1_1);
		
		JLabel lblNewLabel_1_2_3_1_1_1_1 = new JLabel("NAME");
		lblNewLabel_1_2_3_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_3_1_1_1_1.setBounds(10, 10, 273, 56);
		panel_2_1_3_1_1_1_1.add(lblNewLabel_1_2_3_1_1_1_1);
		
		JButton btnNewButton_1_4_1_1_1_1 = new JButton("Remove");
		btnNewButton_1_4_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_4_1_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_4_1_1_1_1.setBackground(new Color(204, 51, 0));
		btnNewButton_1_4_1_1_1_1.setBounds(584, 20, 110, 36);
		panel_2_1_3_1_1_1_1.add(btnNewButton_1_4_1_1_1_1);
		
		JButton btnNewButton_1_1_3_1_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_3_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_3_1_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_3_1_1_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_3_1_1_1_1.setBounds(437, 20, 110, 36);
		panel_2_1_3_1_1_1_1.add(btnNewButton_1_1_3_1_1_1_1);
		
		Panel panel_2_1_4_1_1_1_1 = new Panel();
		panel_2_1_4_1_1_1_1.setLayout(null);
		panel_2_1_4_1_1_1_1.setBounds(744, 515, 715, 69);
		panel_2_2_1_1.add(panel_2_1_4_1_1_1_1);
		
		JLabel lblNewLabel_1_2_4_1_1_1_1 = new JLabel("NAME");
		lblNewLabel_1_2_4_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_4_1_1_1_1.setBounds(10, 10, 273, 56);
		panel_2_1_4_1_1_1_1.add(lblNewLabel_1_2_4_1_1_1_1);
		
		JButton btnNewButton_1_5_1_1_1_1 = new JButton("Remove");
		btnNewButton_1_5_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_5_1_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_5_1_1_1_1.setBackground(new Color(204, 51, 0));
		btnNewButton_1_5_1_1_1_1.setBounds(584, 20, 110, 36);
		panel_2_1_4_1_1_1_1.add(btnNewButton_1_5_1_1_1_1);
		
		JButton btnNewButton_1_1_4_1_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_4_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_4_1_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_4_1_1_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_4_1_1_1_1.setBounds(437, 20, 110, 36);
		panel_2_1_4_1_1_1_1.add(btnNewButton_1_1_4_1_1_1_1);
		
		JButton btnNewButton_2_1 = new JButton("Order");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orderdetails.main(null);
			}
		});
		btnNewButton_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 30));
		btnNewButton_2_1.setBackground(Color.ORANGE);
		btnNewButton_2_1.setBounds(624, 593, 209, 58);
		panel_2_2_1_1.add(btnNewButton_2_1);
	}

}
