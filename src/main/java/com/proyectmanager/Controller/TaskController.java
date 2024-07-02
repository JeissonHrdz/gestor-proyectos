package com.proyectmanager.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.proyectmanager.Exceptions.ResourceNotFoundException;
import com.proyectmanager.Model.Dto.TaskDto;
import com.proyectmanager.Model.Entity.Task;
import com.proyectmanager.Model.Payload.MensajeResponse;
import com.proyectmanager.Services.ITaskService;

@RestController
@RequestMapping("/app/proyect/{idProyect}/sprints")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    @Autowired
    private ITaskService taskService;

    @PostMapping("task")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody TaskDto taskDto) {
        Task taskSave = null;

        try {
            taskSave = taskService.save(taskDto);
            taskDto = TaskDto.builder()
                    .idTask(taskSave.getIdTask())
                    .idSprint(taskSave.getIdSprint())
                    .name(taskSave.getName())
                    .description(taskSave.getDescription())
                    .priority(taskSave.getPriority())
                    .status(taskSave.getStatus())
                    .dateCreation(taskSave.getDateCreation())
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

    @GetMapping("tasks")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findAllBySprint(@PathVariable("id") Integer idSprint) {
        List<Task> task = taskService.listAllBySprint(idSprint);
        if (task == null || task.isEmpty()) {
            throw new ResourceNotFoundException("sprint", "id", idSprint);
        }
        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("")
                        .object(task)
                        .build(),
                HttpStatus.OK);

    }

       @DeleteMapping("tasks/{idTask}")
    public ResponseEntity<?> delete(@PathVariable Integer idTask) {
        try {
            Task taskDelete = taskService.findById(idTask);
            taskService.delete(taskDelete);
            return new ResponseEntity<>(taskDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException DTeX) {
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje(DTeX.getMessage())
                    .object(null)
                    .build(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
