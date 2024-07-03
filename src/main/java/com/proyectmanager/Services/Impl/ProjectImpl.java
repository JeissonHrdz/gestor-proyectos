package com.proyectmanager.Services.Impl;

import java.util.List;

import com.proyectmanager.Model.Entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectmanager.Model.Dao.ProjectDao;
import com.proyectmanager.Model.Dto.ProjectDto;
import com.proyectmanager.Services.IProjectService;

@Service
public class ProjectImpl implements IProjectService {

    @Autowired
    private ProjectDao projectDao;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public List<Project> listAll() {
        return (List) projectDao.findAll();
    }


    @Override
    public Project save(ProjectDto projectDto) {
        Project project = Project.builder()
                .idProyect(projectDto.getIdProject())
                .name(projectDto.getName())
                .dateStart(projectDto.getDateStart())
                .dateEnd(projectDto.getDateEnd())
                .dateCreation(projectDto.getDateCreation())
                .idUser(projectDto.getIdUser())
                .build();
        return projectDao.save(project);

    }

    @Override
    public Project findById(Integer id) {
        return projectDao.findById(id).orElse(null);
    }

   

    @Override
    public void delete(Project Project) {
         projectDao.delete(Project);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public List<Project> listAllByIdUser(Integer idUser) {
        return (List) projectDao.findAllProjectsByUserId(idUser);
    }

}
