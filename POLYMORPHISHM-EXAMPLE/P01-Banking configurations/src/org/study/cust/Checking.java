package org.study.cust;

import org.study.db.AccountType;

public class Checking extends Account{
    
    public Checking(int accountNumber, double initialDeposit){
        super(accountNumber);
        this.setBalance(initialDeposit);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.checking;
    }
}