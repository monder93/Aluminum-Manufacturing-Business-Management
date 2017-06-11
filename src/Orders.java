import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JTextField;
import java.awt.ComponentOrientation;

public class Orders extends JFrame {

	private JFrame frame;
	public static JTable table_1;
	public Connection	myConn;

	String type;
	String query;
	private JButton btnNewButton;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel label_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton_1;
	private JLabel background_label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() 
			{
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Orders() {
		initialize();
	}
	public Orders(String type) {
		this.type=type;
		query="SELECT `מספר הזמנה`, `שם ספק`, `תאריך`, `אתר` FROM `orders` WHERE `סוג` = '"+type+"' ";

		initialize();
	}


	private void initialize() {
		SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd");
		String date = time_formatter.format(System.currentTimeMillis());
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(250, 150, 841, 513);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);		
		frame.setTitle("הזמנות");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane.setBounds(10, 144, 815, 340);
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
			myConn = HelpFunctions.DbConnection();
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery(query);
			table_1.setModel(DbUtils.resultSetToTableModel(myRs));

			btnNewButton = new JButton("\u05D4\u05D5\u05E1\u05E4\u05D4");
			btnNewButton.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0)
				{
					hideOrShow(true);
				}
			});

			table_1.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent me) {
					Point p = me.getPoint();
					int row = table_1.rowAtPoint(p);
					String id = "";
					if(row<0)
						JOptionPane.showMessageDialog(null, "בחר הזמנה בבקשה");
					else
					{

						id = (table_1.getModel().getValueAt(row, 0)).toString();
					}
					if (me.getClickCount() == 2) {
						new OrderItems(id);
					}
				}
			});

			btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			btnNewButton.setBounds(666, 42, 117, 41);
			frame.getContentPane().add(btnNewButton);

			button = new JButton("\u05E2\u05D3\u05DB\u05D5\u05DF");
			button.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			button.setBounds(510, 42, 117, 41);
			frame.getContentPane().add(button);

			button_1 = new JButton("\u05DE\u05D7\u05D9\u05E7\u05D4");
			button_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

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
							Connection myConn = HelpFunctions.DbConnection();
							HelpFunctions.deleteDbRow("orders", ProId, PID, myConn);

							query="SELECT `מספר הזמנה`, `שם ספק`, `תאריך`, `אתר` FROM `orders` WHERE `סוג` = '"+type+"' ";
							Statement myStmt = myConn.createStatement();
							ResultSet myRs = myStmt.executeQuery(query);
							table_1.setModel(DbUtils.resultSetToTableModel(myRs));
							
							myConn.close();
						}

					}

					catch(Exception e1)
					{
						e1.printStackTrace();
					}

				}
			});
			button_1.setBounds(359, 42, 117, 41);
			frame.getContentPane().add(button_1);

			button_2 = new JButton("\u05EA\u05D6\u05DB\u05D5\u05E8\u05EA");
			button_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			button_2.setBounds(204, 42, 117, 41);
			frame.getContentPane().add(button_2);

			button_3 = new JButton("\u05D7\u05D6\u05E8\u05D4");
			button_3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			button_3.setBounds(47, 42, 117, 41);
			frame.getContentPane().add(button_3);

			lblNewLabel = new JLabel("שם ספק :");
			lblNewLabel.setVisible(false);
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel.setBounds(756, 107, 69, 26);
			frame.getContentPane().add(lblNewLabel);

			label = new JLabel("אתר :");
			label.setVisible(false);
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setBounds(553, 107, 47, 26);
			frame.getContentPane().add(label);

			label_1 = new JLabel("תאריך :");
			label_1.setVisible(false);
			label_1.setHorizontalAlignment(SwingConstants.RIGHT);
			label_1.setBounds(335, 107, 61, 26);
			frame.getContentPane().add(label_1);

			textField = new JTextField();
			textField.setVisible(false);
			textField.setBounds(620, 110, 133, 20);
			frame.getContentPane().add(textField);
			textField.setColumns(10);

			textField_1 = new JTextField();
			textField_1.setVisible(false);
			textField_1.setColumns(10);
			textField_1.setBounds(410, 110, 133, 20);
			frame.getContentPane().add(textField_1);

			textField_2 = new JTextField();
			textField_2.setVisible(false);
			textField_2.setColumns(10);
			textField_2.setBounds(185, 110, 133, 20);
			textField_2.setText(date);
			frame.getContentPane().add(textField_2);

			btnNewButton_1 = new JButton("אישור");
			btnNewButton_1.setVisible(false);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Connection myConn = HelpFunctions.DbConnection();
					String q = "INSERT INTO `orders`( `שם ספק`, `תאריך`, `אתר`, `סוג`) VALUES ('"+textField.getText()+"','"+textField_2.getText()+"','"+textField_1.getText()+"','"+type+"')";
					try {
						Statement st = myConn.createStatement();
						st.executeUpdate(q);
						JOptionPane.showMessageDialog(null, "saved");
						query="SELECT `מספר הזמנה`, `שם ספק`, `תאריך`, `אתר` FROM `orders` WHERE `סוג` = '"+type+"' ";
						Statement myStmt = myConn.createStatement();
						ResultSet myRs = myStmt.executeQuery(query);
						table_1.setModel(DbUtils.resultSetToTableModel(myRs));
						hideOrShow(false);

					} catch (Exception e1) {
						e1.printStackTrace();					}

				}
			});
			btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnNewButton_1.setBounds(63, 109, 89, 23);
			frame.getContentPane().add(btnNewButton_1);
			
			// changing JTable Cell Value Alignment
			DefaultTableCellRenderer centerRenderr = new DefaultTableCellRenderer();
			centerRenderr.setHorizontalAlignment(JLabel.CENTER);
			table_1.getColumnModel().getColumn(0).setCellRenderer(centerRenderr);
			table_1.getColumnModel().getColumn(1).setCellRenderer(centerRenderr);
			table_1.getColumnModel().getColumn(2).setCellRenderer(centerRenderr);
			table_1.getColumnModel().getColumn(3).setCellRenderer(centerRenderr);

			background_label = new JLabel("New label");
			background_label.setBounds(0, 0, 835, 484);
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





		} catch (Exception e) {
			e.printStackTrace();

		}


	}

	private void hideOrShow(boolean flag)
	{
		lblNewLabel.setVisible(flag);
		label.setVisible(flag);
		label_1.setVisible(flag);
		textField.setVisible(flag);
		textField_1.setVisible(flag);
		textField_2.setVisible(flag);
		btnNewButton_1.setVisible(flag);
	}
}
