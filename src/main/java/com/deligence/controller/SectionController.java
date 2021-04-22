package com.deligence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deligence.models.Question;
import com.deligence.models.Section;
import com.deligence.repository.SectionRepository;
import com.deligence.service.SectionService;


@RestController
@RequestMapping("/v1/api/")
public class SectionController {

	@Autowired
	SectionRepository sectionRepository;
	
	@Autowired
	SectionService sectionService;
	
	@PostMapping("/section")
	public Section addUser(@RequestBody Section section) {
		return sectionRepository.save(section);
		
		
	}
	
	@GetMapping("/sections")
	public List<Section> getSections(){
		return sectionRepository.findAll();
	}
	
	@GetMapping("/section/questions")
	public List<Question> getQuestions(@RequestParam long id){
		return sectionService.getSectionQuestions(id);
	}
	
	@GetMapping("/section/with/questions")
	public List<Section> getQuestionsWithSection(){
		return sectionService.getSections();
	}
	
	
	
	@GetMapping("/section/exists")
	public Section getSetions(@RequestParam String section){
		return sectionRepository.findSectionBySection(section);
	}
}
