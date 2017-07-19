package main;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import com.mysql.jdbc.Connection;

import helpClasses.HelpFunctions;
import helpClasses.MysqlConnect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 *  a class for the login page 
 */
public class LoginPage extends JFrame 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField passText;;
	public  String DbPassword;
	static LoginPage frame;
	//private Connection conn;	

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
					frame = new LoginPage();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPage() 
	{
		setResizable(false);
		setTitle("מסך כניסה");
		initComponents();
	}

	private void initComponents()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 150, 406, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("כניסה");

		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if((passText.getText().compareTo(DbPassword)==0))
				{
					new MainPage();
					frame.dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "סיסמה שגויה .. נא לנסות מחדש");
			}
		});
		btnNewButton.setBounds(112, 149, 187, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("\u05E1\u05D9\u05E1\u05DE\u05D4");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(219, 105, 80, 14);
		contentPane.add(lblNewLabel);

		// password typing field
		passText = new JPasswordField();
		passText.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent e) 
			{
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					btnNewButton.doClick();
			}
		});
		passText.setBounds(112, 104, 86, 20);
		contentPane.add(passText);
		passText.setColumns(10);

		JLabel lblPleaseEnterYour = new JLabel("לכניסה למערכת , נא להכניס סיסמה");
		lblPleaseEnterYour.setForeground(Color.BLACK);
		lblPleaseEnterYour.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPleaseEnterYour.setBounds(72, 35, 356, 43);
		contentPane.add(lblPleaseEnterYour);
		JLabel background_label = new JLabel("");
		background_label.setBounds(0, 0, 400, 238);
		HelpFunctions.setBackground(background_label);
		contentPane.add(background_label);
		
		// getting the right password from the database
		try 
		{
			String query="SELECT `ערך` FROM `settings` WHERE `שם משתנה` = 'סיסמה' ";
			Statement myStmt = MysqlConnect.getDbCon().conn.createStatement();
			ResultSet res = myStmt.executeQuery(query);
			res.next();
			DbPassword=res.getString(1);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}