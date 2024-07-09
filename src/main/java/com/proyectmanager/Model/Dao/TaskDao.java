package com.proyectmanager.Model.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.proyectmanager.Model.Entity.Task;
import org.springframework.data.repository.query.Param;

public interface TaskDao extends CrudRepository<Task, Integer> {

        @Query("SELECT s FROM Task s WHERE s.idSprint = :idSprint")
    List<Task> ListAllBySprint(Integer idSprint);

    @Query("SELECT s FROM Task s WHERE s.idProject = :idProject")
    List<Task> ListAllByProject(Integer idProject);

    @Query("UPDATE Task t set t.status = :newStatus WHERE t.idTask = :idTask")
    int updateTaskStatus(@Param("idTask") Integer idTask, @Param("newStatus") String newStatus);
    
}
