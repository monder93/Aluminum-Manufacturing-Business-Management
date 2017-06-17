import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.adobe.acrobat.gui.ComboBox;

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

public class AddProject 
{
	private JFrame frame;
	private JTextField place;
	private JTextField customer;
	public static JTextField contact;
	public static JTextField color;
	public static JTextField glass;
	public Connection myConn;
	private JTextField textField;
	private JTextField textField_1;
	public static String id;
	public static String name;
	private JComboBox<String> comboBox_4;
	public static String colorId="err";
	public static String glassId="err";

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
				if (comboBox_4.getSelectedItem().toString().equals("תריס גלילה"))
					new scrollShutter();
				else
					try {
						new slidingShutter();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		shutter.setFont(new Font("Tahoma", Font.BOLD, 12));
		shutter.setBounds(297, 204, 135, 29);
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

		JLabel lblNewLabel_7 = new JLabel(
				"\u05E9\u05D3\u05D4 \u05EA\u05E8\u05D9\u05E1 \u05D2\u05DC\u05D9\u05DC\u05D4 :");
		lblNewLabel_7.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_7.setBounds(312, 249, 120, 40);
		frame.getContentPane().add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Segoe UI", Font.BOLD, 12));

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

		JCheckBox checkBox = new JCheckBox("");
		checkBox.setBounds(202, 266, 97, 23);
		frame.getContentPane().add(checkBox);

		JButton btnNewButton_1 = new JButton("\u05D0\u05D9\u05E9\u05D5\u05E8");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
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
					myConn=HelpFunctions.DbConnection();
					Statement st = myConn.createStatement();
					st.executeUpdate(q);
					JOptionPane.showMessageDialog(null, "saved");
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				try 
				{
					Statement myStmt = myConn.createStatement();
					ResultSet myRs = myStmt.executeQuery("select * from projects");
					ProjectsPage.table.setModel(DbUtils.resultSetToTableModel(myRs));

				}
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton_1.setBounds(103, 300, 329, 46);
		frame.getContentPane().add(btnNewButton_1);

		contact = new JTextField();
		contact.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		contact.setColumns(10);
		contact.setBounds(545, 42, 184, 40);
		frame.getContentPane().add(contact);

		color = new JTextField();
		color.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		color.setColumns(10);
		color.setBounds(103, 42, 184, 40);
		frame.getContentPane().add(color);

		glass = new JTextField();
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
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(545, 197, 184, 40);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(545, 249, 184, 40);
		frame.getContentPane().add(textField_1);
		
		
		
		JButton button_3 = new JButton("צבע אביזרים :");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				new partsColors();
			}
		});
		button_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_3.setBounds(103, 152, 329, 29);
		frame.getContentPane().add(button_3);
		
		JLabel background_label = new JLabel("");
		background_label.setBounds(0, 0, 884, 376);
		HelpFunctions.setBackground(background_label);
		frame.getContentPane().add(background_label);
	}
}
