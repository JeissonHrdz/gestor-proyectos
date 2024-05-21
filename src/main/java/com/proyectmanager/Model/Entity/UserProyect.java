package com.proyectmanager.Model.Entity;

import jakarta.persistence.Column;
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
@Table(name ="user_proyect")
public class UserProyect {


    @Column(name = "id_user")
    private Integer idUser;

    @Column(name ="id_proyect")
    private Integer idProyect;
    
}
