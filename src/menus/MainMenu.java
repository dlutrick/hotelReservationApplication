package menus;

import api.AdminResource;
import api.HotelResource;
import model.IRoom;
import model.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainMenu {
    private final HotelResource hotelResource = new HotelResource();
    private final AdminResource adminResource = new AdminResource();
    private final String mainMenu;
    private static final Scanner scanner = new Scanner(System.in);
    public MainMenu() {
        mainMenu = "Welcome to the Hotel Reservation Application\nHow may we help you?" +
                    "\n------------------------------" +
                    "\n1) Find and reserve a room" +
                    "\n2) See my reservations" +
                    "\n3) Create an account" +
                    "\n4) Admin menu" +
                    "\n5) Logout" +
                    "\n------------------------------";
    }

    public void mainMenuSelection() {
        AdminMenu adminMenu = new AdminMenu();
        String selection = "0";
        // Geeks for Geeks tutorial https://www.geeksforgeeks.org/how-to-check-if-string-contains-only-digits-in-java/
        String selectionValidator = "[/d]+";
        Pattern pattern = Pattern.compile(selectionValidator);
        Matcher match = pattern.matcher(selection);
        do {
            displayMenu();
            selection = scanner.next();
            switch (selection) {
                case "1" -> findAndReserveARoom();
                case "2" -> seeMyReservations();
                case "3" -> createAnAccount();
                case "4" -> {
                    System.out.println("Loading admin menu...");
                    adminMenu.adminMenuSelection();
                }
                case "5" -> System.out.println("Thank you for using our application\nBye-Bye");
                default -> System.out.println("That's not a valid input\nPlease select 1-5");
            }
        } while (!selection.equals("5") && !match.matches());
    }

    public void displayMenu() {
        System.out.println(mainMenu);
        System.out.print("Please select an option (1-5): ");
    }

    public void findAndReserveARoom() {
        // variables
        SimpleDateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
        DateTimeFormatter currentDateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        formatDate.setLenient(false);
        String checkIn;
        String checkOut;
        Date formattedCheckIn;
        Date formattedCheckOut;

        Collection<IRoom> availableRooms;
        Collection<IRoom> recommendedRooms = null;
        IRoom room;

        LocalDate currentDate = LocalDate.now();
        String formattedCurrentDate = currentDate.format(currentDateFormatter);
        // Check in and check out dates
        System.out.println("Let's get some information from you");
        // Get check in
        while(true) {
            try {
                System.out.print("Check in date (MM/DD/YYYY): ");
                checkIn = scanner.next();
                formattedCheckIn = formatDate.parse(checkIn);
                // Checks to make sure the date isn't in the past
                if (formattedCheckIn.before(formatDate.parse(formattedCurrentDate))) {
                    System.out.println("Cannot choose a date from the past");
                } else {
                    break;
                }
            } catch (ParseException e) {
                System.out.println("Invalid date");
            }
        }

        // Get check out
        while(true) {
            try {
                System.out.print("Check out date (MM/DD/YYYY): ");
                checkOut = scanner.next();
                formattedCheckOut = formatDate.parse(checkOut);
                // Checks to make sure the check-out date is not before the check-in date
                if (formattedCheckOut.before(formattedCheckIn)) {
                    System.out.println("Check out date cannot be before check in date");
                } else {
                    break;
                }
            } catch (ParseException e) {
                System.out.println("Invalid date");
            }
        }
        // display available rooms
        availableRooms = hotelResource.findARoom(formattedCheckIn, formattedCheckOut);
        System.out.println(availableRooms);
        if(availableRooms.isEmpty()) {
            formattedCheckIn = hotelResource.plusSevenDays(formattedCheckIn);
            formattedCheckOut = hotelResource.plusSevenDays(formattedCheckOut);
            // if no rooms, find and display one week out
            // checks if any rooms are available
            System.out.println("We're sorry, we don't have any rooms for the selected time\nAllow us to search a week out for you");
            try {
                recommendedRooms = hotelResource.findRoomsAWeekOut(formattedCheckIn, formattedCheckOut);
            } catch(Exception e) {
                System.out.println("There was an error");
            }
            assert recommendedRooms != null;
            if(recommendedRooms.isEmpty()) {
                // if no rooms still, back to main menu
                System.out.println("We're sorry, we don't have any rooms for a week out either");
                return;
            } else {
                System.out.println(recommendedRooms);
                while(true) {
                    System.out.print("What room would you like? (Room number): ");
                    String roomNumber = scanner.next();
                    // Checks that the room exists and that the room is available
                    if (adminResource.getAllRooms().contains(hotelResource.getRoom(roomNumber)) && recommendedRooms.contains(hotelResource.getRoom(roomNumber))) {
                        room = hotelResource.getRoom(roomNumber);
                        break;
                    } else {
                        System.out.println("Room not available\n------------------------------");
                    }
                }

                // ask if they have an account
                while(true) {
                    System.out.print("Do you have an account with us? ('Y' or 'N'): ");
                    String hasAccount = scanner.next();
                    String email;
                    if (hasAccount.equalsIgnoreCase("y")) {
                        // ask for email
                        System.out.print("What's your email?\nEmail: ");
                        email = scanner.next().toLowerCase();
                        while (true) {
                            try {
                                System.out.println("Hello " + adminResource.getCustomer(email).getFirstName() + " " + adminResource.getCustomer(email).getLastName());
                                break;
                            } catch (Exception e) {
                                System.out.println("We're having trouble finding your account. Maybe try another? ");
                                System.out.print("Email: ");
                                email = scanner.next();
                            }
                        }
                        // book the room
                        Reservation reservation = hotelResource.bookARoom(email, room, formattedCheckIn, formattedCheckOut);
                        System.out.println("Thank you for reserving");
                        System.out.println(reservation);
                        break;
                    } else if (hasAccount.equalsIgnoreCase("n")) {
                        // if no account, sign up
                        email = createAnAccount();
                        // book the room
                        Reservation reservation = hotelResource.bookARoom(email, room, formattedCheckIn, formattedCheckOut);
                        System.out.println("Thank you for reserving");
                        System.out.println(reservation);
                        break;
                    }
                }
                // Back to main menu
                return;
            }
        }

        // if given back any rooms, ask which room to book
        while(true) {
            System.out.print("What room would you like? (Room number): ");
            String roomNumber = scanner.next();
            // Checks that the room exists and that the room is available
            if (adminResource.getAllRooms().contains(hotelResource.getRoom(roomNumber)) && availableRooms.contains(hotelResource.getRoom(roomNumber))) {
                room = hotelResource.getRoom(roomNumber);
                break;
            } else {
                System.out.println("Room not available\n------------------------------");
            }
        }

        // ask if they have an account
        while(true) {
            System.out.print("Do you have an account with us? ('Y' or 'N'): ");
            String hasAccount = scanner.next();
            String email;
            if (hasAccount.equalsIgnoreCase("y")) {
                // ask for email
                System.out.print("What's your email?\nEmail: ");
                email = scanner.next().toLowerCase();
                while (true) {
                    try {
                        System.out.println("Hello " + adminResource.getCustomer(email).getFirstName() + " " + adminResource.getCustomer(email).getLastName());
                        break;
                    } catch (Exception e) {
                        System.out.println("We're having trouble finding your account. Maybe try another? ");
                        System.out.print("Email: ");
                        email = scanner.next().toLowerCase();
                    }
                }
                // book the room
                Reservation reservation = hotelResource.bookARoom(email, room, formattedCheckIn, formattedCheckOut);
                System.out.println("Thank you for reserving");
                System.out.println(reservation);
                break;
            } else if (hasAccount.equalsIgnoreCase("n")) {
                // if no account, sign up
                email = createAnAccount();
                // book the room
                Reservation reservation = hotelResource.bookARoom(email, room, formattedCheckIn, formattedCheckOut);
                System.out.println("Thank you for reserving");
                System.out.println(reservation);
                break;
            }
        }
    }

    public void seeMyReservations() {
        System.out.print("What's your email? ");
        String email = scanner.next();
        Collection<Reservation> reservation;
        reservation = hotelResource.getCustomersReservations(email);
        System.out.println(reservation);
    }

    public String createAnAccount() {
        System.out.println("Let's sign you up! ");
        System.out.print("First name: ");
        String firstName = scanner.next();
        System.out.print("Last name: ");
        String lastName = scanner.next();
        System.out.print("Email: ");
        String email = scanner.next().toLowerCase();
        while(true) {
            try {
                hotelResource.createACustomer(firstName, lastName, email);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Please enter a valid email\n(example@domain.com)\n------------------------------");
                email = scanner.next().toLowerCase();
            }
        }
        return email;
    }
}
