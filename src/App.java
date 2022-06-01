import api.AdminResource;
import api.HotelResource;
import menus.AdminMenu;
import menus.MainMenu;
import model.Room;
import model.RoomType;

import java.text.ParseException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Room room = new Room("100", 100.00, RoomType.SINGLE);
        Room room2 = new Room("101", 150.00, RoomType.DOUBLE);
        AdminResource.addRoom(room);;
        AdminResource.addRoom(room2);

        try {
            runApp();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void runApp() throws ParseException {
        MainMenu mainMenu = new MainMenu();
        AdminMenu adminMenu = new AdminMenu();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            mainMenu.displayMenu();
            int selection = scanner.nextInt();
            if(selection == 1) {
                mainMenu.findAndReserveARoom();
            } else if(selection == 2) {
                mainMenu.seeMyReservations();
            } else if(selection == 3) {
                mainMenu.createAnAccount();
            } else if(selection == 4) {
                while(true) {
                    adminMenu.displayAdminMenu();
                    selection = scanner.nextInt();
                    if(selection == 1) {
                        adminMenu.seeAllCustomers();
                    } else if(selection == 2) {
                        adminMenu.seeAllRooms();
                    } else if(selection == 3) {
                        adminMenu.seeAllReservations();
                    } else if(selection == 4) {
                        adminMenu.addARoom();
                    } else if(selection == 5) {
                        System.out.println("Back to the main menu");
                        break;
                    } else {
                        System.out.println("That's not a valid input. (Please select 1-5)");
                    }
                }
            } else if(selection == 5) {
                System.out.println("Thank you for using our application");
                break;
            } else {
                System.out.println("That's not a valid input. (Please select 1-5)");
            }
        }
    }
}
