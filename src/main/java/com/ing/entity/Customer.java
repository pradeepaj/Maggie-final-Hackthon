package com.ing.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String customerId;
	private String customerName;
	private String phoneNumber;
	private String email;
	private String password;
	
	
	
	

}
