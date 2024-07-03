package com.proyectmanager.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyectmanager.Model.Dao.UserProjectDao;
import com.proyectmanager.Model.Dto.UserProjectDto;
import com.proyectmanager.Model.Entity.UserProject;
import com.proyectmanager.Services.IUserProjectService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserProjectImpl implements IUserProjectService {

    @Autowired
    private UserProjectDao userProjectDao;

    @Override
    public UserProject save(UserProjectDto userProjectDto) {
       
        UserProject userProject = UserProject.builder()
                .idUser(userProjectDto.getIdUser())
                .idProject(userProjectDto.getIdProject())
                .build();

        return userProjectDao.save(userProject);

    }

}
