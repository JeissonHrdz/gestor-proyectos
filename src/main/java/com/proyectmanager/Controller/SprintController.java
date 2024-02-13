package com.proyectmanager.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proyectmanager.Exceptions.ResourceNotFoundException;
import com.proyectmanager.Model.Dto.SprintDto;
import com.proyectmanager.Model.Entity.Sprint;
import com.proyectmanager.Model.Payload.MensajeResponse;
import com.proyectmanager.Services.ISprintService;

@RestController
@RequestMapping("/app/proyect/{idProyect}")
public class SprintController {

    @Autowired
    private ISprintService sprintService;

    @PostMapping("sprint")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody SprintDto sprintDto) {
        Sprint sprintSave = null;

        try {
            sprintSave = sprintService.save(sprintDto);
            sprintDto = SprintDto.builder()
                    .idSprint(sprintSave.getIdSprint())
                    .idProyect(sprintSave.getIdProyect())
                    .dateStart(sprintSave.getDateStart())
                    .dateEnd(sprintSave.getDateEnd())
                    .dateCreation(sprintSave.getDateCreation())
                    .number(sprintSave.getNumber())
                    .build();
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("")
                    .object(sprintDto)
                    .build(), HttpStatus.CREATED);

        } catch (DataAccessException DTeX) {
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje(DTeX.getMessage())
                    .object(null)
                    .build(),
                    HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @GetMapping("sprints")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findAllByProyect(@PathVariable("idProyect") Integer idProyect) {
        List<Sprint> sprint = sprintService.listAllByProyect(idProyect);
        if (sprint == null || sprint.isEmpty()) {
            throw new ResourceNotFoundException("proyect", "id", idProyect);
        }
        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("")
                        .object(sprint)
                        .build(),
                HttpStatus.OK);

    }

    @GetMapping("sprints/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> showById(@PathVariable Integer id) {
        Sprint sprint = sprintService.findById(id);

        if (sprint == null) {

            throw new ResourceNotFoundException("sprint", "id", id);
        }
        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("")
                        .object(SprintDto.builder()
                                .idSprint(sprint.getIdSprint())
                                .idProyect(sprint.getIdProyect())
                                .dateStart(sprint.getDateStart())
                                .dateEnd(sprint.getDateEnd())
                                .dateCreation(sprint.getDateCreation())
                                .number(sprint.getNumber())
                                .build())
                        .build(),
                HttpStatus.OK);
    }

    @DeleteMapping("sprints/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            Sprint sprintDelete = sprintService.findById(id);
            sprintService.delete(sprintDelete);
            return new ResponseEntity<>(sprintDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException DTeX) {
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje(DTeX.getMessage())
                    .object(null)
                    .build(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
