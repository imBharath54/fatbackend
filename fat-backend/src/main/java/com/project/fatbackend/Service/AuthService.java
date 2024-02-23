package com.project.fatbackend.Service;

import com.project.fatbackend.Dto.LoginDto;

public interface AuthService {
    boolean isValid(LoginDto loginDTO);
}