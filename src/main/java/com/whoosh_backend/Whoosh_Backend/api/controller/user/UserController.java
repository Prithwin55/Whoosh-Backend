package com.whoosh_backend.Whoosh_Backend.api.controller.user;

import com.whoosh_backend.Whoosh_Backend.api.dto.user.UserDto;
import com.whoosh_backend.Whoosh_Backend.data.entity.user.User;
import com.whoosh_backend.Whoosh_Backend.data.exception.ResourceNotFoundException;
import com.whoosh_backend.Whoosh_Backend.data.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable int id, @RequestBody UserDto user) throws ResourceNotFoundException {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
