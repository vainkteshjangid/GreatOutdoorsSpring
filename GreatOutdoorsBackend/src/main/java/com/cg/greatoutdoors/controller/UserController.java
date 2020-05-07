package com.cg.greatoutdoors.controller;

import java.util.List;

import javax.persistence.NoResultException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.greatoutdoors.entity.UserDTO;
import com.cg.greatoutdoors.exception.RecordNotFoundException;
import com.cg.greatoutdoors.exception.UsernameAlreadyTakenException;
import com.cg.greatoutdoors.exception.WrongPasswordException;
import com.cg.greatoutdoors.service.IUserService;
import com.cg.greatoutdoors.service.UserServiceImpl;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserController {
	@Autowired
	IUserService userService;
	
	@PostMapping(value="user/newUser",consumes="application/json")
	public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO user) {
		try {
			UserDTO u=userService.getUserByUsername(user.getUsername());
			throw new UsernameAlreadyTakenException("username already registered. Please try with another username");
		}catch(NoResultException e) {
			userService.create(user);
		} catch (UsernameAlreadyTakenException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<UserDTO>(user,HttpStatus.OK);
	}
	
	
	@DeleteMapping(value="user/deleteUser/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") @RequestParam Long userId) {
		userService.delete(userId);
		return new ResponseEntity<String>("User deleted successfully!",HttpStatus.OK);
	}
	
	
	@GetMapping(value="user/{userId}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable("userId") @RequestParam Long userId){
		UserDTO user=userService.getUserById(userId);
		
		if(user==null) {
			throw new RecordNotFoundException("Invalid user id : "+userId);
		}
		return new ResponseEntity<UserDTO>(user,HttpStatus.OK);
	}
	
	
	@GetMapping(value="user/{username}")
	public ResponseEntity<UserDTO> getUserByUsername(@PathVariable("username") @RequestParam String username){
		
		UserDTO user;
		try {
			user=userService.getUserByUsername(username);
		}
		catch(NoResultException e) {
			throw new RecordNotFoundException("Invalid username : "+username);
		}
		
		return new ResponseEntity<UserDTO>(user,HttpStatus.OK);
	}
	
	
	@GetMapping(value="user/login")
	public ResponseEntity<?> loginUser(@RequestParam String username,@RequestParam String password) {
		UserDTO user;
		try {
			user=userService.getUserByUsername(username);
		}catch(NoResultException e) {
			//throw new RecordNotFoundException("Incorrect username");
			return new ResponseEntity<>(new RecordNotFoundException("Incorrect username"),HttpStatus.BAD_REQUEST);
		}
		
		if(!password.equals(user.getPassword())) {
			throw new WrongPasswordException("Incorrect password");
		}
		return new ResponseEntity<UserDTO>(user,HttpStatus.OK);
	}
	
	
	@GetMapping(value="user/viewAll",produces="application/json")
	public List<UserDTO> viewAll(){
		return userService.reterive();
	}
	
	
	
	@PutMapping(value="user/logout")
	public String logoutUser() {
		userService.logout();
		return "Logged out";
	}
	
	
	@PutMapping(value="user/updatePassword")
	public String changePassword(@RequestBody UserDTO user) {
		userService.changePassword(user);
		return "Password changed";
	}
	
	
	
	
	
}
