package com.andynator.accountservice.web;

import com.andynator.accountservice.clients.CustomerRestClient;
import com.andynator.accountservice.entities.BankAccount;
import com.andynator.accountservice.models.Customer;
import com.andynator.accountservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankAccountRestController {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;

    public BankAccountRestController(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }
    @GetMapping("/accounts")
    public List<BankAccount> bankAccountList() {
        List<BankAccount> bankAccountList = bankAccountRepository.findAll();
        bankAccountList.forEach(bal->{
           bal.setCustomer(customerRestClient.findCustomerById(bal.getCustomerId()));
        });
        return bankAccountList;
    }
    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id) {
        BankAccount bankAccount = bankAccountRepository.findById(id).get();
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
