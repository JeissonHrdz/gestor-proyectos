package com.proyectmanager.Controller;

import java.util.List;


import com.proyectmanager.Model.Entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proyectmanager.Exceptions.ResourceNotFoundException;
import com.proyectmanager.Model.Dto.ProjectDto;
import com.proyectmanager.Model.Dto.UserProjectDto;
import com.proyectmanager.Model.Payload.MensajeResponse;
import com.proyectmanager.Services.IProjectService;
import com.proyectmanager.Services.IUserProjectService;
import com.proyectmanager.Services.IUserService;

@RestController
@RequestMapping("/app")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectController {

    @PostMapping("prueba")
    public String prueba() {
        return "PRUEBA DE AUTENTICACION";
    }


    @Autowired
    private IProjectService proyectService;

    @Autowired
    private IUserProjectService userProjectService;

    @Autowired
    private IUserService userService;

    @PostMapping("project")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> created(@RequestBody ProjectDto projectDto) {
        Project projectSave = null;

        try {
            projectSave = proyectService.save(projectDto);
            projectDto = ProjectDto.builder()
                    .idProject(projectSave.getIdProyect())
                    .name(projectSave.getName())
                    .dateStart(projectSave.getDateStart())
                    .dateEnd(projectSave.getDateEnd())
                    .dateCreation(projectSave.getDateCreation())
                    .idUser(projectSave.getIdUser())
                    .build();
           
            UserProjectDto userProjectDto = UserProjectDto.builder()
                    .idUser(projectSave.getIdUser())
                    .idProject(projectSave.getIdProyect())
                    .build();
            userProjectService.save(userProjectDto);

            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Guardado Correctamente")
                    .object(projectDto)
                    .build(),
                    HttpStatus.CREATED);
        } catch (DataAccessException DTeX) {
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje(DTeX.getMessage())
                    .object(null)
                    .build(),
                    HttpStatus.METHOD_NOT_ALLOWED);
        }

    }

    @GetMapping("project/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Project project = proyectService.findById(id);
        if (project == null) {
            throw new ResourceNotFoundException("project", "id", id);
        }

        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("")
                        .object(ProjectDto.builder()
                                .idProject(project.getIdProyect())
                                .name(project.getName())
                                .dateStart(project.getDateStart())
                                .dateEnd(project.getDateEnd())
                                .dateCreation(project.getDateCreation())
                                .idUser(project.getIdUser())
                                .build())
                        .build(),
                HttpStatus.OK);

    }

    @DeleteMapping("project/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {

        try {
            Project projectDelete = proyectService.findById(id);
            proyectService.delete(projectDelete);
            return new ResponseEntity<>(projectDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException DTeX) {
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje(DTeX.getMessage())
                    .object(null)
                    .build(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("project")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> showAll() {
        List<Project> getList = proyectService.listAll();

        if (getList == null || getList.isEmpty()) {
            throw new ResourceNotFoundException("proyect");
        }
        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("")
                        .object(getList)
                        .build(),
                HttpStatus.OK);
    }

    @GetMapping("projects/{idUser}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> showAllProjectByIdUser(@PathVariable Integer idUser) {
        List<Project> getList = userService.getProyectsByUserId(idUser);  //proyectService.listAllByIdUser(idUser);
        
        if (getList == null || getList.isEmpty()) {
            throw new ResourceNotFoundException("project");
        }
        return new ResponseEntity<>(getList, HttpStatus.OK);
        /*
         * MensajeResponse.builder()
         * .mensaje("")
         * .object(getList)
         * .build(),
         * HttpStatus.OK);
         */

    }

}
