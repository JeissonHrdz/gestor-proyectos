package com.proyectmanager.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectmanager.Model.Dao.ProyectDao;
import com.proyectmanager.Model.Dto.ProyectDto;
import com.proyectmanager.Model.Entity.Proyect;
import com.proyectmanager.Services.IProyectService;

@Service
public class ProyectImpl implements IProyectService {

    @Autowired
    private ProyectDao proyectDao;

    @Override
    public List<Proyect> listAll() {
        return (List) proyectDao.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Proyect save(ProyectDto proyectDto) {
        Proyect proyect = Proyect.builder()
                .idProyect(proyectDto.getIdProyect())
                .name(proyectDto.getName())
                .dateStart(proyectDto.getDateStart())
                .dateEnd(proyectDto.getDateEnd())
                .dateCreation(proyectDto.getDateCreation())
                .idUser(proyectDto.getIdUser())
                .build();
        return proyectDao.save(proyect);

    }

    @Override
    public Proyect findById(Integer id) {
        return proyectDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Proyect Proyect) {
         proyectDao.delete(Proyect);
    }

}
