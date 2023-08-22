/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajit.hotelreservation.business;

import com.ajit.hotelreservation.entity.Room;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author Aks
 */
public class SearchRoomsTest {
    
    private SearchRooms search;
    
    public SearchRoomsTest() {
        search = new SearchRooms();
    }
    
    /**
     * Test of findMultipleRoomsInSameFloor method, of class SearchRooms.
     */
    @org.junit.Test
    public void testFindMultipleRoomsInSameFloor() {
        
        int numOfGuests = 6;
        Date startDate = new Date();
        Date endDate = new Date();
                
        List<Room> result = search.findMultipleRoomsInSameFloor(numOfGuests, startDate, endDate);
        assertEquals(2, result.size());
        assertEquals(4, result.get(0).getCapacity());
        assertEquals(4, result.get(1).getCapacity());
        
    }

    /**
     * Test of findAvailableRoom method, of class SearchRooms.
     */
    @org.junit.Test
    public void testFindAvailableRoom() {
        
        int numOfGuests = 1;
        Date startDate = new Date();
        Date endDate = new Date();
        
        Room result = search.findAvailableRoom(numOfGuests, startDate, endDate);
        assertEquals(1, result.getCapacity());
        
    }

    /**
     * Test of findAllAvailableRoomsForFloor method, of class SearchRooms.
     */
    @org.junit.Test
    public void testFindAllAvailableRoomsForFloor() {
        
        int level = 1;
        Date startDate = new Date();
        Date endDate = new Date();
        
        List<Room> result = search.findAllAvailableRoomsForFloor(level, startDate, endDate);
        assertEquals(10, result.size());
    }
    
}
