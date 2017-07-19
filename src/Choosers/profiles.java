package Choosers;
import java.awt.EventQueue;
import java.awt.Point;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;

import helpClasses.HelpFunctions;
import helpClasses.MysqlConnect;
import main.AddOrderItems;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.ComponentOrientation;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/*
 * this class for choosing profiles list
 * */

public class profiles 
{

	private JFrame frame;
	private JTable table;
	private String type;

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
					profiles window = new profiles();
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
	public profiles(String type) throws SQLException
	{
		this();
		this.type=type;
	}
	public profiles() throws SQLException
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 428, 509);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 392, 448);
		frame.getContentPane().add(scrollPane);
		frame.setName("פרופילים");
		frame.setVisible(true);
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
					if(type.equals("AddOrderItems"))
					{
						String profileID=(table.getModel().getValueAt(row, 3)).toString();
						AddOrderItems.idTextField.setText(profileID);
						String profileName=(table.getModel().getValueAt(row, 4)).toString();
						AddOrderItems.descriptionTextField_1.setText(profileName);
						frame.dispose();
					}

				}
			}
		});
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane.setViewportView(table);

		String query = "SELECT * FROM profiles";
		ResultSet myRs = MysqlConnect.getDbCon().selectQuery(query);
		table.setModel(DbUtils.resultSetToTableModel(myRs));
		HelpFunctions.renderingTable(table);
	}
}
