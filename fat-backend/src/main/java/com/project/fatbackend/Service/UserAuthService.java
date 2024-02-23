package com.project.fatbackend.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fatbackend.Dto.LoginDto;
import com.project.fatbackend.Entity.User;
import com.project.fatbackend.Repository.UserRepository;


@Service("UserAuthService")
public class UserAuthService implements AuthService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public boolean isValid(LoginDto loginDTO) {
        User user = userRepository.findByemail(loginDTO.getEmail());

        if(user.getPassword().equals(loginDTO.getPassword())) {
        	return true;
        }
        return false;
    }

}