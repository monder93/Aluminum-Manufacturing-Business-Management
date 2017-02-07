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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

//class have functions that we need to usealot in different Frames in the project
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

						timeLabel.setText("Time :  "+hour + ":"+minute+":"+second+"   Date :  "+day+"/"+month+"/"+year);
						sleep(1000);

					}	
				} catch (Exception e) 
				{
					// TODO: handle exception
				}
			}
		};
		clock.start();
	}

	//------------------------------------------------------------------------------------------------------------------	

	public static Connection DbConnection()
	{
		 String url = "jdbc:mysql://localhost:3306/final-project?useUnicode=yes&characterEncoding=UTF-8";
		 String user = "root";
		 String password = "";
		 Connection myConn = null;
		 
		 try {
			myConn = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return myConn;
	}
	
	//---------------------------------------------------------------------------------------------------------------------
	
	public static void getTable(String tableName , JTable viewTable , Connection myConn)
	{
		try{
		Statement myStmt = myConn.createStatement();
		ResultSet myRs = myStmt.executeQuery("select * from "+tableName+"");
		viewTable.setModel(DbUtils.resultSetToTableModel(myRs));
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//----------------------------------------------------------------------------------------------------------------------
	
	public static void setBackground(JLabel background_label)
	{
		background_label.setIcon(new ImageIcon(new ImageIcon(LoginPage.class.getResource("/img/banner1.jpg")).getImage().getScaledInstance(background_label.getWidth(), background_label.getHeight(), Image.SCALE_DEFAULT)));
	}
	
	//----------------------------------------------------------------------------------------------------------------------
	
	public static void setIcon(JButton background_button , String picName)
	{
		background_button.setIcon(new ImageIcon(new ImageIcon(LoginPage.class.getResource("/img/"+picName+".jpg")).getImage().getScaledInstance(background_button.getWidth(), background_button.getHeight(), Image.SCALE_DEFAULT)));
	}
	
	//-----------------------------------------------------------------------------------------------------------------------
	
	public static void deleteDbRow(String tableName ,String primaryId, String ID , Connection myConn)
	{
		try{
			String query = "DELETE FROM `projects` WHERE  `"+primaryId+"`= '"+ID+"'";
			Statement myStmt = myConn.createStatement();
			myStmt.executeUpdate(query);
			
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
