package com.ing.service;

import org.springframework.stereotype.Service;

import com.ing.dto.AccountDeleteDto;
import com.ing.dto.RequestAddAccountDto;
import com.ing.dto.ResponseAddedDto;

@Service
public interface AccountService {

	public AccountDeleteDto deleteAccount(String customerId,String ibannumber);
	
	public ResponseAddedDto addAccount(RequestAddAccountDto requestAccount);
	
}
