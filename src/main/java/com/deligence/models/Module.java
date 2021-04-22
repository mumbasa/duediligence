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
@Table(name="modules")
@Setter
@Getter
public class Module  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;

	private String module;
	
	@Column(name="date_created")
	private Date dateAdded;
	
	@Column(name="index_id")
	private long indexId;
	
	
	@Transient
	private List<Section> sections;
}
