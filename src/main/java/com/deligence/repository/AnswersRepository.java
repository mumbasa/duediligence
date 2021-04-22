package com.deligence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deligence.models.Answers;

@Repository
public interface AnswersRepository extends JpaRepository<Answers,Long> {
	List<Answers> findAnswersByGroupId(long id);

}
