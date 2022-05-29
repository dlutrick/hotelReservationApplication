package application.userInterface;

/**
 * Main menu class to display the menu a customer will see when booting up the app
 *
 * @author davidlutrick
 */
public class MainMenu {
    private String createAccount;
    private String searchRooms;
    private String bookRoom;
    private String viewRoom;

    public MainMenu() {
        this.createAccount = "1) Create an Account";
        this.searchRooms = "2) Search available rooms";
        this.bookRoom = "3) Book a room";
        this.viewRoom = "4) View a room";
    }

    public String displayMenu() {
        return createAccount + "\n" + searchRooms + "\n" + bookRoom + "\n" + viewRoom;
    }
}
