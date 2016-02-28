package model;

public class Customer {
	private int customerId;
	private String name;
	private String address;
	
	private Room room;
	
	public Customer()
	{
	
	}

	public Customer(String name, String address, Room room) {
	
		this.name = name;
		this.address = address;
		this.room = room;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
	
	

}
