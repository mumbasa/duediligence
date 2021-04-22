package com.deligence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deligence.models.Answers;
import com.deligence.models.GroupAnswer;
import com.deligence.models.Question;
import com.deligence.service.GroupAnswerService;


@RestController
@RequestMapping("/v1/api/")
public class QuestionController {
	
	@Autowired
	GroupAnswerService groupAnswerService;

	@PostMapping("/answer/group")
	public GroupAnswer createAnswerGroup(@RequestBody GroupAnswer answerGroup) {
		return groupAnswerService.createAnswerGroup(answerGroup);
		
	}
	
	@GetMapping("/answer/groups")
	public List<GroupAnswer> getAnswerGroups() {
		return groupAnswerService.getGroupAnswers();
		
	}
	
	
	
	@PostMapping("/question")
	public Question createQuestion(@RequestBody Question question) {
		return groupAnswerService.saveQuestion(question);
		
	}
	
	@PostMapping("/answer/group/answer")
	public Answers createAnswerGroup(@RequestBody Answers answer) {
		return groupAnswerService.createAnswer(answer);
		
	}
	@GetMapping("/answer/group")
	public GroupAnswer getAnswerGroup(@RequestParam long id) {
		return groupAnswerService.getAnswerGroupById(id);
		
	}
	
	@GetMapping("/question")
	public Question getQuestion(@RequestParam long id) {
		return groupAnswerService.getQuestionyId(id);
		
	}
	

}