/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.tenniscourts.reservations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tenniscourts.schedules.Schedule;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author Yasmin
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ReservationControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    public ReservationControllerIT() {
    }

    /**
     * Test of bookReservation method, of class ReservationController.
     */
    @Test
    public void testBookReservatonReturnsCreated() throws Exception {
        long id = 1;
        long scheduleId = 2;
      
        CreateReservationRequestDTO createReservationRequestDTO = new CreateReservationRequestDTO();
        
        Schedule newSchedule = new Schedule();
        newSchedule.setId(id);
        
        Reservation newReservation = new Reservation();
        newReservation.setId(id);
        
        createReservationRequestDTO.setGuestId(id);
        createReservationRequestDTO.setScheduleId(scheduleId);
        System.out.println(createReservationRequestDTO.getGuestId().toString() + createReservationRequestDTO.getScheduleId().toString());
        
        this.mockMvc.perform(post("/reservation/book")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(createReservationRequestDTO)))
                .andExpect(status().isCreated());
        
 
    }
    
    @Test
    public void testFindSReservationByIdReturnsOk() throws Exception {
        
        long id = 1;        
        
        this.mockMvc.perform(get("/reservation/{id}/", id)
                .contentType("application/json"))
                .andExpect(status().isOk());      

    }
    
    @Test
    public void testRescheduleReservationReturnsOk() throws Exception {
        
        long reservationId = 1;        

        long newScheduleId = 3;
        
        this.mockMvc.perform(put("/reservation/reschedule/{reservationId}", reservationId)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(newScheduleId)))
                .andExpect(status().isOk());        
     
    }

    /**
     * Test of cancelReservation method, of class ReservationController.
     */
    @Test
    public void testCancelReservation() throws Exception {
        
        long reservationId = 2;        
        
        this.mockMvc.perform(put("/reservation/cancel")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(reservationId)))
                .andExpect(status().isOk());    
    }



}
