/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.tenniscourts.tenniscourts;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author Yasmin
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class TennisCourtControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

//    @Mock
//    private TennisCourtRepository tennisCourtRepository;
//
//    @Mock
//    private TennisCourtMapper tennisCourtMapper;
//
//    @InjectMocks
//    private TennisCourtService tennisCourtService;
    public TennisCourtControllerIT() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addTennisCourt method, of class TennisCourtController.
     */
    @Test
    public void testAddTennisCourtReturnsCreated() throws Exception {
        TennisCourt newTennisCourt = new TennisCourt();

        TennisCourtDTO newTennisCourtDto = new TennisCourtDTO();

        newTennisCourt.setName("Brand New Court");


//        if (tennisCourtMapper == null) {
//            System.out.println("mapper null");
//        }if (tennisCourtService == null) {
//            System.out.println("service null");
//        }if (tennisCourtRepository == null) {
//            System.out.println("repository null");
//        }
//        
//        when(tennisCourtMapper.map(any(TennisCourt.class))).thenReturn(newTennisCourtDto);
//        
//        when(tennisCourtRepository.save(any(TennisCourt.class))).thenReturn(newTennisCourt);
//
//        when(tennisCourtService.addTennisCourt(any())).thenReturn(newTennisCourtDto);
        this.mockMvc.perform(post("/tennisCourt")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(newTennisCourt)))
                .andExpect(status().isCreated());

//        this.mockMvc.perform(get("/tennisCourt/")
//                .contentType("application/json"))
//                .andExpect(status().isCreated());
    }
    
    @Test
    public void testTennisCourtFindByIdReturnsOk() throws Exception {


        long id = 1;
    

        this.mockMvc.perform(get("/tennisCourt/{id}", id)
                .contentType("application/json"))
                .andExpect(status().isOk());
    }
    
    @Test
    public void testTennisCourtFindByIdWithSchedulesReturnsOk() throws Exception {
    

        long id = 1;
    

        this.mockMvc.perform(get("/tennisCourtWithSchedules/{id}", id)
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    /**
     * Test of findTennisCourtById method, of class TennisCourtController.
     *//*
    @Test
    public void testFindTennisCourtById() {
        System.out.println("findTennisCourtById");
        Long tennisCourtId = null;
        TennisCourtController instance = null;
        ResponseEntity<TennisCourtDTO> expResult = null;
        ResponseEntity<TennisCourtDTO> result = instance.findTennisCourtById(tennisCourtId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findTennisCourtWithSchedulesById method, of class TennisCourtController.
     
    @Test
    public void testFindTennisCourtWithSchedulesById() {
        System.out.println("findTennisCourtWithSchedulesById");
        Long tennisCourtId = null;
        TennisCourtController instance = null;
        ResponseEntity<TennisCourtDTO> expResult = null;
        ResponseEntity<TennisCourtDTO> result = instance.findTennisCourtWithSchedulesById(tennisCourtId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

}
