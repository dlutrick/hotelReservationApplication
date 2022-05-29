package application;

import application.userInterface.MainMenu;

public class Main {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        System.out.println(mainMenu.displayMenu());
    }
}
