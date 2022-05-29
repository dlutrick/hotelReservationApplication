package application.userInterface;

/**
 * Admin menu class to display the menu an admin will see when booting up the app
 */
public class AdminMenu {
    private String displayAccounts;
    private String displayAllRooms;
    private String displayAllHotelReservations;
    private String addRoom;

    public AdminMenu() {
        displayAccounts = "1) Display all accounts";
        displayAllRooms = "2) Display all rooms";
        displayAllHotelReservations = "3) Display all reservations";
        addRoom = "4) Add a room";
    }

    public String displayMenu() {
        return displayAccounts + "\n" + displayAllRooms + "\n" + displayAllHotelReservations + "\n" + addRoom;
    }
}
