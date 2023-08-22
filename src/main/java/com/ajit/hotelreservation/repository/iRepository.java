/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajit.hotelreservation.repository;

import java.util.List;

/**
 *
 * @author Aks
 */
public interface iRepository<T> {
    
    void add(T entity);
    void remove(T entity);
    List<T> FindAll(); 
}
