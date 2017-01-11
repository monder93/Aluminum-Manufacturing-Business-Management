import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;


import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddProject {

	private JFrame frame;
	private JTextField place;
	private JTextField customer;
	public static JTextField contact;
	private JTextField color;
	private JTextField glass;
	public Connection myConn;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public static String id;
	public static String name;

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
		frame.setBounds(250, 35, 900, 700);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("צבע :");
		button.setBounds(739, 357, 135, 29);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("זיגוג :");
		button_1.setBounds(739, 410, 135, 29);
		frame.getContentPane().add(button_1);
		
		JButton shutter = new JButton("תריס :");
		shutter.setBounds(739, 461, 135, 29);
		frame.getContentPane().add(shutter);

		JLabel lblNewLabel = new JLabel("\u05D0\u05EA\u05E8 :");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel.setBounds(739, 43, 120, 40);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u05DE\u05D6\u05DE\u05D9\u05DF :");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_1.setBounds(739, 93, 120, 40);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel(
				"\u05EA\u05E2\u05E9\u05D9\u05D5\u05EA \u05D0\u05DC\u05D5\u05DE\u05E0\u05D9\u05D5\u05DD :");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_3.setBounds(739, 300, 120, 40);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_7 = new JLabel(
				"\u05E9\u05D3\u05D4 \u05EA\u05E8\u05D9\u05E1 \u05D2\u05DC\u05D9\u05DC\u05D4 :");
		lblNewLabel_7.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_7.setBounds(739, 500, 120, 40);
		frame.getContentPane().add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Segoe UI", Font.BOLD, 12));

		place = new JTextField();
		place.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		place.setBounds(545, 43, 184, 40);
		frame.getContentPane().add(place);
		place.setColumns(10);

		customer = new JTextField();
		customer.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		customer.setBounds(545, 96, 184, 40);
		frame.getContentPane().add(customer);
		customer.setColumns(10);

		JComboBox<String> company = new JComboBox<String>();
		company.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		company.setToolTipText("\u05E7\u05DC\u05D9\u05DC");
		company.setBounds(545, 311, 184, 29);
		company.addItem("קליל");
		company.addItem("שרמר");
		company.addItem("אלובין");
		frame.getContentPane().add(company);

		JComboBox<String> comboBox_4 = new JComboBox<String>();
		comboBox_4.setBounds(545, 461, 184, 29);
		comboBox_4.addItem("תריס גלילה");
		comboBox_4.addItem("תריס הזזה");
		frame.getContentPane().add(comboBox_4);

		JButton btnNewButton = new JButton("\u05D0\u05D9\u05E9 \u05E7\u05E9\u05E8 \u05D7\u05D3\u05E9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				new Contacts();
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnNewButton.setBounds(339, 260, 184, 30);
		frame.getContentPane().add(btnNewButton);

		JCheckBox checkBox = new JCheckBox("");
		checkBox.setBounds(636, 510, 97, 23);
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
		btnNewButton_1.setBounds(358, 604, 215, 46);
		frame.getContentPane().add(btnNewButton_1);

		contact = new JTextField();
		contact.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		contact.setColumns(10);
		contact.setBounds(545, 250, 184, 40);
		frame.getContentPane().add(contact);

		color = new JTextField();
		color.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		color.setColumns(10);
		color.setBounds(545, 350, 184, 40);
		frame.getContentPane().add(color);

		glass = new JTextField();
		glass.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		glass.setColumns(10);
		glass.setBounds(545, 400, 184, 40);
		frame.getContentPane().add(glass);
		
		JLabel label = new JLabel("כתובת :");
		label.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label.setBounds(739, 144, 120, 40);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("טלפון :");
		label_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label_1.setBounds(739, 199, 120, 40);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(545, 147, 184, 40);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(545, 199, 184, 40);
		frame.getContentPane().add(textField_1);
		
		JButton button_2 = new JButton("איש קשר :");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Tables("contacts");
				contact.setText(name);
			}
		});
		button_2.setBounds(739, 257, 120, 29);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("צבע אביזרים :");
		button_3.setBounds(739, 551, 135, 29);
		frame.getContentPane().add(button_3);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(545, 540, 184, 40);
		frame.getContentPane().add(textField_2);
		
		JLabel background_label = new JLabel("");
		background_label.setBounds(0, 0, 884, 661);
		HelpFunctions.setBackground(background_label);
		frame.getContentPane().add(background_label);
	}
}
