package com.deligence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deligence.models.GroupAnswer;

@Repository
public interface AnswerGroupRepository extends JpaRepository<GroupAnswer,Long> {
	GroupAnswer findGroupAnswerById(Long id);
	
	
	

}
