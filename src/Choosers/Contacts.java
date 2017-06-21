package Choosers;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import helpClasses.HelpFunctions;
import helpClasses.MysqlConnect;
import main.AddProject;

import java.awt.Font;
import java.sql.SQLException;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JEditorPane;

public class Contacts extends JFrame{

	private JFrame frame;
	private JTable table;
	private JPanel contentPane;
	public static String Id;
	public static String name;

	private JTextField textField;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	JButton button_1;
	JButton btnNewButton_3;
	JLabel label;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JLabel label1;
	private JEditorPane editorPane;
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
					Contacts frame = new Contacts();
					frame.setVisible(true);
					//resizable  false
					frame.setResizable(false);
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
	 */
	public Contacts()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 20, 909, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 63, 859, 337);
		setTitle("איש קשר");
		table = new JTable()
		{@Override
			public boolean isCellEditable(int row, int column) 
		{
			return column==1 || column==2 || column==3 || column==4 || column==5  ;                
		};

		};
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane.setViewportView(table);

		label = new JLabel("משפחה :");
		label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label.setVisible(false);
		label.setBounds(795, 562, 84, 33);

		label1 = new JLabel("כתובת :");
		label1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label1.setVisible(false);
		label1.setBounds(795, 622, 84, 33);

		label2 = new JLabel("טלפון :");
		label2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label2.setVisible(false);
		label2.setBounds(465, 509, 84, 33);

		label3 = new JLabel("דואר אלקטרוני :");
		label3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label3.setVisible(false);
		label3.setBounds(465, 571, 84, 33);

		label4 = new JLabel("שם :");
		label4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label4.setVisible(false);
		label4.setBounds(795, 509, 84, 33);


		textField = new JTextField();
		textField.setVisible(false);
		textField.setBounds(636, 509, 103, 33);
		textField.setColumns(10);

		textField1 = new JTextField();
		textField1.setVisible(false);
		textField1.setBounds(636, 562, 103, 33);
		textField1.setColumns(10);

		textField2 = new JTextField();
		textField2.setVisible(false);
		textField2.setBounds(636, 622, 103, 33);
		textField2.setColumns(10);

		textField3 = new JTextField();
		textField3.setVisible(false);
		textField3.setBounds(331, 509, 103, 33);
		textField3.setColumns(10);

		textField4 = new JTextField();
		textField4.setVisible(false);
		textField4.setBounds(331, 568, 103, 33);
		textField4.setColumns(10);
		contentPane.setLayout(null);
		
		editorPane = new JEditorPane();
		editorPane.setFont(new Font("Tahoma", Font.BOLD, 22));
		editorPane.setEditable(false);
		editorPane.setText("אנשי קשר");
		editorPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		editorPane.setBounds(412, 0, 115, 33);
		contentPane.add(editorPane);
		contentPane.add(scrollPane);

		contentPane.add(label);
		contentPane.add(label1);
		contentPane.add(label2);
		contentPane.add(label3);

		JButton btnNewButton = new JButton("הוספת איש קשר");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hideOrShow(true);

			}
		});
		btnNewButton.setBounds(727, 407, 152, 63);
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 11));

		JButton btnNewButton_1 = new JButton("\u05E2\u05D3\u05DB\u05D5\u05DF");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int row=table.getSelectedRow();
				try {
					if(row<0)
					{
						JOptionPane.showMessageDialog(null, "בחר איש קשר בבקשה", "row selection", JOptionPane.ERROR_MESSAGE);
						return;
					}
					else
					{
						String id = table.getModel().getValueAt(row, 0).toString();
						String name = table.getModel().getValueAt(row, 1).toString();
						String lname = table.getModel().getValueAt(row, 2).toString();
						String address = table.getModel().getValueAt(row, 3).toString();
						String phone = table.getModel().getValueAt(row, 4).toString();
						String email = table.getModel().getValueAt(row, 5).toString();
						String q = "UPDATE `contacts` SET`שם`='"+name+"',`משפחה`='"+lname+"',`כתובת`='"+address+"',`טלפון`='"+phone+"',`דואר אלקטרוני`='"+email+"' WHERE `מספר זהות` = '"+id+"'";
//						Connection myConn = HelpFunctions.DbConnection();
//						Statement myStmt;
//						myStmt = myConn.createStatement();
//						myStmt.executeUpdate(q);
						MysqlConnect.getDbCon().updateQuery(q);
						HelpFunctions.getTable("contacts", table);
						HelpFunctions.renderingTable(table);
						JOptionPane.showMessageDialog(null, "עודכן");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_1.setBounds(501, 407, 152, 63);
		btnNewButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));

		JButton btnNewButton_2 = new JButton("\u05DE\u05D7\u05D9\u05E7\u05D4");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int row = table.getSelectedRow();
				int response=0;
				try
				{
					if(row<0)
					{
						JOptionPane.showMessageDialog(null, "בחר פרויקט בבקשה", "row selection", JOptionPane.ERROR_MESSAGE);
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
						String PID=(table.getModel().getValueAt(row, 0)).toString();
						String ProId="מספר זהות";
						String query = "DELETE FROM `contacts` WHERE  `"+ProId+"`= '"+PID+"'";
//						Connection myConn = HelpFunctions.DbConnection();
//						Statement myStmt = myConn.createStatement();
//						myStmt.executeUpdate(query);
						MysqlConnect.getDbCon().deleteRow("contacts", ProId, PID);
						HelpFunctions.getTable("contacts", table);
						HelpFunctions.renderingTable(table);
					}	
				}
				catch(Exception e2)
				{
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(271, 407, 152, 63);
		btnNewButton_2.setFont(new Font("Segoe UI", Font.PLAIN, 11));

		try 
		{
//			myConn = HelpFunctions.DbConnection();
			HelpFunctions.getTable("contacts", table);
			HelpFunctions.renderingTable(table);

			JButton button = new JButton("בחר");
			button.setBounds(20, 411, 152, 55);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{

					int row = table.getSelectedRow();
					try{
						if(row<0)
						{
							JOptionPane.showMessageDialog(null, "בחר איש קשר בבקשה", "row selection", JOptionPane.ERROR_MESSAGE);
							return;
						}
						else
						{
							Id=table.getModel().getValueAt(row, 0).toString();
							name=table.getModel().getValueAt(row,1).toString();
							AddProject.id=Id;
							AddProject.contact.setText(name);
							dispose();
						}
					}

					catch(Exception e)
					{
						e.printStackTrace();
					}
				}

			});
			button.setFont(new Font("Segoe UI", Font.PLAIN, 11));







			contentPane.add(label4);
			contentPane.add(textField);
			contentPane.add(textField1);
			contentPane.add(textField2);
			contentPane.add(textField3);
			contentPane.add(textField4);
			contentPane.add(btnNewButton);
			contentPane.add(btnNewButton_1);
			contentPane.add(btnNewButton_2);
			contentPane.add(button);
			button_1 = new JButton("אישור");
			button_1.setVisible(false);
			button_1.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
