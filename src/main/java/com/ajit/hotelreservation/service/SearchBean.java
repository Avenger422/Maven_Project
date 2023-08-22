/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajit.hotelreservation.service;

import com.ajit.hotelreservation.entity.Room;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.ajit.hotelreservation.business.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Aks
 */
@ManagedBean
@SessionScoped
public class SearchBean {
    
    private int numOfGuests;
    private int level;
    private List<Room> availableRoom;
    private Date startDate;
    private Date endDate;
    
    /**
     * @return the numOfGuests
     */
    public int getNumOfGuests() {
        return numOfGuests;
    }

    /**
     * @param numOfGuests the numOfGuests to set
     */
    public void setNumOfGuests(int numOfGuests) {
        this.numOfGuests = numOfGuests;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @return the availableRoom
     */
    public List<Room> getAvailableRoom() {
        return availableRoom;
    }

    /**
     * @param availableRoom the availableRoom to set
     */
    public void setAvailableRoom(List<Room> availableRoom) {
        this.availableRoom = availableRoom;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    public String getRooms() {

        SearchRooms search = new SearchRooms();
        if (numOfGuests == 0) {
            return "";
        }

        Room room = null;
        if (numOfGuests <= 4) {
            room = search.findAvailableRoom(numOfGuests, startDate, endDate);
        }

        if (room == null || numOfGuests > 4) {
            availableRoom = search.findMultipleRoomsInSameFloor(numOfGuests, startDate, endDate);
        } else {
            availableRoom = new ArrayList<Room>();
            availableRoom.add(room);
        }

        return "";
    }
    
    public void getRoomsInDiffFloors(){
        
        SearchRooms search = new SearchRooms();
        availableRoom = search.findMultipleRoomsInDiffFloor(numOfGuests, startDate, endDate);
        
    }
}
