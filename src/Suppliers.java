import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Suppliers extends JFrame {

	private JFrame frame;
	private JTable table;
	public Connection	myConn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Suppliers frame = new Suppliers();
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
	public Suppliers() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 374);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(61, 56, 724, 381);
		getContentPane().add(table);
		
		JButton btnNewButton = new JButton("\u05D4\u05D5\u05E1\u05E4\u05EA \u05E1\u05E4\u05E7");
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnNewButton.setBounds(838, 82, 212, 74);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u05E2\u05D3\u05DB\u05D5\u05DF");
		btnNewButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(838, 181, 212, 74);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u05DE\u05D7\u05D9\u05E7\u05D4");
		btnNewButton_2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnNewButton_2.setBounds(838, 279, 212, 74);
		getContentPane().add(btnNewButton_2);
		
		try {
			myConn = HelpFunctions.DbConnection();
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from suppliers");
			table.setModel(DbUtils.resultSetToTableModel(myRs));
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
