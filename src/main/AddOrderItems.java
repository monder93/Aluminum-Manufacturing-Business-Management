package main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Choosers.glassList;
import Choosers.hardware;
import Choosers.profiles;
import helpClasses.HelpFunctions;
import helpClasses.MysqlConnect;
import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddOrderItems {

	private JFrame frame;
	public static JTextField idTextField;
	public static JTextField descriptionTextField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	String id="";
	String type="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddOrderItems window = new AddOrderItems();
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
	public AddOrderItems() {
		initialize();
	}

	public AddOrderItems(String id,String type)
	{
		this.id=id;
		this.type=type;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(450, 150, 425, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("הוספת מוצרים להזמנה");
		frame.setVisible(true);

		JLabel lblNewLabel = new JLabel("תיאור :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(254, 114, 82, 33);
		frame.getContentPane().add(lblNewLabel);

		JLabel label = new JLabel("רוחב (מ\"מ) :");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(254, 164, 82, 33);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("גובה (מ\"מ) :");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(112, 164, 73, 33);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("כמות :");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(254, 219, 82, 33);
		frame.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("הערות :");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(254, 297, 82, 33);
		frame.getContentPane().add(label_3);

		idTextField = new JTextField();
		idTextField.setEditable(false);
		idTextField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		idTextField.setBounds(65, 64, 189, 33);
		frame.getContentPane().add(idTextField);
		idTextField.setColumns(10);

		descriptionTextField_1 = new JTextField();
		descriptionTextField_1.setEditable(false);
		descriptionTextField_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		descriptionTextField_1.setColumns(10);
		descriptionTextField_1.setBounds(65, 114, 189, 33);
		frame.getContentPane().add(descriptionTextField_1);

		textField_2 = new JTextField();
		textField_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textField_2.setColumns(10);
		textField_2.setBounds(206, 167, 48, 33);
		frame.getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textField_3.setColumns(10);
		textField_3.setBounds(65, 164, 48, 33);
		frame.getContentPane().add(textField_3);

		textField_4 = new JTextField();
		textField_4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textField_4.setColumns(10);
		textField_4.setBounds(65, 219, 189, 33);
		frame.getContentPane().add(textField_4);

		JButton btnNewButton = new JButton("מוצר");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{

				try
				{
					if(type.equals("הזמנת זכוכית"))
					{
						new glassList("AddOrderItems");
					}
					else if(type.equals("הזמנת פירזול"))
					{
						new hardware("AddOrderItems");
					}
					else if(type.equals("הזמנת פרופילים"))
					{
						new profiles("AddOrderItems");
					}
					
				}
				catch(Exception e1)
				{
					e1.printStackTrace();

				}

			}
		});
		btnNewButton.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		btnNewButton.setBounds(275, 64, 89, 33);
		frame.getContentPane().add(btnNewButton);

		JTextPane textPane = new JTextPane();
		textPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textPane.setBounds(65, 281, 189, 70);
		frame.getContentPane().add(textPane);

		JButton btnNewButton_1 = new JButton("הוסף מוצר");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//				Connection myConn = HelpFunctions.DbConnection();
				String q = "INSERT INTO `ordersproducts`( `מספר הזמנה`, `מספר מוצר`, `תיאור`, `רוחב`, `גובה`, `כמות`, `הערות`) VALUES ('"+id+"','"+idTextField.getText()+"','"+descriptionTextField_1.getText()+"','"+textField_2.getText()+"','"+textField_3.getText()+"','"+textField_4.getText()+"','"+textPane.getText()+"')";
				try {
					MysqlConnect.getDbCon().insertQuery(q);
					JOptionPane.showMessageDialog(null, "נשמר");

				} catch (Exception e1) 
				{
					e1.printStackTrace();					
				}

				try
				{
					String query1="SELECT `מספר סידורי`, `מספר מוצר`, `תיאור`, `רוחב`, `גובה`, `כמות`, `הערות`  FROM `ordersproducts` WHERE `מספר הזמנה` = '"+id+"'";
					ResultSet myRs = MysqlConnect.getDbCon().selectQuery(query1);
					OrderItems.table.setModel(DbUtils.resultSetToTableModel(myRs));
					HelpFunctions.renderingTable(OrderItems.table);
				} 
				catch (SQLException e1)
				{
					e1.printStackTrace();
				}

				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(165, 393, 89, 23);
		frame.getContentPane().add(btnNewButton_1);

		JLabel background_label = new JLabel("New label");
		background_label.setBounds(0, 0, 409, 461);
		frame.getContentPane().add(background_label);
		HelpFunctions.setBackground(background_label);
	}
}
