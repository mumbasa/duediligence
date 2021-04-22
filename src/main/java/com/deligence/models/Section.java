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
@Table(name = "sections")
@Setter
@Getter
public class Section implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long id;
	private String section;
	@Column(name = "date_added")
	private Date dateAdded;
	@Transient
	private List<Question> questions;
}
