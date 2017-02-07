import java.awt.ComponentOrientation;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tables extends JFrame{

	private JFrame frame;
	public static JTable table_1;
	public Connection	myConn;
	public static String Id;
	public static String name;
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
		
//		try {
//			myConn = DriverManager.getConnection(url,user,password);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

		initialize();
	}
	public Tables(String table){
		this.table=table;
//		try {
//			myConn = DriverManager.getConnection(url,user,password);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {


		

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
			myConn  = HelpFunctions.DbConnection();
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery(query+table);
			table_1.setModel(DbUtils.resultSetToTableModel(myRs));
			
			if(this.table.contentEquals("contacts"))
				frame.setTitle("טבלת לקוחות");
			if(this.table.contentEquals("suppliers"))
				frame.setTitle("טבלת ספקים");
			if(this.table.contentEquals("profiles"))
				frame.setTitle("טבלת פרופילים");
			
				
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			

		}
	}
}
