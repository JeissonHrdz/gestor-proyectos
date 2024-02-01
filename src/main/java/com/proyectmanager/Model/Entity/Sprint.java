package com.proyectmanager.Model.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "proyect")
public class Sprint {

    @Id
    @Column(name = "id_sprint")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer idSprint;

    @Column(name = "date_start")
    private Date  dateStart;

    @Column(name = "date_end")
    private Date dateEnd;

    @Column(name = "number")
    private Integer number;

    @Column(name = "id_proyect")
    private Integer idProyect;

    @Column(name = "date_creation")
    private Date dateCreation;
}
