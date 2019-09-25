package com.ing.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ing.dto.LoginReqDto;
import com.ing.dto.LoginResDto;
import com.ing.entity.Customer;
import com.ing.exception.EnterValidCredentials;
import com.ing.repository.CustomerRepository;

/**
 * 
 * @author Pradeep
 * @param LoginReqDto
 * @return LoginResDto
 * @exception EnterValidCredentials
 * method is to validate the user through customerId
 */
@Service
public class LoginServiceImpl implements LoginService {

	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public LoginResDto login(LoginReqDto loginDto) {
		Optional<Customer> customer=customerRepository.findByCustomerId(loginDto.getCustomerId());
		if(customer.isPresent())
		{
			
			Customer cust=customer.get();
			LoginResDto resDto=new LoginResDto();
			logger.info(" inside customer present {}",cust.getCustomerName());
			resDto.setCustomerName(cust.getCustomerName());
			resDto.setMessage("Login Successfull");
			resDto.setStatus("SUCCESS");
			resDto.setStatusCode(HttpStatus.OK.value());
			return resDto;
			
		}
		else {
			throw new EnterValidCredentials("Please Enter Valid Credentials");
		}
		
	}
}
