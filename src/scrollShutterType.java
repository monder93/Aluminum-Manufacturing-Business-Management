import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;
import java.awt.ComponentOrientation;

public class scrollShutterType
{

	private JFrame frame;
	private JTable table;
	private Connection	myConn;

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
					scrollShutterType window = new scrollShutterType();
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
	public scrollShutterType() throws SQLException 
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
		frame.setName("שלבי תריס הזזה");

		table = new JTable();
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane.setViewportView(table);

		//connection to database 
		myConn = HelpFunctions.DbConnection();
		Statement myStmt = myConn.createStatement();
		String query = "SELECT * FROM scrollshuter";
		ResultSet myRs = myStmt.executeQuery(query);
		table.setModel(DbUtils.resultSetToTableModel(myRs));
		HelpFunctions.renderingTable(table);
	}
}
