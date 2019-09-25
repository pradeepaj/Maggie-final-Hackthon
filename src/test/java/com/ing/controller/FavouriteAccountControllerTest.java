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

import com.ing.dto.AddFavReqDto;
import com.ing.dto.AddFavResDto;
import com.ing.service.FavouriteAccountService;
@RunWith(SpringJUnit4ClassRunner.class)
public class FavouriteAccountControllerTest {
	
	@Mock
	FavouriteAccountService favouriteAccountservice;
	
	@InjectMocks
	FavouriteAccountController favouriteAccountController;

	@Test
	public void addFavAccountTest() {
		
		AddFavReqDto req=new AddFavReqDto();
		req.setAccountName("Pradeep");
		req.setAccountNumber("ING0123");
		req.setBankName("ING");
		req.setCustomerId("ING9867");
		AddFavResDto res=new AddFavResDto();
		res.setMessage("Register");
		res.setStatus("SUCCESS");
		res.setStatusCode(HttpStatus.CREATED.value());
		ResponseEntity<AddFavResDto> expResult=new ResponseEntity<>(res,HttpStatus.CREATED);
		
		Mockito.when(favouriteAccountservice.addFavAccount(req)).thenReturn(res);
		ResponseEntity<AddFavResDto> actResult=favouriteAccountController.addFavAccount(req);
		assertEquals(expResult, actResult);
		
	}

}
