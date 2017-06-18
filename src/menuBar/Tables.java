package menuBar;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.sql.ResultSet;
import net.proteanit.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import helpClasses.HelpFunctions;
import helpClasses.MysqlConnect;
import main.AddProject;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tables extends JFrame
{
	private JFrame frame;
	public static JTable table_1;
	public static String Id;
	public static String name;
	String table;
	String query="select * from ";
	String query2="SELECT `שם` FROM `opentypes`";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{

			}
		});

	}

	/**
	 * Create the application.
	 */
	public Tables() 
	{
		initialize();
	}
	public Tables(String table)
	{
		this.table=table;
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(400, 150, 595, 391);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 569, 340);
		frame.getContentPane().add(scrollPane);
		table_1 = new JTable()
		{
			@Override
			public boolean isCellEditable(int row, int column) 
			{
				return false;                
			};
		};
		table_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				if(table.compareTo("contacts")==0)
				{
					int row = table_1.getSelectedRow();

					if (me.getClickCount() == 2)
					{
						Id=table_1.getModel().getValueAt(row, 0).toString();
						name=table_1.getModel().getValueAt(row,1).toString();
						AddProject.id=Id;
						AddProject.contact.setText(name);
					}
				}
			}
		});
		scrollPane.setViewportView(table_1);
		table_1.setBounds(0, 0, 589, 352);

		try {
			if(this.table.compareTo("opentypes")==0)
			{
				ResultSet myRs = MysqlConnect.getDbCon().selectQuery(query2);
				table_1.setModel(DbUtils.resultSetToTableModel(myRs));
			}
			else
			{
				ResultSet myRs = MysqlConnect.getDbCon().selectQuery(query+table);
				table_1.setModel(DbUtils.resultSetToTableModel(myRs));
			}
			// changing JTable Cell Value Alignment
			HelpFunctions.renderingTable(table_1);



			if(this.table.contentEquals("contacts"))
				frame.setTitle("טבלת לקוחות");
			else if(this.table.contentEquals("suppliers"))
				frame.setTitle("טבלת ספקים");
			else if(this.table.contentEquals("profiles"))
				frame.setTitle("טבלת פרופילים");
			else if(this.table.contentEquals("glass"))
				frame.setTitle(("טבלת זיגוג"));
			else if(this.table.contentEquals("colors"))
				frame.setTitle(("טבלת צבעים"));




		} 
		catch (Exception e) 
		{
			e.printStackTrace();


		}
	}
}
