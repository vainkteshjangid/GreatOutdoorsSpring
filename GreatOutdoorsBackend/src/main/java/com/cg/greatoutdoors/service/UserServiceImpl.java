package com.cg.greatoutdoors.service;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.greatoutdoors.dao.IUserDao;
import com.cg.greatoutdoors.dao.UserDaoImpl;
import com.cg.greatoutdoors.entity.UserDTO;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	IUserDao dao;

	@Override
	public void create(UserDTO user) {
		dao.create(user);
	}
	
	@Override
	public void delete(Long userId) {
		dao.delete(userId);
	}

	@Override
	public UserDTO getUserByUsername(String username) throws NoResultException {
		return dao.getUserByUsername(username);
	}

	@Override
	public List<UserDTO> reterive() {
		// TODO Auto-generated method stub
		return dao.reterive();
	}

	@Override
	public UserDTO getUserById(Long id) {
		return dao.getUserById(id);
	}

	@Override
	public boolean isUsernameAvailable(String username) {
		return dao.isUsernameAvailable(username);
	}

	

}
