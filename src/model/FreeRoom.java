package model;

public class FreeRoom extends Room {
    FreeRoom(String roomNumber, RoomType enumeration) {
        super(roomNumber, 0.0, enumeration);
    }
    @Override
    public String toString() {
        return "Room number: " + getRoomNumber() +
                "\nRoom price: " + getRoomPrice() +
                "\nRoom type: " + getRoomType();
    }
}
