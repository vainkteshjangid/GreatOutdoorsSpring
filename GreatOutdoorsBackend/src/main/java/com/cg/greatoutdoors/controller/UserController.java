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
	
/*********************************************************************************************************
     *Method:                  - createUser
     *description:             - handle httpRequest for creating new user in database               - 
     *@returns                 - ResponseEntity
     *@throws                  - 
     *created by               - Vainktesh Prasad Jangid
     *created date             - 26/4/2020
**********************************************************************************************************/
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
	
	
/*********************************************************************************************************
     *Method:                  - deleteUser
     *description:             - handle httpRequest for deleting user by userId from database              - 
     *@returns                 - ResponseEntity
     *@throws                  - 
     *created by               - Vainktesh Prasad Jangid
     *created date             - 26/4/2020
**********************************************************************************************************/
	@DeleteMapping(value="user/deleteUser/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") @RequestParam Long userId) {
		userService.delete(userId);
		return new ResponseEntity<String>("User deleted successfully!",HttpStatus.OK);
	}
	
	
/*********************************************************************************************************
     *Method:                  - getUserById
     *description:             - handle httpRequest for fetching user data from database with given userId              - 
     *@returns                 - user with matched id
     *@throws  RecordNotFoundException - thrown if user is not found in the db
     *created by               - Vainktesh Prasad Jangid
     *created date             - 26/4/2020
**********************************************************************************************************/
	@GetMapping(value="user/{userId}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable("userId") @RequestParam Long userId){
		UserDTO user=userService.getUserById(userId);
		
		if(user==null) {
			throw new RecordNotFoundException("Invalid user id : "+userId);
		}
		return new ResponseEntity<UserDTO>(user,HttpStatus.OK);
	}
	
	
/*********************************************************************************************************
     *Method:                  - getUserByUsername
     *description:             - handle httpRequest to fetch user of given username from db            - 
     *@returns                 - user with matched username
     *@throws                  - 
     *created by               - Vainktesh Prasad Jangid
     *created date             - 26/4/2020
**********************************************************************************************************/
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
	
	
/*********************************************************************************************************
     *Method:                  - loginUser
     *description:             - handle httpRequest for login and checks verify username and password             - 
     *@returns                 - user data matching given credentials
     *@throws                  - RecordNotFoundException and WrongPasswordException
     *created by               - Vainktesh Prasad Jangid
     *created date             - 26/4/2020
**********************************************************************************************************/
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
	
	
/*********************************************************************************************************
     *Method:                  - viewAll
     *description:             - handle httpRequest for fetching all user from the db              - 
     *@returns                 - List of all users
     *@throws                  - 
     *created by               - Vainktesh Prasad Jangid
     *created date             - 26/4/2020
**********************************************************************************************************/
	@GetMapping(value="user/viewAll",produces="application/json")
	public List<UserDTO> viewAll(){
		return userService.reterive();
	}
	
	
}
