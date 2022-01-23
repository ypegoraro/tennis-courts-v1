/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tenniscourts.guests;

import com.tenniscourts.config.BaseRestController;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Yasmin
 */
@AllArgsConstructor
public class GuestController extends BaseRestController {
    
    private final GuestService guestService;
    
    @PostMapping(path = "/guest",
            consumes = MediaType.TEXT_PLAIN_VALUE
    )
    public ResponseEntity<Void> addGuest(@RequestBody GuestDTO guestDTO) {
        return ResponseEntity.created(locationByEntity(guestService.createGuest(guestDTO).getId())).build();
    }
    
}
