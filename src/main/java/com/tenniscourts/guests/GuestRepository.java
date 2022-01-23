/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tenniscourts.guests;

/**
 *
 * @author Yasmin
 */
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import org.springframework.stereotype.Repository;

public interface GuestRepository extends JpaRepository<Guest, Long> {

    List<Guest> findByName(String guestName);
    
    

}
