/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajit.hotelreservation.entity;

import java.util.*;

/**
 *
 * @author Aks
 */
public class Floor {
    
    private int level;
    private List<Room> rooms;
    
    public Floor(int level){
        
        this.level = level;
        createRooms();
    }

    private void createRooms() {
        
        rooms = new ArrayList<Room>();
        
        for(int i=0;i<10;i++){
            
            if(i<3)
                getRooms().add(new ExecutiveRoom(createRoomNumber(level,i)));
            else if(i>2 && i<8)
                getRooms().add(new DeluxeRoom(createRoomNumber(level,i)));
            else if(i>7)
                getRooms().add(new StudioRoom(createRoomNumber(level,i)));
        }
//        for(int i=0;i<3;i++){
//            getRooms().add(new ExecutiveRoom());
//        }
//        for(int i=0;i<5;i++){
//            getRooms().add(new DeluxeRoom());
//        }
//        for(int i=0;i<2;i++){
//            getRooms().add(new StudioRoom());
//        }
    }
    
    private int createRoomNumber(int level, int roomCount){
        
        if(roomCount<9)
            return Integer.parseInt(Integer.toString(level) + "0" + Integer.toString(roomCount+1));
        else 
            return Integer.parseInt(Integer.toString(level) + Integer.toString(roomCount+1));
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
     * @return the rooms
     */
    public List<Room> getRooms() {
        return rooms;
    }
}
