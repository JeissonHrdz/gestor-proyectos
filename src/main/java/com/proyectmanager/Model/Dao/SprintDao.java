package com.proyectmanager.Model.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyectmanager.Model.Entity.Sprint;

public interface SprintDao extends CrudRepository<Sprint, Integer> {

    @Query("SELECT s FROM Sprint s WHERE s.idProject = :idProyect")
    List<Sprint> ListAllByProject(Integer idProyect);
    
}
