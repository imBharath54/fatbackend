package com.project.fatbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.fatbackend.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByemail(String email);


}
