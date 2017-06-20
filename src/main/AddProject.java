package main;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;

import Choosers.Contacts;
import Choosers.colorList;
import Choosers.glassList;
import Choosers.scrollShutterType;
import Choosers.slidingShutter;
import helpClasses.HelpFunctions;
import helpClasses.MysqlConnect;
import net.proteanit.sql.DbUtils;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddProject 
{
	private JFrame frame;
	private JTextField place;
	private JTextField customer;
	public static JTextField contact;
	public static JTextField color;
	public static JTextField glass;
	//public Connection myConn;
	private JTextField adress;
	private JTextField phone;
	public static String id;
	public static String name;
	private JComboBox<String> comboBox_4;
	public static String colorId="err";
	public static String colorPrice="err";
	public static String glassId="err";
	public static String glassPrice="err";
	public static String shutterId="err";
	public static String shutterWeight="err";


	public static JTextField shutterName;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					AddProject window = new AddProject();
					window.frame.setVisible(true);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddProject() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(250, 150, 900, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setTitle("הוספת פרויקט");

		JButton button = new JButton("צבע :");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					new colorList("AddProject");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBounds(297, 49, 135, 29);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("זיגוג :");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					new glassList("AddProject");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_1.setBounds(297, 99, 135, 29);
		frame.getContentPane().add(button_1);

		JButton shutter = new JButton("תריס :");
		shutter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					if (comboBox_4.getSelectedItem().toString().equals("תריס גלילה"))
						new scrollShutterType();
					else
						new slidingShutter();

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		shutter.setFont(new Font("Tahoma", Font.BOLD, 12));
		shutter.setBounds(297, 255, 135, 29);
		frame.getContentPane().add(shutter);

		JLabel lblNewLabel = new JLabel("\u05D0\u05EA\u05E8 :");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel.setBounds(739, 93, 120, 40);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u05DE\u05D6\u05DE\u05D9\u05DF :");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_1.setBounds(739, 143, 120, 40);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel(
				"\u05EA\u05E2\u05E9\u05D9\u05D5\u05EA \u05D0\u05DC\u05D5\u05DE\u05E0\u05D9\u05D5\u05DD :");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_3.setBounds(739, 300, 120, 40);
		frame.getContentPane().add(lblNewLabel_3);

		place = new JTextField();
		place.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		place.setBounds(545, 93, 184, 40);
		frame.getContentPane().add(place);
		place.setColumns(10);

		customer = new JTextField();
		customer.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		customer.setBounds(545, 146, 184, 40);
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

		comboBox_4 = new JComboBox<String>();
		comboBox_4.setBounds(103, 205, 184, 29);
		comboBox_4.addItem("תריס גלילה");
		comboBox_4.addItem("תריס הזזה");
		frame.getContentPane().add(comboBox_4);

		JButton btnNewButton = new JButton("איש קשר :");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				new Contacts();
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnNewButton.setBounds(739, 51, 135, 30);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u05D0\u05D9\u05E9\u05D5\u05E8");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(!(contact.getText().equals(""))&&!(glass.getText().equals(""))&&!(color.getText().equals(""))&&!(place.getText().equals(""))&&!(customer.getText().equals(""))&&!(adress.getText().equals(""))&&!(phone.getText().equals("")))
				{		
					String cont = contact.getText();
					String gla = glass.getText();
					int glaPr = 40;
					String col = color.getText();
					int colPr = 30;
					String cust = customer.getText();
					String plc = place.getText();
					String add = adress.getText();
					String phonenum = phone.getText();
					String cmp = company.getSelectedItem().toString();
					String shut = shutterName.getText();
					
					try {
						String q = "INSERT INTO `projects`(`איש קשר`, `מזהה קשר`, `אתר`, `שם מזמין`, `כתובת`, `טלפון`, `צבע`, `מחיר צבע`, `זיגוג`, `מחיר זיגוג`, `תעשייה`, `תריס`) VALUES('" +cont
								+ "','" + id + "','" + plc + "','" + cust + "','" + add + "','" + phonenum + "','" + col + "','" + colPr + "','" + gla + "','" + glaPr + "','" + cmp + "','" + shut + "') ";
						//					myConn=HelpFunctions.DbConnection();
						//					Statement st = myConn.createStatement();
						//					st.executeUpdate(q);
						MysqlConnect.getDbCon().insertQuery(q);
						JOptionPane.showMessageDialog(null, "saved");
					} 
					catch (Exception e) 
					{
						e.printStackTrace();
					}
					try 
					{
						//					Statement myStmt = myConn.createStatement();
						ResultSet myRs = MysqlConnect.getDbCon().selectQuery("select * from projects");
						ProjectsPage.table.setModel(DbUtils.resultSetToTableModel(myRs));
						HelpFunctions.renderingTable(ProjectsPage.table);

					}
					catch (SQLException e1) 
					{
						e1.printStackTrace();
					}
					frame.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null , "יש למלא הכל");
				}
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton_1.setBounds(103, 306, 329, 40);
		frame.getContentPane().add(btnNewButton_1);

		contact = new JTextField();
		contact.setEditable(false);
		contact.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		contact.setColumns(10);
		contact.setBounds(545, 42, 184, 40);
		frame.getContentPane().add(contact);

		color = new JTextField();
		color.setEditable(false);
		color.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		color.setColumns(10);
		color.setBounds(103, 42, 184, 40);
		frame.getContentPane().add(color);

		glass = new JTextField();
		glass.setEditable(false);
		glass.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		glass.setColumns(10);
		glass.setBounds(103, 93, 184, 40);
		frame.getContentPane().add(glass);

		JLabel label = new JLabel("כתובת :");
		label.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label.setBounds(739, 194, 120, 40);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("טלפון :");
		label_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label_1.setBounds(739, 249, 120, 40);
		frame.getContentPane().add(label_1);

		adress = new JTextField();
		adress.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		adress.setColumns(10);
		adress.setBounds(545, 197, 184, 40);
		frame.getContentPane().add(adress);

		phone = new JTextField();
		phone.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		phone.setColumns(10);
		phone.setBounds(545, 249, 184, 40);
		frame.getContentPane().add(phone);
		
		JLabel lblNewLabel_2 = new JLabel("סוג תריס :");
		lblNewLabel_2.setBounds(297, 205, 135, 29);
		frame.getContentPane().add(lblNewLabel_2);
				
				shutterName = new JTextField();
				shutterName.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				shutterName.setEditable(false);
				shutterName.setColumns(10);
				shutterName.setBounds(103, 245, 184, 40);
				frame.getContentPane().add(shutterName);
				
						JLabel background_label = new JLabel("");
						background_label.setBounds(0, 0, 884, 376);
						HelpFunctions.setBackground(background_label);
						frame.getContentPane().add(background_label);
	}
}
