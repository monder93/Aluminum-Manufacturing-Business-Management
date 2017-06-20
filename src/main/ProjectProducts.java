package main;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import helpClasses.Calc;
import helpClasses.HelpFunctions;
import helpClasses.MysqlConnect;
import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.ComponentOrientation;


public class ProjectProducts extends JFrame
{
	public static JTable table;
	private JPanel contentPane;
	private ButtonGroup proNumBG= new ButtonGroup();
	private ButtonGroup  berzolNumBG= new ButtonGroup();
	public static String id;
	double proCount=0;
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
					ProjectProducts frame = new ProjectProducts();
					frame.setVisible(true);
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
	public ProjectProducts() 
	{
		initialize();
	}

	public ProjectProducts(String id)
	{
		this.id=id;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 578, 374);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("מוצרים לפרויקט");
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		JLabel lblNewLabel_5;
		JLabel proPic;
		lblNewLabel_5 = new JLabel("0");
		lblNewLabel_5.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		proPic = new JLabel("");
		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(10, 419, 1342, 286);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane.setViewportView(table);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener()
		{	
			@Override
			public void valueChanged(ListSelectionEvent e)
			{
				int row = table.getSelectedRow();
				if(row<0)
					JOptionPane.showMessageDialog(null, "בחר פרויקט בבקשה");
				else
				{
					double price=Math.floor((double) (table.getModel().getValueAt(row, 10)));
					price=(price*117/100);
					lblNewLabel_5.setText(String.valueOf(price));
					String query="SELECT  `תמונה` FROM `products` WHERE `מזהה` ='"+(table.getModel().getValueAt(row, 2))+"'";
					ResultSet rs;
					try 
					{
						rs = MysqlConnect.getDbCon().selectQuery(query);
						rs.next();
						java.sql.Blob blob = rs.getBlob(1);  
						java.io.InputStream in = blob.getBinaryStream();  
						BufferedImage image = ImageIO.read(in);
						HelpFunctions.setImageAsIcon(proPic,new ImageIcon(image));
					}
					catch (SQLException | IOException e1) 
					{
						e1.printStackTrace();
					}

				}
			}
		});

		try 
		{

			ResultSet myRs = MysqlConnect.getDbCon().selectQuery("SELECT * FROM `projectsProducts` WHERE `מספר פרויקט` = '"+this.id+"'  ");
			table.setModel(DbUtils.resultSetToTableModel(myRs));
			HelpFunctions.renderingTable(table);
			JTableHeader Theader = table.getTableHeader();
			Theader.setBackground(Color.green);
			Theader.setFont(new Font("Tahoma", Font.BOLD, 12));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		JLabel lblNewLabel = new JLabel("סה\"כ מחיר הפרויקט(ש\"ח) לפני מע\"ם :");
		lblNewLabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(1105, 24, 247, 24);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("מחיר ממוצע למוצר(ש\"ח) אחרי מע\"ם :");
		lblNewLabel_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(1105, 90, 247, 24);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("מחיר המוצר(ש\"ח) אחרי מע\"ם :");
		lblNewLabel_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(1105, 125, 247, 24);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("0");
		lblNewLabel_3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(1036, 24, 61, 24);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("0");
		lblNewLabel_4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(1036, 90, 61, 24);
		contentPane.add(lblNewLabel_4);


		lblNewLabel_5.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(1036, 125, 61, 24);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("\u05DE\u05E1' \u05E4\u05E8\u05D5\u05E4\u05D9\u05DC\u05D9\u05DD :");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_6.setBounds(880, 24, 119, 24);
		contentPane.add(lblNewLabel_6);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u05E7\u05DC\u05D9\u05DC");
		rdbtnNewRadioButton.setHorizontalTextPosition(SwingConstants.LEFT);
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.RIGHT);
		rdbtnNewRadioButton.setBounds(880, 55, 119, 23);
		contentPane.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("\u05D0\u05E7\u05E1\u05D8\u05DC");
		rdbtnNewRadioButton_3.setHorizontalTextPosition(SwingConstants.LEFT);
		rdbtnNewRadioButton_3.setHorizontalAlignment(SwingConstants.RIGHT);
		rdbtnNewRadioButton_3.setBounds(880, 81, 119, 23);
		contentPane.add(rdbtnNewRadioButton_3);

		JLabel lblNewLabel_7 = new JLabel("\u05DE\u05E1' \u05E4\u05D9\u05E8\u05D6\u05D5\u05DC :");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_7.setBounds(748, 24, 108, 24);
		contentPane.add(lblNewLabel_7);

		JRadioButton radioButton = new JRadioButton("\u05E7\u05DC\u05D9\u05DC");
		radioButton.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton.setBounds(720, 55, 136, 23);
		contentPane.add(radioButton);

		JRadioButton radioButton_2 = new JRadioButton("\u05D0\u05E7\u05E1\u05D8\u05DC");
		radioButton_2.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_2.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_2.setBounds(720, 81, 136, 23);
		contentPane.add(radioButton_2);

		//	lblNewLabel_8.setIcon(new ImageIcon(ProjectProducts.class.getResource("/img/background.jpg")));
		proPic.setBounds(69, 24, 225, 265);
		contentPane.add(proPic);
		proNumBG.add(rdbtnNewRadioButton);
		proNumBG.add(rdbtnNewRadioButton_3);

		berzolNumBG.add(radioButton);
		berzolNumBG.add(radioButton_2);

		JButton btnNewButton = new JButton("פרופילים");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try 
				{
					new profiles();
				}
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNewButton.setBounds(534, 48, 123, 46);
		contentPane.add(btnNewButton);

		JButton button = new JButton("פירזולים");
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try 
				{
					new hardware();
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button.setBounds(534, 98, 123, 46);
		contentPane.add(button);

		JButton button_1 = new JButton("בילגי");
		button_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_1.setBounds(534, 148, 123, 46);
		contentPane.add(button_1);

		JButton button_2 = new JButton("תריס גלילה");
		button_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new scrollShutter();
			}
		});
		button_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_2.setBounds(534, 198, 123, 47);
		contentPane.add(button_2);

		JButton button_3 = new JButton("קיר מסך");
		button_3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_3.setBounds(385, 48, 123, 46);
		contentPane.add(button_3);

		JButton button_4 = new JButton("הנחה");
		button_4.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_4.setBounds(385, 98, 123, 46);
		contentPane.add(button_4);

		JButton button_5 = new JButton("מוצר כאופציה");
		button_5.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_5.setBounds(385, 148, 123, 46);
		contentPane.add(button_5);

		JButton button_6 = new JButton("הערות למוצר");
		button_6.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_6.setBounds(385, 198, 123, 46);
		contentPane.add(button_6);

		JButton button_7 = new JButton("\u05D4\u05D5\u05E1\u05E4\u05EA \u05DE\u05D5\u05E6\u05E8 \u05DC\u05E4\u05E8\u05D5\u05D9\u05E7\u05D8");
		button_7.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				new AddProjectProduct();
			}
		});
		button_7.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_7.setBounds(1108, 346, 152, 46);
		contentPane.add(button_7);

		JButton button_8 = new JButton("\u05E2\u05D3\u05DB\u05D5\u05DF");
		button_8.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_8.setBounds(922, 346, 152, 46);
		contentPane.add(button_8);

		JButton button_9 = new JButton("\u05DE\u05D7\u05D9\u05E7\u05D4");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		button_9.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_9.setBounds(742, 346, 152, 46);
		contentPane.add(button_9);

		JButton button_10 = new JButton("\u05D4\u05E2\u05EA\u05E7\u05D4");
		button_10.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_10.setBounds(552, 346, 158, 46);
		contentPane.add(button_10);

		JButton button_11 = new JButton("\u05E0\u05D9\u05EA\u05D5\u05D7 \u05E2\u05DC\u05D9\u05D5\u05EA");
		button_11.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_11.setBounds(368, 346, 152, 46);
		contentPane.add(button_11);

		JButton button_12 = new JButton("\u05D7\u05D6\u05E8\u05D4");
		button_12.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_12.setBounds(192, 346, 152, 46);
		contentPane.add(button_12);

		JButton button_13 = new JButton("");
		button_13.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				new Calc("מחשבון");
			}
		});
		button_13.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_13.setBounds(1152, 225, 108, 64);
		contentPane.add(button_13);
		HelpFunctions.setIcon(button_13, "calculator");

		JButton button_14 = new JButton("");
		button_14.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_14.setBounds(998, 225, 108, 64);
		contentPane.add(button_14);
		HelpFunctions.setIcon(button_14, "printer");

		JButton button_15 = new JButton("");
		button_15.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_15.setBounds(850, 225, 108, 64);
		contentPane.add(button_15);
		HelpFunctions.setIcon(button_15, "pdf");

		JLabel label = new JLabel("סה\"כ מחיר הפרויקט(ש\"ח) אחרי מע\"ם :");
		label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(1105, 55, 247, 24);
		contentPane.add(label);

		JLabel label_1 = new JLabel("21066");
		label_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		label_1.setBounds(1036, 55, 61, 24);
		contentPane.add(label_1);

		// changing JTable Cell Value Alignment
		HelpFunctions.renderingTable(table);

		HelpFunctions.setBackground(proPic, "nopic");
		radioButton.setSelected(true);
		rdbtnNewRadioButton.setSelected(true);
		double allPrice=calcAllProductPrice();
		lblNewLabel_3.setText(String.valueOf(allPrice));
		label_1.setText(String.valueOf(allPrice*1.17));
		
		JButton button_16 = new JButton("צבע אביזרים");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				new partsColors();
			}
		});
		button_16.setBounds(831, 137, 108, 40);
		contentPane.add(button_16);
		
				JLabel background_label = new JLabel("New label");
				background_label.setBounds(0, 0, 1362, 705);
				HelpFunctions.setBackground(background_label);
				contentPane.add(background_label);
	}

	private double calcAllProductPrice()
	{
		double price=0;
		try
		{
			String query="SELECT`מחיר` , `כמות`FROM `projectsproducts` WHERE `מספר פרויקט` = '"+id+"' ";
			ResultSet myRs = MysqlConnect.getDbCon().selectQuery(query);
			while(myRs.next())
			{
				proCount+=(Double.parseDouble(myRs.getString(2)));
				price+=(Double.parseDouble(myRs.getString(1)))*(Double.parseDouble(myRs.getString(2)));
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		System.out.println(proCount);
		return price;
	}
}
