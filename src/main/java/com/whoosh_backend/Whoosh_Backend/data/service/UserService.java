package com.whoosh_backend.Whoosh_Backend.data.service;

import com.whoosh_backend.Whoosh_Backend.api.dto.user.UserDto;
import com.whoosh_backend.Whoosh_Backend.data.entity.user.User;
import com.whoosh_backend.Whoosh_Backend.data.exception.ResourceAlreadyExistException;
import com.whoosh_backend.Whoosh_Backend.data.exception.ResourceNotFoundException;

import java.util.List;

public interface UserService {

    UserDto registerUser(UserDto user) throws ResourceAlreadyExistException;
    UserDto getUserById(int id) throws ResourceNotFoundException;
    List<UserDto> getAllUsers();
    UserDto updateUser(int id, UserDto user) throws ResourceNotFoundException;
    String deleteUser(int id) throws ResourceNotFoundException;
}
