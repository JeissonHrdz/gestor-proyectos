package com.proyectmanager.Services;

import java.util.List;

import com.proyectmanager.Model.Dto.ProjectDto;
import com.proyectmanager.Model.Entity.Project;

public interface IProjectService {

    List<Project> listAll();
    Project save(ProjectDto proyect);
    Project findById(Integer id);
    void delete(Project Project);
    List<Project> listAllByIdUser(Integer idUser);
    
}
