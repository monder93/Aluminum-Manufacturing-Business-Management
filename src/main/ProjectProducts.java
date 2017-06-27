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
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import Choosers.hardware;
import Choosers.partsColors;
import Choosers.profiles;
import Choosers.scrollShutter;
import helpClasses.Calc;
import helpClasses.HelpFunctions;
import helpClasses.MysqlConnect;
import mails.EmailWithPdf;
import net.proteanit.sql.DbUtils;
import pdfReports.PdfMaker;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;


public class ProjectProducts extends JFrame
{
	public static JTable table;
	private JPanel contentPane;
	private ButtonGroup proNumBG= new ButtonGroup();
	private ButtonGroup  berzolNumBG= new ButtonGroup();
	public static String id;
	static double proCount=0;
	public static JLabel lblNewLabel_3;
	public static JLabel lblNewLabel_4;
	public static JLabel label_1;
	public static String color;
	public static double colorPrice;
	public static String glass;
	public static double glassPrice;
	private JTable table_1;
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
		ProjectProducts.id=id;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		PdfMaker pdfMaker = new PdfMaker();
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

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 544, 1342, 150);
		contentPane.add(scrollPane_1);

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(32, 338, 1342, 167);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane.setViewportView(table);

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener()
		{	
			@Override
			public void valueChanged(ListSelectionEvent e)
			{
				if(!table.getSelectionModel().isSelectionEmpty())
				{
					int row = table.getSelectedRow();
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
				else
				{
					lblNewLabel_5.setText("0");
				}

			}
		});


		try 
		{

			ResultSet myRs = MysqlConnect.getDbCon().selectQuery("SELECT * FROM `projectsProducts` WHERE `מספר פרויקט` = '"+ProjectProducts.id+"'  ");
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
		JLabel lblNewLabel = new JLabel("סה\"כ מחיר הפרויקט(ש\"ח) לפני מע\"מ :");
		lblNewLabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(1105, 24, 247, 24);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("מחיר ממוצע למוצר(ש\"ח) אחרי מע\"מ :");
		lblNewLabel_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(1105, 90, 247, 24);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("מחיר המוצר(ש\"ח) אחרי מע\"מ :");
		lblNewLabel_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(1105, 125, 247, 24);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("0");
		lblNewLabel_3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(1036, 24, 61, 24);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("0");
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

		proPic.setBounds(69, 24, 225, 221);
		contentPane.add(proPic);
		proNumBG.add(rdbtnNewRadioButton);
		proNumBG.add(rdbtnNewRadioButton_3);

		berzolNumBG.add(radioButton);
		berzolNumBG.add(radioButton_2);

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
					e.printStackTrace();
				}
			}
		});
		button.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button.setBounds(535, 24, 123, 46);
		contentPane.add(button);

		JButton button_2 = new JButton("תריס גלילה");
		button_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new scrollShutter();
			}
		});
		button_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_2.setBounds(535, 74, 123, 47);
		contentPane.add(button_2);

		JButton button_4 = new JButton("הנחה");
		button_4.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_4.setBounds(386, 24, 123, 46);
		contentPane.add(button_4);

		JButton button_5 = new JButton("מוצר כאופציה");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int row = table.getSelectedRow();
				if(row<0)
				{
					JOptionPane.showMessageDialog(null, "יש לבחור מוצר");
				}
				else
				{
					try {
						String id=table.getModel().getValueAt(row, 0).toString();
						String option= table.getModel().getValueAt(row, 11).toString();
						if(option.equals("false"))
						{

							MysqlConnect.getDbCon().updateQuery("UPDATE `projectsproducts` SET `אופציה`= '1' WHERE `מספר סידורי` = '"+id+"'");
						}
						else
						{
							MysqlConnect.getDbCon().updateQuery("UPDATE `projectsproducts` SET `אופציה`= '0' WHERE `מספר סידורי` = '"+id+"'");

						}
						ResultSet myRs = MysqlConnect.getDbCon().selectQuery("SELECT * FROM `projectsProducts` WHERE `מספר פרויקט` = '"+ProjectProducts.id+"'  ");
						table.setModel(DbUtils.resultSetToTableModel(myRs));
						HelpFunctions.renderingTable(table);
						double allPrice=ProjectProducts.calcAllProductPrice();
						double pieceAvarage = ProjectProducts.calcProductAvaragePrice();
						ProjectProducts.lblNewLabel_3.setText(String.valueOf(allPrice));
						ProjectProducts.label_1.setText(String.valueOf(allPrice*1.17));
						ProjectProducts.lblNewLabel_4.setText(String.valueOf(Math.floor(pieceAvarage)));
						
					}

					catch (SQLException e1) 
					{
						e1.printStackTrace();
					}
				}
			}
		});
		button_5.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_5.setBounds(386, 74, 123, 46);
		contentPane.add(button_5);

		JButton button_6 = new JButton("הערות למוצר");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int row = table.getSelectedRow();
				if(row<0)
				{
					JOptionPane.showMessageDialog(null, "יש לבחור מוצר");
				}
				else
				{
					int productId= (int) table.getModel().getValueAt(row, 0);
					try {
						new Notes(productId);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		button_6.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_6.setBounds(386, 124, 123, 46);
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
		button_7.setBounds(1121, 270, 152, 46);
		contentPane.add(button_7);

		JButton button_9 = new JButton("\u05DE\u05D7\u05D9\u05E7\u05D4");
		button_9.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{

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
						String ProId="מספר סידורי";
						MysqlConnect.getDbCon().deleteRow("projectsproducts", ProId, PID);
						ResultSet myRs = MysqlConnect.getDbCon().selectQuery("SELECT * FROM `projectsProducts` WHERE `מספר פרויקט` = '"+ProjectProducts.id+"'  ");
						table.setModel(DbUtils.resultSetToTableModel(myRs));
						HelpFunctions.renderingTable(table);

						double allPrice=ProjectProducts.calcAllProductPrice();
						double pieceAvarage = ProjectProducts.calcProductAvaragePrice();
						ProjectProducts.lblNewLabel_3.setText(String.valueOf(allPrice));
						ProjectProducts.label_1.setText(String.valueOf(allPrice*1.17));
						ProjectProducts.lblNewLabel_4.setText(String.valueOf(Math.floor(pieceAvarage)));
					}
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}

			}
		});
		button_9.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_9.setBounds(935, 270, 152, 46);
		contentPane.add(button_9);

		JButton button_10 = new JButton("\u05D4\u05E2\u05EA\u05E7\u05D4");
		button_10.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				int row = table.getSelectedRow();
				if(row<0)
				{
					JOptionPane.showMessageDialog(null, "יש לבחור מוצר להעתיק");
				}
				else
				{
					int projectId= (int) table.getModel().getValueAt(row, 1);
					String codeItem = table.getModel().getValueAt(row, 2).toString();
					String te2or = table.getModel().getValueAt(row, 3).toString();
					String series = table.getModel().getValueAt(row, 4).toString();
					String width = table.getModel().getValueAt(row, 5).toString();
					String height = table.getModel().getValueAt(row, 6).toString();
					String quantity = table.getModel().getValueAt(row, 7).toString();
					String color = table.getModel().getValueAt(row, 8).toString();
					String glass = table.getModel().getValueAt(row, 9).toString();
					double price = (double) table.getModel().getValueAt(row, 10);
					String sql="INSERT INTO `projectsproducts`(`מספר פרויקט`, `קוד מוצר`, `תיאור`, `סדרה`, `רוחב`, `גובה`, `כמות`, `צבע`, `זיגוג`, `מחיר`) VALUES ('"+projectId+"','"+codeItem+"','"+te2or+"','"+series+"','"+width+"','"+height+"','"+quantity+"','"+color+"','"+glass+"','"+price+"')";
					try
					{
						MysqlConnect.getDbCon().insertQuery(sql);
						ResultSet myRs = MysqlConnect.getDbCon().selectQuery("SELECT * FROM `projectsProducts` WHERE `מספר פרויקט` = '"+ProjectProducts.id+"'  ");
						table.setModel(DbUtils.resultSetToTableModel(myRs));
						HelpFunctions.renderingTable(table);

						double allPrice=ProjectProducts.calcAllProductPrice();
						double pieceAvarage = ProjectProducts.calcProductAvaragePrice();
						ProjectProducts.lblNewLabel_3.setText(String.valueOf(allPrice));
						ProjectProducts.label_1.setText(String.valueOf(allPrice*1.17));
						ProjectProducts.lblNewLabel_4.setText(String.valueOf(Math.floor(pieceAvarage)));

					} 
					catch (SQLException e1) 
					{
						e1.printStackTrace();
					}

				}
			}
		});
		button_10.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_10.setBounds(745, 270, 158, 46);
		contentPane.add(button_10);

		JButton button_11 = new JButton("\u05E0\u05D9\u05EA\u05D5\u05D7 \u05E2\u05DC\u05D9\u05D5\u05EA");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int row = table.getSelectedRow();
				if(row<0)
				{
					JOptionPane.showMessageDialog(null, "יש לבחור מוצר");
				}
				else
				{
					String id = table.getModel().getValueAt(row, 0).toString();
					String name = table.getModel().getValueAt(row, 3).toString();
					new PrdCostAnalysis(Integer.parseInt(id),name);
				}
			}
		});
		button_11.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_11.setBounds(561, 270, 152, 46);
		contentPane.add(button_11);

		JButton button_12 = new JButton("צפייה במוצר");
		button_12.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				//table.getSelectionModel().clearSelection();

				int row = table.getSelectedRow();
				if(row<0)
				{
					JOptionPane.showMessageDialog(null, "יש לבחור מוצר להעתיק");
				}
				else
				{
					String id = table.getModel().getValueAt(row, 0).toString();
					String projectId= table.getModel().getValueAt(row, 1).toString();
					String codeItem = table.getModel().getValueAt(row, 2).toString();
					String te2or = table.getModel().getValueAt(row, 3).toString();
					String series = table.getModel().getValueAt(row, 4).toString();
					String width = table.getModel().getValueAt(row, 5).toString();
					String height = table.getModel().getValueAt(row, 6).toString();
					String quantity = table.getModel().getValueAt(row, 7).toString();
					String color = table.getModel().getValueAt(row, 8).toString();
					String glass = table.getModel().getValueAt(row, 9).toString();
					String pricee = table.getModel().getValueAt(row, 10).toString();

					new ShowUpdateProjectProduct(id,projectId,codeItem,width,height,series,color,glass,te2or,quantity,pricee);

				}
			}
		});
		button_12.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_12.setBounds(385, 270, 152, 46);
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
		button_13.setBounds(1165, 181, 108, 64);
		contentPane.add(button_13);
		HelpFunctions.setIcon(button_13, "calculator");

		JButton button_14 = new JButton("");
		button_14.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					new EmailWithPdf();
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, "שליחת מייל נכשלה");
				}
			}
		});
		button_14.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_14.setBounds(1011, 181, 108, 64);
		contentPane.add(button_14);
		HelpFunctions.setIcon(button_14, "mail");

		JButton button_15 = new JButton("");
		button_15.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				pdfMaker.exportProjectBidPDF();
			}
		});
		button_15.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_15.setBounds(863, 181, 108, 64);
		contentPane.add(button_15);
		HelpFunctions.setIcon(button_15, "pdf");

		JLabel label = new JLabel("סה\"כ מחיר הפרויקט(ש\"ח) אחרי מע\"מ :");
		label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(1105, 55, 247, 24);
		contentPane.add(label);

		label_1 = new JLabel("21066");
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
		double productAvarage=calcProductAvaragePrice();
		lblNewLabel_3.setText(String.valueOf(allPrice));
		label_1.setText(String.valueOf(Math.floor(allPrice*1.17)/100*100));
		lblNewLabel_4.setText(String.valueOf(Math.floor(productAvarage)));

		JButton button_16 = new JButton("צבע אביזרים");
		button_16.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new partsColors();
			}
		});
		button_16.setBounds(535, 128, 123, 41);
		contentPane.add(button_16);

		JLabel background_label = new JLabel("New label");
		background_label.setBounds(0, 0, 1362, 705);
		HelpFunctions.setBackground(background_label);
		contentPane.add(background_label);
	}
	//--------------------------------------------------------calcAllProductPrice-----------------------------------------------

	public static double calcAllProductPrice()
	{
		double price=0;
		try
		{
			String query="SELECT`מחיר` , `כמות`FROM `projectsproducts` WHERE `מספר פרויקט` = '"+id+"' AND `אופציה` = 'false'";
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
		return Math.floor(price*100/100);
	}
	//--------------------------------------------------------calcProductAvaragePrice-----------------------------------------------
	public static double calcProductAvaragePrice()
	{
		double price=0;
		double quantityCount=0;
		try
		{
			String query="SELECT`מחיר` , `כמות`FROM `projectsproducts` WHERE `מספר פרויקט` = '"+id+"' AND `אופציה` = 'false'";
			ResultSet myRs = MysqlConnect.getDbCon().selectQuery(query);
			while(myRs.next())
			{
				quantityCount+=(Double.parseDouble(myRs.getString(2)));
				price+=(Double.parseDouble(myRs.getString(1)))*(Double.parseDouble(myRs.getString(2)));
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return Math.floor((price/quantityCount)*100/100);
	}
}
