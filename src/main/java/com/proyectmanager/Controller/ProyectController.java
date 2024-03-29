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
import com.proyectmanager.Model.Dto.ProyectDto;
import com.proyectmanager.Model.Entity.Proyect;
import com.proyectmanager.Model.Payload.MensajeResponse;
import com.proyectmanager.Services.IProyectService;

@RestController
@RequestMapping("/app")
public class ProyectController {

    @Autowired
    private IProyectService proyectService;

    @PostMapping("proyect")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> created(@RequestBody ProyectDto proyectDto) {
        Proyect proyectSave = null;

        try {
            proyectSave = proyectService.save(proyectDto);
            proyectDto = ProyectDto.builder()
                    .idProyect(proyectSave.getIdProyect())
                    .name(proyectSave.getName())
                    .dateStart(proyectSave.getDateStart())
                    .dateEnd(proyectSave.getDateEnd())
                    .dateCreation(proyectSave.getDateCreation())
                    .idUser(proyectSave.getIdUser())
                    .build();
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Guardado Correctamente")
                    .object(proyectDto)
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

    @GetMapping("proyect/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Proyect proyect = proyectService.findById(id);
        if (proyect == null) {
            throw new ResourceNotFoundException("proyect", "id", id);
        }

        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("")
                        .object(ProyectDto.builder()
                                .idProyect(proyect.getIdProyect())
                                .name(proyect.getName())
                                .dateStart(proyect.getDateStart())
                                .dateEnd(proyect.getDateEnd())
                                .dateCreation(proyect.getDateCreation())
                                .idUser(proyect.getIdUser())
                                .build())
                        .build(),
                HttpStatus.OK);

    }

    @DeleteMapping("proyect/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {

        try {
            Proyect proyectDelete = proyectService.findById(id);
            proyectService.delete(proyectDelete);
            return new ResponseEntity<>(proyectDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException DTeX) {
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje(DTeX.getMessage())
                    .object(null)
                    .build(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("proyect")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> showAll() {
        List<Proyect> getList = proyectService.listAll();

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

}
