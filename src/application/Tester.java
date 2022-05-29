package application;

import application.model.customer.Customer;
import application.service.CustomerService;

public class Tester {
    public static void main(String[] args) {
        CustomerService.addCustomer("j@gmail.com", "Joe", "Spaz");
        CustomerService.addCustomer("k@gmail.com", "kole", "Spaz");
        CustomerService.addCustomer("l@gmail.com", "lannie", "Spaz");

        System.out.println(CustomerService.getCustomer("k@gmail.com"));

        System.out.println(CustomerService.getAllCustomers());
    }
}
