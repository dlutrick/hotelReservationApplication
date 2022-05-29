package application;

import application.model.customer.Customer;

public class Tester {
    public static void main(String[] args) {
        Customer customer = new Customer("first", "second", "email");
        System.out.println(customer);
    }
}
