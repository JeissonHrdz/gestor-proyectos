package com.proyectmanager.Services;
import org.springframework.stereotype.Service;

import com.proyectmanager.Model.Dto.UserProjectDto;
import com.proyectmanager.Model.Entity.UserProject;


@Service
public interface IUserProjectService {
    
    UserProject save(UserProjectDto userProjectDto);
}
