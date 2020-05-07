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
public class GreatOutdoorsBackendApplication implements CommandLineRunner{
	@PersistenceContext
	EntityManager em;
	
	public static void main(String[] args) {
		SpringApplication.run(GreatOutdoorsBackendApplication.class, args);
		
	}
	@Override
	public void run(String... args) throws Exception {
//		// ***************************************************************************
	
		UserDTO u1=new UserDTO("system","system","Retailer","8745962315","abc@gmail.com");
		em.persist(u1);
//		
		AddressDTO a1=new AddressDTO(101L,"15","Jaipur","Rajasthan","Udai mod","144411",u1);
		AddressDTO a2=new AddressDTO(102L,"45","Jalandhar","Punjab","Phagwara","451236",u1);
		em.persist(a1);
		em.persist(a2);
//		
//		//********************************************************************************
		UserDTO u2=new UserDTO("hacker","hacker","Product master","5874621345","xyz@gmail.com");
		em.persist(u2);
//	
//		
		AddressDTO a3=new AddressDTO(034L,"53","Ajmer","Rajasthan","Sugar mill area","456123",u2);
		em.persist(a3);
		
		CartDTO c1=new CartDTO(123L,78965L,5);
		CartDTO c2=new CartDTO(456L,45123L,2);
		CartDTO c3=new CartDTO(789L,98213L,9);
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		
		
		//ProductDTO(String productName,double price, String colour,int productCategory, String dimension, String specification, String manufacturer,int quantity)
//		
		ProductDTO p1=new ProductDTO("Firefox bikes Dart 26T Speed Mountain cycle",10649.99,"Blue/White",1,"NA","Speed mountain cycle","Firefox Bikes",100);
		ProductDTO p2=new ProductDTO("Quantico Inline skates with PU Flashing Wheel",2299.00,"Black/Orange",2,"size: 6-10","PU Flashing wheel","Frank roder",142);
		em.persist(p1);
		em.persist(p2);
//		
	}
	

}
