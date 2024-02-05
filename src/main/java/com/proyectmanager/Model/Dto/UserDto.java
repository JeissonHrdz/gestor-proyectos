package com.proyectmanager.Model.Dto;

import java.sql.Date;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class UserDto {

    private Integer id;   
    private String name; 
    private String lastName; 
    private String email; 
    private String phone;  
    private Date dateRegister;  
    private Integer idRol;
    
    
}
