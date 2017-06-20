package main;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import helpClasses.HelpFunctions;
import helpClasses.MysqlConnect;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ProjectsPage extends JFrame
{

	private JFrame frame;
	public static JTable table;
	private JPanel contentPane;
	private JTextField searchword;
	private JComboBox comboBox;
	private JButton cancel;
	private JLabel sb;
	private JLabel sw;
	private JButton search;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					ProjectsPage frame = new ProjectsPage();
					frame.setVisible(true);
					frame.setResizable(false);
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
	public ProjectsPage() 
	{
		setTitle("Projects");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{

		setTitle("פרויקטים");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 578, 374);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 980, 626);
		contentPane.add(scrollPane);
		table = new JTable()
		{
			@Override
			public boolean isCellEditable(int row, int column) 
			{
				return column==1 || column==2 || column==3 || column==4 || column==5 || column==6 || column==7 ;                
			};
		};
		table.setAutoCreateRowSorter(true);

		//reversing JTable content to ---> right to left
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		scrollPane.setViewportView(table);



		JTableHeader Theader = table.getTableHeader();
		Theader.setBackground(Color.green);
		Theader.setFont(new Font("Tahoma", Font.BOLD, 12));

		((DefaultTableCellRenderer)Theader.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

		JButton btnNewButton = new JButton("\u05D4\u05D5\u05E1\u05E4\u05EA \u05E4\u05E8\u05D5\u05D9\u05E7\u05D8");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				AddProject newProject=new AddProject();
			}
		});
		btnNewButton.setBounds(1098, 68, 203, 46);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u05D4\u05D5\u05E1\u05E4\u05D4/\u05E2\u05D3\u05DB\u05D5\u05DF \u05DE\u05D5\u05E6\u05E8\u05D9\u05DD \u05DC\u05E4\u05E8\u05D5\u05D9\u05E7\u05D8");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				int row = table.getSelectedRow();
				if(row<0)
					JOptionPane.showMessageDialog(null, "בחר פרויקט בבקשה");
				else
				{
					String Id=(table.getModel().getValueAt(row, 0)).toString();
					new ProjectProducts(Id);
				}
			}
		});
		btnNewButton_1.setBounds(1098, 269, 203, 46);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\u05DE\u05D7\u05D9\u05E7\u05EA \u05E4\u05E8\u05D5\u05D9\u05E7\u05D8");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int row = table.getSelectedRow();
				int response = 0;
				try{
					if(row<0)
					{
						JOptionPane.showMessageDialog(null, "בחר פרויקט בבקשה", "row selection", JOptionPane.ERROR_MESSAGE);
						return;
					}
					else
					{
						response = JOptionPane.showConfirmDialog(null, "להמשיך ?", "אישור",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					}
					if (response == JOptionPane.NO_OPTION) 
					{
						return;
					}
					else if (response == JOptionPane.YES_OPTION) 
					{
						String PID=(table.getModel().getValueAt(row, 0)).toString();
						String ProId="מספר פרויקט";
//						Connection myConn = HelpFunctions.DbConnection();
						MysqlConnect.getDbCon().deleteRow("projects", ProId, PID);
						HelpFunctions.getTable("projects", table);
						HelpFunctions.renderingTable(table);
//						myConn.close();
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(1098, 206, 203, 46);
		getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("עדכון פרויקט");
		btnNewButton_3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int row=table.getSelectedRow();
				try
				{
					if(row<0)
						JOptionPane.showMessageDialog(null, "בחר פרויקט בבקשה", "row selection", JOptionPane.ERROR_MESSAGE);
					else
					{
						String id = table.getModel().getValueAt(row, 0).toString();
						String contact = table.getModel().getValueAt(row, 1).toString();
						String place = table.getModel().getValueAt(row, 2).toString();
						String costumer = table.getModel().getValueAt(row, 3).toString();
						String color = table.getModel().getValueAt(row, 4).toString();
						String colorPrice = table.getModel().getValueAt(row, 5).toString();
						String glass = table.getModel().getValueAt(row, 6).toString();
						String glassPrice = table.getModel().getValueAt(row, 7).toString();
						String query = "UPDATE `projects` SET`איש קשר`='"+contact+"',`אתר`='"+place+"',`שם מזמין`='"+costumer+"',`צבע`='"+color+"',`מחיר צבע`='"+colorPrice+"',`זיגוג`='"+glass+"',`מחיר זיגוג`='"+glassPrice+"' WHERE `מספר פרויקט`='"+id+"'";
//						Connection myConn = HelpFunctions.DbConnection();
//						Statement myStmt;
//						myStmt = myConn.createStatement();
//						myStmt.executeUpdate(query);
						MysqlConnect.getDbCon().updateQuery(query);
						HelpFunctions.getTable("projects", table);
						HelpFunctions.renderingTable(table);
						JOptionPane.showMessageDialog(null, "עודכן");
					}
				} 
				catch (SQLException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(1098, 133, 203, 46);
		getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("\u05D7\u05D9\u05E4\u05D5\u05E9");
		btnNewButton_4.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				showHide(true);
			}
		});
		btnNewButton_4.setBounds(1098, 337, 203, 46);
		getContentPane().add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("\u05D7\u05D6\u05E8\u05D4");
		btnNewButton_5.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();				
			}
		});
		btnNewButton_5.setBounds(1098, 406, 203, 46);
		getContentPane().add(btnNewButton_5);

