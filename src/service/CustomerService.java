package service;

import model.Customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    // Singleton reference geeksforgeeks.org/singleton-class-java/
    // Created static reference of singleton instance
    private static CustomerService customerService = null;
    private final Map<String, Customer> customers = new HashMap<>();

    // Made constructor private to restrict it
    private CustomerService() {

    }

    // Created the static getInstance method to create an instance of the singlton
    public static CustomerService getInstance() {
        if(customerService == null) {
            customerService = new CustomerService();
        }

        return customerService;
    }

    public void addCustomer(String firstName, String lastName, String email) {
        customers.put(email, new Customer(firstName, lastName, email));
    }

    public Customer getCustomer(String email) {
        return customers.get(email);
    }

    public Collection<Customer> getAllCustomers() {
        return customers.values();
    }
}
