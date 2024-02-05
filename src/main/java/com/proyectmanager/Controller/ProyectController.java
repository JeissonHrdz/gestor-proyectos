package com.proyectmanager.Controller;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proyectmanager.Model.Dto.ProyectDto;
import com.proyectmanager.Model.Entity.Proyect;
import com.proyectmanager.Model.Payload.MensajeResponse;
import com.proyectmanager.Services.IProyectService;

@RestController
@RequestMapping("/app")
public class ProyectController {

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

}
