package model;

import java.util.regex.Pattern;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;

    public Customer(String firstName, String lastName, String email) {
        // Source Lesson 5 Section 10 RegEx
        String emailRegex = "^(.+)@(.+).com$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        if(!emailPattern.matcher(email).matches()) {
            throw new IllegalArgumentException();
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "\nFirst name: " + firstName +
                "\nLast name: " + lastName +
                "\nEmail: " + email;
    }
}
