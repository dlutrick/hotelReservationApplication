package application.service;

import application.model.customer.Customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {
    private static Customer customer;
    private static Map<String, Customer> customers = new HashMap<>();
    public static void addCustomer(String email, String firstName, String lastName) {
        customer = new Customer(firstName, lastName, email);
        customers.put(customer.getEmail(), customer);
    }

    public static Customer getCustomer(String customerEmail) {
        return customers.get(customerEmail);
    }

    public static Collection<Customer> getAllCustomers() {
        return customers.values();
    }
}
