/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tenniscourts.guests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;


/**
 *
 * @author Yasmin
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class CreateGuestRequestDTO {
    
    @NotNull
    private String name;
    
}
