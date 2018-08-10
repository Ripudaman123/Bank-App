package com.app.bank.pojo;


public abstract class BankAccount {

	private final int accountNumber;
	private Customer accountHolder;
	private double accountBalance;
	
	//maintains the next accountNumber
	private static int accountId;
	
	//gets invoked whenever a class is loaded
	static {
		accountId = 9810;
	}

	{
		this.accountNumber = ++accountId;
	}

	public BankAccount( Customer accountHolder, double accountBalance) {
		this.accountHolder = accountHolder;
		this.accountBalance = accountBalance;
	}

	public Customer getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(Customer accountHolder) {
		this.accountHolder = accountHolder;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public static int getAccountId() {
		return accountId;
	}

	public static void setAccountId(int accountId) {
		BankAccount.accountId = accountId;
	}

	public int getAccountNumber() {
		return accountNumber;
	}
	
	
}
