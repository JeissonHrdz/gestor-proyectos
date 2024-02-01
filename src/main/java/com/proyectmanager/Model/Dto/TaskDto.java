package com.proyectmanager.Model.Dto;

import java.util.Date;


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

public class TaskDto {


    private Integer idTask;
    private String name;
    private String description;
    private String status;   
    private Date dateCreation;
    private Integer idSprint;
}
