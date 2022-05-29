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
    private String adminMenu;
    private String logout;

    public MainMenu() {
        createAccount = "1) Create an Account";
        searchRooms = "2) Search available rooms";
        bookRoom = "3) Book a room";
        viewRoom = "4) View a room";
        adminMenu = "5) Admin menu";
        logout = "6) Logout";
    }

    public String displayMenu() {
        return createAccount + "\n" + searchRooms + "\n" + bookRoom + "\n" + viewRoom + "\n" + adminMenu + "\n" + logout;
    }
}
