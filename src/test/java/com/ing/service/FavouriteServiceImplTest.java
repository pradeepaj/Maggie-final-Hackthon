package com.ing.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.ing.dto.FavouriteDto;
import com.ing.dto.FavouriteResponseDto;
import com.ing.entity.Account;
import com.ing.repository.AccountRepository;

@RunWith(MockitoJUnitRunner.class)
public class FavouriteServiceImplTest {
	@Mock
	AccountRepository accountsRepository;
	@InjectMocks
	FavouriteServiceImpl favouriteService;
	@Test
	public void testGetFavourites() {
		int pageNumber=1;
		int perPage=5;
		String customerId="ING2651";
		Pageable paging = PageRequest.of(pageNumber, perPage);
		String status="ACTIVE";
		Account account=new Account();
		account.setAccountName("sai");
		account.setBankName("sbi");
		account.setAccountStatus("ACTIVE");
		List<Account> accounts=new ArrayList<>();
		accounts.add(account);
		FavouriteDto fav=new FavouriteDto();
		
		FavouriteResponseDto dt=new FavouriteResponseDto();
		List<FavouriteResponseDto> dt1=new ArrayList<>();
		dt.setAccountName("sbi");
		dt.setBankName("sboi");
	dt1.add(dt);
	fav.setData(dt1);
		Mockito.when(accountsRepository.findByAccountStatus(paging,customerId,status)).thenReturn(accounts);
		FavouriteDto dt3=favouriteService.getFavourites(customerId, perPage, pageNumber);
		assertEquals(dt3.getClass(),fav.getClass());
		
	}

}