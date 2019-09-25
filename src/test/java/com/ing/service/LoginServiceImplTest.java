package com.ing.service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ing.dto.LoginReqDto;
import com.ing.dto.LoginResDto;
import com.ing.entity.Customer;
import com.ing.exception.EnterValidCredentials;
import com.ing.repository.CustomerRepository;
@RunWith(SpringJUnit4ClassRunner.class)
public class LoginServiceImplTest {

	@InjectMocks
	LoginServiceImpl loginService; 
	
	@Mock
	CustomerRepository customerRepository;
	
	@Test
	public void loginTest() {
		LoginReqDto dto=new LoginReqDto();
		dto.setCustomerId("ING2156");
		LoginResDto res=new LoginResDto();
		res.setCustomerName("pradeep");
		res.setMessage("login successfull");
		res.setStatusCode(HttpStatus.OK.value());
		Customer customer=new Customer();
		customer.setCustomerId(dto.getCustomerId());
		Mockito.when(customerRepository.findByCustomerId(dto.getCustomerId())).thenReturn(Optional.of(customer));
		LoginResDto actResult=loginService.login(dto);
		assertEquals(res.getStatusCode(), actResult.getStatusCode());
	}
	
	@Test(expected = EnterValidCredentials.class)
	public void invalidCredentailFoundExceptionTest() {
		LoginReqDto dto=new LoginReqDto();
		dto.setCustomerId("ING2156");
		loginService.login(dto);
	}

}
