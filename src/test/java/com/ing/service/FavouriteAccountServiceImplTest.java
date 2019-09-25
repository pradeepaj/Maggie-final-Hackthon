package com.ing.service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ing.dto.AddFavReqDto;
import com.ing.dto.AddFavResDto;
import com.ing.entity.Account;
import com.ing.entity.Customer;
import com.ing.repository.AccountRepository;
import com.ing.repository.CustomerRepository;
import com.ing.util.MailWithOTPService;

@RunWith(SpringJUnit4ClassRunner.class)
public class FavouriteAccountServiceImplTest {

	@InjectMocks
	FavouriteAccountServiceImpl favouriteAccountServiceImpl;

	@Mock
	AccountRepository accountRepository;
	@Mock
	CustomerRepository customerRepository;
	@Mock
	MailWithOTPService mailWithOTPService;

	@Test
	public void addFavAccountTest() {

		AddFavReqDto req = new AddFavReqDto();
		req.setAccountName("Pradeep");
		req.setAccountNumber("ING0123");
		req.setBankName("ING");
		req.setCustomerId("ING9867");
		AddFavResDto res = new AddFavResDto();
		res.setMessage("Register");
		res.setStatus("SUCCESS");
		res.setStatusCode(HttpStatus.CREATED.value());
		Account account = new Account();
		Customer customer=new Customer();
		customer.setCustomerId(req.getCustomerId());
		BeanUtils.copyProperties(req, account);
		
		String body = "Account name:";
		String email ="dhanashekara123@gmail.com";
		String subject = "asdasd";

		Mockito.doNothing().when(mailWithOTPService).sendEmail(email, subject, body);
		
		Mockito.when(accountRepository.save(account)).thenReturn(account);
		Mockito.when(customerRepository.findByCustomerId(req.getCustomerId())).thenReturn(Optional.of(customer));
		AddFavResDto actResult = favouriteAccountServiceImpl.addFavAccount(req);
		assertEquals(res.getStatusCode(), actResult.getStatusCode());

	}



}
