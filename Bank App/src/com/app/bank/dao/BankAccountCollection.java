package com.app.bank.dao;


import java.util.Collection;
import java.util.HashMap;

import java.util.Map;

import com.app.bank.pojo.CurrentAccount;
import com.app.bank.pojo.Customer;
import com.app.bank.pojo.SavingsAccount;

public class BankAccountCollection {
	
	public BankAccountCollection(){};
	
	private Map<Integer,SavingsAccount> savingAccount=new HashMap<>();
	private Map<Integer,CurrentAccount> currentAccount=new HashMap<>();
	
	public void allAccounts()
	{
		SavingsAccount account1 = new SavingsAccount(new Customer("Raj","987654232","qwerty@gmail.com","10/12/1990"), 100200, true);
		SavingsAccount account2 = new SavingsAccount(new Customer("Ram","987654231","fwerty@gmail.com","2/12/1990"), 500200, false);
		SavingsAccount account3 = new SavingsAccount(new Customer("Rajan","987654233","bwerty@gmail.com","1/1/1990"), 900000, true);
	    SavingsAccount account4 = new SavingsAccount(new Customer("Raman","987654238","mwerty@gmail.com","2/2/1990"), 440000, false);
		
		this.savingAccount.put(account1.getAccountNumber(),account1);
		this.savingAccount.put(account2.getAccountNumber(),account2);	
		this.savingAccount.put(account3.getAccountNumber(),account3);
		this.savingAccount.put(account4.getAccountNumber(),account4);
	
        CurrentAccount account5=new CurrentAccount(new Customer("Sandy","9383782909","acdazc@gmail.com","09/07/1995"),362265,15000);
        CurrentAccount account6=new CurrentAccount(new Customer("Mandy","9383782209","aczc@gmail.com","09/07/1998"),363465,10000);
        CurrentAccount account7=new CurrentAccount(new Customer("Brandy","9383785909","cdaz@gmail.com","09/05/1991"),31265,15000);
        CurrentAccount account8=new CurrentAccount(new Customer("Candy","9383782899","acdtyc@gmail.com","09/03/1992"),369065,10000);
        
        this.currentAccount.put(account5.getAccountNumber(), account5);
        this.currentAccount.put(account6.getAccountNumber(), account6);
        this.currentAccount.put(account7.getAccountNumber(), account7);
        this.currentAccount.put(account8.getAccountNumber(), account8);
	}
	
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
	public double depositMoney(int accountNumber, double amount) {
		
		Integer i=accountNumber;
	    if(savingAccount.get(i)!=null)
	    {
	    	savingAccount.get(i).setAccountBalance(savingAccount.get(i).getAccountBalance()+amount);
	    	return savingAccount.get(i).getAccountBalance();
	    }
	    else if(currentAccount.get(i)!=null)
	    {
	    	currentAccount.get(i).setAccountBalance(savingAccount.get(i).getAccountBalance()+amount);
	        return currentAccount.get(i).getAccountBalance();
	    }
	    else
	    	return -1;
	}
	public double withdrawMoney(int accountNumber, double amount) {
		
		Integer i=accountNumber;
	    if(savingAccount.get(i)!=null)
	    {
	    	savingAccount.get(i).setAccountBalance(savingAccount.get(i).getAccountBalance()-amount);
	    	return savingAccount.get(i).getAccountBalance();
	    }
	    else if(currentAccount.get(i)!=null)
	    {
	    	currentAccount.get(i).setAccountBalance(savingAccount.get(i).getAccountBalance()-amount);
	        return currentAccount.get(i).getAccountBalance();
	    }
	    else
	    {
	    	return -1;
	    }
	}
	/*public void transferMoney(int accountNumber, int accountNumber2, double amount) {
		
		Integer i=accountNumber;
		Integer j=accountNumber2;
		 if(savingAccount.get(i)!=null)
		    {
		    	savingAccount.get(i).setAccountBalance(savingAccount.get(i).getAccountBalance()-amount);
		    }
		    else
		    {
		    	currentAccount.get(i).setAccountBalance(savingAccount.get(i).getAccountBalance()-amount);
		    }
		 if(savingAccount.get(j)!=null)
		    {
		    	savingAccount.get(i).setAccountBalance(savingAccount.get(i).getAccountBalance()+amount);
		    }
		    else
		    {
		    	currentAccount.get(i).setAccountBalance(savingAccount.get(i).getAccountBalance()+amount);
		    }
		return;
	}*/
	
	
	
}
