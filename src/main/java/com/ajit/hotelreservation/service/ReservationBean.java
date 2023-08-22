/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajit.hotelreservation.service;

import com.ajit.hotelreservation.business.BookingsHandler;
import com.ajit.hotelreservation.entity.BookingStatus;
import com.ajit.hotelreservation.entity.Reservation;
import com.ajit.hotelreservation.entity.Room;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Aks
 */

@ManagedBean
@SessionScoped
public class ReservationBean {
    
    private String guestName;
    private int guestId;
    private List<Reservation> guestBookings;
    
    /**
     * @return the guestName
     */
    public String getGuestName() {
        return guestName;
    }

    /**
     * @param guestName the guestName to set
     */
    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    /**
     * @return the guestId
     */
    public int getGuestId() {
        return guestId;
    }

    /**
     * @param guestId the guestId to set
     */
    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    /**
     * @return the guestBookings
     */
    public List<Reservation> getGuestBookings() {
        return guestBookings;
    }

    /**
     * @param guestBookings the guestBookings to set
     */
    public void setGuestBookings(List<Reservation> guestBookings) {
        this.guestBookings = guestBookings;
    }
    
    public void makeBooking(List<Room> availableRooms, Date startDate, Date endDate) {

        BookingsHandler bookings = new BookingsHandler();
        bookings.makeBooking(guestName, guestId, startDate, endDate, availableRooms);
    }

    public void cancelBooking(UUID bookingId) {

        BookingsHandler bookings = new BookingsHandler();
        bookings.cancelBooking(bookingId, guestBookings);
    }

    public void getReservations(){
        BookingsHandler bookings = new BookingsHandler();
        guestBookings = bookings.getReservations(guestId);
    }
}
