package com.ing.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.dto.AccountDeleteDto;
import com.ing.dto.RequestAddAccountDto;
import com.ing.dto.ResponseAddedDto;
import com.ing.service.AccountService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class AccountController {

	/**
	 *Delete Controller
	 *@author Sharath 
	 **/
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	
	@Autowired
	AccountService accountService;
	
	
	@PutMapping("/accounts")
	public ResponseEntity<ResponseAddedDto> addAccount(@RequestBody RequestAddAccountDto requestDto)
	{
		return new ResponseEntity<>(accountService.addAccount(requestDto),HttpStatus.OK);
	}
	
	@DeleteMapping("/accounts/{customerId}/{ibannumber}")
	public ResponseEntity<AccountDeleteDto> deleteAccount(@PathVariable String customerId, @PathVariable String ibannumber)
	{
		logger.info("delete controller");
		return new ResponseEntity<>(accountService.deleteAccount(customerId,ibannumber),HttpStatus.OK);
	}
	
}