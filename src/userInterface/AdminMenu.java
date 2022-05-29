package userInterface;

/**
 * Admin menu class to display the menu a customer will see when booting up the app
 *
 * @author davidlutrick
 */
public class AdminMenu {
    private String createAccount;
    private String searchRooms;
    private String bookRoom;
    private String viewRoom;

    AdminMenu() {
        createAccount = "Create an Account";
        searchRooms = "Search available rooms";
        bookRoom = "Book a room";
        viewRoom = "View a room";
    }

    /**
     * Gets the data from AminMenu to display
     * @return gives access to private fields
     */
    public String getCreateAccount() {
        return createAccount;
    }

    public String getSearchRooms() {
        return searchRooms;
    }

    public String getBookRoom() {
        return bookRoom;
    }

    public String getViewRoom() {
        return viewRoom;
    }
}
