package com.proyectmanager.Services;

import java.util.List;

import com.proyectmanager.Model.Dto.SprintDto;
import com.proyectmanager.Model.Entity.Sprint;

public interface ISprintService {

    List<Sprint> listAllByProyect(Integer idProyect);

    Sprint save(SprintDto sprintDto);

    Sprint findById(Integer id);

    void delete(Sprint sprint);


}
