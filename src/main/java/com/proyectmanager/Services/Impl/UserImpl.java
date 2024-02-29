package com.proyectmanager.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.proyectmanager.Model.Dao.UserDao;
import com.proyectmanager.Model.Dto.UserDto;
import com.proyectmanager.Model.Entity.User;
import com.proyectmanager.Services.IUserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserImpl implements IUserService {

    @Autowired
    private  UserDao userDao; 
    
    private final PasswordEncoder passwordEncoder;

   
    @SuppressWarnings("null")
    @Override
    public User save(UserDto userDto) {
        User user = User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .phone(userDto.getPhone())
                .dateRegister(userDto.getDateRegister())
                .idRol(userDto.getIdRol())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .build();
        return userDao.save(user);
    }

    @SuppressWarnings("null")
    @Override
    public User findById(Integer id) {
        return userDao.findById(id).orElse(null);
    }

    @SuppressWarnings("null")
    @Override
    public boolean existsById(Integer id) {
        return userDao.existsById(id);

    }

}
