/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tenniscourts.guests;

import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
/**
 *
 * @author Yasmin
 */
@Mapper(componentModel = "spring")
public interface GuestMapper {    
    
    Guest map(GuestDTO source);

    GuestDTO map(Guest source);

    List<GuestDTO> map(List<Guest> source);
    
}
