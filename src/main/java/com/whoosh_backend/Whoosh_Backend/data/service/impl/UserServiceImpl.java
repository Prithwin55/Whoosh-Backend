package com.whoosh_backend.Whoosh_Backend.data.service.impl;

import com.whoosh_backend.Whoosh_Backend.api.dto.user.UserDto;
import com.whoosh_backend.Whoosh_Backend.api.mapper.UserMapper;
import com.whoosh_backend.Whoosh_Backend.data.entity.user.User;
import com.whoosh_backend.Whoosh_Backend.data.exception.ResourceAlreadyExistException;
import com.whoosh_backend.Whoosh_Backend.data.exception.ResourceNotFoundException;
import com.whoosh_backend.Whoosh_Backend.data.repository.UserRepository;
import com.whoosh_backend.Whoosh_Backend.data.service.UserService;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public UserDto registerUser(UserDto user) throws ResourceAlreadyExistException {

            if(userRepository.findByUsername(user.getUsername())!=null){
                throw new ResourceAlreadyExistException("Username already exists");
            }
            if(userRepository.findByEmail(user.getEmail())!=null){
                throw new ResourceAlreadyExistException("Email already exists");
            }
            user.setPassword(encoder.encode(user.getPassword()));

            User savedUser=userRepository.save(UserMapper.INSTANCE.toEntity(user));

            return UserMapper.INSTANCE.toDto(savedUser);

    }
    @Override
    public UserDto getUserById(int id) throws ResourceNotFoundException {
        return userRepository.findById(id)
                .map(UserMapper.INSTANCE::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
            public UserDto updateUser(int id, UserDto user) throws ResourceNotFoundException {
                return userRepository.findById(id).map(existingUser -> {
                    if (user.getUsername() != null) {
                        existingUser.setUsername(user.getUsername());
                    }
                    if (user.getEmail() != null) {
                        existingUser.setEmail(user.getEmail());
                    }
                    if (user.getPassword() != null) {
                        existingUser.setPassword(encoder.encode(user.getPassword()));
                    }
                    if(user.getAddress() != null) {
                        existingUser.setAddress(user.getAddress());
                    }
                    User updatedUser = userRepository.save(existingUser);
                    return UserMapper.INSTANCE.toDto(updatedUser);
                }).orElseThrow(() -> new ResourceNotFoundException("User not found"));
            }

    @Override
    public String deleteUser(int id) throws ResourceNotFoundException {
        //check if user exists
        if(!userRepository.existsById(id)){
            throw new ResourceNotFoundException("User not found");
        }
        userRepository.deleteById(id);
        return "User deleted";
    }
}
