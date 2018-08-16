package com.app.bank.service;

import java.util.Collection;

import com.app.bank.dao.BankAccountCollection;
import com.app.bank.pojo.CurrentAccount;
import com.app.bank.pojo.SavingsAccount;

public class BankAccountService {

	private BankAccountCollection dao = new BankAccountCollection() ;
	
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

	public double depositMoney(int accountNumber, double amount) {
	    
	   return dao.depositMoney(accountNumber,amount);
	}

	public double withdrawMoney(int accountNumber, double amount) {
		return dao.withdrawMoney(accountNumber, amount);
		
	}
	public void allAccounts() {
		dao.allAccounts();
		
	}

	/*public void transferMoney(int accountNumber, int accountNumber2, double amount) {
		dao.transferMoney(accountNumber, accountNumber2, amount);
		return;
	}*/


}
