package model;
import controller.*;
import java.util.*;

public class Hotel {

	public ArrayList<Room> checkAvailability(Room room)
	{
				
		ArrayList<Room> rooms =new ArrayList<Room>(); 
		try {
			String query = "select * from room where roomtype='"
					+ room.getRoomType() + "' and noofbeds="
					+ room.getNoOfBeds() + " and AVAILABILITYSTATUS='yes'";
			
			DBHandler.getDbConnection();
			rooms = DBHandler.executeQuery(query);
			DBHandler.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return rooms;
	}

	public int addRoom(Room room) {
		int row=0;
		try {
			String availability;
			if(room.getAvailabilityStatus())
				availability="yes";
			else
				availability="no";
			String query="insert into room values ("+room.getRoomNo()+",'"+room.getRoomType()+"',"+room.getNoOfBeds()+",'"+availability+"')";
			DBHandler.getDbConnection();
			 row=DBHandler.executeUpdate(query);
			DBHandler.closeConnection();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return row;
	}
	
	public int addCustomer(Customer customer)
	{
		int row=0;
		try {
			String query="insert into customer values(custseq.nextval,'"+customer.getName()+"','"+customer.getAddress()+"',"+customer.getRoom().getRoomNo()+")";
			DBHandler.getDbConnection();
			 row=DBHandler.executeUpdate(query);
			DBHandler.closeConnection();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return row;
		
	}
	
	public int changeStatus(Room room)
	{
	 	int ret=0;
	 	
	 	try {
			String query="update room set availabilitystatus='no' where roomno="+room.getRoomNo();
			DBHandler.getDbConnection();
			ret=DBHandler.executeUpdate(query);
			DBHandler.closeConnection();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	 	
	 	return ret;
	}
	
	
	public int  checkOutRoom(Room room)
	{
		
		int ret1=0;
		int ret2=0;
		try {
			String query1 = "update room set availabilitystatus='yes' where roomno="+room.getRoomNo();
			DBHandler.getDbConnection();
			ret1 = DBHandler.executeUpdate(query1);
			if(ret1!=0)
			{
				String query2="delete from customer where roomno=+"+room.getRoomNo();
				ret2=DBHandler.executeUpdate(query2);
				
			}
			
			DBHandler.closeConnection();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return ret2;
		
	}
	
    
	public ArrayList<Customer> getOccupancyDetails()
	{
		ArrayList<Customer> custom = new ArrayList<Customer>();
		
		try {
			String query = "select r.roomno,roomtype,noofbeds,name,address from customer c,room r where c.roomno=r.roomno";
			
			DBHandler.getDbConnection();
			custom = DBHandler.executeOccupancyQuery(query);
			DBHandler.closeConnection();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return custom;
		
	}
	
	public ArrayList<Room> viewAllRooms()
	{
		ArrayList<Room> roomList = new ArrayList<Room>();
		
		try {
			String query = "select * from room ";
			
			DBHandler.getDbConnection();
			roomList= DBHandler.executeQuery(query);
			DBHandler.closeConnection();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return roomList;
		
	}

}
