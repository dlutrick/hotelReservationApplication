package application.controller;

import application.models.customer.Customer;
import application.userInterface.MainMenu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    MainMenu mainMenu = new MainMenu();
    Scanner scanner = new Scanner(System.in);
    public void start(boolean loggedIn) {
        Map<String, Customer> customers = new HashMap<>();
        Customer customer;
        while(loggedIn) {
            System.out.println("------Welcome valued customer!------");
            System.out.println(mainMenu.displayMenu());
            int selection = scanner.nextInt();
            if(selection == 1) {
                System.out.println("Please enter your name: ");
                String name = scanner.next();
                System.out.println("Please enter your email: ");
                String email = scanner.next();
                customer = new Customer(name, email);
                customers.put(customer.getEmail(), customer);
                System.out.println(customer.toString());
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
