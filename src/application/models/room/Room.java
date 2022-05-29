package application.models.room;

public class Room {
    private double cost;
    private String roomNumber;
    private String roomType;
    public Room(double cost, String roomNumber, String roomType) {
        this.cost = cost;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
}
