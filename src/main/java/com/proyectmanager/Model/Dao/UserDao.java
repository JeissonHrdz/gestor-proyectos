package com.proyectmanager.Model.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.proyectmanager.Model.Entity.User;

public interface UserDao extends CrudRepository<User, Integer> {
    Optional<User> findByUsername(String username);


    @Query("SELECT s.id FROM User s WHERE s.username = :username")
    Integer findIdByUsername(String username);
}
