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
import main.ProjectProducts;
import main.ShowUpdateProjectProduct;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.ComponentOrientation;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class glassList {

	private JFrame frame;
	private JTable table;
	public String glassID="";
	public String glassPrice="";
	public String glassName="";
	private String className;


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
					glassList window = new glassList();
					window.frame.setVisible(true);
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
	 * @throws SQLException 
	 */
	public glassList() throws SQLException 
	{

		initialize();
	}

	public glassList(String c) throws SQLException 
	{
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
		frame.setBounds(100, 100, 878, 509);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 852, 448);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent e) 
			{
				JTable table =(JTable) e.getSource();
				Point p = e.getPoint();
				int row = table.rowAtPoint(p);
				if (e.getClickCount() == 2) 
				{
					if(className.equals("AddProjectProduct"))
					{
						glassID=(table.getModel().getValueAt(row, 0)).toString();
						AddProjectProduct.glassId=glassID;
						glassName=(table.getModel().getValueAt(row, 1)).toString();
						AddProjectProduct.textField_1.setText(glassName);
						glassPrice=(table.getModel().getValueAt(row, 2)).toString();
						AddProjectProduct.glassPrice=glassPrice;
						ProjectProducts.glassPrice=Double.parseDouble(glassPrice);

					}
					else if(className.equals("UpdateProjectProduct"))
					{
						glassName=(table.getModel().getValueAt(row, 1)).toString();
						ShowUpdateProjectProduct.glassTextField.setText(glassName);
						ShowUpdateProjectProduct.glassPrice=(double) table.getModel().getValueAt(row, 2);
					}
					else
					{
						glassID=(table.getModel().getValueAt(row, 0)).toString();
						AddProject.glassId=glassID;
						glassName=(table.getModel().getValueAt(row, 1)).toString();
						AddProject.glass.setText(glassName);
						glassPrice=(table.getModel().getValueAt(row, 2)).toString();
						AddProject.glassPrice=glassPrice;
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
		String query = "SELECT * FROM glass";
		ResultSet myRs = MysqlConnect.getDbCon().selectQuery(query);
		table.setModel(DbUtils.resultSetToTableModel(myRs));
		HelpFunctions.renderingTable(table);


	}
}