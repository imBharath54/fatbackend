package com.project.fatbackend.Service;

import com.project.fatbackend.Entity.User;

import com.project.fatbackend.Entity.User;
import com.project.fatbackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user){
        userRepository.save(user);

    }


    public User getUserByEmail(String email){
        User user = userRepository.findByemail(email);
        

        if (user != null){
            return user;
        }
        else {
            return null;
        }
    }
}
