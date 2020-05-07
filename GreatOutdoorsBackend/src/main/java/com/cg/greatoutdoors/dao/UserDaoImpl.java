package com.cg.greatoutdoors.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.greatoutdoors.entity.UserDTO;


@Repository
@Transactional
public class UserDaoImpl implements IUserDao{
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void create(UserDTO user) {
		em.persist(user);
	}
	
	@Override 
	public boolean isUsernameAvailable(String username) {
		String str="SELECT user FROM UserDTO user WHERE user.username=:username";
		TypedQuery<UserDTO> query=em.createQuery(str,UserDTO.class);
		query.setParameter("username", username);
		try {
			UserDTO u=query.getSingleResult();
		}catch(NoResultException e) {
			return true;
		}
		return false;
	}

	@Override
	public void delete(Long userId) {
		String user_str="SELECT user FROM UserDTO user WHERE user.userId=:uid";
		TypedQuery<UserDTO> query=em.createQuery(user_str,UserDTO.class);
		query.setParameter("uid", userId);
		UserDTO user=query.getSingleResult();
		
		String address_str="DELETE FROM AddressDTO address WHERE address.user=:user";
		Query addressQuery=em.createQuery(address_str);
		addressQuery.setParameter("user", user);
		addressQuery.executeUpdate();
		
		
		em.remove(user);
	}
	
	@Override
	public UserDTO getUserByUsername(String username) throws NoResultException{
		String str="Select user FROM UserDTO user WHERE user.username=:username";
		TypedQuery<UserDTO> query=em.createQuery(str,UserDTO.class);
		query.setParameter("username", username);
		return query.getSingleResult();
	}

	@Override
	public boolean logout() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void changePassword(UserDTO user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserDTO> reterive() {
		// TODO Auto-generated method stub
		String str="SELECT user FROM UserDTO user";
		TypedQuery<UserDTO> query=em.createQuery(str,UserDTO.class);
		return query.getResultList();
	}

	@Override
	public UserDTO getUserById(Long id) {
		UserDTO user = em.find(UserDTO.class, id);
		return user;
	}
	
	

}
