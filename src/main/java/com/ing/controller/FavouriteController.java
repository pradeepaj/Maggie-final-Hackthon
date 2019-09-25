package com.ing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.service.FavouriteService;

@RestController
@RequestMapping("/api")

@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class FavouriteController {
	@Autowired
	FavouriteService favouriteService;
	@GetMapping("{customerId}/favourite/{perPage}/{pageNumber}")
public ResponseEntity getFavourites(@PathVariable String customerId,@PathVariable Integer perPage,@PathVariable Integer pageNumber) {
		return new ResponseEntity<>(favouriteService.getFavourites(customerId,perPage,pageNumber),HttpStatus.OK);
		
	}
}
