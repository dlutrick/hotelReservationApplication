package application.model.room;

import application.model.IRoom;
import application.model.RoomType;

public class Room implements IRoom {
    private String roomNumber;
    private Double price;
    private RoomType enumeration;
    public Room(String roomNumber, Double price, RoomType enumeration) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.enumeration = enumeration;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
    public Double getRoomPrice() {
        return price;
    }
    public RoomType getRoomType() {
        return enumeration;
    }
    public boolean isFree() {
        if(price == 0.0) {
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return "Room number: " + roomNumber + "\nPrice: " + price + "\n Room type: " + enumeration;
    }
}
