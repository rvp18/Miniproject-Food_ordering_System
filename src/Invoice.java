import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

public class Invoice extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	String email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Invoice frame = new Invoice("");
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
	public Invoice(String emailId) {

		con = db.dbconnect();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 20, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		this.email = emailId;
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Review Our App");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reviewpage rp = new Reviewpage(email);
				rp.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnNewButton.setBounds(1133, 53, 281, 146);
		panel.add(btnNewButton);

		JButton btnOrderMore = new JButton("Order More");
		btnOrderMore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement pst1 = (PreparedStatement) con
							.prepareStatement("DELETE FROM tempaddeditems WHERE Email=?");
					pst1.setString(1, email);
					pst1.executeUpdate();

				} catch (SQLException e1) {

					e1.printStackTrace();
				}
				Home hp = new Home(email);
				hp.setVisible(true);
				dispose();
			}
		});
		btnOrderMore.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnOrderMore.setBackground(Color.ORANGE);
		btnOrderMore.setBounds(1133, 291, 281, 146);
		panel.add(btnOrderMore);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 10, 978, 733);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 379, 958, 286);
		panel_1.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		try {
			String query = "SELECT Name,Price FROM tempaddeditems WHERE Email=? ";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, email);

			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));

			JLabel lblNewLabel_1_2_2 = new JLabel("Name:");
			lblNewLabel_1_2_2.setFont(new Font("Maiandra GD", Font.BOLD, 25));
			lblNewLabel_1_2_2.setBounds(10, 124, 176, 36);
			panel_1.add(lblNewLabel_1_2_2);

			JLabel add = new JLabel("Address:");
			add.setFont(new Font("Maiandra GD", Font.BOLD, 25));
			add.setBounds(10, 170, 176, 36);
			panel_1.add(add);

			JLabel lblNewLabel_1_2_2_2 = new JLabel("Pincode:");
			lblNewLabel_1_2_2_2.setFont(new Font("Maiandra GD", Font.BOLD, 25));
			lblNewLabel_1_2_2_2.setBounds(10, 248, 176, 36);
			panel_1.add(lblNewLabel_1_2_2_2);

			JLabel lblNewLabel_1_2_2_3 = new JLabel("Phone Number:");
			lblNewLabel_1_2_2_3.setFont(new Font("Maiandra GD", Font.BOLD, 25));
			lblNewLabel_1_2_2_3.setBounds(10, 294, 204, 36);
			panel_1.add(lblNewLabel_1_2_2_3);

			JLabel lblNewLabel_1_2_2_4 = new JLabel("Order Invoice");
			lblNewLabel_1_2_2_4.setFont(new Font("Maiandra GD", Font.BOLD, 30));
			lblNewLabel_1_2_2_4.setBounds(377, 36, 247, 49);
			panel_1.add(lblNewLabel_1_2_2_4);

			String total = "";

			try {
				String query1 = "SELECT sum(Price+(Price/100)*18) FROM tempaddeditems;";
				PreparedStatement pst1 = con.prepareStatement(query1);
				ResultSet rs1 = pst1.executeQuery();

				if (rs1.next()) {

					total = rs1.getString("sum(Price+(Price/100)*18)");

				}

			} catch (SQLException e1) {

				e1.printStackTrace();
			}

			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setFont(new Font("Maiandra GD", Font.BOLD, 30));
			lblNewLabel.setBounds(458, 675, 166, 49);
			panel_1.add(lblNewLabel);

			lblNewLabel.setText(total);

			JLabel lblTotal = new JLabel("Total:");
			lblTotal.setFont(new Font("Maiandra GD", Font.BOLD, 30));
			lblTotal.setBounds(369, 675, 89, 49);
			panel_1.add(lblTotal);

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		JLabel name = new JLabel("");
		name.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		name.setBounds(107, 124, 861, 36);
		panel_1.add(name);

		String name_v = "";

		try {
			String query = "SELECT Name FROM customeraddress WHERE Email=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				name_v = rs.getString("Name");

			}

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		name.setText(name_v);

		JLabel addprnt = new JLabel("");
		addprnt.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		addprnt.setBounds(117, 170, 851, 41);
		panel_1.add(addprnt);

		String addfromdata = "";
		try {
			String query = "SELECT Address FROM customeraddress WHERE Email=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				addfromdata = rs.getString("Address");

			}

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		addprnt.setText(addfromdata);

		JLabel pincode = new JLabel("");
		pincode.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		pincode.setBounds(117, 248, 851, 36);
		panel_1.add(pincode);

		String pin = "";
		try {
			String query = "SELECT Pincode FROM customeraddress WHERE Email=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				pin = rs.getString("Pincode");

			}

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		pincode.setText(pin);

		JLabel phno = new JLabel("");
		phno.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		phno.setBounds(201, 294, 767, 36);
		panel_1.add(phno);

		String ph = "";
		try {
			String query = "SELECT PhoneNo FROM customeraddress WHERE Email=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				ph = rs.getString("PhoneNo");

			}

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		phno.setText(ph);

		JLabel lblNewLabel_1_2_2_3 = new JLabel("Payment:");
		lblNewLabel_1_2_2_3.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		lblNewLabel_1_2_2_3.setBounds(10, 333, 121, 36);
		panel_1.add(lblNewLabel_1_2_2_3);

		JLabel payment = new JLabel("");
		payment.setFont(new Font("Maiandra GD", Font.BOLD, 25));
		payment.setBounds(128, 333, 840, 36);
		panel_1.add(payment);

		String pay = "";
		try {
			String query = "SELECT PaymentMethod FROM customeraddress WHERE Email=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				pay = rs.getString("PaymentMethod");

			}

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		payment.setText(pay);

		JButton btnPrintOrderInvoice = new JButton("Print Order Invoice");
		btnPrintOrderInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PrinterJob job = PrinterJob.getPrinterJob();
				job.setJobName("Print Data");

				job.setPrintable(new Printable() {
					public int print(Graphics pg, PageFormat pf, int pageNum) {
						pf.setOrientation(PageFormat.LANDSCAPE);
						if (pageNum > 0) {
							return Printable.NO_SUCH_PAGE;
						}

						Graphics2D g2 = (Graphics2D) pg;
						g2.translate(pf.getImageableX(), pf.getImageableY());
						g2.scale(0.65, 0.65);

						panel_1.print(g2);

						return Printable.PAGE_EXISTS;

					}
				});
				boolean ok = job.printDialog();
				if (ok) {
					try {

						job.print();
					} catch (PrinterException ex) {
						ex.printStackTrace();
					}
				}

			}
		});
		btnPrintOrderInvoice.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		btnPrintOrderInvoice.setBackground(Color.ORANGE);
		btnPrintOrderInvoice.setBounds(1133, 535, 281, 146);
		panel.add(btnPrintOrderInvoice);

	}
}
