package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.greatoutdoors.entity.UserDTO;

@Repository
public interface UserRepository extends JpaRepository<UserDTO,Integer>{

}
