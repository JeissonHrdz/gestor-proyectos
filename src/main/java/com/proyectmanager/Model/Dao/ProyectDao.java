package com.proyectmanager.Model.Dao;

import org.springframework.data.repository.CrudRepository;

import com.proyectmanager.Model.Entity.Proyect;

public interface ProyectDao extends CrudRepository<Proyect, Integer> {
    
}
