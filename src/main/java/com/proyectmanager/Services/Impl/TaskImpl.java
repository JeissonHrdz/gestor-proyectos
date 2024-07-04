package com.proyectmanager.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectmanager.Model.Dao.TaskDao;
import com.proyectmanager.Model.Dto.TaskDto;
import com.proyectmanager.Model.Entity.Task;
import com.proyectmanager.Services.ITaskService;

@Service
public class TaskImpl implements ITaskService {

    @Autowired
    private TaskDao taskDao;

    @Override
    public List<Task> listAllBySprint(Integer idSprint) {
        return (List) taskDao.ListAllBySprint(idSprint);
    }

    @Override
    public List<Task> listAllByProject(Integer idProject) {
        return (List) taskDao.ListAllByProject(idProject);
    }

    @Override
    public Task save(TaskDto taskDto) {
        Task task = Task.builder()
                .idTask(taskDto.getIdTask())
                .idSprint(taskDto.getIdSprint())
                .name(taskDto.getName())
                .description(taskDto.getDescription())
                .priority(taskDto.getPriority())
                .status(taskDto.getStatus())
                .dateCreation(taskDto.getDateCreation())
                .idProject(taskDto.getIdProject())
                .build();
        return taskDao.save(task);
    }

    @Override
    public Task findById(Integer id) {
        return taskDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Task task) {
        taskDao.delete(task);
    }

}
