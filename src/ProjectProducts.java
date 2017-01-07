import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ProjectProducts extends JFrame{

	private JFrame frame;
	private JTable table;
	private JPanel contentPane;
	static String url = "jdbc:mysql://localhost:3306/Final";
	static String user = "root";
	static String password = "";
	public Connection	myConn;
	private ButtonGroup proNumBG= new ButtonGroup();
	private ButtonGroup  berzolNumBG= new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectProducts frame = new ProjectProducts();
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
	public ProjectProducts() {
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
		scrollPane.setBounds(10, 419, 1342, 286);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		try {
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from projects");
			table.setModel(DbUtils.resultSetToTableModel(myRs));
		} catch (Exception e) {
			e.printStackTrace();

		}
			JLabel lblNewLabel = new JLabel("\u05E1\u05D4\"\u05DB \u05DE\u05D7\u05D9\u05E8 \u05D4\u05E4\u05E8\u05D5\u05D9\u05E7\u05D8(\u05E9\"\u05D7) :");
			lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
			lblNewLabel.setBounds(1194, 48, 158, 24);
			contentPane.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("\u05DE\u05D7\u05D9\u05E8 \u05DE\u05DE\u05D5\u05E6\u05E2 \u05DC\u05DE\u05D5\u05E6\u05E8(\u05E9\"\u05D7) :");
			lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
			lblNewLabel_1.setBounds(1194, 83, 158, 24);
			contentPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("\u05DE\u05D7\u05D9\u05E8 \u05D4\u05DE\u05D5\u05E6\u05E8(\u05E9\"\u05D7) :");
			lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
			lblNewLabel_2.setBounds(1194, 118, 158, 24);
			contentPane.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("0");
			lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			lblNewLabel_3.setBounds(1145, 48, 39, 24);
			contentPane.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("0");
			lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			lblNewLabel_4.setBounds(1145, 83, 39, 24);
			contentPane.add(lblNewLabel_4);
			
			JLabel lblNewLabel_5 = new JLabel("0");
			lblNewLabel_5.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			lblNewLabel_5.setBounds(1145, 118, 39, 24);
			contentPane.add(lblNewLabel_5);
			
			JLabel lblNewLabel_6 = new JLabel("\u05DE\u05E1' \u05E4\u05E8\u05D5\u05E4\u05D9\u05DC\u05D9\u05DD :");
			lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 12));
			lblNewLabel_6.setBounds(967, 17, 119, 24);
			contentPane.add(lblNewLabel_6);
			
			JRadioButton rdbtnNewRadioButton = new JRadioButton("\u05E7\u05DC\u05D9\u05DC");
			rdbtnNewRadioButton.setHorizontalTextPosition(SwingConstants.LEFT);
			rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.RIGHT);
			rdbtnNewRadioButton.setBounds(963, 48, 123, 23);
			contentPane.add(rdbtnNewRadioButton);
			
			JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u05D0\u05DC\u05D5\u05D1\u05D9\u05DF");
			rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.RIGHT);
			rdbtnNewRadioButton_1.setHorizontalTextPosition(SwingConstants.LEFT);
			rdbtnNewRadioButton_1.setBounds(963, 74, 123, 23);
			contentPane.add(rdbtnNewRadioButton_1);
			
			JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("\u05E9\u05E8\u05DE\u05E8");
			rdbtnNewRadioButton_2.setHorizontalTextPosition(SwingConstants.LEFT);
			rdbtnNewRadioButton_2.setHorizontalAlignment(SwingConstants.RIGHT);
			rdbtnNewRadioButton_2.setBounds(963, 100, 123, 23);
			contentPane.add(rdbtnNewRadioButton_2);
			
			JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("\u05D0\u05E7\u05E1\u05D8\u05DC");
			rdbtnNewRadioButton_3.setHorizontalTextPosition(SwingConstants.LEFT);
			rdbtnNewRadioButton_3.setHorizontalAlignment(SwingConstants.RIGHT);
			rdbtnNewRadioButton_3.setBounds(963, 126, 123, 23);
			contentPane.add(rdbtnNewRadioButton_3);
			
			JLabel lblNewLabel_7 = new JLabel("\u05DE\u05E1' \u05E4\u05D9\u05E8\u05D6\u05D5\u05DC :");
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_7.setFont(new Font("Segoe UI", Font.BOLD, 12));
			lblNewLabel_7.setBounds(835, 17, 108, 24);
			contentPane.add(lblNewLabel_7);
			
			JRadioButton radioButton = new JRadioButton("\u05E7\u05DC\u05D9\u05DC");
			radioButton.setHorizontalTextPosition(SwingConstants.LEFT);
			radioButton.setHorizontalAlignment(SwingConstants.RIGHT);
			radioButton.setBounds(807, 48, 136, 23);
			contentPane.add(radioButton);
			
			JRadioButton radioButton_1 = new JRadioButton("\u05D0\u05DC\u05D5\u05D1\u05D9\u05DF");
			radioButton_1.setHorizontalTextPosition(SwingConstants.LEFT);
			radioButton_1.setHorizontalAlignment(SwingConstants.RIGHT);
			radioButton_1.setBounds(807, 74, 136, 23);
			contentPane.add(radioButton_1);
			
			JRadioButton radioButton_2 = new JRadioButton("\u05D0\u05E7\u05E1\u05D8\u05DC");
			radioButton_2.setHorizontalTextPosition(SwingConstants.LEFT);
			radioButton_2.setHorizontalAlignment(SwingConstants.RIGHT);
			radioButton_2.setBounds(807, 100, 136, 23);
			contentPane.add(radioButton_2);
			
			JRadioButton radioButton_3 = new JRadioButton("\u05D0\u05E8\u05E4\u05DC");
			radioButton_3.setHorizontalTextPosition(SwingConstants.LEFT);
			radioButton_3.setHorizontalAlignment(SwingConstants.RIGHT);
			radioButton_3.setBounds(807, 126, 136, 23);
			contentPane.add(radioButton_3);
			
			JLabel lblNewLabel_8 = new JLabel("");
			lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\hosam\\workspace\\Final-Project\\Aluminum-Manufacturing-Business-Management\\src\\img\\background.jpg"));
			lblNewLabel_8.setBounds(69, 24, 225, 265);
			contentPane.add(lblNewLabel_8);
			proNumBG.add(rdbtnNewRadioButton);
			proNumBG.add(rdbtnNewRadioButton_1);
			proNumBG.add(rdbtnNewRadioButton_2);
			proNumBG.add(rdbtnNewRadioButton_3);
			
			berzolNumBG.add(radioButton);
			berzolNumBG.add(radioButton_1);
			berzolNumBG.add(radioButton_2);
			berzolNumBG.add(radioButton_3);
			
			JButton btnNewButton = new JButton("New button");
			btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			btnNewButton.setBounds(587, 48, 123, 46);
			contentPane.add(btnNewButton);
			
			JButton button = new JButton("New button");
			button.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			button.setBounds(587, 98, 123, 46);
			contentPane.add(button);
			
			JButton button_1 = new JButton("New button");
			button_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			button_1.setBounds(587, 148, 123, 46);
			contentPane.add(button_1);
			
			JButton button_2 = new JButton("New button");
			button_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			button_2.setBounds(587, 198, 123, 47);
			contentPane.add(button_2);
			
			JButton button_3 = new JButton("New button");
			button_3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			button_3.setBounds(438, 48, 123, 46);
			contentPane.add(button_3);
			
			JButton button_4 = new JButton("New button");
			button_4.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			button_4.setBounds(438, 98, 123, 46);
			contentPane.add(button_4);
			
			JButton button_5 = new JButton("New button");
			button_5.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			button_5.setBounds(438, 148, 123, 46);
			contentPane.add(button_5);
			
			JButton button_6 = new JButton("New button");
			button_6.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			button_6.setBounds(438, 198, 123, 46);
			contentPane.add(button_6);
			
			JButton button_7 = new JButton("\u05D4\u05D5\u05E1\u05E4\u05EA \u05DE\u05D5\u05E6\u05E8 \u05DC\u05E4\u05E8\u05D5\u05D9\u05E7\u05D8");
			button_7.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			button_7.setBounds(1108, 346, 152, 46);
			contentPane.add(button_7);
			
			JButton button_8 = new JButton("\u05E2\u05D3\u05DB\u05D5\u05DF");
			button_8.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			button_8.setBounds(922, 346, 152, 46);
			contentPane.add(button_8);
			
			JButton button_9 = new JButton("\u05DE\u05D7\u05D9\u05E7\u05D4");
			button_9.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			button_9.setBounds(742, 346, 152, 46);
			contentPane.add(button_9);
			
			JButton button_10 = new JButton("\u05D4\u05E2\u05EA\u05E7\u05D4");
			button_10.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			button_10.setBounds(552, 346, 158, 46);
			contentPane.add(button_10);
			
			JButton button_11 = new JButton("\u05E0\u05D9\u05EA\u05D5\u05D7 \u05E2\u05DC\u05D9\u05D5\u05EA");
			button_11.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			button_11.setBounds(368, 346, 152, 46);
			contentPane.add(button_11);
			
			JButton button_12 = new JButton("\u05D7\u05D6\u05E8\u05D4");
			button_12.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			button_12.setBounds(192, 346, 152, 46);
			contentPane.add(button_12);
			
		
	}
}
