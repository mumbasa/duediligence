package com.deligence.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table
public class Answers implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private long id;
	@Column(name = "text")
	private String option;

	@JoinColumn(name = "group_id")
	private long groupId;
	
	private double score;
	
	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "group_id") private GroupAnswer groupAnswer;
	 */

}
