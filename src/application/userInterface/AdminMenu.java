package application.userInterface;

/**
 * Admin menu class to display the menu an admin will see when booting up the app
 */
public class AdminMenu {
    private String adminMenu;
    public AdminMenu() {
        adminMenu = "------------------------------\n" +
                    "1) See all Customers\n" +
                    "2) See all Rooms\n" +
                    "3) See all Reservations\n" +
                    "4) Add a Room\n" +
                    "5) Back to Main Menu\n" +
                    "------------------------------";
    }

    public String displayMenu() {
        return adminMenu;
    }
}
