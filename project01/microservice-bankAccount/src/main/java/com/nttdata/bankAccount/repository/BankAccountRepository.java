package com.nttdata.bankAccount.repository;

import com.nttdata.bankAccount.entity.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {

    BankAccount findByAccountNumber(String accountNumber);

}
