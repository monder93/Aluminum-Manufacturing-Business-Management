package debts;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
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
import javax.swing.table.JTableHeader;

import helpClasses.HelpFunctions;
import helpClasses.MysqlConnect;

import javax.swing.JLabel;

public class DebtsForSuppliersPage extends JFrame
{

	private JFrame frame;
	public static JTable table_1;
	public Connection	myConn;

	String table;
	String query="select * from ";
	private JButton addDebtButton;
	private JButton button_1;
	private JTextField supplierNameTextField;
	private JTextField debtsTextField;
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel logoLabel;
	private JLabel logoLabel2;
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
	public DebtsForSuppliersPage() 
	{
		initialize();
	}
	public DebtsForSuppliersPage(String table)
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
	frame.setTitle("חובות לספקים");

	logoLabel = new JLabel("New label");
	logoLabel.setBounds(566, 283, 259, 190);
	frame.getContentPane().add(logoLabel);

	logoLabel2 = new JLabel("New label");
	logoLabel2.setBounds(10, 11, 815, 82);
	frame.getContentPane().add(logoLabel2);

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 104, 534, 323);
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
	JTableHeader Theader = table_1.getTableHeader();
	Theader.setBackground(Color.green);
	Theader.setFont(new Font("Tahoma", Font.BOLD, 12));


	try
	{
//		myConn = HelpFunctions.DbConnection();
//		Statement myStmt = myConn.createStatement();
		ResultSet myRs = MysqlConnect.getDbCon().selectQuery(query+table);
		table_1.setModel(DbUtils.resultSetToTableModel(myRs));



		addDebtButton = new JButton("\u05D4\u05D5\u05E1\u05E4\u05D4");
		addDebtButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(!supplierNameTextField.getText().contentEquals("") && (!debtsTextField.getText().contentEquals("")))
					try {
						//getting current time
						SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd");
						String current_time_str = time_formatter.format(System.currentTimeMillis());

						//query to insert data
						String q = "INSERT INTO `debtsforsuppliers`( `שם ספק`, `תאריך`, `חוב`, `שולם`, `לתשלום`)  VALUES ('"+supplierNameTextField.getText()+"','"+current_time_str+"','"+debtsTextField.getText()+"','0','"+debtsTextField.getText()+"')";

						//connection to database
//						myConn=HelpFunctions.DbConnection();
//						Statement st;
//						st = myConn.createStatement();

						//execute the query
//						st.executeUpdate(q);
						MysqlConnect.getDbCon().insertQuery(q);
						//message for success
						JOptionPane.showMessageDialog(null, "saved");System.out.println(q);

						//reset TextFields
						supplierNameTextField.setText("");
						debtsTextField.setText("");

						// update the table with the new data
						ResultSet myRs = MysqlConnect.getDbCon().selectQuery(query+table);
						table_1.setModel(DbUtils.resultSetToTableModel(myRs));
						// changing JTable Cell Value Alignment
						HelpFunctions.renderingTable(table_1);

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
					DebtsForSupplierPagePaied.debtnumber=(table.getModel().getValueAt(row, 0)).toString();
					DebtsForSupplierPagePaied.debtAmount=Integer.parseInt((table.getModel().getValueAt(row, 3)).toString());
					DebtsForSupplierPagePaied.paidAmount=Integer.parseInt((table.getModel().getValueAt(row, 4)).toString());
					DebtsForSupplierPagePaied.toPayAmount=Integer.parseInt((table.getModel().getValueAt(row, 5)).toString());

					new DebtsForSupplierPagePaied();
				}
			}
		});		

		addDebtButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		addDebtButton.setBounds(708, 104, 117, 41);
		frame.getContentPane().add(addDebtButton);

		button_1 = new JButton("\u05DE\u05D7\u05D9\u05E7\u05D4");
		button_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int row = table_1.getSelectedRow();


				int response = 0;
				try{
					if(row<0)
					{
						JOptionPane.showMessageDialog(null, "בחר חוב", "row selection", JOptionPane.ERROR_MESSAGE);
						return;
					}
					else
					{
						response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					}
					if (response == JOptionPane.NO_OPTION) 
					{
						return;
					}
					else if (response == JOptionPane.YES_OPTION) 
					{
						String OID=(table_1.getModel().getValueAt(row, 0)).toString();
						String OrderId="מספר חוב";
//						Connection myConn = HelpFunctions.DbConnection();
						MysqlConnect.getDbCon().deleteRow("debtsforsupplierspaied", OrderId, OID);
						MysqlConnect.getDbCon().deleteRow("debtsforsuppliers", OrderId, OID);
						HelpFunctions.getTable("debtsforsuppliers", table_1);

						// changing JTable Cell Value Alignment
						HelpFunctions.renderingTable(table_1);


					}

				}

				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		button_1.setBounds(566, 104, 117, 41);
		frame.getContentPane().add(button_1);

		supplierNameTextField = new JTextField();
		supplierNameTextField.setColumns(10);
		supplierNameTextField.setBounds(580, 181, 103, 20);
		frame.getContentPane().add(supplierNameTextField);


		debtsTextField = new JTextField();
		debtsTextField.setColumns(10);
		debtsTextField.setBounds(580, 239, 103, 20);
		frame.getContentPane().add(debtsTextField);

		lblNewLabel = new JLabel("שם ספק");
		lblNewLabel.setBounds(732, 184, 93, 14);
		frame.getContentPane().add(lblNewLabel);

		label = new JLabel("חוב");
		label.setBounds(732, 242, 93, 14);
		frame.getContentPane().add(label);

		// changing JTable Cell Value Alignment
		HelpFunctions.renderingTable(table_1);


		JLabel background_label = new JLabel("New label");
		background_label.setBounds(0, 0, 835, 484);
		frame.getContentPane().add(background_label);
		HelpFunctions.setBackground(background_label);
		HelpFunctions.setBackground(logoLabel, "finance");
		HelpFunctions.setBackground(logoLabel2, "finance2");


	} catch (Exception e) {
		e.printStackTrace();

	}
	}
}
