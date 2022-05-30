package application.service;

import application.controller.Application;
import application.model.IRoom;
import application.model.RoomType;
import application.model.customer.Customer;
import application.model.reservation.Reservation;
import application.model.room.Room;

import java.util.*;

public class ReservationService {
    private static Map<String, IRoom> rooms = new HashMap<>();
    private static Map<String, Reservation> reservations = new HashMap<>();
    public static void addRoom(IRoom room) {
        rooms.put(room.getRoomNumber(), room);
    }
    public static IRoom getARoom(String roomId) {
        return rooms.get(roomId);
    }
    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        reservations.put(customer.getEmail(), new Reservation(customer, room, checkInDate, checkOutDate));
        return reservations.get(customer.getEmail());
    }
//    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
//
//    }
//    public static void printAllReservation() {
//
//    }
}
