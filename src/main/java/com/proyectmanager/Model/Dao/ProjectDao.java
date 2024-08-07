package com.proyectmanager.Model.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyectmanager.Model.Entity.Project;

public interface ProjectDao extends CrudRepository<Project, Integer> {

    @Query("SELECT p FROM Project p WHERE p.idUser = :idUser")
  //  @Query("select p from proyect p, user_proyect u where p.id_proyect = u.id_proyect and u.id_user = :idUser")    
    List<Project> findAllProjectsByUserId(Integer idUser);
    
}