//		Connection myConn = HelpFunctions.DbConnection();
		HelpFunctions.getTable("projects", table);
		HelpFunctions.renderingTable(table);

		sb = new JLabel("חפש לפי :");
		sb.setVisible(false);
		sb.setHorizontalAlignment(SwingConstants.RIGHT);
		sb.setBounds(1214, 478, 87, 14);
		contentPane.add(sb);

		sw = new JLabel("מילת חיפוש :");
		sw.setVisible(false);
		sw.setHorizontalAlignment(SwingConstants.RIGHT);
		sw.setBounds(1214, 526, 87, 14);
		contentPane.add(sw);

		comboBox = new JComboBox();
		comboBox.setVisible(false);
		comboBox.setBounds(1098, 475, 106, 20);
		contentPane.add(comboBox);
		comboBox.addItem("איש קשר");
		comboBox.addItem("שם מזמין");
		comboBox.addItem("אתר");

		search = new JButton("חפש");
		search.setVisible(false);
		search.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{

				String searchBy=comboBox.getSelectedItem().toString();
				String searchWord=searchword.getText();

//				Connection myConn = HelpFunctions.DbConnection();
//				Statement myStmt;
				try
				{
					String query="SELECT * FROM `projects` WHERE `"+ searchBy +"` = '"+ searchWord +"'";
//					myStmt = myConn.createStatement();
					ResultSet myRs = MysqlConnect.getDbCon().selectQuery(query);
					table.setModel(DbUtils.resultSetToTableModel(myRs));
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		});
		search.setBounds(1098, 575, 203, 46);
		contentPane.add(search);

		searchword = new JTextField();
		searchword.setVisible(false);
		searchword.setBounds(1098, 523, 106, 20);
		contentPane.add(searchword);
		searchword.setColumns(10);

		cancel = new JButton("בטל חיפוש");
		cancel.setVisible(false);
		cancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
//				Connection myConn = HelpFunctions.DbConnection();
//				Statement myStmt;
				try
				{
//					myStmt = myConn.createStatement();
					ResultSet myRs = MysqlConnect.getDbCon().selectQuery("SELECT * FROM `projects`");
					table.setModel(DbUtils.resultSetToTableModel(myRs));
					HelpFunctions.renderingTable(table);
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				showHide(false);
			}
		});
		cancel.setBounds(1098, 632, 203, 46);
		contentPane.add(cancel);

		JLabel background_label = new JLabel("New label");
		background_label.setBounds(0, 0, 1362, 705);
		HelpFunctions.setBackground(background_label);
		contentPane.add(background_label);

		// changing JTable Cell Value Alignment
		HelpFunctions.renderingTable(table);

	}
	private void showHide(boolean flag)
	{
		sb.setVisible(flag);
		sw.setVisible(flag);
		search.setVisible(flag);
		searchword.setVisible(flag);
		cancel.setVisible(flag);
		comboBox.setVisible(flag);
	}
}
