package com.iberry.user.DAo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.iberry.login.bean.UserLogin;

public class UserDAO
{
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static boolean status;
	public static Connection getConnection()
	{
		String url="jdbc:mysql://localhost:3306/?";
		@SuppressWarnings("unused")
		String dbName="userid";
		String driver="com.mysql.jdbc.Driver";
		String user="root";
		String password="root";
		java.sql.Connection conn=null;
		try
		{
			Class.forName(driver).newInstance();
			conn=DriverManager.getConnection(url, user,password);	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return(Connection) conn;
	}
	public static boolean validate(UserLogin det)
	{
		try
		{
			Connection conn=UserDAO.getConnection();
			pst=(PreparedStatement)conn.prepareStatement("select * from userid.userlogin where "+"idUserlogin=? and password=?");
			pst.setString(1, det.getIdUserlogin());
			pst.setString(2, det.getPassword());
			rs=pst.executeQuery();
			status=rs.next();
			conn.close();	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return status;
	}
	public static boolean validate1(UserLogin det)
	{
		try
		{
			Connection conn=UserDAO.getConnection();
			pst=(PreparedStatement)conn.prepareStatement("insert into userid.userlogin");
			pst.setString(1, det.getIdUserlogin());
			pst.setString(2, det.getPassword());
			pst.executeUpdate();
			conn.close();	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return true;
	}
}
