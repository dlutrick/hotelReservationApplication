package menus;

import api.AdminResource;
import api.HotelResource;
import model.IRoom;
import model.Room;
import model.RoomType;
import service.ReservationService;

import java.util.Scanner;

public class AdminMenu {
    private String adminMenu;
    private static Scanner scanner = new Scanner(System.in);

    public AdminMenu() {
        adminMenu = "------------------------------" +
                "\n1) See all customers" +
                "\n2) See all rooms" +
                "\n3) See all reservations" +
                "\n4) Add a room" +
                "\n5) Back to main menu" +
                "\n------------------------------";
    }

    public void displayAdminMenu() {
        System.out.println(adminMenu);
    }

    public void seeAllCustomers() {
        System.out.println(AdminResource.getAllCustomers());
    }

    public void seeAllRooms() {
        System.out.println(AdminResource.getAllRooms());
    }

    public void seeAllReservations() {
        System.out.println("What's your email? ");
        String email = scanner.next();
        HotelResource.getCustomersReservations(email);
    }

    public void addARoom() {
        IRoom room;
        System.out.println("What's the room number? ");
        String roomNumber = scanner.next();
        System.out.println("What's the price per night? ");
        Double pricePerNight = scanner.nextDouble();
        System.out.println("What's the room type? (Double or Single? ");
        String roomType = scanner.next();
        while(true) {
            if(roomType.equalsIgnoreCase("single")) {
                room = new Room(roomNumber, pricePerNight, RoomType.SINGLE);
                break;
            } else if(roomType.equalsIgnoreCase("double")) {
                room = new Room(roomNumber, pricePerNight, RoomType.DOUBLE);
                break;
            } else {
                System.out.println("That's not a valid input. (Single or Double)");
            }
        }
        AdminResource.addRoom(room);
    }
}
