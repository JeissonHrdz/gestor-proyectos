package com.proyectmanager.Services;

import java.util.List;

import com.proyectmanager.Model.Dto.ProyectDto;
import com.proyectmanager.Model.Entity.Proyect;

public interface IProyectService {

    List<Proyect> listAll();
    Proyect save(ProyectDto proyect);
    Proyect findById(Integer id);
    void delete(Proyect Proyect);
    
}
