package com.ing.dto;


import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestAddAccountDto {
	
	private String accountName;
	private String IBANNumber;
	private String bankName;
	private String accountId;
	private LocalDate createdOn;

}
