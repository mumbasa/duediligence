package com.deligence.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "business_background")
@Setter
@Getter
public class Business implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String address;
	
	@Column(name = "yoe")
	private String establishmentDate;
	
	@Column(name = "is_ghanaian")
	private boolean whollyeGhanaian;
	
	@Column(name = "is_foreign")
	private boolean whollyForeign;
	
	@Column(name = "is_ghana_foreign")
	private boolean ghanaianForegn;
	
	@Column(name = "foreign_portion")
	private double  foreignPortion;
	
	@Column(name = "core_business")
	private String  coreBusiness;
	
	private int  staff;
	
	private double transaction;

	@Column(name = "transaction_unit")
	private String transactionUnit;
	
	@OneToOne
	private User user;
	
	public Business() {
		// TODO Auto-generated constructor stub
	}
	
	
	

}
