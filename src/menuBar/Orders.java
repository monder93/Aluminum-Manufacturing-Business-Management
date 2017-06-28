package menuBar;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.JTableHeader;

import Choosers.Suppliers;
import helpClasses.HelpFunctions;
import helpClasses.MysqlConnect;
import main.OrderItems;

import javax.swing.JTextField;

import java.awt.Color;
import java.awt.ComponentOrientation;

public class Orders extends JFrame 
{

	private JFrame frame;
	public static JTable table_1;

	String type;
	String query;
	private JButton btnNewButton;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JLabel label;
	private JLabel label_1;
	public static JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton_1;
	private JLabel background_label;
	private JButton btnNewButton_2;
	private Boolean flag=true;
	private String globalDate;


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
	public Orders() 
	{
		initialize();
	}
	public Orders(String type) 
	{
		this.type=type;
		query="SELECT `מספר הזמנה`, `שם ספק`, `תאריך`, `אתר` FROM `orders` WHERE `סוג` = '"+type+"' ";
		initialize();
	}


	private void initialize() 
	{
		SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd");
		String date = time_formatter.format(System.currentTimeMillis());
		globalDate=date;
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(250, 150, 800, 513);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);		
		frame.setTitle("הזמנות");

		btnNewButton_2 = new JButton("שם ספק ");
		btnNewButton_2.setVisible(false);
		btnNewButton_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				new Suppliers("orders");

			}
		});
		btnNewButton_2.setBounds(666, 98, 118, 23);
		frame.getContentPane().add(btnNewButton_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane.setBounds(10, 133, 773, 340);
		frame.getContentPane().add(scrollPane);
		table_1 = new JTable()
		{
			@Override
			public boolean isCellEditable(int row, int column) 
			{
				return column==1 || column==2 || column==3 || column==4 ;                
			};
		};
		table_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane.setViewportView(table_1);

		table_1.setBounds(0, 0, 589, 352);
		try 
		{
			ResultSet myRs = MysqlConnect.getDbCon().selectQuery(query);
			table_1.setModel(DbUtils.resultSetToTableModel(myRs));
			HelpFunctions.renderingTable(table_1);

			btnNewButton = new JButton("\u05D4\u05D5\u05E1\u05E4\u05D4");
			btnNewButton.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0)
				{
					hideOrShow(flag);
					if(flag==true)
						flag=false;
					else
						flag=true;
				}
			});

			JTableHeader Theader = table_1.getTableHeader();
			Theader.setBackground(Color.green);
			Theader.setFont(new Font("Tahoma", Font.BOLD, 12));
			
			btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			btnNewButton.setBounds(666, 31, 117, 41);
			frame.getContentPane().add(btnNewButton);

			button = new JButton("\u05E2\u05D3\u05DB\u05D5\u05DF");
			button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					int row=table_1.getSelectedRow();
					try
					{
						if(row<0)
							JOptionPane.showMessageDialog(null, "בחר הזמנה בבקשה", "row selection", JOptionPane.ERROR_MESSAGE);
						else
						{
							String id = table_1.getModel().getValueAt(row, 0).toString();
							String supplier = table_1.getModel().getValueAt(row, 1).toString();
							String date = table_1.getModel().getValueAt(row, 2).toString();
							String site = table_1.getModel().getValueAt(row, 3).toString();

							String query = "UPDATE `orders` SET`שם ספק`='"+supplier+"',`אתר`='"+site+"',`תאריך`='"+date+"' WHERE `מספר הזמנה`='"+id+"'";

							MysqlConnect.getDbCon().updateQuery(query);

							String query2="SELECT `מספר הזמנה`, `שם ספק`, `תאריך`, `אתר` FROM `orders` WHERE `סוג` = '"+type+"' ";

							ResultSet rs = MysqlConnect.getDbCon().selectQuery(query2);
							table_1.setModel(DbUtils.resultSetToTableModel(rs));
							HelpFunctions.renderingTable(table_1);
							JOptionPane.showMessageDialog(null, "עודכן");
						}
					} 
					catch (SQLException e1) 
					{
						e1.printStackTrace();
					}
				}
			});
			button.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			button.setBounds(510, 31, 117, 41);
			frame.getContentPane().add(button);

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
							JOptionPane.showMessageDialog(null, "בחר הזמנה בבקשה", "row selection", JOptionPane.ERROR_MESSAGE);
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
							String PID=(table_1.getModel().getValueAt(row, 0)).toString();
							String ProId="מספר הזמנה";

							//deleting all the items of the order 
							MysqlConnect.getDbCon().deleteRow("ordersproducts", ProId, PID);

							//deleting the order
							MysqlConnect.getDbCon().deleteRow("orders", ProId, PID);

							query="SELECT `מספר הזמנה`, `שם ספק`, `תאריך`, `אתר` FROM `orders` WHERE `סוג` = '"+type+"' ";
							ResultSet myRs = MysqlConnect.getDbCon().selectQuery(query);
							table_1.setModel(DbUtils.resultSetToTableModel(myRs));
							HelpFunctions.renderingTable(table_1);

						}
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
				}
			});
			button_1.setBounds(359, 31, 117, 41);
			frame.getContentPane().add(button_1);

			button_2 = new JButton("\u05EA\u05D6\u05DB\u05D5\u05E8\u05EA");
			button_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			button_2.setBounds(204, 31, 117, 41);
			frame.getContentPane().add(button_2);

			button_3 = new JButton("הוספת מוצר להזמנה");
			button_3.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
					int row=table_1.getSelectedRow();
					if(row<0)
						JOptionPane.showMessageDialog(null, "בחר  הזמנה בבקשה", "row selection", JOptionPane.ERROR_MESSAGE);
					else
					{
						String id = (table_1.getModel().getValueAt(row, 0)).toString();
						new OrderItems(id,type);
					}

				}
			});
			button_3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			button_3.setBounds(10, 31, 154, 41);
			frame.getContentPane().add(button_3);

			label = new JLabel("אתר :");
			label.setVisible(false);
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setBounds(486, 96, 31, 26);
			frame.getContentPane().add(label);

			label_1 = new JLabel("תאריך :");
			label_1.setVisible(false);
			label_1.setHorizontalAlignment(SwingConstants.RIGHT);
			label_1.setBounds(293, 96, 61, 26);
			frame.getContentPane().add(label_1);

			textField = new JTextField();
			textField.setEditable(false);
			textField.setVisible(false);
			textField.setBounds(522, 99, 105, 20);
			frame.getContentPane().add(textField);
			textField.setColumns(10);

			textField_1 = new JTextField();
			textField_1.setVisible(false);
			textField_1.setColumns(10);
			textField_1.setBounds(359, 99, 117, 20);
			frame.getContentPane().add(textField_1);

			textField_2 = new JTextField();
			textField_2.setVisible(false);
			textField_2.setColumns(10);
			textField_2.setBounds(207, 99, 98, 20);
			textField_2.setText(date);
			frame.getContentPane().add(textField_2);

			btnNewButton_1 = new JButton("אישור");
			btnNewButton_1.setVisible(false);
			btnNewButton_1.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					if(!textField.getText().equals("") && !textField_1.getText().equals("") && !textField_2.getText().equals(""))
					{
						String q = "INSERT INTO `orders`( `שם ספק`, `תאריך`, `אתר`, `סוג`) VALUES ('"+textField.getText()+"','"+textField_2.getText()+"','"+textField_1.getText()+"','"+type+"')";
						try 
						{
							MysqlConnect.getDbCon().insertQuery(q);
							JOptionPane.showMessageDialog(null, "הזמנה נוספה");
							query="SELECT `מספר הזמנה`, `שם ספק`, `תאריך`, `אתר` FROM `orders` WHERE `סוג` = '"+type+"' ";
							ResultSet myRs = MysqlConnect.getDbCon().selectQuery(query);
							table_1.setModel(DbUtils.resultSetToTableModel(myRs));
							HelpFunctions.renderingTable(table_1);
							hideOrShow(false);

						} 
						catch (Exception e1)
						{
							e1.printStackTrace();				
						}

					}
					else
					{
						JOptionPane.showMessageDialog(null, "יש למלא כל הנתונים");
					}
				}
			});
			btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnNewButton_1.setBounds(10, 98, 154, 23);
			frame.getContentPane().add(btnNewButton_1);


			// changing JTable Cell Value Alignment
			HelpFunctions.renderingTable(table_1);

			background_label = new JLabel("New label");
			background_label.setBounds(0, 0, 799, 484);
			frame.getContentPane().add(background_label);
			HelpFunctions.setBackground(background_label);

			if(type.contentEquals("הזמנת זכוכית"))
				frame.setTitle("הזמנת זכוכית");
			if(type.contentEquals("הזמנת פירזול"))
				frame.setTitle("הזמנת פירזול");
			if(type.contentEquals("הזמנת פרופילים"))
				frame.setTitle("הזמנת פרופילים");	
			if(type.contentEquals("הזמנת משקופים"))
				frame.setTitle("הזמנת משקופים עיוורים");	
			if(type.contentEquals("הזמנת תריס גלילה"))
				frame.setTitle("הזמנת תריס גלילה");	

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	private void hideOrShow(boolean flag)
	{
		btnNewButton_2.setVisible(flag);
		label.setVisible(flag);
		label_1.setVisible(flag);
		textField.setVisible(flag);
		textField_1.setVisible(flag);
		textField_2.setVisible(flag);
		textField.setText("");
		textField_1.setText("");
		textField_2.setText(globalDate);
		btnNewButton_1.setVisible(flag);
	}
}
