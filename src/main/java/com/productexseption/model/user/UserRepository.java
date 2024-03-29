package com.productexseption.model.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    @Query("select  u from User u where u.username=:username")
    User findByLogin(String username);
    boolean existsByUsername(@Param("username") String username);

    User findByCode(String code);
}
