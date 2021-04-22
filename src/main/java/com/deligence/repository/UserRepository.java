package com.deligence.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deligence.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findUserByEmail(String email);
	List<User> findUsersByDateAdded(Date dateAdded);
	
	

}
