/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.tenniscourts.schedules;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tenniscourts.tenniscourts.TennisCourt;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author Yasmin
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ScheduleControllerIT {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;
    
    public ScheduleControllerIT() {
    }
    
    @Test
    public void testAddScheduleTennisCourtReturnsCreated() throws Exception {
        
        long tennisCourtId = 1;
        
        long hour = 1;
        
        CreateScheduleRequestDTO createScheduleRequestDTO = new CreateScheduleRequestDTO();
        
        createScheduleRequestDTO.setStartDateTime(LocalDateTime.now());
        createScheduleRequestDTO.setTennisCourtId(tennisCourtId);
        
        Schedule newSchedule = new Schedule();
        
        TennisCourt tennisCourt = new TennisCourt();
        
        tennisCourt.setId(tennisCourtId);
        
        newSchedule.setTennisCourt(tennisCourt);
        
        newSchedule.setStartDateTime(LocalDateTime.now());
        newSchedule.setEndDateTime(LocalDateTime.now().plusHours(hour));
       
        
     
        this.mockMvc.perform(post("/schedule")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(createScheduleRequestDTO)))
                .andExpect(status().isCreated());

//        this.mockMvc.perform(get("/tennisCourt/")
//                .contentType("application/json"))
//                .andExpect(status().isCreated());
    }

    /**
     * Test of addScheduleTennisCourt method, of class ScheduleController.
     */
    @Test
    public void testFindSchedulesByDatesReturnsOk() throws Exception {
        
        long daysAfter = 3;
        
        LocalDate startDate = LocalDate.now();
        
        LocalDate endDate = startDate.plusDays(daysAfter);
        
        
        this.mockMvc.perform(get("/schedule/{startDate}/{endDate}", startDate, endDate)
                .contentType("application/json"))
                .andExpect(status().isOk());      

    }
    
    @Test
    public void testFindSchedulesByIdReturnsOk() throws Exception {
        
        long id = 1;        
        
        this.mockMvc.perform(get("/schedule/{id}/", id)
                .contentType("application/json"))
                .andExpect(status().isOk());      

    }
   
}
