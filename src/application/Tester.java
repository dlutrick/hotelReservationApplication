package application;

import application.model.RoomType;
import application.model.customer.Customer;
import application.model.room.Room;
import application.service.CustomerService;
import application.service.ReservationService;

public class Tester {
    public static void main(String[] args) {
        ReservationService.addRoom(new Room("100", 100.00, RoomType.DOUBLE));
    }
}
