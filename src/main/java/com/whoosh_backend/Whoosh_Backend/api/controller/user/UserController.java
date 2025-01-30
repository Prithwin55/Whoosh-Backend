package com.whoosh_backend.Whoosh_Backend.api.controller.user;

import com.whoosh_backend.Whoosh_Backend.api.dto.user.UserDto;
import com.whoosh_backend.Whoosh_Backend.data.entity.user.User;
import com.whoosh_backend.Whoosh_Backend.data.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    UserService userService;



    @PostMapping("/register")
    public UserDto registerUser(@RequestBody UserDto user){
        return userService.registerUser(user);
    }

}
