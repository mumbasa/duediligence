package com.deligence.service;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.deligence.models.Business;
import com.deligence.repository.BusinessRepository;

@Service
public class BusinessService {
	
	@Autowired
	BusinessRepository businessRepository;
	
	@Autowired
	ModuleService moduleService;
	@Autowired
	UserService userRepository;
	
	@Autowired
	JdbcTemplate template;

	
	public List<Business> listAll() {
        return businessRepository.findAll();
    }
	
	public List<Business> findBusinessByUser(Principal principal) {
        return businessRepository.findBusinessesByUser(userRepository.findUserByEmail(principal.getName()));
    }
     
    public Business save(Business user) {
    	return businessRepository.save(user);
    }
     
    public Business get(long id) {
        return businessRepository.findById(id).get();
    }
     
    public int addModuleToBusiness(long moduleId,long businessId) {
		String sql ="INSERT INTO business_tests(module_id,business_id) VALUES(?,?,now()) ";
		return template.update(sql,moduleId,businessId);
	}
    
    public com.deligence.models.Module getBusinessTest(long businessId) {
    	String sql ="SELECT module_id from business_tests where business_id=?";
    	long id =template.queryForObject(sql,Long.class, businessId);
    	    	
    	return moduleService.getModule(id);
		
	}
}
