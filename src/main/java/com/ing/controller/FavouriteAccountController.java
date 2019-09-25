package com.ing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.dto.AddFavReqDto;
import com.ing.dto.AddFavResDto;
import com.ing.service.FavouriteAccountService;

/**
 * 
 * @author Pradeep
 * @param AddFavReqDto
 * @return AddFavResDto
 */


@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class FavouriteAccountController {
	
	@Autowired
	private FavouriteAccountService favouriteAccountservice;
	
	@PostMapping("accounts")
	public ResponseEntity<AddFavResDto> addFavAccount(@RequestBody AddFavReqDto favReqDto){
		return new ResponseEntity<>(favouriteAccountservice.addFavAccount(favReqDto), HttpStatus.CREATED);
	}

}
