package com.proyectmanager.Services;

import java.util.Set;

import com.proyectmanager.Model.Dto.UserDto;
import com.proyectmanager.Model.Entity.Proyect;
import com.proyectmanager.Model.Entity.User;

public interface IUserService {    

    User save(UserDto user);
    User findById(Integer id);
    Integer findUserId(String username);
    boolean existsById(Integer id);
    Set<Proyect> getProyectsByUserId(Integer idUser);

}
