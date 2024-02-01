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
public class Proyect {

    @Id
    @Column(name = "id_proyect")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProyect;

    @Column(name = "name")
    private String name;

    @Column(name = "date_start")
    private Date dateStart;

    @Column(name = "date_end")
    private Date dateEnd;

    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "date_creation")
    private Date dateCreation;


    
}
