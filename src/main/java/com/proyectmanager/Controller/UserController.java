package com.proyectmanager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proyectmanager.Exceptions.ResourceNotFoundException;
import com.proyectmanager.Model.Dto.UserDto;
import com.proyectmanager.Model.Entity.User;
import com.proyectmanager.Model.Payload.MensajeResponse;
import com.proyectmanager.Services.IUserService;

@RestController
@RequestMapping("/app")
@CrossOrigin(origins = "http://localhost:4200" )
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("user")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> created(@RequestBody UserDto userDto) {
        User userSave = null;

        try {
            userSave = userService.save(userDto);
            userDto = UserDto.builder()
                    .id(userSave.getId())
                    .name(userSave.getName())
                    .lastName(userSave.getLastName())
                    .email(userSave.getEmail())
                    .phone(userSave.getPhone())
                    .dateRegister(userSave.getDateRegister())
                    .idRol(userSave.getIdRol())
                    .password(userSave.getPassword())
                    .build();
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Guardado Correctamente")
                    .object(userDto)
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

    @GetMapping("user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        User user = userService.findById(id);

        if (user == null) {

            throw new ResourceNotFoundException("cliente", "id", id);

        }

        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("")
                        .object(UserDto.builder()
                                .id(user.getId())
                                .name(user.getName())
                                .lastName(user.getLastName())
                                .email(user.getEmail())
                                .dateRegister(user.getDateRegister())
                                .phone(user.getPhone())
                                .idRol(user.getIdRol())
                                .password(user.getPassword())
                                .build())
                        .build(),
                HttpStatus.OK);

    }
}
