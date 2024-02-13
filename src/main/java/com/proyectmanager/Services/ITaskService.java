package com.proyectmanager.Services;

import java.util.List;

import com.proyectmanager.Model.Dto.TaskDto;
import com.proyectmanager.Model.Entity.Task;



public interface ITaskService {

    List<Task> listAllBySprint(Integer idSprint);

    Task save(TaskDto taskDto);

    Task findById(Integer id);

    void delete(Task task);
    
} 
