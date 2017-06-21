package main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

import Choosers.colorList;
import Choosers.glassList;
import helpClasses.HelpFunctions;
import helpClasses.MysqlConnect;
import net.proteanit.sql.DbUtils;
import products.ProductFactory;
import products.Products;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.ComponentOrientation;

public class AddProjectProduct 
{

	private JFrame frame;
	public static JTextField textField;
	public static JTextField textField_1;
	public static JTextField textField_4;
	public static JTextField textField_5;
	public static JTextField textField_6;
	public static JTextField textField_7;
	private JTextField textField_8;
	public static String colorId="err";
	public static String glassId="err";
	public static int proId ;
	public static int wingsNumber ;
	public static String type;
	public static String series;
	private String ProjectId=ProjectProducts.id;
	public static String colorPrice="err";
	public static String glassPrice="err";
	public static JLabel proPic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {
					AddProjectProduct window = new AddProjectProduct();
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
	public AddProjectProduct()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(350, 120, 660, 460);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("הוספת מוצר לפרויקט");
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JButton chooseProduct = new JButton("בחירת מוצר");
		chooseProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				new product();
			}
		});
		chooseProduct.setBounds(363, 58, 214, 54);
		frame.getContentPane().add(chooseProduct);

		JLabel lblNewLabel = new JLabel("סדרה");
		lblNewLabel.setBounds(531, 148, 46, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("תיאור");
		lblNewLabel_1.setBounds(531, 194, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("רוחב");
		lblNewLabel_2.setBounds(531, 240, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("גובה");
		lblNewLabel_3.setBounds(531, 280, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("כמות");
		lblNewLabel_4.setBounds(531, 320, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);

		proPic = new JLabel("תמונה");
		proPic.setBounds(76, 58, 188, 168);
		frame.getContentPane().add(proPic);
		HelpFunctions.setBackground(proPic,"nopic");

		JButton btnNewButton = new JButton("צבע");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					new colorList("AddProjectProduct");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}	
			}
		});
		btnNewButton.setBounds(270, 240, 89, 23);
		frame.getContentPane().add(btnNewButton);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textField.setBounds(76, 240, 184, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton button = new JButton("זיגוג");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					new glassList("AddProjectProduct");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(270, 280, 89, 23);
		frame.getContentPane().add(button);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textField_1.setColumns(10);
		textField_1.setBounds(76, 280, 184, 20);
		frame.getContentPane().add(textField_1);

		JButton btnNewButton_1 = new JButton("אישור");

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				double price=0;
				if(!(textField.getText().equals(""))&&!(textField_1.getText().equals(""))&&!(textField_4.getText().equals(""))&&!(textField_5.getText().equals(""))&&!(textField_6.getText().equals(""))&&!(textField_7.getText().equals(""))&&!(textField_8.getText().equals("")))
				{
					try {
						ProductFactory pr = new ProductFactory();
						Products p = pr.getProduct(type, Double.parseDouble(textField_6.getText().toString()), Double.parseDouble(textField_7.getText().toString()),36.18, 45,String.valueOf(series), 2);
						price=p.calculatePrice();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}


					String query="INSERT INTO `projectsproducts`(`מספר פרויקט`, `קוד מוצר`, `תיאור`, `סדרה`, `רוחב`, `גובה`, `כמות`, `צבע`, `זיגוג`, `מחיר`) VALUES ('"+ProjectId+"','"+proId+"','"+textField_5.getText().toString()+"','"+textField_4.getText().toString()+"','"+textField_6.getText().toString()+"','"+textField_7.getText().toString()+"','"+textField_8.getText().toString()+"','"+textField.getText().toString()+"','"+textField_1.getText().toString()+"','"+price+"')";
					try {
						MysqlConnect.getDbCon().insertQuery(query);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					try 
					{
						ResultSet myRs;
						myRs = MysqlConnect.getDbCon().selectQuery("SELECT * FROM `projectsProducts` WHERE `מספר פרויקט` = '"+ProjectProducts.id +"'  ");
						ProjectProducts.table.setModel(DbUtils.resultSetToTableModel(myRs));
						HelpFunctions.renderingTable(ProjectProducts.table);
						
						double allPrice=ProjectProducts.calcAllProductPrice();
						ProjectProducts.lblNewLabel_3.setText(String.valueOf(allPrice));
						ProjectProducts.label_1.setText(String.valueOf(allPrice*1.17));
					} 
					catch (SQLException e1) 
					{
						e1.printStackTrace();
					}
					
					frame.dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "יש למלא הכל");
			}
		});
		btnNewButton_1.setBounds(363, 364, 214, 47);
		frame.getContentPane().add(btnNewButton_1);

		JButton button_3 = new JButton("ביטול");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		button_3.setBounds(76, 364, 214, 47);
		frame.getContentPane().add(button_3);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textField_4.setBounds(401, 145, 120, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textField_5.setColumns(10);
		textField_5.setBounds(286, 191, 235, 20);
		frame.getContentPane().add(textField_5);

		textField_6 = new JTextField();
		textField_6.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textField_6.setColumns(10);
		textField_6.setBounds(401, 237, 120, 20);
		frame.getContentPane().add(textField_6);

		textField_7 = new JTextField();
		textField_7.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textField_7.setColumns(10);
		textField_7.setBounds(401, 277, 120, 20);
		frame.getContentPane().add(textField_7);

		textField_8 = new JTextField();
		textField_8.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textField_8.setColumns(10);
		textField_8.setBounds(401, 317, 120, 20);
		frame.getContentPane().add(textField_8);

		JLabel background_label = new JLabel("רקע");
		background_label.setBounds(0, 0, 644, 561);
		frame.getContentPane().add(background_label);
		HelpFunctions.setBackground(background_label);

	}

}
