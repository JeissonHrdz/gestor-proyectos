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

public class SprintDto {  

    private Integer idSprint;
    private Date  dateStart;
    private Date dateEnd;
    private Integer number;
    private Integer idProject;
    private Date dateCreation;
}
