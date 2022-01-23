/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tenniscourts.guests;

import com.tenniscourts.exceptions.EntityNotFoundException;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Yasmin
 */
@Service
@AllArgsConstructor
public class GuestService {

    private final GuestRepository guestRepository;

    private final GuestMapper guestMapper;

    public GuestDTO createGuest(GuestDTO guestDTO) {
        //return guestMapper.map(guestRepository.saveAndFlush(guestMapper.map(createGuestRequestDTO)));
        return guestMapper.map(this.create(guestDTO));
    }

    private Guest create(GuestDTO guestDTO) {
        if (guestDTO == null) {
            System.out.println(guestDTO.getName());
        }
        System.out.println(guestMapper.map(guestDTO).getName());
        return guestRepository.save(guestMapper.map(guestDTO));
        /*Guest guest = new Guest();
        guest = guestMapper.map(createGuestRequestDTO);
        System.out.println(guest.getName());
        System.out.println(createGuestRequestDTO.getName());
        if (guest == null){
            System.out.println("ooooooooooooo");
        }
        return guestRepository.save(guest);*/
    }

    public GuestDTO findGuestById(Long id) {
        //return guestRepository.findById(id).map(GuestMapper::map).<RuntimeException>orElseThrow(() -> {
        try {
            return guestMapper.map((guestRepository.findById(id)).get());
        } catch (Exception e) {
            throw new EntityNotFoundException("Guest not found.");
        }
    }
    
    public List<GuestDTO> findGuestByName(String name) {
        
        List<Guest> guestsFound = new ArrayList<Guest>();
        
        List<GuestDTO> guestsDTOFound = new ArrayList<GuestDTO>();
        
        guestsFound = guestRepository.findByName(name);
        
        guestsDTOFound = guestMapper.map(guestsFound);
        
       /* for (Guest guestFound : guestsFound) {
            guestsDTOFound.add(guestRepository.findById(guestFound.getId()).map(GuestMapper::map));
        }*/
        
        return guestsDTOFound;
    }
    
    public List<GuestDTO> findAllGuests() {
        
        List<GuestDTO> guestsDTO = new ArrayList<GuestDTO>();
        
        List<Guest> guests = guestRepository.findAll();
        
        guestsDTO = guestMapper.map(guests);
        
        return guestsDTO;
        
        /* (Guest guest : guests) {
            guestsDTO.add(guestRepository.findById(guest.getId()).map(GuestMapper::map));
        }*/
    }

    private Guest updateGuest(Long guestId, Guest updatedGuest) {
        String newName = updatedGuest.getName();

        return guestRepository.findById(guestId).map(guest -> {
            guest.setName(newName);
            return guestRepository.save(guest);
        }).<RuntimeException>orElseThrow(() -> {
            throw new EntityNotFoundException("Guest not found.");
        });
    }

    public void deleteGuest(Long guestId) {
        
        try {
            guestRepository.deleteById(guestId);
        } catch (Exception e) {
            throw new EntityNotFoundException("Guest not found.");
        }
        /*return guestRepository.deleteById(guestId).<RuntimeException>orElseThrow(() -> {
            throw new EntityNotFoundException("Guest not found.");
        });*/
    }
}


