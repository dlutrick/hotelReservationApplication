package api;

import model.Customer;
import model.IRoom;
import model.Room;
import model.RoomType;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;

public class AdminResource {
    private final ReservationService reservationService = ReservationService.getInstance();
    private final CustomerService customerService = CustomerService.getInstance();
    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    public void addRoom(IRoom room) {
        reservationService.addRoom(room);
    }

    public Collection<IRoom> getAllRooms() {
        return reservationService.getAllRooms();
    }

    public Collection<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    public void displayAllReservations() {
        System.out.println(reservationService.getAllReservations());
    }

    public void addTestData() {
        AdminResource adminResource = new AdminResource();
        Room room = new Room("100", 100.00, RoomType.SINGLE);
        Room room2 = new Room("101", 150.00, RoomType.DOUBLE);
        adminResource.addRoom(room);
        adminResource.addRoom(room2);

        customerService.addCustomer("John", "Doe", "john@example.com");
        customerService.addCustomer("Jane", "Doe", "jane@example.com");

    }
}
