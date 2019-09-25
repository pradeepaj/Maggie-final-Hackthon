package com.ing.service;

import org.springframework.stereotype.Service;

import com.ing.dto.FavouriteDto;

@Service
public interface FavouriteService {

	public FavouriteDto getFavourites(String customerId, Integer perPage, Integer pageNumber);

}