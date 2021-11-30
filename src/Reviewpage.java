import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Reviewpage extends JFrame {

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
					Reviewpage frame = new Reviewpage("");
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
	public Reviewpage(String emailId) {

		con = db.dbconnect();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 20, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		this.email = emailId;

		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(311, 92, 894, 611);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Enjoying The App ??");
		lblNewLabel.setFont(new Font("Maiandra GD", Font.BOLD, 35));
		lblNewLabel.setBounds(280, 55, 352, 73);
		panel_1.add(lblNewLabel);

		JButton bad = new JButton("");
		bad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bad_icon = "Bad";

				try {
					PreparedStatement pst = (PreparedStatement) con
							.prepareStatement("insert into customerreview(Email,Rating) values(?,?)");
					pst.setString(1, email);
					pst.setString(2, bad_icon);
					pst.executeUpdate();

					try {
						PreparedStatement pst1 = (PreparedStatement) con
								.prepareStatement("DELETE FROM tempaddeditems WHERE Email=?");
						pst1.setString(1, email);
						pst1.executeUpdate();

						Home hp = new Home(email);
						hp.setVisible(true);
						dispose();

					} catch (SQLException e1) {

						e1.printStackTrace();
					}

					JOptionPane.showMessageDialog(null, "Thanks for Review:)");

				} catch (SQLException e1) {

					e1.printStackTrace();
				}

			}
		});
		bad.setIcon(new ImageIcon(Reviewpage.class.getResource("/Images/nah!! emoji.png")));
		bad.setBackground(Color.WHITE);
		bad.setBounds(163, 223, 129, 113);
		panel_1.add(bad);

		JButton okok = new JButton("");
		okok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Average = "Average";

				try {
					PreparedStatement pst = (PreparedStatement) con
							.prepareStatement("insert into customerreview(Email,Rating) values(?,?)");
					pst.setString(1, email);
					pst.setString(2, Average);
					pst.executeUpdate();

					try {
						PreparedStatement pst1 = (PreparedStatement) con
								.prepareStatement("DELETE FROM tempaddeditems WHERE Email=?");
						pst1.setString(1, email);
						pst1.executeUpdate();

						Home hp = new Home(email);
						hp.setVisible(true);
						dispose();

					} catch (SQLException e1) {

						e1.printStackTrace();
					}

					JOptionPane.showMessageDialog(null, "Thanks for Review:)");

				} catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
		});
		okok.setIcon(new ImageIcon(Reviewpage.class.getResource("/Images/ok emoji.png")));
		okok.setBackground(Color.WHITE);
		okok.setBounds(384, 223, 129, 113);
		panel_1.add(okok);

		JButton good = new JButton("");
		good.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Good = "Good";

				try {
					PreparedStatement pst = (PreparedStatement) con
							.prepareStatement("insert into customerreview(Email,Rating) values(?,?)");
					pst.setString(1, email);
					pst.setString(2, Good);
					pst.executeUpdate();

					JOptionPane.showMessageDialog(null, "Thanks for Review:)");

					try {
						PreparedStatement pst1 = (PreparedStatement) con
								.prepareStatement("DELETE FROM tempaddeditems WHERE Email=?");
						pst1.setString(1, email);
						pst1.executeUpdate();

						Home hp = new Home(email);
						hp.setVisible(true);
						dispose();

					} catch (SQLException e1) {

						e1.printStackTrace();
					}

				} catch (SQLException e1) {

					e1.printStackTrace();
				}

			}
		});
		good.setIcon(new ImageIcon(Reviewpage.class.getResource("/Images/loved it emoji.png")));
		good.setBackground(Color.WHITE);
		good.setBounds(602, 223, 129, 113);
		panel_1.add(good);

		JLabel lblNewLabel_1 = new JLabel("Nahh !!");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Gabriola", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(181, 276, 85, 73);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Okayish");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Gabriola", Font.PLAIN, 35));
		lblNewLabel_1_1.setBounds(397, 276, 106, 73);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Loved It!!");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Gabriola", Font.PLAIN, 35));
		lblNewLabel_1_2.setBounds(622, 276, 109, 73);
		panel_1.add(lblNewLabel_1_2);

//		JButton btnNewButton = new JButton("Submit");
//		btnNewButton.setBackground(new Color(0, 255, 204));
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				
//				
//				String comment=cmt.getText() ;
//			
//				
//				try {
//			          PreparedStatement pst=(PreparedStatement)con.prepareStatement("insert into customerreview(Comment) values(?)");
//			          pst.setString(1, comment);
//			          pst.executeUpdate();
//			          
//			          
//			          dispose();
//			        } catch (SQLException e1) {
//			          
//			        	
//			          e1.printStackTrace();
//			        }
//				
//				
//				JOptionPane.showMessageDialog(null, "Thanks for your Feedback","Rate Us",JOptionPane.PLAIN_MESSAGE);
//				Home.main(null);
//				dispose();
//			}
//		});
//		btnNewButton.setFont(new Font("Maiandra GD", Font.BOLD, 20));
//		btnNewButton.setBounds(401, 554, 125, 35);
//		panel_1.add(btnNewButton);
	}

}
