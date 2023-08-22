/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajit.hotelreservation.business;

import com.ajit.hotelreservation.entity.Room;
import com.ajit.hotelreservation.entity.Floor;
import com.ajit.hotelreservation.repository.FloorRepository;
import com.ajit.hotelreservation.repository.iRepository;
import java.util.*;

/**
 *
 * @author Aks
 */
public class SearchRooms {

    private iRepository floorRepo;
    private List<Floor> floors;
    
    public SearchRooms(){
        floorRepo = FloorRepository.getInstance();
        floors = floorRepo.FindAll();
    }

    public List<Room> findMultipleRoomsInSameFloor(int numOfGuests, Date startDate, Date endDate) {

        for (Floor floor : floors) {
            int guests = numOfGuests;
            ArrayList<Room> availableRooms = new ArrayList<Room>();
            for (Room room : floor.getRooms()) {
                if (!room.isOccupied(startDate, endDate)) {
                    guests -= room.getCapacity();
                    availableRooms.add(room);
                    if (guests <= 0) {
                        return availableRooms;
                    }
                }
            }
        }
        return new ArrayList<Room>();
    }

    public Room findAvailableRoom(int numOfGuests, Date startDate, Date endDate) {

        for (Floor floor : floors) {
            for (Room room : floor.getRooms()) {
                if (!room.isOccupied(startDate, endDate)) {
                    if (room.getCapacity() == numOfGuests || (numOfGuests == 3 && room.getCapacity() > numOfGuests)) {
                        return room;
                    }
                }
            }
        }

        return null;
    }

    public List<Room> findMultipleRoomsInDiffFloor(int numOfGuests, Date startDate, Date endDate) {

        ArrayList<Room> availableRooms = new ArrayList<Room>();
        int guests = numOfGuests;

        for (Floor floor : floors) {
            for (Room room : floor.getRooms()) {
                if (!room.isOccupied(startDate, endDate)) {
                    guests -= room.getCapacity();
                    availableRooms.add(room);
                    if (guests <= 0) {
                        break;
                    }
                }
            }
        }

        if (guests <= 0) {
            return availableRooms;
        } else {
            return new ArrayList<Room>();
        }
    }

    public List<Room> findAllAvailableRoomsForFloor(int level, Date startDate, Date endDate) {

        ArrayList<Room> availableRooms = new ArrayList<Room>();

        for (Floor floor : floors) {
            if (floor.getLevel() != level) {
                continue;
            } else {
                for (Room room : floor.getRooms()) {
                    if (!room.isOccupied(startDate, endDate)) {
                        availableRooms.add(room);
                    }
                }
            }

        }

        return availableRooms;
    }
    
}
