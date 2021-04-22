package com.deligence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deligence.models.Section;

public interface SectionRepository extends JpaRepository<Section, Long> {
	Section findSectionBySection(String section);
	

}
