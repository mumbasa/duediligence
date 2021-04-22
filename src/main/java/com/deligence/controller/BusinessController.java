package com.deligence.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deligence.models.Business;
import com.deligence.service.BusinessService;
import com.deligence.service.UserService;

@RestController
@RequestMapping("/v1/api/")
public class BusinessController {

	@Autowired
	BusinessService businessService;
	
	@Autowired
	UserService userService;

	@PostMapping("/business")
	 public Business addBusiness(@RequestBody Business business){
		 return businessService.save(business);
		 
		 
	 }
	

	@GetMapping("/businesses/by/user")
	 public List<Business> getBusinessesUser(Principal principal){
		 return businessService.findBusinessByUser(principal);
		 
		 
	 }
	

	
	@GetMapping("/businesses")
	 public List<Business> getBusinesses(){
		 return businessService.listAll();
		 
		 
	 }
	
	@PostMapping("/business/module")
	 public int  takeTest(@RequestParam long businesssId,@RequestParam long moduleId){
		 return businessService.addModuleToBusiness(moduleId, businesssId);
		 
		 
	 }
	
	@GetMapping("/business/module")
	 public com.deligence.models.Module gestTest(@RequestParam long businesssId){
		 return businessService.getBusinessTest(businesssId);
		 
		 
	 }
	
	
	
}
