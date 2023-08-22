/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajit.hotelreservation.repository;

import com.ajit.hotelreservation.entity.Room;
import java.util.*;

/**
 *
 * @author Aks
 */
public class RoomRepository implements iRepository<Room> {

    List<Room> rooms;
    
    public RoomRepository(){
        rooms = new ArrayList<Room>();
    }
    
    @Override
    public void add(Room entity) {
        rooms.add(entity);
    }

    @Override
    public void remove(Room entity) {
        rooms.remove(entity);
    }

    @Override
    public List<Room> FindAll() {
        return rooms;
    }
    
}
