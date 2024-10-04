package com.nttdata.bankAccount.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Data
@Entity
@Builder
@Table(name = "bank_account")
@AllArgsConstructor
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "account_number")
    private String accountNumber;

    private Double balance;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "client_id")
    private Long clientId;

    public BankAccount(){
        this.balance = 0.0;
        this.accountNumber = generateAccountNumber();
    }

    private String generateAccountNumber(){
        Random random = new Random();
        return String.valueOf(100000000 + random.nextInt(900000000));
    }

}
