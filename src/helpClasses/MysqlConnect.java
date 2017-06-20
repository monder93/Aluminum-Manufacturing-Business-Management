package helpClasses;

import com.mysql.jdbc.Connection;
import java.sql.*;


public final class MysqlConnect
{
	public Connection conn;
	private Statement statement;
	public static MysqlConnect db;
	private MysqlConnect()
	{
		String url = "jdbc:mysql://localhost:3306/final-project?useUnicode=yes&characterEncoding=UTF-8";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "";
		try 
		{
			Class.forName(driver).newInstance();
			this.conn = (Connection)DriverManager.getConnection(url,userName,password);
		}
		catch (Exception sqle) 
		{
			sqle.printStackTrace();
		}
	}
	/**
	 *
	 * @return MysqlConnect Database connection object
	 */
	public static synchronized MysqlConnect getDbCon() 
	{
		if ( db == null ) 
		{
			db = new MysqlConnect();
		}
		return db;
	}

	
	public ResultSet selectQuery(String query) throws SQLException
	{
		statement = db.conn.createStatement();
		ResultSet res = statement.executeQuery(query);
		return res;
	}
	
	public ResultSet selectWhereQuery(String tableName , String ID , String idValue) throws SQLException
	{
		String query = "SELECT * FROM "+tableName+" WHERE `"+ID+"` = '"+idValue+"'";
		statement = db.conn.createStatement();
		ResultSet res = statement.executeQuery(query);
		return res;
	}

	public int insertQuery(String insertQuery) throws SQLException 
	{
		statement = db.conn.createStatement();
		int result = statement.executeUpdate(insertQuery);
		return result;
	}
	
	public int updateQuery(String updateQuery) throws SQLException 
	{
		statement = db.conn.createStatement();
		int result = statement.executeUpdate(updateQuery);
		return result;
	}
	
	public void deleteRow(String tableName ,String primaryId, String ID)
	{
		try
		{
			String query = "DELETE FROM `"+tableName+"` WHERE  `"+primaryId+"`= '"+ID+"'";
			statement = db.conn.createStatement();
			statement.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}