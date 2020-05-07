package com.cg.greatoutdoors.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.greatoutdoors.entity.UserDTO;
@Service
public interface IUserService {
	
	public void create(UserDTO user);
	
	public UserDTO getUserByUsername(String username);
	
	public boolean logout();

	public void changePassword(UserDTO user);
	
	public List<UserDTO> reterive();

	public UserDTO getUserById(Long id);

	void delete(Long userId);
	
	boolean isUsernameAvailable(String username);
	
}
