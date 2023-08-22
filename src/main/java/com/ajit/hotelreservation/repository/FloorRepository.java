/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajit.hotelreservation.repository;

import com.ajit.hotelreservation.entity.Floor;
import com.ajit.hotelreservation.entity.Hotel;
import java.util.*;

/**
 *
 * @author Aks
 */
public class FloorRepository implements iRepository<Floor>{

    private static FloorRepository instance;
    List<Floor> floors;
    
    private FloorRepository(){
        
        floors = new ArrayList<Floor>();
        for(int i=0; i<10;i++){
            floors.add(new Floor(i+1));
        }
    }
    
    public static synchronized FloorRepository getInstance(){
        if(instance == null)
            instance = new FloorRepository();
        
        return instance;
    }
    
    @Override
    public void add(Floor entity) {
        floors.add(entity);
    }

    @Override
    public void remove(Floor entity) {
        floors.remove(entity);
    }

    @Override
    public List<Floor> FindAll() {
        return floors;
    }
    
}
