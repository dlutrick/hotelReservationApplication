package application.model.customer;

import java.util.regex.Pattern;

/**
 * The class for each customer created
 *
 * @author davidlutrick
 */
public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    // Source: Lesson 5 section 10 "RegEx" Infosys Java Development Program
    private final String emailRegex = "^(.+)@(.+).com$";
    private final Pattern pattern = Pattern.compile(emailRegex);

    public Customer(String firstName, String lastName, String email) {
        // Source: Lesson 5 section 10 "RegEx" Infosys Java Development Program
        if(!pattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Error, Invalid email");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "First name: " + firstName + "\nLast name: " + lastName + "\nEmail: " + email;
    }
}
