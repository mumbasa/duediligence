package com.deligence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deligence.models.Business;
import com.deligence.models.User;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {
	List<Business> findBusinessesByUser(User user);
	
	
	
	
	

}
