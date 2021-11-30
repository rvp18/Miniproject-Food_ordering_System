import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

public class Orderdetails extends JFrame {

	String total = "";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Name;
	private JTextField add;
	private JTextField pincode;
	private JTextField ph_no;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;

	String email;
	String pym_meth;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

//		System.out.println(args[0]);
//		Maharashtrian m = new Maharashtrian();
//		List<String> list = m.getSelectedItems();
//		
//		System.out.println("List by object : " + list);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Orderdetails frame = new Orderdetails("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con = null;
	private JTextField itemidtoremove;

	/**
	 * Create the frame.
	 */
	public Orderdetails(String emailId) {

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

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		panel_1.setBounds(701, 23, 765, 720);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Customer details:");
		lblNewLabel.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel.setFont(new Font("Maiandra GD", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 10, 417, 60);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 92, 76, 37);
		panel_1.add(lblNewLabel_1);

		Name = new JTextField();
		Name.setFont(new Font("Consolas", Font.BOLD, 20));
		Name.setBounds(10, 124, 745, 50);
		panel_1.add(Name);
		Name.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Address:");
		lblNewLabel_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(10, 200, 148, 37);
		panel_1.add(lblNewLabel_1_1);

		add = new JTextField();
		add.setFont(new Font("Consolas", Font.BOLD, 20));
		add.setColumns(10);
		add.setBounds(10, 237, 745, 50);
		panel_1.add(add);

		JLabel lblNewLabel_1_1_1 = new JLabel("Pincode:");
		lblNewLabel_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(10, 311, 148, 37);
		panel_1.add(lblNewLabel_1_1_1);

		pincode = new JTextField();
		pincode.setFont(new Font("Consolas", Font.BOLD, 20));
		pincode.setColumns(10);
		pincode.setBounds(10, 347, 172, 50);
		panel_1.add(pincode);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Phone No.");
		lblNewLabel_1_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblNewLabel_1_1_1_1.setBounds(213, 311, 148, 37);
		panel_1.add(lblNewLabel_1_1_1_1);

		ph_no = new JTextField();
		ph_no.setFont(new Font("Consolas", Font.BOLD, 20));
		ph_no.setColumns(10);
		ph_no.setBounds(216, 347, 352, 50);
		panel_1.add(ph_no);

		JRadioButton COD = new JRadioButton("COD");
		buttonGroup.add(COD);
		COD.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		COD.setBounds(39, 407, 141, 68);
		panel_1.add(COD);

		JRadioButton PayByCard = new JRadioButton("Pay by Card");
		buttonGroup.add(PayByCard);
		PayByCard.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		PayByCard.setBounds(39, 469, 219, 60);
		panel_1.add(PayByCard);

		JButton btnNewButton_1_1 = new JButton("Order");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = Name.getText();
				String address = add.getText();
				String pc = pincode.getText();
				String phno = ph_no.getText();

				if (COD.isSelected() == true) {

					pym_meth = "COD";
				} else if (PayByCard.isSelected()) {

					pym_meth = "Card";
				}

				else {
				}

				try {
					PreparedStatement pst = con.prepareStatement(
							"insert into customeraddress(Email,Name,Address,Pincode,PhoneNo,PaymentMethod) values(?,?,?,?,?,?)");
					pst.setString(1, email);
					pst.setString(2, name);
					pst.setString(3, address);
					pst.setString(4, pc);
					pst.setString(5, phno);
					pst.setString(6, pym_meth);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Procceding your Payment");

					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Something Went Wrong", "Order", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

				if (COD.isSelected() == true) {
					Invoice ivp = new Invoice(email);
					ivp.setVisible(true);
					dispose();
				} else if (PayByCard.isSelected()) {
					CardDetails2 cdp = new CardDetails2(email);
					cdp.setVisible(true);
					dispose();
				}

				else {
					JOptionPane.showMessageDialog(null, "Please Select Payment Option");
				}

			}
		});
		btnNewButton_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		btnNewButton_1_1.setBackground(new Color(0, 204, 0));
		btnNewButton_1_1.setBounds(64, 552, 180, 68);
		panel_1.add(btnNewButton_1_1);

		JLabel lblNewLabel_3 = new JLabel("Order Details:");
		lblNewLabel_3.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		lblNewLabel_3.setBounds(24, 28, 260, 49);
		panel.add(lblNewLabel_3);

		JButton btnBack_1 = new JButton("");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home hp = new Home(email);
				hp.setVisible(true);
				dispose();
			}
		});
		btnBack_1.setIcon(new ImageIcon(Orderdetails.class.getResource("/Images/back 3.png")));
		btnBack_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnBack_1.setBackground(Color.WHITE);
		btnBack_1.setBounds(24, 651, 101, 80);
		panel.add(btnBack_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 120, 603, 460);
		panel.add(scrollPane);
