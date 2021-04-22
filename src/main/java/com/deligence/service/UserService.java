package com.deligence.service;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deligence.models.User;
import com.deligence.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<User> listAll() {
        return userRepository.findAll();
    }
     
    public User save(User user) {
    	return userRepository.save(user);
    }
     
    public User get(long id) {
        return userRepository.findById(id).get();
    }
     
    public void delete(long id) {
    	userRepository.deleteById(id);
    }
    
    public User findUserByEmail(String email) {
    	return userRepository.findUserByEmail(email);
    	
    }
    
    public List<User> findUserByDate(Date date) {
    	return userRepository.findUsersByDateAdded(date);
    	
    }
	
}
