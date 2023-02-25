package com.productexseption.model.user;

import com.productexseption.model.role.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private Status status;
    private String email;
    private Collection<Role> roles;

    public UserResponse(User user) {
        this.id = user.getId();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.status = user.getStatus();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.roles = user.getRoles();
    }
}
