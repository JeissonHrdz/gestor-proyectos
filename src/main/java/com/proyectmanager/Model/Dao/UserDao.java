package com.proyectmanager.Model.Dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.proyectmanager.Model.Entity.User;

public interface UserDao extends CrudRepository<User, Integer> {

    Optional<User> findByEmail(String email);;
    
}
