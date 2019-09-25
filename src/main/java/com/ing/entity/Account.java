package com.ing.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "favourite_account")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String accountNumber;
	private String accountName;
	private String accountStatus;
	private String bankName;
	private LocalDate createdOn;
	private String customerId;

}
