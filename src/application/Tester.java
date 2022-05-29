package application;

import application.model.customer.Customer;
import application.service.CustomerService;

public class Tester {
    public static void main(String[] args) {
        CustomerService cs = new CustomerService();
        cs.addCustomer("j@gmail.com", "Joe", "Spaz");
        cs.addCustomer("k@gmail.com", "kole", "Spaz");
        cs.addCustomer("l@gmail.com", "lannie", "Spaz");

        System.out.println(cs.getCustomer("k@gmail.com"));

        //System.out.println(cs.getAllCustomers());
    }
}
