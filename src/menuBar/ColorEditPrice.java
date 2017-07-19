package menuBar;

/*
 * a class for viewing and editing colors price 
 * */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import helpClasses.HelpFunctions;
import helpClasses.MysqlConnect;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.ComponentOrientation;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ColorEditPrice extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JButton btnNewButton_1;
	private boolean flag=true;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ColorEditPrice frame = new ColorEditPrice();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public ColorEditPrice() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(450, 150, 450, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 414, 292);
		contentPane.add(scrollPane);
		setVisible(true);
		table = new JTable()
		{
			@Override
			public boolean isCellEditable(int row, int column) 
			{
				return  column==1 || column==2 || column==3 ;                
			};
		};
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane.setViewportView(table);

		String query = "SELECT * FROM colors";
		ResultSet myRs = MysqlConnect.getDbCon().selectQuery(query);
		table.setModel(DbUtils.resultSetToTableModel(myRs));
		HelpFunctions.renderingTable(table);

		JButton btnNewButton = new JButton("הוספת צבע חדש");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				showHide(flag);
				if(flag==false)
					flag=true;
				else
					flag=false;

			}
		});
		btnNewButton.setBounds(302, 0, 122, 23);
		contentPane.add(btnNewButton);

		JButton button = new JButton("עדכון צבע");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{

				int row=table.getSelectedRow();
				try
				{
					if(row<0)
						JOptionPane.showMessageDialog(null, "בחר צבע   בבקשה", "row selection", JOptionPane.ERROR_MESSAGE);
					else
					{
						String id = table.getModel().getValueAt(row, 0).toString();
						String code = table.getModel().getValueAt(row, 1).toString();
						String color = table.getModel().getValueAt(row, 2).toString();
						String colorPrice = table.getModel().getValueAt(row, 3).toString();
						String query = "UPDATE `colors` SET`קוד מזהה`='"+code+"',`תאור`='"+color+"',`מחיר לקג`='"+colorPrice+"' WHERE `מספר מזהה`='"+id+"'";
						MysqlConnect.getDbCon().updateQuery(query);
						HelpFunctions.getTable("colors", table);
						HelpFunctions.renderingTable(table);
						JOptionPane.showMessageDialog(null, "עודכן");
					}
				} 
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}

			}
		});
		button.setBounds(157, 0, 122, 23);
		contentPane.add(button);

		label = new JLabel("קוד מזהה");
		label.setBounds(351, 331, 73, 14);
		contentPane.add(label);

		textField = new JTextField();
		textField.setBounds(271, 328, 73, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		label_1 = new JLabel("תאור");
		label_1.setBounds(236, 331, 33, 14);
		contentPane.add(label_1);

		textField_1 = new JTextField();
		textField_1.setBounds(147, 328, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		label_2 = new JLabel("מחיר");
		label_2.setBounds(103, 331, 33, 14);
		contentPane.add(label_2);

		textField_2 = new JTextField();
		textField_2.setBounds(10, 328, 89, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		btnNewButton_1 = new JButton("אישור");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String query = "INSERT INTO `colors` (`קוד מזהה`,`תאור`,`מחיר לקג`) VALUES('" +textField.getText().toString()
						+ "','" + textField_1.getText().toString() + "','" + textField_2.getText().toString() + "')";
				if(!textField.getText().equals("") && !textField_1.getText().equals("") && !textField_2.getText().equals(""))
				{
					try {
						MysqlConnect.getDbCon().insertQuery(query);
						HelpFunctions.getTable("colors", table);
						HelpFunctions.renderingTable(table);
						JOptionPane.showMessageDialog(null, "הוסף צבע חדש");

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					showHide(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "יש למלא כל השדות");	
				}
			}
		});
		btnNewButton_1.setBounds(0, 356, 109, 23);
		contentPane.add(btnNewButton_1);

		JButton button_1 = new JButton("מחיקת צבע");
		button_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{

				int row = table.getSelectedRow();
				int response = 0;
				try{
					if(row<0)
					{
						JOptionPane.showMessageDialog(null, "בחר צבע  בבקשה", "row selection", JOptionPane.ERROR_MESSAGE);
						return;
					}
					else
					{
						response = JOptionPane.showConfirmDialog(null, "להמשיך ?", "אישור",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					}
					if (response == JOptionPane.NO_OPTION) 
					{
						return;
					}
					else if (response == JOptionPane.YES_OPTION) 
					{
						String CID=(table.getModel().getValueAt(row, 0)).toString();
						String colorId="מספר מזהה";
						MysqlConnect.getDbCon().deleteRow("colors", colorId, CID);
						HelpFunctions.getTable("colors", table);
						HelpFunctions.renderingTable(table);
					}
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}

			}
		});
		button_1.setBounds(10, 0, 126, 23);
		contentPane.add(button_1);

		label.setVisible(false);
		label_1.setVisible(false);
		label_2.setVisible(false);
		textField.setVisible(false);
		textField_1.setVisible(false);
		textField_2.setVisible(false);
		btnNewButton_1.setVisible(false);
	}
	//----------------------------------------------------------hidrOrShow-function-------------------------------------------------
	//function to hide some components
	private void showHide(boolean flag)
	{
		label.setVisible(flag);
		label_1.setVisible(flag);
		label_2.setVisible(flag);
		textField.setVisible(flag);
		textField_1.setVisible(flag);
		textField_2.setVisible(flag);
		btnNewButton_1.setVisible(flag);

		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
	}
}
