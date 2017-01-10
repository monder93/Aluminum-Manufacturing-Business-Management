import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;


public class AddProject {
	public Connection	myConn;
	static String url = "jdbc:mysql://localhost:3306/final-project?useUnicode=yes&characterEncoding=UTF-8";
	static String user = "root";
	static String password = "";
	
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

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
		
		JLabel lblNewLabel_3 = new JLabel("\u05EA\u05E2\u05E9\u05D9\u05D5\u05EA \u05D0\u05DC\u05D5\u05DE\u05E0\u05D9\u05D5\u05DD :");
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
		
		JLabel lblNewLabel_7 = new JLabel("\u05E9\u05D3\u05D4 \u05EA\u05E8\u05D9\u05E1 \u05D2\u05DC\u05D9\u05DC\u05D4 :");
		lblNewLabel_7.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_7.setBounds(739, 400, 120, 40);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("\u05E6\u05D1\u05E2 \u05D0\u05D1\u05D9\u05D6\u05E8\u05D9\u05DD :");
		lblNewLabel_8.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_7.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_8.setBounds(739, 450, 120, 40);
		frame.getContentPane().add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textField.setBounds(545, 50, 184, 40);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textField_1.setBounds(545, 103, 184, 40);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(545, 161, 184, 31);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(545, 211, 184, 29);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(545, 261, 184, 29);
		frame.getContentPane().add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(545, 311, 184, 29);
		frame.getContentPane().add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(545, 361, 184, 29);
		frame.getContentPane().add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(339, 361, 184, 29);
		frame.getContentPane().add(comboBox_5);
		
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
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					String name="שם";
					String id="מספר";
					myConn = DriverManager.getConnection(url,user,password);
					String query = "insert into pro("+name+","+id+")VALUES('שםפפפ','מספר')";
					System.out.println(query);
					Statement myStmt = myConn.createStatement();
					myStmt.executeUpdate(query);

					//PreparedStatement myStmt = (PreparedStatement)myConn.prepareStatement(query);
					//myStmt.executeUpdate();
					
					
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				} 

			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton_1.setBounds(358, 504, 215, 46);
		frame.getContentPane().add(btnNewButton_1);
	}
}
