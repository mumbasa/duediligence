package com.deligence.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.deligence.configuration.Solution;
import com.deligence.models.Answers;
import com.deligence.models.GroupAnswer;
import com.deligence.models.Question;
import com.deligence.repository.AnswerGroupRepository;
import com.deligence.repository.AnswersRepository;
import com.deligence.repository.QuestionRepository;

@Service
public class GroupAnswerService {

	@Autowired
	AnswerGroupRepository answerGroupRepository;

	@Autowired
	AnswersRepository answersRepository;

	@Autowired
	QuestionRepository questionRepository;

	@Autowired
	JdbcTemplate template;

	public GroupAnswer createAnswerGroup(GroupAnswer answer) {
		return answerGroupRepository.save(answer);
	}

	public Question saveQuestion(Question question) {
		return questionRepository.save(question);
	}

	public GroupAnswer getAnswerGroupById(long id) {
		GroupAnswer group = answerGroupRepository.findGroupAnswerById(id);
		group.setAnswers(answersRepository.findAnswersByGroupId(id));
		return group;
	}

	public Question getQuestionyId(long id) {
		Optional<Question> question = questionRepository.findById(id);
		question.get().setAnswer(getAnswerGroupById(question.get().getGroupId()));

		return question.get();
	}

	public List<GroupAnswer> getGroupAnswers() {
		List<GroupAnswer> groupAnswers = answerGroupRepository.findAll();
		groupAnswers.forEach(e -> e.setAnswers(answersRepository.findAnswersByGroupId(e.getId())));
		return groupAnswers;

	}

	public Answers createAnswer(Answers answer) {
		return answersRepository.save(answer);
	}

	public double scoringSystem(List<Solution> answers, long testId) {

		Map<Long, Double> markingScheme = new HashMap<Long, Double>();
		for (GroupAnswer answer : getGroupAnswers()) {
			answer.getAnswers().forEach(e -> markingScheme.put(e.getId(), e.getScore()));
			;
		}

		for (int i = 0; i < answers.size(); i++) {
			Solution answer = answers.get(i);
			if (answer.getAnswerId() < 1) {
				if (answer.getAnswer().length() > 3) {

					answers.get(i).setScore(1);
				}
			} else {
				answers.get(i).setScore(markingScheme.get(answers.get(i).getAnswerId()));

			}
		}
		String sql = "INSERT INTO `due_diligence`.`test_question_answers` (`question_id`, `answer`, `score`, `date_scored`, `test_id`, `answer_id`) VALUES (?,?,?,now(),?,?)";
		template.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				// TODO Auto-generated method stub
				Solution s = answers.get(i);
				ps.setLong(1, s.getQuestionId());
				ps.setString(2, s.getAnswer());
				ps.setDouble(3, s.getScore());
				ps.setLong(4, testId);
				ps.setLong(5, s.getAnswerId());

			}

			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return answers.size();
			}
		});

		return answers.stream().collect(Collectors.summingDouble(e ->e.getScore())).doubleValue();
	}

}
