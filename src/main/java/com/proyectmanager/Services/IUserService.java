package com.proyectmanager.Services;



import com.proyectmanager.Model.Dto.UserDto;
import com.proyectmanager.Model.Entity.User;

public interface IUserService {    

    User save(UserDto user);
    User findById(Integer id);
    boolean existsById(Integer id);

}
