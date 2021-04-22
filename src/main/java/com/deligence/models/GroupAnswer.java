package com.deligence.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
@Table(name = "answer_group")
public class GroupAnswer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "group_name")
	private String groupName;

	private int iteration;

	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "groupAnswer")
	@Transient
	private List<Answers> answers;

	@Column(name = "date_added")
	private Date dateAdded;
}
