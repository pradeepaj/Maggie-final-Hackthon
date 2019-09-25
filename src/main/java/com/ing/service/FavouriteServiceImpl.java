package com.ing.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ing.dto.FavouriteDto;
import com.ing.dto.FavouriteResponseDto;
import com.ing.entity.Account;
import com.ing.repository.AccountRepository;

@Service
public class FavouriteServiceImpl implements FavouriteService {
	@Autowired
	AccountRepository accountsRepository;

	@Override

	public FavouriteDto getFavourites(String customerId, Integer perPage, Integer pageNumber) {
		Pageable paging = PageRequest.of(pageNumber, perPage);
		String status = "ACTIVE";
		
		List<Account> account1 = accountsRepository.findByAccountStatus(customerId, status);
		Integer count=account1.size();
		List<Account> accounts = accountsRepository.findByAccountStatus(paging, customerId, status);
		
		List<FavouriteResponseDto> dto = new ArrayList<>();
		FavouriteDto dt = new FavouriteDto();

		for (Account account : accounts) {

			FavouriteResponseDto data = new FavouriteResponseDto();

			data.setAccountName(account.getAccountName());
			data.setBankName(account.getBankName());
			data.setIBANNumber(account.getAccountNumber());
			data.setDate(account.getCreatedOn());

			dto.add(data);

		}
		dt.setData(dto);
		dt.setCount(count);
		return dt;

	}

}
