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
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Maharashtrian extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Maharashtrian frame = new Maharashtrian();
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
	public Maharashtrian() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNorthindian = new JButton("North-Indian");
		btnNorthindian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NorthIndian.main(null);
			}
		});
		btnNorthindian.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnNorthindian.setBackground(Color.ORANGE);
		btnNorthindian.setBounds(0, 10, 194, 38);
		panel.add(btnNorthindian);
		
		JButton btnSouthindian = new JButton("South-Indian");
		btnSouthindian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SouthIndian.main(null);
			}
		});
		btnSouthindian.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnSouthindian.setBackground(Color.ORANGE);
		btnSouthindian.setBounds(194, 10, 169, 38);
		panel.add(btnSouthindian);
		
		JButton btnChinese = new JButton("Chinese");
		btnChinese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chinese.main(null);
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
		separator.setBounds(731, 46, 10, 526);
		panel_2.add(separator);
		
		JLabel lblNewLabel = new JLabel("Veg");
		lblNewLabel.setFont(new Font("Maiandra GD", Font.BOLD, 35));
		lblNewLabel.setBounds(324, -13, 95, 90);
		panel_2.add(lblNewLabel);
		
		JLabel lblNonveg = new JLabel("Non-Veg");
		lblNonveg.setFont(new Font("Maiandra GD", Font.BOLD, 35));
		lblNonveg.setBounds(1033, -13, 172, 90);
		panel_2.add(lblNonveg);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Maharashtrian.class.getResource("/Images/off1.jpg")));
		lblNewLabel_1.setBounds(33, 62, 688, 163);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(Maharashtrian.class.getResource("/Images/off1.jpg")));
		lblNewLabel_1_1.setBounds(751, 62, 688, 163);
		panel_2.add(lblNewLabel_1_1);
		
		Panel panel_2_1 = new Panel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(10, 231, 715, 69);
		panel_2.add(panel_2_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("NAME");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(10, 10, 273, 56);
		panel_2_1.add(lblNewLabel_1_2);
		
		JButton btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1.setBackground(new Color(204, 51, 0));
		btnNewButton_1.setBounds(584, 20, 110, 36);
		panel_2_1.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("ADD");
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1.setBounds(437, 20, 110, 36);
		panel_2_1.add(btnNewButton_1_1);
		
		Panel panel_2_1_1 = new Panel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBounds(10, 300, 715, 69);
		panel_2.add(panel_2_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("NAME");
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_1.setBounds(10, 10, 273, 56);
		panel_2_1_1.add(lblNewLabel_1_2_1);
		
		JButton btnNewButton_1_2 = new JButton("Remove");
		btnNewButton_1_2.setForeground(Color.WHITE);
		btnNewButton_1_2.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_2.setBackground(new Color(204, 51, 0));
		btnNewButton_1_2.setBounds(584, 20, 110, 36);
		panel_2_1_1.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_1.setBounds(437, 20, 110, 36);
		panel_2_1_1.add(btnNewButton_1_1_1);
		
		Panel panel_2_1_2 = new Panel();
		panel_2_1_2.setLayout(null);
		panel_2_1_2.setBounds(10, 369, 715, 69);
		panel_2.add(panel_2_1_2);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("NAME");
		lblNewLabel_1_2_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_2.setBounds(10, 10, 273, 56);
		panel_2_1_2.add(lblNewLabel_1_2_2);
		
		JButton btnNewButton_1_3 = new JButton("Remove");
		btnNewButton_1_3.setForeground(Color.WHITE);
		btnNewButton_1_3.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_3.setBackground(new Color(204, 51, 0));
		btnNewButton_1_3.setBounds(584, 20, 110, 36);
		panel_2_1_2.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_1_2 = new JButton("ADD");
		btnNewButton_1_1_2.setForeground(Color.WHITE);
		btnNewButton_1_1_2.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_2.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_2.setBounds(437, 20, 110, 36);
		panel_2_1_2.add(btnNewButton_1_1_2);
		
		Panel panel_2_1_3 = new Panel();
		panel_2_1_3.setLayout(null);
		panel_2_1_3.setBounds(10, 437, 715, 69);
		panel_2.add(panel_2_1_3);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("NAME");
		lblNewLabel_1_2_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_3.setBounds(10, 10, 273, 56);
		panel_2_1_3.add(lblNewLabel_1_2_3);
		
		JButton btnNewButton_1_4 = new JButton("Remove");
		btnNewButton_1_4.setForeground(Color.WHITE);
		btnNewButton_1_4.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_4.setBackground(new Color(204, 51, 0));
		btnNewButton_1_4.setBounds(584, 20, 110, 36);
		panel_2_1_3.add(btnNewButton_1_4);
		
		JButton btnNewButton_1_1_3 = new JButton("ADD");
		btnNewButton_1_1_3.setForeground(Color.WHITE);
		btnNewButton_1_1_3.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_3.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_3.setBounds(437, 20, 110, 36);
		panel_2_1_3.add(btnNewButton_1_1_3);
		
		Panel panel_2_1_4 = new Panel();
		panel_2_1_4.setLayout(null);
		panel_2_1_4.setBounds(10, 506, 715, 69);
		panel_2.add(panel_2_1_4);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("NAME");
		lblNewLabel_1_2_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_4.setBounds(10, 10, 273, 56);
		panel_2_1_4.add(lblNewLabel_1_2_4);
		
		JButton btnNewButton_1_5 = new JButton("Remove");
		btnNewButton_1_5.setForeground(Color.WHITE);
		btnNewButton_1_5.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_5.setBackground(new Color(204, 51, 0));
		btnNewButton_1_5.setBounds(584, 20, 110, 36);
		panel_2_1_4.add(btnNewButton_1_5);
		
		JButton btnNewButton_1_1_4 = new JButton("ADD");
		btnNewButton_1_1_4.setForeground(Color.WHITE);
		btnNewButton_1_1_4.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_4.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_4.setBounds(437, 20, 110, 36);
		panel_2_1_4.add(btnNewButton_1_1_4);
		
		Panel panel_2_1_5 = new Panel();
		panel_2_1_5.setLayout(null);
		panel_2_1_5.setBounds(744, 231, 715, 69);
		panel_2.add(panel_2_1_5);
		
		JLabel lblNewLabel_1_2_5 = new JLabel("NAME");
		lblNewLabel_1_2_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_5.setBounds(10, 10, 273, 56);
		panel_2_1_5.add(lblNewLabel_1_2_5);
		
		JButton btnNewButton_1_6 = new JButton("Remove");
		btnNewButton_1_6.setForeground(Color.WHITE);
		btnNewButton_1_6.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_6.setBackground(new Color(204, 51, 0));
		btnNewButton_1_6.setBounds(584, 20, 110, 36);
		panel_2_1_5.add(btnNewButton_1_6);
		
		JButton btnNewButton_1_1_5 = new JButton("ADD");
		btnNewButton_1_1_5.setForeground(Color.WHITE);
		btnNewButton_1_1_5.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_5.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_5.setBounds(437, 20, 110, 36);
		panel_2_1_5.add(btnNewButton_1_1_5);
		
		Panel panel_2_1_1_1 = new Panel();
		panel_2_1_1_1.setLayout(null);
		panel_2_1_1_1.setBounds(744, 300, 715, 69);
		panel_2.add(panel_2_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("NAME");
		lblNewLabel_1_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_1_1.setBounds(10, 10, 273, 56);
		panel_2_1_1_1.add(lblNewLabel_1_2_1_1);
		
		JButton btnNewButton_1_2_1 = new JButton("Remove");
		btnNewButton_1_2_1.setForeground(Color.WHITE);
		btnNewButton_1_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_2_1.setBackground(new Color(204, 51, 0));
		btnNewButton_1_2_1.setBounds(584, 20, 110, 36);
		panel_2_1_1_1.add(btnNewButton_1_2_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_1_1.setBounds(437, 20, 110, 36);
		panel_2_1_1_1.add(btnNewButton_1_1_1_1);
		
		Panel panel_2_1_2_1 = new Panel();
		panel_2_1_2_1.setLayout(null);
		panel_2_1_2_1.setBounds(744, 369, 715, 69);
		panel_2.add(panel_2_1_2_1);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("NAME");
		lblNewLabel_1_2_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_2_1.setBounds(10, 10, 273, 56);
		panel_2_1_2_1.add(lblNewLabel_1_2_2_1);
		
		JButton btnNewButton_1_3_1 = new JButton("Remove");
		btnNewButton_1_3_1.setForeground(Color.WHITE);
		btnNewButton_1_3_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_3_1.setBackground(new Color(204, 51, 0));
		btnNewButton_1_3_1.setBounds(584, 20, 110, 36);
		panel_2_1_2_1.add(btnNewButton_1_3_1);
		
		JButton btnNewButton_1_1_2_1 = new JButton("ADD");
		btnNewButton_1_1_2_1.setForeground(Color.WHITE);
		btnNewButton_1_1_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_2_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_2_1.setBounds(437, 20, 110, 36);
		panel_2_1_2_1.add(btnNewButton_1_1_2_1);
		
		Panel panel_2_1_3_1 = new Panel();
		panel_2_1_3_1.setLayout(null);
		panel_2_1_3_1.setBounds(744, 437, 715, 69);
		panel_2.add(panel_2_1_3_1);
		
		JLabel lblNewLabel_1_2_3_1 = new JLabel("NAME");
		lblNewLabel_1_2_3_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_3_1.setBounds(10, 10, 273, 56);
		panel_2_1_3_1.add(lblNewLabel_1_2_3_1);
		
		JButton btnNewButton_1_4_1 = new JButton("Remove");
		btnNewButton_1_4_1.setForeground(Color.WHITE);
		btnNewButton_1_4_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_4_1.setBackground(new Color(204, 51, 0));
		btnNewButton_1_4_1.setBounds(584, 20, 110, 36);
		panel_2_1_3_1.add(btnNewButton_1_4_1);
		
		JButton btnNewButton_1_1_3_1 = new JButton("ADD");
		btnNewButton_1_1_3_1.setForeground(Color.WHITE);
		btnNewButton_1_1_3_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_3_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_3_1.setBounds(437, 20, 110, 36);
		panel_2_1_3_1.add(btnNewButton_1_1_3_1);
		
		Panel panel_2_1_4_1 = new Panel();
		panel_2_1_4_1.setLayout(null);
		panel_2_1_4_1.setBounds(744, 506, 715, 69);
		panel_2.add(panel_2_1_4_1);
		
		JLabel lblNewLabel_1_2_4_1 = new JLabel("NAME");
		lblNewLabel_1_2_4_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_4_1.setBounds(10, 10, 273, 56);
		panel_2_1_4_1.add(lblNewLabel_1_2_4_1);
		
		JButton btnNewButton_1_5_1 = new JButton("Remove");
		btnNewButton_1_5_1.setForeground(Color.WHITE);
		btnNewButton_1_5_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_5_1.setBackground(new Color(204, 51, 0));
		btnNewButton_1_5_1.setBounds(584, 20, 110, 36);
		panel_2_1_4_1.add(btnNewButton_1_5_1);
		
		JButton btnNewButton_1_1_4_1 = new JButton("ADD");
		btnNewButton_1_1_4_1.setForeground(Color.WHITE);
		btnNewButton_1_1_4_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_4_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_4_1.setBounds(437, 20, 110, 36);
		panel_2_1_4_1.add(btnNewButton_1_1_4_1);
		
		JButton btnNewButton_2 = new JButton("Order");
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.setFont(new Font("Maiandra GD", Font.BOLD, 30));
		btnNewButton_2.setBounds(634, 593, 209, 58);
		panel_2.add(btnNewButton_2);
		
		JButton btnBack_1 = new JButton("");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.main(null);
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
		panel_2_2.setLayout(null);
		panel_2_2.setBounds(0, 0, 1461, 672);
		panel_1.add(panel_2_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(731, 46, 10, 548);
		panel_2_2.add(separator_1);
		
		JLabel lblNewLabel_2 = new JLabel("Veg");
		lblNewLabel_2.setFont(new Font("Maiandra GD", Font.BOLD, 35));
		lblNewLabel_2.setBounds(323, -12, 95, 90);
		panel_2_2.add(lblNewLabel_2);
		
		JLabel lblNonveg_1 = new JLabel("Non-Veg");
		lblNonveg_1.setFont(new Font("Maiandra GD", Font.BOLD, 35));
		lblNonveg_1.setBounds(1034, -12, 172, 90);
		panel_2_2.add(lblNonveg_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("");
		lblNewLabel_1_3.setIcon(new ImageIcon(Maharashtrian.class.getResource("/Images/off2.jpg")));
		lblNewLabel_1_3.setBounds(33, 65, 688, 163);
		panel_2_2.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(Maharashtrian.class.getResource("/Images/off2.jpg")));
		lblNewLabel_1_1_1.setBounds(763, 65, 688, 163);
		panel_2_2.add(lblNewLabel_1_1_1);
		
		Panel panel_2_1_6 = new Panel();
		panel_2_1_6.setLayout(null);
		panel_2_1_6.setBounds(10, 250, 715, 69);
		panel_2_2.add(panel_2_1_6);
		
		JLabel lblNewLabel_1_2_6 = new JLabel("NAME");
		lblNewLabel_1_2_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_6.setBounds(10, 10, 273, 56);
		panel_2_1_6.add(lblNewLabel_1_2_6);
		
		JButton btnNewButton_1_7 = new JButton("Remove");
		btnNewButton_1_7.setForeground(Color.WHITE);
		btnNewButton_1_7.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_7.setBackground(new Color(204, 51, 0));
		btnNewButton_1_7.setBounds(584, 20, 110, 36);
		panel_2_1_6.add(btnNewButton_1_7);
		
		JButton btnNewButton_1_1_6 = new JButton("ADD");
		btnNewButton_1_1_6.setForeground(Color.WHITE);
		btnNewButton_1_1_6.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_6.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_6.setBounds(437, 20, 110, 36);
		panel_2_1_6.add(btnNewButton_1_1_6);
		
		Panel panel_2_1_1_2 = new Panel();
		panel_2_1_1_2.setLayout(null);
		panel_2_1_1_2.setBounds(10, 319, 715, 69);
		panel_2_2.add(panel_2_1_1_2);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("NAME");
		lblNewLabel_1_2_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_1_2.setBounds(10, 10, 273, 56);
		panel_2_1_1_2.add(lblNewLabel_1_2_1_2);
		
		JButton btnNewButton_1_2_2 = new JButton("Remove");
		btnNewButton_1_2_2.setForeground(Color.WHITE);
		btnNewButton_1_2_2.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_2_2.setBackground(new Color(204, 51, 0));
		btnNewButton_1_2_2.setBounds(584, 20, 110, 36);
		panel_2_1_1_2.add(btnNewButton_1_2_2);
		
		JButton btnNewButton_1_1_1_2 = new JButton("ADD");
		btnNewButton_1_1_1_2.setForeground(Color.WHITE);
		btnNewButton_1_1_1_2.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_1_2.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_1_2.setBounds(437, 20, 110, 36);
		panel_2_1_1_2.add(btnNewButton_1_1_1_2);
		
		Panel panel_2_1_2_2 = new Panel();
		panel_2_1_2_2.setLayout(null);
		panel_2_1_2_2.setBounds(10, 388, 715, 69);
		panel_2_2.add(panel_2_1_2_2);
		
		JLabel lblNewLabel_1_2_2_2 = new JLabel("NAME");
		lblNewLabel_1_2_2_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_2_2.setBounds(10, 10, 273, 56);
		panel_2_1_2_2.add(lblNewLabel_1_2_2_2);
		
		JButton btnNewButton_1_3_2 = new JButton("Remove");
		btnNewButton_1_3_2.setForeground(Color.WHITE);
		btnNewButton_1_3_2.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_3_2.setBackground(new Color(204, 51, 0));
		btnNewButton_1_3_2.setBounds(584, 20, 110, 36);
		panel_2_1_2_2.add(btnNewButton_1_3_2);
		
		JButton btnNewButton_1_1_2_2 = new JButton("ADD");
		btnNewButton_1_1_2_2.setForeground(Color.WHITE);
		btnNewButton_1_1_2_2.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_2_2.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_2_2.setBounds(437, 20, 110, 36);
		panel_2_1_2_2.add(btnNewButton_1_1_2_2);
		
		Panel panel_2_1_3_2 = new Panel();
		panel_2_1_3_2.setLayout(null);
		panel_2_1_3_2.setBounds(10, 456, 715, 69);
		panel_2_2.add(panel_2_1_3_2);
		
		JLabel lblNewLabel_1_2_3_2 = new JLabel("NAME");
		lblNewLabel_1_2_3_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_3_2.setBounds(10, 10, 273, 56);
		panel_2_1_3_2.add(lblNewLabel_1_2_3_2);
		
		JButton btnNewButton_1_4_2 = new JButton("Remove");
		btnNewButton_1_4_2.setForeground(Color.WHITE);
		btnNewButton_1_4_2.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_4_2.setBackground(new Color(204, 51, 0));
		btnNewButton_1_4_2.setBounds(584, 20, 110, 36);
		panel_2_1_3_2.add(btnNewButton_1_4_2);
		
		JButton btnNewButton_1_1_3_2 = new JButton("ADD");
		btnNewButton_1_1_3_2.setForeground(Color.WHITE);
		btnNewButton_1_1_3_2.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_3_2.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_3_2.setBounds(437, 20, 110, 36);
		panel_2_1_3_2.add(btnNewButton_1_1_3_2);
		
		Panel panel_2_1_4_2 = new Panel();
		panel_2_1_4_2.setLayout(null);
		panel_2_1_4_2.setBounds(10, 525, 715, 69);
		panel_2_2.add(panel_2_1_4_2);
		
		JLabel lblNewLabel_1_2_4_2 = new JLabel("NAME");
		lblNewLabel_1_2_4_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_4_2.setBounds(10, 10, 273, 56);
		panel_2_1_4_2.add(lblNewLabel_1_2_4_2);
		
		JButton btnNewButton_1_5_2 = new JButton("Remove");
		btnNewButton_1_5_2.setForeground(Color.WHITE);
		btnNewButton_1_5_2.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_5_2.setBackground(new Color(204, 51, 0));
		btnNewButton_1_5_2.setBounds(584, 20, 110, 36);
		panel_2_1_4_2.add(btnNewButton_1_5_2);
		
		JButton btnNewButton_1_1_4_2 = new JButton("ADD");
		btnNewButton_1_1_4_2.setForeground(Color.WHITE);
		btnNewButton_1_1_4_2.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_4_2.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_4_2.setBounds(437, 20, 110, 36);
		panel_2_1_4_2.add(btnNewButton_1_1_4_2);
		
		Panel panel_2_1_5_1 = new Panel();
		panel_2_1_5_1.setLayout(null);
		panel_2_1_5_1.setBounds(744, 250, 715, 69);
		panel_2_2.add(panel_2_1_5_1);
		
		JLabel lblNewLabel_1_2_5_1 = new JLabel("NAME");
		lblNewLabel_1_2_5_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_5_1.setBounds(10, 10, 273, 56);
		panel_2_1_5_1.add(lblNewLabel_1_2_5_1);
		
		JButton btnNewButton_1_6_1 = new JButton("Remove");
		btnNewButton_1_6_1.setForeground(Color.WHITE);
		btnNewButton_1_6_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_6_1.setBackground(new Color(204, 51, 0));
		btnNewButton_1_6_1.setBounds(584, 20, 110, 36);
		panel_2_1_5_1.add(btnNewButton_1_6_1);
		
		JButton btnNewButton_1_1_5_1 = new JButton("ADD");
		btnNewButton_1_1_5_1.setForeground(Color.WHITE);
		btnNewButton_1_1_5_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_5_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_5_1.setBounds(437, 20, 110, 36);
		panel_2_1_5_1.add(btnNewButton_1_1_5_1);
		
		Panel panel_2_1_1_1_1 = new Panel();
		panel_2_1_1_1_1.setLayout(null);
		panel_2_1_1_1_1.setBounds(744, 319, 715, 69);
		panel_2_2.add(panel_2_1_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("NAME");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_1_1_1.setBounds(10, 10, 273, 56);
		panel_2_1_1_1_1.add(lblNewLabel_1_2_1_1_1);
		
		JButton btnNewButton_1_2_1_1 = new JButton("Remove");
		btnNewButton_1_2_1_1.setForeground(Color.WHITE);
		btnNewButton_1_2_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_2_1_1.setBackground(new Color(204, 51, 0));
		btnNewButton_1_2_1_1.setBounds(584, 20, 110, 36);
		panel_2_1_1_1_1.add(btnNewButton_1_2_1_1);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_1_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_1_1_1.setBounds(437, 20, 110, 36);
		panel_2_1_1_1_1.add(btnNewButton_1_1_1_1_1);
		
		Panel panel_2_1_2_1_1 = new Panel();
		panel_2_1_2_1_1.setLayout(null);
		panel_2_1_2_1_1.setBounds(744, 388, 715, 69);
		panel_2_2.add(panel_2_1_2_1_1);
		
		JLabel lblNewLabel_1_2_2_1_1 = new JLabel("NAME");
		lblNewLabel_1_2_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_2_1_1.setBounds(10, 10, 273, 56);
		panel_2_1_2_1_1.add(lblNewLabel_1_2_2_1_1);
		
		JButton btnNewButton_1_3_1_1 = new JButton("Remove");
		btnNewButton_1_3_1_1.setForeground(Color.WHITE);
		btnNewButton_1_3_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_3_1_1.setBackground(new Color(204, 51, 0));
		btnNewButton_1_3_1_1.setBounds(584, 20, 110, 36);
		panel_2_1_2_1_1.add(btnNewButton_1_3_1_1);
		
		JButton btnNewButton_1_1_2_1_1 = new JButton("ADD");
		btnNewButton_1_1_2_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_2_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_2_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_2_1_1.setBounds(437, 20, 110, 36);
		panel_2_1_2_1_1.add(btnNewButton_1_1_2_1_1);
		
		Panel panel_2_1_3_1_1 = new Panel();
		panel_2_1_3_1_1.setLayout(null);
		panel_2_1_3_1_1.setBounds(744, 456, 715, 69);
		panel_2_2.add(panel_2_1_3_1_1);
		
		JLabel lblNewLabel_1_2_3_1_1 = new JLabel("NAME");
		lblNewLabel_1_2_3_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_3_1_1.setBounds(10, 10, 273, 56);
		panel_2_1_3_1_1.add(lblNewLabel_1_2_3_1_1);
		
		JButton btnNewButton_1_4_1_1 = new JButton("Remove");
		btnNewButton_1_4_1_1.setForeground(Color.WHITE);
		btnNewButton_1_4_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_4_1_1.setBackground(new Color(204, 51, 0));
		btnNewButton_1_4_1_1.setBounds(584, 20, 110, 36);
		panel_2_1_3_1_1.add(btnNewButton_1_4_1_1);
		
		JButton btnNewButton_1_1_3_1_1 = new JButton("ADD");
		btnNewButton_1_1_3_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_3_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_3_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_3_1_1.setBounds(437, 20, 110, 36);
		panel_2_1_3_1_1.add(btnNewButton_1_1_3_1_1);
		
		Panel panel_2_1_4_1_1 = new Panel();
		panel_2_1_4_1_1.setLayout(null);
		panel_2_1_4_1_1.setBounds(744, 525, 715, 69);
		panel_2_2.add(panel_2_1_4_1_1);
		
		JLabel lblNewLabel_1_2_4_1_1 = new JLabel("NAME");
		lblNewLabel_1_2_4_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2_4_1_1.setBounds(10, 10, 273, 56);
		panel_2_1_4_1_1.add(lblNewLabel_1_2_4_1_1);
		
		JButton btnNewButton_1_5_1_1 = new JButton("Remove");
		btnNewButton_1_5_1_1.setForeground(Color.WHITE);
		btnNewButton_1_5_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_5_1_1.setBackground(new Color(204, 51, 0));
		btnNewButton_1_5_1_1.setBounds(584, 20, 110, 36);
		panel_2_1_4_1_1.add(btnNewButton_1_5_1_1);
		
		JButton btnNewButton_1_1_4_1_1 = new JButton("ADD");
		btnNewButton_1_1_4_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_4_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_4_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_4_1_1.setBounds(437, 20, 110, 36);
		panel_2_1_4_1_1.add(btnNewButton_1_1_4_1_1);
		
		JButton btnNewButton_2_1 = new JButton("Order");
		btnNewButton_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 30));
		btnNewButton_2_1.setBackground(Color.ORANGE);
		btnNewButton_2_1.setBounds(631, 604, 209, 58);
		panel_2_2.add(btnNewButton_2_1);
	}
}
