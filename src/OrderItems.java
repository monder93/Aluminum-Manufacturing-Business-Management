import java.awt.ComponentOrientation;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class OrderItems {

	private JFrame frame;
	public static JTable table;
	public Connection	myConn;
	String id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderItems window = new OrderItems();
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
	public OrderItems() {
		initialize();
	}
	public OrderItems(String id) {
		this.id=id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 174, 619, 276);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane.setViewportView(table);

		try {
			myConn = HelpFunctions.DbConnection();
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("SELECT `מספר סידורי`, `מספר מוצר`, `תיאור`, `רוחב`, `גובה`, `כמות`, `הערות`  FROM `ordersproducts` WHERE `מספר הזמנה` = '"+this.id+"'");
			table.setModel(DbUtils.resultSetToTableModel(myRs));
		} catch (Exception e) {
			e.printStackTrace();

		}

		JButton btnNewButton = new JButton("הוספת מוצר");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddOrderItems(id);
			}
		});
		btnNewButton.setBounds(501, 58, 106, 48);
		frame.getContentPane().add(btnNewButton);

		JButton button = new JButton("מחיקת מוצר");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int row = table.getSelectedRow();


				int response = 0;
				try{
					if(row<0)
					{
						JOptionPane.showMessageDialog(null, "בחר מוצר בבקשה", "row selection", JOptionPane.ERROR_MESSAGE);
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
						String PID=(table.getModel().getValueAt(row, 0)).toString();
						String ProId="מספר סידורי";
						Connection myConn = HelpFunctions.DbConnection();
						HelpFunctions.deleteDbRow("ordersproducts", ProId, PID, myConn);
						Statement myStmt = myConn.createStatement();
						ResultSet myRs = myStmt.executeQuery("SELECT `מספר סידורי`, `מספר מוצר`, `תיאור`, `רוחב`, `גובה`, `כמות`, `הערות`  FROM `ordersproducts` WHERE `מספר הזמנה` = '"+id+"'");
						table.setModel(DbUtils.resultSetToTableModel(myRs));
						myConn.close();
					}

				}

				catch(Exception e1)
				{
					e1.printStackTrace();
				}

			}
		});
		button.setBounds(366, 58, 106, 48);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("");
		button_1.setBounds(223, 58, 106, 48);
		frame.getContentPane().add(button_1);
		HelpFunctions.setIcon(button_1, "pdf");

		JButton button_2 = new JButton("");
		button_2.setBounds(74, 58, 106, 48);
		frame.getContentPane().add(button_2);
		HelpFunctions.setIcon(button_2, "printer");
	}
}
