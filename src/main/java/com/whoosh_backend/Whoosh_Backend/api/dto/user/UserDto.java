package com.whoosh_backend.Whoosh_Backend.api.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private int id;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String role;
    private String address;
}