package com.ing.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddFavReqDto {
	private String accountNumber;
	private String accountName;
	private String bankName;
	private String customerId;

}
