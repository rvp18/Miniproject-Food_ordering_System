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
		setBounds(10, 20, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
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
		lblNewLabel_1.setBounds(27, 62, 688, 163);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(Maharashtrian.class.getResource("/Images/off1.jpg")));
		lblNewLabel_1_1.setBounds(751, 62, 688, 163);
		panel_2.add(lblNewLabel_1_1);
		
		Panel panel_2_1 = new Panel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(10, 231, 715, 69);
		panel_2.add(panel_2_1);
		
		JLabel MasalaPapad = new JLabel("Masala Papad");
		MasalaPapad.setFont(new Font("Times New Roman", Font.BOLD, 20));
		MasalaPapad.setBounds(10, 10, 273, 56);
		panel_2_1.add(MasalaPapad);
		
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
		
		JLabel lblRs_2_1 = new JLabel("Rs.50/-");
		lblRs_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_1.setBounds(324, 10, 103, 56);
		panel_2_1.add(lblRs_2_1);
		
		Panel panel_2_1_1 = new Panel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBounds(10, 300, 715, 69);
		panel_2.add(panel_2_1_1);
		
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
		
		JLabel lblRs_2_2 = new JLabel("Rs.60/-");
		lblRs_2_2.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_2.setBounds(323, 10, 103, 56);
		panel_2_1_1.add(lblRs_2_2);
		
		JLabel MixBhaji = new JLabel("Mix Bhaji");
		MixBhaji.setBounds(10, 10, 273, 56);
		panel_2_1_1.add(MixBhaji);
		MixBhaji.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		Panel panel_2_1_2 = new Panel();
		panel_2_1_2.setLayout(null);
		panel_2_1_2.setBounds(10, 369, 715, 69);
		panel_2.add(panel_2_1_2);
		
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
		
		JLabel lblRs_2_3 = new JLabel("Rs.70/-");
		lblRs_2_3.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_3.setBounds(323, 10, 103, 56);
		panel_2_1_2.add(lblRs_2_3);
		
		JLabel MoogVada = new JLabel("Moog Vada");
		MoogVada.setBounds(10, 10, 273, 56);
		panel_2_1_2.add(MoogVada);
		MoogVada.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		Panel panel_2_1_3 = new Panel();
		panel_2_1_3.setLayout(null);
		panel_2_1_3.setBounds(10, 437, 715, 69);
		panel_2.add(panel_2_1_3);
		
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
		
		JLabel lblRs_2_3_1 = new JLabel("Rs.80/-");
		lblRs_2_3_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_3_1.setBounds(324, 10, 103, 56);
		panel_2_1_3.add(lblRs_2_3_1);
		
		JLabel ChanaKoliwada = new JLabel("Chana Koliwada");
		ChanaKoliwada.setBounds(10, 12, 273, 56);
		panel_2_1_3.add(ChanaKoliwada);
		ChanaKoliwada.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		Panel panel_2_1_4 = new Panel();
		panel_2_1_4.setLayout(null);
		panel_2_1_4.setBounds(10, 506, 715, 69);
		panel_2.add(panel_2_1_4);
		
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
		
		JLabel lblRs_2_3_2 = new JLabel("Rs.100/-");
		lblRs_2_3_2.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_3_2.setBounds(324, 10, 103, 56);
		panel_2_1_4.add(lblRs_2_3_2);
		
		JLabel MalvaniPannerTikka = new JLabel("Malvani Paneer Tikka ");
		MalvaniPannerTikka.setBounds(10, 10, 273, 56);
		panel_2_1_4.add(MalvaniPannerTikka);
		MalvaniPannerTikka.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		Panel panel_2_1_5 = new Panel();
		panel_2_1_5.setLayout(null);
		panel_2_1_5.setBounds(744, 231, 715, 69);
		panel_2.add(panel_2_1_5);
		
		JLabel ChickenFry = new JLabel("Chicken Fry");
		ChickenFry.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ChickenFry.setBounds(10, 10, 273, 56);
		panel_2_1_5.add(ChickenFry);
		
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
		
		JLabel lblRs_2_3_3 = new JLabel("Rs.150/-");
		lblRs_2_3_3.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_3_3.setBounds(318, 10, 103, 56);
		panel_2_1_5.add(lblRs_2_3_3);
		
		Panel panel_2_1_1_1 = new Panel();
		panel_2_1_1_1.setLayout(null);
		panel_2_1_1_1.setBounds(744, 300, 715, 69);
		panel_2.add(panel_2_1_1_1);
		
		JLabel MuttonFry = new JLabel("Mutton Fry");
		MuttonFry.setFont(new Font("Times New Roman", Font.BOLD, 20));
		MuttonFry.setBounds(10, 10, 273, 56);
		panel_2_1_1_1.add(MuttonFry);
		
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
		
		JLabel lblRs_2_3_4 = new JLabel("Rs.150/-");
		lblRs_2_3_4.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_3_4.setBounds(315, 10, 103, 56);
		panel_2_1_1_1.add(lblRs_2_3_4);
		
		Panel panel_2_1_2_1 = new Panel();
		panel_2_1_2_1.setLayout(null);
		panel_2_1_2_1.setBounds(744, 369, 715, 69);
		panel_2.add(panel_2_1_2_1);
		
		JLabel PrawnsFry = new JLabel("Prawns Fry");
		PrawnsFry.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PrawnsFry.setBounds(10, 10, 273, 56);
		panel_2_1_2_1.add(PrawnsFry);
		
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
		
		JLabel lblRs_2_3_5 = new JLabel("Rs.170/-");
		lblRs_2_3_5.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_3_5.setBounds(316, 10, 103, 56);
		panel_2_1_2_1.add(lblRs_2_3_5);
		
		Panel panel_2_1_3_1 = new Panel();
		panel_2_1_3_1.setLayout(null);
		panel_2_1_3_1.setBounds(744, 437, 715, 69);
		panel_2.add(panel_2_1_3_1);
		
		JLabel SurmaiFry = new JLabel("Surmai Fry");
		SurmaiFry.setFont(new Font("Times New Roman", Font.BOLD, 20));
		SurmaiFry.setBounds(10, 10, 273, 56);
		panel_2_1_3_1.add(SurmaiFry);
		
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
		
		JLabel lblRs_2_3_6 = new JLabel("Rs.180/-");
		lblRs_2_3_6.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_3_6.setBounds(314, 8, 103, 56);
		panel_2_1_3_1.add(lblRs_2_3_6);
		
		Panel panel_2_1_4_1 = new Panel();
		panel_2_1_4_1.setLayout(null);
		panel_2_1_4_1.setBounds(744, 506, 715, 69);
		panel_2.add(panel_2_1_4_1);
		
		JLabel PomfretFry = new JLabel("Pomfret Fry");
		PomfretFry.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PomfretFry.setBounds(10, 10, 273, 56);
		panel_2_1_4_1.add(PomfretFry);
		
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
		
		JLabel lblRs_2_3_7 = new JLabel("Rs.200/-");
		lblRs_2_3_7.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_2_3_7.setBounds(316, 8, 103, 56);
		panel_2_1_4_1.add(lblRs_2_3_7);
		
		JButton btnNewButton_2 = new JButton("Order");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orderdetails.main(null);
			}
		});
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
		panel_2_2.setBackground(Color.WHITE);
		panel_2_2.setLayout(null);
		panel_2_2.setBounds(0, 0, 1461, 672);
		panel_1.add(panel_2_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(735, 210, 10, 384);
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
		
		JLabel DalFry = new JLabel("Dal Fry");
		DalFry.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		DalFry.setBounds(10, 10, 273, 56);
		panel_2_1_6.add(DalFry);
		
		JLabel lblRs_4 = new JLabel("Rs.130/-");
		lblRs_4.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_4.setBounds(324, 10, 103, 56);
		panel_2_1_6.add(lblRs_4);
		
		Panel panel_2_1_1_2 = new Panel();
		panel_2_1_1_2.setLayout(null);
		panel_2_1_1_2.setBounds(10, 319, 715, 69);
		panel_2_2.add(panel_2_1_1_2);
		
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
		
		JLabel lblRs_3 = new JLabel("Rs.150/-");
		lblRs_3.setBounds(324, 10, 103, 56);
		panel_2_1_1_2.add(lblRs_3);
		lblRs_3.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		
		JLabel VegThali = new JLabel("Veg Thali");
		VegThali.setBounds(10, 10, 273, 56);
		panel_2_1_1_2.add(VegThali);
		VegThali.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		
		Panel panel_2_1_2_2 = new Panel();
		panel_2_1_2_2.setLayout(null);
		panel_2_1_2_2.setBounds(10, 388, 715, 69);
		panel_2_2.add(panel_2_1_2_2);
		
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
		
		JLabel VegKolhapuri = new JLabel("Veg Kolhapuri");
		VegKolhapuri.setBounds(10, 10, 270, 56);
		panel_2_1_2_2.add(VegKolhapuri);
		VegKolhapuri.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		
		JLabel lblRs = new JLabel("Rs.150/-");
		lblRs.setBounds(324, 10, 103, 56);
		panel_2_1_2_2.add(lblRs);
		lblRs.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		
		Panel panel_2_1_3_2 = new Panel();
		panel_2_1_3_2.setLayout(null);
		panel_2_1_3_2.setBounds(10, 456, 715, 69);
		panel_2_2.add(panel_2_1_3_2);
		
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
		
		JLabel MushroomMasala = new JLabel("Mushroom Masala");
		MushroomMasala.setBounds(10, 10, 273, 56);
		panel_2_1_3_2.add(MushroomMasala);
		MushroomMasala.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		
		JLabel lblRs_2 = new JLabel("Rs.170/-");
		lblRs_2.setBounds(324, 10, 103, 56);
		panel_2_1_3_2.add(lblRs_2);
		lblRs_2.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		
		Panel panel_2_1_4_2 = new Panel();
		panel_2_1_4_2.setLayout(null);
		panel_2_1_4_2.setBounds(10, 525, 715, 69);
		panel_2_2.add(panel_2_1_4_2);
		
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
		
		JLabel KajuMalvaniMasala = new JLabel("Kaju Malvani Masala");
		KajuMalvaniMasala.setBounds(10, 10, 276, 56);
		panel_2_1_4_2.add(KajuMalvaniMasala);
		KajuMalvaniMasala.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		
		JLabel lblRs_10 = new JLabel("Rs.200/-");
		lblRs_10.setBounds(324, 10, 103, 56);
		panel_2_1_4_2.add(lblRs_10);
		lblRs_10.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		
		Panel panel_2_1_5_1 = new Panel();
		panel_2_1_5_1.setLayout(null);
		panel_2_1_5_1.setBounds(744, 250, 715, 69);
		panel_2_2.add(panel_2_1_5_1);
		
		JLabel ChickenHandi = new JLabel("Chicken Handi");
		ChickenHandi.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		ChickenHandi.setBounds(10, 10, 273, 56);
		panel_2_1_5_1.add(ChickenHandi);
		
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
		
		JLabel lblRs_5 = new JLabel("Rs.300/-");
		lblRs_5.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_5.setBounds(324, 10, 103, 56);
		panel_2_1_5_1.add(lblRs_5);
		
		Panel panel_2_1_1_1_1 = new Panel();
		panel_2_1_1_1_1.setLayout(null);
		panel_2_1_1_1_1.setBounds(744, 319, 715, 69);
		panel_2_2.add(panel_2_1_1_1_1);
		
		JLabel ChickenMalvani = new JLabel("Chicken Malvani");
		ChickenMalvani.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		ChickenMalvani.setBounds(10, 10, 273, 56);
		panel_2_1_1_1_1.add(ChickenMalvani);
		
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
		
		JLabel lblRs_6 = new JLabel("Rs.350/-");
		lblRs_6.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_6.setBounds(325, 10, 103, 56);
		panel_2_1_1_1_1.add(lblRs_6);
		
		Panel panel_2_1_2_1_1 = new Panel();
		panel_2_1_2_1_1.setLayout(null);
		panel_2_1_2_1_1.setBounds(744, 388, 715, 69);
		panel_2_2.add(panel_2_1_2_1_1);
		
		JLabel ChickenKolhapuri = new JLabel("Chicken Kolhapuri");
		ChickenKolhapuri.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		ChickenKolhapuri.setBounds(10, 10, 273, 56);
		panel_2_1_2_1_1.add(ChickenKolhapuri);
		
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
		
		JLabel lblRs_7 = new JLabel("Rs.370/-");
		lblRs_7.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_7.setBounds(324, 10, 103, 56);
		panel_2_1_2_1_1.add(lblRs_7);
		
		Panel panel_2_1_3_1_1 = new Panel();
		panel_2_1_3_1_1.setLayout(null);
		panel_2_1_3_1_1.setBounds(744, 456, 715, 69);
		panel_2_2.add(panel_2_1_3_1_1);
		
		JLabel PrawnsMasala = new JLabel("Prawns Masala");
		PrawnsMasala.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		PrawnsMasala.setBounds(10, 10, 273, 56);
		panel_2_1_3_1_1.add(PrawnsMasala);
		
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
		
		JLabel lblRs_8 = new JLabel("Rs.370/-");
		lblRs_8.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_8.setBounds(324, 10, 103, 56);
		panel_2_1_3_1_1.add(lblRs_8);
		
		Panel panel_2_1_4_1_1 = new Panel();
		panel_2_1_4_1_1.setLayout(null);
		panel_2_1_4_1_1.setBounds(744, 525, 715, 69);
		panel_2_2.add(panel_2_1_4_1_1);
		
		JLabel PomfretMasala = new JLabel("Pomfret Masala");
		PomfretMasala.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		PomfretMasala.setBounds(10, 10, 273, 56);
		panel_2_1_4_1_1.add(PomfretMasala);
		
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
		
		JLabel lblRs_9 = new JLabel("Rs.390/-");
		lblRs_9.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblRs_9.setBounds(324, 10, 103, 56);
		panel_2_1_4_1_1.add(lblRs_9);
		
		JButton btnNewButton_2_1 = new JButton("Order");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orderdetails.main(null);
			}
		});
		btnNewButton_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 30));
		btnNewButton_2_1.setBackground(Color.ORANGE);
		btnNewButton_2_1.setBounds(631, 604, 209, 58);
		panel_2_2.add(btnNewButton_2_1);
	}
}
