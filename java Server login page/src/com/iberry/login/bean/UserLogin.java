package com.iberry.login.bean;

public class UserLogin
{
	private String idUserlogin;
	private String password;
	public UserLogin(String idUserlogin, String password)
	{
		super();
		this.idUserlogin = idUserlogin;
		this.password = password;
	}
	public String getIdUserlogin()
	{
		return idUserlogin;
	}
	public void setIdUserlogin(String idUserlogin)
	{
		this.idUserlogin = idUserlogin;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	
}
