package com.proyectmanager.Model.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyectmanager.Model.Entity.Proyect;

public interface ProyectDao extends CrudRepository<Proyect, Integer> {

    @Query("SELECT p FROM Proyect p WHERE p.idUser = :idUser")
    List<Proyect> findAllProyectsByUserId(Integer idUser);
    
}
