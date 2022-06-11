import menus.MainMenu;

import java.text.ParseException;

public class HotelApplication {
    public static void main(String[] args) {
        try {
            runApp();
        } catch (ParseException e) {
            System.out.println("Incorrect format. (MM/dd/yyyy)");
        }
    }

    public static void runApp() throws ParseException {
       MainMenu mainMenu = new MainMenu();
       mainMenu.mainMenuSelection();
    }
}
