package application.model.freeRoom;

import application.model.RoomType;
import application.model.room.Room;

public class FreeRoom extends Room {
    public FreeRoom(String roomNumber, RoomType enumeration) {
        super(roomNumber, 0.0, enumeration);
    }
    @Override
    public String toString() {
        return "Room number: " + getRoomNumber() + "\nPrice: " + getRoomPrice() + "\nRoom type: " + getRoomType();
    }
}
