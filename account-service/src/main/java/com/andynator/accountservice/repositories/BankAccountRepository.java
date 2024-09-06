package com.andynator.accountservice.repositories;

import com.andynator.accountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

 public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}
