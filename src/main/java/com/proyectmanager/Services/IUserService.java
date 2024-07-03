package com.proyectmanager.Services;

import java.util.List;

import com.proyectmanager.Model.Dto.UserDto;
import com.proyectmanager.Model.Entity.Project;
import com.proyectmanager.Model.Entity.User;

public interface IUserService {    

    User save(UserDto user);
    User findById(Integer id);
    Integer findUserId(String username);
    boolean existsById(Integer id);
    List<Project> getProyectsByUserId(Integer idUser);

}
