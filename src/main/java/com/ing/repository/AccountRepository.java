package com.ing.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ing.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
	@Query("select c from Account c where c.customerId=:customerId and c.accountStatus=:status")
	List<Account> findByAccountStatus(String customerId, String status);

	@Query("select c from Account c where c.customerId=:customerId and c.accountStatus=:status order by c.accountName desc")
	List<Account> findByAccountStatus(Pageable pageable, String customerId, String status);

	@Modifying
	@Transactional
	@Query("update Account c set c.accountStatus=:status where c.accountNumber=:accountNumber and c.customerId=:customerId")
	void update(String accountNumber, String customerId, String status);

}
