package menus;

import api.AdminResource;
import model.IRoom;
import model.Room;
import model.RoomType;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminMenu {
    private final AdminResource adminResource = new AdminResource();
    private final String adminMenu;
    private static final Scanner scanner = new Scanner(System.in);

    public AdminMenu() {
        adminMenu = "Hello, Admin" +
                    "\n------------------------------" +
                    "\n1) See all customers" +
                    "\n2) See all rooms" +
                    "\n3) See all reservations" +
                    "\n4) Add a room" +
                    "\n5) Back to main menu" +
                    "\n6) Add test data" +
                    "\n------------------------------";
    }

    public void adminMenuSelection() {
        String selection = "0";
        // Geeks for Geeks tutorial https://www.geeksforgeeks.org/how-to-check-if-string-contains-only-digits-in-java/
        String selectionValidator = "[/d]+";
        Pattern pattern = Pattern.compile(selectionValidator);
        Matcher match = pattern.matcher(selection);
        do {
            displayAdminMenu();
            System.out.print("Please select an option (1-5): ");
            selection = scanner.next();
            switch (selection) {
                case "1" -> seeAllCustomers();
                case "2" -> seeAllRooms();
                case "3" -> seeAllReservations();
                case "4" -> addARoom();
                case "5" -> System.out.println("Back to main menu...");
                case "6" -> addTestData();
                default -> System.out.println("That's not a valid input\nPlease select 1-6");
            }
        } while (!selection.equals("5") && !match.matches());
    }

    public void addTestData() {
        adminResource.addTestData();
    }
    public void displayAdminMenu() {
        System.out.println(adminMenu);
    }

    public void seeAllCustomers() {
        System.out.println(adminResource.getAllCustomers());
    }

    public void seeAllRooms() {
        System.out.println(adminResource.getAllRooms());
    }

    public void seeAllReservations() {
        adminResource.displayAllReservations();
    }

    public void addARoom() {
        IRoom room;
        System.out.print("What's the room number? ");
        String roomNumber = scanner.next();
        Double pricePerNight;
        System.out.print("What's the price per night? ");
        while(true) {
            try {
                pricePerNight = scanner.nextDouble();
                break;
            } catch(InputMismatchException e) {
                scanner.nextLine();
                System.out.print("Please enter the price (Must be a number): ");
            }
        }

        while(true) {
            System.out.print("What's the room type? (Double or Single) ");
            String roomType = scanner.next();
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
        adminResource.addRoom(room);
    }
}
