package com.productexseption.model.user;

import com.productexseption.core.enumeration.Status;
import com.productexseption.model.role.Role;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "user_id_seq", strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String code;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String email;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();


}
