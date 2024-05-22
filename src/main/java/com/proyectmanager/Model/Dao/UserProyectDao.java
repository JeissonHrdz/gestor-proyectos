package com.proyectmanager.Model.Dao;

import org.springframework.data.repository.CrudRepository;
import com.proyectmanager.Model.Entity.UserProyect;
import com.proyectmanager.Model.Entity.UserProyectPK;


public interface UserProyectDao extends CrudRepository<UserProyect, UserProyectPK> {    

   /*  @Query("INSERT INTO user_proyect s (s.id_user,s.id_proyect) values (:idUser, :idProyect)")
    void save(Integer idUser, Integer idProyect); */
}
