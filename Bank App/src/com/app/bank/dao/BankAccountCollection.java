package com.app.bank.dao;

import java.util.Collection;
import java.util.HashMap;

import java.util.Map;

import com.app.bank.pojo.CurrentAccount;
import com.app.bank.pojo.SavingsAccount;

public abstract class BankAccountCollection {
	private Map<Integer,SavingsAccount> savingAccount=new HashMap<>();
	private Map<Integer,CurrentAccount> currentAccount=new HashMap<>();
	
	public void addSavingsAccount(SavingsAccount savingAccount) {
		this.savingAccount.put(savingAccount.getAccountNumber(),savingAccount);
	}
	public void addCurrentAccount(CurrentAccount currentAccount) {
		this.currentAccount.put(currentAccount.getAccountNumber(),currentAccount);
	}

	public Collection<SavingsAccount> viewAllSavings(){
		return savingAccount.values();
	}
	public Collection<CurrentAccount> viewAllCurrent(){
		return currentAccount.values();
	}
}
