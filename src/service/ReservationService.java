package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.*;

public class ReservationService {
    // The <key, value> pair are room number and room
    private static final Map<String, IRoom> rooms = new HashMap<>();
    // List to contain all reservations
    private static final List<Reservation> reservations = new ArrayList<>();

    public static Collection<Reservation> getAllReservations() {
        return reservations;
    }

    public static void addRoom(IRoom room) {
        rooms.put(room.getRoomNumber(), room);
    }

    public static IRoom getARoom(String roomNumber) {
        return rooms.get(roomNumber);
    }

    public static Collection<IRoom> getAllRooms() {
        return rooms.values();
    }

    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(reservation);
        return reservation;
    }

    /**
     * Come back to fix
     * @param checkInDate
     * @param checkOutDate
     * @return
     */
    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        List<IRoom> availableRooms = new ArrayList<>();
        for(Reservation reservation : reservations) {
            if(checkOutDate.before(reservation.getCheckInDate()) || checkInDate.after(reservation.getCheckOutDate())) {
                availableRooms.add(reservation.getRoom());
            }

        }
        return availableRooms;
    }

    public static Collection<Reservation> getCustomersReservation(Customer customer) {
        List<Reservation> customersReservations = new ArrayList<>();
        for(Reservation reservation : reservations) {
            if(reservation.getCustomer().equals(customer)) {
                customersReservations.add(reservation);
            }
        }
        return customersReservations;
    }
}
