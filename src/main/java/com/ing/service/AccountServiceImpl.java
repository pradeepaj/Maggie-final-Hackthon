package com.ing.service;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.dto.AccountDeleteDto;
import com.ing.dto.RequestAddAccountDto;
import com.ing.dto.ResponseAddedDto;
import com.ing.entity.Account;
import com.ing.exception.AccountNameException;
import com.ing.exception.AccountNumberException;
import com.ing.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	
	/**
	 *Delete AccountServiceImpl
	 *@author Sharath 
	 **/
	
	@Autowired
	AccountRepository accountRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	public AccountDeleteDto deleteAccount(String customerId,String ibannumber) {
		
		logger.info("delete service implementation");
		String status="INACTIVE";
		//String customerId = requestDto.getCustomerId();
		//String accountNumber = requestDto.getIBANNumber();
		
		AccountDeleteDto accountDelete = new AccountDeleteDto();
		 accountRepository.update(ibannumber, customerId,status);
		 
		 accountDelete.setMessage("deleted successfully");
		 accountDelete.setStatus("SUCCESS");
		 accountDelete.setStatusCode(200);
		
		return accountDelete;
	}

	
	public ResponseAddedDto addAccount(RequestAddAccountDto requestAccount) {
		
		ResponseAddedDto response = new ResponseAddedDto();
		Account account = new Account();
		account.setAccountName(requestAccount.getAccountName());
		account.setAccountNumber(requestAccount.getIBANNumber());
		account.setAccountStatus("ACTIVE");
		account.setBankName(requestAccount.getBankName());
		account.setCustomerId(requestAccount.getAccountId());
		account.setCreatedOn(requestAccount.getCreatedOn());
		
		
		if(requestAccount.getIBANNumber().length() <= 20)
		{
			
			String regex = "^[a-zA-Z0-9'-]+$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(requestAccount.getAccountName());
			if(matcher.matches())
			{
				
				accountRepository.save(account);				
				
				if(account.getAccountName() != null)
				{
					response.setMessage("Edited successfully");
					response.setStatus("SUCCESS");
					response.setStatusCode(200);
					return response;
				}else {
					response.setMessage(" Not Edited successfully");
					response.setStatus("FAILURE");
					response.setStatusCode(404);
					return response;
				}
				
			}else
			{
				throw new AccountNameException("Name is not valid");
			}
			
		}else
		{
			throw new AccountNumberException("bank account number is more than the length");
		}
	}

}
