package debts;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import helpClasses.HelpFunctions;
import helpClasses.MysqlConnect;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.ComponentOrientation;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DebtsPagePaied extends JFrame 
{

	private JPanel contentPane;
	private JTable table;
	private JButton button;
	private JButton button_2;
	public static String debtnumber;
	private JLabel label;
	private JTextField payAmountTextField;
	public static int debtAmount;
	public static int paidAmount;
	public static int toPayAmount;
	private JLabel background_label;
	JComboBox comboBox;
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
					DebtsPagePaied frame = new DebtsPagePaied();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DebtsPagePaied() 
	{
		setVisible(true);
		initialize();
	}

	private void initialize()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 100, 841, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("תשלומי לקוח");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 491, 395);
		contentPane.add(scrollPane);

		table = new JTable()
		{
			@Override
			public boolean isCellEditable(int row, int column) 
			{
				return false ;                
			};
		};

		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane.setViewportView(table);

		button = new JButton("הוספה");
		button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{

				if((!payAmountTextField.getText().contentEquals("") && (Integer.parseInt(payAmountTextField.getText())<=debtAmount-paidAmount)))
				{
					//getting current time
					SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd");
					String current_time_str = time_formatter.format(System.currentTimeMillis());
					try 
					{
//						myConn = HelpFunctions.DbConnection();
//						Statement myStmt = myConn.createStatement();
						String query = "INSERT INTO `customersdebtspaied`( `מספר חוב`, `תאריך`, `סוג תשלום`, `סכום` )  VALUES ('"+debtnumber+"','"+current_time_str+"','"+comboBox.getSelectedItem().toString()+"','"+payAmountTextField.getText()+"')";			
						MysqlConnect.getDbCon().insertQuery(query);

						String query2="SELECT * FROM `customersdebtspaied` WHERE `מספר חוב` = '"+debtnumber+"' ";
						ResultSet myRs = MysqlConnect.getDbCon().selectQuery(query2);

						System.out.println(query2);
						table.setModel(DbUtils.resultSetToTableModel(myRs));

						paidAmount+=Integer.parseInt(payAmountTextField.getText());
						toPayAmount=debtAmount-paidAmount;

						//insert data to DebtsPage table
						String query3="UPDATE `customersdebts` SET`שולם`="+paidAmount+",`לתשלום`="+toPayAmount+" WHERE `מספר חוב` = "+debtnumber+"";
						MysqlConnect.getDbCon().updateQuery(query3);
						System.out.println(query3);

						String query4="select * from `customersdebts`";
						myRs = MysqlConnect.getDbCon().selectQuery(query4);

						System.out.println(query4);
						DebtsPage.table_1.setModel(DbUtils.resultSetToTableModel(myRs));

						payAmountTextField.setText("");

						// changing JTable Cell Value Alignment
						HelpFunctions.renderingTable(table);

						
						// changing JTable Cell Value Alignment
						HelpFunctions.renderingTable(DebtsPage.table_1);





					} catch (Exception e2)
					{
						e2.printStackTrace();
						// TODO: handle exception
					}

				}
				else
				{
					if(payAmountTextField.getText().equals(""))
						JOptionPane.showMessageDialog(null, "תכניס סכום");
					else
						JOptionPane.showMessageDialog(null, "סכום מקסימלי "+(debtAmount-paidAmount));
				}
			}}
				);
		button.setBounds(679, 69, 124, 40);
		contentPane.add(button);

		button_2 = new JButton("מחיקה");
		button_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				int row = table.getSelectedRow();


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
						String PID=(table.getModel().getValueAt(row, 1)).toString();
						String ProId="מספר תשלום";
//						Connection myConn = HelpFunctions.DbConnection();
						paidAmount-=Integer.parseInt((table.getModel().getValueAt(row, 4)).toString());
						toPayAmount=debtAmount-paidAmount;
						MysqlConnect.getDbCon().deleteRow("customersdebtspaied", ProId, PID);
						
						String query2="SELECT * FROM `customersdebtspaied` WHERE `מספר חוב` = '"+debtnumber+"' ";
						ResultSet myRs = MysqlConnect.getDbCon().selectQuery(query2);
						
						System.out.println(query2);
						table.setModel(DbUtils.resultSetToTableModel(myRs));
						
						// changing JTable Cell Value Alignment
						HelpFunctions.renderingTable(table);

						
						//insert data to DebtsPage table
						String query3="UPDATE `customersdebts` SET`שולם`="+paidAmount+",`לתשלום`="+toPayAmount+" WHERE `מספר חוב` = "+debtnumber+"";
						MysqlConnect.getDbCon().updateQuery(query3);
						System.out.println(query3);

						String query4="select * from `customersdebts`";
						//myRs = myStmt.executeQuery(query4);
						myRs = MysqlConnect.getDbCon().selectQuery(query4);

						System.out.println(query4);
						DebtsPage.table_1.setModel(DbUtils.resultSetToTableModel(myRs));
						
						// changing JTable Cell Value Alignment
						HelpFunctions.renderingTable(DebtsPage.table_1);
					}

				}

				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
	});
		button_2.setBounds(528, 69, 124, 40);
		contentPane.add(button_2);

		try 
		{			
//			myConn = HelpFunctions.DbConnection();
//			Statement myStmt = myConn.createStatement();

			String query="SELECT * FROM `customersdebtspaied` WHERE `מספר חוב` = '"+debtnumber+"' ";
			ResultSet myRs = MysqlConnect.getDbCon().selectQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(myRs));

			JLabel lblNewLabel = new JLabel("סוג תשלום :");
			lblNewLabel.setBounds(711, 172, 92, 34);
			contentPane.add(lblNewLabel);

			label = new JLabel("סכום :");
			label.setBounds(733, 260, 70, 34);
			contentPane.add(label);



			payAmountTextField = new JTextField();
			payAmountTextField.setColumns(10);
			payAmountTextField.setBounds(566, 267, 86, 20);
			contentPane.add(payAmountTextField);
			
			comboBox = new JComboBox();
			comboBox.setBounds(566, 172, 86, 34);
			contentPane.add(comboBox);
			comboBox.addItem("מזומן");
			comboBox.addItem("ציק");
			comboBox.addItem("ויזה");

			// changing JTable Cell Value Alignment
			HelpFunctions.renderingTable(table);
			

			background_label = new JLabel("New label");
			background_label.setBounds(0, 0, 825, 475);
			contentPane.add(background_label);
			HelpFunctions.setBackground(background_label);
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
}
}
