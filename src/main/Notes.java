package main;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.JTableHeader;

import helpClasses.HelpFunctions;
import helpClasses.MysqlConnect;
import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Notes {

	private JFrame frame;
	private JTextField textField;
	private int num;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Notes window = new Notes();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Notes() {
	}
	public Notes(int num) throws SQLException 
	{
		this.num = num;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @wbp.parser.entryPoint
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 562);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(33, 379, 370, 55);
		frame.getContentPane().add(textPane);
		
		JButton button = new JButton("הוסיף הערה");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(!textPane.getText().equals(""))
				{

					String q = "INSERT INTO `productsnotes`(`מספר מוצר`, `הערות`) VALUES ('"+num+"','"+textPane.getText().toString()+"')";
					try
					{
						MysqlConnect.getDbCon().insertQuery(q);
						JOptionPane.showMessageDialog(null, "נוספה הערה חדשה","הערה חדשה",1);
						ResultSet myRs = MysqlConnect.getDbCon().selectWhereQuery("productsnotes","מספר מוצר", String.valueOf(num));
						table.setModel(DbUtils.resultSetToTableModel(myRs));
						//coloring green the header of the table 
						JTableHeader Theader = table.getTableHeader();
						Theader.setBackground(Color.green);
						Theader.setFont(new Font("Tahoma", Font.BOLD, 12));

						// changing JTable Cell Value Alignment
						HelpFunctions.renderingTable(table);

						//reset the textField to empty
						textPane.setText("");

					} 
					catch (Exception e1)
					{
						e1.printStackTrace();					
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "תכתוב הערה", "הוספת הערה", 2);
				}
			}
		});
		button.setBounds(230, 469, 109, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("מחק הערה");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int row = table.getSelectedRow();


				int response = 0;
				try{
					if(row<0)
					{
						JOptionPane.showMessageDialog(null, "בחר הערה בבקשה", "בחירת הערה", JOptionPane.ERROR_MESSAGE);
						return;
					}
					else
					{
						response = JOptionPane.showConfirmDialog(null, "האם אתה בטוח שברצונך להמשיך?", "מחיקת הערה",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					}
					if (response == JOptionPane.NO_OPTION) 
					{
						return;
					}
					else if (response == JOptionPane.YES_OPTION) 
					{
						String RID=(table.getModel().getValueAt(row, 0)).toString();
						String remindId="מזהה";
						MysqlConnect.getDbCon().deleteRow("productsnotes", remindId, RID);
						HelpFunctions.getTable("productsnotes", table);

						// changing JTable Cell Value Alignment
						ResultSet myRs = MysqlConnect.getDbCon().selectWhereQuery("productsnotes","מספר מוצר", String.valueOf(num));
						table.setModel(DbUtils.resultSetToTableModel(myRs));
						//coloring green the header of the table 
						JTableHeader Theader = table.getTableHeader();
						Theader.setBackground(Color.green);
						Theader.setFont(new Font("Tahoma", Font.BOLD, 12));

						// changing JTable Cell Value Alignment
						HelpFunctions.renderingTable(table);
						//myConn.close();
					}

				}

				catch(Exception e2)
				{
					e2.printStackTrace();
				}
			}
		});
		button_1.setBounds(106, 469, 109, 23);
		frame.getContentPane().add(button_1);
		
		JLabel label = new JLabel("הערות למוצר מספר :");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setHorizontalTextPosition(SwingConstants.LEFT);
		label.setBounds(250, 45, 132, 14);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(230, 42, 35, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText(String.valueOf(num));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 98, 364, 250);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		ResultSet myRs = MysqlConnect.getDbCon().selectWhereQuery("productsnotes","מספר מוצר", String.valueOf(num));
		table.setModel(DbUtils.resultSetToTableModel(myRs));
		//coloring green the header of the table 
		JTableHeader Theader = table.getTableHeader();
		Theader.setBackground(Color.green);
		Theader.setFont(new Font("Tahoma", Font.BOLD, 12));

		// changing JTable Cell Value Alignment
		HelpFunctions.renderingTable(table);

		
//		MysqlConnect.getDbCon().selectQuery(query)
		
	}
}
