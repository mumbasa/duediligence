package com.deligence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deligence.models.Question;

@Repository
public interface  QuestionRepository  extends JpaRepository<Question, Long>{
	List<Question> findQuestionBySectionId(long id);


}
