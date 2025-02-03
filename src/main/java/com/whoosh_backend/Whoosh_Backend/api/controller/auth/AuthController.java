package com.whoosh_backend.Whoosh_Backend.api.controller.auth;

import com.whoosh_backend.Whoosh_Backend.api.dto.user.UserDto;
import com.whoosh_backend.Whoosh_Backend.data.exception.ResourceAlreadyExistException;
import com.whoosh_backend.Whoosh_Backend.data.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public UserDto registerUser(@Valid @RequestBody UserDto user) throws ResourceAlreadyExistException {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDto user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "Login successfull";
    }

    @PostMapping("/logout")
    public void logout() {
        SecurityContextHolder.clearContext();
    }
}