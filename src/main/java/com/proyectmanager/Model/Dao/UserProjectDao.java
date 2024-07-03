package com.proyectmanager.Model.Dao;

import org.springframework.data.repository.CrudRepository;
import com.proyectmanager.Model.Entity.UserProject;
import com.proyectmanager.Model.Entity.UserProjectPK;


public interface UserProjectDao extends CrudRepository<UserProject, UserProjectPK> {

   /*  @Query("INSERT INTO user_proyect s (s.id_user,s.id_proyect) values (:idUser, :idProyect)")
    void save(Integer idUser, Integer idProyect); */
}
