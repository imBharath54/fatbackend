package com.project.fatbackend.Service;

import com.project.fatbackend.Entity.User;

public interface UserService {

    void addUser(User user);
    User getUserByEmail(String email);
}
