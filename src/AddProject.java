import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AddProject {

	private JFrame frame;
	private JTextField place;
	private JTextField customer;
	private JTextField contact;
	private JTextField color;
	private JTextField glass;
	private JTextField shutter;
	public Connection myConn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProject window = new AddProject();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddProject() {
//		try {
//			myConn = DriverManager.getConnection(url, user, password);
//		
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\u05D0\u05EA\u05E8 :");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel.setBounds(739, 50, 120, 40);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u05DE\u05D6\u05DE\u05D9\u05DF :");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_1.setBounds(739, 100, 120, 40);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u05D0\u05D9\u05E9 \u05E7\u05E9\u05E8 :");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_2.setBounds(739, 150, 120, 40);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel(
				"\u05EA\u05E2\u05E9\u05D9\u05D5\u05EA \u05D0\u05DC\u05D5\u05DE\u05E0\u05D9\u05D5\u05DD :");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_3.setBounds(739, 200, 120, 40);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\u05E6\u05D1\u05E2 :");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_4.setBounds(739, 250, 120, 40);
		frame.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("\u05D6\u05D9\u05D2\u05D5\u05D2 :");
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_5.setBounds(739, 300, 120, 40);
		frame.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("\u05EA\u05E8\u05D9\u05E1 :");
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_6.setBounds(739, 350, 120, 40);
		frame.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel(
				"\u05E9\u05D3\u05D4 \u05EA\u05E8\u05D9\u05E1 \u05D2\u05DC\u05D9\u05DC\u05D4 :");
		lblNewLabel_7.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_7.setBounds(739, 400, 120, 40);
		frame.getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("\u05E6\u05D1\u05E2 \u05D0\u05D1\u05D9\u05D6\u05E8\u05D9\u05DD :");
		lblNewLabel_8.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_7.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_8.setBounds(739, 450, 120, 40);
		frame.getContentPane().add(lblNewLabel_8);

		place = new JTextField();
		place.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		place.setBounds(545, 50, 184, 40);
		frame.getContentPane().add(place);
		place.setColumns(10);

		customer = new JTextField();
		customer.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		customer.setBounds(545, 103, 184, 40);
		frame.getContentPane().add(customer);
		customer.setColumns(10);

		JComboBox company = new JComboBox();
		company.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		company.setToolTipText("\u05E7\u05DC\u05D9\u05DC");
		company.setBounds(545, 211, 184, 29);
		frame.getContentPane().add(company);

		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(545, 361, 184, 29);
		frame.getContentPane().add(comboBox_4);

		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(545, 450, 184, 31);
		frame.getContentPane().add(comboBox_6);

		JButton btnNewButton = new JButton("\u05D0\u05D9\u05E9 \u05E7\u05E9\u05E8 \u05D7\u05D3\u05E9");
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnNewButton.setBounds(339, 160, 184, 30);
		frame.getContentPane().add(btnNewButton);

		JCheckBox checkBox = new JCheckBox("");
		checkBox.setBounds(636, 410, 97, 23);
		frame.getContentPane().add(checkBox);

		JButton btnNewButton_1 = new JButton("\u05D0\u05D9\u05E9\u05D5\u05E8");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cont = contact.getText();
				String gla = glass.getText();
				int glaPr = 40;
				String col = color.getText();
				int colPr = 30;
				String cust = customer.getText();
				String plc = place.getText();
				
				try {
					String q = "insert into `projects`(`אתר`, `שם מזמין`, `צבע`, `מחיר צבע`, `זיגוג`, `מחיר זיגוג`, `איש קשר`) values('" + plc
							+ "','" + cust + "','" + col + "','" + colPr + "','" + gla + "','" + glaPr + "','" + cont
							+ "') ";
					//String q2 = "";
					myConn=HelpFunctions.DbConnection();
					Statement st = myConn.createStatement();
					st.executeUpdate(q);
					JOptionPane.showMessageDialog(null, "saved");
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					Statement myStmt = myConn.createStatement();
					ResultSet myRs = myStmt.executeQuery("select * from projects");
					ProjectsPage.table.setModel(DbUtils.resultSetToTableModel(myRs));

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton_1.setBounds(358, 504, 215, 46);
		frame.getContentPane().add(btnNewButton_1);

		contact = new JTextField();
		contact.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		contact.setColumns(10);
		contact.setBounds(545, 150, 184, 40);
		frame.getContentPane().add(contact);

		color = new JTextField();
		color.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		color.setColumns(10);
		color.setBounds(545, 250, 184, 40);
		frame.getContentPane().add(color);

		glass = new JTextField();
		glass.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		glass.setColumns(10);
		glass.setBounds(545, 300, 184, 40);
		frame.getContentPane().add(glass);

		shutter = new JTextField();
		shutter.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		shutter.setColumns(10);
		shutter.setBounds(339, 350, 184, 40);
		frame.getContentPane().add(shutter);
	}
}
