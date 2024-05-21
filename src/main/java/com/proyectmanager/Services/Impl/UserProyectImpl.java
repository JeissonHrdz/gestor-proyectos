package com.proyectmanager.Services.Impl;

import org.springframework.stereotype.Service;

import com.proyectmanager.Model.Dao.UserProyectDao;
import com.proyectmanager.Model.Dto.UserProyectDto;
import com.proyectmanager.Model.Entity.UserProyect;
import com.proyectmanager.Services.IUserProyectService;

@Service
public class UserProyectImpl implements IUserProyectService {

    private UserProyectDao userProyectDao;

    @Override
    public void save(UserProyectDto userProyectDto) {
        UserProyect userProyect = UserProyect.builder()
        .idUser(userProyectDto.getIdUser())
        .idProyect(userProyectDto.getIdProyect())
        .build();

        userProyectDao.save(userProyect);       

    }
    
}
