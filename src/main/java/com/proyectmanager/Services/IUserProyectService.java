package com.proyectmanager.Services;
import org.springframework.stereotype.Service;

import com.proyectmanager.Model.Dto.UserProyectDto;
import com.proyectmanager.Model.Entity.UserProyect;


@Service
public interface IUserProyectService {
    
    UserProyect save(UserProyectDto userProyectDto);
}
