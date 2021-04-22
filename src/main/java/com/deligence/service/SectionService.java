package com.deligence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deligence.models.Question;
import com.deligence.models.Section;
import com.deligence.repository.QuestionRepository;
import com.deligence.repository.SectionRepository;

@Service
public class SectionService {

	@Autowired
	SectionRepository sectionRepository;

	@Autowired
	QuestionRepository questionRepository;

	@Autowired
	GroupAnswerService groupService;

	public List<Question> getSectionQuestions(long sectionId) {

		List<Question> questions = questionRepository.findQuestionBySectionId(sectionId);
		questions.forEach(e -> e.setAnswer(groupService.getAnswerGroupById(e.getGroupId())));
		return questions;
	}

	public List<Section> getSections() {
		List<Section> section = sectionRepository.findAll();
		section.forEach(e -> e.setQuestions(getSectionQuestions(e.getId())));
		return section;

	}

	public Section getSection(long id) {
		Section section = sectionRepository.findById(id).get();
		section.setQuestions(getSectionQuestions(id));
		return section;

	}

}
