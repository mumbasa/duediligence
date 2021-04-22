package com.deligence.models;

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
@Getter
@Setter
@Table(name="indexes")
public class Index {
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	@Column(name="date_added")
	private Date dateAdded;
	
	@Transient
	private List<Module> modules;

}
