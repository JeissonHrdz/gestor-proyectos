package com.proyectmanager.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyectmanager.Model.Dao.UserProyectDao;
import com.proyectmanager.Model.Dto.UserProyectDto;
import com.proyectmanager.Model.Entity.UserProyect;
import com.proyectmanager.Services.IUserProyectService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserProyectImpl implements IUserProyectService {

    @Autowired
    private UserProyectDao userProyectDao;

    @Override
    public UserProyect save(UserProyectDto userProyectDto) {
       
        UserProyect userProyect = UserProyect.builder()
                .idUser(userProyectDto.getIdUser())
                .idProyect(userProyectDto.getIdProyect())
                .build();

        return userProyectDao.save(userProyect);

    }

}
