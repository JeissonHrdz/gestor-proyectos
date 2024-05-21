package com.proyectmanager.Model.Dao;

import org.springframework.data.jpa.repository.Query;


import com.proyectmanager.Model.Entity.UserProyect;

public interface UserProyectDao {    

    @Query("INSERT INTO user_proyect ('id_user','id_proyect') values (:userProyect.getIdUser,:userProyect.getIdUser)")
    void save(UserProyect userProyect); 
}