//		
		table = new JTable();

		try {
			String query = "SELECT itemid,Name,Price FROM tempaddeditems WHERE Email=? ";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, email);

			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		scrollPane.setViewportView(table);

		JLabel totaltext = new JLabel("Total:");
		totaltext.setFont(new Font("Maiandra GD", Font.BOLD, 30));
		totaltext.setBounds(241, 580, 85, 49);
		panel.add(totaltext);

		try {
			String query = "SELECT sum(Price+(Price/100)*18) FROM tempaddeditems";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				total = rs.getString("sum(Price+(Price/100)*18)");

//				total=total+(total*18/100);

			}

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		JLabel totalPrice = new JLabel("");
		totalPrice.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		totalPrice.setBounds(325, 580, 133, 49);
		panel.add(totalPrice);

		totalPrice.setText(total);

		itemidtoremove = new JTextField();
		itemidtoremove.setFont(new Font("Consolas", Font.BOLD, 20));
		itemidtoremove.setBounds(192, 682, 152, 49);
		panel.add(itemidtoremove);
		itemidtoremove.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("ItemID:");
		lblNewLabel_2.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		lblNewLabel_2.setBounds(192, 638, 152, 34);
		panel.add(lblNewLabel_2);

		JButton btnNewButton_1_1_1 = new JButton("Remove");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = itemidtoremove.getText();
				try {
					String query = "DELETE FROM tempaddeditems WHERE itemid=?";
					PreparedStatement pst = con.prepareStatement(query);

					pst.setString(1, item);

					pst.executeUpdate();

					JOptionPane.showMessageDialog(null, "Item Removed");

				} catch (SQLException e1) {

					e1.printStackTrace();
				}

				try {
					String query = "DELETE FROM finalorder WHERE itemid=?";
					PreparedStatement pst = con.prepareStatement(query);

					pst.setString(1, item);

					pst.executeUpdate();

				} catch (SQLException e1) {

					e1.printStackTrace();
				}

				try {
					String query = "SELECT itemid,Name,Price FROM tempaddeditems WHERE Email=? ";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1, email);

					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (SQLException e1) {

					e1.printStackTrace();
				}

				try {
					String query = "SELECT sum(Price+(Price/100)*18) FROM tempaddeditems;";
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet rs = pst.executeQuery();

					if (rs.next()) {

						total = rs.getString("sum(Price+(Price/100)*18)");

						totalPrice.setText(total);

					}

				} catch (SQLException e1) {

					e1.printStackTrace();
				}

			}
		});
		btnNewButton_1_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		btnNewButton_1_1_1.setBackground(new Color(255, 102, 102));
		btnNewButton_1_1_1.setBounds(368, 682, 136, 49);
		panel.add(btnNewButton_1_1_1);

		JLabel lblNewLabel_4 = new JLabel("(18% GST ADDED)");
		lblNewLabel_4.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		lblNewLabel_4.setBounds(468, 605, 143, 24);
		panel.add(lblNewLabel_4);

		JButton btnNewButton_1_1_2 = new JButton("APPLY COUPON");
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double coupon = Double.parseDouble(total);

				if (500 <= coupon && coupon < 1000) {
					coupon -= 50.00;
				} else if (coupon >= 1000.00) {
					coupon -= 100.00;
				} else {
					JOptionPane.showMessageDialog(null, "Offer not applicable");
				}

				btnNewButton_1_1_2.setEnabled(false);
				btnNewButton_1_1_2.setBackground(new Color(105, 105, 105));

				try {
					String query = "SELECT sum(Price+(Price/100)*18) FROM tempaddeditems;";
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet rs = pst.executeQuery();

					if (rs.next()) {

						total = rs.getString("sum(Price+(Price/100)*18)");

						String s = String.valueOf(coupon);

						totalPrice.setText(s);

					}

				} catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1_2.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		btnNewButton_1_1_2.setBackground(Color.ORANGE);
		btnNewButton_1_1_2.setBounds(305, 552, 274, 68);
		panel_1.add(btnNewButton_1_1_2);
	}

	@SuppressWarnings("unused")
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
