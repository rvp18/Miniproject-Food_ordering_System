import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Invoice extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Invoice frame = new Invoice();
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
	public Invoice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 20, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Review Our App");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reviewpage.main(null);
				dispose();
			}
		});
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnNewButton.setBounds(1163, 157, 281, 146);
		panel.add(btnNewButton);
		
		JButton btnOrderMore = new JButton("Order More");
		btnOrderMore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.main(null);
				dispose();
			}
		});
		btnOrderMore.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnOrderMore.setBackground(Color.ORANGE);
		btnOrderMore.setBounds(1163, 394, 281, 146);
		panel.add(btnOrderMore);
	}
}
