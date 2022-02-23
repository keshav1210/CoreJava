package org.study.cust;

import org.study.db.AccountType;

public class Savings extends Account{
    
    public Savings(int accountNumber, double initialDeposit){
        super(accountNumber);
        this.setBalance(initialDeposit);
    }
   
    @Override
    public AccountType getAccountType() {
        return AccountType.saving;
    }
}
