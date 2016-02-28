package model;
import controller.*;
public class Manager {
	private String name;
	private String pass;
	
	public Manager(String name,String pass)
	{
		this.name=name;
		this.pass=pass;
	}
	
	
	public boolean validate()
	{
		boolean flag=false;
		try
		{
		String query="select * from login where username='"+name+"' and password='"+pass+"'";
		
		DBHandler.getDbConnection();
		flag=DBHandler.executeSelect(query);
		DBHandler.closeConnection();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return flag;
		
	}

}
