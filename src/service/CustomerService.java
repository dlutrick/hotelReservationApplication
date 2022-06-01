package service;

import model.Customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {
    private static final Map<String, Customer> customers = new HashMap<>();

    public static void addCustomer(String firstName, String lastName, String email) {
        customers.put(email, new Customer(firstName, lastName, email));
    }

    public static Customer getCustomer(String email) {
        return customers.get(email);
    }

    public static Collection<Customer> getAllCustomers() {
        return customers.values();
    }
}
