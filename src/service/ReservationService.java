package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class ReservationService {
    // Singleton reference geeksforgeeks.org/singleton-class-java/
    // Created static reference of singleton instance
    private static ReservationService reservationService = null;
    // The <key, value> pair are room number and list of reservations for that room
    private final Map<String, Collection<Reservation>> bookingInfo = new HashMap<>();
    private final Map<String, IRoom> rooms = new HashMap<>();

    // Made constructor private to restrict it
    private ReservationService() {

    }

    // Created the static getInstance method to create an instance of the singleton
    public static ReservationService getInstance() {
        if(reservationService == null) {
            reservationService = new ReservationService();
        }

        return reservationService;
    }

    public Collection<Reservation> getAllReservations() {
        Collection<Reservation> allReservations = new ArrayList<>();
        for(Collection<Reservation> reservations : bookingInfo.values()) {
            allReservations.addAll(reservations);
        }

        return allReservations;
    }

    public void addRoom(IRoom room) {
        rooms.put(room.getRoomNumber(), room);
        bookingInfo.put(room.getRoomNumber(), new ArrayList<>());
    }

    public IRoom getARoom(String roomNumber) {
        return rooms.get(roomNumber);
    }

    public Collection<IRoom> getAllRooms() {
        return rooms.values();
    }

    // method utilizing the default modifier
    void thankCustomer(String firstName, String lastName) {
        System.out.println("Thank you, " + firstName + " " + lastName);
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Collection<IRoom> availableRooms = findRooms(checkInDate, checkOutDate);
        Reservation reservation = null;
        // Creates a new reservation
        if(availableRooms.contains(room)){
            reservation = new Reservation(customer, room, checkInDate, checkOutDate);
            // Adds that reservation to bookingInfo to track each rooms reservations
            bookingInfo.get(room.getRoomNumber()).add(reservation);
        }
        thankCustomer(customer.getFirstName(), customer.getLastName());
        return reservation;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        // Creates a list of all available room within time frame
        // Creates a list of all available rooms
        Collection<IRoom> availableRooms = new ArrayList<>(rooms.values());
        // Creates a list of all rooms that are taken during the time frame
        Collection<IRoom> unavailableRooms = new ArrayList<>();
        Collection<Reservation> reservations = getAllReservations();

        for(Reservation reservation : reservations) {
            if(!roomIsFree(checkInDate, checkOutDate, reservation)) {
                unavailableRooms.add(reservation.getRoom());
            }
        }

        // Filters out the unavailable rooms
        availableRooms.removeIf(unavailableRooms::contains);

        return availableRooms;
    }

    public Collection<IRoom> findRoomsAWeekOut(Date checkIn, Date checkOut) {
        System.out.println("Here's what we found: From " + checkIn + " through " + checkOut);
        return findRooms(checkIn, checkOut);
    }

    private boolean roomIsFree(Date checkIn, Date checkOut, Reservation reservation) {
        return checkOut.before(reservation.getCheckInDate()) || checkIn.after(reservation.getCheckOutDate());
    }

    public Date plusSevenDays(Date date) {
        LocalDate localDate = LocalDate.from(date.toInstant().atZone(ZoneId.systemDefault()));
        localDate = localDate.plusDays(7);
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public Collection<Reservation> getCustomersReservation(Customer customer) {
        List<Reservation> customersReservations = new ArrayList<>();
        Collection<Reservation> reservations = getAllReservations();
        for(Reservation res : reservations) {
            if(res.getCustomer().getEmail().equals(customer.getEmail())) {
                customersReservations.add(res);
            }
        }
        return customersReservations;
    }
}
