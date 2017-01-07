import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import net.proteanit.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProjectsPage extends JFrame{

	private JFrame frame;
	private JTable table;
	private JPanel contentPane;
	static String url = "jdbc:mysql://localhost:3306/Final";
	static String user = "root";
	static String password = "";
	public Connection	myConn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectsPage frame = new ProjectsPage();
					frame.setVisible(true);
					frame.setResizable(false);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProjectsPage() {
		setTitle("Projects");
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

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 578, 374);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 980, 390);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("\u05D4\u05D5\u05E1\u05E4\u05EA \u05E4\u05E8\u05D5\u05D9\u05E7\u05D8");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddProject newProject=new AddProject();
			}
		});
		btnNewButton.setBounds(1098, 68, 203, 46);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u05D4\u05D5\u05E1\u05E4\u05D4/\u05E2\u05D3\u05DB\u05D5\u05DF \u05DE\u05D5\u05E6\u05E8\u05D9\u05DD \u05DC\u05E4\u05E8\u05D5\u05D9\u05E7\u05D8");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProjectProducts prjctPrdct = new ProjectProducts();
			}
		});
		btnNewButton_1.setBounds(1098, 136, 203, 46);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u05DE\u05D7\u05D9\u05E7\u05EA \u05E4\u05E8\u05D5\u05D9\u05E7\u05D8");
		btnNewButton_2.setBounds(1098, 206, 203, 46);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u05DE\u05D9\u05D5\u05DF");
		btnNewButton_3.setBounds(1098, 269, 203, 46);
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u05D7\u05D9\u05E4\u05D5\u05E9");
		btnNewButton_4.setBounds(1098, 337, 203, 46);
		getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("\u05D7\u05D6\u05E8\u05D4");
		btnNewButton_5.setBounds(1098, 406, 203, 46);
		getContentPane().add(btnNewButton_5);
		
		try {
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from projects");
			table.setModel(DbUtils.resultSetToTableModel(myRs));
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
