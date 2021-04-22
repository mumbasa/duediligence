package com.deligence.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "questions")
public class Question implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	
	private String question;
	
	@Column(name = "answer_group_id")
	private long groupId;
	
	@Transient
	private GroupAnswer answer;
	
	@Transient
	private Question parent;
	
	private boolean scoring;
	
	private int iteration;
	
	@Column(name="date_added")
	private Date dateAdded;
	
	@Column(name="section_id")
	private long sectionId;
}
