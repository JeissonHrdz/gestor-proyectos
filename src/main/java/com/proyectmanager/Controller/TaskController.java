package com.proyectmanager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proyectmanager.Model.Dto.TaskDto;
import com.proyectmanager.Model.Entity.Task;
import com.proyectmanager.Model.Payload.MensajeResponse;
import com.proyectmanager.Services.ITaskService;

@RestController
@RequestMapping("/app/proyect/{idProyect}/sprints/{id}")
public class TaskController {

    @Autowired
    private ITaskService taskService;

    @PostMapping("tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody TaskDto taskDto) {
        Task taskSave = null;

        try {
            taskSave = taskService.save(taskDto);
            taskDto = TaskDto.builder()
                    .idTask(taskSave.getIdTask())
                    .idSprint(taskDto.getIdSprint())
                    .name(taskSave.getName())
                    .description(taskDto.getDescription())
                    .status(taskDto.getStatus())
                    .dateCreation(taskDto.getDateCreation())
                    .build();

            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("")
                    .object(taskDto)
                    .build(), HttpStatus.CREATED);

        } catch (DataAccessException DTeX) {
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje(DTeX.getMessage())
                    .object(null)
                    .build(),
                    HttpStatus.METHOD_NOT_ALLOWED);

        }
    }

}
