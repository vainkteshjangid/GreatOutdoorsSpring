package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.greatoutdoors.entity.AddressDTO;

@Repository
public interface AddressRepository extends JpaRepository<AddressDTO,Integer>{

}
