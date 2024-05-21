package com.proyectmanager.Services;

import org.springframework.stereotype.Service;

import com.proyectmanager.Model.Dto.UserProyectDto;


@Service
public interface IUserProyectService {
    
    void save(UserProyectDto userProyectDto);
}