//					Connection myConn = HelpFunctions.DbConnection();
					String q = "INSERT INTO `contacts`( `שם`, `משפחה`, `כתובת`, `טלפון`, `דואר אלקטרוני`) VALUES ('"+textField.getText()+"','"+textField1.getText()+"','"+textField2.getText()+"','"+textField3.getText()+"','"+textField4.getText()+"')";
					try
					{
//						Statement st = myConn.createStatement();
//						st.executeUpdate(q);
						MysqlConnect.getDbCon().insertQuery(q);
						JOptionPane.showMessageDialog(null, "נשמר");
						HelpFunctions.getTable("contacts", table);
						HelpFunctions.renderingTable(table);
						hideOrShow(false);

					} catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			});
			button_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			button_1.setBounds(127, 509, 165, 42);
			contentPane.add(button_1);

			// changing JTable Cell Value Alignment
			HelpFunctions.renderingTable(table);
			
			btnNewButton_3 = new JButton("ביטול");
			btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnNewButton_3.setVisible(false);
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
					textField.setText("");
					textField1.setText("");
					textField2.setText("");
					textField3.setText("");
					textField4.setText("");
					hideOrShow(false);
				}
			});
			btnNewButton_3.setBounds(127, 566, 165, 42);
			contentPane.add(btnNewButton_3);
			
			
						JLabel background_label = new JLabel("New label");
						background_label.setBounds(0, 0, 904, 666);
						HelpFunctions.setBackground(background_label);
						contentPane.add(background_label);
		}
		catch (Exception e) 
		{
			e.printStackTrace();

		}


	}
	private void hideOrShow(boolean flag)
	{
		label.setVisible(flag);
		label2.setVisible(flag);
		label3.setVisible(flag);
		label1.setVisible(flag);
		label4.setVisible(flag);
		textField.setVisible(flag);
		textField1.setVisible(flag);
		textField2.setVisible(flag);
		textField3.setVisible(flag);
		textField4.setVisible(flag);
		button_1.setVisible(flag);
		btnNewButton_3.setVisible(flag);
		
	}
}
