package com.cg.greatoutdoors.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.greatoutdoors.entity.UserDTO;

@Repository
@Transactional
public interface IUserDao{
	
	public void create(UserDTO user);
	
	public boolean logout();

	public void changePassword(UserDTO user);

	public List<UserDTO> reterive();

	public UserDTO getUserById(Long id);

	public UserDTO getUserByUsername(String username);

	void delete(Long userId);

	boolean isUsernameAvailable(String username);

}
