package com.ing.service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ing.dto.AddFavReqDto;
import com.ing.dto.AddFavResDto;
import com.ing.entity.Account;
import com.ing.entity.Customer;
import com.ing.exception.EnterValidCredentials;
import com.ing.repository.AccountRepository;
import com.ing.repository.CustomerRepository;
import com.ing.util.MailWithOTPService;

@Service
public class FavouriteAccountServiceImpl implements FavouriteAccountService{
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private MailWithOTPService mailWithOTPService;
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public AddFavResDto addFavAccount(AddFavReqDto favReqDto) {
		
		 String regex = "^[a-zA-Z0-9'-]+$";
         Pattern pattern = Pattern.compile(regex);
         Matcher matcher = pattern.matcher(favReqDto.getAccountName());
		if(favReqDto.getAccountNumber().length() <= 20 && matcher.matches() ) {
		
		Account account =new Account();
		BeanUtils.copyProperties(favReqDto, account);
		account.setAccountStatus("ACTIVE");
		account.setCreatedOn(LocalDate.now());
		accountRepository.save(account);
		logger.info("addFavAccount()  {}", account.getCustomerId());
		AddFavResDto resDto=new AddFavResDto();
		resDto.setMessage("Account Added Successfull");
		resDto.setStatus("SUCCESS");
		resDto.setStatusCode(HttpStatus.CREATED.value());
		Optional<Customer> customer=customerRepository.findByCustomerId(favReqDto.getCustomerId());
		
		String body = "Account name:"+favReqDto.getAccountName()+"\n"+"Account number:"
		+favReqDto.getAccountNumber()+"\n"+"Bank name:"+favReqDto.getBankName();
		String subject = "Your favourite accounts list has been updated";
		if(customer.isPresent())
		{
			String email = customer.get().getEmail();
			mailWithOTPService.sendEmail(email, subject, body);
		}
		return resDto;
	}
	else
	{
		throw new EnterValidCredentials("Please Enter Valid Name and Account Number");
	}
	
	}
	
	
}
