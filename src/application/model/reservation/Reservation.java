package application.model.reservation;

import java.util.Calendar;

public class Reservation {
    private String customerName;
    private String customerEmail;
    private Calendar checkInDate;
    private Calendar checkOutDate;

    public Reservation(String customerName, String customerEmail, Calendar checkInDate, Calendar checkOutDate) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCheckInDate(Calendar checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Calendar getCheckInDate() {
        return checkInDate;
    }

    public void setCheckOutDate(Calendar checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Calendar getCheckOutDate() {
        return checkOutDate;
    }
}
