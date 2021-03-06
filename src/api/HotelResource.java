package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {
    private final ReservationService reservationService = ReservationService.getInstance();
    private final CustomerService customerService = CustomerService.getInstance();

    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    public void createACustomer(String firstName, String lastName, String email) {
        customerService.addCustomer(firstName, lastName, email);
    }

    public IRoom getRoom(String roomNumber) {
        return reservationService.getARoom(roomNumber);
    }

    public Reservation bookARoom(String email, IRoom room, Date checkInDate, Date checkOutDate) {
        return reservationService.reserveARoom(getCustomer(email), room, checkInDate, checkOutDate);
    }

    public Collection<Reservation> getCustomersReservations(String email) {
        return reservationService.getCustomersReservation(customerService.getCustomer(email));
    }

    public Collection<IRoom> findARoom(Date checkIn, Date checkOut) {
        return reservationService.findRooms(checkIn, checkOut);
    }

    public Collection<IRoom> findRoomsAWeekOut(Date checkIn, Date checkOut) {
        return reservationService.findRoomsAWeekOut(checkIn, checkOut);
    }

    public Date plusSevenDays(Date date) {
        return reservationService.plusSevenDays(date);
    }
}
