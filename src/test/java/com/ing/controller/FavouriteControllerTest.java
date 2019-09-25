package com.ing.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.ing.dto.FavouriteDto;
import com.ing.dto.FavouriteResponseDto;
import com.ing.service.FavouriteService;

@RunWith(MockitoJUnitRunner.class)
public class FavouriteControllerTest {
	@Mock 
FavouriteService favouriteService;
	@InjectMocks
	FavouriteController favouriteController;
	@Test
	public void getStatementsTest()
	{
		int pageNumber=1;
		int perPage=5;
		String customerId="ING2651";
	FavouriteResponseDto dt=new FavouriteResponseDto();
	dt.setAccountName("sbi");
	List<FavouriteResponseDto> dt1=new ArrayList<>();
	dt1.add(dt);
	FavouriteDto dto=new FavouriteDto();
	dto.setData(dt1);
	
		Mockito.when(favouriteService.getFavourites(customerId, perPage, pageNumber)).thenReturn(dto);
	ResponseEntity response=favouriteController.getFavourites(customerId, perPage, pageNumber);
response.getBody();
	assertEquals(200,response.getStatusCodeValue());

}
}