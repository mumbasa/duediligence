package com.deligence.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="business_tests")
public class BusinessTestSession implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private long id;
	
	@Column( name="business_id")
	private long businessId;
	
	@Column( name="module_id")
	private long moduleId;
	
	@Column( name="date_taken")
	private Date dateTaken;
	
	@Column( name="test_score")
	private double score;
	
	@Column( name="is_complete")
	private boolean complete;
}
