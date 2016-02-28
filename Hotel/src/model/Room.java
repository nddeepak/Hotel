package model;

public class Room {
	private int roomNo;
	private String roomType;
	private int noOfBeds;
	private boolean availabilityStatus;
	
	public Room() {
		
	}



	public Room(String roomType, int noOfBeds) {
		
		this.roomType = roomType;
		this.noOfBeds = noOfBeds;
	}



	public Room(int roomNo, String roomType, int noOfBeds, boolean availabilityStatus) {
		
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.noOfBeds = noOfBeds;
		this.availabilityStatus = availabilityStatus;
	}
	public Room(int roomNo, String roomType, int noOfBeds) {
		
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.noOfBeds = noOfBeds;
		
	}
	
	

	public boolean getAvailabilityStatus() {
		return availabilityStatus;
	}

	public void setAvailabilityStatus(boolean availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}

	public int getNoOfBeds() {
		return noOfBeds;
	}

	public void setNoOfBeds(int noOfBeds) {
		this.noOfBeds = noOfBeds;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	
	

}
