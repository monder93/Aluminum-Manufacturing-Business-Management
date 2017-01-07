import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import net.proteanit.sql.*;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Tables extends JFrame{

	private JFrame frame;
	public static JTable table_1;
	static String url = "jdbc:mysql://localhost:3306/Final";
	static String user = "root";
	static String password = "";
	public Connection	myConn;
	
	String table;
	String query="select * from ";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
//				try {
//					Tables window = new Tables();
//					window.frame.setVisible(true);
//					window.frame.setResizable(false);
//
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
			}
		});
	
	}

	/**
	 * Create the application.
	 */
	public Tables() {
		
		try {
			myConn = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		initialize();
	}
	public Tables(String table){
		this.table=table;
		try {
			myConn = DriverManager.getConnection(url,user,password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {


		

		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 595, 391);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 569, 340);
		frame.getContentPane().add(scrollPane);
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setBounds(0, 0, 589, 352);

		try {
//			Class.forName("com.mysql.jdbc.Driver").newInstance();
//			Connection myConn = DriverManager.getConnection(url,user,password);
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery(query+table);
			table_1.setModel(DbUtils.resultSetToTableModel(myRs));
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
