package menus;

import api.AdminResource;
import api.HotelResource;
import model.Customer;
import model.IRoom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class MainMenu {
    private String mainMenu;
    private static Scanner scanner = new Scanner(System.in);
    public MainMenu() {
        mainMenu = "------------------------------" +
                        "\n1) Find and reserve a room" +
                        "\n2) See my reservations" +
                        "\n3) Create an account" +
                        "\n4) Admin menu" +
                        "\n5) Logout" +
                        "\n------------------------------";
    }

    public void displayMenu() {
        System.out.println(mainMenu);
    }

    public void findAndReserveARoom() throws ParseException {
        Customer customer = null;
        IRoom room = null;
        boolean isSelectingRoom = true;
        System.out.println("What room would you like? (Room number)");
        while(isSelectingRoom) {
            String roomNumber = scanner.next();
            if(AdminResource.getAllRooms().contains(HotelResource.getRoom(roomNumber))) {
                room = HotelResource.getRoom(roomNumber);
                isSelectingRoom = false;
            } else {
                System.out.println("Room does not exist");
            }
        }
        System.out.println("Do you have an account with us? ('Y' or 'N')");
        boolean isSelectingYesOrNo = true;
        while(isSelectingYesOrNo) {
            String haveAnAccount = scanner.next();
            if(haveAnAccount.equalsIgnoreCase("y")) {
                System.out.println("What's your email? ");
                String email = scanner.next();
                System.out.println("Hello, " + AdminResource.getCustomer(email).getFirstName() + " " + AdminResource.getCustomer(email).getLastName() + ".");
                System.out.println("When's your check in day? (MM/dd/yyyy)");
                String checkIn = scanner.next();
                System.out.println(("When's your check out day? (MM/dd/yyyy"));
                String checkOut = scanner.next();
                HotelResource.bookARoom(email, room, new SimpleDateFormat("MM/dd/yyyy").parse(checkIn), new SimpleDateFormat("MM/dd/yyyy").parse(checkOut));
                System.out.println("Thank you for reserving! Your reservation is confirmed.");
                isSelectingYesOrNo = false;
            } else if(haveAnAccount.equalsIgnoreCase("n")) {
                System.out.println("Let's sign you up! ");
                System.out.println("First name: ");
                String firstName = scanner.next();
                System.out.println("Last name: ");
                String lastName = scanner.next();
                System.out.println("Email: ");
                String email = scanner.next();
                HotelResource.createACustomer(firstName, lastName, email);
                customer = HotelResource.getCustomer(email);
                System.out.println("Thank you " + firstName + " " + lastName + ".");
                System.out.println("When's your check in day? (MM/dd/yyyy)");
                String checkIn = scanner.next();
                System.out.println(("When's your check out day? (MM/dd/yyyy"));
                String checkOut = scanner.next();
                HotelResource.bookARoom(email, room, new SimpleDateFormat("MM/dd/yyyy").parse(checkIn), new SimpleDateFormat("MM/dd/yyyy").parse(checkOut));
                System.out.println("Thank you for reserving! Your reservation is confirmed.");
                isSelectingYesOrNo = false;
            } else {
                System.out.println("That's an invalid selection. ('Y' or 'N')");
            }
        }
    }

    public void seeMyReservations() {
        System.out.println("What's your email? ");
        String email = scanner.next();
        HotelResource.getCustomersReservations(email);
    }

    public void createAnAccount() {
        System.out.println("Let's sign you up! ");
        System.out.println("First name: ");
        String firstName = scanner.next();
        System.out.println("Last name: ");
        String lastName = scanner.next();
        System.out.println("Email: ");
        String email = scanner.next();
        HotelResource.createACustomer(firstName, lastName, email);
        System.out.println("Thank you " + firstName + " " + lastName + ".");
    }
}
