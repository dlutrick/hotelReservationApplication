package application.controller;

import application.model.customer.Customer;
import application.userInterface.AdminMenu;
import application.userInterface.MainMenu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * The class that contains all of the business logic to control the loop
 *
 * @author davidlutrick
 */
public class Application {
    MainMenu mainMenu = new MainMenu();
    AdminMenu adminMenu = new AdminMenu();
    Scanner scanner = new Scanner(System.in);

    /**
     * Application loop that runs the cli if the user is currently logged in
     * @param loggedIn boolean value representing the customer being logged in or not
     */
    public void start(boolean loggedIn) {
        // Key value pair data structure containing all of the customers that sign up
        Map<String, Customer> customers = new HashMap<>();
        Customer customer;
        boolean isAdmin = false;
        while(loggedIn) {
            System.out.println("------Welcome valued customer!------");
            System.out.println(mainMenu.displayMenu());
            int selection = scanner.nextInt();
            // Prompts the user to enter their name and email to create an account
            if(selection == 1) {
                System.out.println("Please enter your first name: ");
                String firstName = scanner.next();
                System.out.println("Please enter your last name: ");
                String lastName = scanner.next();
                System.out.println("Please enter your email: ");
                String email = scanner.next();
                customer = new Customer(firstName, lastName, email);
                customers.put(customer.getEmail(), customer);
                System.out.println(customer.toString());
            } else if(selection == 2) {
                System.out.println("2");
            } else if(selection == 3) {
                System.out.println("3");
            } else if(selection == 4) {
                System.out.println("4");
                // Creates the Admin menu loop
            } else if(selection == 5) {
                isAdmin = true;
                while(isAdmin) {
                    System.out.println("------Welcome admin------");
                    System.out.println(adminMenu.displayMenu());
                    int adminSelection = scanner.nextInt();
                    scanner.nextLine();
                    if(adminSelection == 1) {

                    } else if(adminSelection == 2) {
                        System.out.println("2");
                    } else if(adminSelection == 3) {
                        System.out.println("2");
                    } else if(adminSelection == 4) {
                        System.out.println("2");
                    } else if(adminSelection == 5) {
                        isAdmin = false;
                    } else {
                        System.out.println("------Please select a valid option.------");
                    }
                }
            } else if(selection == 6) {
                System.out.println("Thank you for using our application! See you soon!");
                loggedIn = false;
            } else {
                System.out.println("------Please select a valid option.------");
            }
        }
    }
}
