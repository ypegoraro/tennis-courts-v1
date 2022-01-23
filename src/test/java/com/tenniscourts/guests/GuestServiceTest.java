/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.tenniscourts.guests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

/**
 *
 * @author Yasmin
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(MockitoJUnitRunner.class)
public class GuestServiceTest {
    
    @Mock
    private GuestRepository guestRepository;
    
    @Mock
    private GuestMapper guestMapper;
    
    @InjectMocks
    private GuestService guestService;
    
    
   /* public GuestServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        //MockitoAnnotations.initMocks(this);
    }
    
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createGuest method, of class GuestService.
     */
    @Test
    public void testCreateGuestWhenSaved() {
       // GuestRepository guestRepository = mock(GuestRepository.class);
        CreateGuestRequestDTO createGuestRequestDTO = new CreateGuestRequestDTO();
        createGuestRequestDTO.setName("New guest");
    
        
        Guest guest = new Guest();
        
        guest.setName("New guest");
        
      //  when(guestRepository.save(any(Guest.class))).thenReturn(guest);
        
        when(guestMapper.map(any(GuestDTO.class))).thenReturn(guest);

        verify(guestRepository, times(1)).save(any(Guest.class));
    }
    
    @Test
    public void testCreateGuest2() {
        CreateGuestRequestDTO createGuestRequestDTO = new CreateGuestRequestDTO();
        createGuestRequestDTO.setName("New guest");
        
        Guest guest = new Guest();
        
        guest.setName("New guest");

        assertEquals(guestService.createGuest(GuestDTO).getName(), guest.getName());
    }
    
}
