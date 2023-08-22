/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajit.hotelreservation.business;

import com.ajit.hotelreservation.entity.BookingStatus;
import com.ajit.hotelreservation.entity.Floor;
import com.ajit.hotelreservation.entity.Reservation;
import com.ajit.hotelreservation.entity.Room;
import com.ajit.hotelreservation.repository.FloorRepository;
import com.ajit.hotelreservation.repository.iRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Aks
 */
public class BookingsHandler {
    
    iRepository floorRepo;
    SearchRooms search;
      
    public BookingsHandler(){
        
        floorRepo = FloorRepository.getInstance();
        search = new SearchRooms();
    }
    
    public void makeBooking(String guestName, int guestId, Date start, Date end, List<Room> availableRoom) {

        for (Room room : availableRoom) {
            List<Reservation> reservations = room.getBookings();
            if (reservations == null) {
                reservations = new ArrayList<Reservation>();
            }
            reservations.add(new Reservation(guestName, guestId, start, end, room.getRoomNumber()));
            room.setBookings(reservations);
        }
    }

    public void cancelBooking(UUID bookingId, List<Reservation> guestBookings) {

        for (Reservation reservation : guestBookings) {
            if (reservation.getUid().compareTo(bookingId) == 0) {
                reservation.setBookingStatus(BookingStatus.Cancelled);
            }
        }
    }
    
    public List<Reservation> getReservations(int guestId) {

        List<Reservation> guestBookings = new ArrayList<Reservation>();
        List<Floor> floors = floorRepo.FindAll();
        
        for (Floor floor : floors) {
            for (Room room : floor.getRooms()) {
                if (room.getBookings() == null) {
                    continue;
                } else {
                    for (Reservation reservation : room.getBookings()) {
                        if (reservation.getGuestId() == guestId) {
                            guestBookings.add(reservation);
                        }
                    }
                }
            }

        }

        return guestBookings;
    }
}
