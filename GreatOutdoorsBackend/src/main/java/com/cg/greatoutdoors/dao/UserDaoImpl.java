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
	
/*********************************************************************************************************
     *Method:                  - create 
     *description:             - create a new user in database               - 
     *@returns                 - void
     *@throws                  - 
     *created by               - Vainktesh Prasad Jangid
     *created date             - 26/4/2020
**********************************************************************************************************/
	@Override
	public void create(UserDTO user) {
		em.persist(user);
	}
	
/*********************************************************************************************************
     *Method:                  - isUsernameAvailable
     *description:             - checks if username is already registered or not              - 
     *@returns                 - true or false
     *@throws                  - 
     *created by               - Vainktesh Prasad Jangid
     *created date             - 26/4/2020
**********************************************************************************************************/
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

	
/*********************************************************************************************************
     *Method:                  - delete
     *description:             - delete user with given id from database               - 
     *@returns                 - void
     *@throws                  - 
     *created by               - Vainktesh Prasad Jangid
     *created date             - 26/4/2020
**********************************************************************************************************/
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
	
	
/*********************************************************************************************************
     *Method:                  - getUserByUsername
     *description:             - fetch user with given username from database             - 
     *@returns                 - user with matching username
     *@throws                  - 
     *created by               - Vainktesh Prasad Jangid
     *created date             - 26/4/2020
**********************************************************************************************************/
	@Override
	public UserDTO getUserByUsername(String username) throws NoResultException{
		String str="Select user FROM UserDTO user WHERE user.username=:username";
		TypedQuery<UserDTO> query=em.createQuery(str,UserDTO.class);
		query.setParameter("username", username);
		return query.getSingleResult();
	}

	
/*********************************************************************************************************
     *Method:                  - reterive
     *description:             - fetch all users from database             - 
     *@returns                 - List of all users
     *@throws                  - 
     *created by               - Vainktesh Prasad Jangid
     *created date             - 26/4/2020
**********************************************************************************************************/
	@Override
	public List<UserDTO> reterive() {
		// TODO Auto-generated method stub
		String str="SELECT user FROM UserDTO user";
		TypedQuery<UserDTO> query=em.createQuery(str,UserDTO.class);
		return query.getResultList();
	}

	
/*********************************************************************************************************
     *Method:                  - getUserById
     *description:             - fetch user with given id from database              - 
     *@returns                 - User with matching userId
     *@throws                  - 
     *created by               - Vainktesh Prasad Jangid
     *created date             - 26/4/2020
**********************************************************************************************************/
	@Override
	public UserDTO getUserById(Long id) {
		UserDTO user = em.find(UserDTO.class, id);
		return user;
	}
	
	

}
