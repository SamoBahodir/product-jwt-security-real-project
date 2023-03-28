package com.productexseption.model.user;

import com.productexseption.model.role.Role;
import lombok.Data;

import java.util.Collection;
import java.util.Set;

@Data
public class UserPayload {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private Status status;
    private String email;
    private Set<Role> roles;
}
