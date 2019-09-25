package com.ing.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.dto.LoginReqDto;
import com.ing.dto.LoginResDto;
import com.ing.service.LoginService;

/**
 * 
 * @author Pradeep
 * @param LoginReqDto
 * @return LoginResDto
 */


@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class Logincontroller {
	private static final Logger logger = LoggerFactory.getLogger(Logincontroller.class);
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResDto> login(@RequestBody LoginReqDto reqdto){
		logger.info("Entering to login()");
		return new ResponseEntity<>(loginService.login(reqdto),HttpStatus.OK);
	}

}
