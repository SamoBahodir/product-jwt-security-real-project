package com.productexseption.model.user;

import com.productexseption.model.role.Role;
import lombok.Data;

import java.util.Collection;

@Data
public class UserResponse {
    private Long id;
    private String username;
    private String password;
    private String email;
    private Collection<Role> roles;

    public UserResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.roles = user.getRoles();
    }
}
