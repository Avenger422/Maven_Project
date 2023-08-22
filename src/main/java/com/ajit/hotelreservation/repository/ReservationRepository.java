/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajit.hotelreservation.repository;

import com.ajit.hotelreservation.entity.Reservation;
import java.util.*;

/**
 *
 * @author Aks
 */
public class ReservationRepository implements iRepository<Reservation> {

    List<Reservation> reservations;
    
    public ReservationRepository(){
        reservations = new ArrayList<Reservation>();
    }
    
    @Override
    public void add(Reservation entity) {
        reservations.add(entity);
    }

    @Override
    public void remove(Reservation entity) {
        reservations.remove(entity);
    }

    @Override
    public List<Reservation> FindAll() {
        return reservations;
    }
    
}
