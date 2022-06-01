import model.Customer;

public class Driver {
    public static void main(String[] args) {
        Customer customer = new Customer("first", "last", "d@domain.com");
        System.out.println(customer);
    }
}
