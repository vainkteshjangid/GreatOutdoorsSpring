package com.cg;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.greatoutdoors.entity.AddressDTO;
import com.cg.greatoutdoors.entity.CartDTO;
import com.cg.greatoutdoors.entity.ProductDTO;
import com.cg.greatoutdoors.entity.UserDTO;
import com.cg.greatoutdoors.service.IUserService;
import com.cg.greatoutdoors.service.UserServiceImpl;
import com.cg.repository.AddressRepository;
import com.cg.repository.UserRepository;
@Transactional
@SpringBootApplication
public class GreatOutdoorsBackendApplication{
	@PersistenceContext
	EntityManager em;
	
	public static void main(String[] args) {
		SpringApplication.run(GreatOutdoorsBackendApplication.class, args);
		
	}

}
