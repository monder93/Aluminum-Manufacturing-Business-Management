import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class DebtsPage extends JFrame{

	private JFrame frame;
	public static JTable table_1;
	public Connection	myConn;
	
	String table;
	String query="select * from ";
	private JButton btnNewButton;
	private JButton button;
	private JButton button_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
//				try {
//					DebtsPage window = new DebtsPage();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DebtsPage() {
		initialize();
	}
	public DebtsPage(String table) {
		this.table=table;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {frame = new JFrame();
	frame.setResizable(false);
	frame.setBounds(250, 150, 841, 513);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setExtendedState(JFrame.MAXIMIZED_BOTH);
	frame.setVisible(true);
	frame.getContentPane().setLayout(null);		
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 144, 815, 340);
	frame.getContentPane().add(scrollPane);
	table_1 = new JTable();
	//table_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	scrollPane.setViewportView(table_1);
	table_1.setBounds(0, 0, 589, 352);

	try {
//		Class.forName("com.mysql.jdbc.Driver").newInstance();
		myConn = HelpFunctions.DbConnection();
		Statement myStmt = myConn.createStatement();
		ResultSet myRs = myStmt.executeQuery(query+table);
		table_1.setModel(DbUtils.resultSetToTableModel(myRs));
		
		btnNewButton = new JButton("\u05D4\u05D5\u05E1\u05E4\u05D4");
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNewButton.setBounds(546, 42, 117, 41);
		frame.getContentPane().add(btnNewButton);
		
		button = new JButton("\u05E2\u05D3\u05DB\u05D5\u05DF");
		button.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button.setBounds(370, 42, 117, 41);
		frame.getContentPane().add(button);
		
		button_1 = new JButton("\u05DE\u05D7\u05D9\u05E7\u05D4");
		button_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(192, 42, 117, 41);
		frame.getContentPane().add(button_1);
		
//		button_2 = new JButton("\u05EA\u05D6\u05DB\u05D5\u05E8\u05EA");
//		button_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
//		button_2.setBounds(204, 42, 117, 41);
//		frame.getContentPane().add(button_2);
//		
//		button_3 = new JButton("\u05D7\u05D6\u05E8\u05D4");
//		button_3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
//		button_3.setBounds(47, 42, 117, 41);
//		frame.getContentPane().add(button_3);
	} catch (Exception e) {
		e.printStackTrace();

	}
}


}
