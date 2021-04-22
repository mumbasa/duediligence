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

import com.deligence.models.Module;
import com.deligence.models.Section;
import com.deligence.service.ModuleService;

@RestController
@RequestMapping("/v1/api")
public class ModulesController {

	@Autowired
	ModuleService moduleService;
	
	
	@PostMapping("/module")
	public Module saveModule(@RequestBody Module module) {
		return moduleService.saveModule(module);
	}
	
	@PostMapping("/module/section")
	public int saveModuleSection(@RequestParam long sectionId,@RequestParam long moduleId) {
		return moduleService.addSectinModule(moduleId, sectionId);
	}
	@DeleteMapping("/module/section")
	public int delteModuleSection(@RequestParam long sectionId,@RequestParam long moduleId) {
		return moduleService.deleteModuleSection(moduleId, sectionId);
	}
	
	
	@GetMapping("/module/sections")
	public List<Section> getModuleSection(@RequestParam  long moduleId){
		return moduleService.getModuleSection(moduleId);
				
	}
	
	
}
