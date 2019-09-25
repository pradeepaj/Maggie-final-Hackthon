package com.ing.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ing.dto.LoginReqDto;
import com.ing.dto.LoginResDto;
import com.ing.service.LoginService;
@RunWith(SpringJUnit4ClassRunner.class)
public class LogincontrollerTest {
	
	@Mock
	LoginService loginService; 
	
	@InjectMocks
	Logincontroller logincontroller;
	
	@Test
	public void loginTest() {
		
		LoginReqDto dto=new LoginReqDto();
		dto.setCustomerId("ING2156");
		LoginResDto res=new LoginResDto();
		res.setCustomerName("pradeep");
		res.setMessage("login successfull");
		res.setStatusCode(HttpStatus.OK.value());
		
		ResponseEntity<LoginResDto> expResult=new ResponseEntity<>(res,HttpStatus.OK);
		Mockito.when(loginService.login(dto)).thenReturn(res);
		ResponseEntity<LoginResDto> actResult=logincontroller.login(dto);
		assertEquals(expResult, actResult);
		
	}

}
