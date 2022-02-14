package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Room {

	public int meterSquare;
	public int doubleBed;
	public int singleBed;
	public int roomNumber;
	public int roomPrice;
	public boolean soldRoom;
	public double windowX;
	public double windowY;
	

	public ImageView fullRoomO = new ImageView(new Image("fullroom.png"));

	public double getWindowX() {
		return windowX;
	}

	public void setWindowX(double windowX) {
		this.windowX = windowX;
	}


	public double getWindowY() {
		return windowY;
	}

	public void setWindowY(double windowY) {
		this.windowY = windowY;
	}

	public Room() {
		
	}

	public Room(int roomNumber, int meterSquare,int singleBed , int doubleBed,int roomPrice) {
		
		this.roomNumber = roomNumber;
		this.meterSquare =meterSquare; 
		this.singleBed =singleBed;
		this.doubleBed =doubleBed;
		this.roomPrice=roomPrice;
		this.soldRoom = false;
	}

    
	
	public int getMeterSquare() {
		return meterSquare;
	}

	public void setMeterSquare(int meterSquare) {
		this.meterSquare = meterSquare;
	}

	public int getDoubleBed() {
		return doubleBed;
	}

	public void setDoubleBed(int doubleBed) {
		this.doubleBed = doubleBed;
	}

	public int getSingleBed() {
		return singleBed;
	}

	public void setSingleBed(int singleBed) {
		this.singleBed = singleBed;
	}

	public int getRoomPrice() {
		return roomPrice;
	}


	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	
	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public void setXandY(double windowX , double windowY) {
		
		this.windowX=windowX;
		this.windowY=windowY;
		
	}
	
	@Override
	public String toString() {
		return "Room [meterSquare=" + meterSquare + ", doubleBed=" + doubleBed + ", singleBed=" + singleBed
				+ ", roomNumber=" + roomNumber + ", roomPrice=" + roomPrice + ", customer="  + "]";
	}
}
