package com.app.bank.service;

import java.util.Collection;

import com.app.bank.dao.BankAccountCollection;
import com.app.bank.pojo.CurrentAccount;
import com.app.bank.pojo.SavingsAccount;

public class BankAccountService {

	private BankAccountCollection dao;
	
	public void addSavingsAccount(SavingsAccount savingAccount) {
		dao.addSavingsAccount(savingAccount);
	}
	
	public void addCurrentAccount(CurrentAccount currentAccount) {
		dao.addCurrentAccount(currentAccount);
	}
	public Collection<SavingsAccount> viewAllSavings(){
		return dao.viewAllSavings();
	}
	public Collection<CurrentAccount> viewAllCurrent(){
		return dao.viewAllCurrent();
	}
	
}
