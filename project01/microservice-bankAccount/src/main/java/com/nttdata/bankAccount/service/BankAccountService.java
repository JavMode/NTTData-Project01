package com.nttdata.bankAccount.service;

import com.nttdata.bankAccount.entity.BankAccount;

import java.util.List;

public interface BankAccountService {

    void createBankAccount(BankAccount bankAccount);

    List<BankAccount> getBankAccounts();

    BankAccount getBankAccountById(Long id);

    void deposit(BankAccount bankAccount, String accountNumber);

    BankAccount withdraw(BankAccount bankAccount, String accountNumber);

    void deleteBankAccountById(Long id);

}
