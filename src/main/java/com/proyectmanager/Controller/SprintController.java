package com.proyectmanager.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyectmanager.Exceptions.ResourceNotFoundException;
import com.proyectmanager.Model.Dto.SprintDto;
import com.proyectmanager.Model.Entity.Sprint;
import com.proyectmanager.Model.Payload.MensajeResponse;
import com.proyectmanager.Services.ISprintService;

@RestController
@RequestMapping("/app/project/{idProject}")
@CrossOrigin(origins = "http://localhost:4200")
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
                    .idProject(sprintSave.getIdProject())
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
    public ResponseEntity<?> findAllByProyect(@PathVariable("idProject") Integer idProject) {
        List<Sprint> sprint = sprintService.listAllByProject(idProject);
        if (sprint == null || sprint.isEmpty()) {
            throw new ResourceNotFoundException("proyect", "id", idProject);
        }

        return new ResponseEntity<>(sprint, HttpStatus.OK);
       /* return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("")
                        .object(sprint)
                        .build(),
                HttpStatus.OK);*/

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
                                .idProject(sprint.getIdProject())
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
