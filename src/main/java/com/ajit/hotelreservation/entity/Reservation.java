/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajit.hotelreservation.entity;

import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Aks
 */
public class Reservation {
    
    private String guestName;
    private int guestId;
    private Date start;
    private Date end;
    private int roomNumber;
    private BookingStatus bookingStatus;
    private UUID uid;
    
    public Reservation(String guestName, int guestId, Date start, Date end, int roomNumber) {
        this.guestName = guestName;
        this.guestId = guestId;
        this.start = start;
        this.end = end;
        this.roomNumber = roomNumber;
        this.bookingStatus = BookingStatus.Booked;
        this.uid = UUID.randomUUID();
    }
    
    /**
     * @return the guestName
     */
    public String getGuestName() {
        return guestName;
    }

    /**
     * @return the guestId
     */
    public int getGuestId() {
        return guestId;
    }

    /**
     * @return the start
     */
    public Date getStart() {
        return start;
    }

    /**
     * @return the end
     */
    public Date getEnd() {
        return end;
    }

    /**
     * @return the roomNumbers
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * @return the bookingStatus
     */
    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    /**
     * @param bookingStatus the bookingStatus to set
     */
    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    /**
     * @return the uid
     */
    public UUID getUid() {
        return uid;
    }
}
