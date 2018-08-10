package com.app.bank.pojo;

public class SavingsAccount extends BankAccount {
	private boolean salary;
	
	

	public SavingsAccount(Customer accountHolder, double accountBalance,boolean salary) {
		super(accountHolder, accountBalance);
		this.salary=salary;
		// TODO Auto-generated constructor stub
	}
	public boolean isSalary() {
		return salary;
	}
	public void setSalary(boolean salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "SavingsAccount [salary=" + salary + ", toString()=" + super.toString() + "]";
	}
}