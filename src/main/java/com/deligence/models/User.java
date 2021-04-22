package com.deligence.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String email;
	private String password;

	@Column(name = "date_added")
	private Date dateAdded;
	private String mobile;
	
	@Transient 
	public String token;
	protected User() {
	}
	public User(String email,String password,String mobile) {
		this.setEmail(email);
		this.setPassword(new BCryptPasswordEncoder().encode(password));
		this.setMobile(mobile);
		this.dateAdded=new Date();
	}

	
}
