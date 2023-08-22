/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajit.hotelreservation.entity;

import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Aks
 */
public class Room {
    
    private int roomNumber;
    private double rate;
    private int capacity;
    private List<Reservation> bookings;

    public Room(int roomNumber, int capacity){
        
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }
    /**
     * @return the roomNumber
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * @param roomNumber the roomNumber to set
     */
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * @return the rate
     */
    public double getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(double rate) {
        this.rate = rate;
    }

    /**
     * @param startDate
     * @param endDate
     * @return the occupied
     */
    public boolean isOccupied(Date startDate, Date endDate) {
        
        if(bookings == null)
            return false;
        
        for(Reservation reservation : bookings)
        {
            if((reservation.getStart().before(startDate) || reservation.getStart().compareTo(startDate)==0) 
                    && (reservation.getEnd().after(endDate) || reservation.getEnd().compareTo(endDate)==0))
                return true;
            else if((reservation.getStart().before(startDate) || reservation.getStart().compareTo(startDate)==0) 
                    && (reservation.getEnd().after(startDate) || reservation.getEnd().compareTo(startDate)==0))
                return true;
            else if((reservation.getStart().before(endDate) || reservation.getStart().compareTo(endDate)==0) 
                    && (reservation.getEnd().after(endDate) || reservation.getEnd().compareTo(endDate)==0))
                return true;
        }
        return false;
    }

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @return the bookings
     */
    public List<Reservation> getBookings() {
        return bookings;
    }

    /**
     * @param bookings the bookings to set
     */
    public void setBookings(List<Reservation> bookings) {
        this.bookings = bookings;
    }

       
    
}
