package com.nttdata.bankAccount.controller;

import com.nttdata.bankAccount.entity.BankAccount;
import com.nttdata.bankAccount.service.BankAccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bankAccount")
public class BankAccountController {

    @Autowired
    private BankAccountServiceImpl bankAccountService;

    @PostMapping("/cuentas")
    @ResponseStatus(HttpStatus.CREATED)
    public void createBankAccount(@RequestBody BankAccount bankAccount){
        bankAccountService.createBankAccount(bankAccount);
    }

    @GetMapping("/cuentas")
    public ResponseEntity<?> getBankAccounts(){
        return ResponseEntity.ok(bankAccountService.getBankAccounts());
    }

    @GetMapping("/cuentas/{id}")
    public ResponseEntity<?> getBankAccountById(@PathVariable Long id){
        return ResponseEntity.ok(bankAccountService.getBankAccountById(id));
    }

    @PutMapping("/cuentas/{accountNumber}/depositar")
    @ResponseStatus(HttpStatus.OK)
    public void deposit(@RequestBody BankAccount bankAccount, @PathVariable String accountNumber){
        bankAccountService.deposit(bankAccount, accountNumber);
    }

    @PutMapping("/cuentas/{accountNumber}/retirar")
    @ResponseStatus(HttpStatus.OK)
    public void withdraw(@RequestBody BankAccount bankAccount, @PathVariable String accountNumber){
        bankAccountService.withdraw(bankAccount, accountNumber);
    }

    @DeleteMapping("/cuentas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBankAccountById(@PathVariable Long id){
        bankAccountService.deleteBankAccountById(id);
    }

}
