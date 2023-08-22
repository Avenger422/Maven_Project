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
public class Hotel {
    
    private static Hotel instance;
    private List<Floor> floors;
    
    private Hotel(){
        
        floors = new ArrayList<Floor>();
        for(int i=0; i<10;i++){
            floors.add(new Floor(i+1));
        }
    }
    
    public static synchronized Hotel getInstance(){
        if(instance == null)
            instance = new Hotel();
        
        return instance;
    }

    /**
     * @return the floors
     */
    public List<Floor> getFloors() {
        return floors;
    }
        
}
