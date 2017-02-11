import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class DebtsPage extends JFrame
{

	private JFrame frame;
	public static JTable table_1;
	public Connection	myConn;
	
	String table;
	String query="select * from ";
	private JButton addDebtButton;
	private JButton button_1;
	private JTextField customerNameTextField;
	private JTextField debtsTextField;
	private JLabel lblNewLabel;
	private JLabel label;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() {

			}
		});
	}

	/**
	 * Create the application.
	 */
	public DebtsPage() 
	{
		initialize();
	}
	public DebtsPage(String table)
	{
		this.table=table;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {frame = new JFrame();
	frame.setResizable(false);
	frame.setBounds(250, 150, 841, 513);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setExtendedState(JFrame.MAXIMIZED_BOTH);
	frame.setVisible(true);
	frame.getContentPane().setLayout(null);	
	frame.setTitle("לקוחות חייבים");
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 104, 534, 369);
	frame.getContentPane().add(scrollPane);
	table_1 = new JTable()
	 {
	    @Override
	    public boolean isCellEditable(int row, int column) 
	    {
	        return column==1 ||  column==3 ;                
	    };
	};

	table_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	scrollPane.setViewportView(table_1);
	table_1.setBounds(0, 0, 589, 352);


	try
	{
		myConn = HelpFunctions.DbConnection();
		Statement myStmt = myConn.createStatement();
		ResultSet myRs = myStmt.executeQuery(query+table);
		table_1.setModel(DbUtils.resultSetToTableModel(myRs));
		

		
		addDebtButton = new JButton("\u05D4\u05D5\u05E1\u05E4\u05D4");
		addDebtButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(!customerNameTextField.getText().contentEquals("") && (!debtsTextField.getText().contentEquals("")))
				try {
					//getting current time
					SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd");
					String current_time_str = time_formatter.format(System.currentTimeMillis());
					
					//query to insert data
					String q = "INSERT INTO `customersdebts`( `שם לקוח`, `תאריך`, `חוב`, `שולם`, `לתשלום`)  VALUES ('"+customerNameTextField.getText()+"','"+current_time_str+"','"+debtsTextField.getText()+"','0','0')";	
					
					//connection to database
					myConn=HelpFunctions.DbConnection();
					Statement st;
					st = myConn.createStatement();
					
					//execute the query
					st.executeUpdate(q);
					//message for success
					JOptionPane.showMessageDialog(null, "saved");System.out.println(q);
					
					//reset TextFields
					customerNameTextField.setText("");
					debtsTextField.setText("");
					
					// update the table with the new data
					ResultSet myRs = myStmt.executeQuery(query+table);
					table_1.setModel(DbUtils.resultSetToTableModel(myRs));
					
				} 
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
			
			}
				
		});
		
		table_1.addMouseListener(new MouseAdapter() 
		{
		    public void mousePressed(MouseEvent me)
		    {
		        JTable table =(JTable) me.getSource();
		        Point p = me.getPoint();
		        int row = table.rowAtPoint(p);
		        if (me.getClickCount() == 2) 
		        {
					DebtsPagePaied.debtnumber=(table.getModel().getValueAt(row, 0)).toString();
					DebtsPagePaied.debtAmount=Integer.parseInt((table.getModel().getValueAt(row, 3)).toString());
					DebtsPagePaied.paidAmount=Integer.parseInt((table.getModel().getValueAt(row, 4)).toString());
					DebtsPagePaied.toPayAmount=Integer.parseInt((table.getModel().getValueAt(row, 5)).toString());

		        	new DebtsPagePaied();
		        }
		    }
		});		
		
		addDebtButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		addDebtButton.setBounds(708, 104, 117, 41);
		frame.getContentPane().add(addDebtButton);
		
		button_1 = new JButton("\u05DE\u05D7\u05D9\u05E7\u05D4");
		button_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(566, 104, 117, 41);
		frame.getContentPane().add(button_1);
		
		customerNameTextField = new JTextField();
		customerNameTextField.setColumns(10);
		customerNameTextField.setBounds(580, 222, 103, 20);
		frame.getContentPane().add(customerNameTextField);
		
		
		debtsTextField = new JTextField();
		debtsTextField.setColumns(10);
		debtsTextField.setBounds(580, 280, 103, 20);
		frame.getContentPane().add(debtsTextField);
		
		lblNewLabel = new JLabel("שם לקוח");
		lblNewLabel.setBounds(732, 225, 93, 14);
		frame.getContentPane().add(lblNewLabel);
		
		label = new JLabel("חוב");
		label.setBounds(732, 283, 93, 14);
		frame.getContentPane().add(label);
		
		JLabel background_label = new JLabel("New label");
		background_label.setBounds(0, 0, 835, 484);
		frame.getContentPane().add(background_label);
		HelpFunctions.setBackground(background_label);
	} catch (Exception e) {
		e.printStackTrace();

	}
}
}
