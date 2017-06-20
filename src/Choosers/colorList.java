package Choosers;
import java.awt.EventQueue;
import java.awt.Point;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;

import helpClasses.HelpFunctions;
import helpClasses.MysqlConnect;
import main.AddProject;
import main.AddProjectProduct;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.ComponentOrientation;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class colorList {

	private JFrame frame;
	private JTable table;
	public String colorID="";
	public String colorName="";
	public String colorPrice="";

	private String className;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					colorList window = new colorList();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public colorList() throws SQLException {
		initialize();
	}

	public colorList(String c) throws SQLException {
		this.className=c;
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 338, 509);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 302, 448);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) 
			{
				JTable table =(JTable) e.getSource();
				Point p = e.getPoint();
				int row = table.rowAtPoint(p);
				if (e.getClickCount() == 2) 
				{
					if(className.equals("AddProjectProduct")){
						colorID=(table.getModel().getValueAt(row, 0)).toString();
						AddProjectProduct.colorId=colorID;
						colorName=(table.getModel().getValueAt(row, 1)).toString();
						AddProjectProduct.textField.setText(colorName);
						colorPrice=(table.getModel().getValueAt(row, 3)).toString();
						AddProjectProduct.colorPrice=colorPrice;
					}
					else
					{
						colorID=(table.getModel().getValueAt(row, 0)).toString();
						AddProject.colorId=colorID;
						colorName=(table.getModel().getValueAt(row, 1)).toString();
						AddProject.color.setText(colorName);
						colorPrice=(table.getModel().getValueAt(row, 3)).toString();
						AddProject.colorPrice=colorPrice;
					}
					frame.dispose();
				}
			}
		});
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane.setViewportView(table);

		//connection to database 
//		myConn = HelpFunctions.DbConnection();
//		Statement myStmt = myConn.createStatement();
		String query = "SELECT * FROM colors";
		ResultSet myRs = MysqlConnect.getDbCon().selectQuery(query);
		table.setModel(DbUtils.resultSetToTableModel(myRs));
		HelpFunctions.renderingTable(table);


	}
}
