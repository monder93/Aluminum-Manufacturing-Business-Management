package helpClasses;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import main.LoginPage;
import net.proteanit.sql.DbUtils;

//class have functions that we need to use alot in different Frames in the project
public class HelpFunctions 
{

	//------------------------------------------------------------------------------------------------------------------
	//clock function	
	public static void clock(JLabel timeLabel)
	{
		Thread clock=new Thread()
		{
			public void run()
			{
				try 
				{
					while(true)
					{
						Calendar cal = new GregorianCalendar();
						int day=cal.get(Calendar.DAY_OF_MONTH);
						int month=cal.get(Calendar.MONTH)+1;
						int year=cal.get(Calendar.YEAR);

						int second = cal.get(Calendar.SECOND);
						int minute = cal.get(Calendar.MINUTE);
						int hour=cal.get(Calendar.HOUR);

						timeLabel.setText("שעה :  "+hour + ":"+minute+":"+second+"   תאריך :  "+day+"/"+month+"/"+year);
						sleep(1000);

					}	
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		};
		clock.start();
	}

	//------------------------------------------------------------------------------------------------------------------	

	public static String getCurrentTime()
	{
		Calendar cal = new GregorianCalendar();
		int day=cal.get(Calendar.DAY_OF_MONTH);
		int month=cal.get(Calendar.MONTH)+1;
		int year=cal.get(Calendar.YEAR);

		int second = cal.get(Calendar.SECOND);
		int minute = cal.get(Calendar.MINUTE);
		int hour=cal.get(Calendar.HOUR);

		String s="שעה :  "+hour + ":"+minute+":"+second+"   תאריך :  "+day+"/"+month+"/"+year;
		return s;
	}

	//---------------------------------------------------------------------------------------------------------------------

	public static void getTable(String tableName , JTable viewTable)
	{
		try
		{
			Statement myStmt = MysqlConnect.getDbCon().conn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from "+tableName+"");
			viewTable.setModel(DbUtils.resultSetToTableModel(myRs));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	//----------------------------------------------------------------------------------------------------------------------

	public static void renderingTable(JTable table)
	{
		// changing JTable Cell Value Alignment
		DefaultTableCellRenderer centerRenderr = new DefaultTableCellRenderer();
		centerRenderr.setHorizontalAlignment(JLabel.CENTER);
		for(int i = 0 ; i<table.getColumnCount();i++)
		{
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderr);
		}
	}
	//----------------------------------------------------------------------------------------------------------------------

	public static void setBackground(JLabel background_label)
	{
		background_label.setIcon(new ImageIcon(new ImageIcon(LoginPage.class.getResource("/img/banner1.jpg")).getImage().getScaledInstance(background_label.getWidth(), background_label.getHeight(), Image.SCALE_DEFAULT)));
	}

	//----------------------------------------------------------------------------------------------------------------------

	public static void setBackground(JLabel background_label,String name)
	{
		background_label.setIcon(new ImageIcon(new ImageIcon(LoginPage.class.getResource("/img/"+name+".jpg")).getImage().getScaledInstance(background_label.getWidth(), background_label.getHeight(), Image.SCALE_DEFAULT)));
	}

	//----------------------------------------------------------------------------------------------------------------------

	public static void setIcon(JButton background_button , String picName)
	{
		background_button.setIcon(new ImageIcon(new ImageIcon(LoginPage.class.getResource("/img/"+picName+".jpg")).getImage().getScaledInstance(background_button.getWidth(), background_button.getHeight(), Image.SCALE_DEFAULT)));
	}

	//-----------------------------------------------------------------------------------------------------------------------
	public static void setImageAsIcon(JLabel label , ImageIcon ImageIcon)
	{
		label.setIcon(new ImageIcon(ImageIcon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT)));
	}

	//-----------------------------------------------------------------------------------------------------------------------


}