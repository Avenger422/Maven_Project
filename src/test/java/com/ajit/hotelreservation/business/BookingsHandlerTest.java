/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajit.hotelreservation.business;

import com.ajit.hotelreservation.entity.BookingStatus;
import com.ajit.hotelreservation.entity.Reservation;
import com.ajit.hotelreservation.entity.Room;
import com.ajit.hotelreservation.entity.StudioRoom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aks
 */
public class BookingsHandlerTest {
    
    BookingsHandler instance;
    
    public BookingsHandlerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new BookingsHandler();
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of makeBooking method, of class BookingsHandler.
     */
    @Test
    public void testMakeBooking() {
        
        String guestName = "ajit";
        int guestId = 1;
        Date start = new Date();
        Date end = new Date();
        List<Room> availableRoom = new ArrayList<Room>();
        Room room = new StudioRoom(123);
        availableRoom.add(room);
        
        instance.makeBooking(guestName, guestId, start, end, availableRoom);
        assertEquals(1, availableRoom.get(0).getBookings().size());
        
    }

    /**
     * Test of cancelBooking method, of class BookingsHandler.
     */
    @Test
    public void testCancelBooking() {
        
        List<Reservation> guestBookings = new ArrayList<Reservation>();
        guestBookings.add(new Reservation("ajit", 1, new Date(), new Date(), 123));
       
        instance.cancelBooking(guestBookings.get(0).getUid(), guestBookings);
        assertEquals(BookingStatus.Cancelled, guestBookings.get(0).getBookingStatus());
    }
    
}
