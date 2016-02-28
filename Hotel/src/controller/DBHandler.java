package controller;
import java.sql.*;
import model.*;
import java.util.*;

public class DBHandler 

{
	private static Connection con;
	private static Statement st;
	
	public static void getDbConnection()
	{
		try
		{
	    Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@192.168.30.6:1521:oracle";
		con=DriverManager.getConnection(url,"c1115","tcs");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static boolean executeSelect(String query)
	{
		boolean flag=false;
		try
		{
		 st=con.createStatement();
		 ResultSet rs=st.executeQuery(query);
	     flag=false;
		 if(rs.next())
		 {
			flag=true;
		 }
		}
		
		catch(Exception e)
		{ 
			e.printStackTrace();
		}
		return flag;
	}
	
	public static int executeUpdate(String query)
	{
		int row=0;
		try
		{
		 st=con.createStatement();
		 row=st.executeUpdate(query);
		 }
		catch(Exception e)
		{ 
			e.printStackTrace();
		}
		return row;
	}
	
	public static ArrayList<Room> executeQuery(String query)
	{
	
		ArrayList<Room> roomList=new ArrayList<Room>();
	
		try
		{
		 st=con.createStatement();
		 ResultSet rs=st.executeQuery(query);
	  
		while(rs.next())
		 {
			Room r=new Room();
			r.setRoomNo(Integer.parseInt(rs.getString(1)));
			r.setRoomType(rs.getString(2));
			r.setNoOfBeds(Integer.parseInt(rs.getString(3)));
			String status=rs.getString(4);
			if(status.equals("yes"))
			r.setAvailabilityStatus(true);
			else
				r.setAvailabilityStatus(false);
			roomList.add(r);	
		
		 }
		
		
		}
		
		catch(Exception e)
		{ 
			e.printStackTrace();
		}
		return roomList;
	}
	
	public static ArrayList<Customer> executeOccupancyQuery(String query)
	{

		ArrayList<Customer> custList = new ArrayList<Customer>();

		try
		{
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next())
			{
				Room r = new Room();
				r.setRoomNo(Integer.parseInt(rs.getString(1)));
				r.setRoomType(rs.getString(2));
				r.setNoOfBeds(Integer.parseInt(rs.getString(3)));

				Customer c = new Customer();
				c.setRoom(r);
				c.setName(rs.getString(4));
				c.setAddress(rs.getString(4));
				custList.add(c);
				
			}


		}

		catch (Exception e)
		{
			e.printStackTrace();
		}
		return custList;
	}
	
	
	
	public static void closeConnection()throws Exception
	{
		try{
		con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

