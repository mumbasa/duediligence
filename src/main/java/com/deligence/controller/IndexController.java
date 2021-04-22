package com.deligence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deligence.models.Index;
import com.deligence.service.ModuleService;

@RestController
@RequestMapping("/v1/api")
public class IndexController {
	@Autowired
	ModuleService moduleService;
	
	@PostMapping("/index")
	public Index saveIndex(@RequestBody Index index) {
		return moduleService.saveIndex(index);
		
	}
	
	@GetMapping("/index")
	public Index getIndex(@RequestParam long id) {
		return moduleService.getIndex(id);
	}

	
	@GetMapping("/indexes")
	public List<Index> getIndexes() {
		return moduleService.getIndexes();
	}
	
	
	@PostMapping("/index/module")
	public int addModuleToIndex(@RequestParam long indexId,@RequestParam long moduleId) {
		return moduleService.addModuleToIndex(moduleId, indexId);
		
	}
	
	@DeleteMapping("/index/module")
	public int deleteModulIndex(@RequestParam long indexId,@RequestParam long moduleId) {
		return moduleService.deleteModuleIndex(moduleId, indexId);
		
	}
	
	
	
}
