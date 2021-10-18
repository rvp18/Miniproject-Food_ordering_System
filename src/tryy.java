import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

public class tryy extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tryy frame = new tryy();
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
	public tryy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 800);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		getContentPane().add(panel_1, BorderLayout.CENTER);
		
		Panel panel_2 = new Panel();
		panel_2.setLayout(null);
		panel_2.setBounds(10, 25, 715, 143);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 10, 134, 123);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NAME");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(192, 26, 273, 56);
		panel_2.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1.setBackground(new Color(204, 51, 0));
		btnNewButton_1.setBounds(548, 90, 127, 43);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("ADD");
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1.setBounds(548, 26, 127, 43);
		panel_2.add(btnNewButton_1_1);
		
		Panel panel_2_1 = new Panel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(10, 167, 715, 143);
		panel_1.add(panel_2_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(10, 10, 134, 123);
		panel_2_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("NAME");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(192, 26, 273, 56);
		panel_2_1.add(lblNewLabel_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Remove");
		btnNewButton_1_2.setForeground(Color.WHITE);
		btnNewButton_1_2.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_2.setBackground(new Color(204, 51, 0));
		btnNewButton_1_2.setBounds(548, 90, 127, 43);
		panel_2_1.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_1_1 = new JButton("ADD");
		btnNewButton_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_1.setBounds(548, 26, 127, 43);
		panel_2_1.add(btnNewButton_1_1_1);
		
		Panel panel_2_2 = new Panel();
		panel_2_2.setLayout(null);
		panel_2_2.setBounds(10, 310, 715, 143);
		panel_1.add(panel_2_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(10, 10, 134, 123);
		panel_2_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("NAME");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(192, 26, 273, 56);
		panel_2_2.add(lblNewLabel_1_2);
		
		JButton btnNewButton_1_3 = new JButton("Remove");
		btnNewButton_1_3.setForeground(Color.WHITE);
		btnNewButton_1_3.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_3.setBackground(new Color(204, 51, 0));
		btnNewButton_1_3.setBounds(548, 90, 127, 43);
		panel_2_2.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_1_2 = new JButton("ADD");
		btnNewButton_1_1_2.setForeground(Color.WHITE);
		btnNewButton_1_1_2.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_2.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_2.setBounds(548, 26, 127, 43);
		panel_2_2.add(btnNewButton_1_1_2);
		
		Panel panel_2_3 = new Panel();
		panel_2_3.setLayout(null);
		panel_2_3.setBounds(10, 452, 715, 143);
		panel_1.add(panel_2_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(10, 10, 134, 123);
		panel_2_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_3 = new JLabel("NAME");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(192, 26, 273, 56);
		panel_2_3.add(lblNewLabel_1_3);
		
		JButton btnNewButton_1_4 = new JButton("Remove");
		btnNewButton_1_4.setForeground(Color.WHITE);
		btnNewButton_1_4.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_4.setBackground(new Color(204, 51, 0));
		btnNewButton_1_4.setBounds(548, 90, 127, 43);
		panel_2_3.add(btnNewButton_1_4);
		
		JButton btnNewButton_1_1_3 = new JButton("ADD");
		btnNewButton_1_1_3.setForeground(Color.WHITE);
		btnNewButton_1_1_3.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		btnNewButton_1_1_3.setBackground(new Color(0, 153, 51));
		btnNewButton_1_1_3.setBounds(548, 26, 127, 43);
		panel_2_3.add(btnNewButton_1_1_3);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 0, 742, 674);
		panel_1.add(tabbedPane);
	}

}
