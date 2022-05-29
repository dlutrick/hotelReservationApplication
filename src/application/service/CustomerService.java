package application.service;

import application.model.customer.Customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {
    private Customer customer;
    private Map<String, Customer> customers = new HashMap<>();
    public void addCustomer(String email, String firstName, String lastName) {
        customer = new Customer(firstName, lastName, email);
        customers.put(customer.getEmail(), customer);
    }

    public Customer getCustomer(String customerEmail) {
        return customers.get(customerEmail);
    }

    public Collection<Customer> getAllCustomers() {
        return customers.values();
    }
}
