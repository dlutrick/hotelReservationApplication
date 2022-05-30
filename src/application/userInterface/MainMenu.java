package application.userInterface;

/**
 * Main menu class to display the menu a customer will see when booting up the app
 *
 * @author davidlutrick
 */
public class MainMenu {
    private String mainMenu;
    public MainMenu() {
        mainMenu = "------------------------------\n" +
                    "1) Find and reserve a room\n" +
                    "2) See my reservations\n" +
                    "3) Create an account\n" +
                    "4) Admin menu\n" +
                    "5) Logout\n" +
                    "------------------------------";
    }

    public String displayMenu() {
        return mainMenu;
    }
}
