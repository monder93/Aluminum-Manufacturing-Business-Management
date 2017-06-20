package main;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Point;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.proteanit.sql.*;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import helpClasses.HelpFunctions;
import helpClasses.MysqlConnect;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.SwingConstants;

import com.itextpdf.text.pdf.codec.Base64.InputStream;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class product extends JFrame{

	private JFrame frame;
	public static JTable table_1;
	public static JTable table_2;
	private ButtonGroup BG1= new ButtonGroup();
	private ButtonGroup BG2= new ButtonGroup();
	public String series="";
	public int wingCount;
	JLabel label;
	public static String Id;
	public static String name;
	String query="SELECT `שם` FROM `opentypes`  ";
	String query2="SELECT `שם` FROM `opentypes`  ";
	private JTextField wing;
	String type="";
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
	public product() 
	{
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(120, 20, 686, 443);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(508, 35, 132, 340);
		frame.getContentPane().add(scrollPane);
		table_1 = new JTable()
		 {
		    @Override
		    public boolean isCellEditable(int row, int column) 
		    {
		        return false;                
		    };
		};
		table_1.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent me) 
			{
				JTable table =(JTable) me.getSource();
		        Point p = me.getPoint();
		        int row = table.rowAtPoint(p);
		        if (me.getClickCount() == 2) 
		        {
		        	type=(table.getModel().getValueAt(row, 0)).toString();
		        	AddProjectProduct.type=type;
//		        	System.out.println("type at product: "+ type);
		        	query2= "SELECT `סדרה` FROM `products` WHERE `סוג פתיחה` = '"+ type +"'";
//		        	Statement myStmt;
					try 
					{
//						myStmt = myConn.createStatement();
						ResultSet myRs = MysqlConnect.getDbCon().selectQuery(query2);
						table_2.setModel(DbUtils.resultSetToTableModel(myRs));
					} 
					catch (SQLException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }		
			}
		});
	
		
		table_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane.setViewportView(table_1);
		table_1.setBounds(0, 0, 589, 352);

		try 
		{
//			myConn  = HelpFunctions.DbConnection();
//			Statement myStmt = myConn.createStatement();
			ResultSet myRs = MysqlConnect.getDbCon().selectQuery(query);
			table_1.setModel(DbUtils.resultSetToTableModel(myRs));
			// changing JTable Cell Value Alignment
			HelpFunctions.renderingTable(table_1);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(244, 35, 132, 340);
		frame.getContentPane().add(scrollPane2);
		table_2 = new JTable()
		 {
		    @Override
		    public boolean isCellEditable(int row, int column) 
		    {
		        return false;                
		    };
		};
		
		table_2.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent e) 
			{
				JTable table =(JTable) e.getSource();
		        Point p = e.getPoint();
		        int row = table.rowAtPoint(p);
		        if (e.getClickCount() == 2) 
		        {
		        	series=(table.getModel().getValueAt(row, 0)).toString();
//		        	System.out.println(series);
		        	wing.show();
		        	label.show();
		        }
			}
		});
		table_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane2.setViewportView(table_2);
		table_2.setBounds(0, 0, 289, 352);

		try 
		{
//			myConn2  = HelpFunctions.DbConnection();
//			Statement myStmt = myConn2.createStatement();
			ResultSet myRs = MysqlConnect.getDbCon().selectQuery("SELECT `סדרה` FROM `products` WHERE `סוג פתיחה` = '"+ type +"'");
			table_2.setModel(DbUtils.resultSetToTableModel(myRs));
			HelpFunctions.renderingTable(table_2);

			
			label = new JLabel("כמות כנפי זכוכית:");
			label.setHorizontalTextPosition(SwingConstants.LEFT);
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setBounds(36, 35, 107, 28);
			frame.getContentPane().add(label);
			label.hide();
			wing = new JTextField();
			wing.setBounds(36, 63, 107, 28);
			frame.getContentPane().add(wing);
			wing.setColumns(10);
			wing.hide();
			JLabel label_1 = new JLabel("מונובלוק:");
			label_1.setHorizontalTextPosition(SwingConstants.LEFT);
			label_1.setHorizontalAlignment(SwingConstants.RIGHT);
			label_1.setBounds(36, 128, 107, 28);
			frame.getContentPane().add(label_1);
			
			JRadioButton radioButton = new JRadioButton("עם מונובלוק");
			radioButton.setHorizontalTextPosition(SwingConstants.LEFT);
			radioButton.setHorizontalAlignment(SwingConstants.RIGHT);
			radioButton.setBounds(36, 152, 109, 23);
			frame.getContentPane().add(radioButton);
			
			JRadioButton radioButton_1 = new JRadioButton("בלי מונובלוק");
			radioButton_1.setSelected(true);
			radioButton_1.setHorizontalTextPosition(SwingConstants.LEFT);
			radioButton_1.setHorizontalAlignment(SwingConstants.RIGHT);
			radioButton_1.setBounds(36, 182, 109, 23);
			frame.getContentPane().add(radioButton_1);
			
			JLabel label_2 = new JLabel("רשת:");
			label_2.setHorizontalTextPosition(SwingConstants.LEFT);
			label_2.setHorizontalAlignment(SwingConstants.RIGHT);
			label_2.setBounds(38, 240, 107, 28);
			frame.getContentPane().add(label_2);
			
			JRadioButton radioButton_2 = new JRadioButton("עם רשת");
			radioButton_2.setHorizontalTextPosition(SwingConstants.LEFT);
			radioButton_2.setHorizontalAlignment(SwingConstants.RIGHT);
			radioButton_2.setBounds(38, 264, 109, 23);
			frame.getContentPane().add(radioButton_2);
			
			JRadioButton radioButton_3 = new JRadioButton("בלי רשת");
			radioButton_3.setSelected(true);
			radioButton_3.setHorizontalTextPosition(SwingConstants.LEFT);
			radioButton_3.setHorizontalAlignment(SwingConstants.RIGHT);
			radioButton_3.setBounds(38, 294, 109, 23);
			frame.getContentPane().add(radioButton_3);
			
			
			BG1.add(radioButton);
			BG1.add(radioButton_1);
			BG2.add(radioButton_2);
			BG2.add(radioButton_3);
			
			JButton btnNewButton = new JButton("אשור");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					if(!(type.equals(""))&&!(series.equals(""))&&!(wing.getText().equals("")))
					{
						
						String query = "SELECT * FROM `products` WHERE `סדרה` = '"+series+"' AND `סוג פתיחה` = '"+type+"' AND `מס כנפים` = '"+wing.getText().toString()+"'";
//						System.out.println(query);
						try
						{
						ResultSet rs = MysqlConnect.getDbCon().selectQuery(query);
						rs.next();
						AddProjectProduct.proId = rs.getInt(1) ;
						AddProjectProduct.textField_4.setText(""+rs.getInt(5));
						AddProjectProduct.textField_5.setText(rs.getString(3)+"-"+rs.getString(6)+"-"+rs.getString(7)+" כנפיים ");
						AddProjectProduct.wingsNumber = Integer.parseInt(wing.getText().toString());
						AddProjectProduct.type=type;
						AddProjectProduct.series=series;
						java.sql.Blob blob = rs.getBlob(8);  
						java.io.InputStream in = blob.getBinaryStream();  
						BufferedImage image = ImageIO.read(in);
						HelpFunctions.setImageAsIcon(AddProjectProduct.proPic,new ImageIcon(image));
						frame.dispose();
						}
						catch (Exception e) 
						{
							e.printStackTrace();
						}
						
						}
					else
						JOptionPane.showMessageDialog(null, "יש למלא הכל");
				}
			});
			btnNewButton.setBounds(36, 341, 107, 34);
			frame.getContentPane().add(btnNewButton);
			// changing JTable Cell Value Alignment
			HelpFunctions.renderingTable(table_2);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}