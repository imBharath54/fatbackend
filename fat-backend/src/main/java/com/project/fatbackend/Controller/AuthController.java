package com.project.fatbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.fatbackend.Entity.User;
import com.project.fatbackend.Dto.LoginDto;
import com.project.fatbackend.Dto.UserDto;
import com.project.fatbackend.Service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@CrossOrigin
public class AuthController {
	
	
	@Autowired
	UserService userservice; 
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDto login,HttpSession session){
		
		User user = userservice.getUserByEmail(login.getEmail());
		if (user != null) {
			session.setAttribute("valid", true);
			session.setAttribute("role", "user");
			return new ResponseEntity<>(new UserDto(user),HttpStatus.OK);		
			}
		
		
		
		return null;
		
	}
	
	@PostMapping("/logout")
	public ResponseEntity<?> logout(@RequestBody LoginDto login,HttpSession session){
		
		session.invalidate();
		return new ResponseEntity<>("logged out",HttpStatus.OK);
		
	}

}
