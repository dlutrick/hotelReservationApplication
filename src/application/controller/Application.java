package application.controller;

import application.model.RoomType;
import application.model.customer.Customer;
import application.model.room.Room;
import application.service.ReservationService;
import application.userInterface.AdminMenu;
import application.userInterface.MainMenu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * The class that contains all of the business logic to control the loop
 *
 * @author davidlutrick
 */
public class Application {
    MainMenu mainMenu = new MainMenu();
    AdminMenu adminMenu = new AdminMenu();
    Scanner scanner = new Scanner(System.in);

    /**
     * Application loop that runs the cli if the user is currently logged in
     * @param loggedIn boolean value representing the customer being logged in or not
     */
    public void start(boolean loggedIn) throws ParseException {
        // Key value pair data structure containing all of the customers that sign up
        Map<String, Customer> customers = new HashMap<>();
        Customer customer = null;
        boolean isAdmin = false;
        while(loggedIn) {
            System.out.println("------Welcome valued customer------");
            System.out.println(mainMenu.displayMenu());
            int selection = scanner.nextInt();
            // Prompts the user to enter their name and email to create an account
            if(selection == 1) {
                System.out.println("Please enter your first name: ");
                String firstName = scanner.next();
                System.out.println("Please enter your last name: ");
                String lastName = scanner.next();
                System.out.println("Please enter your email: ");
                String email = scanner.next();
                customer = new Customer(firstName, lastName, email);
                customers.put(customer.getEmail(), customer);
                System.out.println(customer);
            } else if(selection == 2) {
                System.out.println("2");
            } else if(selection == 3) {
                // Books a reservation
                System.out.println("What room would you like to book?");
                String desiredRoom = scanner.next();
                System.out.println("Check in date: ");
                String checkIn = scanner.next();
                System.out.println("Check out date: ");
                String checkOut = scanner.next();
                ReservationService.reserveARoom(customers.get(customer.getEmail()), ReservationService.getARoom(desiredRoom), new SimpleDateFormat("dd/MM/yyyy").parse(checkIn), new SimpleDateFormat("dd/MM/yyyy").parse(checkOut));
            } else if(selection == 4) {
                // View a single room
                System.out.println("Enter a room number: ");
                String roomNumber = scanner.next();
                System.out.println(ReservationService.getARoom(roomNumber));
            } else if(selection == 5) {
                // Creates the Admin menu loop
                isAdmin = true;
                while(isAdmin) {
                    System.out.println("------Welcome admin------");
                    System.out.println(adminMenu.displayMenu());
                    int adminSelection = scanner.nextInt();
                    scanner.nextLine();
                    if(adminSelection == 1) {

                    } else if(adminSelection == 2) {
                        System.out.println("2");
                    } else if(adminSelection == 3) {
                        System.out.println("2");
                    } else if(adminSelection == 4) {
                        // Adds a room
                        System.out.println("What's the room number? ");
                        String roomNumber = scanner.next();
                        System.out.println("What's the price? ");
                        Double price = scanner.nextDouble();
                        System.out.println("Single or double? ");
                        RoomType roomType = null;
                        boolean isSelecting = true;
                        while(isSelecting) {
                            String roomTypeAnswer = scanner.next();
                            if(roomTypeAnswer.equalsIgnoreCase("single")) {
                                roomType = RoomType.SINGLE;
                                isSelecting = false;
                            } else if(roomTypeAnswer.equalsIgnoreCase("double")) {
                                roomType = RoomType.DOUBLE;
                                isSelecting = false;
                            } else {
                                System.out.println("------That's not a valid type. Please enter single or double------");
                            }
                        }
                        ReservationService.addRoom(new Room(roomNumber, price, roomType));
                    } else if(adminSelection == 5) {
                        isAdmin = false;
                    } else {
                        System.out.println("------Please select a valid option.------");
                    }
                }
            } else if(selection == 6) {
                System.out.println("Thank you for using our application! See you soon!");
                loggedIn = false;
            } else {
                System.out.println("------Please select a valid option.------");
            }
        }
    }
}
