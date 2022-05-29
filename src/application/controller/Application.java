package application.controller;

import application.userInterface.MainMenu;

import java.util.Scanner;

public class Application {
    MainMenu mainMenu = new MainMenu();
    Scanner scanner = new Scanner(System.in);
    public void start(boolean loggedIn) {
        while(loggedIn) {
            System.out.println(mainMenu.displayMenu());
            int selection = scanner.nextInt();
            if(selection == 1) {
                System.out.println("1");
            } else if(selection == 2) {
                System.out.println("2");
            } else if(selection == 3) {
                System.out.println("3");
            } else if(selection == 4) {
                System.out.println("4");
            } else if(selection == 5) {
                System.out.println("5");
            } else if(selection == 6) {
                System.out.println("Thank you for using our application! See you soon!");
                loggedIn = false;
            } else {
                System.out.println("----Please select a valid option.----");
            }
        }
    }
}
