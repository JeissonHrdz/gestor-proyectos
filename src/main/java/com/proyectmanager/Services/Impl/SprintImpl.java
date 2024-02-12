package com.proyectmanager.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectmanager.Model.Dao.SprintDao;
import com.proyectmanager.Model.Dto.SprintDto;
import com.proyectmanager.Model.Entity.Sprint;
import com.proyectmanager.Services.ISprintService;

@Service
public class SprintImpl implements ISprintService {

    @Autowired
    private SprintDao sprintDao;

    @Override
    public Sprint save(SprintDto sprintDto) {
        Sprint sprint = Sprint.builder()
                .idSprint(sprintDto.getIdSprint())
                .idProyect(sprintDto.getIdProyect())
                .dateStart(sprintDto.getDateStart())
                .dateEnd(sprintDto.getDateEnd())
                .dateCreation(sprintDto.getDateCreation())
                .number(sprintDto.getNumber())
                .build();
        return sprintDao.save(sprint);
    }

    @Override
    public Sprint findById(Integer id) {
        return sprintDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Sprint sprint) {
        sprintDao.delete(sprint);
    }

    @Override
    public List<Sprint> listAllByProyect(Integer idProyect) {
        return (List) sprintDao.ListAllByProyect(idProyect);
    }

}
