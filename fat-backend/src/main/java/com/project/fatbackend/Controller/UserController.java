package com.project.fatbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.fatbackend.Dto.UserDto;
import com.project.fatbackend.Entity.User;
import com.project.fatbackend.Service.UserService;

import jakarta.servlet.http.HttpSession;


@RestController 
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/user/{email}")
	public ResponseEntity<?> getUser(@PathVariable("email") String email,HttpSession session){
		try {
    		boolean valid = (boolean)session.getAttribute("valid");
	    	String role = (String) session.getAttribute("role");
	    	if(valid==true && role.equals("user")) {
	            User user = userService.getUserByEmail(email);
	
	            System.out.println(user);
	
	            if (user != null){
	                UserDto userDto = new  UserDto(user);
	
	                return new ResponseEntity<>(userDto, HttpStatus.OK);
	            }
	            else {return new ResponseEntity<>(new UserDto(),HttpStatus.NOT_FOUND);}
	
	    		
	    	}
    	}
	    	
	    catch (NullPointerException e) {
	    	return new ResponseEntity<>("Login first",HttpStatus.BAD_REQUEST);   
	    	
	    }
    	return new ResponseEntity<>("Login first",HttpStatus.BAD_REQUEST);   

    			
	}
	
	@PostMapping("/user")
	public ResponseEntity<?> saveUser(@RequestBody User user){
		userService.addUser(user);
		
		return new ResponseEntity<>("user saved successfully",HttpStatus.OK);
		
		
	}

}
