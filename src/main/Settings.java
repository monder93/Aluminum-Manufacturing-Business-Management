package main;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import helpClasses.MysqlConnect;
import javax.swing.JEditorPane;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Settings extends JFrame
{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Settings frame = new Settings();
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
	public Settings() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(450, 200, 532, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("הגדרות");
		setVisible(true);
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setFont(new Font("Tahoma", Font.BOLD, 20));
		editorPane.setText("הגדרות");
		editorPane.setBounds(225, 0, 81, 30);
		contentPane.add(editorPane);
		setVisible(true);
		
		//----------------------------------------------password update button------------------------------------------
		JButton button = new JButton("עדכן");
		button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					String password=textField.getText().toString();
					String query = "UPDATE `settings` SET`ערך`='"+password+"' WHERE `שם משתנה`='סיסמה'";		
					MysqlConnect.getDbCon().updateQuery(query);
					LoadValues();
					JOptionPane.showMessageDialog(null, "סיסמה עודכנה");
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(267, 56, 61, 23);
		contentPane.add(button);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(335, 57, 98, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("סיסמה:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(455, 58, 61, 14);
		contentPane.add(label);

		JLabel label_1 = new JLabel("מע\"מ :");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(455, 100, 61, 14);
		contentPane.add(label_1);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setColumns(10);
		textField_1.setBounds(335, 99, 98, 20);
		contentPane.add(textField_1);

		JLabel label_2 = new JLabel("רווח :");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(455, 140, 61, 14);
		contentPane.add(label_2);

		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2.setColumns(10);
		textField_2.setBounds(335, 139, 98, 20);
		contentPane.add(textField_2);

		JLabel label_3 = new JLabel("יצור");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(455, 183, 61, 14);
		contentPane.add(label_3);

		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3.setColumns(10);
		textField_3.setBounds(335, 182, 98, 20);
		contentPane.add(textField_3);

		JLabel label_4 = new JLabel("הרכבה :");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(204, 57, 61, 14);
		contentPane.add(label_4);

		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_4.setColumns(10);
		textField_4.setBounds(84, 56, 98, 20);
		contentPane.add(textField_4);

		JLabel label_5 = new JLabel("הפדס :");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(204, 100, 61, 14);
		contentPane.add(label_5);

		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_5.setColumns(10);
		textField_5.setBounds(84, 99, 98, 20);
		contentPane.add(textField_5);

		JLabel label_6 = new JLabel("עוור :");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(204, 140, 61, 14);
		contentPane.add(label_6);

		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_6.setColumns(10);
		textField_6.setBounds(84, 139, 98, 20);
		contentPane.add(textField_6);

		JButton button_1 = new JButton("עדכן");
		button_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					String tax=textField_1.getText().toString();
					String query = "UPDATE `settings` SET`ערך`='"+tax+"' WHERE `שם משתנה`='מעמ'";		
					MysqlConnect.getDbCon().updateQuery(query);
					LoadValues();
					JOptionPane.showMessageDialog(null, "מעמ  עודכן");

				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		button_1.setBounds(267, 98, 61, 23);
		contentPane.add(button_1);

		JButton button_2 = new JButton("עדכן");
		button_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					String profit=textField_2.getText().toString();
					String query = "UPDATE `settings` SET`ערך`='"+profit+"' WHERE `שם משתנה`='רווח'";		
					MysqlConnect.getDbCon().updateQuery(query);
					LoadValues();
					JOptionPane.showMessageDialog(null, "רווח עודכן");

				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		button_2.setBounds(267, 138, 61, 23);
		contentPane.add(button_2);

		JButton button_3 = new JButton("עדכן");
		button_3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					String produce=textField_3.getText().toString();
					String query = "UPDATE `settings` SET`ערך`='"+produce+"' WHERE `שם משתנה`='יצור'";		
					MysqlConnect.getDbCon().updateQuery(query);
					LoadValues();
					JOptionPane.showMessageDialog(null, "יצור  עודכן");

				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		button_3.setBounds(267, 181, 61, 23);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("עדכן");
		button_4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					String composition=textField_4.getText().toString();
					String query = "UPDATE `settings` SET`ערך`='"+composition+"' WHERE `שם משתנה`='הרכבה'";		
					MysqlConnect.getDbCon().updateQuery(query);
					LoadValues();
					JOptionPane.showMessageDialog(null, "הרכבה עודכן");
				}
				catch (Exception e1)
				{
				e1.printStackTrace();
				}
			}
		});
		button_4.setBounds(13, 55, 61, 23);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("עדכן");
		button_5.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					String loss=textField_5.getText().toString();
					String query = "UPDATE `settings` SET`ערך`='"+loss+"' WHERE `שם משתנה`='הפסד'";		
					MysqlConnect.getDbCon().updateQuery(query);
					LoadValues();
					JOptionPane.showMessageDialog(null, "הפסד עודכן");
				}
				catch (Exception e1)
				{
				e1.printStackTrace();
				}
			}
		});
		button_5.setBounds(13, 98, 61, 23);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("עדכן");
		button_6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					String blind=textField_6.getText().toString();
					String query = "UPDATE `settings` SET`ערך`='"+blind+"' WHERE `שם משתנה`='עוור'";		
					MysqlConnect.getDbCon().updateQuery(query);
					LoadValues();
					JOptionPane.showMessageDialog(null, "עוור עודכן");
				}
				catch (Exception e1)
				{
				e1.printStackTrace();
				}
			}
		});
		button_6.setBounds(13, 138, 61, 23);
		contentPane.add(button_6);

		//--------------------------------------------------fetching values from database and setting them----------------------
		LoadValues();
	}
	private void LoadValues()
	{
		try 
		{
			ResultSet myRs = MysqlConnect.getDbCon().selectWhereQuery("settings", "שם משתנה", "סיסמה");
			myRs.next();
			textField.setText(myRs.getString(3));

			myRs = MysqlConnect.getDbCon().selectWhereQuery("settings", "שם משתנה", "מעמ");
			myRs.next();
			textField_1.setText(myRs.getString(3));

			myRs = MysqlConnect.getDbCon().selectWhereQuery("settings", "שם משתנה", "רווח");
			myRs.next();
			textField_2.setText(myRs.getString(3));

			myRs = MysqlConnect.getDbCon().selectWhereQuery("settings", "שם משתנה", "יצור");
			myRs.next();
			textField_3.setText(myRs.getString(3));

			myRs = MysqlConnect.getDbCon().selectWhereQuery("settings", "שם משתנה", "הרכבה");
			myRs.next();
			textField_4.setText(myRs.getString(3));

			myRs = MysqlConnect.getDbCon().selectWhereQuery("settings", "שם משתנה", "הפסד");
			myRs.next();
			textField_5.setText(myRs.getString(3));

			myRs = MysqlConnect.getDbCon().selectWhereQuery("settings", "שם משתנה", "עוור");
			myRs.next();
			textField_6.setText(myRs.getString(3));


		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
